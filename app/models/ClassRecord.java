package models;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

import com.avaje.ebean.annotation.CreatedTimestamp;
import com.avaje.ebean.annotation.UpdatedTimestamp;

@Entity
public class ClassRecord extends Model {

    private static final long serialVersionUID = 1L;

	// Fields
	@Id
	public Long id;

	@Required
	public boolean cleared;

	@CreatedTimestamp
	public Timestamp createdTime;

	@UpdatedTimestamp
	public Timestamp updatedTime;

	@Required
	public boolean disavowed = false;

	@ManyToOne
	public User user;

	@ManyToOne
	public Class course;

	// Constructors
	public ClassRecord(User user, Class course, boolean cleared) {
		this.user = user;
		this.course = course;
		this.cleared = cleared;
	}

	// Getters / Setters
	public static Finder<Long, ClassRecord> find = new Finder<Long, ClassRecord>(
			Long.class, ClassRecord.class);

	public static List<ClassRecord> all() {
		return find.where().ne("disavowed", true).findList();
	}

	public static ClassRecord create(ClassRecord classRecord) {
		classRecord.save();
		return classRecord;
	}

	public static void delete(Long id) {
		// find.ref(id).delete();
		ClassRecord classRecord = find.ref(id);
		classRecord.disavowed = true;
		classRecord.save();
	}

	public static ClassRecord byId(Long id) {
		return find.where().ne("disavowed", true).eq("id", id).findUnique();
	}

	public static ClassRecord byData(User user, Class classs) {
		return find.where().ne("disavowed", true).eq("user_id", user.id)
				.eq("course_id", classs.id).findUnique();
	}

}
