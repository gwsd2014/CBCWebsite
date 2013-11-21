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
	private int nest;

	private Tokens comparator;
	private String leftVariable;
	private int rightValue;

	private final int range;

	public ConditionalComponent(Difficulty diff, Component parent, int newNest) {
		parentComponent = parent;
		difficulty = diff;
		random = new Random();
		this.nest = newNest;

		range = 6;
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
		ifComponent = makeAComponent();
		HashMap<String, Integer> ifMap = makeComponentLines(ifComponent,
				deepCopyHashMap(parentMap), testVariable);

		// make else component
		elseComponent = makeAComponent();
		HashMap<String, Integer> elseMap = makeComponentLines(elseComponent,
				deepCopyHashMap(parentMap), testVariable);

		HashMap<String, Integer> currentMap;

		// decide which path to take, if or else
		Boolean ifTaken = random.nextBoolean();
		if (ifTaken) {
			// set the test value to the test variable
			rightValue = parentMap.get(leftVariable);
			currentMap = ifMap;
		} else {
			// set the value to anything OTHER than what test variable currently
			// is
			do {
				rightValue = random.nextInt(range) - range / 2;
			} while (rightValue == parentMap.get(leftVariable));
			currentMap = elseMap;
		}

		return currentMap;
	}

	private LogicComponent makeAComponent() {
		LogicComponent newComponent;

		if (nest <= 1 || difficulty.getLevel() == 2) {
			newComponent = new ArithmeticComponent(difficulty, this);
		} else {
			// 50/50 chance make nested loop or nested conditional
			if (random.nextBoolean()) {
				newComponent = new LoopComponent(difficulty, this, nest - 1);
			} else {
				newComponent = new ConditionalComponent(difficulty, this,
						nest - 1);
			}
		}

		return newComponent;
	}

	private HashMap<String, Integer> makeComponentLines(LogicComponent comp,
			HashMap<String, Integer> parentMap, String testVariable) {
		HashMap<String, Integer> newMap = null;

		if (comp instanceof ArithmeticComponent) {
			newMap = comp.createLines(parentMap, testVariable);
		} else if (comp instanceof LoopComponent) {
			newMap = ((LoopComponent) comp).createForLoop(parentMap,
					testVariable);
		} else if (comp instanceof ConditionalComponent) {
			newMap = ((ConditionalComponent) comp).createLines(parentMap,
					testVariable);
		}

		return newMap;
	}

	public HashMap<String, Integer> runLines(HashMap<String, Integer> parentMap) {

		HashMap<String, Integer> tempMap = parentMap;
		Boolean ifTaken;
		// need to determine if test condition still holds
		if (parentMap.get(leftVariable) == rightValue) {
			ifTaken = true;
		} else {
			ifTaken = false;
		}

		if (ifTaken) {
			tempMap = ifComponent.runLines(deepCopyHashMap(tempMap));
		} else {
			tempMap = elseComponent.runLines(deepCopyHashMap(tempMap));
		}

		return tempMap;
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
