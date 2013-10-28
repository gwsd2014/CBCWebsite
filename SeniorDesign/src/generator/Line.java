package generator;

import java.util.ArrayList;
import java.util.HashMap;

public class Line {
	private Component parentComponent;
	private HashMap<Integer, Object> varValMap;
	private ArrayList<Tokens> tokenList;
	private Boolean isBlank;

	public Line(Component parent, Boolean blank) {
		parentComponent = parent;
		isBlank = blank;
		varValMap = new HashMap<Integer, Object>();
		tokenList = new ArrayList<Tokens>();
	}

	public void declareVariable(String name, int value) {
		tokenList.add(Tokens.VAR);
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
}
