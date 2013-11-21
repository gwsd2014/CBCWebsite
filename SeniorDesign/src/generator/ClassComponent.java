package generator;

import java.util.HashMap;
import java.util.LinkedList;

public class ClassComponent extends Component {
	private String name;
	private ProblemComponent parentProblem;
	private LinkedList<FunctionComponent> childFunctions;
	private Difficulty difficulty;

	private HashMap<String, Integer> variables;

	public ClassComponent(String name, Difficulty diff, ProblemComponent parent) {

		parentProblem = parent;
		difficulty = diff;
		this.name = name;
		this.variables = new HashMap<String, Integer>();
		childFunctions = new LinkedList<FunctionComponent>();
	}

	public int levelOne(){
		FunctionComponent firstFunction = new FunctionComponent("foo",
				difficulty, this);
		childFunctions.add(firstFunction);
		firstFunction.declareVariables();

		int newValue = firstFunction.levelOneLogics();

		return newValue;
	}
	
	public int levelTwo(){
		FunctionComponent firstFunction = new FunctionComponent("foo",
				difficulty, this);
		childFunctions.add(firstFunction);
		firstFunction.declareVariables();

		int newValue = firstFunction.levelTwoLogics();

		return newValue;
	}
	
	public int levelThree(){
		FunctionComponent firstFunction = new FunctionComponent("foo",
				difficulty, this);
		childFunctions.add(firstFunction);
		firstFunction.declareVariables();

		int newValue = firstFunction.levelThreeLogics();

		return newValue;
	}

	public int levelFour(){
		FunctionComponent firstFunction = new FunctionComponent("foo",
				difficulty, this);
		childFunctions.add(firstFunction);
		firstFunction.declareVariables();

		int newValue = firstFunction.levelFourLogics();

		return newValue;
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

	public HashMap<String, Integer> getVariables() {
		return variables;
	}
}
