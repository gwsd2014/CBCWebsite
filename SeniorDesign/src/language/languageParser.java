package language;

// $ANTLR 3.5 C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g 2013-09-22 22:26:22

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class LanguageParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ASSIGN", "CLASS", "COMMA", "ENDCLASS", 
		"ENDFUNCTION", "FUNCTION", "ID", "LPAREN", "MINUS", "PLUS", "RPAREN", 
		"SLASH", "STAR", "VALUE", "VAR", "WS"
	};
	public static final int EOF=-1;
	public static final int ASSIGN=4;
	public static final int CLASS=5;
	public static final int COMMA=6;
	public static final int ENDCLASS=7;
	public static final int ENDFUNCTION=8;
	public static final int FUNCTION=9;
	public static final int ID=10;
	public static final int LPAREN=11;
	public static final int MINUS=12;
	public static final int PLUS=13;
	public static final int RPAREN=14;
	public static final int SLASH=15;
	public static final int STAR=16;
	public static final int VALUE=17;
	public static final int VAR=18;
	public static final int WS=19;

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
	@Override public String getGrammarFileName() { return "C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g"; }



	// $ANTLR start "file"
	// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:19:1: file : CLASS ID func function_list ENDCLASS ;
	public final void file() throws Exception  {
		try {
			// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:19:5: ( CLASS ID func function_list ENDCLASS )
			// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:20:3: CLASS ID func function_list ENDCLASS
			{
			match(input,CLASS,FOLLOW_CLASS_in_file264); 
			match(input,ID,FOLLOW_ID_in_file266); 
			pushFollow(FOLLOW_func_in_file268);
			func();
			state._fsp--;

			pushFollow(FOLLOW_function_list_in_file270);
			function_list();
			state._fsp--;

			match(input,ENDCLASS,FOLLOW_ENDCLASS_in_file272); 
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
	// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:23:1: function_list : (| func function_list );
	public final void function_list() throws Exception  {
		try {
			// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:23:14: (| func function_list )
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
					// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:24:3: 
					{
					}
					break;
				case 2 :
					// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:24:5: func function_list
					{
					pushFollow(FOLLOW_func_in_function_list288);
					func();
					state._fsp--;

					pushFollow(FOLLOW_function_list_in_function_list290);
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
	// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:27:1: func : FUNCTION ID LPAREN param RPAREN variable_assignments compound_statement ENDFUNCTION ;
	public final void func() throws Exception  {
		try {
			// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:27:6: ( FUNCTION ID LPAREN param RPAREN variable_assignments compound_statement ENDFUNCTION )
			// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:28:4: FUNCTION ID LPAREN param RPAREN variable_assignments compound_statement ENDFUNCTION
			{
			match(input,FUNCTION,FOLLOW_FUNCTION_in_func306); 
			match(input,ID,FOLLOW_ID_in_func308); 
			match(input,LPAREN,FOLLOW_LPAREN_in_func310); 
			pushFollow(FOLLOW_param_in_func312);
			param();
			state._fsp--;

			match(input,RPAREN,FOLLOW_RPAREN_in_func314); 
			pushFollow(FOLLOW_variable_assignments_in_func316);
			variable_assignments();
			state._fsp--;

			pushFollow(FOLLOW_compound_statement_in_func318);
			compound_statement();
			state._fsp--;

			match(input,ENDFUNCTION,FOLLOW_ENDFUNCTION_in_func320); 
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
	// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:31:1: param : (| VAR ID param_cont );
	public final void param() throws Exception  {
		try {
			// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:31:7: (| VAR ID param_cont )
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
					// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:32:3: 
					{
					}
					break;
				case 2 :
					// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:32:5: VAR ID param_cont
					{
					match(input,VAR,FOLLOW_VAR_in_param337); 
					match(input,ID,FOLLOW_ID_in_param339); 
					pushFollow(FOLLOW_param_cont_in_param341);
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
	// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:35:1: param_cont : (| COMMA VAR ID param_cont );
	public final void param_cont() throws Exception  {
		try {
			// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:36:2: (| COMMA VAR ID param_cont )
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
					// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:37:3: 
					{
					}
					break;
				case 2 :
					// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:37:5: COMMA VAR ID param_cont
					{
					match(input,COMMA,FOLLOW_COMMA_in_param_cont360); 
					match(input,VAR,FOLLOW_VAR_in_param_cont362); 
					match(input,ID,FOLLOW_ID_in_param_cont364); 
					pushFollow(FOLLOW_param_cont_in_param_cont366);
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
	// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:40:1: variable_assignments : assignment more_assignments ;
	public final void variable_assignments() throws Exception  {
		try {
			// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:41:2: ( assignment more_assignments )
			// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:42:3: assignment more_assignments
			{
			pushFollow(FOLLOW_assignment_in_variable_assignments382);
			assignment();
			state._fsp--;

			pushFollow(FOLLOW_more_assignments_in_variable_assignments384);
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
	// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:45:1: more_assignments : (| assignment more_assignments );
	public final void more_assignments() throws Exception  {
		try {
			// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:46:2: (| assignment more_assignments )
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==ENDFUNCTION||LA4_0==ID) ) {
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
					// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:47:3: 
					{
					}
					break;
				case 2 :
					// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:47:5: assignment more_assignments
					{
					pushFollow(FOLLOW_assignment_in_more_assignments403);
					assignment();
					state._fsp--;

					pushFollow(FOLLOW_more_assignments_in_more_assignments405);
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
	// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:50:1: assignment : VAR ID ASSIGN VALUE ;
	public final void assignment() throws Exception  {
		try {
			// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:51:2: ( VAR ID ASSIGN VALUE )
			// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:52:3: VAR ID ASSIGN VALUE
			{
			match(input,VAR,FOLLOW_VAR_in_assignment422); 
			match(input,ID,FOLLOW_ID_in_assignment424); 
			match(input,ASSIGN,FOLLOW_ASSIGN_in_assignment426); 
			match(input,VALUE,FOLLOW_VALUE_in_assignment428); 
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
	// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:55:1: compound_statement : (| statement compound_statement );
	public final void compound_statement() throws Exception  {
		try {
			// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:55:19: (| statement compound_statement )
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==ENDFUNCTION) ) {
				alt5=1;
			}
			else if ( (LA5_0==ID) ) {
				alt5=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}

			switch (alt5) {
				case 1 :
					// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:57:3: 
					{
					}
					break;
				case 2 :
					// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:57:4: statement compound_statement
					{
					pushFollow(FOLLOW_statement_in_compound_statement444);
					statement();
					state._fsp--;

					pushFollow(FOLLOW_compound_statement_in_compound_statement446);
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
	// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:60:1: statement : arithmatic_expression ;
	public final void statement() throws Exception  {
		try {
			// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:60:10: ( arithmatic_expression )
			// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:61:3: arithmatic_expression
			{
			pushFollow(FOLLOW_arithmatic_expression_in_statement459);
			arithmatic_expression();
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
	// $ANTLR end "statement"



	// $ANTLR start "arithmatic_expression"
	// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:65:1: arithmatic_expression : ID ASSIGN term arith_recurse ;
	public final void arithmatic_expression() throws Exception  {
		try {
			// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:66:2: ( ID ASSIGN term arith_recurse )
			// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:67:3: ID ASSIGN term arith_recurse
			{
			match(input,ID,FOLLOW_ID_in_arithmatic_expression475); 
			match(input,ASSIGN,FOLLOW_ASSIGN_in_arithmatic_expression477); 
			pushFollow(FOLLOW_term_in_arithmatic_expression479);
			term();
			state._fsp--;

			pushFollow(FOLLOW_arith_recurse_in_arithmatic_expression481);
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
	// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:70:1: arith_recurse : (| operator term | operator LPAREN term arith_recurse RPAREN );
	public final void arith_recurse() throws Exception  {
		try {
			// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:71:2: (| operator term | operator LPAREN term arith_recurse RPAREN )
			int alt6=3;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==ENDFUNCTION||LA6_0==ID||LA6_0==RPAREN) ) {
				alt6=1;
			}
			else if ( ((LA6_0 >= MINUS && LA6_0 <= PLUS)||(LA6_0 >= SLASH && LA6_0 <= STAR)) ) {
				int LA6_2 = input.LA(2);
				if ( (LA6_2==ID||LA6_2==VALUE) ) {
					alt6=2;
				}
				else if ( (LA6_2==LPAREN) ) {
					alt6=3;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 6, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}

			switch (alt6) {
				case 1 :
					// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:72:3: 
					{
					}
					break;
				case 2 :
					// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:72:5: operator term
					{
					pushFollow(FOLLOW_operator_in_arith_recurse500);
					operator();
					state._fsp--;

					pushFollow(FOLLOW_term_in_arith_recurse502);
					term();
					state._fsp--;

					}
					break;
				case 3 :
					// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:73:5: operator LPAREN term arith_recurse RPAREN
					{
					pushFollow(FOLLOW_operator_in_arith_recurse508);
					operator();
					state._fsp--;

					match(input,LPAREN,FOLLOW_LPAREN_in_arith_recurse510); 
					pushFollow(FOLLOW_term_in_arith_recurse512);
					term();
					state._fsp--;

					pushFollow(FOLLOW_arith_recurse_in_arith_recurse514);
					arith_recurse();
					state._fsp--;

					match(input,RPAREN,FOLLOW_RPAREN_in_arith_recurse516); 
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



	// $ANTLR start "operator"
	// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:76:1: operator : ( PLUS | MINUS | STAR | SLASH );
	public final void operator() throws Exception  {
		try {
			// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:76:9: ( PLUS | MINUS | STAR | SLASH )
			// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:
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
	// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:83:1: term : ( ID | VALUE );
	public final void term() throws Exception  {
		try {
			// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:83:6: ( ID | VALUE )
			// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:
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



	public static final BitSet FOLLOW_CLASS_in_file264 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_ID_in_file266 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_func_in_file268 = new BitSet(new long[]{0x0000000000000280L});
	public static final BitSet FOLLOW_function_list_in_file270 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_ENDCLASS_in_file272 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_func_in_function_list288 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_function_list_in_function_list290 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FUNCTION_in_func306 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_ID_in_func308 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_LPAREN_in_func310 = new BitSet(new long[]{0x0000000000044000L});
	public static final BitSet FOLLOW_param_in_func312 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_RPAREN_in_func314 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_variable_assignments_in_func316 = new BitSet(new long[]{0x0000000000000500L});
	public static final BitSet FOLLOW_compound_statement_in_func318 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_ENDFUNCTION_in_func320 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_in_param337 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_ID_in_param339 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_param_cont_in_param341 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_COMMA_in_param_cont360 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_VAR_in_param_cont362 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_ID_in_param_cont364 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_param_cont_in_param_cont366 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_assignment_in_variable_assignments382 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_more_assignments_in_variable_assignments384 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_assignment_in_more_assignments403 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_more_assignments_in_more_assignments405 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_in_assignment422 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_ID_in_assignment424 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ASSIGN_in_assignment426 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_VALUE_in_assignment428 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_statement_in_compound_statement444 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_compound_statement_in_compound_statement446 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_arithmatic_expression_in_statement459 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_arithmatic_expression475 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ASSIGN_in_arithmatic_expression477 = new BitSet(new long[]{0x0000000000020400L});
	public static final BitSet FOLLOW_term_in_arithmatic_expression479 = new BitSet(new long[]{0x000000000001B000L});
	public static final BitSet FOLLOW_arith_recurse_in_arithmatic_expression481 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_operator_in_arith_recurse500 = new BitSet(new long[]{0x0000000000020400L});
	public static final BitSet FOLLOW_term_in_arith_recurse502 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_operator_in_arith_recurse508 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_LPAREN_in_arith_recurse510 = new BitSet(new long[]{0x0000000000020400L});
	public static final BitSet FOLLOW_term_in_arith_recurse512 = new BitSet(new long[]{0x000000000001F000L});
	public static final BitSet FOLLOW_arith_recurse_in_arith_recurse514 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_RPAREN_in_arith_recurse516 = new BitSet(new long[]{0x0000000000000002L});
}
