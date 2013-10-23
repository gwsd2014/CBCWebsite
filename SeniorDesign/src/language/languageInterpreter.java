package language;
import org.antlr.runtime.*;

public class languageInterpreter {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		languageLexer lex = new languageLexer(new ANTLRFileStream(args[0]));
        CommonTokenStream tokens = new CommonTokenStream(lex);
 
        languageParser parser = new languageParser(tokens);
 
        try {
            parser.file();
            System.out.println("Correctly parsed");
        } catch (RecognitionException e)  {
            e.printStackTrace();
        }
	}

}
