package generator;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Iterator;

public class Converter {

	PrintWriter output;

	public Converter() {
		try {
			output = new PrintWriter("src/output.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Failed");
			e.printStackTrace();
		}
	}

	public PrintWriter convertProblem(ProblemComponent problem) {
		for (Iterator<ClassComponent> i = problem.getChildren().iterator(); i
				.hasNext();) {
			convertClass(i.next());
		}

		output.close();
		return output;
	}

	public void convertClass(ClassComponent classComp) {
		output.println("class " + classComp.getName());

		for (Iterator<Line> i = classComp.getLines().iterator(); i.hasNext();) {
			convertLine(i.next(), 1);
		}

		output.println();

		for (Iterator<FunctionComponent> i = classComp.getChildren().iterator(); i
				.hasNext();) {
			convertFunction(i.next(), 1);
		}
		output.println("endclass");
	}

	public void convertFunction(FunctionComponent function, int indentation) {
		String indent = "";
		// add correct value of indentation for every line in this function
		for (int i = 0; i < indentation; i++) {
			indent += "\t";
		}

		output.print(indent + "function " + function.getName() + " ( ");

		// print all the parameters
		if (function.getParameterList().length > 0) {
			String[] parameters = function.getParameterList();
			for (int i = 0; i < parameters.length; i++) {
				if (i > 0) {
					output.print(", ");
				}
				output.print("var " + parameters[i] + " ");
			}
		}

		output.println(")");	

		// print the children
		for (Iterator<LogicComponent> i = function.getChildren().iterator(); i
				.hasNext();) {
			Component comp = i.next();
			if( comp instanceof LogicComponent){
				convertLogic((LogicComponent)comp, indentation + 1);
			}else{
				convertLine((Line) comp, indentation + 1);
			}
		}

		output.println(indent + "endfunction\n");
	}

	public void convertLogic(LogicComponent logic, int indentation) {
		String indent = "";
		// add correct value of indentation for every line in this function
		for (int i = 0; i < indentation; i++) {
			indent += "\t";
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
			output.println(indent + "if ( " + conditional.getLeftVariable()
					+ " " + tokenConversion(conditional.getComparator()) + " "
					+ conditional.getRightValue() + " )");

			convertLogic(conditional.getIfComponent(), indentation + 1);

			output.println(indent + "endif");
			output.println(indent + "else");

			convertLogic(conditional.getElseComponent(), indentation + 1);

			output.println(indent + "endelse");
		}

		// Loop
		if (logic instanceof LoopComponent) {
			LoopComponent loop = (LoopComponent) logic;
			if (loop.isForLoop()) {
				// print test statement
				output.println(indent + "for ( " + loop.getLeftVariable()
						+ " = " + loop.getRightValue() + " ; "
						+ loop.getLeftVariable() + " "
						+ tokenConversion(loop.getComparator()) + " "
						+ loop.getForLoopTestValue() + " ; "
						+ loop.getLeftVariable() + " "
						+ tokenConversion(loop.getForLoopIncrementor()) + " )");

				// print the logic within the loop
				for (Iterator<LogicComponent> i = loop.getChildLogics()
						.iterator(); i.hasNext();) {
					convertLogic(i.next(), indentation + 1);
				}

				output.println(indent + "endfor");

			} else {
				// print test statement
				output.println(indent + "while ( " + loop.getLeftVariable()
						+ " " + tokenConversion(loop.getComparator()) + " "
						+ loop.getRightValue() + " ) ");

				// print the logic within the loop
				for (Iterator<LogicComponent> i = loop.getChildLogics()
						.iterator(); i.hasNext();) {
					convertLogic(i.next(), indentation + 1);
				}

				output.println(indent + "endwhile");
			}

		}
		
		//line
		if(logic instanceof Line){
			convertLine((Line) logic, indentation);
		}
	}

	public void convertLine(Line line, int indentation) {
		if (line.getIsBlank()) {
			output.print("\n");
			return;
		}

		String indent = "";
		// add correct value of indentation for every line in this function
		for (int i = 0; i < indentation; i++) {
			indent += "\t";
		}
		output.print(indent);

		// keep track of where you are in ArrayList
		int counter = -1;
		for (Iterator<Tokens> i = line.getTokenList().iterator(); i.hasNext();) {
			counter++;

			Tokens token = i.next();
			if (token.toString().compareTo("VARIABLE") == 0
					|| token.toString().compareTo("VALUE") == 0) {
				output.print(line.getVarValMap().get(counter) + " ");
			} else
				output.print(tokenConversion(token) + " ");
		}
		output.println();
	}

	private String tokenConversion(Tokens token) {
		switch (token) {
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
		case LPAREN:
			return "(";
		case MINUS:
			return "-";
		case PLUS:
			return "+";
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
