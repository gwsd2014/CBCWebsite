package language;

// $ANTLR 3.5 C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g 2013-11-03 21:08:07

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class LanguageLexer extends Lexer {
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
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public LanguageLexer() {} 
	public LanguageLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public LanguageLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g"; }

	// $ANTLR start "ASSIGN"
	public final void mASSIGN() throws RecognitionException {
		try {
			int _type = ASSIGN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:2:8: ( '=' )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:2:10: '='
			{
			match('='); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ASSIGN"

	// $ANTLR start "CLASS"
	public final void mCLASS() throws RecognitionException {
		try {
			int _type = CLASS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:3:7: ( 'class' )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:3:9: 'class'
			{
			match("class"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CLASS"

	// $ANTLR start "COMMA"
	public final void mCOMMA() throws RecognitionException {
		try {
			int _type = COMMA;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:4:7: ( ',' )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:4:9: ','
			{
			match(','); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMA"

	// $ANTLR start "ELSE"
	public final void mELSE() throws RecognitionException {
		try {
			int _type = ELSE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:5:6: ( 'else' )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:5:8: 'else'
			{
			match("else"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ELSE"

	// $ANTLR start "ENDCLASS"
	public final void mENDCLASS() throws RecognitionException {
		try {
			int _type = ENDCLASS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:6:10: ( 'endclass' )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:6:12: 'endclass'
			{
			match("endclass"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ENDCLASS"

	// $ANTLR start "ENDELSE"
	public final void mENDELSE() throws RecognitionException {
		try {
			int _type = ENDELSE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:7:9: ( 'endelse' )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:7:11: 'endelse'
			{
			match("endelse"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ENDELSE"

	// $ANTLR start "ENDFUNCTION"
	public final void mENDFUNCTION() throws RecognitionException {
		try {
			int _type = ENDFUNCTION;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:8:13: ( 'endfunction' )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:8:15: 'endfunction'
			{
			match("endfunction"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ENDFUNCTION"

	// $ANTLR start "ENDIF"
	public final void mENDIF() throws RecognitionException {
		try {
			int _type = ENDIF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:9:7: ( 'endif' )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:9:9: 'endif'
			{
			match("endif"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ENDIF"

	// $ANTLR start "EQUALS"
	public final void mEQUALS() throws RecognitionException {
		try {
			int _type = EQUALS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:10:8: ( '==' )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:10:10: '=='
			{
			match("=="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EQUALS"

	// $ANTLR start "FUNCTION"
	public final void mFUNCTION() throws RecognitionException {
		try {
			int _type = FUNCTION;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:11:10: ( 'function' )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:11:12: 'function'
			{
			match("function"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FUNCTION"

	// $ANTLR start "IF"
	public final void mIF() throws RecognitionException {
		try {
			int _type = IF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:12:4: ( 'if' )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:12:6: 'if'
			{
			match("if"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IF"

	// $ANTLR start "LPAREN"
	public final void mLPAREN() throws RecognitionException {
		try {
			int _type = LPAREN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:13:8: ( '(' )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:13:10: '('
			{
			match('('); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LPAREN"

	// $ANTLR start "MINUS"
	public final void mMINUS() throws RecognitionException {
		try {
			int _type = MINUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:14:7: ( '-' )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:14:9: '-'
			{
			match('-'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MINUS"

	// $ANTLR start "PLUS"
	public final void mPLUS() throws RecognitionException {
		try {
			int _type = PLUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:15:6: ( '+' )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:15:8: '+'
			{
			match('+'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PLUS"

	// $ANTLR start "RPAREN"
	public final void mRPAREN() throws RecognitionException {
		try {
			int _type = RPAREN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:16:8: ( ')' )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:16:10: ')'
			{
			match(')'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RPAREN"

	// $ANTLR start "SLASH"
	public final void mSLASH() throws RecognitionException {
		try {
			int _type = SLASH;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:17:7: ( '/' )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:17:9: '/'
			{
			match('/'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SLASH"

	// $ANTLR start "STAR"
	public final void mSTAR() throws RecognitionException {
		try {
			int _type = STAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:18:6: ( '*' )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:18:8: '*'
			{
			match('*'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STAR"

	// $ANTLR start "VAR"
	public final void mVAR() throws RecognitionException {
		try {
			int _type = VAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:19:5: ( 'var' )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:19:7: 'var'
			{
			match("var"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "VAR"

	// $ANTLR start "ID"
	public final void mID() throws RecognitionException {
		try {
			int _type = ID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:109:7: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' )* )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:109:9: ( 'a' .. 'z' | 'A' .. 'Z' ) ( '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:109:30: ( '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= '0' && LA1_0 <= '9')||(LA1_0 >= 'A' && LA1_0 <= 'Z')||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop1;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ID"

	// $ANTLR start "VALUE"
	public final void mVALUE() throws RecognitionException {
		try {
			int _type = VALUE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:110:10: ( ( '-' )? ( '0' .. '9' )+ )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:110:12: ( '-' )? ( '0' .. '9' )+
			{
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:110:12: ( '-' )?
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0=='-') ) {
				alt2=1;
			}
			switch (alt2) {
				case 1 :
					// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:110:12: '-'
					{
					match('-'); 
					}
					break;

			}

			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:110:16: ( '0' .. '9' )+
			int cnt3=0;
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( ((LA3_0 >= '0' && LA3_0 <= '9')) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt3 >= 1 ) break loop3;
					EarlyExitException eee = new EarlyExitException(3, input);
					throw eee;
				}
				cnt3++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "VALUE"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:111:8: ( ( ' ' | '\\t' | '\\r' | '\\n' ) )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:111:10: ( ' ' | '\\t' | '\\r' | '\\n' )
			{
			if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			_channel=HIDDEN;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WS"

	@Override
	public void mTokens() throws RecognitionException {
		// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:8: ( ASSIGN | CLASS | COMMA | ELSE | ENDCLASS | ENDELSE | ENDFUNCTION | ENDIF | EQUALS | FUNCTION | IF | LPAREN | MINUS | PLUS | RPAREN | SLASH | STAR | VAR | ID | VALUE | WS )
		int alt4=21;
		alt4 = dfa4.predict(input);
		switch (alt4) {
			case 1 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:10: ASSIGN
				{
				mASSIGN(); 

				}
				break;
			case 2 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:17: CLASS
				{
				mCLASS(); 

				}
				break;
			case 3 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:23: COMMA
				{
				mCOMMA(); 

				}
				break;
			case 4 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:29: ELSE
				{
				mELSE(); 

				}
				break;
			case 5 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:34: ENDCLASS
				{
				mENDCLASS(); 

				}
				break;
			case 6 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:43: ENDELSE
				{
				mENDELSE(); 

				}
				break;
			case 7 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:51: ENDFUNCTION
				{
				mENDFUNCTION(); 

				}
				break;
			case 8 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:63: ENDIF
				{
				mENDIF(); 

				}
				break;
			case 9 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:69: EQUALS
				{
				mEQUALS(); 

				}
				break;
			case 10 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:76: FUNCTION
				{
				mFUNCTION(); 

				}
				break;
			case 11 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:85: IF
				{
				mIF(); 

				}
				break;
			case 12 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:88: LPAREN
				{
				mLPAREN(); 

				}
				break;
			case 13 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:95: MINUS
				{
				mMINUS(); 

				}
				break;
			case 14 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:101: PLUS
				{
				mPLUS(); 

				}
				break;
			case 15 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:106: RPAREN
				{
				mRPAREN(); 

				}
				break;
			case 16 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:113: SLASH
				{
				mSLASH(); 

				}
				break;
			case 17 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:119: STAR
				{
				mSTAR(); 

				}
				break;
			case 18 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:124: VAR
				{
				mVAR(); 

				}
				break;
			case 19 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:128: ID
				{
				mID(); 

				}
				break;
			case 20 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:131: VALUE
				{
				mVALUE(); 

				}
				break;
			case 21 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:137: WS
				{
				mWS(); 

				}
				break;

		}
	}


	protected DFA4 dfa4 = new DFA4(this);
	static final String DFA4_eotS =
		"\1\uffff\1\22\1\16\1\uffff\3\16\1\uffff\1\30\4\uffff\1\16\5\uffff\4\16"+
		"\1\36\1\uffff\5\16\1\uffff\1\47\1\16\1\51\5\16\1\uffff\1\57\1\uffff\3"+
		"\16\1\63\1\16\1\uffff\3\16\1\uffff\2\16\1\72\2\16\1\75\1\uffff\1\16\1"+
		"\77\1\uffff\1\16\1\uffff\1\16\1\102\1\uffff";
	static final String DFA4_eofS =
		"\103\uffff";
	static final String DFA4_minS =
		"\1\11\1\75\1\154\1\uffff\1\154\1\165\1\146\1\uffff\1\60\4\uffff\1\141"+
		"\5\uffff\1\141\1\163\1\144\1\156\1\60\1\uffff\1\162\1\163\1\145\2\143"+
		"\1\uffff\1\60\1\163\1\60\2\154\1\165\1\146\1\164\1\uffff\1\60\1\uffff"+
		"\1\141\1\163\1\156\1\60\1\151\1\uffff\1\163\1\145\1\143\1\uffff\1\157"+
		"\1\163\1\60\1\164\1\156\1\60\1\uffff\1\151\1\60\1\uffff\1\157\1\uffff"+
		"\1\156\1\60\1\uffff";
	static final String DFA4_maxS =
		"\1\172\1\75\1\154\1\uffff\1\156\1\165\1\146\1\uffff\1\71\4\uffff\1\141"+
		"\5\uffff\1\141\1\163\1\144\1\156\1\172\1\uffff\1\162\1\163\1\145\1\151"+
		"\1\143\1\uffff\1\172\1\163\1\172\2\154\1\165\1\146\1\164\1\uffff\1\172"+
		"\1\uffff\1\141\1\163\1\156\1\172\1\151\1\uffff\1\163\1\145\1\143\1\uffff"+
		"\1\157\1\163\1\172\1\164\1\156\1\172\1\uffff\1\151\1\172\1\uffff\1\157"+
		"\1\uffff\1\156\1\172\1\uffff";
	static final String DFA4_acceptS =
		"\3\uffff\1\3\3\uffff\1\14\1\uffff\1\16\1\17\1\20\1\21\1\uffff\1\23\1\24"+
		"\1\25\1\11\1\1\5\uffff\1\15\5\uffff\1\13\10\uffff\1\22\1\uffff\1\4\5\uffff"+
		"\1\2\3\uffff\1\10\6\uffff\1\6\2\uffff\1\5\1\uffff\1\12\2\uffff\1\7";
	static final String DFA4_specialS =
		"\103\uffff}>";
	static final String[] DFA4_transitionS = {
			"\2\20\2\uffff\1\20\22\uffff\1\20\7\uffff\1\7\1\12\1\14\1\11\1\3\1\10"+
			"\1\uffff\1\13\12\17\3\uffff\1\1\3\uffff\32\16\6\uffff\2\16\1\2\1\16\1"+
			"\4\1\5\2\16\1\6\14\16\1\15\4\16",
			"\1\21",
			"\1\23",
			"",
			"\1\24\1\uffff\1\25",
			"\1\26",
			"\1\27",
			"",
			"\12\17",
			"",
			"",
			"",
			"",
			"\1\31",
			"",
			"",
			"",
			"",
			"",
			"\1\32",
			"\1\33",
			"\1\34",
			"\1\35",
			"\12\16\7\uffff\32\16\6\uffff\32\16",
			"",
			"\1\37",
			"\1\40",
			"\1\41",
			"\1\42\1\uffff\1\43\1\44\2\uffff\1\45",
			"\1\46",
			"",
			"\12\16\7\uffff\32\16\6\uffff\32\16",
			"\1\50",
			"\12\16\7\uffff\32\16\6\uffff\32\16",
			"\1\52",
			"\1\53",
			"\1\54",
			"\1\55",
			"\1\56",
			"",
			"\12\16\7\uffff\32\16\6\uffff\32\16",
			"",
			"\1\60",
			"\1\61",
			"\1\62",
			"\12\16\7\uffff\32\16\6\uffff\32\16",
			"\1\64",
			"",
			"\1\65",
			"\1\66",
			"\1\67",
			"",
			"\1\70",
			"\1\71",
			"\12\16\7\uffff\32\16\6\uffff\32\16",
			"\1\73",
			"\1\74",
			"\12\16\7\uffff\32\16\6\uffff\32\16",
			"",
			"\1\76",
			"\12\16\7\uffff\32\16\6\uffff\32\16",
			"",
			"\1\100",
			"",
			"\1\101",
			"\12\16\7\uffff\32\16\6\uffff\32\16",
			""
	};

	static final short[] DFA4_eot = DFA.unpackEncodedString(DFA4_eotS);
	static final short[] DFA4_eof = DFA.unpackEncodedString(DFA4_eofS);
	static final char[] DFA4_min = DFA.unpackEncodedStringToUnsignedChars(DFA4_minS);
	static final char[] DFA4_max = DFA.unpackEncodedStringToUnsignedChars(DFA4_maxS);
	static final short[] DFA4_accept = DFA.unpackEncodedString(DFA4_acceptS);
	static final short[] DFA4_special = DFA.unpackEncodedString(DFA4_specialS);
	static final short[][] DFA4_transition;

	static {
		int numStates = DFA4_transitionS.length;
		DFA4_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA4_transition[i] = DFA.unpackEncodedString(DFA4_transitionS[i]);
		}
	}

	protected class DFA4 extends DFA {

		public DFA4(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 4;
			this.eot = DFA4_eot;
			this.eof = DFA4_eof;
			this.min = DFA4_min;
			this.max = DFA4_max;
			this.accept = DFA4_accept;
			this.special = DFA4_special;
			this.transition = DFA4_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( ASSIGN | CLASS | COMMA | ELSE | ENDCLASS | ENDELSE | ENDFUNCTION | ENDIF | EQUALS | FUNCTION | IF | LPAREN | MINUS | PLUS | RPAREN | SLASH | STAR | VAR | ID | VALUE | WS );";
		}
	}

}
