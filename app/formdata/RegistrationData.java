package formdata;

import models.User;

public class RegistrationData {

    public String username;
	public String password;
	public String passwordRepeat;
	public String email;
	public String firstName;
	public String lastName;
	public int grade;
	public int weight;
	public Long userId; // ID of user who is exception to email/username
						// validation

	public RegistrationData() {
	}

	public RegistrationData(String email, String username, String password,
			String passwordRepeat, String firstName, String lastName,
			int grade, Long userId, int weight) {
		this.email = email;
		this.username = username;
		this.password = password;
		this.passwordRepeat = passwordRepeat;
		this.firstName = firstName;
		this.lastName = lastName;
		this.grade = grade;
		this.userId = userId;
		this.weight = weight;
	}

	public String validate() {
		User userByUsername = User.byUsername(username);
		if ((userByUsername != null) && (userByUsername.id != userId)) {
			return "The username you specified is already in use! Please choose another and try again.";
		}

		User userByEmail = User.byEmail(email);
		if ((userByEmail != null) && (userByEmail.id != userId)) {
			return "The email you specified is already in use! Please choose another and try again.";
		}

		if (firstName.length() <= 0) {
			return "Please provide a first name!";
		}

		if (lastName.length() <= 0) {
			return "Please provide a last name!";
		}

		if (email.length() <= 0) {
			return "Please provide an email address!";
		}

		// TODO: Email address validation

		if (username.length() <= 0) {
			return "Please provide a desired username!";
		}

		if (password.length() <= 0) {
			return "Please provide a password!";
		}

		if (!passwordRepeat.equals(password)) {
			return "The passwords you entered do not match! Please try again.";
		}
        
        

		return null;
	}

}
