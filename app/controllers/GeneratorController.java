package controllers;

import generator.Question;

import java.util.Random;

import models.Gen;
import models.User;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.viewCode;

public class GeneratorController extends Controller {

    public static Result execute(String group1) {

		User user = User.byId(session("userId"));
		if (user == null) {
			return redirect(routes.UserController.index(request().uri()));
		}

		System.out.println(group1);

		if (group1.equalsIgnoreCase("0")) {
			// incorrect
			// decrease grade
			adjustDifficulty(user, false);

		} else if (group1.equalsIgnoreCase("1")) {
			// correct
			// increase grade
			adjustDifficulty(user, true);

		} else {
			// not an answer
		}

		int level = user.grade;
		int weight = user.weight;

		Question question = Gen.createProblem(level, weight);

		// pick spot for the correct answer
		Random rand = new Random();
		Integer spot = rand.nextInt(3);
		Integer[] modifiedAnswers = question.answers;

		// swap the two values, if not 0
		if (spot != 0) {
			Integer temp = modifiedAnswers[0];
			modifiedAnswers[0] = modifiedAnswers[spot];
			modifiedAnswers[spot] = temp;
		}

		return ok(viewCode.render(question.lines, question.spaces,
				modifiedAnswers, spot));
	}

	public static void adjustDifficulty(User user, boolean correct) {
		int[] gradeChange = { 4, 5, 4, 7, 4, 10, 7, 5 };

		if (correct) {
			if (user.weight + 1 == gradeChange[user.grade]) {
				// change to next grade
				// if not highest grade
				if (user.grade != 7) {
					User.changeWeight(user, 1);
					User.changeGrade(user, user.grade + 1);
				} else {
					// do nothing;
				}
			} else {
				// just change weight
				User.changeWeight(user, user.weight + 1);
			}
		} else{
            if(user.weight > 1 ){
                User.changeWeight(user, user.weight - 1);
            }
        }
	}
}
