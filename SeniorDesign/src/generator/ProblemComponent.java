package generator;

import java.util.LinkedList;
import java.util.Random;

public class ProblemComponent extends Component {

	private String testVariable;
	private int correctAnswer;
	private int incorrectAnswer1;
	private int incorrectAnswer2;
	private int incorrectAnswer3;
	private LinkedList<ClassComponent> childClasses;

	// Constructor
	public ProblemComponent(Difficulty difficulty) {
		childClasses = new LinkedList<ClassComponent>();
		testVariable = chooseVariable();

		createClasses(difficulty);

		setAnswers();
	}

	private void setAnswers() {
		Random rand = new Random();

		// now create the incorrect answers

		incorrectAnswer1 = correctAnswer + 1;

		incorrectAnswer2 = correctAnswer * 2;
		if (incorrectAnswer2 == 0 || incorrectAnswer2 == incorrectAnswer1) {
			incorrectAnswer2 = -1;
		}

		incorrectAnswer3 = (rand.nextInt(100) - 50);
		while (incorrectAnswer3 == correctAnswer
				|| incorrectAnswer3 == incorrectAnswer1
				|| incorrectAnswer3 == incorrectAnswer2) {
			incorrectAnswer3 = (rand.nextInt(100) - 50);
		}
	}

	// create classes
	private void createClasses(Difficulty difficulty) {
		switch (difficulty.getLevel()) {
		case 1:
			ClassComponent firstClass = new ClassComponent("one", difficulty,
					this);
			childClasses.add(firstClass);
			correctAnswer = firstClass.levelOne();
			break;
		case 2:
			ClassComponent secondClass = new ClassComponent("two", difficulty,
					this);
			childClasses.add(secondClass);
			correctAnswer = secondClass.levelTwo();
			break;
		case 3:
			ClassComponent thirdClass = new ClassComponent("three", difficulty,
					this);
			childClasses.add(thirdClass);
			correctAnswer = thirdClass.levelThree();
			break;
		case 4:
			ClassComponent fourthClass = new ClassComponent("four", difficulty,
					this);
			childClasses.add(fourthClass);
			correctAnswer = fourthClass.levelFour();
			break;
		case 5:
			ClassComponent fifthClass = new ClassComponent("five", difficulty,
					this);
			childClasses.add(fifthClass);
			correctAnswer = fifthClass.levelFive();
			break;
		case 6:
			ClassComponent sixthClass = new ClassComponent("six", difficulty, this);
			childClasses.add(sixthClass);
			correctAnswer = sixthClass.levelSix();
			break;
		case 7:
			ClassComponent seventhClass = new ClassComponent("seven", difficulty, this);
			childClasses.add(seventhClass);
			correctAnswer = seventhClass.levelSeven();
		}
	}

	public String getTestVariable() {
		return testVariable;
	}

	public int getCorrectAnswer() {
		return correctAnswer;
	}

	public int getIncorrect1() {
		return incorrectAnswer1;
	}

	public int getIncorrect2() {
		return incorrectAnswer2;
	}

	public int getIncorrect3() {
		return incorrectAnswer3;
	}

	public LinkedList<ClassComponent> getChildren() {
		return childClasses;
	}
}
