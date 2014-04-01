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

		//default 
		int correct = -1;
		
		
		if (group1.equalsIgnoreCase("0")) {
			// incorrect
			// decrease grade
			adjustDifficulty(user, false);
			correct = 0;

		} else if (group1.equalsIgnoreCase("1")) {
			// correct
			// increase grade
			adjustDifficulty(user, true);
			correct = 1;

		} else {
			// not an answer
			if(user.grade > 0 || user.weight > 1){
				correct = -2;
			}
		}

		int level = user.grade;
		int weight = getEffectiveWeight(level, user.weight);

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
				modifiedAnswers, spot, correct));
	}
    
    public static int getEffectiveWeight(int level, int realWeight){
    	//use 3 for simple variable problems
    	if(level < 2){
    		if (realWeight > 9){
    			return 3;
    		}
    	}
    	
    	//make lvl 4 min = 2
    	if(level == 4){
    		if(realWeight/3 < 2){
    			return 2;
    		}
    	}
    	
    	if(level > 4){
    		return realWeight/2;
    	}
    	
    	return realWeight/3;
    }

	public static void adjustDifficulty(User user, boolean correct) {
		int[] gradeChange = { 12, 9, 9, 21, 21, 20, 21, 10 };

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
		} else{ //incorrect answer
            if(user.weight > 1 ){
                User.changeWeight(user, user.weight - 1);
            }
        }
	}
}
