package generator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

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
		int[] answers = multipleChoiceAnswers(problem);
		returnQuestion = new Question(lines, spaces, answers, problem);
		return returnQuestion;
	}
	
	public static int evaluateAnswer(String input, ProblemComponent problem){
		Question returnQuestion = null;
		LinkedList<Integer> spaces = new LinkedList<Integer>();
		LinkedList<String> lines = new LinkedList<String>();
		
		File tmp = null; // create random file name
		try {
			File root = new File("/export/home/mgoddard/CBCWebsite/temp");
			tmp = File.createTempFile("FIB", ".java", root);
		} catch (IOException e) {
			System.out.println("IOEXCPETION " + e);
			e.printStackTrace();
		}

		String userInput = readReplacement(problem);
		int returnedAnswer = runCompilerWithReplacement(input, problem, tmp);

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

		if (returnedAnswer == problem.getCorrectAnswer()) {
			return 1;
		} else {
			return 0;
		}

		/*
		 * try { Files.delete(temp.toPath()); } catch (IOException e1) {
		 * e1.printStackTrace(); }
		 */
	
		
	}

	private static int runCompilerWithReplacement(String replacement,
			ProblemComponent problem, File temp) {

		JavaConverter javaConverter = new JavaConverter();
		javaConverter.convertProblem(problem,
				Difficulty.getProblemComponent(ProblemType.FILL_BLANK, 2),
				replacement, temp);

		File root = new File("/export/home/mgoddard/CBCWebsite/temp");

		String fileToCompile = temp.getPath();
		String className = temp.getName().replaceAll(".java", "");

		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

		compiler.run(null, null, null, fileToCompile);
		System.out.println("finished");
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
			returnedObject = cls.getDeclaredMethods()[0]
					.invoke(instance, empty);
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

		instance.getClass();
		int returnedAnswer = (Integer) returnedObject;
		System.out.println("With the inputed answer, the function returns "
				+ returnedAnswer);

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
