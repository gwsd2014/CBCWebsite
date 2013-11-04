package language;

// $ANTLR 3.5 C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g 2013-11-03 21:08:07

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class LanguageParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ASSIGN", "CLASS", "COMMA", "ELSE", 
		"ENDCLASS", "ENDELSE", "ENDFUNCTION", "ENDIF", "EQUALS", "FUNCTION", "ID", 
		"IF", "LPAREN", "MINUS", "PLUS", "RPAREN", "SLASH", "STAR", "VALUE", "VAR", 
		"WS"
	};
	public static final int EOF=-1;
	public static final int ASSIGN=4;
	public static final int CLASS=5;
	public static final int COMMA=6;
	public static final int ELSE=7;
	public static final int ENDCLASS=8;
	public static final int ENDELSE=9;
	public static final int ENDFUNCTION=10;
	public static final int ENDIF=11;
	public static final int EQUALS=12;
	public static final int FUNCTION=13;
	public static final int ID=14;
	public static final int IF=15;
	public static final int LPAREN=16;
	public static final int MINUS=17;
	public static final int PLUS=18;
	public static final int RPAREN=19;
	public static final int SLASH=20;
	public static final int STAR=21;
	public static final int VALUE=22;
	public static final int VAR=23;
	public static final int WS=24;

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
	// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:25:1: file : CLASS ID func function_list ENDCLASS ;
	public final void file() throws Exception  {
		try {
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:25:5: ( CLASS ID func function_list ENDCLASS )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:26:3: CLASS ID func function_list ENDCLASS
			{
			match(input,CLASS,FOLLOW_CLASS_in_file331); 
			match(input,ID,FOLLOW_ID_in_file333); 
			pushFollow(FOLLOW_func_in_file335);
			func();
			state._fsp--;

			pushFollow(FOLLOW_function_list_in_file337);
			function_list();
			state._fsp--;

			match(input,ENDCLASS,FOLLOW_ENDCLASS_in_file339); 
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
	// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:29:1: function_list : (| func function_list );
	public final void function_list() throws Exception  {
		try {
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:29:14: (| func function_list )
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
					// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:30:3: 
					{
					}
					break;
				case 2 :
					// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:30:5: func function_list
					{
					pushFollow(FOLLOW_func_in_function_list355);
					func();
					state._fsp--;

					pushFollow(FOLLOW_function_list_in_function_list357);
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
	// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:33:1: func : FUNCTION ID LPAREN param RPAREN variable_assignments compound_statement ENDFUNCTION ;
	public final void func() throws Exception  {
		try {
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:33:6: ( FUNCTION ID LPAREN param RPAREN variable_assignments compound_statement ENDFUNCTION )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:34:4: FUNCTION ID LPAREN param RPAREN variable_assignments compound_statement ENDFUNCTION
			{
			match(input,FUNCTION,FOLLOW_FUNCTION_in_func373); 
			match(input,ID,FOLLOW_ID_in_func375); 
			match(input,LPAREN,FOLLOW_LPAREN_in_func377); 
			pushFollow(FOLLOW_param_in_func379);
			param();
			state._fsp--;

			match(input,RPAREN,FOLLOW_RPAREN_in_func381); 
			pushFollow(FOLLOW_variable_assignments_in_func383);
			variable_assignments();
			state._fsp--;

			pushFollow(FOLLOW_compound_statement_in_func385);
			compound_statement();
			state._fsp--;

			match(input,ENDFUNCTION,FOLLOW_ENDFUNCTION_in_func387); 
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
	// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:37:1: param : (| VAR ID param_cont );
	public final void param() throws Exception  {
		try {
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:37:7: (| VAR ID param_cont )
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
					// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:38:3: 
					{
					}
					break;
				case 2 :
					// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:38:5: VAR ID param_cont
					{
					match(input,VAR,FOLLOW_VAR_in_param404); 
					match(input,ID,FOLLOW_ID_in_param406); 
					pushFollow(FOLLOW_param_cont_in_param408);
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
	// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:41:1: param_cont : (| COMMA VAR ID param_cont );
	public final void param_cont() throws Exception  {
		try {
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:42:2: (| COMMA VAR ID param_cont )
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
					// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:43:3: 
					{
					}
					break;
				case 2 :
					// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:43:5: COMMA VAR ID param_cont
					{
					match(input,COMMA,FOLLOW_COMMA_in_param_cont427); 
					match(input,VAR,FOLLOW_VAR_in_param_cont429); 
					match(input,ID,FOLLOW_ID_in_param_cont431); 
					pushFollow(FOLLOW_param_cont_in_param_cont433);
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
	// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:46:1: variable_assignments : assignment more_assignments ;
	public final void variable_assignments() throws Exception  {
		try {
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:47:2: ( assignment more_assignments )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:48:3: assignment more_assignments
			{
			pushFollow(FOLLOW_assignment_in_variable_assignments449);
			assignment();
			state._fsp--;

			pushFollow(FOLLOW_more_assignments_in_variable_assignments451);
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
	// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:51:1: more_assignments : (| assignment more_assignments );
	public final void more_assignments() throws Exception  {
		try {
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:52:2: (| assignment more_assignments )
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( ((LA4_0 >= ENDELSE && LA4_0 <= ENDIF)||(LA4_0 >= ID && LA4_0 <= IF)) ) {
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
					// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:53:3: 
					{
					}
					break;
				case 2 :
					// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:53:5: assignment more_assignments
					{
					pushFollow(FOLLOW_assignment_in_more_assignments470);
					assignment();
					state._fsp--;

					pushFollow(FOLLOW_more_assignments_in_more_assignments472);
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
	// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:56:1: assignment : VAR ID ASSIGN VALUE ;
	public final void assignment() throws Exception  {
		try {
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:57:2: ( VAR ID ASSIGN VALUE )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:58:3: VAR ID ASSIGN VALUE
			{
			match(input,VAR,FOLLOW_VAR_in_assignment489); 
			match(input,ID,FOLLOW_ID_in_assignment491); 
			match(input,ASSIGN,FOLLOW_ASSIGN_in_assignment493); 
			match(input,VALUE,FOLLOW_VALUE_in_assignment495); 
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
	// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:61:1: compound_statement : (| statement compound_statement );
	public final void compound_statement() throws Exception  {
		try {
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:61:19: (| statement compound_statement )
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( ((LA5_0 >= ENDELSE && LA5_0 <= ENDIF)) ) {
				alt5=1;
			}
			else if ( ((LA5_0 >= ID && LA5_0 <= IF)) ) {
				alt5=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}

			switch (alt5) {
				case 1 :
					// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:63:3: 
					{
					}
					break;
				case 2 :
					// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:63:4: statement compound_statement
					{
					pushFollow(FOLLOW_statement_in_compound_statement511);
					statement();
					state._fsp--;

					pushFollow(FOLLOW_compound_statement_in_compound_statement513);
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
	// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:66:1: statement : ( arithmatic_expression | conditional_expression );
	public final void statement() throws Exception  {
		try {
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:66:10: ( arithmatic_expression | conditional_expression )
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==ID) ) {
				alt6=1;
			}
			else if ( (LA6_0==IF) ) {
				alt6=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}

			switch (alt6) {
				case 1 :
					// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:67:3: arithmatic_expression
					{
					pushFollow(FOLLOW_arithmatic_expression_in_statement526);
					arithmatic_expression();
					state._fsp--;

					}
					break;
				case 2 :
					// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:68:5: conditional_expression
					{
					pushFollow(FOLLOW_conditional_expression_in_statement532);
					conditional_expression();
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
	// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:71:1: arithmatic_expression : ID ASSIGN term arith_recurse ;
	public final void arithmatic_expression() throws Exception  {
		try {
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:72:2: ( ID ASSIGN term arith_recurse )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:73:3: ID ASSIGN term arith_recurse
			{
			match(input,ID,FOLLOW_ID_in_arithmatic_expression547); 
			match(input,ASSIGN,FOLLOW_ASSIGN_in_arithmatic_expression549); 
			pushFollow(FOLLOW_term_in_arithmatic_expression551);
			term();
			state._fsp--;

			pushFollow(FOLLOW_arith_recurse_in_arithmatic_expression553);
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
	// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:76:1: arith_recurse : (| operator term | operator LPAREN term arith_recurse RPAREN );
	public final void arith_recurse() throws Exception  {
		try {
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:77:2: (| operator term | operator LPAREN term arith_recurse RPAREN )
			int alt7=3;
			int LA7_0 = input.LA(1);
			if ( ((LA7_0 >= ENDELSE && LA7_0 <= ENDIF)||(LA7_0 >= ID && LA7_0 <= IF)||LA7_0==RPAREN) ) {
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
					// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:78:3: 
					{
					}
					break;
				case 2 :
					// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:78:5: operator term
					{
					pushFollow(FOLLOW_operator_in_arith_recurse572);
					operator();
					state._fsp--;

					pushFollow(FOLLOW_term_in_arith_recurse574);
					term();
					state._fsp--;

					}
					break;
				case 3 :
					// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:79:5: operator LPAREN term arith_recurse RPAREN
					{
					pushFollow(FOLLOW_operator_in_arith_recurse580);
					operator();
					state._fsp--;

					match(input,LPAREN,FOLLOW_LPAREN_in_arith_recurse582); 
					pushFollow(FOLLOW_term_in_arith_recurse584);
					term();
					state._fsp--;

					pushFollow(FOLLOW_arith_recurse_in_arith_recurse586);
					arith_recurse();
					state._fsp--;

					match(input,RPAREN,FOLLOW_RPAREN_in_arith_recurse588); 
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
	// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:82:1: conditional_expression : IF test_expression compound_statement ENDIF ELSE compound_statement ENDELSE ;
	public final void conditional_expression() throws Exception  {
		try {
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:83:2: ( IF test_expression compound_statement ENDIF ELSE compound_statement ENDELSE )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:84:3: IF test_expression compound_statement ENDIF ELSE compound_statement ENDELSE
			{
			match(input,IF,FOLLOW_IF_in_conditional_expression605); 
			pushFollow(FOLLOW_test_expression_in_conditional_expression607);
			test_expression();
			state._fsp--;

			pushFollow(FOLLOW_compound_statement_in_conditional_expression609);
			compound_statement();
			state._fsp--;

			match(input,ENDIF,FOLLOW_ENDIF_in_conditional_expression611); 
			match(input,ELSE,FOLLOW_ELSE_in_conditional_expression613); 
			pushFollow(FOLLOW_compound_statement_in_conditional_expression615);
			compound_statement();
			state._fsp--;

			match(input,ENDELSE,FOLLOW_ENDELSE_in_conditional_expression617); 
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
	// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:87:1: test_expression : LPAREN ID EQUALS term RPAREN ;
	public final void test_expression() throws Exception  {
		try {
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:88:2: ( LPAREN ID EQUALS term RPAREN )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:89:3: LPAREN ID EQUALS term RPAREN
			{
			match(input,LPAREN,FOLLOW_LPAREN_in_test_expression634); 
			match(input,ID,FOLLOW_ID_in_test_expression636); 
			match(input,EQUALS,FOLLOW_EQUALS_in_test_expression638); 
			pushFollow(FOLLOW_term_in_test_expression640);
			term();
			state._fsp--;

			match(input,RPAREN,FOLLOW_RPAREN_in_test_expression642); 
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



	// $ANTLR start "operator"
	// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:92:1: operator : ( PLUS | MINUS | STAR | SLASH );
	public final void operator() throws Exception  {
		try {
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:92:9: ( PLUS | MINUS | STAR | SLASH )
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
	// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:99:1: term : ( ID | VALUE );
	public final void term() throws Exception  {
		try {
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:99:6: ( ID | VALUE )
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



	public static final BitSet FOLLOW_CLASS_in_file331 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_ID_in_file333 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_func_in_file335 = new BitSet(new long[]{0x0000000000002100L});
	public static final BitSet FOLLOW_function_list_in_file337 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_ENDCLASS_in_file339 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_func_in_function_list355 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_function_list_in_function_list357 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FUNCTION_in_func373 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_ID_in_func375 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_LPAREN_in_func377 = new BitSet(new long[]{0x0000000000880000L});
	public static final BitSet FOLLOW_param_in_func379 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_RPAREN_in_func381 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_variable_assignments_in_func383 = new BitSet(new long[]{0x000000000000C400L});
	public static final BitSet FOLLOW_compound_statement_in_func385 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_ENDFUNCTION_in_func387 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_in_param404 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_ID_in_param406 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_param_cont_in_param408 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_COMMA_in_param_cont427 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_VAR_in_param_cont429 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_ID_in_param_cont431 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_param_cont_in_param_cont433 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_assignment_in_variable_assignments449 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_more_assignments_in_variable_assignments451 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_assignment_in_more_assignments470 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_more_assignments_in_more_assignments472 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_in_assignment489 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_ID_in_assignment491 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ASSIGN_in_assignment493 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_VALUE_in_assignment495 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_statement_in_compound_statement511 = new BitSet(new long[]{0x000000000000C000L});
	public static final BitSet FOLLOW_compound_statement_in_compound_statement513 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_arithmatic_expression_in_statement526 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_conditional_expression_in_statement532 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_arithmatic_expression547 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ASSIGN_in_arithmatic_expression549 = new BitSet(new long[]{0x0000000000404000L});
	public static final BitSet FOLLOW_term_in_arithmatic_expression551 = new BitSet(new long[]{0x0000000000360000L});
	public static final BitSet FOLLOW_arith_recurse_in_arithmatic_expression553 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_operator_in_arith_recurse572 = new BitSet(new long[]{0x0000000000404000L});
	public static final BitSet FOLLOW_term_in_arith_recurse574 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_operator_in_arith_recurse580 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_LPAREN_in_arith_recurse582 = new BitSet(new long[]{0x0000000000404000L});
	public static final BitSet FOLLOW_term_in_arith_recurse584 = new BitSet(new long[]{0x00000000003E0000L});
	public static final BitSet FOLLOW_arith_recurse_in_arith_recurse586 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_RPAREN_in_arith_recurse588 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_conditional_expression605 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_test_expression_in_conditional_expression607 = new BitSet(new long[]{0x000000000000C800L});
	public static final BitSet FOLLOW_compound_statement_in_conditional_expression609 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_ENDIF_in_conditional_expression611 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_ELSE_in_conditional_expression613 = new BitSet(new long[]{0x000000000000C200L});
	public static final BitSet FOLLOW_compound_statement_in_conditional_expression615 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_ENDELSE_in_conditional_expression617 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_test_expression634 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_ID_in_test_expression636 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_EQUALS_in_test_expression638 = new BitSet(new long[]{0x0000000000404000L});
	public static final BitSet FOLLOW_term_in_test_expression640 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_RPAREN_in_test_expression642 = new BitSet(new long[]{0x0000000000000002L});
}
