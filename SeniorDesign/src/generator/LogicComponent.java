package generator;

import java.util.HashMap;

public abstract class LogicComponent extends Component {

	public HashMap<String, Integer> createLines(
			HashMap<String, Integer> parentMap, String testVariable) {
			return parentMap;
	}

	public HashMap<String, Integer> runLines(HashMap<String, Integer> parentMap){
		return null;
	}
	
}
