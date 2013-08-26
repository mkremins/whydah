package io.mkremins.whydah.parser;

import io.mkremins.whydah.util.Reader;

public final class Lexer implements Reader<Token> {

	private int index;
	private final int lastIndex;
	private final String text;

	public Lexer(final String text) {
		index = -1;
		lastIndex = text.length() - 1;
		this.text = text;
	}

	@Override
	public Token read() {
		if (index >= lastIndex) {
			return new Token(TokenType.EOF);
		}

		final char ch = advance();

		switch (ch) {
		case ' ':
		case '\t':
			return readWhitespace();
		case '(':
		case ')':
		case '{':
		case '}':
		case '[':
		case ']':
		case ',':
		case ':':
			return readPunctuator();
		case '=':
			return new Token(TokenType.ASSIGN, "=");
		case '&':
			return new Token(TokenType.CAPTURE, "&");
		case '.':
			return Character.isDigit(lookahead(1)) ? readNumLiteral()
					: readPunctuator();
		case ';':
		case '\n':
		case '\r':
			return new Token(TokenType.NEWLINE);
		case '\'':
		case '"':
			return readStringLiteral(ch);
		case '/':
			switch (lookahead(1)) {
			case '/':
				return readLineComment();
			case '*':
				return readBlockComment();
			default:
				return readName();
			}
		case '-':
			return Character.isDigit(lookahead(1)) ? readNumLiteral()
					: readName();
		default:
			return Character.isDigit(ch) ? readNumLiteral() : readName();
		}
	}

	private char advance() {
		return text.charAt(++index);
	}

	private char lookahead(final int num) {
		return text.charAt(index + num);
	}

	private Token readWhitespace() {
		while (Character.isWhitespace(lookahead(1))) {
			advance();
		}
		return new Token(TokenType.WHITESPACE);
	}

	private Token readPunctuator() {
		final char ch = lookahead(0);
		return new Token(TokenType.of(ch), String.valueOf(ch));
	}

	private Token readNumLiteral() {
		final char ch = lookahead(0);
		boolean decimal = ch == '.';
		final StringBuilder number = new StringBuilder();
		number.append(ch);
		while (Character.isDigit(lookahead(1))
				|| (!decimal && lookahead(1) == '.')) {
			final char next = advance();
			if (next == '.') {
				decimal = true;
			}
			number.append(next);
		}
		return new Token(TokenType.NUM_LITERAL, number.toString());
	}

	private Token readStringLiteral(final char quote) {
		final StringBuilder value = new StringBuilder();
		// TODO this is na•ve Ð among other things, it doesn't consider escapes
		while (lookahead(1) != quote) {
			value.append(advance());
		}
		advance();
		return new Token(TokenType.STRING_LITERAL, value.toString());
	}

	private Token readLineComment() {
		while (lookahead(1) != '\n' && lookahead(1) != '\r') {
			advance();
		}
		return new Token(TokenType.COMMENT);
	}

	private Token readBlockComment() {
		while (lookahead(1) != '*' || lookahead(2) != '/') {
			advance();
		}
		advance();
		advance();
		return new Token(TokenType.COMMENT);
	}

	private Token readName() {
		final char ch = lookahead(0);
		final StringBuilder name = new StringBuilder();
		name.append(ch);
		// TODO this is na•ve
		while (!TokenType.splitNames(lookahead(1))) {
			name.append(advance());
		}
		return new Token(TokenType.NAME, name.toString());
	}

}
