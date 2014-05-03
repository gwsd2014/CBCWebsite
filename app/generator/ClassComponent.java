package generator;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

public class ClassComponent extends Component {
    private String name;
	private ProblemComponent parentProblem;
	private LinkedList<FunctionComponent> childFunctions;
	private LinkedList<Line> childLines;
	private String testVariable;
	private HashMap<String, Integer> variables;
	private HashMap<String, String[]> functionMap;

	private Random rand;
	private final int range;

	private int level;
	private int weight;
	private ProblemType pt;

	public ClassComponent(String name, ProblemComponent parent, int level,
			int weight, ProblemType problemType) {
		this.level = level;
		this.weight = weight;
		this.pt = problemType;
		parentProblem = parent;
		this.name = name;
		testVariable = parent.getTestVariable();
		this.variables = new HashMap<String, Integer>();
		functionMap = new HashMap<String, String[]>();
		childFunctions = new LinkedList<FunctionComponent>();
		childLines = new LinkedList<Line>();
		rand = new Random();
		range = 3;
	}

	public int levelZero() {
		FunctionComponent zeroFunction = new FunctionComponent("Main", this,
				this.level, this.weight, this.pt);
		childFunctions.add(zeroFunction);
		zeroFunction.declareVariables(0);

		int newValue = zeroFunction.levelZeroLogics();

		return newValue;
	}

	public int levelOne() {
		FunctionComponent firstFunction = new FunctionComponent("Main", this,
				this.level, this.weight, this.pt);
		childFunctions.add(firstFunction);
		firstFunction.declareVariables(0);
		firstFunction.declareArray();

		int newValue = firstFunction.levelOneLogics();

		return newValue;
	}

	public int levelTwo() {
		FunctionComponent firstFunction = new FunctionComponent("Main", this,
				this.level, this.weight, this.pt);
		childFunctions.add(firstFunction);
		firstFunction.declareVariables(0);

		int newValue = firstFunction.levelTwoLogics();

		return newValue;
	}

	public int levelThree() {

		FunctionComponent firstFunction = new FunctionComponent("Main", this,
				this.level, this.weight, this.pt);
		childFunctions.add(firstFunction);
		firstFunction.declareVariables(0);
		int newValue = firstFunction.levelThreeLogics();

		return newValue;
	}

	public int levelFour() {
		FunctionComponent firstFunction = new FunctionComponent("Main", this,
				this.level, this.weight, this.pt);
		childFunctions.add(firstFunction);
		firstFunction.declareVariables(0);

		int newValue = firstFunction.levelFourLogics();

		return newValue;
	}

	/**
	 * Multiple-function test
	 * 
	 * @return
	 */
	public int levelFive() {
		// create other functions
		FunctionComponent[] functionArray = new FunctionComponent[determineAmountOfFunctions()];
		for (int i = 0; i < functionArray.length; i++) {
			String functionName = "function" + i;
			functionArray[i] = new FunctionComponent(functionName, this,
					this.level, this.weight, this.pt);
			childFunctions.add(functionArray[i]);
			functionArray[i].declareVariables(1);

			// create the parameter list with new variables
			String[] functionParameters = new String[2];
			LinkedList<String> takenLetters = new LinkedList<String>();
			for (int j = 0; j < functionParameters.length; j++) {
				String letter = chooseVariable();
				while (variables.containsKey(letter)
						|| takenLetters.contains(letter)
						|| functionArray[i].getVariables().containsKey(letter)) {
					letter = chooseVariable();
				}
				functionParameters[j] = letter;
				takenLetters.add(letter);
			}
			functionArray[i].setParameters(functionParameters);
			functionMap.put(functionName, functionParameters);
		}

		// create first function
		String firstName = "Main";
		FunctionComponent firstFunction = new FunctionComponent(firstName,
				this, this.level, this.weight, this.pt);
		childFunctions.add(firstFunction);
		firstFunction.declareVariables(0);
		functionMap.put(firstName, new String[0]);
		// run main function
		variables.put(testVariable, firstFunction.levelFiveMain(functionArray));

		return variables.get(testVariable);
	}

	public int levelSix() {
		// create other functions
		FunctionComponent[] functionArray = new FunctionComponent[determineAmountOfFunctions()];
		for (int i = 0; i < functionArray.length; i++) {
			String functionName = "function" + i;
			functionArray[i] = new FunctionComponent(functionName, this,
					this.level, this.weight, this.pt);
			childFunctions.add(functionArray[i]);
			functionArray[i].declareVariables(1);

			// create the parameter list with new variables
			String[] functionParameters = new String[2];
			LinkedList<String> takenLetters = new LinkedList<String>();
			for (int j = 0; j < functionParameters.length; j++) {
				String letter = chooseVariable();
				while (variables.containsKey(letter)
						|| takenLetters.contains(letter)
						|| functionArray[i].getVariables().containsKey(letter)) {
					letter = chooseVariable();
				}
				functionParameters[j] = letter;
				takenLetters.add(letter);
			}
			functionArray[i].setParameters(functionParameters);
			functionMap.put(functionName, functionParameters);
		}

		// create first function
		String firstName = "Main";
		FunctionComponent firstFunction = new FunctionComponent(firstName,
				this, this.level, this.weight, this.pt);
		childFunctions.add(firstFunction);
		firstFunction.declareVariables(0);
		functionMap.put(firstName, new String[0]);
		// run main function
		variables.put(testVariable, firstFunction.levelSixMain(functionArray));

		return variables.get(testVariable);
	}

	public int levelSeven() {
		// child function
		FunctionComponent recurser = new FunctionComponent("recurser", this,
				this.level, this.weight, this.pt);
		childFunctions.add(recurser);

		// create the parameter with new variable
		String[] functionParameters = new String[1];
		String letter = chooseVariable();
		while (variables.containsKey(letter)) {
			letter = chooseVariable();
		}
		functionParameters[0] = letter;
		recurser.setParameters(functionParameters);
		functionMap.put(recurser.getName(), functionParameters);

		// create main function
		FunctionComponent recursiveMain = new FunctionComponent("Main", this,
				this.level, this.weight, this.pt);
		childFunctions.add(recursiveMain);
		recursiveMain.declareVariables(0);
		functionMap.put(recursiveMain.getName(), new String[0]);

		// run
		variables.put(testVariable, recursiveMain.levelSevenMain(recurser));

		return variables.get(testVariable);
	}

	public void overrideTestVariable(String newTV){
		testVariable = newTV;
		parentProblem.overrideTestVariable(newTV);
	}
	
	private int determineAmountOfFunctions() {
		if (this.level == 6) {
			return 2;
		}

		if (this.weight > 6) {
			return 2;
		}

		return 1;
	}

	public String getName() {
		return name;
	}

	public ProblemComponent getParent() {
		return parentProblem;
	}

	public LinkedList<FunctionComponent> getChildren() {
		return childFunctions;
	}

	public LinkedList<Line> getLines() {
		return childLines;
	}

	public HashMap<String, Integer> getVariablesDeepCopy() {
		return deepCopyHashMap(variables);
	}

	public HashMap<String, String[]> getFunctionMap() {
		return functionMap;
	}

	public String getTestVariable() {
		return testVariable;
	}
}
