package models;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

import com.avaje.ebean.Page;
import com.avaje.ebean.annotation.CreatedTimestamp;
import com.avaje.ebean.annotation.UpdatedTimestamp;

import formdata.ClassData;

@Entity
public class Class extends Model {
    
	private static final long serialVersionUID = 1L;

	// Fields
	@Id
	public Long id;

	@Required
	public String name;

	public String description;
	public int gradeLow;
	public int gradeHigh;
	
	@Required
	public boolean deployed = false;

	@CreatedTimestamp
	public Timestamp createdTime;
	
	@UpdatedTimestamp
	public Timestamp updatedTime;
	
	@Required
	public boolean disavowed = false;
	
	@ManyToOne
	public User instructor;
	
	@ManyToMany
	public Set<User> students = new HashSet<User>();

	// Constructors
	public Class(String name, String description, int gradeLow, int gradeHigh, User instructor) {
		this.name = name;
		this.description = description;
		this.gradeLow = gradeLow;
		this.gradeHigh = gradeHigh;
		this.instructor = instructor;
	}
	public Class(ClassData data, User instructor) {
		this.name = data.name;
		this.description = data.description;
		this.gradeLow = Integer.parseInt(data.gradeLow);
		this.gradeHigh = Integer.parseInt(data.gradeHigh);
		this.instructor = instructor;
	}
	
	// Getters / Setters
	public static Finder<Long, Class> find = new Finder<Long, Class>(Long.class, Class.class);

	public static List<Class> all() {
		return find.where().ne("disavowed", true).findList();
	}
	
	public static List<Class> allInstrClasses(User instr, boolean isDeployed) {
		return find.where()
				.eq("instructor_id", instr.id)
				.ne("disavowed", true)
				.eq("deployed", isDeployed)
				.findList();	
	}
	
	public static Class mostRecent() {
		return find.byId(find.nextId());
	}

	public static Class create(Class classs) {
		classs.save();
		classs.saveManyToManyAssociations("students");
		return classs;
	}
	
	public static void createRecords(Class classs) {
		for (User student : classs.students) {
			// TODO: Decide whether or not disavowed students should still have records (?)
//			if (student.disavowed) {
//				continue;
//			}
			
			createRecords(classs, student);
		}
	}
	
	public static void createRecords(Class classs, User student) {
		ClassRecord classRecord = ClassRecord.byData(student, classs);
		if (classRecord == null) {
			classRecord = new ClassRecord(student, classs, false);
			classRecord.save();
		}
	}
	
	public static void deploy(Long id) {
		Class classs = find.ref(id);
		classs.deployed = true;
		classs.save();
		
		createRecords(classs);
	}
	
	public static void delete(Long id) {
//		find.ref(id).delete();
		Class classs = find.ref(id);
		classs.disavowed = true;
		classs.save();
	}
	
	public static Class byId(Long id) {
		return find.where().ne("disavowed", true).eq("id", id).findUnique();
	}
	
	public static Page<Class> page(User user, int page, int pageSize, String sortBy, String order, String filter, boolean deployed) {
        return 
            find.where()
            	.ne("disavowed", true)
            	.eq("deployed", deployed)
            	.eq("instructor_id", user.id)
                .ilike("name", "%" + filter + "%")
                .orderBy(sortBy + " " + order)
                .findPagingList(pageSize)
                .setFetchAhead(false)
                .getPage(page);
    }
	
	public static List<Class> getClasses(User user, boolean deployed) {
        return 
            find.where()
            	.ne("disavowed", true)
            	.eq("instructor_id", user.id)
            	.eq("deployed", deployed)
            	.findList();
    }
	
	public static List<Class> getStudentClasses(User user, User student) {
        return 
            find.where()
            	.ne("disavowed", true)
            	.eq("students.id", student.id)
            	.eq("instructor_id", user.id)
            	.findList();
    }
	
	public static List<Class> getDeployedClasses(User student) {
        return 
            find.where()
            	.ne("disavowed", true)
            	.eq("deployed", true)
            	.eq("students.id", student.id)
            	.findList();
    }
	
	public static void enroll(Class classs, User student) {
		classs.students.add(student);
		classs.save();
		
		createRecords(classs, student);
	}
	
	public static void unenroll(Class classs, User student) {
		classs.students.remove(student);
		classs.save();
	}
	
	public boolean hasStudent(Long studentId) {
		User student = User.byId(studentId);
		if (student == null) {
			return false;
		}
		
		return students.contains(student);
	}

}