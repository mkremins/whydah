package io.mkremins.whydah.parser;

import io.mkremins.whydah.util.Reader;

public final class Morpher implements Reader<Token> {

	private final Reader<Token> tokens;
	private boolean ignoreNextNewline;

	public Morpher(final Reader<Token> tokens) {
		this.tokens = tokens;
		// ignore newlines that appear before any actual code is found
		ignoreNextNewline = true;
	}

	@Override
	public Token read() {
		while (true) {
			final Token token = tokens.read();

			switch (token.getType()) {
			case COMMENT:
			case WHITESPACE:
				// ignore semantically meaningless tokens
				continue;

			case NEWLINE:
				if (ignoreNextNewline) {
					continue;
				}
				// treat multiple newlines in a row as a single newline
				ignoreNextNewline = true;
				break;

			default:
				ignoreNextNewline = false;
				break;
			}

			return token;
		}
	}

}
