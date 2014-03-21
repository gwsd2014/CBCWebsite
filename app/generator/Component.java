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

	protected HashMap<String, Integer> deepCopyHashMap(
			HashMap<String, Integer> input) {
		HashMap<String, Integer> copy = new HashMap<String, Integer>();
		Set<String> set = input.keySet();
		for (Iterator<String> i = set.iterator(); i.hasNext();) {
			String variable = i.next();
			copy.put(variable, input.get(variable));
		}

		return copy;
	}

	protected String selectVariable(HashMap<String, Integer> variables) {
		Random rand = new Random();
		
		Iterator<String> variablesIterator = variables.keySet().iterator();
		String randomVariable = variablesIterator.next();
		for (int j = 0; j < rand.nextInt(variables.size()); j++) {
			randomVariable = variablesIterator.next();
		}
		return randomVariable;
	}
}
