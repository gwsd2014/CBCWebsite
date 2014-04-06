package controllers;

import generator.Control;
import generator.ProblemType;
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

		// default
		int correct = -1;

		if (group1.equalsIgnoreCase("0")) {
			// incorrect
			// decrease grade

			correct = 0;

		} else if (group1.equalsIgnoreCase("1")) {
			// correct
			// increase grade

			correct = 1;

		} else if (!group1.equalsIgnoreCase("fromMain")) {
			/*
			 * // not an answer if (user.grade > 0 || user.weight > 1) { correct
			 * = -2; }
			 */
			correct = Control.evaluateAnswer(group1, user.username);

		}

		if (correct == 1) {
			adjustDifficulty(user, true);
		} else if (correct == 0) {
			adjustDifficulty(user, false);
		}

		int level = user.grade;
		int weight = getEffectiveWeight(level, user.weight);
		ProblemType pt = getProblemType(level, user.weight);
		Question question = Gen.createProblem(level, weight, pt, user.username);

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
		if (pt == ProblemType.FILL_BLANK) {
			spot = -1;
		}
		return ok(viewCode.render(question.lines, question.spaces,
				modifiedAnswers, spot, correct));
	}

	public static ProblemType getProblemType(int level, int weight) {
		if (level == 2 && weight > 9) {
			return ProblemType.FILL_BLANK;
		}
		return ProblemType.MULTI_CHOICE;
	}

	public static int getEffectiveWeight(int level, int realWeight) {
		// use 3 for simple variable problems
		if (level < 2) {
			if (realWeight > 9) {
				return 3;
			}
		}

		if (level == 2 && realWeight > 9) {
			return 1;
		}

		// make lvl 4 min = 2
		if (level == 4) {
			if (realWeight / 3 < 2) {
				return 2;
			}
		}

		if (level > 4) {
			return realWeight / 2;
		}

		return realWeight / 3;
	}

	public static void adjustDifficulty(User user, boolean correct) {
		int[] gradeChange = { 12, 9, 12, 21, 21, 20, 21, 10 };

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
		} else { // incorrect answer
			if (user.weight > 1) {
				User.changeWeight(user, user.weight - 1);
			}
		}
	}
}
