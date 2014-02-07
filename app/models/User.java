package models;

import java.sql.Timestamp;
import java.util.*;

import play.db.ebean.*;
import play.data.validation.Constraints.*;

import javax.persistence.*;

import com.avaje.ebean.annotation.CreatedTimestamp;
import com.avaje.ebean.annotation.UpdatedTimestamp;

import controllers.UserController;
import formdata.RegistrationData;

@Entity
public class User extends Model {
	
	private static final long serialVersionUID = 2L;
	
	public static enum UserType {
		ADMINISTRATOR,
		INSTRUCTOR,
		STUDENT;
		
		public static UserType getUserType(String userTypeString) {
			UserType userType = null;
			
			switch(userTypeString) {
			case "Administrator":
				userType = ADMINISTRATOR;
				break;
			case "Instructor":
				userType = INSTRUCTOR;
				break;
			case "Student":
				userType = STUDENT;
				break;
			}
			
			return userType;
		}
	}

	// Fields
	@Id
	public Long id;

	@Required
	@Column(unique = true)
    @Email
	public String email;
	
	@Required
	@Column(unique = true)
	public String username;

	@Required
	public String password;

	@Required
	public String firstName;

	@Required
	public String lastName;
	
	@Required
	public int grade;
	
	@Required
	public UserType type;

	@CreatedTimestamp
	public Timestamp createdTime;
	
	@UpdatedTimestamp
	public Timestamp updatedTime;
	
	@Required
	public boolean disavowed = false;
	
	// Constructors
	public User(String email, String username, String password, String firstName, String lastName, UserType type, int grade) {
		this.email = email;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.type = type;
		this.grade = grade;
	}
	
	public User(RegistrationData data, String type) {
		this.email = data.email;
		this.username = data.username;
		this.password = data.password;
		this.firstName = data.firstName;
		this.lastName = data.lastName;
		this.grade = data.grade;
		this.type = UserType.getUserType(type);
	}

	// Getters / Setters
	public static Finder<Long, User> find = new Finder<Long, User>(Long.class, User.class);

	public static List<User> all() {
		return find.where().ne("disavowed", true).findList();
	}

	public static User create(User user) {
		user.save();
		return user;
	}

	public static void delete(Long id) {
//		find.ref(id).delete();
		User user = find.ref(id);
		user.disavowed = true;
		user.save();
	}
	
	public static User byId(Long id) {
		return find.where().ne("disavowed", true).eq("id", id).findUnique();
	}
	
	public static User byId(String idString) {
		if (idString == null) {
			return null;
		}
		
		if (idString.equals("")) {
			return null;
		}
		
		return byId(Long.parseLong(idString));
	}
	
	public static User byEmail(String email) {
		return find.where().ne("disavowed", true).eq("email", email).findUnique();
	}
	
	public static User byUsername(String username) {
		return find.where().ne("disavowed", true).eq("username", username).findUnique();
	}
	
	public static User byUsernameOrEmail(String usernameOrEmail) {
		User user = find.where().ne("disavowed", true).eq("username", usernameOrEmail).findUnique();
		if (user == null) {
			user = find.where().ne("disavowed", true).eq("email", usernameOrEmail).findUnique();
		}
		
		return user;
	}
	
	public static List<User> allStudents() {
		return find.where().ne("disavowed", true).eq("type", UserType.STUDENT).orderBy().asc("lastName").findList();
	}
	
	public static List<User> getStudents(int gradeLow, int gradeHigh) {
		return find.where()
				.ne("disavowed", true)
				.eq("type", UserType.STUDENT)
				.between("grade", gradeLow, gradeHigh)
				.orderBy()
				.asc("lastName").findList();
	}
	
	public static List<User> allInstructors() {
		return find.where().ne("disavowed", true).eq("type", UserType.INSTRUCTOR).orderBy().asc("lastName").findList();
	}

	public static User byLogin(String usernameOrEmail, String password) {
		User user = byUsername(usernameOrEmail);
		if (user == null) {
			user = byEmail(usernameOrEmail);
			if (user == null) {
				return null;
			}
		}
		
		// TODO: Let's actually hash passwords, shall we?
		if (!user.password.equals(password)) {
			return null;
		}

		return user;
	}

}