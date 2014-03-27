package generator;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Iterator;

public class JavaConverter {

    PrintWriter output;
	ComponentTypes removedComponent;
	String userReplacement;
	boolean hasRemoved;

	public JavaConverter() {
		try {
			String clss = JavaConverter.class.getProtectionDomain()
					.getCodeSource().getLocation().getPath();
			//System.out.println("JavaConverter: " + clss);

			output = new PrintWriter("app/generator/javaOutput.java");
		} catch (FileNotFoundException e) {
			System.out.println("FILE NOT FOUND EXCEPTION IN JAVA CONVERTER " + e);
			e.printStackTrace();
		}
	}

	public PrintWriter convertProblem(ProblemComponent problem,
			ComponentTypes removed, String replacement) {

		removedComponent = removed;
		userReplacement = replacement;
		hasRemoved = false;

		for (Iterator<ClassComponent> i = problem.getChildren().iterator(); i
				.hasNext();) {
			convertClass(i.next());
		}

		output.close();
		return output;
	}

	public void convertClass(ClassComponent classComp) {

		ClassLoader cl = ClassLoader.getSystemClassLoader();

		URL[] urls = ((URLClassLoader) cl).getURLs();

		for (URL url : urls) {
			System.out.println(url.getFile());
		}
		output.println("package generator; \n");
		//output.println("import app.generator.simpleInterface; \n");

		output.println("public class javaOutput{");

		for (Iterator<Line> i = classComp.getLines().iterator(); i.hasNext();) {
			convertLine(i.next(), 1);
		}

		output.println();

		for (Iterator<FunctionComponent> i = classComp.getChildren().iterator(); i
				.hasNext();) {
			convertFunction(i.next(), 1);
		}
		output.println("}");
	}

	public void convertFunction(FunctionComponent function, int indentation) {
		String indent = "";
		// add correct value of indentation for every line in this function
		for (int i = 0; i < indentation; i++) {
			indent += "\t";
		}

		output.print(indent + "public int " + function.getName() + " ( ");

		// print all the parameters
		if (function.getParameterList().length > 0) {
			String[] parameters = function.getParameterList();
			for (int i = 0; i < parameters.length; i++) {
				if (i > 0) {
					output.print(", ");
				}
				output.print("int " + parameters[i] + " ");
			}
		}

		output.println(") {");

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

		output.println(indent + "}\n");
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

			// test to see if conditional must be removed
			if (!hasRemoved && removedComponent == ComponentTypes.Conditional) {
				output.println(indent + "if ( " + userReplacement + " ) {");
				hasRemoved = true;
			} else {
				output.println(indent + "if ( " + conditional.getLeftVariable()
						+ " " + tokenConversion(conditional.getComparator())
						+ " " + conditional.getRightValue() + " ) {");
			}
			convertLogic(conditional.getIfComponent(), indentation + 1);

			output.println(indent + "}");
			output.println(indent + "else {");

			convertLogic(conditional.getElseComponent(), indentation + 1);

			output.println(indent + "}");
		}

		// Loop
		if (logic instanceof LoopComponent) {
			LoopComponent loop = (LoopComponent) logic;
			if (loop.isForLoop()) {

				// print test statement
				String loopStatement = indent + "for ( int "
						+ loop.getLeftVariable() + " = " + loop.getRightValue()
						+ " ; " + loop.getLeftVariable() + " "
						+ tokenConversion(loop.getComparator()) + " "
						+ loop.getForLoopTestValue() + " ; "
						+ loop.getLeftVariable() + " "
						+ tokenConversion(loop.getForLoopIncrementor())
						+ " ) {";
				if (!hasRemoved && removedComponent == ComponentTypes.Loop) {
					loopStatement = loopStatement.replaceFirst("\\?\\?\\?",
							userReplacement);
					hasRemoved = true;
				}

				output.println(loopStatement);

				// print the logic within the loop
				for (Iterator<LogicComponent> i = loop.getChildLogics()
						.iterator(); i.hasNext();) {
					convertLogic(i.next(), indentation + 1);
				}

				output.println(indent + "}");

			} else {
				// print test statement
				output.println(indent + "while ( " + loop.getLeftVariable()
						+ " " + tokenConversion(loop.getComparator()) + " "
						+ loop.getRightValue() + " ) {");

				// print the logic within the loop
				for (Iterator<LogicComponent> i = loop.getChildLogics()
						.iterator(); i.hasNext();) {
					convertLogic(i.next(), indentation + 1);
				}

				output.println(indent + "}");
			}

		}

		// line
		if (logic instanceof Line) {
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
				if (line.getIsFunctionCall()
						&& removedComponent == ComponentTypes.Function
						&& !hasRemoved && counter > 3) {
					// remove the variable and replace with ???
					output.print(userReplacement);
					hasRemoved = true;
				} else if (line.getIsArrayDeclaration()) {
					// make exception for array declaration
					if (line.getIsArrayDeclaration()) {
						String array = (String) line.getVarValMap()
								.get(counter);
						output.print(array.charAt(0) + " = new int["
								+ array.charAt(2) + "]");
					}
				} else {
					output.print(line.getVarValMap().get(counter));
				}
			} else
				output.print(tokenConversion(token));

			if (i.hasNext()) {
				output.print(" ");
			}
		}
		output.print(";");
		output.println();
	}

	private String tokenConversion(Tokens token) {
		switch (token) {
		case ARR:
			return "int[]";
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
			return "int";
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
