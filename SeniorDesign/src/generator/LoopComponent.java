package generator;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class LoopComponent extends LogicComponent {
	private Component parentComponent;
	private Random random;
	private Difficulty difficulty;
	private LinkedList<LogicComponent> childLogics;

	private Boolean forLoop;
	private Tokens comparator;
	private String leftVariable;
	private int rightValue;
	private int forLoopTestValue;
	private Tokens forLoopIncrementor;
	private int runs;
	private int nest;

	private final int range;
	private final int questionMarks = -1234567;

	public LoopComponent(Difficulty diff, Component parent, int newNest) {
		parentComponent = parent;
		difficulty = diff;
		random = new Random();
		childLogics = new LinkedList<LogicComponent>();
		this.nest = newNest;

		range = 6;
	}

	public HashMap<String, Integer> createForLoop(
			HashMap<String, Integer> parentMap, String testVariable) {

		HashMap<String, Integer> tempMap = parentMap;
		forLoop = true;

		// create test variable
		do {
			leftVariable = chooseVariable();
		} while (tempMap.containsKey(leftVariable));

		// choose value
		rightValue = random.nextInt(range) - range / 2;

		// set test condition
		int comparatorChooser = random.nextInt(4);
		runs = determineRuns();
		switch (comparatorChooser) {
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
		boolean selectArithmetic = true;
		if (difficulty.getWeight() >= 2 && nest > 1) {
			selectArithmetic = random.nextBoolean();
		}
		if (selectArithmetic) {
			LogicComponent nextArith = new ArithmeticComponent(difficulty, this);
			childLogics.add(nextArith);
			// create the arithmetic by do NOT change the current variables
			nextArith.createLines(deepCopyHashMap(parentMap), testVariable);

		} else {
			// coin flip for conditional or another loop
			if (random.nextBoolean()) {
				// loop
				LogicComponent nextLoop = new LoopComponent(difficulty, this,
						nest - 1);
				childLogics.add(nextLoop);
				tempMap = ((LoopComponent) nextLoop).createForLoop(
						deepCopyHashMap(parentMap), testVariable);
			} else {
				// conditional
				LogicComponent nextCond = new ConditionalComponent(difficulty,
						this, nest - 1);
				childLogics.add(nextCond);
				tempMap = nextCond.createLines(deepCopyHashMap(parentMap),
						testVariable);
			}
		}

		return tempMap;
	}

	public HashMap<String, Integer> runLines(HashMap<String, Integer> parentMap) {

		HashMap<String, Integer> tempMap = parentMap;

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
		switch (difficulty.getWeight()) {
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
		if (difficulty.getProblemType() == ProblemType.FILL_BLANK)
			return random.nextInt(5);
		else
			return difficulty.getWeight();
	}

	/**
	 * 
	 * @return true on for loop, false on while loop
	 */
	public Boolean isForLoop() {
		return forLoop;
	}

	public String getForLoopTestValue() {
		if (forLoopTestValue == questionMarks) {
			return "???";
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

	public LinkedList<LogicComponent> getChildLogics() {
		return childLogics;
	}
}
