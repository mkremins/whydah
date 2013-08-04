package io.mkremins.whydah.ast;

import io.mkremins.whydah.interpreter.Scope;

public final class StringExpression implements Expression {

	private final String value;

	public StringExpression(final String value) {
		this.value = value;
	}

	@Override
	public boolean isFullyEvaluated() {
		return true;
	}

	@Override
	public Expression evaluateWithin(final Scope scope) {
		return this;
	}

	@Override
	public String print() {
		return "\"" + value + "\"";
	}

}
