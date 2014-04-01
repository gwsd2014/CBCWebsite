package generator;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class LoopComponent extends LogicComponent {
	private Component parentComponent;
	private Random random;
	private LinkedList<LogicComponent> childLogics;

	private Tokens comparator;
	private String leftVariable;
	private int rightValue;
	private int forLoopTestValue;
	private String forLoopTestValueString;
	private Boolean arrayLoop;
	private Tokens forLoopIncrementor;
	private int runs;
	private int nest;

	private final int range;
	private final int questionMarks = -1234567;

	private int level;
	private int weight;
	private ProblemType pt;

	private String functionCallName;
	private String[] parameterStrings;
	private int[] parameterValues;
	private FunctionComponent childFunction;

	public LoopComponent(int level, int weight, ProblemType problemType,
			Component parent, int newNest) {
		this.level = level;
		this.weight = weight;
		this.pt = problemType;
		parentComponent = parent;
		random = new Random();
		childLogics = new LinkedList<LogicComponent>();
		arrayLoop = false;
		this.nest = newNest;

		range = 6;
	}

	public HashMap<String, Integer> createArrayLoop(
			HashMap<String, Integer> parentMap, String testVariable,
			String arrayFullName) {

		arrayLoop = true;

		String arrayName = arrayFullName.substring(0, 1);
		int arrayLength = Integer.parseInt(arrayFullName.substring(2, 3));

		HashMap<String, Integer> tempMap = parentMap;

		// create test variable
		do {
			leftVariable = chooseVariable();
		} while (tempMap.containsKey(leftVariable));

		// choose value
		rightValue = random.nextInt(range) - range / 2;
		forLoopTestValue = rightValue + arrayLength;
		forLoopTestValueString = arrayName + ".length";
		comparator = Tokens.LT;
		forLoopIncrementor = Tokens.INCREASE;

		runs = arrayLength;

		LogicComponent nextArith = new ArithmeticComponent(this, this.level,
				this.weight, this.pt);
		childLogics.add(nextArith);
		// create the arithmetic by do NOT change the current variables
		nextArith.createLines(deepCopyHashMap(parentMap), testVariable);

		return tempMap;
	}

	public HashMap<String, Integer> createForLoop(
			HashMap<String, Integer> parentMap, String testVariable) {

		HashMap<String, Integer> tempMap = parentMap;

		// create test variable
		do {
			leftVariable = chooseVariable();
		} while (tempMap.containsKey(leftVariable));

		// choose value
		rightValue = random.nextInt(range) - range / 2;

		// set test condition
		runs = determineRuns();

		switch (random.nextInt(4)) {
		case 0:
			comparator = Tokens.LTE;
			forLoopTestValue = rightValue + (runs - 1);
			forLoopIncrementor = Tokens.INCREASE;
			break;
		case 1:
			comparator = Tokens.LT;
			forLoopTestValue = rightValue + runs;
			forLoopIncrementor = Tokens.INCREASE;
			break;
		case 2:
			comparator = Tokens.GT;
			forLoopTestValue = rightValue - runs;
			forLoopIncrementor = Tokens.DECREASE;
			break;
		case 3:
			comparator = Tokens.GTE;
			forLoopTestValue = rightValue - (runs - 1);
			forLoopIncrementor = Tokens.DECREASE;
		}

		// determine what should go in the loop, only going beyond arithmetic if
		// weight > 1, and if nesting hasn't expired
		int selection = 0;
		if (this.level == 6 && this.weight > 8) {
			selection = -1;
		} else if (this.weight >= 2 && nest > 1) {
			selection = random.nextInt(3);
		}
		if (selection == 0) {
			LogicComponent nextArith = new ArithmeticComponent(this,
					this.level, this.weight, this.pt);
			childLogics.add(nextArith);
			// create the arithmetic by do NOT change the current variables
			nextArith.createLines(deepCopyHashMap(parentMap), testVariable);

		} else if (selection == -1) {
			// hard mode loop
			Line functionCall = new Line(this, false);
			functionCall.callFunction(testVariable, functionCallName,
					parameterStrings);
			// alter the variable by calling function
			tempMap.put(testVariable,
					childFunction.levelFiveCallee(parameterValues));
			childLogics.add(functionCall);

		} else if (selection == 1) {
			// loop
			LogicComponent nextLoop = new LoopComponent(this.level,
					this.weight, this.pt, this, nest - 1);
			childLogics.add(nextLoop);
			tempMap = ((LoopComponent) nextLoop).createForLoop(
					deepCopyHashMap(parentMap), testVariable);
		} else {
			// conditional
			LogicComponent nextCond = new ConditionalComponent(this.level,
					this.weight, this.pt, this, nest - 1);
			childLogics.add(nextCond);
			tempMap = nextCond.createLines(deepCopyHashMap(parentMap),
					testVariable);
		}

		return tempMap;
	}

	public HashMap<String, Integer> runLines(HashMap<String, Integer> parentMap) {

		HashMap<String, Integer> tempMap = parentMap;

		if(tempMap == null){
			System.out.println("null in runLines");
		}
		// loop through number of loop runs
		for (int i = 0; i < runs; i++) {
			// loop through all child components
			for (Iterator<LogicComponent> iterator = childLogics.iterator(); iterator
					.hasNext();) {
				LogicComponent nextComponent = iterator.next();
				tempMap = nextComponent.runLines(deepCopyHashMap(tempMap));
			}
		}

		return tempMap;
	}

	public void overrideChildren(Line overide) {
		childLogics.clear();
		childLogics.add(overide);
	}

	public void replacePiece() {
		switch (this.weight) {
		case 1:
			System.out.println("Expected answer: " + rightValue);
			rightValue = questionMarks;
			return;
		case 2:
			System.out.println("Expected answer: " + forLoopTestValue);
			forLoopTestValue = questionMarks;
			return;
		case 3:
			System.out.println("Expected answer: " + forLoopIncrementor);
			forLoopIncrementor = Tokens.QUESTIONS;
			return;
		}
	}

	private int determineRuns() {
		if (this.pt == ProblemType.FILL_BLANK)
			return random.nextInt(5);
		else
			return this.weight;
	}

	public String getForLoopTestValue() {
		if (forLoopTestValue == questionMarks) {
			return "???";
		}
		if (arrayLoop) {
			return forLoopTestValueString;
		}
		return Integer.toString(forLoopTestValue);
	}

	/**
	 * 
	 * @return true on increments, false on decrements
	 */
	public Tokens getForLoopIncrementor() {
		return forLoopIncrementor;
	}

	public String getLeftVariable() {
		return leftVariable;
	}

	public Tokens getComparator() {
		return comparator;
	}

	public String getRightValue() {
		if (rightValue == questionMarks) {
			return "???";
		}
		return Integer.toString(rightValue);
	}

	public void setFunctionCallName(String newName) {
		functionCallName = newName;
	}

	public void setParameterStrings(String[] setParams) {
		parameterStrings = setParams;
	}

	public void setChildFunction(FunctionComponent setFunc) {
		childFunction = setFunc;
	}

	public void setParameterValues(int[] setValues) {
		parameterValues = setValues;
	}

	public LinkedList<LogicComponent> getChildLogics() {
		return childLogics;
	}
}
