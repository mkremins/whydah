package io.mkremins.whydah.parser;

public enum TokenType {
	ASSIGN,
	LPAREN,
	RPAREN,
	LBRACKET,
	RBRACKET,
	LBRACE,
	RBRACE,
	COMMA,
	COLON,
	NEWLINE,
	COMMENT,
	WHITESPACE,
	STRING_LITERAL,
	NUM_LITERAL,
	NAME,
	EOF;

	public static TokenType of(final char ch) {
		switch(ch) {
		case '(': return LPAREN;
		case ')': return RPAREN;
		case '{': return LBRACE;
		case '}': return RBRACE;
		case '[': return LBRACKET;
		case ']': return RBRACKET;
		case ':': return COLON;
		case ',': return COMMA;
		default: return null; // TODO not sure whether returning null here is a good idea
		}
	}

	public static boolean splitNames(final char ch) {
		switch(ch) {
		case '(':
		case ')':
		case '{':
		case '}':
		case '[':
		case ']':
		case ',':
		case ':':
		case ';':
		case '\n':
		case '\r':
		case ' ':
		case '\t':
			return true;
		default:
			return false;
		}
	}

}
