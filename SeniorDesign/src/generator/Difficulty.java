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
		// level one
		if (level == 1) {
			if (correct) {
				weight += 1;
			} else if (weight > 1) {
				weight -= 1;
			}

			// check to see if need to level up
			if (weight > 5) {
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

			// increase at 5
			if (weight > 4) {
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
		level = 1;
		type = ProblemType.MULTI_CHOICE;
		weight = 1;
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
