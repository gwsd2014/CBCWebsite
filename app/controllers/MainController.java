package controllers;

import models.User;
import play.Routes;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

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
