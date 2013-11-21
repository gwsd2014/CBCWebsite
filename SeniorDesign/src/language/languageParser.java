package language;

//$ANTLR 3.5 C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g 2013-11-10 20:00:53

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class LanguageParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ASSIGN", "CLASS", "COMMA", "DECREASE", 
		"ELSE", "ENDCLASS", "ENDELSE", "ENDFOR", "ENDFUNCTION", "ENDIF", "ENDWHILE", 
		"EQUALS", "FOR", "FUNCTION", "GT", "GTE", "ID", "IF", "INCREASE", "LPAREN", 
		"LT", "LTE", "MINUS", "PLUS", "RPAREN", "SEMICOLON", "SLASH", "STAR", 
		"VALUE", "VAR", "WHILE", "WS"
	};
	public static final int EOF=-1;
	public static final int ASSIGN=4;
	public static final int CLASS=5;
	public static final int COMMA=6;
	public static final int DECREASE=7;
	public static final int ELSE=8;
	public static final int ENDCLASS=9;
	public static final int ENDELSE=10;
	public static final int ENDFOR=11;
	public static final int ENDFUNCTION=12;
	public static final int ENDIF=13;
	public static final int ENDWHILE=14;
	public static final int EQUALS=15;
	public static final int FOR=16;
	public static final int FUNCTION=17;
	public static final int GT=18;
	public static final int GTE=19;
	public static final int ID=20;
	public static final int IF=21;
	public static final int INCREASE=22;
	public static final int LPAREN=23;
	public static final int LT=24;
	public static final int LTE=25;
	public static final int MINUS=26;
	public static final int PLUS=27;
	public static final int RPAREN=28;
	public static final int SEMICOLON=29;
	public static final int SLASH=30;
	public static final int STAR=31;
	public static final int VALUE=32;
	public static final int VAR=33;
	public static final int WHILE=34;
	public static final int WS=35;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public LanguageParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public LanguageParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return LanguageParser.tokenNames; }
	@Override public String getGrammarFileName() { return "C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g"; }



	// $ANTLR start "file"
	// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:36:1: file : CLASS ID func function_list ENDCLASS ;
	public final void file() throws Exception  {
		try {
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:36:5: ( CLASS ID func function_list ENDCLASS )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:37:3: CLASS ID func function_list ENDCLASS
			{
			match(input,CLASS,FOLLOW_CLASS_in_file467); 
			match(input,ID,FOLLOW_ID_in_file469); 
			pushFollow(FOLLOW_func_in_file471);
			func();
			state._fsp--;

			pushFollow(FOLLOW_function_list_in_file473);
			function_list();
			state._fsp--;

			match(input,ENDCLASS,FOLLOW_ENDCLASS_in_file475); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "file"



	// $ANTLR start "function_list"
	// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:40:1: function_list : (| func function_list );
	public final void function_list() throws Exception  {
		try {
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:40:14: (| func function_list )
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0==ENDCLASS) ) {
				alt1=1;
			}
			else if ( (LA1_0==FUNCTION) ) {
				alt1=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}

			switch (alt1) {
				case 1 :
					// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:41:3: 
					{
					}
					break;
				case 2 :
					// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:41:5: func function_list
					{
					pushFollow(FOLLOW_func_in_function_list491);
					func();
					state._fsp--;

					pushFollow(FOLLOW_function_list_in_function_list493);
					function_list();
					state._fsp--;

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "function_list"



	// $ANTLR start "func"
	// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:44:1: func : FUNCTION ID LPAREN param RPAREN variable_assignments compound_statement ENDFUNCTION ;
	public final void func() throws Exception  {
		try {
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:44:6: ( FUNCTION ID LPAREN param RPAREN variable_assignments compound_statement ENDFUNCTION )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:45:4: FUNCTION ID LPAREN param RPAREN variable_assignments compound_statement ENDFUNCTION
			{
			match(input,FUNCTION,FOLLOW_FUNCTION_in_func509); 
			match(input,ID,FOLLOW_ID_in_func511); 
			match(input,LPAREN,FOLLOW_LPAREN_in_func513); 
			pushFollow(FOLLOW_param_in_func515);
			param();
			state._fsp--;

			match(input,RPAREN,FOLLOW_RPAREN_in_func517); 
			pushFollow(FOLLOW_variable_assignments_in_func519);
			variable_assignments();
			state._fsp--;

			pushFollow(FOLLOW_compound_statement_in_func521);
			compound_statement();
			state._fsp--;

			match(input,ENDFUNCTION,FOLLOW_ENDFUNCTION_in_func523); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "func"



	// $ANTLR start "param"
	// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:48:1: param : (| VAR ID param_cont );
	public final void param() throws Exception  {
		try {
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:48:7: (| VAR ID param_cont )
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==RPAREN) ) {
				alt2=1;
			}
			else if ( (LA2_0==VAR) ) {
				alt2=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:49:3: 
					{
					}
					break;
				case 2 :
					// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:49:5: VAR ID param_cont
					{
					match(input,VAR,FOLLOW_VAR_in_param540); 
					match(input,ID,FOLLOW_ID_in_param542); 
					pushFollow(FOLLOW_param_cont_in_param544);
					param_cont();
					state._fsp--;

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "param"



	// $ANTLR start "param_cont"
	// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:52:1: param_cont : (| COMMA VAR ID param_cont );
	public final void param_cont() throws Exception  {
		try {
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:53:2: (| COMMA VAR ID param_cont )
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==RPAREN) ) {
				alt3=1;
			}
			else if ( (LA3_0==COMMA) ) {
				alt3=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}

			switch (alt3) {
				case 1 :
					// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:54:3: 
					{
					}
					break;
				case 2 :
					// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:54:5: COMMA VAR ID param_cont
					{
					match(input,COMMA,FOLLOW_COMMA_in_param_cont563); 
					match(input,VAR,FOLLOW_VAR_in_param_cont565); 
					match(input,ID,FOLLOW_ID_in_param_cont567); 
					pushFollow(FOLLOW_param_cont_in_param_cont569);
					param_cont();
					state._fsp--;

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "param_cont"



	// $ANTLR start "variable_assignments"
	// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:57:1: variable_assignments : assignment more_assignments ;
	public final void variable_assignments() throws Exception  {
		try {
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:58:2: ( assignment more_assignments )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:59:3: assignment more_assignments
			{
			pushFollow(FOLLOW_assignment_in_variable_assignments585);
			assignment();
			state._fsp--;

			pushFollow(FOLLOW_more_assignments_in_variable_assignments587);
			more_assignments();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "variable_assignments"



	// $ANTLR start "more_assignments"
	// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:62:1: more_assignments : (| assignment more_assignments );
	public final void more_assignments() throws Exception  {
		try {
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:63:2: (| assignment more_assignments )
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( ((LA4_0 >= ENDELSE && LA4_0 <= ENDWHILE)||LA4_0==FOR||(LA4_0 >= ID && LA4_0 <= IF)||LA4_0==WHILE) ) {
				alt4=1;
			}
			else if ( (LA4_0==VAR) ) {
				alt4=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}

			switch (alt4) {
				case 1 :
					// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:64:3: 
					{
					}
					break;
				case 2 :
					// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:64:5: assignment more_assignments
					{
					pushFollow(FOLLOW_assignment_in_more_assignments606);
					assignment();
					state._fsp--;

					pushFollow(FOLLOW_more_assignments_in_more_assignments608);
					more_assignments();
					state._fsp--;

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "more_assignments"



	// $ANTLR start "assignment"
	// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:67:1: assignment : VAR ID ASSIGN VALUE ;
	public final void assignment() throws Exception  {
		try {
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:68:2: ( VAR ID ASSIGN VALUE )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:69:3: VAR ID ASSIGN VALUE
			{
			match(input,VAR,FOLLOW_VAR_in_assignment625); 
			match(input,ID,FOLLOW_ID_in_assignment627); 
			match(input,ASSIGN,FOLLOW_ASSIGN_in_assignment629); 
			match(input,VALUE,FOLLOW_VALUE_in_assignment631); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "assignment"



	// $ANTLR start "compound_statement"
	// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:72:1: compound_statement : (| statement compound_statement );
	public final void compound_statement() throws Exception  {
		try {
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:72:19: (| statement compound_statement )
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( ((LA5_0 >= ENDELSE && LA5_0 <= ENDWHILE)) ) {
				alt5=1;
			}
			else if ( (LA5_0==FOR||(LA5_0 >= ID && LA5_0 <= IF)||LA5_0==WHILE) ) {
				alt5=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}

			switch (alt5) {
				case 1 :
					// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:74:3: 
					{
					}
					break;
				case 2 :
					// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:74:4: statement compound_statement
					{
					pushFollow(FOLLOW_statement_in_compound_statement647);
					statement();
					state._fsp--;

					pushFollow(FOLLOW_compound_statement_in_compound_statement649);
					compound_statement();
					state._fsp--;

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "compound_statement"



	// $ANTLR start "statement"
	// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:77:1: statement : ( arithmatic_expression | conditional_expression | while_loop_expression | for_loop_expression );
	public final void statement() throws Exception  {
		try {
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:77:10: ( arithmatic_expression | conditional_expression | while_loop_expression | for_loop_expression )
			int alt6=4;
			switch ( input.LA(1) ) {
			case ID:
				{
				alt6=1;
				}
				break;
			case IF:
				{
				alt6=2;
				}
				break;
			case WHILE:
				{
				alt6=3;
				}
				break;
			case FOR:
				{
				alt6=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}
			switch (alt6) {
				case 1 :
					// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:78:3: arithmatic_expression
					{
					pushFollow(FOLLOW_arithmatic_expression_in_statement662);
					arithmatic_expression();
					state._fsp--;

					}
					break;
				case 2 :
					// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:79:5: conditional_expression
					{
					pushFollow(FOLLOW_conditional_expression_in_statement668);
					conditional_expression();
					state._fsp--;

					}
					break;
				case 3 :
					// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:80:5: while_loop_expression
					{
					pushFollow(FOLLOW_while_loop_expression_in_statement674);
					while_loop_expression();
					state._fsp--;

					}
					break;
				case 4 :
					// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:81:5: for_loop_expression
					{
					pushFollow(FOLLOW_for_loop_expression_in_statement680);
					for_loop_expression();
					state._fsp--;

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "statement"



	// $ANTLR start "arithmatic_expression"
	// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:84:1: arithmatic_expression : ID ASSIGN term arith_recurse ;
	public final void arithmatic_expression() throws Exception  {
		try {
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:85:2: ( ID ASSIGN term arith_recurse )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:86:3: ID ASSIGN term arith_recurse
			{
			match(input,ID,FOLLOW_ID_in_arithmatic_expression695); 
			match(input,ASSIGN,FOLLOW_ASSIGN_in_arithmatic_expression697); 
			pushFollow(FOLLOW_term_in_arithmatic_expression699);
			term();
			state._fsp--;

			pushFollow(FOLLOW_arith_recurse_in_arithmatic_expression701);
			arith_recurse();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "arithmatic_expression"



	// $ANTLR start "arith_recurse"
	// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:89:1: arith_recurse : (| operator term | operator LPAREN term arith_recurse RPAREN );
	public final void arith_recurse() throws Exception  {
		try {
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:90:2: (| operator term | operator LPAREN term arith_recurse RPAREN )
			int alt7=3;
			int LA7_0 = input.LA(1);
			if ( ((LA7_0 >= ENDELSE && LA7_0 <= ENDWHILE)||LA7_0==FOR||(LA7_0 >= ID && LA7_0 <= IF)||LA7_0==RPAREN||LA7_0==WHILE) ) {
				alt7=1;
			}
			else if ( ((LA7_0 >= MINUS && LA7_0 <= PLUS)||(LA7_0 >= SLASH && LA7_0 <= STAR)) ) {
				int LA7_2 = input.LA(2);
				if ( (LA7_2==ID||LA7_2==VALUE) ) {
					alt7=2;
				}
				else if ( (LA7_2==LPAREN) ) {
					alt7=3;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 7, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				throw nvae;
			}

			switch (alt7) {
				case 1 :
					// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:91:3: 
					{
					}
					break;
				case 2 :
					// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:91:5: operator term
					{
					pushFollow(FOLLOW_operator_in_arith_recurse720);
					operator();
					state._fsp--;

					pushFollow(FOLLOW_term_in_arith_recurse722);
					term();
					state._fsp--;

					}
					break;
				case 3 :
					// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:92:5: operator LPAREN term arith_recurse RPAREN
					{
					pushFollow(FOLLOW_operator_in_arith_recurse728);
					operator();
					state._fsp--;

					match(input,LPAREN,FOLLOW_LPAREN_in_arith_recurse730); 
					pushFollow(FOLLOW_term_in_arith_recurse732);
					term();
					state._fsp--;

					pushFollow(FOLLOW_arith_recurse_in_arith_recurse734);
					arith_recurse();
					state._fsp--;

					match(input,RPAREN,FOLLOW_RPAREN_in_arith_recurse736); 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "arith_recurse"



	// $ANTLR start "conditional_expression"
	// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:95:1: conditional_expression : IF test_expression compound_statement ENDIF ELSE compound_statement ENDELSE ;
	public final void conditional_expression() throws Exception  {
		try {
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:96:2: ( IF test_expression compound_statement ENDIF ELSE compound_statement ENDELSE )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:97:3: IF test_expression compound_statement ENDIF ELSE compound_statement ENDELSE
			{
			match(input,IF,FOLLOW_IF_in_conditional_expression753); 
			pushFollow(FOLLOW_test_expression_in_conditional_expression755);
			test_expression();
			state._fsp--;

			pushFollow(FOLLOW_compound_statement_in_conditional_expression757);
			compound_statement();
			state._fsp--;

			match(input,ENDIF,FOLLOW_ENDIF_in_conditional_expression759); 
			match(input,ELSE,FOLLOW_ELSE_in_conditional_expression761); 
			pushFollow(FOLLOW_compound_statement_in_conditional_expression763);
			compound_statement();
			state._fsp--;

			match(input,ENDELSE,FOLLOW_ENDELSE_in_conditional_expression765); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "conditional_expression"



	// $ANTLR start "test_expression"
	// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:100:1: test_expression : LPAREN ID comparator term RPAREN ;
	public final void test_expression() throws Exception  {
		try {
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:101:2: ( LPAREN ID comparator term RPAREN )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:102:3: LPAREN ID comparator term RPAREN
			{
			match(input,LPAREN,FOLLOW_LPAREN_in_test_expression782); 
			match(input,ID,FOLLOW_ID_in_test_expression784); 
			pushFollow(FOLLOW_comparator_in_test_expression786);
			comparator();
			state._fsp--;

			pushFollow(FOLLOW_term_in_test_expression788);
			term();
			state._fsp--;

			match(input,RPAREN,FOLLOW_RPAREN_in_test_expression790); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "test_expression"



	// $ANTLR start "while_loop_expression"
	// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:105:1: while_loop_expression : WHILE test_expression compound_statement ENDWHILE ;
	public final void while_loop_expression() throws Exception  {
		try {
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:106:2: ( WHILE test_expression compound_statement ENDWHILE )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:107:3: WHILE test_expression compound_statement ENDWHILE
			{
			match(input,WHILE,FOLLOW_WHILE_in_while_loop_expression807); 
			pushFollow(FOLLOW_test_expression_in_while_loop_expression809);
			test_expression();
			state._fsp--;

			pushFollow(FOLLOW_compound_statement_in_while_loop_expression811);
			compound_statement();
			state._fsp--;

			match(input,ENDWHILE,FOLLOW_ENDWHILE_in_while_loop_expression813); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "while_loop_expression"



	// $ANTLR start "for_loop_expression"
	// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:110:1: for_loop_expression : FOR LPAREN ID ASSIGN VALUE SEMICOLON ID comparator VALUE SEMICOLON ID increment RPAREN compound_statement ENDFOR ;
	public final void for_loop_expression() throws Exception  {
		try {
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:111:2: ( FOR LPAREN ID ASSIGN VALUE SEMICOLON ID comparator VALUE SEMICOLON ID increment RPAREN compound_statement ENDFOR )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:112:3: FOR LPAREN ID ASSIGN VALUE SEMICOLON ID comparator VALUE SEMICOLON ID increment RPAREN compound_statement ENDFOR
			{
			match(input,FOR,FOLLOW_FOR_in_for_loop_expression830); 
			match(input,LPAREN,FOLLOW_LPAREN_in_for_loop_expression832); 
			match(input,ID,FOLLOW_ID_in_for_loop_expression834); 
			match(input,ASSIGN,FOLLOW_ASSIGN_in_for_loop_expression836); 
			match(input,VALUE,FOLLOW_VALUE_in_for_loop_expression838); 
			match(input,SEMICOLON,FOLLOW_SEMICOLON_in_for_loop_expression840); 
			match(input,ID,FOLLOW_ID_in_for_loop_expression842); 
			pushFollow(FOLLOW_comparator_in_for_loop_expression844);
			comparator();
			state._fsp--;

			match(input,VALUE,FOLLOW_VALUE_in_for_loop_expression846); 
			match(input,SEMICOLON,FOLLOW_SEMICOLON_in_for_loop_expression848); 
			match(input,ID,FOLLOW_ID_in_for_loop_expression850); 
			pushFollow(FOLLOW_increment_in_for_loop_expression852);
			increment();
			state._fsp--;

			match(input,RPAREN,FOLLOW_RPAREN_in_for_loop_expression854); 
			pushFollow(FOLLOW_compound_statement_in_for_loop_expression856);
			compound_statement();
			state._fsp--;

			match(input,ENDFOR,FOLLOW_ENDFOR_in_for_loop_expression858); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "for_loop_expression"



	// $ANTLR start "comparator"
	// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:115:1: comparator : ( EQUALS | LT | GT | LTE | GTE );
	public final void comparator() throws Exception  {
		try {
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:116:2: ( EQUALS | LT | GT | LTE | GTE )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:
			{
			if ( input.LA(1)==EQUALS||(input.LA(1) >= GT && input.LA(1) <= GTE)||(input.LA(1) >= LT && input.LA(1) <= LTE) ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "comparator"



	// $ANTLR start "increment"
	// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:124:1: increment : ( INCREASE | DECREASE );
	public final void increment() throws Exception  {
		try {
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:125:2: ( INCREASE | DECREASE )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:
			{
			if ( input.LA(1)==DECREASE||input.LA(1)==INCREASE ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "increment"



	// $ANTLR start "operator"
	// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:130:1: operator : ( PLUS | MINUS | STAR | SLASH );
	public final void operator() throws Exception  {
		try {
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:130:9: ( PLUS | MINUS | STAR | SLASH )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:
			{
			if ( (input.LA(1) >= MINUS && input.LA(1) <= PLUS)||(input.LA(1) >= SLASH && input.LA(1) <= STAR) ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "operator"



	// $ANTLR start "term"
	// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:137:1: term : ( ID | VALUE );
	public final void term() throws Exception  {
		try {
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:137:6: ( ID | VALUE )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:
			{
			if ( input.LA(1)==ID||input.LA(1)==VALUE ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "term"

	// Delegated rules



	public static final BitSet FOLLOW_CLASS_in_file467 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_ID_in_file469 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_func_in_file471 = new BitSet(new long[]{0x0000000000020200L});
	public static final BitSet FOLLOW_function_list_in_file473 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_ENDCLASS_in_file475 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_func_in_function_list491 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_function_list_in_function_list493 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FUNCTION_in_func509 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_ID_in_func511 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_LPAREN_in_func513 = new BitSet(new long[]{0x0000000210000000L});
	public static final BitSet FOLLOW_param_in_func515 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_RPAREN_in_func517 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_variable_assignments_in_func519 = new BitSet(new long[]{0x0000000400311000L});
	public static final BitSet FOLLOW_compound_statement_in_func521 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_ENDFUNCTION_in_func523 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_in_param540 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_ID_in_param542 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_param_cont_in_param544 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_COMMA_in_param_cont563 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_VAR_in_param_cont565 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_ID_in_param_cont567 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_param_cont_in_param_cont569 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_assignment_in_variable_assignments585 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_more_assignments_in_variable_assignments587 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_assignment_in_more_assignments606 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_more_assignments_in_more_assignments608 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_in_assignment625 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_ID_in_assignment627 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ASSIGN_in_assignment629 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_VALUE_in_assignment631 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_statement_in_compound_statement647 = new BitSet(new long[]{0x0000000400310000L});
	public static final BitSet FOLLOW_compound_statement_in_compound_statement649 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_arithmatic_expression_in_statement662 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_conditional_expression_in_statement668 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_while_loop_expression_in_statement674 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_for_loop_expression_in_statement680 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_arithmatic_expression695 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ASSIGN_in_arithmatic_expression697 = new BitSet(new long[]{0x0000000100100000L});
	public static final BitSet FOLLOW_term_in_arithmatic_expression699 = new BitSet(new long[]{0x00000000CC000000L});
	public static final BitSet FOLLOW_arith_recurse_in_arithmatic_expression701 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_operator_in_arith_recurse720 = new BitSet(new long[]{0x0000000100100000L});
	public static final BitSet FOLLOW_term_in_arith_recurse722 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_operator_in_arith_recurse728 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_LPAREN_in_arith_recurse730 = new BitSet(new long[]{0x0000000100100000L});
	public static final BitSet FOLLOW_term_in_arith_recurse732 = new BitSet(new long[]{0x00000000DC000000L});
	public static final BitSet FOLLOW_arith_recurse_in_arith_recurse734 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_RPAREN_in_arith_recurse736 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_conditional_expression753 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_test_expression_in_conditional_expression755 = new BitSet(new long[]{0x0000000400312000L});
	public static final BitSet FOLLOW_compound_statement_in_conditional_expression757 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_ENDIF_in_conditional_expression759 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_ELSE_in_conditional_expression761 = new BitSet(new long[]{0x0000000400310400L});
	public static final BitSet FOLLOW_compound_statement_in_conditional_expression763 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_ENDELSE_in_conditional_expression765 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_test_expression782 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_ID_in_test_expression784 = new BitSet(new long[]{0x00000000030C8000L});
	public static final BitSet FOLLOW_comparator_in_test_expression786 = new BitSet(new long[]{0x0000000100100000L});
	public static final BitSet FOLLOW_term_in_test_expression788 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_RPAREN_in_test_expression790 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WHILE_in_while_loop_expression807 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_test_expression_in_while_loop_expression809 = new BitSet(new long[]{0x0000000400314000L});
	public static final BitSet FOLLOW_compound_statement_in_while_loop_expression811 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_ENDWHILE_in_while_loop_expression813 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FOR_in_for_loop_expression830 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_LPAREN_in_for_loop_expression832 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_ID_in_for_loop_expression834 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ASSIGN_in_for_loop_expression836 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_VALUE_in_for_loop_expression838 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_for_loop_expression840 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_ID_in_for_loop_expression842 = new BitSet(new long[]{0x00000000030C8000L});
	public static final BitSet FOLLOW_comparator_in_for_loop_expression844 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_VALUE_in_for_loop_expression846 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_for_loop_expression848 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_ID_in_for_loop_expression850 = new BitSet(new long[]{0x0000000000400080L});
	public static final BitSet FOLLOW_increment_in_for_loop_expression852 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_RPAREN_in_for_loop_expression854 = new BitSet(new long[]{0x0000000400310800L});
	public static final BitSet FOLLOW_compound_statement_in_for_loop_expression856 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_ENDFOR_in_for_loop_expression858 = new BitSet(new long[]{0x0000000000000002L});
}
