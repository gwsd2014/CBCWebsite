package generator;

import java.util.HashMap;
import java.util.LinkedList;

public class ClassComponent extends Component {
	private String name;
	private ProblemComponent parentProblem;
	private LinkedList<FunctionComponent> childFunctions;
	
	private HashMap<String, Integer> variables;
	
	public ClassComponent(String name){
		this.name = name;
		this.variables = new HashMap<String, Integer>();
		childFunctions = new LinkedList<FunctionComponent>();
	}
	
	
	//create functions
	public int createFunctions(){
		FunctionComponent firstFunction = new FunctionComponent("foo");
		firstFunction.setParent(this);
		childFunctions.add(firstFunction);
		firstFunction.declareVariables();
		
		int newValue = firstFunction.createLogics();
		
		return newValue;
	}
	
	public String getName(){
		return name;
	}
	
	public ProblemComponent getParent(){
		return parentProblem;
	}
	
	public void setParent(ProblemComponent PC){
		parentProblem = PC;
	}
	
	public LinkedList<FunctionComponent> getChildren(){
		return childFunctions;
	}
	
	public HashMap<String, Integer> getVariables(){
		return variables;
	}
}
