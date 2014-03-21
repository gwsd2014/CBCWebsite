package generator;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

public class ConditionalComponent extends LogicComponent {
    private Component parentComponent;
	private LogicComponent ifComponent;
	private LogicComponent elseComponent;
	private Random random;
	private int nest;

	private Tokens comparator;
	private String leftVariable;
	private int rightValue;

	private final int range;

	private int level;
	private int weight;
	private ProblemType pt;

	public ConditionalComponent(int level, int weight, ProblemType problemType,
			Component parent, int newNest) {
		this.level = level;
		this.weight = weight;
		this.pt = problemType;
		parentComponent = parent;
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

		if (this.level == 4) {
			leftVariable = testVariable;
		}

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

	public void createRecursiveConditional(String additionValue,
			String passedVariable, int passedValue, String functionName,
			String baseValue) {
		// if component is base case
		Line baseLine = new Line(this, false);
		ifComponent = baseLine;
		baseLine.returnStatement(baseValue);

		// else component is recursive case
		Line recursiveLine = new Line(this, false);
		elseComponent = recursiveLine;
		recursiveLine.recursiveAddition(additionValue, functionName,
				passedVariable, "1");

		comparator = Tokens.EQUALS;
		leftVariable = passedVariable;
		rightValue = passedValue;
	}

	private LogicComponent makeAComponent() {
		LogicComponent newComponent;

		if (nest <= 1 || this.level == 2) {
			newComponent = new ArithmeticComponent(this, this.level,
					this.weight, this.pt);
		} else {
			// 50/50 chance make nested loop or nested conditional
			if (random.nextBoolean()) {
				newComponent = new LoopComponent(this.level, this.weight,
						this.pt, this, nest - 1);
			} else {
				newComponent = new ConditionalComponent(this.level,
						this.weight, this.pt, this, nest - 1);
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
