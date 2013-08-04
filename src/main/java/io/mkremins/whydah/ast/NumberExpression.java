package io.mkremins.whydah.ast;

import io.mkremins.whydah.interpreter.Scope;

public final class NumberExpression implements Expression {

	private final Number value;

	public NumberExpression(final Number value) {
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
		return value.toString();
	}

}
