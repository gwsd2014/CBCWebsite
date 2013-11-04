package generator;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.util.Set;

public class ArithmeticComponent extends LogicComponent {
	private Component parentComponent;
	private LinkedList<Line> childLines;
	private Random random;
	private Difficulty difficulty;

	public ArithmeticComponent(Difficulty diff, Component parent) {
		parentComponent = parent;
		difficulty = diff;
		childLines = new LinkedList<Line>();
		random = new Random();
	}

	public HashMap<String, Integer> createLines(
			HashMap<String, Integer> parentMap, String testVariable) {

		HashMap<String, Integer> currentMap = parentMap;

		// create a random amount of arithmetic operations, depending on the
		// difficulty weight, maximum 5
		for (int i = 0; i < difficulty.getWeight() && i < 5; i++) {

			// if it is the final line, make sure to modify the test variable
			// one more time, else randomly choose another variable to modify
			String leftVariable = testVariable;
			if (i < difficulty.getWeight() - 1) {
				Iterator<String> leftSideIterator = currentMap.keySet()
						.iterator();
				leftVariable = leftSideIterator.next();
				for (int j = 0; j < random.nextInt(currentMap.size()); j++) {
					leftVariable = leftSideIterator.next();
				}
			}

			// randomly decide whether to add by value or by variable
			if (random.nextGaussian() < 0) {
				// adding by value

				int previousValue = currentMap.get(leftVariable);

				int increment = random.nextInt(20) - 10;

				Line additionLine = new Line(this, false);
				childLines.add(additionLine);

				// create addition line, and change the value in the variable
				// map
				additionLine.additionByValue(leftVariable, increment);
				currentMap.put(leftVariable, previousValue + increment);
			} else {
				// adding by variable

				int previousValue = currentMap.get(leftVariable);

				// randomly choose a variable to adjust by (this really works)
				Iterator<String> variablesIterator = currentMap.keySet()
						.iterator();
				String randomVariable = variablesIterator.next();
				for (int j = 0; j < random.nextInt(currentMap.size()); j++) {
					randomVariable = variablesIterator.next();
				}

				Line additionLine = new Line(this, false);
				childLines.add(additionLine);

				// create addition line, and change the value in the variable
				// map
				additionLine.additionByVariable(leftVariable, randomVariable);
				currentMap.put(leftVariable,
						previousValue + currentMap.get(randomVariable));
			}

		}
		return currentMap;
	}

	public Component getParent() {
		return parentComponent;
	}

	public LinkedList<Line> getChildLines() {
		return childLines;
	}
}
