package generator;

/**
 * This class determines the appropriate difficulty level for the user.
 * 
 */

public class Difficulty {

	private int level;
	private ProblemType type;
	private int weight;

	/**
	 * This function determines if the difficulty level of the user should
	 * change, based on his completion history
	 * 
	 * @return difficulty
	 */
	public void adjustDifficulty(boolean correct) {
		// level zero
		if (level == 0) {
			if (correct) {
				weight += 1;
			} else if (weight > 1) {
				weight -= 1;
			}

			// check to see if need to level up
			if (weight > 5) {
				weight = 1;
				level = 1;
			}
		} else if (level == 1) {
			if (correct) {
				weight += 1;
			} else if (weight > 1) {
				weight -= 1;
			}

			if (weight > 4) {
				weight = 1;
				level = 2;
			}

		} else if (level == 2) {
			if (correct) {
				weight += 1;
			} else if (weight > 1) {
				weight -= 1;
			}

			// increase at 4
			if (weight == 4) {
				level = 3;
				weight = 1;
			}
		} else if (level == 3) {
			if (correct) {
				weight += 1;
			} else if (weight > 1) {
				weight -= 1;
			}

			// increase at 4
			if (weight == 4) {
				level = 4;
				weight = 1;
			}
		} else if (level == 4) {
			if (correct) {
				weight += 1;
			} else if (weight > 1) {
				weight -= 1;
			}

			// increase at 4
			if (weight > 3) {
				level = 5;
				weight = 1;
			}

		} else if (level == 5) {
			if (correct) {
				weight += 1;
			} else if (weight > 1) {
				weight -= 1;
			}

			// increase at 10
			if (weight > 9) {
				weight = 1;
				level = 6;
			}
		} else if (level == 6) {
			if (correct) {
				weight += 1;
			} else if (weight > 1) {
				weight -= 1;
			}

			// increase at 7
			if (weight > 6) {
				weight = 1;
				level = 7;
			}
		} else if (level == 7) {
			if (correct) {
				weight += 1;
			} else if (weight > 1) {
				weight -= 1;
			}

			// cap at 4
			if (weight > 4) {
				weight = 4;
			}
		}

	}

	public Difficulty() {
		this(0, ProblemType.MULTI_CHOICE, 1);
	}

	public Difficulty(int setLevel, ProblemType setType, int setWeight){
		level = setLevel;
		type = setType;
		weight = setWeight;
	}
	
	public ComponentTypes getProblemComponent() {
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

	public int getLevel() {
		return level;
	}

	public ProblemType getProblemType() {
		return type;
	}

	public int getWeight() {
		return weight;
	}
}
