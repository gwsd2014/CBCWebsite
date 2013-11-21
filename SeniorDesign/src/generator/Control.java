package generator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import language.LanguageInterpreter;

public class Control {

	private final static String path = "src/output.txt";

	public static void main(String[] args) {
		Difficulty DM = new Difficulty();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int questionCounter = 0;

		while (true) {
			questionCounter++;
			System.out.println("\nQuestion #" + questionCounter + "\n");
			ProblemComponent problem = new ProblemComponent(DM);
			Converter converter = new Converter();
			converter.convertProblem(problem);
			
			String[] codeArr = { path };
			try {
				LanguageInterpreter.main(codeArr);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

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

			System.out.println("What is the value of "
					+ problem.getTestVariable());
			System.out.println("A. " + problem.getCorrectAnswer());
			System.out.println("B. " + problem.getIncorrect1());
			System.out.println("C. " + problem.getIncorrect2());
			System.out.println("D. " + problem.getIncorrect3());
			System.out.println("\nPlease type your answer below:");

			char c = 'F';
			try {
				c = br.readLine().charAt(0);
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

}
