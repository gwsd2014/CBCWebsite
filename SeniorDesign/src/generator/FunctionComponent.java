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

	public FunctionComponent(String name, Difficulty diff, ClassComponent parent) {
		rand = new Random();

		parentClass = parent;
		difficulty = diff;
		this.name = name;
		variables = new HashMap<String, Integer>();
		childLines = new LinkedList<Line>();
		childLogics = new LinkedList<LogicComponent>();
	}

	// create declaration
	public void declareVariables() {
		testVariable = parentClass.getParent().getTestVariable();

		// declare the test variable
		Line decl = new Line(this, false);
		childLines.add(decl);
		int initialValue = rand.nextInt(20) - 10;
		decl.declareVariable(testVariable, initialValue);
		variables.put(testVariable, initialValue);

		// now determine how many extra lines to create, based on the difficulty
		// weight
		for (int i = 0; i < difficulty.getWeight()-1 && i < 4; i++) {
			// each variable is declared as a letter, with value from -10 to 10
			Line declaration = new Line(this, false);
			childLines.add(declaration);

			// choose a letter for the variable, as long as it has not already
			// been chosen
			String letterVariable = chooseVariable();
			while (variables.containsKey(letterVariable)) {
				letterVariable = chooseVariable();
			}

			int variableValue = rand.nextInt(20) - 10;

			// create the line, and add it to the variables map
			declaration.declareVariable(letterVariable, variableValue);
			variables.put(letterVariable, variableValue);
		}

		// add a blank line at the end of indentation
		Line blank = new Line(this, true);
		childLines.add(blank);
	}

	// create rest of function
	public int createLogics() {
		ArithmeticComponent firstArith = new ArithmeticComponent(difficulty,
				this);
		childLogics.add(firstArith);

		variables = firstArith.createLines(variables, testVariable);

		ConditionalComponent firstCondition = new ConditionalComponent(difficulty, this);
		childLogics.add(firstCondition);
		
		variables = firstCondition.createLines(variables, testVariable);
		
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
