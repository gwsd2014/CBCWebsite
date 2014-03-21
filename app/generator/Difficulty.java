package generator;

import com.avaje.ebean.Ebean;

import models.User;

/**
 * This class determines the appropriate difficulty level for the user.
 * 
 */

public class Difficulty {

    /**
	 * This function determines if the difficulty level of the user should
	 * change, based on his completion history
	 * 
	 * @return difficulty
	 */
	public static void adjustDifficulty(User user, boolean correct) {
		System.out.println("Input into adjudtDifficulty: Weight = " + user.weight);
		
		// level zero
		if (user.grade == 0) {
			if (correct) {
				user.weight += 1;
			} else if (user.weight > 1) {
				user.weight -= 1;
			}

			// check to see if need to level up
			if (user.weight > 3) {
				user.weight = 1;
				user.grade = 1;
			}
		} else if (user.grade == 1) {
			if (correct) {
				user.weight += 1;
			} else if (user.weight > 1) {
				user.weight -= 1;
			}

			if (user.weight > 4) {
				user.weight = 1;
				user.grade = 2;
			}

		} else if (user.grade == 2) {
			if (correct) {
				user.weight += 1;
			} else if (user.weight > 1) {
				user.weight -= 1;
			}

			// increase at 4
			if (user.weight == 4) {
				user.grade = 3;
				user.weight = 1;
			}
		} else if (user.grade == 3) {
			if (correct) {
				user.weight += 1;
			} else if (user.weight > 1) {
				user.weight -= 1;
			}

			// increase at 7
			if (user.weight == 7) {
				user.grade = 4;
				user.weight = 1;
			}
		} else if (user.grade == 4) {
			if (correct) {
				user.weight += 1;
			} else if (user.weight > 1) {
				user.weight -= 1;
			}

			// increase at 4
			if (user.weight > 3) {
				user.grade = 5;
				user.weight = 1;
			}

		} else if (user.grade == 5) {
			if (correct) {
				user.weight += 1;
			} else if (user.weight > 1) {
				user.weight -= 1;
			}

			// increase at 10
			if (user.weight > 9) {
				user.weight = 1;
				user.grade = 6;
			}
		} else if (user.grade == 6) {
			if (correct) {
				user.weight += 1;
			} else if (user.weight > 1) {
				user.weight -= 1;
			}

			// increase at 7
			if (user.weight > 6) {
				user.weight = 1;
				user.grade = 7;
				//TODO Change Problem Type
				//type = ProblemType.FILL_BLANK;
			}
		} else if (user.grade == 7) {
			if (correct) {
				user.weight += 1;
			} else if (user.weight > 1) {
				user.weight -= 1;
			}

			// cap at 4
			if (user.weight > 4) {
				user.weight = 4;
				//TODO Change Problem Type
				//type = ProblemType.FILL_BLANK;
			}
		}
		System.out.println("Before Saving: Weight = " + user.weight);
		user.save();
		System.out.println("After Saving: Weight = " + user.weight);
	}

	public static ComponentTypes getProblemComponent(ProblemType type, int level) {
		if(type == ProblemType.MULTI_CHOICE){
			return ComponentTypes.None;
		}
		
		switch (level) {
		case 0:
			return ComponentTypes.Line;
		case 1:
			return ComponentTypes.Line;
		case 2:
			return ComponentTypes.Conditional;
		case 3:
			return ComponentTypes.Loop;
		case 4:
			return ComponentTypes.Conditional;
		case 5:
			return ComponentTypes.Function;
		case 6:
			return ComponentTypes.Function;
		case 7:
			return ComponentTypes.Function;
		}
		
		return ComponentTypes.None;
	}

}
