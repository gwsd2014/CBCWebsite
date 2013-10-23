package generator;

import java.util.HashMap;
import java.util.LinkedList;

public class FunctionComponent extends Component {
	private String name;
	private ClassComponent parentClass;
	
	private LinkedList<LogicComponent> childLogics;
	private LinkedList<Line> childLines;
	private String testVariable;
	private HashMap<String, Integer> variables;
	
	public FunctionComponent(String name){
		this.name = name;
		variables = new HashMap<String, Integer>();
		childLines = new LinkedList<Line>();
		childLogics = new LinkedList<LogicComponent>();
	}
	
	//create declaration
	public void declareVariables(){
		testVariable = parentClass.getParent().getTestVariable();
		Line decl = new Line();
		childLines.add(decl);
		decl.setParent(this);
		decl.declareVariable(testVariable, 0);
		variables.put(testVariable, 0);
	}
	
	//create rest of function
	public int createLogics(){
		ArithmeticComponent firstArith = new ArithmeticComponent();
		childLogics.add(firstArith);
		firstArith.setParent(this);
		
		int newValue = firstArith.createLines();
		variables.put(testVariable, newValue);
		
		return newValue;
	}
	
	public String getName(){
		return name;
	}
	
	public ClassComponent getParent(){
		return parentClass;
	}
	
	public void setParent(ClassComponent CC){
		parentClass = CC;
	}
	
	public LinkedList<LogicComponent> getChildLogics(){
		return childLogics;
	}
	
	public LinkedList<Line> getChildLines(){
		return childLines;
	}
	
	public String getTestVariable(){
		return testVariable;
	}
	
	public HashMap<String, Integer> getVariables(){
		return variables;
	}
}
