package io.mkremins.whydah.parser;

public final class Token {

	private final TokenType type;
	private final String text;

	public Token(final TokenType type, final String text) {
		this.type = type;
		this.text = text;
	}

	public Token(final TokenType type) {
		this(type, "");
	}

	public TokenType getType() {
		return type;
	}

	public String getText() {
		return text;
	}

}
