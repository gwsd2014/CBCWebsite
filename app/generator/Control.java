package generator;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

public class Control {

	public static void main(String[] args) {
		Question q = Control.run(6, 12, ProblemType.MULTI_CHOICE);
		List<String> lines = q.lines;
		for (int i = 0; i < lines.size(); i++) {
			System.out.println(lines.remove(0));
		}
	}

	public static Question run(int level, int weight, ProblemType pt) {

		if (weight < 1) {
			weight = 1;
		}

		ProblemComponent problem = new ProblemComponent(level, weight, pt);
		ConverterHtml converter = new ConverterHtml();

		LinkedList<String> question = converter.convertProblem(problem,
				Difficulty.getProblemComponent(pt, level), weight);

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

		int[] answers = new int[4];
		if (pt == ProblemType.MULTI_CHOICE) {
			lines.add("What does the above function return after finishing execution?");
			spaces.add(0);
			answers = setAnswers(problem.getCorrectAnswer());
		} else {
			lines.add("What value must be inserted into the ??? so that the function returns "
					+ problem.getCorrectAnswer());
			spaces.add(0);
			answers = setAnswers(converter.getCorrectAnswer());
		}

		Question returnQuestion = new Question(lines, spaces, answers);

		return returnQuestion;
	}

	private static int runCompilerWithReplacement(String replacement,
			ProblemComponent problem, File temp) {

		URL Url = ((URLClassLoader) (Thread.currentThread()
				.getContextClassLoader())).getURLs()[0];

		try {
			System.out.println("path: " + Url.toURI().toString());
		} catch (URISyntaxException e1) {
			System.out.println("e in conversion: " + e1);
			e1.printStackTrace();
		}

		System.out.println("control path: " + temp.getPath());
		System.out.println("name: " + temp.getName());

		JavaConverter javaConverter = new JavaConverter();
		javaConverter.convertProblem(problem,
				Difficulty.getProblemComponent(ProblemType.FILL_BLANK, 2),
				replacement, temp);

		File root = new File("/export/home/mgoddard/CBCWebsite/temp");
		File sourceFile = new File(root, "javaOutput.java");

		String fileToCompile = temp.getPath();
		String className = temp.getName().replaceAll(".java", "");

		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

		System.out.println("Working Directory = "
				+ System.getProperty("user.dir"));
		System.out.println("compiling");

		compiler.run(null, null, null, fileToCompile);
		System.out.println("finished");
		URLClassLoader classLoader;

		Class<?> cls = null;
		simpleInterface instance = null;
		try {
			classLoader = URLClassLoader.newInstance(new URL[] { root.toURI()
					.toURL() });
			cls = Class.forName(className, true, classLoader);

			instance = (simpleInterface) cls.newInstance();
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
		}
		int returnedAnswer = 2;
		// int returnedAnswer = instance.Main();
		System.out.println("With the inputed answer, the function returns "
				+ returnedAnswer);
		/*
		 * try { Files.delete(sourceFile.toPath()); } catch (IOException e1) {
		 * // TODO // Auto-generated catch block e1.printStackTrace(); }
		 */
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

	private static int[] setAnswers(int correctAnswer) {
		Random rand = new Random();
		int[] retAnswers = new int[4];
		retAnswers[0] = correctAnswer;
		// now create the incorrect answers

		retAnswers[1] = correctAnswer + 1;

		retAnswers[2] = correctAnswer * 2;
		if (retAnswers[2] == 0 || retAnswers[2] == retAnswers[1]) {
			retAnswers[2] = -1;
		}

		retAnswers[3] = (rand.nextInt(100) - 50);
		while (retAnswers[3] == correctAnswer || retAnswers[3] == retAnswers[1]
				|| retAnswers[3] == retAnswers[2]) {
			retAnswers[3] = (rand.nextInt(100) - 50);
		}
		return retAnswers;
	}

}
