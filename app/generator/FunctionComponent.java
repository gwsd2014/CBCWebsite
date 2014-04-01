package generator;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class FunctionComponent extends Component {
	private String name;
	private ClassComponent parentClass;

	private LinkedList<LogicComponent> children;
	private String[] parameterList;
	private String testVariable;
	private HashMap<String, Integer> variables;

	private Random rand;
	private final int range;

	private int level;
	private int weight;
	private ProblemType pt;

	public FunctionComponent(String name, ClassComponent parent, int level,
			int weight, ProblemType problemType) {
		this.level = level;
		this.weight = weight;
		this.pt = problemType;
		rand = new Random();
		parameterList = new String[0];
		parentClass = parent;
		this.name = name;
		variables = parent.getVariablesDeepCopy();
		children = new LinkedList<LogicComponent>();
		testVariable = parent.getTestVariable();
		if (level == 1) {
			range = 20;
		} else {
			range = 6;
		}
	}

	public void setParameters(String[] parameters) {
		parameterList = parameters;
	}

	/**
	 * Declares the variables If linesOveride set above 0, that value will be
	 * used, else the default value for that difficulty will be used
	 * 
	 * @param linesOveride
	 */
	public void declareVariables(int linesOveride) {
		int lines = determineAmountOfLines();
		if (linesOveride > 0) {
			lines = 1;
		} else {
			// for all functions except child functions, declare test variable
			Line decl = new Line(this, false);
			children.add(decl);
			int initialValue = rand.nextInt(range) - range / 2;
			decl.declareVariable(testVariable, initialValue);
			variables.put(testVariable, initialValue);
		}
		// now determine how many extra lines to create, based on the difficulty
		// weight
		for (int i = 0; i < lines; i++) {
			// each variable is declared as a letter, with value from -10 to 10
			Line declaration = new Line(this, false);
			children.add(declaration);

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
		children.add(blank);
	}

	public String declareArray() {
		// choose array name
		String letterVariable = chooseVariable();
		while (variables.containsKey(letterVariable)) {
			letterVariable = chooseVariable();
		}

		// determine array size
		int arraySize = determineArraySize();
		// declare array
		Line arrayDeclaration = new Line(this, false);
		children.add(arrayDeclaration);
		String fullArrayName = letterVariable + "[" + arraySize + "]";
		arrayDeclaration.declareArray(fullArrayName);

		// declare all array indices
		for (int i = 0; i < arraySize; i++) {
			Line indexDeclaration = new Line(this, false);
			children.add(indexDeclaration);
			int initialValue = rand.nextInt(range) - range / 2;
			indexDeclaration.declareArrayVariable(letterVariable + "[" + i
					+ "]", initialValue);
			variables.put(letterVariable + "[" + i + "]", initialValue);
		}

		// override the test variable, making it one of the array indices
		int testIndex = rand.nextInt(arraySize);
		String newTestVariable = letterVariable + "[" + testIndex + "]";
		overrideTestVariable(newTestVariable);

		// add a blank line at the end of indentation
		Line blank = new Line(this, true);
		children.add(blank);

		return fullArrayName;
	}

	private void overrideTestVariable(String newTV) {
		testVariable = newTV;
		parentClass.overrideTestVariable(newTV);
	}

	private int determineArraySize() {
		int size = this.weight;
		if (size > 3) {
			size = 3;
		}
		return size;
	}

	private int determineAmountOfLines() {
		// cap lines at 1 for fill in the blank
		if (this.pt == ProblemType.FILL_BLANK) {
			return 1;
		}

		int lines = this.weight - 1;

		if (this.level == 2) {
			if (lines > 1) {
				lines = 1;
			}
		}

		else if (this.level == 3 && this.weight > 3) {
			lines = 1;
		}

		// with difficulty 5/6, cap at 3 lines
		else if (this.level == 5 || this.level == 6) {
			if (lines > 3) {
				lines = 3;
			}
		}

		return lines;
	}

	/**
	 * Simple arithmetic
	 * 
	 * @return testVariable new value
	 */
	public int levelZeroLogics() {
		ArithmeticComponent firstArith = new ArithmeticComponent(this,
				this.level, this.weight, this.pt);
		children.add(firstArith);

		variables = firstArith.createLines(variables, testVariable);

		// add blank line and return statement
		Line blankLine = new Line(this, true);
		children.add(blankLine);

		Line returnLine = new Line(this, false);
		children.add(returnLine);
		returnLine.returnStatement(testVariable);

		return variables.get(testVariable);
	}

	/**
	 * Array Tests
	 * 
	 * @return test variable value
	 */
	public int levelOneLogics() {
		ArithmeticComponent firstArith = new ArithmeticComponent(this,
				this.level, this.weight, this.pt);
		children.add(firstArith);

		variables = firstArith.createLines(variables, testVariable);

		// add blank line and return statement
		Line blankLine = new Line(this, true);
		children.add(blankLine);

		Line returnLine = new Line(this, false);
		children.add(returnLine);
		returnLine.returnStatement(testVariable);

		return variables.get(testVariable);
	}

	/**
	 * Conditional tests, no nesting
	 * 
	 * @return testVariable new value
	 */
	public int levelTwoLogics() {
		ArithmeticComponent firstArith = new ArithmeticComponent(this,
				this.level, this.weight, this.pt);
		children.add(firstArith);

		variables = firstArith.createLines(deepCopyHashMap(variables),
				testVariable);

		ConditionalComponent firstCondition = new ConditionalComponent(
				this.level, this.weight, this.pt, this, this.weight);
		children.add(firstCondition);

		variables = firstCondition.createLines(deepCopyHashMap(variables),
				testVariable);

		// add blank line and return statement
		Line blankLine = new Line(this, true);
		children.add(blankLine);

		Line returnLine = new Line(this, false);
		children.add(returnLine);
		returnLine.returnStatement(testVariable);

		return variables.get(testVariable);
	}

	/**
	 * Loop tests, no nesting
	 * 
	 * @return testVariable new value
	 */
	public int levelThreeLogics() {
		boolean hasArray = false;
		String arrayName = "";
		if (this.weight > 3) {
			hasArray = true;
			arrayName = declareArray();
		}

		ArithmeticComponent firstArith = new ArithmeticComponent(this,
				this.level, this.weight, this.pt);
		children.add(firstArith);

		variables = firstArith.createLines(deepCopyHashMap(variables),
				testVariable);

		// loop, no nesting
		LoopComponent firstLoop = new LoopComponent(this.level, this.weight,
				this.pt, this, 1);
		children.add(firstLoop);
		if (!hasArray) {
			firstLoop.createForLoop(deepCopyHashMap(variables), testVariable);
		} else {
			firstLoop.createArrayLoop(deepCopyHashMap(variables), testVariable,
					arrayName);
		}

		variables = firstLoop.runLines(variables);

		// add blank line and return statement
		Line blankLine = new Line(this, true);
		children.add(blankLine);

		Line returnLine = new Line(this, false);
		children.add(returnLine);
		returnLine.returnStatement(testVariable);

		return variables.get(testVariable);
	}

	/**
	 * Conditional and loop tests, up to 3 nesting
	 * 
	 * @return testVariable new value
	 */
	public int levelFourLogics() {
		ArithmeticComponent firstArith = new ArithmeticComponent(this,
				this.level, this.weight, this.pt);
		children.add(firstArith);

		variables = firstArith.createLines(deepCopyHashMap(variables),
				testVariable);

		// coin-flip loop or conditional
		if (rand.nextBoolean()) {
			ConditionalComponent firstCondition = new ConditionalComponent(
					this.level, this.weight, this.pt, this, this.weight);
			children.add(firstCondition);

			variables = firstCondition.createLines(variables, testVariable);
		} else {
			LoopComponent firstLoop = new LoopComponent(this.level,
					this.weight, this.pt, this, this.weight);
			children.add(firstLoop);

			firstLoop.createForLoop(deepCopyHashMap(variables), testVariable);
			variables = firstLoop.runLines(variables);
		}

		// add blank line and return statement
		Line blankLine = new Line(this, true);
		children.add(blankLine);

		Line returnLine = new Line(this, false);
		children.add(returnLine);
		returnLine.returnStatement(testVariable);

		return variables.get(testVariable);
	}

	/**
	 * Function call test, this function calls the other
	 * 
	 * @return testVariable new value
	 */
	public int levelFiveMain(FunctionComponent[] calleeFunctions) {
		// call every function passes
		for (int k = 0; k < calleeFunctions.length; k++) {
			String calleeName = calleeFunctions[k].getName();
			Line functionCall = new Line(this, false);
			int[] parameterValues = new int[parentClass.getFunctionMap().get(
					calleeName).length];
			String[] parameterStrings = new String[parentClass.getFunctionMap()
					.get(calleeName).length];
			for (int i = 0; i < parameterValues.length; i++) {
				// choose by variable or by value
				if (rand.nextBoolean() || this.weight <= 3) {
					// by value, first 3 always value
					parameterValues[i] = rand.nextInt(range) - 3;
					parameterStrings[i] = Integer.toString(parameterValues[i]);
				} else { // by variable
					// choose which variable to pass
					String randomVariable = selectVariable(variables);

					parameterStrings[i] = randomVariable;
					parameterValues[i] = variables.get(randomVariable);
				}
			}
			// choose which variable to alter with the function
			String alteredVariable = testVariable;
			if (k < calleeFunctions.length - 1) {
				// if last function, alter the test variable, else choose random
				while (alteredVariable.equals(testVariable)) {
					alteredVariable = selectVariable(variables);
				}
			}

			functionCall.callFunction(alteredVariable, calleeName,
					parameterStrings);
			// alter the variable by calling function
			variables.put(alteredVariable,
					calleeFunctions[k].levelFiveCallee(parameterValues));
			children.add(functionCall);
		}
		// add blank line and return statement
		Line blankLine = new Line(this, true);
		children.add(blankLine);

		Line returnLine = new Line(this, false);
		children.add(returnLine);
		returnLine.returnStatement(testVariable);

		return variables.get(testVariable);
	}

	/**
	 * Function call test, this function called by the other
	 */
	public int levelFiveCallee(int[] paramValues) {
		// first add declared parameters to variable map
		for (int i = 0; i < parameterList.length; i++) {
			variables.put(parameterList[i], paramValues[i]);
		}
		// pick function type, at random
		int selection = rand.nextInt(3);

		// choose which variable to return
		String randomVariable = selectVariable(variables);

		if (selection == 0) {
			ArithmeticComponent firstArith = new ArithmeticComponent(this,
					this.level, this.weight, this.pt);
			children.add(firstArith);
			variables = firstArith.createLines(deepCopyHashMap(variables),
					randomVariable);
		} else if (selection == 1) {
			LoopComponent firstLoop = new LoopComponent(this.level,
					this.weight, this.pt, this, 1);
			children.add(firstLoop);
			firstLoop.createForLoop(deepCopyHashMap(variables), randomVariable);
			variables = firstLoop.runLines(deepCopyHashMap(variables));

		} else {
			ConditionalComponent firstCond = new ConditionalComponent(
					this.level, this.weight, this.pt, this, 1);
			children.add(firstCond);
			variables = firstCond.createLines(deepCopyHashMap(variables),
					randomVariable);
		}

		// add blank line
		Line blankLine = new Line(this, true);
		children.add(blankLine);

		// add return statement
		Line returnLine = new Line(this, false);
		children.add(returnLine);
		returnLine.returnStatement(randomVariable);

		return variables.get(randomVariable);
	}

	public int levelSixMain(FunctionComponent[] calleeFunctions) {
		// call every function passes
		String calleeName = calleeFunctions[1].getName();
		Line functionCall = new Line(this, false);
		int[] parameterValues = new int[parentClass.getFunctionMap().get(
				calleeName).length];
		String[] parameterStrings = new String[parentClass.getFunctionMap()
				.get(calleeName).length];
		for (int i = 0; i < parameterValues.length; i++) {
			// choose by variable or by value
			if (rand.nextBoolean() || this.weight <= 3) {
				// by value, first 3 always value
				parameterValues[i] = rand.nextInt(range) - 3;
				parameterStrings[i] = Integer.toString(parameterValues[i]);
			} else { // by variable
				// choose which variable to pass
				String randomVariable = selectVariable(variables);

				parameterStrings[i] = randomVariable;
				parameterValues[i] = variables.get(randomVariable);
			}
		}
		// choose which variable to alter with the function
		String alteredVariable = testVariable;

		functionCall
				.callFunction(alteredVariable, calleeName, parameterStrings);
		// alter the variable by calling function
		variables.put(alteredVariable, calleeFunctions[1]
				.levelSixNestedFunction(parameterValues, calleeFunctions[0]));
		children.add(functionCall);

		// add blank line and return statement
		Line blankLine = new Line(this, true);
		children.add(blankLine);

		Line returnLine = new Line(this, false);
		children.add(returnLine);
		returnLine.returnStatement(testVariable);

		return variables.get(testVariable);
	}

	public int levelSixNestedFunction(int[] paramValues,
			FunctionComponent childFunction) {
		// first add declared parameters to variable map
		for (int i = 0; i < parameterList.length; i++) {
			variables.put(parameterList[i], paramValues[i]);
		}

		// choose which variable to return
		String randomVariable = selectVariable(variables);

		// create child function
		String calleeName = childFunction.getName();
		Line functionCall = new Line(this, false);
		int[] parameterValues = new int[parentClass.getFunctionMap().get(
				calleeName).length];
		String[] parameterStrings = new String[parentClass.getFunctionMap()
				.get(calleeName).length];
		for (int i = 0; i < parameterValues.length; i++) {
			// choose by variable or by value
			if (rand.nextBoolean() || this.weight <= 3) {
				// by value, first 3 always value
				parameterValues[i] = rand.nextInt(range) - 3;
				parameterStrings[i] = Integer.toString(parameterValues[i]);
			} else { // by variable
				// choose which variable to pass
				String passedVariable = selectVariable(variables);

				parameterStrings[i] = passedVariable;
				parameterValues[i] = variables.get(passedVariable);
			}
		}

		functionCall.callFunction(randomVariable, calleeName, parameterStrings);
		// alter the variable by calling function
		variables.put(randomVariable,
				childFunction.levelFiveCallee(parameterValues));
		children.add(functionCall);

		// pick function type, arithmetic for now
		ArithmeticComponent firstArith = new ArithmeticComponent(this,
				this.level, this.weight, this.pt);
		children.add(firstArith);

		// create lines
		variables = firstArith.createLines(deepCopyHashMap(variables),
				randomVariable);

		// add blank line
		Line blankLine = new Line(this, true);
		children.add(blankLine);

		// add return statement
		Line returnLine = new Line(this, false);
		children.add(returnLine);
		returnLine.returnStatement(randomVariable);

		return variables.get(randomVariable);
	}

	public int levelSevenMain(FunctionComponent childFunction) {
		String calleeName = childFunction.getName();

		Line functionCall = new Line(this, false);
		String[] parameterStrings = new String[1];
		parameterStrings[0] = selectVariable(variables);
		int parameterValue = variables.get(parameterStrings[0]);

		functionCall.callFunction(testVariable, calleeName, parameterStrings);
		children.add(functionCall);

		// determine how many times to recurse
		int recursions = this.weight;

		// alter the variable by calling function
		variables.put(testVariable,
				childFunction.levelSevenRecurser(recursions, parameterValue));

		// add blank line and return statement
		Line blankLine = new Line(this, true);
		children.add(blankLine);

		Line returnLine = new Line(this, false);
		children.add(returnLine);
		returnLine.returnStatement(testVariable);

		return variables.get(testVariable);
	}

	public int levelSevenRecurser(int recursions, int initialValue) {
		ConditionalComponent recursiveConditional = new ConditionalComponent(
				this.level, this.weight, this.pt, this, 0);
		children.add(recursiveConditional);

		int additionValue = rand.nextInt(5) + 1;
		int baseValue = rand.nextInt(6) - 3;
		int finalValue = initialValue - recursions;
		int returnValue = (additionValue * recursions) + baseValue;

		recursiveConditional.createRecursiveConditional(
				Integer.toString(additionValue), parameterList[0], finalValue,
				name, Integer.toString(baseValue));

		return returnValue;
	}

	public HashMap<String, Integer> runLines(HashMap<String, Integer> parentMap) {
		// run variable declarations again, variable values overridden,
		HashMap<String, Integer> tempMap = parentMap;

		for (Iterator<LogicComponent> i = children.iterator(); i.hasNext();) {
			LogicComponent child = i.next();
			if (!(child instanceof Line)) {
				tempMap = child.runLines(deepCopyHashMap(tempMap));
			}
		}

		// run child components again, variable values modified
		return tempMap;
	}

	public String getName() {
		return name;
	}

	public ClassComponent getParent() {
		return parentClass;
	}

	public LinkedList<LogicComponent> getChildren() {
		return children;
	}

	public String getTestVariable() {
		return testVariable;
	}

	public HashMap<String, Integer> getVariables() {
		return variables;
	}

	public String[] getParameterList() {
		return parameterList;
	}
}
