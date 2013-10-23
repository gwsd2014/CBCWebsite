package generator;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import language.languageInterpreter;

public class Control {

	private final static String path = "src/output.txt";
	
	public static void main(String[] args) {
		ProblemComponent problem = new ProblemComponent(1);
		Converter converter = new Converter();
		
		PrintWriter code = converter.convertProblem(problem);
		String[] codeArr = {path};
		try {
			languageInterpreter.main(codeArr);
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
		
		System.out.println("\nWhat is the value of " +problem.getTestVariable());
		System.out.println("1. " + problem.getCorrectAnswer());
		System.out.println("2. " + problem.getIncorrect1());
		System.out.println("3. " + problem.getIncorrect2());
		System.out.println("4. " + problem.getIncorrect3());
	}

}
