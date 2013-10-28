package language;

// $ANTLR 3.5 C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g 2013-09-22 22:26:22

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
	@Override public String getGrammarFileName() { return "C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g"; }

	// $ANTLR start "ASSIGN"
	public final void mASSIGN() throws RecognitionException {
		try {
			int _type = ASSIGN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:2:8: ( '=' )
			// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:2:10: '='
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
			// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:3:7: ( 'class' )
			// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:3:9: 'class'
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
			// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:4:7: ( ',' )
			// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:4:9: ','
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

	// $ANTLR start "ENDCLASS"
	public final void mENDCLASS() throws RecognitionException {
		try {
			int _type = ENDCLASS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:5:10: ( 'endclass' )
			// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:5:12: 'endclass'
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

	// $ANTLR start "ENDFUNCTION"
	public final void mENDFUNCTION() throws RecognitionException {
		try {
			int _type = ENDFUNCTION;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:6:13: ( 'endfunction' )
			// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:6:15: 'endfunction'
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

	// $ANTLR start "FUNCTION"
	public final void mFUNCTION() throws RecognitionException {
		try {
			int _type = FUNCTION;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:7:10: ( 'function' )
			// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:7:12: 'function'
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

	// $ANTLR start "LPAREN"
	public final void mLPAREN() throws RecognitionException {
		try {
			int _type = LPAREN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:8:8: ( '(' )
			// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:8:10: '('
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
			// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:9:7: ( '-' )
			// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:9:9: '-'
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
			// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:10:6: ( '+' )
			// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:10:8: '+'
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
			// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:11:8: ( ')' )
			// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:11:10: ')'
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
			// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:12:7: ( '/' )
			// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:12:9: '/'
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
			// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:13:6: ( '*' )
			// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:13:8: '*'
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
			// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:14:5: ( 'var' )
			// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:14:7: 'var'
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
			// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:93:7: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' )* )
			// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:93:9: ( 'a' .. 'z' | 'A' .. 'Z' ) ( '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:93:30: ( '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= '0' && LA1_0 <= '9')||(LA1_0 >= 'A' && LA1_0 <= 'Z')||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:
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
			// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:94:10: ( ( '-' )? ( '0' .. '9' )+ )
			// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:94:12: ( '-' )? ( '0' .. '9' )+
			{
			// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:94:12: ( '-' )?
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0=='-') ) {
				alt2=1;
			}
			switch (alt2) {
				case 1 :
					// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:94:12: '-'
					{
					match('-'); 
					}
					break;

			}

			// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:94:16: ( '0' .. '9' )+
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
					// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:
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
			// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:95:8: ( ( ' ' | '\\t' | '\\r' | '\\n' ) )
			// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:95:10: ( ' ' | '\\t' | '\\r' | '\\n' )
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
		// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:1:8: ( ASSIGN | CLASS | COMMA | ENDCLASS | ENDFUNCTION | FUNCTION | LPAREN | MINUS | PLUS | RPAREN | SLASH | STAR | VAR | ID | VALUE | WS )
		int alt4=16;
		switch ( input.LA(1) ) {
		case '=':
			{
			alt4=1;
			}
			break;
		case 'c':
			{
			int LA4_2 = input.LA(2);
			if ( (LA4_2=='l') ) {
				int LA4_16 = input.LA(3);
				if ( (LA4_16=='a') ) {
					int LA4_21 = input.LA(4);
					if ( (LA4_21=='s') ) {
						int LA4_25 = input.LA(5);
						if ( (LA4_25=='s') ) {
							int LA4_30 = input.LA(6);
							if ( ((LA4_30 >= '0' && LA4_30 <= '9')||(LA4_30 >= 'A' && LA4_30 <= 'Z')||(LA4_30 >= 'a' && LA4_30 <= 'z')) ) {
								alt4=14;
							}

							else {
								alt4=2;
							}

						}

						else {
							alt4=14;
						}

					}

					else {
						alt4=14;
					}

				}

				else {
					alt4=14;
				}

			}

			else {
				alt4=14;
			}

			}
			break;
		case ',':
			{
			alt4=3;
			}
			break;
		case 'e':
			{
			int LA4_4 = input.LA(2);
			if ( (LA4_4=='n') ) {
				int LA4_17 = input.LA(3);
				if ( (LA4_17=='d') ) {
					switch ( input.LA(4) ) {
					case 'c':
						{
						int LA4_26 = input.LA(5);
						if ( (LA4_26=='l') ) {
							int LA4_31 = input.LA(6);
							if ( (LA4_31=='a') ) {
								int LA4_35 = input.LA(7);
								if ( (LA4_35=='s') ) {
									int LA4_38 = input.LA(8);
									if ( (LA4_38=='s') ) {
										int LA4_41 = input.LA(9);
										if ( ((LA4_41 >= '0' && LA4_41 <= '9')||(LA4_41 >= 'A' && LA4_41 <= 'Z')||(LA4_41 >= 'a' && LA4_41 <= 'z')) ) {
											alt4=14;
										}

										else {
											alt4=4;
										}

									}

									else {
										alt4=14;
									}

								}

								else {
									alt4=14;
								}

							}

							else {
								alt4=14;
							}

						}

						else {
							alt4=14;
						}

						}
						break;
					case 'f':
						{
						int LA4_27 = input.LA(5);
						if ( (LA4_27=='u') ) {
							int LA4_32 = input.LA(6);
							if ( (LA4_32=='n') ) {
								int LA4_36 = input.LA(7);
								if ( (LA4_36=='c') ) {
									int LA4_39 = input.LA(8);
									if ( (LA4_39=='t') ) {
										int LA4_42 = input.LA(9);
										if ( (LA4_42=='i') ) {
											int LA4_45 = input.LA(10);
											if ( (LA4_45=='o') ) {
												int LA4_47 = input.LA(11);
												if ( (LA4_47=='n') ) {
													int LA4_48 = input.LA(12);
													if ( ((LA4_48 >= '0' && LA4_48 <= '9')||(LA4_48 >= 'A' && LA4_48 <= 'Z')||(LA4_48 >= 'a' && LA4_48 <= 'z')) ) {
														alt4=14;
													}

													else {
														alt4=5;
													}

												}

												else {
													alt4=14;
												}

											}

											else {
												alt4=14;
											}

										}

										else {
											alt4=14;
										}

									}

									else {
										alt4=14;
									}

								}

								else {
									alt4=14;
								}

							}

							else {
								alt4=14;
							}

						}

						else {
							alt4=14;
						}

						}
						break;
					default:
						alt4=14;
					}
				}

				else {
					alt4=14;
				}

			}

			else {
				alt4=14;
			}

			}
			break;
		case 'f':
			{
			int LA4_5 = input.LA(2);
			if ( (LA4_5=='u') ) {
				int LA4_18 = input.LA(3);
				if ( (LA4_18=='n') ) {
					int LA4_23 = input.LA(4);
					if ( (LA4_23=='c') ) {
						int LA4_28 = input.LA(5);
						if ( (LA4_28=='t') ) {
							int LA4_33 = input.LA(6);
							if ( (LA4_33=='i') ) {
								int LA4_37 = input.LA(7);
								if ( (LA4_37=='o') ) {
									int LA4_40 = input.LA(8);
									if ( (LA4_40=='n') ) {
										int LA4_43 = input.LA(9);
										if ( ((LA4_43 >= '0' && LA4_43 <= '9')||(LA4_43 >= 'A' && LA4_43 <= 'Z')||(LA4_43 >= 'a' && LA4_43 <= 'z')) ) {
											alt4=14;
										}

										else {
											alt4=6;
										}

									}

									else {
										alt4=14;
									}

								}

								else {
									alt4=14;
								}

							}

							else {
								alt4=14;
							}

						}

						else {
							alt4=14;
						}

					}

					else {
						alt4=14;
					}

				}

				else {
					alt4=14;
				}

			}

			else {
				alt4=14;
			}

			}
			break;
		case '(':
			{
			alt4=7;
			}
			break;
		case '-':
			{
			int LA4_7 = input.LA(2);
			if ( ((LA4_7 >= '0' && LA4_7 <= '9')) ) {
				alt4=15;
			}

			else {
				alt4=8;
			}

			}
			break;
		case '+':
			{
			alt4=9;
			}
			break;
		case ')':
			{
			alt4=10;
			}
			break;
		case '/':
			{
			alt4=11;
			}
			break;
		case '*':
			{
			alt4=12;
			}
			break;
		case 'v':
			{
			int LA4_12 = input.LA(2);
			if ( (LA4_12=='a') ) {
				int LA4_20 = input.LA(3);
				if ( (LA4_20=='r') ) {
					int LA4_24 = input.LA(4);
					if ( ((LA4_24 >= '0' && LA4_24 <= '9')||(LA4_24 >= 'A' && LA4_24 <= 'Z')||(LA4_24 >= 'a' && LA4_24 <= 'z')) ) {
						alt4=14;
					}

					else {
						alt4=13;
					}

				}

				else {
					alt4=14;
				}

			}

			else {
				alt4=14;
			}

			}
			break;
		case 'A':
		case 'B':
		case 'C':
		case 'D':
		case 'E':
		case 'F':
		case 'G':
		case 'H':
		case 'I':
		case 'J':
		case 'K':
		case 'L':
		case 'M':
		case 'N':
		case 'O':
		case 'P':
		case 'Q':
		case 'R':
		case 'S':
		case 'T':
		case 'U':
		case 'V':
		case 'W':
		case 'X':
		case 'Y':
		case 'Z':
		case 'a':
		case 'b':
		case 'd':
		case 'g':
		case 'h':
		case 'i':
		case 'j':
		case 'k':
		case 'l':
		case 'm':
		case 'n':
		case 'o':
		case 'p':
		case 'q':
		case 'r':
		case 's':
		case 't':
		case 'u':
		case 'w':
		case 'x':
		case 'y':
		case 'z':
			{
			alt4=14;
			}
			break;
		case '0':
		case '1':
		case '2':
		case '3':
		case '4':
		case '5':
		case '6':
		case '7':
		case '8':
		case '9':
			{
			alt4=15;
			}
			break;
		case '\t':
		case '\n':
		case '\r':
		case ' ':
			{
			alt4=16;
			}
			break;
		default:
			NoViableAltException nvae =
				new NoViableAltException("", 4, 0, input);
			throw nvae;
		}
		switch (alt4) {
			case 1 :
				// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:1:10: ASSIGN
				{
				mASSIGN(); 

				}
				break;
			case 2 :
				// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:1:17: CLASS
				{
				mCLASS(); 

				}
				break;
			case 3 :
				// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:1:23: COMMA
				{
				mCOMMA(); 

				}
				break;
			case 4 :
				// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:1:29: ENDCLASS
				{
				mENDCLASS(); 

				}
				break;
			case 5 :
				// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:1:38: ENDFUNCTION
				{
				mENDFUNCTION(); 

				}
				break;
			case 6 :
				// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:1:50: FUNCTION
				{
				mFUNCTION(); 

				}
				break;
			case 7 :
				// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:1:59: LPAREN
				{
				mLPAREN(); 

				}
				break;
			case 8 :
				// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:1:66: MINUS
				{
				mMINUS(); 

				}
				break;
			case 9 :
				// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:1:72: PLUS
				{
				mPLUS(); 

				}
				break;
			case 10 :
				// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:1:77: RPAREN
				{
				mRPAREN(); 

				}
				break;
			case 11 :
				// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:1:84: SLASH
				{
				mSLASH(); 

				}
				break;
			case 12 :
				// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:1:90: STAR
				{
				mSTAR(); 

				}
				break;
			case 13 :
				// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:1:95: VAR
				{
				mVAR(); 

				}
				break;
			case 14 :
				// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:1:99: ID
				{
				mID(); 

				}
				break;
			case 15 :
				// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:1:102: VALUE
				{
				mVALUE(); 

				}
				break;
			case 16 :
				// C:\\Users\\Michael\\Documents\\My Dropbox\\Senior Design\\pseudoLanguage\\language.g:1:108: WS
				{
				mWS(); 

				}
				break;

		}
	}



}
