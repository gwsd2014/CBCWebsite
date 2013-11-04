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
		if(correct){
			weight += 1;
		}else if(weight > 1){
			weight -= 1;
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
