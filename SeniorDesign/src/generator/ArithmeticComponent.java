package generator;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class ArithmeticComponent extends LogicComponent {
	private Component parentComponent;
	private LinkedList<Line> childLines;
	private Random random;
	private Difficulty difficulty;

	private final int range;

	public ArithmeticComponent(Difficulty diff, Component parent) {
		parentComponent = parent;
		difficulty = diff;
		childLines = new LinkedList<Line>();
		random = new Random();

		if (difficulty.getLevel() == 1) {
			range = 20;
		} else {
			range = 6;
		}
	}

	public HashMap<String, Integer> createLines(
			HashMap<String, Integer> parentMap, String testVariable) {
		HashMap<String, Integer> currentMap = parentMap;

		// create a random amount of arithmetic operations, depending on the
		// difficulty weight, maximum 5

		int lines = determineAmountOfLines();

		for (int i = 0; i < lines; i++) {
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

			if (parentComponent instanceof LoopComponent
					&& difficulty.getLevel() == 4) {
				leftVariable = testVariable;
			}

			// randomly decide whether to add by value or by variable
			if (random.nextGaussian() < 0) {
				// adding by value

				int previousValue = currentMap.get(leftVariable);

				int increment = random.nextInt(range) - range / 2;

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

	public HashMap<String, Integer> runLines(HashMap<String, Integer> parentMap) {

		HashMap<String, Integer> tempMap = parentMap;

		// loop through child lines
		for (int i = 0; i < childLines.size(); i++) {
			// extract the variable being changed
			HashMap<Integer, Object> lineVariables = childLines.get(i)
					.getVarValMap();
			String modifiedVariable = (String) lineVariables.get(0);

			// determine the new values of the two right hand values/variables
			Object firstValue = lineVariables.get(2);
			if (firstValue instanceof String) {
				firstValue = tempMap.get(firstValue);
			}

			Object secondValue = lineVariables.get(4);
			if (secondValue instanceof String) {
				secondValue = tempMap.get(secondValue);
			}

			// change the variable value
			int currentValue = tempMap.get(modifiedVariable);
			int newValue = (Integer) firstValue + (Integer) secondValue;

			tempMap.put(modifiedVariable, newValue);
		}
		return tempMap;
	}

	private int determineAmountOfLines() {
		// cap fill in the blanks at 1
		if (difficulty.getProblemType() == ProblemType.FILL_BLANK) {
			return 1;
		}

		int lines = difficulty.getWeight();

		if (difficulty.getLevel() == 4) {
			lines = 1;
		}

		if (difficulty.getLevel() == 5) {
			lines = 2;
		}

		if (difficulty.getLevel() == 6) {
			lines = 2;
		}

		return lines;
	}

	public Component getParent() {
		return parentComponent;
	}

	public LinkedList<Line> getChildLines() {
		return childLines;
	}
}
