package language;

// $ANTLR 3.5 C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g 2013-12-09 22:41:07

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
	public static final int RETURN=28;
	public static final int RPAREN=29;
	public static final int SEMICOLON=30;
	public static final int SLASH=31;
	public static final int STAR=32;
	public static final int VALUE=33;
	public static final int VAR=34;
	public static final int WHILE=35;
	public static final int WS=36;

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

	// $ANTLR start "DECREASE"
	public final void mDECREASE() throws RecognitionException {
		try {
			int _type = DECREASE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:5:10: ( '--' )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:5:12: '--'
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
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:6:6: ( 'else' )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:6:8: 'else'
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
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:7:10: ( 'endclass' )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:7:12: 'endclass'
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
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:8:9: ( 'endelse' )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:8:11: 'endelse'
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
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:9:8: ( 'endfor' )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:9:10: 'endfor'
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
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:10:13: ( 'endfunction' )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:10:15: 'endfunction'
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
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:11:7: ( 'endif' )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:11:9: 'endif'
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
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:12:10: ( 'endwhile' )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:12:12: 'endwhile'
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
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:13:8: ( '==' )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:13:10: '=='
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
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:14:5: ( 'for' )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:14:7: 'for'
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
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:15:10: ( 'function' )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:15:12: 'function'
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
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:16:4: ( '>' )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:16:6: '>'
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
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:17:5: ( '>=' )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:17:7: '>='
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
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:18:4: ( 'if' )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:18:6: 'if'
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
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:19:10: ( '++' )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:19:12: '++'
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
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:20:8: ( '(' )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:20:10: '('
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
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:21:4: ( '<' )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:21:6: '<'
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
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:22:5: ( '<=' )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:22:7: '<='
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
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:23:7: ( '-' )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:23:9: '-'
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
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:24:6: ( '+' )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:24:8: '+'
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
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:25:8: ( 'return' )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:25:10: 'return'
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
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:26:8: ( ')' )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:26:10: ')'
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
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:27:11: ( ';' )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:27:13: ';'
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
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:28:7: ( '/' )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:28:9: '/'
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
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:29:6: ( '*' )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:29:8: '*'
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
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:30:5: ( 'var' )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:30:7: 'var'
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
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:31:7: ( 'while' )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:31:9: 'while'
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
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:171:7: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' )* )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:171:9: ( 'a' .. 'z' | 'A' .. 'Z' ) ( '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:171:30: ( '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' )*
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
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:172:10: ( ( '-' )? ( '0' .. '9' )+ )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:172:12: ( '-' )? ( '0' .. '9' )+
			{
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:172:12: ( '-' )?
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0=='-') ) {
				alt2=1;
			}
			switch (alt2) {
				case 1 :
					// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:172:12: '-'
					{
					match('-'); 
					}
					break;

			}

			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:172:16: ( '0' .. '9' )+
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
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:173:8: ( ( ' ' | '\\t' | '\\r' | '\\n' ) )
			// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:173:10: ( ' ' | '\\t' | '\\r' | '\\n' )
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
		// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:8: ( ASSIGN | CLASS | COMMA | DECREASE | ELSE | ENDCLASS | ENDELSE | ENDFOR | ENDFUNCTION | ENDIF | ENDWHILE | EQUALS | FOR | FUNCTION | GT | GTE | IF | INCREASE | LPAREN | LT | LTE | MINUS | PLUS | RETURN | RPAREN | SEMICOLON | SLASH | STAR | VAR | WHILE | ID | VALUE | WS )
		int alt4=33;
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
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:29: DECREASE
				{
				mDECREASE(); 

				}
				break;
			case 5 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:38: ELSE
				{
				mELSE(); 

				}
				break;
			case 6 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:43: ENDCLASS
				{
				mENDCLASS(); 

				}
				break;
			case 7 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:52: ENDELSE
				{
				mENDELSE(); 

				}
				break;
			case 8 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:60: ENDFOR
				{
				mENDFOR(); 

				}
				break;
			case 9 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:67: ENDFUNCTION
				{
				mENDFUNCTION(); 

				}
				break;
			case 10 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:79: ENDIF
				{
				mENDIF(); 

				}
				break;
			case 11 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:85: ENDWHILE
				{
				mENDWHILE(); 

				}
				break;
			case 12 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:94: EQUALS
				{
				mEQUALS(); 

				}
				break;
			case 13 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:101: FOR
				{
				mFOR(); 

				}
				break;
			case 14 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:105: FUNCTION
				{
				mFUNCTION(); 

				}
				break;
			case 15 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:114: GT
				{
				mGT(); 

				}
				break;
			case 16 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:117: GTE
				{
				mGTE(); 

				}
				break;
			case 17 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:121: IF
				{
				mIF(); 

				}
				break;
			case 18 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:124: INCREASE
				{
				mINCREASE(); 

				}
				break;
			case 19 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:133: LPAREN
				{
				mLPAREN(); 

				}
				break;
			case 20 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:140: LT
				{
				mLT(); 

				}
				break;
			case 21 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:143: LTE
				{
				mLTE(); 

				}
				break;
			case 22 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:147: MINUS
				{
				mMINUS(); 

				}
				break;
			case 23 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:153: PLUS
				{
				mPLUS(); 

				}
				break;
			case 24 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:158: RETURN
				{
				mRETURN(); 

				}
				break;
			case 25 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:165: RPAREN
				{
				mRPAREN(); 

				}
				break;
			case 26 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:172: SEMICOLON
				{
				mSEMICOLON(); 

				}
				break;
			case 27 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:182: SLASH
				{
				mSLASH(); 

				}
				break;
			case 28 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:188: STAR
				{
				mSTAR(); 

				}
				break;
			case 29 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:193: VAR
				{
				mVAR(); 

				}
				break;
			case 30 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:197: WHILE
				{
				mWHILE(); 

				}
				break;
			case 31 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:203: ID
				{
				mID(); 

				}
				break;
			case 32 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:206: VALUE
				{
				mVALUE(); 

				}
				break;
			case 33 :
				// C:\\Users\\Michael\\Documents\\Senior Design\\pseudoLanguage\\Language.g:1:212: WS
				{
				mWS(); 

				}
				break;

		}
	}


	protected DFA4 dfa4 = new DFA4(this);
	static final String DFA4_eotS =
		"\1\uffff\1\27\1\23\1\uffff\1\32\2\23\1\40\1\23\1\43\1\uffff\1\45\1\23"+
		"\4\uffff\2\23\5\uffff\1\23\2\uffff\4\23\2\uffff\1\56\4\uffff\6\23\1\71"+
		"\1\23\1\uffff\1\23\1\74\2\23\1\77\5\23\1\uffff\2\23\1\uffff\1\23\1\111"+
		"\1\uffff\4\23\1\116\3\23\1\122\1\uffff\2\23\1\125\1\23\1\uffff\2\23\1"+
		"\131\1\uffff\1\23\1\133\1\uffff\3\23\1\uffff\1\137\1\uffff\1\23\1\141"+
		"\1\142\1\uffff\1\23\2\uffff\1\23\1\145\1\uffff";
	static final String DFA4_eofS =
		"\146\uffff";
	static final String DFA4_minS =
		"\1\11\1\75\1\154\1\uffff\1\55\1\154\1\157\1\75\1\146\1\53\1\uffff\1\75"+
		"\1\145\4\uffff\1\141\1\150\5\uffff\1\141\2\uffff\1\163\1\144\1\162\1\156"+
		"\2\uffff\1\60\4\uffff\1\164\1\162\1\151\1\163\1\145\1\143\1\60\1\143\1"+
		"\uffff\1\165\1\60\1\154\1\163\1\60\2\154\1\157\1\146\1\150\1\uffff\1\164"+
		"\1\162\1\uffff\1\145\1\60\1\uffff\1\141\1\163\1\162\1\156\1\60\2\151\1"+
		"\156\1\60\1\uffff\1\163\1\145\1\60\1\143\1\uffff\1\154\1\157\1\60\1\uffff"+
		"\1\163\1\60\1\uffff\1\164\1\145\1\156\1\uffff\1\60\1\uffff\1\151\2\60"+
		"\1\uffff\1\157\2\uffff\1\156\1\60\1\uffff";
	static final String DFA4_maxS =
		"\1\172\1\75\1\154\1\uffff\1\71\1\156\1\165\1\75\1\146\1\53\1\uffff\1\75"+
		"\1\145\4\uffff\1\141\1\150\5\uffff\1\141\2\uffff\1\163\1\144\1\162\1\156"+
		"\2\uffff\1\172\4\uffff\1\164\1\162\1\151\1\163\1\145\1\167\1\172\1\143"+
		"\1\uffff\1\165\1\172\1\154\1\163\1\172\2\154\1\165\1\146\1\150\1\uffff"+
		"\1\164\1\162\1\uffff\1\145\1\172\1\uffff\1\141\1\163\1\162\1\156\1\172"+
		"\2\151\1\156\1\172\1\uffff\1\163\1\145\1\172\1\143\1\uffff\1\154\1\157"+
		"\1\172\1\uffff\1\163\1\172\1\uffff\1\164\1\145\1\156\1\uffff\1\172\1\uffff"+
		"\1\151\2\172\1\uffff\1\157\2\uffff\1\156\1\172\1\uffff";
	static final String DFA4_acceptS =
		"\3\uffff\1\3\6\uffff\1\23\2\uffff\1\31\1\32\1\33\1\34\2\uffff\1\37\1\40"+
		"\1\41\1\14\1\1\1\uffff\1\4\1\26\4\uffff\1\20\1\17\1\uffff\1\22\1\27\1"+
		"\25\1\24\10\uffff\1\21\12\uffff\1\15\2\uffff\1\35\2\uffff\1\5\11\uffff"+
		"\1\2\4\uffff\1\12\3\uffff\1\36\2\uffff\1\10\3\uffff\1\30\1\uffff\1\7\3"+
		"\uffff\1\6\1\uffff\1\13\1\16\2\uffff\1\11";
	static final String DFA4_specialS =
		"\146\uffff}>";
	static final String[] DFA4_transitionS = {
			"\2\25\2\uffff\1\25\22\uffff\1\25\7\uffff\1\12\1\15\1\20\1\11\1\3\1\4"+
			"\1\uffff\1\17\12\24\1\uffff\1\16\1\13\1\1\1\7\2\uffff\32\23\6\uffff\2"+
			"\23\1\2\1\23\1\5\1\6\2\23\1\10\10\23\1\14\3\23\1\21\1\22\3\23",
			"\1\26",
			"\1\30",
			"",
			"\1\31\2\uffff\12\24",
			"\1\33\1\uffff\1\34",
			"\1\35\5\uffff\1\36",
			"\1\37",
			"\1\41",
			"\1\42",
			"",
			"\1\44",
			"\1\46",
			"",
			"",
			"",
			"",
			"\1\47",
			"\1\50",
			"",
			"",
			"",
			"",
			"",
			"\1\51",
			"",
			"",
			"\1\52",
			"\1\53",
			"\1\54",
			"\1\55",
			"",
			"",
			"\12\23\7\uffff\32\23\6\uffff\32\23",
			"",
			"",
			"",
			"",
			"\1\57",
			"\1\60",
			"\1\61",
			"\1\62",
			"\1\63",
			"\1\64\1\uffff\1\65\1\66\2\uffff\1\67\15\uffff\1\70",
			"\12\23\7\uffff\32\23\6\uffff\32\23",
			"\1\72",
			"",
			"\1\73",
			"\12\23\7\uffff\32\23\6\uffff\32\23",
			"\1\75",
			"\1\76",
			"\12\23\7\uffff\32\23\6\uffff\32\23",
			"\1\100",
			"\1\101",
			"\1\102\5\uffff\1\103",
			"\1\104",
			"\1\105",
			"",
			"\1\106",
			"\1\107",
			"",
			"\1\110",
			"\12\23\7\uffff\32\23\6\uffff\32\23",
			"",
			"\1\112",
			"\1\113",
			"\1\114",
			"\1\115",
			"\12\23\7\uffff\32\23\6\uffff\32\23",
			"\1\117",
			"\1\120",
			"\1\121",
			"\12\23\7\uffff\32\23\6\uffff\32\23",
			"",
			"\1\123",
			"\1\124",
			"\12\23\7\uffff\32\23\6\uffff\32\23",
			"\1\126",
			"",
			"\1\127",
			"\1\130",
			"\12\23\7\uffff\32\23\6\uffff\32\23",
			"",
			"\1\132",
			"\12\23\7\uffff\32\23\6\uffff\32\23",
			"",
			"\1\134",
			"\1\135",
			"\1\136",
			"",
			"\12\23\7\uffff\32\23\6\uffff\32\23",
			"",
			"\1\140",
			"\12\23\7\uffff\32\23\6\uffff\32\23",
			"\12\23\7\uffff\32\23\6\uffff\32\23",
			"",
			"\1\143",
			"",
			"",
			"\1\144",
			"\12\23\7\uffff\32\23\6\uffff\32\23",
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
			return "1:1: Tokens : ( ASSIGN | CLASS | COMMA | DECREASE | ELSE | ENDCLASS | ENDELSE | ENDFOR | ENDFUNCTION | ENDIF | ENDWHILE | EQUALS | FOR | FUNCTION | GT | GTE | IF | INCREASE | LPAREN | LT | LTE | MINUS | PLUS | RETURN | RPAREN | SEMICOLON | SLASH | STAR | VAR | WHILE | ID | VALUE | WS );";
		}
	}

}
