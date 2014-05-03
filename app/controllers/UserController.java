package controllers;

import static play.data.Form.form;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import models.Class;
import models.User;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Http.MultipartFormData.FilePart;
import play.mvc.Http.RequestBody;
import play.mvc.Result;
import views.html.createStudent;
import views.html.editRegistration;
import views.html.editStudent;
import views.html.index;
import views.html.login;
import views.html.register;
import views.html.viewStudent;
import formdata.AuthenticationData;
import formdata.RegistrationData;

public class UserController extends Controller {

    public static Result index(String returnUrl) {
    	session("returnUrl", returnUrl);
		return ok(login.render(form(AuthenticationData.class), returnUrl));
	}

	public static Result login() {
		String returnUrl = session("returnUrl");
		if (returnUrl == null) {
			returnUrl = "none";
		}

		Form<AuthenticationData> loginForm = form(AuthenticationData.class)
				.bindFromRequest();
		if (loginForm.hasErrors()) {
			return badRequest(login.render(loginForm, returnUrl));
		} else {
			session().clear();
			User user = User.byUsernameOrEmail(loginForm.get().usernameOrEmail);
			session("userId", user.id.toString());
			session("userFirstName", user.firstName);
			return redirect((returnUrl.equals("none")) ? "/" : returnUrl);
		}
	}

	public static Result createStudent() {
		return ok(createStudent.render(form(RegistrationData.class), "Student"));
	}

	public static Result createStudent_submit() {

		Form<RegistrationData> createUserForm = form(RegistrationData.class)
				.bindFromRequest();
		if (createUserForm.hasErrors()) {
			return badRequest(createStudent.render(createUserForm, "Student"));
		} else {
			User newUser = User
					.create(new User(createUserForm.get(), "Student"));

			session().clear();
			session("userId", newUser.id.toString());
			session("userFirstName", newUser.firstName);
			
			return ok(index.render());
		}
	}

	public static Result editStudent(Long userId) {
		User user = User.byId(session("userId"));
		if (user == null) {
			return redirect(routes.UserController.index(request().uri()));
		}

		User student = User.byId(userId);
		if (student == null) {
			return redirect("http://thebest404pageever.com/"); // TODO: Redirect
																// to generic
																// error page
		}

		RegistrationData data = new RegistrationData(student.email,
				student.username, student.password, student.password,
				student.firstName, student.lastName, 0, userId,
				1);
		Form<RegistrationData> form = Form.form(RegistrationData.class);
		form = form.fill(data);
		return ok(editStudent.render(form, userId));
	}

	public static Result editStudent_submit(Long userId) {
		User user = User.byId(session("userId"));
		if (user == null) {
			return redirect(routes.UserController.index(request().uri()));
		}

		Form<RegistrationData> editStudentForm = form(RegistrationData.class)
				.bindFromRequest();
		if (editStudentForm.hasErrors()) {
			return badRequest(editStudent.render(editStudentForm, userId));
		} else {
			User student = User.byId(userId);
			if (student == null) {
				return redirect("http://thebest404pageever.com/"); // TODO:
																	// Redirect
																	// to
																	// generic
																	// error
																	// page
			}

			RegistrationData studentData = editStudentForm.get();
			student.email = studentData.email;
			student.username = studentData.username;
			student.firstName = studentData.firstName;
			student.lastName = studentData.lastName;
			student.grade = studentData.grade;
            student.weight = studentData.weight;
			student.save();

			flash("success", "Modified student details have been saved.");
			return ok(viewStudent.render(Class.allInstrClasses(user, true),
					Class.getStudentClasses(user, student), student));
		}
	}

	public static Result view(Long userId) {
		User user = User.byId(session("userId"));
		if (user == null) {
			return redirect(routes.UserController.index(request().uri()));
		}

		User student = User.byId(userId);
		if (student == null) {
			return redirect("http://thebest404pageever.com/"); // TODO: Redirect
																// to generic
																// error page
		}

		return ok(viewStudent.render(Class.allInstrClasses(user, true),
				Class.getStudentClasses(user, student), student));
	}

	public static Result createInstructor() {
		return ok(register.render(form(RegistrationData.class), "Instructor"));
	}

	public static Result createInstructor_submit() {
		Form<RegistrationData> createUserForm = form(RegistrationData.class)
				.bindFromRequest();
		if (createUserForm.hasErrors()) {
			return badRequest(register.render(createUserForm, "Instructor"));
		} else {
			User newUser = new User(createUserForm.get(), "Instructor");

			RequestBody body = request().body();
			Http.MultipartFormData data = body.asMultipartFormData();
			FilePart picture = data.getFile("picture");
			if (picture == null) {
				flash("error",
						"No user image specified! Please provide one, then try again.");
				return badRequest(register.render(createUserForm, "Instructor"));
			}

			String fileName = picture.getFilename();
			String contentType = picture.getContentType();

			if (!contentType.equals("image/jpeg")
					&& !contentType.equals("image/jpg")
					&& !contentType.equals("image/pjpeg")
					&& !contentType.equals("image/x-png")
					&& !contentType.equals("image/png")) {
				flash("error", "Uploaded file is of wrong type (" + contentType
						+ ")");
				return badRequest(register.render(createUserForm, "Instructor"));
			}

			File file = picture.getFile();
			long fileSize = file.length(); // in bytes
			if (fileSize > 512000) {
				flash("error", "Uploaded image is too large (~"
						+ (fileSize / 1000) + "kb)");
				return badRequest(register.render(createUserForm, "Instructor"));
			}

			newUser = User.create(newUser);

			try {
				BufferedImage bufferedImage = ImageIO.read(file);

				File usersFolder = new File("public/images/users/");

				if (!usersFolder.exists()) {
					usersFolder.mkdir();
				}

				File convertedFile = new File("public/images/users",
						newUser.id.toString() + ".png");
				ImageIO.write(bufferedImage, "png", convertedFile);
			} catch (Exception ioe) {
				newUser.delete();
				flash("error",
						"Unable to save uploaded image due to an internal server error. Please try again!");
				return badRequest(register.render(createUserForm, "Instructor"));
			}

			flash("success", "Please log in using your credentials.");
			return redirect(routes.UserController.index("none"));
		}
	}

	public static Result editInstructor() {
		User user = User.byId(session("userId"));
		if (user == null) {
			return redirect(routes.UserController.index(request().uri()));
		}

		RegistrationData data = new RegistrationData(user.email, user.username,
				user.password, user.password, user.firstName, user.lastName,
				user.grade, user.id, user.weight);
		Form<RegistrationData> form = Form.form(RegistrationData.class);
		form = form.fill(data);
		return ok(editRegistration.render(form));
	}

	public static Result editInstructor_submit() {
		User user = User.byId(session("userId"));
		if (user == null) {
			return redirect(routes.UserController.index(request().uri()));
		}

		Form<RegistrationData> editUserForm = form(RegistrationData.class)
				.bindFromRequest();
		if (editUserForm.hasErrors()) {
			return badRequest(editRegistration.render(editUserForm));
		} else {
			RequestBody body = request().body();
			Http.MultipartFormData data = body.asMultipartFormData();
			FilePart picture = data.getFile("picture");
			if (picture != null) {
				String fileName = picture.getFilename();
				String contentType = picture.getContentType();

				if (!contentType.equals("image/jpeg")
						&& !contentType.equals("image/jpg")
						&& !contentType.equals("image/pjpeg")
						&& !contentType.equals("image/x-png")
						&& !contentType.equals("image/png")) {
					flash("error", "Uploaded file is of wrong type ("
							+ contentType + ")");
					return badRequest(editRegistration.render(editUserForm));
				}

				File file = picture.getFile();
				long fileSize = file.length(); // in bytes
				if (fileSize > 512000) {
					flash("error", "Uploaded image is too large (~"
							+ (fileSize / 1000) + "kb)");
					return badRequest(editRegistration.render(editUserForm));
				}

				try {
					BufferedImage bufferedImage = ImageIO.read(file);

					File usersFolder = new File("public/images/users/");

					if (!usersFolder.exists()) {
						usersFolder.mkdir();
					}

					File convertedFile = new File("public/images/users",
							user.id.toString() + ".png");
					ImageIO.write(bufferedImage, "png", convertedFile);
				} catch (Exception ioe) {
					flash("error",
							"Unable to save uploaded image due to an internal server error. Please try again!");
					return badRequest(editRegistration.render(editUserForm));
				}
			}

			RegistrationData instrData = editUserForm.get();
			user.username = instrData.username;
			user.password = instrData.password;
			user.email = instrData.email;
			user.firstName = instrData.firstName;
			user.lastName = instrData.lastName;
			user.save();

			flash("success", "Modified registration details have been saved.");
			return ok(index.render()); // TODO: Perhaps redirect to some kind of
										// private profile where instructors can
										// just view their registration details,
										// not edit them? (like we already have
										// for classes)
		}
	}

	public static Result logout() {
		session().clear();
		return redirect(routes.UserController.index("none"));
	}

}