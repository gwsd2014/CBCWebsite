package generator;

import java.util.ArrayList;
import java.util.HashMap;

public class Line{
	private Component parentComponent;
	private HashMap<Integer, Object> varValMap;
	private ArrayList<Tokens> tokenList;
	
	public Line(){
		varValMap = new HashMap<Integer, Object>();
		tokenList = new ArrayList<Tokens>();
	}
	
	public void declareVariable(String name, int value){
		tokenList.add(Tokens.VAR);
		tokenList.add(Tokens.VARIABLE);
		varValMap.put(tokenList.size() - 1, name);
		tokenList.add(Tokens.ASSIGN);
		tokenList.add(Tokens.VALUE);
		varValMap.put(tokenList.size() - 1, value);
	}
	
	public void addition(String name, int value){
		tokenList.add(Tokens.VARIABLE);
		varValMap.put(tokenList.size() - 1, name);
		tokenList.add(Tokens.ASSIGN);
		tokenList.add(Tokens.VARIABLE);
		varValMap.put(tokenList.size() - 1, name);
		tokenList.add(Tokens.PLUS);
		tokenList.add(Tokens.VALUE);
		varValMap.put(tokenList.size() - 1, value);
	}
	
	public Component getParent(){
		return parentComponent;
	}
	
	public void setParent(Component C){
		parentComponent = C;
	}
	
	public HashMap<Integer, Object> getVarValMap(){
		return varValMap;
	}
	
	public ArrayList<Tokens> getTokenList(){
		return tokenList;
	}
}
