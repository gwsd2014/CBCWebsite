package generator;

import java.util.LinkedList;
import java.util.Random;

public class ArithmeticComponent extends LogicComponent {
	private FunctionComponent parentFunction;
	private LinkedList<Line> childLines;
	private Random random;
	
	public ArithmeticComponent(){
		childLines = new LinkedList<Line>();
		random = new Random();
	}
	
	public int createLines(){
		String testVariable = parentFunction.getTestVariable();
		int initialValue = parentFunction.getVariables().get(testVariable);
		int increment = random.nextInt(20);
		
		Line additionLine = new Line();
		childLines.add(additionLine);
		additionLine.setParent(this);
		
		additionLine.addition(testVariable, increment);
		
		int newValue = initialValue + increment;
		return newValue;
	}
	
	public FunctionComponent getParent(){
		return parentFunction;
	}
	
	public void setParent(FunctionComponent FC){
		parentFunction = FC;
	}
	
	public LinkedList<Line> getChildLines(){
		return childLines;
	}
}
