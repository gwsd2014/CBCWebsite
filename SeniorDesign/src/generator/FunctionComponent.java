package generator;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

public class FunctionComponent extends Component {
	private String name;
	private ClassComponent parentClass;
	private Difficulty difficulty;

	private LinkedList<LogicComponent> childLogics;
	private LinkedList<Line> childLines;
	private String testVariable;
	private HashMap<String, Integer> variables;

	private Random rand;
	private final int range;

	public FunctionComponent(String name, Difficulty diff, ClassComponent parent) {
		rand = new Random();

		parentClass = parent;
		difficulty = diff;
		this.name = name;
		variables = new HashMap<String, Integer>();
		childLines = new LinkedList<Line>();
		childLogics = new LinkedList<LogicComponent>();

		if (difficulty.getLevel() == 1) {
			range = 20;
		} else {
			range = 6;
		}
	}

	// create declaration
	public void declareVariables() {
		testVariable = parentClass.getParent().getTestVariable();

		// declare the test variable
		Line decl = new Line(this, false);
		childLines.add(decl);
		int initialValue = rand.nextInt(range) - range / 2;
		decl.declareVariable(testVariable, initialValue);
		variables.put(testVariable, initialValue);

		int lines = determineAmountOfLines();
		// now determine how many extra lines to create, based on the difficulty
		// weight
		for (int i = 0; i < lines; i++) {
			// each variable is declared as a letter, with value from -10 to 10
			Line declaration = new Line(this, false);
			childLines.add(declaration);

			// choose a letter for the variable, as long as it has not already
			// been chosen
			String letterVariable = chooseVariable();
			while (variables.containsKey(letterVariable)) {
				letterVariable = chooseVariable();
			}

			int variableValue = rand.nextInt(range) - range / 2;

			// create the line, and add it to the variables map
			declaration.declareVariable(letterVariable, variableValue);
			variables.put(letterVariable, variableValue);
		}

		// add a blank line at the end of indentation
		Line blank = new Line(this, true);
		childLines.add(blank);
	}

	private int determineAmountOfLines() {
		int lines = difficulty.getWeight() - 1;

		if (difficulty.getLevel() == 2) {
			if (lines > 1) {
				lines = 1;
			}
		}

		return lines;
	}

	/**
	 * Simple arithmetic
	 * 
	 * @return testVariable new value
	 */
	public int levelOneLogics() {
		ArithmeticComponent firstArith = new ArithmeticComponent(difficulty,
				this);
		childLogics.add(firstArith);

		variables = firstArith.createLines(variables, testVariable);

		return variables.get(testVariable);
	}

	/**
	 * Conditional tests, no nesting
	 * 
	 * @return testVariable new value
	 */
	public int levelTwoLogics() {
		ArithmeticComponent firstArith = new ArithmeticComponent(difficulty,
				this);
		childLogics.add(firstArith);

		variables = firstArith.createLines(deepCopyHashMap(variables),
				testVariable);

		ConditionalComponent firstCondition = new ConditionalComponent(
				difficulty, this, difficulty.getWeight());
		childLogics.add(firstCondition);

		variables = firstCondition.createLines(deepCopyHashMap(variables),
				testVariable);

		return variables.get(testVariable);
	}

	/**
	 * Loop tests, no nesting
	 * 
	 * @return testVariable new value
	 */
	public int levelThreeLogics() {
		ArithmeticComponent firstArith = new ArithmeticComponent(difficulty,
				this);
		childLogics.add(firstArith);

		variables = firstArith.createLines(deepCopyHashMap(variables),
				testVariable);

		// loop, no nesting
		LoopComponent firstLoop = new LoopComponent(difficulty, this, 1);
		childLogics.add(firstLoop);

		firstLoop.createForLoop(deepCopyHashMap(variables), testVariable);
		variables = firstLoop.runLines(variables);

		return variables.get(testVariable);
	}

	/**
	 * Conditional and loop tests, up to 3 nesting
	 * 
	 * @return testVariable new value
	 */
	public int levelFourLogics() {
		ArithmeticComponent firstArith = new ArithmeticComponent(difficulty,
				this);
		childLogics.add(firstArith);

		variables = firstArith.createLines(deepCopyHashMap(variables),
				testVariable);

		// coin-flip loop or conditional
		if (rand.nextBoolean()) {
			ConditionalComponent firstCondition = new ConditionalComponent(
					difficulty, this, difficulty.getWeight());
			childLogics.add(firstCondition);

			variables = firstCondition.createLines(variables, testVariable);
		} else {
			LoopComponent firstLoop = new LoopComponent(difficulty, this,
					difficulty.getWeight());
			childLogics.add(firstLoop);

			firstLoop.createForLoop(deepCopyHashMap(variables), testVariable);
			variables = firstLoop.runLines(variables);
		}
		return variables.get(testVariable);
	}

	public String getName() {
		return name;
	}

	public ClassComponent getParent() {
		return parentClass;
	}

	public LinkedList<LogicComponent> getChildLogics() {
		return childLogics;
	}

	public LinkedList<Line> getChildLines() {
		return childLines;
	}

	public String getTestVariable() {
		return testVariable;
	}

	public HashMap<String, Integer> getVariables() {
		return variables;
	}
}
