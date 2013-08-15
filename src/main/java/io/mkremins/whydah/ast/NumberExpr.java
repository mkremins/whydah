package io.mkremins.whydah.ast;

import io.mkremins.whydah.interpreter.Scope;

public final class NumberExpr implements Expr {

	private final Number value;

	public NumberExpr(final Number value) {
		this.value = value;
	}

	@Override
	public boolean isFullyEvaluated() {
		return true;
	}

	@Override
	public Expr evaluateWithin(final Scope scope) {
		return this;
	}

	@Override
	public String print() {
		return value.toString();
	}

}
