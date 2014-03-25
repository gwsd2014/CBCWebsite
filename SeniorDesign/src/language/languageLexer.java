package language;

// $ANTLR 3.5 C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g 2014-01-02 18:28:27

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class LanguageLexer extends Lexer {
	public static final int EOF=-1;
	public static final int ARR=4;
	public static final int ASSIGN=5;
	public static final int CLASS=6;
	public static final int COMMA=7;
	public static final int DECREASE=8;
	public static final int ELSE=9;
	public static final int ENDCLASS=10;
	public static final int ENDELSE=11;
	public static final int ENDFOR=12;
	public static final int ENDFUNCTION=13;
	public static final int ENDIF=14;
	public static final int ENDWHILE=15;
	public static final int EQUALS=16;
	public static final int FOR=17;
	public static final int FUNCTION=18;
	public static final int GT=19;
	public static final int GTE=20;
	public static final int ID=21;
	public static final int IF=22;
	public static final int INCREASE=23;
	public static final int LPAREN=24;
	public static final int LT=25;
	public static final int LTE=26;
	public static final int MINUS=27;
	public static final int PLUS=28;
	public static final int RETURN=29;
	public static final int RPAREN=30;
	public static final int SEMICOLON=31;
	public static final int SLASH=32;
	public static final int STAR=33;
	public static final int VALUE=34;
	public static final int VAR=35;
	public static final int WHILE=36;
	public static final int WS=37;

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

	// $ANTLR start "ARR"
	public final void mARR() throws RecognitionException {
		try {
			int _type = ARR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:2:5: ( 'arr' )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:2:7: 'arr'
			{
			match("arr"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ARR"

	// $ANTLR start "ASSIGN"
	public final void mASSIGN() throws RecognitionException {
		try {
			int _type = ASSIGN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:3:8: ( '=' )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:3:10: '='
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
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:4:7: ( 'class' )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:4:9: 'class'
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
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:5:7: ( ',' )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:5:9: ','
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

	// $ANTLR start "DECREASE"
	public final void mDECREASE() throws RecognitionException {
		try {
			int _type = DECREASE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:6:10: ( '--' )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:6:12: '--'
			{
			match("--"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DECREASE"

	// $ANTLR start "ELSE"
	public final void mELSE() throws RecognitionException {
		try {
			int _type = ELSE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:7:6: ( 'else' )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:7:8: 'else'
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
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:8:10: ( 'endclass' )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:8:12: 'endclass'
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
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:9:9: ( 'endelse' )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:9:11: 'endelse'
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

	// $ANTLR start "ENDFOR"
	public final void mENDFOR() throws RecognitionException {
		try {
			int _type = ENDFOR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:10:8: ( 'endfor' )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:10:10: 'endfor'
			{
			match("endfor"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ENDFOR"

	// $ANTLR start "ENDFUNCTION"
	public final void mENDFUNCTION() throws RecognitionException {
		try {
			int _type = ENDFUNCTION;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:11:13: ( 'endfunction' )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:11:15: 'endfunction'
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
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:12:7: ( 'endif' )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:12:9: 'endif'
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

	// $ANTLR start "ENDWHILE"
	public final void mENDWHILE() throws RecognitionException {
		try {
			int _type = ENDWHILE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:13:10: ( 'endwhile' )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:13:12: 'endwhile'
			{
			match("endwhile"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ENDWHILE"

	// $ANTLR start "EQUALS"
	public final void mEQUALS() throws RecognitionException {
		try {
			int _type = EQUALS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:14:8: ( '==' )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:14:10: '=='
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

	// $ANTLR start "FOR"
	public final void mFOR() throws RecognitionException {
		try {
			int _type = FOR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:15:5: ( 'for' )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:15:7: 'for'
			{
			match("for"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FOR"

	// $ANTLR start "FUNCTION"
	public final void mFUNCTION() throws RecognitionException {
		try {
			int _type = FUNCTION;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:16:10: ( 'function' )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:16:12: 'function'
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

	// $ANTLR start "GT"
	public final void mGT() throws RecognitionException {
		try {
			int _type = GT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:17:4: ( '>' )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:17:6: '>'
			{
			match('>'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "GT"

	// $ANTLR start "GTE"
	public final void mGTE() throws RecognitionException {
		try {
			int _type = GTE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:18:5: ( '>=' )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:18:7: '>='
			{
			match(">="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "GTE"

	// $ANTLR start "IF"
	public final void mIF() throws RecognitionException {
		try {
			int _type = IF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:19:4: ( 'if' )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:19:6: 'if'
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

	// $ANTLR start "INCREASE"
	public final void mINCREASE() throws RecognitionException {
		try {
			int _type = INCREASE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:20:10: ( '++' )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:20:12: '++'
			{
			match("++"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INCREASE"

	// $ANTLR start "LPAREN"
	public final void mLPAREN() throws RecognitionException {
		try {
			int _type = LPAREN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:21:8: ( '(' )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:21:10: '('
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

	// $ANTLR start "LT"
	public final void mLT() throws RecognitionException {
		try {
			int _type = LT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:22:4: ( '<' )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:22:6: '<'
			{
			match('<'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LT"

	// $ANTLR start "LTE"
	public final void mLTE() throws RecognitionException {
		try {
			int _type = LTE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:23:5: ( '<=' )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:23:7: '<='
			{
			match("<="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LTE"

	// $ANTLR start "MINUS"
	public final void mMINUS() throws RecognitionException {
		try {
			int _type = MINUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:24:7: ( '-' )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:24:9: '-'
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
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:25:6: ( '+' )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:25:8: '+'
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

	// $ANTLR start "RETURN"
	public final void mRETURN() throws RecognitionException {
		try {
			int _type = RETURN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:26:8: ( 'return' )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:26:10: 'return'
			{
			match("return"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RETURN"

	// $ANTLR start "RPAREN"
	public final void mRPAREN() throws RecognitionException {
		try {
			int _type = RPAREN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:27:8: ( ')' )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:27:10: ')'
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

	// $ANTLR start "SEMICOLON"
	public final void mSEMICOLON() throws RecognitionException {
		try {
			int _type = SEMICOLON;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:28:11: ( ';' )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:28:13: ';'
			{
			match(';'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SEMICOLON"

	// $ANTLR start "SLASH"
	public final void mSLASH() throws RecognitionException {
		try {
			int _type = SLASH;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:29:7: ( '/' )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:29:9: '/'
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
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:30:6: ( '*' )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:30:8: '*'
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
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:31:5: ( 'var' )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:31:7: 'var'
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

	// $ANTLR start "WHILE"
	public final void mWHILE() throws RecognitionException {
		try {
			int _type = WHILE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:32:7: ( 'while' )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:32:9: 'while'
			{
			match("while"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WHILE"

	// $ANTLR start "ID"
	public final void mID() throws RecognitionException {
		try {
			int _type = ID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:178:7: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' | '[' | ']' )* )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:178:9: ( 'a' .. 'z' | 'A' .. 'Z' ) ( '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' | '[' | ']' )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:178:30: ( '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' | '[' | ']' )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= '0' && LA1_0 <= '9')||(LA1_0 >= 'A' && LA1_0 <= '[')||LA1_0==']'||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= '[')||input.LA(1)==']'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
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
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:179:10: ( ( '-' )? ( '0' .. '9' )+ )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:179:12: ( '-' )? ( '0' .. '9' )+
			{
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:179:12: ( '-' )?
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0=='-') ) {
				alt2=1;
			}
			switch (alt2) {
				case 1 :
					// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:179:12: '-'
					{
					match('-'); 
					}
					break;

			}

			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:179:16: ( '0' .. '9' )+
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
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:180:8: ( ( ' ' | '\\t' | '\\r' | '\\n' ) )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:180:10: ( ' ' | '\\t' | '\\r' | '\\n' )
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
		// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:8: ( ARR | ASSIGN | CLASS | COMMA | DECREASE | ELSE | ENDCLASS | ENDELSE | ENDFOR | ENDFUNCTION | ENDIF | ENDWHILE | EQUALS | FOR | FUNCTION | GT | GTE | IF | INCREASE | LPAREN | LT | LTE | MINUS | PLUS | RETURN | RPAREN | SEMICOLON | SLASH | STAR | VAR | WHILE | ID | VALUE | WS )
		int alt4=34;
		alt4 = dfa4.predict(input);
		switch (alt4) {
			case 1 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:10: ARR
				{
				mARR(); 

				}
				break;
			case 2 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:14: ASSIGN
				{
				mASSIGN(); 

				}
				break;
			case 3 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:21: CLASS
				{
				mCLASS(); 

				}
				break;
			case 4 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:27: COMMA
				{
				mCOMMA(); 

				}
				break;
			case 5 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:33: DECREASE
				{
				mDECREASE(); 

				}
				break;
			case 6 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:42: ELSE
				{
				mELSE(); 

				}
				break;
			case 7 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:47: ENDCLASS
				{
				mENDCLASS(); 

				}
				break;
			case 8 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:56: ENDELSE
				{
				mENDELSE(); 

				}
				break;
			case 9 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:64: ENDFOR
				{
				mENDFOR(); 

				}
				break;
			case 10 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:71: ENDFUNCTION
				{
				mENDFUNCTION(); 

				}
				break;
			case 11 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:83: ENDIF
				{
				mENDIF(); 

				}
				break;
			case 12 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:89: ENDWHILE
				{
				mENDWHILE(); 

				}
				break;
			case 13 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:98: EQUALS
				{
				mEQUALS(); 

				}
				break;
			case 14 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:105: FOR
				{
				mFOR(); 

				}
				break;
			case 15 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:109: FUNCTION
				{
				mFUNCTION(); 

				}
				break;
			case 16 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:118: GT
				{
				mGT(); 

				}
				break;
			case 17 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:121: GTE
				{
				mGTE(); 

				}
				break;
			case 18 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:125: IF
				{
				mIF(); 

				}
				break;
			case 19 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:128: INCREASE
				{
				mINCREASE(); 

				}
				break;
			case 20 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:137: LPAREN
				{
				mLPAREN(); 

				}
				break;
			case 21 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:144: LT
				{
				mLT(); 

				}
				break;
			case 22 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:147: LTE
				{
				mLTE(); 

				}
				break;
			case 23 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:151: MINUS
				{
				mMINUS(); 

				}
				break;
			case 24 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:157: PLUS
				{
				mPLUS(); 

				}
				break;
			case 25 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:162: RETURN
				{
				mRETURN(); 

				}
				break;
			case 26 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:169: RPAREN
				{
				mRPAREN(); 

				}
				break;
			case 27 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:176: SEMICOLON
				{
				mSEMICOLON(); 

				}
				break;
			case 28 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:186: SLASH
				{
				mSLASH(); 

				}
				break;
			case 29 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:192: STAR
				{
				mSTAR(); 

				}
				break;
			case 30 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:197: VAR
				{
				mVAR(); 

				}
				break;
			case 31 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:201: WHILE
				{
				mWHILE(); 

				}
				break;
			case 32 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:207: ID
				{
				mID(); 

				}
				break;
			case 33 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:210: VALUE
				{
				mVALUE(); 

				}
				break;
			case 34 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:216: WS
				{
				mWS(); 

				}
				break;

		}
	}


	protected DFA4 dfa4 = new DFA4(this);
	static final String DFA4_eotS =
		"\1\uffff\1\24\1\31\1\24\1\uffff\1\34\2\24\1\42\1\24\1\45\1\uffff\1\47"+
		"\1\24\4\uffff\2\24\3\uffff\1\24\2\uffff\1\24\2\uffff\4\24\2\uffff\1\61"+
		"\4\uffff\3\24\1\65\3\24\1\75\1\24\1\uffff\1\24\1\100\1\24\1\uffff\1\24"+
		"\1\103\5\24\1\uffff\2\24\1\uffff\1\24\1\115\1\uffff\4\24\1\122\3\24\1"+
		"\126\1\uffff\2\24\1\131\1\24\1\uffff\2\24\1\135\1\uffff\1\24\1\137\1\uffff"+
		"\3\24\1\uffff\1\143\1\uffff\1\24\1\145\1\146\1\uffff\1\24\2\uffff\1\24"+
		"\1\151\1\uffff";
	static final String DFA4_eofS =
		"\152\uffff";
	static final String DFA4_minS =
		"\1\11\1\162\1\75\1\154\1\uffff\1\55\1\154\1\157\1\75\1\146\1\53\1\uffff"+
		"\1\75\1\145\4\uffff\1\141\1\150\3\uffff\1\162\2\uffff\1\141\2\uffff\1"+
		"\163\1\144\1\162\1\156\2\uffff\1\60\4\uffff\1\164\1\162\1\151\1\60\1\163"+
		"\1\145\1\143\1\60\1\143\1\uffff\1\165\1\60\1\154\1\uffff\1\163\1\60\2"+
		"\154\1\157\1\146\1\150\1\uffff\1\164\1\162\1\uffff\1\145\1\60\1\uffff"+
		"\1\141\1\163\1\162\1\156\1\60\2\151\1\156\1\60\1\uffff\1\163\1\145\1\60"+
		"\1\143\1\uffff\1\154\1\157\1\60\1\uffff\1\163\1\60\1\uffff\1\164\1\145"+
		"\1\156\1\uffff\1\60\1\uffff\1\151\2\60\1\uffff\1\157\2\uffff\1\156\1\60"+
		"\1\uffff";
	static final String DFA4_maxS =
		"\1\172\1\162\1\75\1\154\1\uffff\1\71\1\156\1\165\1\75\1\146\1\53\1\uffff"+
		"\1\75\1\145\4\uffff\1\141\1\150\3\uffff\1\162\2\uffff\1\141\2\uffff\1"+
		"\163\1\144\1\162\1\156\2\uffff\1\172\4\uffff\1\164\1\162\1\151\1\172\1"+
		"\163\1\145\1\167\1\172\1\143\1\uffff\1\165\1\172\1\154\1\uffff\1\163\1"+
		"\172\2\154\1\165\1\146\1\150\1\uffff\1\164\1\162\1\uffff\1\145\1\172\1"+
		"\uffff\1\141\1\163\1\162\1\156\1\172\2\151\1\156\1\172\1\uffff\1\163\1"+
		"\145\1\172\1\143\1\uffff\1\154\1\157\1\172\1\uffff\1\163\1\172\1\uffff"+
		"\1\164\1\145\1\156\1\uffff\1\172\1\uffff\1\151\2\172\1\uffff\1\157\2\uffff"+
		"\1\156\1\172\1\uffff";
	static final String DFA4_acceptS =
		"\4\uffff\1\4\6\uffff\1\24\2\uffff\1\32\1\33\1\34\1\35\2\uffff\1\40\1\41"+
		"\1\42\1\uffff\1\15\1\2\1\uffff\1\5\1\27\4\uffff\1\21\1\20\1\uffff\1\23"+
		"\1\30\1\26\1\25\11\uffff\1\22\3\uffff\1\1\7\uffff\1\16\2\uffff\1\36\2"+
		"\uffff\1\6\11\uffff\1\3\4\uffff\1\13\3\uffff\1\37\2\uffff\1\11\3\uffff"+
		"\1\31\1\uffff\1\10\3\uffff\1\7\1\uffff\1\14\1\17\2\uffff\1\12";
	static final String DFA4_specialS =
		"\152\uffff}>";
	static final String[] DFA4_transitionS = {
			"\2\26\2\uffff\1\26\22\uffff\1\26\7\uffff\1\13\1\16\1\21\1\12\1\4\1\5"+
			"\1\uffff\1\20\12\25\1\uffff\1\17\1\14\1\2\1\10\2\uffff\32\24\6\uffff"+
			"\1\1\1\24\1\3\1\24\1\6\1\7\2\24\1\11\10\24\1\15\3\24\1\22\1\23\3\24",
			"\1\27",
			"\1\30",
			"\1\32",
			"",
			"\1\33\2\uffff\12\25",
			"\1\35\1\uffff\1\36",
			"\1\37\5\uffff\1\40",
			"\1\41",
			"\1\43",
			"\1\44",
			"",
			"\1\46",
			"\1\50",
			"",
			"",
			"",
			"",
			"\1\51",
			"\1\52",
			"",
			"",
			"",
			"\1\53",
			"",
			"",
			"\1\54",
			"",
			"",
			"\1\55",
			"\1\56",
			"\1\57",
			"\1\60",
			"",
			"",
			"\12\24\7\uffff\33\24\1\uffff\1\24\3\uffff\32\24",
			"",
			"",
			"",
			"",
			"\1\62",
			"\1\63",
			"\1\64",
			"\12\24\7\uffff\33\24\1\uffff\1\24\3\uffff\32\24",
			"\1\66",
			"\1\67",
			"\1\70\1\uffff\1\71\1\72\2\uffff\1\73\15\uffff\1\74",
			"\12\24\7\uffff\33\24\1\uffff\1\24\3\uffff\32\24",
			"\1\76",
			"",
			"\1\77",
			"\12\24\7\uffff\33\24\1\uffff\1\24\3\uffff\32\24",
			"\1\101",
			"",
			"\1\102",
			"\12\24\7\uffff\33\24\1\uffff\1\24\3\uffff\32\24",
			"\1\104",
			"\1\105",
			"\1\106\5\uffff\1\107",
			"\1\110",
			"\1\111",
			"",
			"\1\112",
			"\1\113",
			"",
			"\1\114",
			"\12\24\7\uffff\33\24\1\uffff\1\24\3\uffff\32\24",
			"",
			"\1\116",
			"\1\117",
			"\1\120",
			"\1\121",
			"\12\24\7\uffff\33\24\1\uffff\1\24\3\uffff\32\24",
			"\1\123",
			"\1\124",
			"\1\125",
			"\12\24\7\uffff\33\24\1\uffff\1\24\3\uffff\32\24",
			"",
			"\1\127",
			"\1\130",
			"\12\24\7\uffff\33\24\1\uffff\1\24\3\uffff\32\24",
			"\1\132",
			"",
			"\1\133",
			"\1\134",
			"\12\24\7\uffff\33\24\1\uffff\1\24\3\uffff\32\24",
			"",
			"\1\136",
			"\12\24\7\uffff\33\24\1\uffff\1\24\3\uffff\32\24",
			"",
			"\1\140",
			"\1\141",
			"\1\142",
			"",
			"\12\24\7\uffff\33\24\1\uffff\1\24\3\uffff\32\24",
			"",
			"\1\144",
			"\12\24\7\uffff\33\24\1\uffff\1\24\3\uffff\32\24",
			"\12\24\7\uffff\33\24\1\uffff\1\24\3\uffff\32\24",
			"",
			"\1\147",
			"",
			"",
			"\1\150",
			"\12\24\7\uffff\33\24\1\uffff\1\24\3\uffff\32\24",
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
			return "1:1: Tokens : ( ARR | ASSIGN | CLASS | COMMA | DECREASE | ELSE | ENDCLASS | ENDELSE | ENDFOR | ENDFUNCTION | ENDIF | ENDWHILE | EQUALS | FOR | FUNCTION | GT | GTE | IF | INCREASE | LPAREN | LT | LTE | MINUS | PLUS | RETURN | RPAREN | SEMICOLON | SLASH | STAR | VAR | WHILE | ID | VALUE | WS );";
		}
	}

}
