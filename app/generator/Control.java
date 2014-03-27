package generator;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.util.LinkedList;
import java.util.NoSuchElementException;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

public class Control {

    public static Question run(int level, int weight, ProblemType pt) {

		if (weight < 1) {
			weight = 1;
		}

		ProblemComponent problem = new ProblemComponent(level, weight, pt);
		ConverterHtml converter = new ConverterHtml();

		LinkedList<String> question = converter.convertProblem(problem,
				ComponentTypes.None, 2);

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

		Question returnQuestion = null;

		if (pt == ProblemType.MULTI_CHOICE) {
			int[] answers = multipleChoiceAnswers(problem);
			returnQuestion = new Question(lines, spaces, answers);
		} else { // else do fill in the blank
			String userInput = readReplacement(problem);
			int returnedAnswer = runCompilerWithReplacement("2 == 2", problem);
			if (returnedAnswer == problem.getCorrectAnswer()) {
				int[] yes = { 1, 1, 1, 1 };
				returnQuestion = new Question(lines, spaces, yes);
			} else {
				int[] no = { 0, 0, 0, 0 };
				returnQuestion = new Question(lines, spaces, no);
			}
		}

		return returnQuestion;
	}

	private static int runCompilerWithReplacement(String replacement,
			ProblemComponent problem) {

		String clss = Control.class.getProtectionDomain().getCodeSource()
				.getLocation().getPath();
		System.out.println("Control: " + clss);

		JavaConverter javaConverter = new JavaConverter();
		javaConverter.convertProblem(problem,
				Difficulty.getProblemComponent(ProblemType.FILL_BLANK, 2),
				replacement);

		File root = new File("/app");
		File sourceFile = new File("app/generator/javaOutput.java");

		String fileToCompile = sourceFile.getPath();
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

		compiler.run(null, null, null, fileToCompile);

		File destinationFile = new File(root, "/generator/");
		System.out.println("destSTring " + destinationFile.getPath());
		URLClassLoader classLoader;
		Class<?> cls;
		simpleInterface instance = null;
		try {
			classLoader = URLClassLoader.newInstance(new URL[] { root.toURI()
					.toURL() });
			cls = Class.forName("generator.javaOutput", true, classLoader);
			instance = (simpleInterface) cls.newInstance();
		} catch (ClassNotFoundException e) { // TODO
			System.out.println("CLASS NOT FOUND EXCEPTION IN CONTROL " + e);
			e.printStackTrace();
		} catch (InstantiationException e) { // TODO
			System.out.println("INSTANTIATION EXCEPTION" + e);
			e.printStackTrace();
		} catch (IllegalAccessException e) { // TODO
			System.out.println("ILLEGAL ACCESS EXCEPTION" + e);
			e.printStackTrace();
		} catch (MalformedURLException e) {
			System.out.println("MALFORMED URL EXCPETION " + e);
			e.printStackTrace();
		}

		int returnedAnswer = instance.Main();
		System.out.println("With the inputed answer, the function returns "
				+ returnedAnswer);

		try {
			Files.delete(sourceFile.toPath());
		} catch (IOException e1) { // TODO
			// Auto-generated catch block
			e1.printStackTrace();
		}

		return returnedAnswer;
	}

	private static String readReplacement(ProblemComponent problem) {
		System.out
				.println("What should be placed into the ??? such that Main returns "
						+ problem.getCorrectAnswer());
		String line = null;
		/*
		 * try { line = br.readLine(); } catch (IOException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		return line;
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
