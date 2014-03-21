package formdata;

import models.User;

public class AuthenticationData {

	public String usernameOrEmail;
	public String password;

	public String validate() {
		User user = User.byLogin(usernameOrEmail, password);
		if (user == null) {
			return "Invalid username/email and/or password! Please try again.";
		}
    
        /*
		if (user.type != User.UserType.INSTRUCTOR) {
			return "Invalid username/email and/or password! Please try again.";
		}
		*/
		return null;
	}

}
