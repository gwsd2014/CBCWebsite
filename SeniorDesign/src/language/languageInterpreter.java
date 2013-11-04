package language;
import org.antlr.runtime.*;

public class LanguageInterpreter {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		LanguageLexer lex = new LanguageLexer(new ANTLRFileStream(args[0]));
        CommonTokenStream tokens = new CommonTokenStream(lex);
 
        LanguageParser parser = new LanguageParser(tokens);
 
        try {
            parser.file();
            System.out.println("Parsed");
        } catch (RecognitionException e)  {
            e.printStackTrace();
        }
	}

}
