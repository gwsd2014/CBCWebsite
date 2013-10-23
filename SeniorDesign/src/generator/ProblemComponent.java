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
	public ProblemComponent(int diff) {
		childClasses = new LinkedList<ClassComponent>();
		testVariable = "x";

		ProblemTypes problemType = chooseProblemType(diff);
		createClasses(problemType);

		setAnswers();
	}

	private void setAnswers() {
		Random rand = new Random();

		// now create the incorrect answers
		
		incorrectAnswer1 = (int) (correctAnswer * rand.nextGaussian());
		while (incorrectAnswer1 == correctAnswer) {
			incorrectAnswer1 = (int) (correctAnswer * rand.nextGaussian());
		}

		incorrectAnswer2 = (int) (correctAnswer * rand.nextGaussian());
		while (incorrectAnswer2 == correctAnswer) {
			incorrectAnswer3 = (int) (correctAnswer * rand.nextGaussian());
		}

		incorrectAnswer3 = (int) (correctAnswer * rand.nextGaussian());
		while (incorrectAnswer3 == correctAnswer) {
			incorrectAnswer3 = (int) (correctAnswer * rand.nextGaussian());
		}
	}

	// choose problemType
	private ProblemTypes chooseProblemType(int difficulty) {
		if (difficulty == 1) {
			return ProblemTypes.VAR_DECLARATION;
		}
		return ProblemTypes.INVALID;
	}

	// create classes
	private void createClasses(ProblemTypes problemType) {

		// create test class
		ClassComponent firstClass = new ClassComponent("one");
		childClasses.add(firstClass);
		firstClass.setParent(this);
		correctAnswer = firstClass.createFunctions();
	}
	
	public String getTestVariable(){
		return testVariable;
	}
	
	public int getCorrectAnswer(){
		return correctAnswer;
	}
	
	public int getIncorrect1(){
		return incorrectAnswer1;
	}
	
	public int getIncorrect2(){
		return incorrectAnswer2;
	}
	
	public int getIncorrect3(){
		return incorrectAnswer3;
	}
	
	public LinkedList<ClassComponent> getChildren(){
		return childClasses;
	}
}
