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

	public LoopComponent(Difficulty diff, Component parent, int newNest) {
		parentComponent = parent;
		difficulty = diff;
		random = new Random();
		childLogics = new LinkedList<LogicComponent>();
		this.nest = newNest;

		range = 6;
	}

	/*
	 * public HashMap<String, Integer> createWhileLoop( HashMap<String, Integer>
	 * parentMap, String testVariable) { forLoop = false;
	 * 
	 * // make test statement // randomly choose variable to test
	 * Iterator<String> variablesIterator = parentMap.keySet().iterator();
	 * String randomVariable = variablesIterator.next(); for (int j = 0; j <
	 * random.nextInt(parentMap.size()); j++) { randomVariable =
	 * variablesIterator.next(); } // TODO Randomization leftVariable =
	 * randomVariable; int comparatorChooser = random.nextInt(4); switch
	 * (comparatorChooser) { case 0: comparator = Tokens.LTE; break; case 1:
	 * comparator = Tokens.LT; break; case 2: comparator = Tokens.GT; break;
	 * case 3: comparator = Tokens.GTE; break; }
	 * 
	 * HashMap<String, Integer> currentMap = new HashMap<String, Integer>();
	 * 
	 * // determine what should go in the loop, only going beyond arithmetic if
	 * // weight > 1, and if nesting hasn't expired boolean selectArithmetic =
	 * true; if (difficulty.getWeight() >= 2 && nest > 1) { selectArithmetic =
	 * random.nextBoolean(); } if (selectArithmetic) { LogicComponent nextArith
	 * = new ArithmeticComponent(difficulty, this); childLogics.add(nextArith);
	 * currentMap = nextArith.createLines(deepCopyHashMap(parentMap),
	 * testVariable);
	 * 
	 * } else { // coin flip for conditional or another loop if
	 * (random.nextBoolean()) { // loop LogicComponent nextLoop = new
	 * LoopComponent(difficulty, this, nest - 1); childLogics.add(nextLoop);
	 * currentMap = nextLoop.createLines(deepCopyHashMap(parentMap),
	 * testVariable); } else { // conditional LogicComponent nextCond = new
	 * ConditionalComponent(difficulty, this, nest - 1);
	 * childLogics.add(nextCond); currentMap =
	 * nextCond.createLines(deepCopyHashMap(parentMap), testVariable); } }
	 * return currentMap; }
	 */

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
		runs = difficulty.getWeight();
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

	/**
	 * 
	 * @return true on for loop, false on while loop
	 */
	public Boolean isForLoop() {
		return forLoop;
	}

	public int getForLoopTestValue() {
		return forLoopTestValue;
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

	public int getRightValue() {
		return rightValue;
	}

	public LinkedList<LogicComponent> getChildLogics() {
		return childLogics;
	}
}
