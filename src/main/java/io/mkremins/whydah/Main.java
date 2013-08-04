package io.mkremins.whydah;

import io.mkremins.whydah.parser.Lexer;
import io.mkremins.whydah.parser.Morpher;
import io.mkremins.whydah.parser.Token;
import io.mkremins.whydah.parser.TokenType;
import io.mkremins.whydah.util.Reader;

public final class Main {

	public static void main(final String[] args) {
		final String source = "yes = (no + 1); /*if then * /do*/ if (no + 4.2 < -3) { run \"string 'contents'\"; }";
		final Reader<Token> tokens = new Morpher(new Lexer(source));
		boolean keepGoing = true;
		while (keepGoing) {
			final Token token = tokens.read();
			if (token.getType() == TokenType.EOF) {
				keepGoing = false;
			} else if (token.getType() == TokenType.NEWLINE) {
				System.out.println("END_LINE\n");
			} else {
				System.out.println(token.getType().toString() + ": "
						+ token.getText());
			}
		}
	}

}
