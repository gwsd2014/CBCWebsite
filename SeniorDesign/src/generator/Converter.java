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
			System.out.println("Fialed");
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

		output.println(indent + "function " + function.getName() + " ( )");

		// print the variable declarations at the top of the function
		for (Iterator<Line> i = function.getChildLines().iterator(); i
				.hasNext();) {
			convertLine(i.next(), indentation + 1);
		}

		// print the arithmetic
		for (Iterator<LogicComponent> i = function.getChildLogics().iterator(); i
				.hasNext();) {
			convertLogic(i.next(), indentation + 1);
		}

		output.println(indent + "endfunction");
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

		// Loop
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
		case ENDCLASS:
			return "endclass";
		case ENDFUNCTION:
			return "endfunction";
		case FUNCTION:
			return "function";
		case ID:
			// TODO ERROR STATEMENT
			break;
		case LPAREN:
			return "(";
		case MINUS:
			return "-";
		case PLUS:
			return "+";
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
		case WS:
			// TODO ERROR STATEMENT
			break;
		}
		// TODO ERROR STATEMENT
		return "Token not found";
	}
}
