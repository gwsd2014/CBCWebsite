package controllers;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;

import formdata.ClassData;
import models.User;
import play.data.*;
import static play.data.Form.*;
import play.mvc.*;
import play.mvc.Http.RequestBody;
import play.mvc.Http.MultipartFormData.FilePart;
import views.html.*;
import models.Class;

public class ClassController extends Controller {

	public static Result create() {
		User user = User.byId(session("userId"));
		if (user == null) {
			return redirect(routes.UserController.index(request().uri()));
		}

		return ok(createClass.render(form(ClassData.class)));
	}

	public static Result create_submit() {
		User user = User.byId(session("userId"));
		if (user == null) {
			return redirect(routes.UserController.index(request().uri()));
		}
		
		Form<ClassData> createClassForm = form(ClassData.class).bindFromRequest();
		if (createClassForm.hasErrors()) {
			return badRequest(createClass.render(createClassForm));
		} else {
			Class newClass = new Class(createClassForm.get(), User.byId(session("userId")));
			
			RequestBody body = request().body();
			Http.MultipartFormData data = body.asMultipartFormData();
			FilePart picture = data.getFile("picture");
			if (picture == null) {
				flash("error", "No class image specified! Please provide one, then try again.");
				return badRequest(createClass.render(createClassForm));
			}
			
			String fileName = picture.getFilename();
			String contentType = picture.getContentType();
			
			if (!contentType.equals("image/jpeg") &&
				!contentType.equals("image/jpg") &&
				!contentType.equals("image/pjpeg") &&
				!contentType.equals("image/x-png") &&
				!contentType.equals("image/png")) {
				flash("error", "Uploaded file is of wrong type (" + contentType + ")");
				return badRequest(createClass.render(createClassForm));
			}
			
			File file = picture.getFile();
			long fileSize = file.length();	// in bytes
			if (fileSize > 512000) {
				flash("error", "Uploaded image is too large (~" + (fileSize / 1000) + "kb)");
				return badRequest(createClass.render(createClassForm));
			}
			
			newClass = Class.create(newClass);
			
	        try {
	        	BufferedImage bufferedImage = ImageIO.read(file);
	        	
	        	File classesFolder = new File("public/images/classes/");
	        	
				if (!classesFolder.exists()) {
					classesFolder.mkdir(); 
				}
	        	
	            File convertedFile = new File("public/images/classes", newClass.id.toString() + ".png");
	            ImageIO.write(bufferedImage, "png", convertedFile);
	        } catch (Exception ioe) {
	        	newClass.delete();
	        	flash("error", "Unable to save uploaded image due to an internal server error. Please try again!");
	        	return badRequest(createClass.render(createClassForm));
	        }
			
			flash("success", "Class created.");
			return ok(viewClass.render(newClass));
		}
	}
	
	public static Result edit(Long classId) {
		User user = User.byId(session("userId"));
		if (user == null) {
			return redirect(routes.UserController.index(request().uri()));
		}
		
		Class classs = Class.byId(classId);
		if (classs == null) {
			return redirect("http://thebest404pageever.com/");	// TODO: Redirect to generic error page
		}
		
		ClassData data = new ClassData(classs.name, classs.description, String.valueOf(classs.gradeLow), String.valueOf(classs.gradeHigh));
		Form<ClassData> form = Form.form(ClassData.class);
		form = form.fill(data);
		return ok(editClass.render(form, classId));
	}
	
	public static Result edit_submit(Long classId) {
		User user = User.byId(session("userId"));
		if (user == null) {
			return redirect(routes.UserController.index(request().uri()));
		}
		
		Form<ClassData> editClassForm = form(ClassData.class).bindFromRequest();
		if (editClassForm.hasErrors()) {
			return badRequest(editClass.render(editClassForm, classId));
		} else {
			Class classs = Class.byId(classId);
			if (classs == null) {
				return redirect("http://thebest404pageever.com/");	// TODO: Redirect to generic error page
			}
			
			RequestBody body = request().body();
			Http.MultipartFormData data = body.asMultipartFormData();
			FilePart picture = data.getFile("picture");
			if (picture != null) {
				String fileName = picture.getFilename();
				String contentType = picture.getContentType();
				
				if (!contentType.equals("image/jpeg") &&
					!contentType.equals("image/jpg") &&
					!contentType.equals("image/pjpeg") &&
					!contentType.equals("image/x-png") &&
					!contentType.equals("image/png")) {
					flash("error", "Uploaded file is of wrong type (" + contentType + ")");
					return badRequest(editClass.render(editClassForm, classId));
				}
				
				File file = picture.getFile();
				long fileSize = file.length();	// in bytes
				if (fileSize > 512000) {
					flash("error", "Uploaded image is too large (~" + (fileSize / 1000) + "kb)");
					return badRequest(editClass.render(editClassForm, classId));
				}
				
		        try {
		        	BufferedImage bufferedImage = ImageIO.read(file);
		        	
		        	File classesFolder = new File("public/images/classes/");
		        	
					if (!classesFolder.exists()) {
						classesFolder.mkdir(); 
					}
		        	
		            File convertedFile = new File("public/images/classes", classs.id.toString() + ".png");
		            ImageIO.write(bufferedImage, "png", convertedFile);
		        } catch (Exception ioe) {
		        	flash("error", "Unable to save uploaded image due to an internal server error. Please try again!");
		        	return badRequest(editClass.render(editClassForm, classId));
		        }
			}
			
			ClassData classData = editClassForm.get();
			classs.name = classData.name;
			classs.description = classData.description;
			classs.gradeLow = Integer.parseInt(classData.gradeLow);
			classs.gradeHigh = Integer.parseInt(classData.gradeHigh);
			classs.save();
			
			flash("success", "Modified class details have been saved.");
			return ok(viewClass.render(classs));
		}
	}
	
	public static Result deploy(Long classId) {
		Class classs = Class.byId(classId);
		if (classs == null) {
			return ok("false");
		}
		
		Class.deploy(classId);
        flash("success", "Class '" + classs.name + "' has been deployed.");
        return ok("true");
    }
	
	public static Result delete(Long classId) {
		Class classs = Class.byId(classId);
		if (classs == null) {
			return ok("false");
		}
		
		Class.delete(classId);
        flash("success", "Class '" + classs.name + "' has been deleted.");
        return ok("true");
    }

	/**
	 * Display the paginated list of classes.
	 *
	 * @param page Current page number (starts from 0)
	 * @param sortBy Column to be sorted
	 * @param order Sort order (either asc or desc)
	 * @param filter Filter applied on computer names
	 */
	public static Result browse(int page, String sortBy, String order, String filter) {
		User user = User.byId(session("userId"));
		if (user == null) {
			return redirect(routes.UserController.index(request().uri()));
		}

		return ok(
				browseClasses.render(
						models.Class.getClasses(user, false), models.Class.page(user, page, 10, sortBy, order, filter, true),
						sortBy, order, filter
						)
				);
	}
	
	public static Result view(Long classId) {
		User user = User.byId(session("userId"));
		if (user == null) {
			return redirect(routes.UserController.index(request().uri()));
		}
		
		Class classs = Class.byId(classId);
		if (classs == null) {
			return redirect("http://thebest404pageever.com/");	// TODO: Redirect to generic error page
		}
		
		return ok(viewClass.render(classs));
	}
	
	public static Result enrollStudents(Long classId, boolean restrictByGrade) {
		User user = User.byId(session("userId"));
		if (user == null) {
			return redirect(routes.UserController.index(request().uri()));
		}
		
		Class classs = Class.byId(classId);
		if (classs == null) {
			return redirect("http://thebest404pageever.com/");	// TODO: Redirect to generic error page
		}
		
		if (restrictByGrade) {
			return ok(enrollStudents.render(User.getStudents(classs.gradeLow, classs.gradeHigh), classs, restrictByGrade));
		} else {
			return ok(enrollStudents.render(User.allStudents(), classs, restrictByGrade));
		}
	}
	
	public static Result enroll(Long classId, Long studentId) {
		Class classs = Class.byId(classId);
		if (classs == null) {
			return redirect("http://thebest404pageever.com/");	// TODO: Redirect to generic error page
		}
		
		User student = User.byId(studentId);
		if (student == null) {
			return redirect("http://thebest404pageever.com/");	// TODO: Redirect to generic error page
		}
		
		Class.enroll(classs, student);
        flash("success", "Student '" + classs.name + "' has been enrolled.");
        return redirect(routes.ClassController.enrollStudents(classs.id, true));
	}
	
	public static Result unenroll(Long classId, Long studentId) {
		Class classs = Class.byId(classId);
		if (classs == null) {
			return redirect("http://thebest404pageever.com/");	// TODO: Redirect to generic error page
		}
		
		User student = User.byId(studentId);
		if (student == null) {
			return redirect("http://thebest404pageever.com/");	// TODO: Redirect to generic error page
		}
		
		Class.unenroll(classs, student);
        flash("success", "Student '" + classs.name + "' has been unenrolled.");
        return redirect(routes.ClassController.enrollStudents(classs.id, true));
	}
	
	public static Result classStudents(Long classId) {
		User user = User.byId(session("userId"));
		if (user == null) {
			return redirect(routes.UserController.index(request().uri()));
		}
		
		Class classs = Class.byId(classId);
		if (classs == null) {
			return redirect("http://thebest404pageever.com/");	// TODO: Redirect to generic error page
		}
		
		return ok(classStudents.render(classs));
	}
	
}