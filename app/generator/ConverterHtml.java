package generator;

import java.util.Iterator;
import java.util.LinkedList;

public class ConverterHtml {

	StringBuilder builder;
	LinkedList<String> list;
	ComponentTypes removedComponent;
	boolean hasRemoved;
	int weight;
	String blankAnswer;

	public ConverterHtml() {
		builder = new StringBuilder();
		list = new LinkedList<String>();
	}

	public LinkedList<String> convertProblem(ProblemComponent problem,
			ComponentTypes removed, int problemWeight) {
		removedComponent = removed;
		hasRemoved = false;
		weight = problemWeight;

		for (Iterator<ClassComponent> i = problem.getChildren().iterator(); i
				.hasNext();) {
			convertClass(i.next());
		}

		return list;
	}

	private void newLine() {
		list.add(builder.toString());
		builder.delete(0, builder.length());
	}

	public void convertClass(ClassComponent classComp) {
		builder.append("class " + classComp.getName());
		newLine();

		for (Iterator<Line> i = classComp.getLines().iterator(); i.hasNext();) {
			convertLine(i.next(), 1);
		}
		if (!classComp.getLines().isEmpty()) {
			newLine();
		}
		for (Iterator<FunctionComponent> i = classComp.getChildren().iterator(); i
				.hasNext();) {
			convertFunction(i.next(), 1);
		}
		builder.append("endclass");
		newLine();
	}

	public void convertFunction(FunctionComponent function, int indentation) {
		String indent = "";
		// add correct value of indentation for every line in this function
		for (int i = 0; i < indentation; i++) {
			indent += "%";
		}

		builder.append(indent + "function " + function.getName() + " ( ");

		// print all the parameters
		if (function.getParameterList().length > 0) {
			String[] parameters = function.getParameterList();
			for (int i = 0; i < parameters.length; i++) {
				if (i > 0) {
					builder.append(", ");
				}
				builder.append("var " + parameters[i] + " ");
			}
		}

		builder.append(")");
		newLine();

		// print the children
		for (Iterator<LogicComponent> i = function.getChildren().iterator(); i
				.hasNext();) {
			Component comp = i.next();
			if (comp instanceof LogicComponent) {
				convertLogic((LogicComponent) comp, indentation + 1);
			} else {
				convertLine((Line) comp, indentation + 1);
			}
		}

		builder.append(indent + "endfunction");
		newLine();
	}

	public void convertLogic(LogicComponent logic, int indentation) {
		String indent = "";
		// add correct value of indentation for every line in this function
		for (int i = 0; i < indentation; i++) {
			indent += "%";
		}

		// Arithmetic
		if (logic instanceof ArithmeticComponent) {
			for (Iterator<Line> i = ((ArithmeticComponent) logic)
					.getChildLines().iterator(); i.hasNext();) {
				convertLine(i.next(), indentation);
			}
		}

		// Conditional
		if (logic instanceof ConditionalComponent) {

			// print test statement
			ConditionalComponent conditional = (ConditionalComponent) logic;
			if (!hasRemoved && removedComponent == ComponentTypes.Conditional) {
				builder.append(indent + "if ( ??? )");
				newLine();
				hasRemoved = true;
				System.out.println("Expected answer: "
						+ conditional.getLeftVariable() + " "
						+ tokenConversion(conditional.getComparator()) + " "
						+ conditional.getRightValue());
			} else {
				builder.append(indent + "if ( " + conditional.getLeftVariable()
						+ " " + tokenConversion(conditional.getComparator())
						+ " " + conditional.getRightValue() + " )");
				newLine();
			}
			convertLogic(conditional.getIfComponent(), indentation + 1);

			builder.append(indent + "else");
			newLine();

			convertLogic(conditional.getElseComponent(), indentation + 1);

			builder.append(indent + "endelse");
			newLine();
		}

		// Loop
		if (logic instanceof LoopComponent) {
			LoopComponent loop = (LoopComponent) logic;
			// insert ??? if needed
			if (!hasRemoved && removedComponent == ComponentTypes.Loop) {
				// remove different components based on weight
				loop.replacePiece();
				hasRemoved = true;
			}
			// print test statement
			builder.append(indent + "for ( " + loop.getLeftVariable() + " = "
					+ loop.getRightValue() + " ; " + loop.getLeftVariable()
					+ " " + tokenConversion(loop.getComparator()) + " "
					+ loop.getForLoopTestValue() + " ; "
					+ loop.getLeftVariable() + " "
					+ tokenConversion(loop.getForLoopIncrementor()) + " )");
			newLine();

			// print the logic within the loop
			for (Iterator<LogicComponent> i = loop.getChildLogics().iterator(); i
					.hasNext();) {
				convertLogic(i.next(), indentation + 1);
			}

			builder.append(indent + "endfor");
			newLine();

		}

		// line
		if (logic instanceof Line) {
			convertLine((Line) logic, indentation);
		}
	}

	public void convertLine(Line line, int indentation) {
		if (line.getIsBlank()) {
			// do nothing
			// newLine();
			return;
		}

		String indent = "";
		// add correct value of indentation for every line in this function
		for (int i = 0; i < indentation; i++) {
			indent += "%";
		}
		builder.append(indent);

		// keep track of where you are in ArrayList
		int counter = -1;
		for (Iterator<Tokens> i = line.getTokenList().iterator(); i.hasNext();) {
			counter++;

			Tokens token = i.next();
			if (token.toString().compareTo("VARIABLE") == 0
					|| token.toString().compareTo("VALUE") == 0) {
				if (line.getIsFunctionCall()
						&& removedComponent == ComponentTypes.Function
						&& !hasRemoved && counter > 3) {
					// remove the variable and replace with ???
					builder.append("??? ");
					hasRemoved = true;
					System.out.println("Expected answer: "
							+ line.getVarValMap().get(counter));
				} else {
					builder.append(line.getVarValMap().get(counter) + " ");
				}
			} else
				builder.append(tokenConversion(token) + " ");
		}
		newLine();
	}

	private String tokenConversion(Tokens token) {
		switch (token) {
		case ARR:
			return "arr";
		case ASSIGN:
			return "=";
		case CLASS:
			return "class";
		case COMMA:
			return ",";
		case DIGIT:
			// TODO ERROR STATEMENT
			break;
		case ELSE:
			return "else";
		case ENDCLASS:
			return "endclass";
		case ENDELSE:
			return "endelse";
		case ENDFUNCTION:
			return "endfunction";
		case ENDIF:
			return "endif";
		case ENDWHILE:
			return "endwhile";
		case EQUALS:
			return "==";
		case FUNCTION:
			return "function";
		case ID:
			// TODO ERROR STATEMENT
			break;
		case IF:
			return "if";
		case LBRACK:
			return "[";
		case LPAREN:
			return "(";
		case MINUS:
			return "-";
		case PLUS:
			return "+";
		case QUESTIONS:
			return "???";
		case RBRACK:
			return "]";
		case RETURN:
			return "return";
		case RPAREN:
			return ")";
		case SLASH:
			return "/";
		case STAR:
			return "*";
		case VALUE:
			// TODO ERROR STATEMENT
			break;
		case VAR:
			return "var";
		case VARIABLE:
			// TODO ERROR STATEMENT
			break;
		case WHILE:
			return "while";
		case WS:
			// TODO ERROR STATEMENT
			break;
		case DECREASE:
			return "--";
		case ENDFOR:
			return "endfor";
		case FOR:
			return "for";
		case GT:
			return ">";
		case GTE:
			return ">=";
		case INCREASE:
			return "++";
		case LT:
			return "<";
		case LTE:
			return "<=";
		case SEMICOLON:
			return ";";
		}
		// TODO ERROR STATEMENT
		return "Token not found";
	}
}
