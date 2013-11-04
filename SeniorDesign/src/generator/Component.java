package generator;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public abstract class Component {

	protected String chooseVariable() {
		Random r = new Random();
		char c = (char) (r.nextInt(26) + 'a');
		return "" + c;
	}
	
	protected HashMap<String, Integer> deepCopyHashMap(HashMap<String, Integer> input){
		HashMap<String, Integer> copy = new HashMap<String, Integer>();
		Set<String> set = input.keySet();
		for(Iterator<String> i = set.iterator(); i.hasNext();){
			String variable = i.next();
			copy.put(variable, input.get(variable));
		}
		
		return copy;
	}
}
