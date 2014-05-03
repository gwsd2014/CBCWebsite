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

	private int weight;
	private int level;
	private ProblemType pt;

	// Constructor
	public ProblemComponent(int level, int weight, ProblemType problemType) {
		this.level = level;
		this.weight = weight;
		this.pt = problemType;

		childClasses = new LinkedList<ClassComponent>();

		testVariable = chooseVariable();

		createClasses();

		setAnswers();
	}

	private void setAnswers() {
		Random rand = new Random();

		// now create the incorrect answers
		do {
			incorrectAnswer1 = correctAnswer + rand.nextInt(6) - 3;
		} while (incorrectAnswer1 == correctAnswer);

		incorrectAnswer2 = correctAnswer * (rand.nextInt(3) + 1);
		while(incorrectAnswer2 == incorrectAnswer1 || incorrectAnswer2 == correctAnswer){
			incorrectAnswer2 = correctAnswer + rand.nextInt(10);
		}

		incorrectAnswer3 = (rand.nextInt(10) - 5);
		while (incorrectAnswer3 == correctAnswer
				|| incorrectAnswer3 == incorrectAnswer1
				|| incorrectAnswer3 == incorrectAnswer2) {
			incorrectAnswer3 = (rand.nextInt(10) - 5);
		}
	}

	// create classes
	private void createClasses() {
		switch (this.level) {
		case 0:
			ClassComponent zeroClass = new ClassComponent("zero", this,
					this.level, this.weight, this.pt);
			childClasses.add(zeroClass);
			correctAnswer = zeroClass.levelZero();
			break;
		case 1:
			ClassComponent firstClass = new ClassComponent("one", this,
					this.level, this.weight, this.pt);
			childClasses.add(firstClass);
			correctAnswer = firstClass.levelOne();
			break;
		case 2:
			ClassComponent secondClass = new ClassComponent("two", this,
					this.level, this.weight, this.pt);
			childClasses.add(secondClass);
			correctAnswer = secondClass.levelTwo();
			break;
		case 3:
			ClassComponent thirdClass = new ClassComponent("three", this,
					this.level, this.weight, this.pt);
			childClasses.add(thirdClass);
			correctAnswer = thirdClass.levelThree();
			break;
		case 4:
			ClassComponent fourthClass = new ClassComponent("four", this,
					this.level, this.weight, this.pt);
			childClasses.add(fourthClass);
			correctAnswer = fourthClass.levelFour();
			break;
		case 5:
			ClassComponent fifthClass = new ClassComponent("five", this,
					this.level, this.weight, this.pt);
			childClasses.add(fifthClass);
			correctAnswer = fifthClass.levelFive();
			break;
		case 6:
			ClassComponent sixthClass = new ClassComponent("six", this,
					this.level, this.weight, this.pt);
			childClasses.add(sixthClass);
			correctAnswer = sixthClass.levelSix();
			break;
		case 7:
			ClassComponent seventhClass = new ClassComponent("seven", this,
					this.level, this.weight, this.pt);
			childClasses.add(seventhClass);
			correctAnswer = seventhClass.levelSeven();
		}
	}

	public void overrideTestVariable(String newTV) {
		testVariable = newTV;
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
