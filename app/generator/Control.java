package generator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.LinkedList;
import java.util.NoSuchElementException;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

public class Control {

	public static void main(String[] args) {
		Question q = Control.run(7, 2, ProblemType.MULTI_CHOICE, "nope");

		System.out.println("after");
		LinkedList<String> afterlines = javaConversion(
				(LinkedList<String>) q.lines, "lols", "doublelol");
		for (int i = 0; i < 100; i++) {
			System.out.println(afterlines.remove(0));
		}

	}

	public static Question run(int level, int weight, ProblemType pt,
			String username) {

		if (weight < 1) {
			weight = 1;
		}

		ProblemComponent problem = new ProblemComponent(level, weight, pt);
		ConverterHtml converter = new ConverterHtml();

		LinkedList<String> question = converter.convertProblem(problem,
				Difficulty.getProblemComponent(pt, level), 2);

		Question returnQuestion = null;
		LinkedList<Integer> spaces = new LinkedList<Integer>();
		LinkedList<String> lines = new LinkedList<String>();

		String current = null;
		try {
			current = question.remove();
		} catch (NoSuchElementException e) {
			current = null;
		}
		while (current != null) {
			int spaceCount = 0;
			while (current.startsWith("%")) {
				spaceCount++;
				current = current.substring(1);
			}
			lines.add(current);
			spaces.add(spaceCount);
			try {
				current = question.remove();

			} catch (NoSuchElementException e) {
				current = null;
			}
		}

		// add question
		if (pt == ProblemType.MULTI_CHOICE) {
			lines.add("What does the function return after finishing exectution?");
		} else {
			lines.add("#" + problem.getCorrectAnswer());

			// write the file out to memory
			File pseudoOutput = new File("temp/" + username + ".txt");
			try {
				PrintWriter writer = new PrintWriter(pseudoOutput);
				for (int i = 0; i < lines.size(); i++) {
					writer.write(lines.get(i) + "\n");
				}
				writer.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			lines.removeLast();
			lines.add("What needs to replace ??? so that the function returns "
					+ problem.getCorrectAnswer());
		}
		spaces.add(0);
		int[] answers = multipleChoiceAnswers(problem);
		returnQuestion = new Question(lines, spaces, answers, problem);
		return returnQuestion;
	}

	public static LinkedList<String> javaConversion(LinkedList<String> pseudo,
			String replacement, String username) {
		LinkedList<String> java = new LinkedList<String>();
		while (pseudo.peek() != null) {
			String line = pseudo.remove();
			System.out.println("fresh " + line);

			line = line.replaceAll("\\?\\?\\?", replacement);

			// change class
			if (line.contains("#")) {
				line = line.substring(1);
			} else if (line.contains("endclass")) {
				line = line.replaceAll("endclass", "}");
			} else if (line.contains("class")) {
				line = "public class " + username + " {";
			}
			// change function
			else if (line.contains("endfunction")) {
				line = line.replaceAll("endfunction", "}");
			} else if (line.contains("function")) {
				line = line.replaceAll("function", "int");
				line = line.replaceAll("var", "int");
				line = line.concat(" {");
			}
			// change if
			else if (line.contains("endif")) {
				line = line.replaceAll("endif", "}");
			} else if (line.contains("if")) {
				line = line.concat(" {");
			} else if (line.contains("endelse")) {
				line = line.replaceAll("endelse", "}");
			} else if (line.contains("else")) {
				line = line.concat(" {");
			}
			// change loop
			else if (line.contains("endfor")) {
				line = line.replaceAll("endfor", "}");
			} else if (line.contains("for")) {
				line = line.replaceAll("for \\( ", "for ( int ");
				line = line.concat(" {");
			}
			// change line
			else if (line.contains("var")) {
				line = line.replaceAll("var", "int");
				line = line.concat(";");
			}
			// change array
			else if (line.contains("arr")) {
				line = line.replaceAll("\\[", " = new int[");
				line = line.replaceAll("arr", "int[]");
				line = line.concat(";");
			}
			// else just a normal line
			else {
				line = line.concat(";");
			}
			java.add(line);
		}
		return java;
	}

	public static int evaluateAnswer(String input, String username) {
		LinkedList<Integer> spaces = new LinkedList<Integer>();
		LinkedList<String> lines = new LinkedList<String>();

		File root = new File("/export/home/mgoddard/CBCWebsite/temp");
		File tmp = new File(root, "/" + username + ".txt");

		// String userInput = readReplacement(problem);
		// int returnedAnswer = runCompilerWithReplacement(input, problem, tmp);

		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(tmp));
			String line;
			while ((line = br.readLine()) != null) {
				int spaceCount = 0;
				while (line.startsWith("\t")) {
					spaceCount++;
					line = line.substring(1);
				}
				lines.add(line);
				spaces.add(spaceCount);
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		int correct = Integer.parseInt(lines.removeLast());
		System.out.println("CORRECT: " + correct);
		for (int i = 0; i < lines.size(); i++) {
			System.out.println(lines.get(i));
		}

		LinkedList<String> javaLines = javaConversion(lines, input, username);

		for (int i = 0; i < javaLines.size(); i++) {
			System.out.println(javaLines.get(i));
		}

		// save javaFile to memory
		File javaOutput = new File("temp/" + username + ".java");
		try {
			PrintWriter writer = new PrintWriter(javaOutput);
			for (int i = 0; i < javaLines.size(); i++) {
				writer.write(javaLines.get(i) + "\n");
			}
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		int recieved = runCompilerWithReplacement(javaOutput);
		/*
		 * try { Files.delete(temp.toPath()); } catch (IOException e1) {
		 * e1.printStackTrace(); }
		 */
		if (correct == recieved) {
			return 1;
		} else {
			return 0;
		}
	}

	private static int runCompilerWithReplacement(File javaText) {

		File root = new File("/export/home/mgoddard/CBCWebsite/temp");

		String fileToCompile = javaText.getPath();
		String className = javaText.getName().replaceAll(".java", "");

		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

		compiler.run(null, null, null, fileToCompile);
		URLClassLoader classLoader;

		Class<?> cls = null;
		Object instance = null;
		Object returnedObject = null;
		try {
			classLoader = URLClassLoader.newInstance(new URL[] { root.toURI()
					.toURL() });
			cls = Class.forName(className, true, classLoader);

			instance = cls.newInstance();
			Object[] empty = new Object[0];
			Method mtd = cls.getDeclaredMethods()[0];
			mtd.setAccessible(true);
			returnedObject = mtd.invoke(instance, empty);
		} catch (InstantiationException e) {
			System.out.println("INSTANTIATION EXCEPTION" + e);
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			System.out.println("ILLEGAL ACCESS EXCEPTION" + e);
			e.printStackTrace();
		} catch (MalformedURLException e) {
			System.out.println("MALFORMED URL EXCPETION " + e);
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("CLASS NOT FOUND EXCEPTION " + e);
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			System.out.println("ILLEGAL ARGUMENT EXCEPTION " + e);
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			System.out.println("INVOKATION TARGET EXCEPTION " + e);
			e.printStackTrace();
		} catch (SecurityException e) {
			System.out.println("SECURITY EXCEPTION " + e);
			e.printStackTrace();
		}

		// instance.getClass();
		int returnedAnswer = (Integer) returnedObject;
		System.out.println("With the inputed answer, the function returns "
				+ returnedAnswer);

		return returnedAnswer;
	}

	private static int[] multipleChoiceAnswers(ProblemComponent problem) {
		int[] returnAnswers = new int[4];
		returnAnswers[0] = problem.getCorrectAnswer();
		returnAnswers[1] = problem.getIncorrect1();
		returnAnswers[2] = problem.getIncorrect2();
		returnAnswers[3] = problem.getIncorrect3();
		return returnAnswers;
	}
}
