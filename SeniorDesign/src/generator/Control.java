package generator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

import language.LanguageInterpreter;
import language.simpleInterface;

public class Control {

	private final static String path = "src/output.txt";
	private Difficulty DM;
	private BufferedReader br;

	public Control() {
//		this.DM = new Difficulty(4, ProblemType.MULTI_CHOICE, 2);
		this.DM = new Difficulty(3, ProblemType.FILL_BLANK, 1);
		this.br = new BufferedReader(new InputStreamReader(System.in));
	}

	public static void main(String[] args) {
		Control control = new Control();
		control.run(null);
	}

	public void run(String[] args) {

		int questionCounter = 0;

		while (true) {
			questionCounter++;
			System.out.println("\nQuestion #" + questionCounter + "\n");
			ProblemComponent problem = new ProblemComponent(DM);
			Converter converter = new Converter();

			converter.convertProblem(problem, DM.getProblemComponent(),
					DM.getWeight());

			// if fully generated code
			// run lexxer and parser to ensure validity
			if (DM.getProblemType() == ProblemType.MULTI_CHOICE) {
				String[] codeArr = { path };
				try {
					LanguageInterpreter.main(codeArr);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			// read then print the file
			FileReader reader;
			try {
				reader = new FileReader(path);
				char[] cbuf = new char[10000];
				reader.read(cbuf);
				System.out.println(cbuf);
				reader.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (DM.getProblemType() == ProblemType.MULTI_CHOICE) {
				multipleChoiceAnswers(problem);
			} else {
				// else do fill in the blank
				String userInput = readReplacement(problem);
				int returnedAnswer = runCompilerWithReplacement(userInput,
						problem);
				if (returnedAnswer == problem.getCorrectAnswer()) {
					System.out.println("Correct!");
					DM.adjustDifficulty(true);
				} else {
					System.out.println("Incorrect!");
					DM.adjustDifficulty(false);
				}
			}

		}
	}

	private int runCompilerWithReplacement(String replacement,
			ProblemComponent problem) {
		JavaConverter javaConverter = new JavaConverter();
		javaConverter.convertProblem(problem, DM.getProblemComponent(),
				replacement);

		File root = new File(
				"/Users/Michael/Documents/My Dropbox/Senior Design/workspace/SeniorDesign/src");
		File sourceFile = new File(root, "language/javaOutput.java");

		String fileToCompile = sourceFile.getPath();
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

		compiler.run(null, null, null, fileToCompile);
		URLClassLoader classLoader;
		Class<?> cls;
		simpleInterface instance = null;
		try {
			classLoader = URLClassLoader.newInstance(new URL[] { root.toURI()
					.toURL() });
			cls = Class.forName("language.javaOutput", true, classLoader);
			instance = (simpleInterface) cls.newInstance();
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int returnedAnswer = instance.Main();
		System.out.println("With the inputed answer, the function returns "
				+ returnedAnswer);

		try {
			Files.delete(sourceFile.toPath());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return returnedAnswer;
	}

	private void runCompiler() {
		File root = new File(
				"/Users/Michael/Documents/My Dropbox/Senior Design/workspace/SeniorDesign/src");
		File sourceFile = new File(root, "language/javaOutput.java");

		String fileToCompile = sourceFile.getPath();
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

		compiler.run(null, null, null, fileToCompile);
		URLClassLoader classLoader;
		Class<?> cls;
		simpleInterface instance = null;
		try {
			classLoader = URLClassLoader.newInstance(new URL[] { root.toURI()
					.toURL() });
			cls = Class.forName("language.javaOutput", true, classLoader);
			instance = (simpleInterface) cls.newInstance();
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(instance);
		System.out.println(instance.Main());

		try {
			Files.delete(sourceFile.toPath());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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

	private void multipleChoiceAnswers(ProblemComponent problem) {
		System.out.println("What is the value of " + problem.getTestVariable()
				+ " after Main is run?");
		System.out.println("A. " + problem.getCorrectAnswer());
		System.out.println("B. " + problem.getIncorrect1());
		System.out.println("C. " + problem.getIncorrect2());
		System.out.println("D. " + problem.getIncorrect3());
		System.out.println("\nPlease type your answer below:");

		char c = 'F';
		try {
			String line = br.readLine();
			// error check empty input
			if (line.isEmpty()) {
				System.out.println("Incorrect!");
				DM.adjustDifficulty(false);
				return;
			}
			c = line.charAt(0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (c == 'A' || c == 'a') {
			System.out.println("Correct!");
			DM.adjustDifficulty(true);
		} else {
			System.out.println("Incorrect!");
			DM.adjustDifficulty(false);
		}
	}
}
