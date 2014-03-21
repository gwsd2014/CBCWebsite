package generator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Control {

    private static Difficulty DM;
	private BufferedReader br;

	public Control() {
		// this.DM = new Difficulty(4, ProblemType.MULTI_CHOICE, 2);
		// this.DM = new Difficulty(3, ProblemType.FILL_BLANK, 1);
		this.br = new BufferedReader(new InputStreamReader(System.in));
	}

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

		int[] answers = multipleChoiceAnswers(problem);

		Question returnQuestion = new Question(lines, spaces, answers);

		return returnQuestion;
		/*
		 * if (DM.getProblemType() == ProblemType.MULTI_CHOICE) {
		 * multipleChoiceAnswers(problem); } else { // else do fill in the blank
		 * String userInput = readReplacement(problem); int returnedAnswer =
		 * runCompilerWithReplacement(userInput, problem); if (returnedAnswer ==
		 * problem.getCorrectAnswer()) { System.out.println("Correct!");
		 * DM.adjustDifficulty(true); } else { System.out.println("Incorrect!");
		 * DM.adjustDifficulty(false); } }
		 */

	}

	private int runCompilerWithReplacement(String replacement,
			ProblemComponent problem) {/*
										 * JavaConverter javaConverter = new
										 * JavaConverter();
										 * javaConverter.convertProblem(problem,
										 * DM.getProblemComponent(),
										 * replacement);
										 * 
										 * File root = new File(
										 * "/Users/Michael/Documents/My Dropbox/Senior Design/workspace/SeniorDesign/src"
										 * ); File sourceFile = new File(root,
										 * "language/javaOutput.java");
										 * 
										 * String fileToCompile =
										 * sourceFile.getPath(); JavaCompiler
										 * compiler =
										 * ToolProvider.getSystemJavaCompiler();
										 * 
										 * compiler.run(null, null, null,
										 * fileToCompile); URLClassLoader
										 * classLoader; Class<?> cls;
										 * simpleInterface instance = null; try
										 * { classLoader =
										 * URLClassLoader.newInstance(new URL[]
										 * { root.toURI() .toURL() }); cls =
										 * Class.forName("language.javaOutput",
										 * true, classLoader); instance =
										 * (simpleInterface) cls.newInstance();
										 * } catch (MalformedURLException e1) {
										 * // TODO Auto-generated catch block
										 * e1.printStackTrace(); } catch
										 * (ClassNotFoundException e) { // TODO
										 * Auto-generated catch block
										 * e.printStackTrace(); } catch
										 * (InstantiationException e) { // TODO
										 * Auto-generated catch block
										 * e.printStackTrace(); } catch
										 * (IllegalAccessException e) { // TODO
										 * Auto-generated catch block
										 * e.printStackTrace(); }
										 * 
										 * int returnedAnswer = instance.Main();
										 * System.out.println(
										 * "With the inputed answer, the function returns "
										 * + returnedAnswer);
										 * 
										 * try {
										 * Files.delete(sourceFile.toPath()); }
										 * catch (IOException e1) { // TODO
										 * Auto-generated catch block
										 * e1.printStackTrace(); }
										 * 
										 * return returnedAnswer;
										 */
		return 0;
	}

	private void runCompiler() {
		/*
		 * File root = new File(
		 * "/Users/Michael/Documents/My Dropbox/Senior Design/workspace/SeniorDesign/src"
		 * ); File sourceFile = new File(root, "language/javaOutput.java");
		 * 
		 * String fileToCompile = sourceFile.getPath(); JavaCompiler compiler =
		 * ToolProvider.getSystemJavaCompiler();
		 * 
		 * compiler.run(null, null, null, fileToCompile); URLClassLoader
		 * classLoader; Class<?> cls; simpleInterface instance = null; try {
		 * classLoader = URLClassLoader.newInstance(new URL[] { root.toURI()
		 * .toURL() }); cls = Class.forName("language.javaOutput", true,
		 * classLoader); instance = (simpleInterface) cls.newInstance(); } catch
		 * (MalformedURLException e1) { // TODO Auto-generated catch block
		 * e1.printStackTrace(); } catch (ClassNotFoundException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); } catch
		 * (InstantiationException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } catch (IllegalAccessException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 * 
		 * System.out.println(instance); System.out.println(instance.Main());
		 * 
		 * try { Files.delete(sourceFile.toPath()); } catch (IOException e1) {
		 * // TODO Auto-generated catch block e1.printStackTrace(); }
		 */
	}

	private String readReplacement(ProblemComponent problem) {
		System.out
				.println("What should be placed into the ??? such that Main returns "
						+ problem.getCorrectAnswer());
		String line = null;
		try {
			line = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
