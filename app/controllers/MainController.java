package controllers;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.io.FileUtils;

import models.User;
import play.Routes;
import play.libs.F.Promise;
import play.mvc.Action;
import play.mvc.Controller;
import play.mvc.Http.Context;
import play.mvc.Http.MultipartFormData;
import play.mvc.Http.RequestBody;
import play.mvc.Http.MultipartFormData.FilePart;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.SimpleResult;
import play.mvc.With;
import views.html.*;

public class MainController extends Controller {

	public static Result index() {
		User user = User.byId(session("userId"));
		if (user == null) {
			return redirect(routes.UserController.index(request().uri()));
		}

		return ok(index.render());
	}

	public static Result javascriptRoutes() {
		response().setContentType("text/javascript");
		return ok(
				Routes.javascriptRouter("jsRoutes",
						routes.javascript.ClassController.delete(),
						routes.javascript.ClassController.deploy(),
						routes.javascript.ClassController.enroll(),
						routes.javascript.ClassController.unenroll()
						)
				);
	}

}
