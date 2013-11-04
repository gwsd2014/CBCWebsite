package generator;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

public class ConditionalComponent extends LogicComponent {
	private Component parentComponent;
	private LogicComponent ifComponent;
	private LogicComponent elseComponent;
	private Random random;
	private Difficulty difficulty;

	private Tokens comparator;
	private String leftVariable;
	private int rightValue;

	public ConditionalComponent(Difficulty diff, Component parent) {
		parentComponent = parent;
		difficulty = diff;
		random = new Random();
	}

	public HashMap<String, Integer> createLines(
			HashMap<String, Integer> parentMap, String testVariable) {

		// make test statement
		// randomly choose variable to test
		Iterator<String> variablesIterator = parentMap.keySet().iterator();
		String randomVariable = variablesIterator.next();
		for (int j = 0; j < random.nextInt(parentMap.size()); j++) {
			randomVariable = variablesIterator.next();
		}
		// TODO Randomization
		leftVariable = randomVariable;
		comparator = Tokens.EQUALS;

		// make if component
		ifComponent = new ArithmeticComponent(difficulty, this);
		HashMap<String, Integer> ifMap = ifComponent.createLines(
				deepCopyHashMap(parentMap), testVariable);

		// make else component
		elseComponent = new ArithmeticComponent(difficulty, this);
		HashMap<String, Integer> elseMap = elseComponent.createLines(
				deepCopyHashMap(parentMap), testVariable);

		HashMap<String, Integer> currentMap = parentMap;

		// decide which path to take, if or else
		boolean ifTaken = random.nextBoolean();
		if (ifTaken) {
			//set the test value to the test variable
			rightValue = parentMap.get(leftVariable);
			currentMap = ifMap;
		}else{
			//set the value to anything OTHER than what test variable currently is
			do{
				rightValue = random.nextInt(20) - 10;
			}while(rightValue == parentMap.get(leftVariable));
			currentMap = elseMap;
		}
		

		// return new state of variables
		return currentMap;
	}

	public String getLeftVariable() {
		return leftVariable;
	}

	public Tokens getComparator() {
		return comparator;
	}

	public int getRightValue() {
		return rightValue;
	}

	public LogicComponent getIfComponent() {
		return ifComponent;
	}

	public LogicComponent getElseComponent() {
		return elseComponent;
	}
}
