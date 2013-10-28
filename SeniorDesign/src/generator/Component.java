package generator;

import java.util.Random;

public abstract class Component {

	protected String chooseVariable() {
		Random r = new Random();
		char c = (char) (r.nextInt(26) + 'a');
		return "" + c;
	}
}
