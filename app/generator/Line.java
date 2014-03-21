package generator;

import java.util.ArrayList;
import java.util.HashMap;

public class Line extends LogicComponent {
    private Component parentComponent;
	private HashMap<Integer, Object> varValMap;
	private ArrayList<Tokens> tokenList;
	private Boolean isBlank;
	private Boolean isFunctionCall;
	private Boolean isArrayDeclaration;

	public Line(Component parent, Boolean blank) {
		parentComponent = parent;
		isBlank = blank;
		varValMap = new HashMap<Integer, Object>();
		tokenList = new ArrayList<Tokens>();
		isFunctionCall = false;
		isArrayDeclaration = false;
	}

	public void declareVariable(String name, int value) {
		tokenList.add(Tokens.VAR);
		tokenList.add(Tokens.VARIABLE);
		varValMap.put(tokenList.size() - 1, name);
		tokenList.add(Tokens.ASSIGN);
		tokenList.add(Tokens.VALUE);
		varValMap.put(tokenList.size() - 1, value);
	}

	public void declareArray(String name) {
		isArrayDeclaration = true;
		
		tokenList.add(Tokens.ARR);
		tokenList.add(Tokens.VARIABLE);
		varValMap.put(tokenList.size() - 1, name);
	}

	public void declareArrayVariable(String name, int value) {
		tokenList.add(Tokens.VARIABLE);
		varValMap.put(tokenList.size() - 1, name);
		tokenList.add(Tokens.ASSIGN);
		tokenList.add(Tokens.VALUE);
		varValMap.put(tokenList.size() - 1, value);
	}

	public void additionByValue(String name, int value) {
		tokenList.add(Tokens.VARIABLE);
		varValMap.put(tokenList.size() - 1, name);
		tokenList.add(Tokens.ASSIGN);
		tokenList.add(Tokens.VARIABLE);
		varValMap.put(tokenList.size() - 1, name);
		tokenList.add(Tokens.PLUS);
		tokenList.add(Tokens.VALUE);
		varValMap.put(tokenList.size() - 1, value);
	}

	public void additionByVariable(String name1, String name2) {
		tokenList.add(Tokens.VARIABLE);
		varValMap.put(tokenList.size() - 1, name1);
		tokenList.add(Tokens.ASSIGN);
		tokenList.add(Tokens.VARIABLE);
		varValMap.put(tokenList.size() - 1, name1);
		tokenList.add(Tokens.PLUS);
		tokenList.add(Tokens.VALUE);
		varValMap.put(tokenList.size() - 1, name2);
	}

	public void callFunction(String variableName, String functionName,
			String[] parameterList) {
		isFunctionCall = true;
		
		tokenList.add(Tokens.VARIABLE);
		varValMap.put(tokenList.size() - 1, variableName);
		tokenList.add(Tokens.ASSIGN);
		tokenList.add(Tokens.VARIABLE);
		varValMap.put(tokenList.size() - 1, functionName);
		tokenList.add(Tokens.LPAREN);
		// add every parameter
		for (int i = 0; i < parameterList.length; i++) {
			if (i > 0) {
				// add a comma for all parameters after the first
				tokenList.add(Tokens.COMMA);
			}

			tokenList.add(Tokens.VARIABLE);
			varValMap.put(tokenList.size() - 1, parameterList[i]);
		}
		tokenList.add(Tokens.RPAREN);
	}

	public void recursiveAddition(String additional, String functionName,
			String parameter, String decrementer) {
		tokenList.add(Tokens.RETURN);
		tokenList.add(Tokens.VALUE);
		varValMap.put(tokenList.size() - 1, additional);
		tokenList.add(Tokens.PLUS);
		tokenList.add(Tokens.VARIABLE);
		varValMap.put(tokenList.size() - 1, functionName);
		tokenList.add(Tokens.LPAREN);
		tokenList.add(Tokens.VARIABLE);
		varValMap.put(tokenList.size() - 1, parameter);
		tokenList.add(Tokens.MINUS);
		tokenList.add(Tokens.VARIABLE);
		varValMap.put(tokenList.size() - 1, decrementer);
		tokenList.add(Tokens.RPAREN);
	}

	public void returnStatement(String returnVariable) {
		tokenList.add(Tokens.RETURN);
		tokenList.add(Tokens.VARIABLE);
		varValMap.put(tokenList.size() - 1, returnVariable);
	}

	public Component getParent() {
		return parentComponent;
	}

	public HashMap<Integer, Object> getVarValMap() {
		return varValMap;
	}

	public ArrayList<Tokens> getTokenList() {
		return tokenList;
	}

	public Boolean getIsBlank() {
		return isBlank;
	}
	
	public Boolean getIsFunctionCall(){
		return isFunctionCall;
	}
	
	public Boolean getIsArrayDeclaration(){
		return isArrayDeclaration;
	}
}
