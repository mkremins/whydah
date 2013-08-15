package io.mkremins.whydah.ast;

import io.mkremins.whydah.interpreter.Scope;

public final class StringExpr implements Expr {

	private final String value;

	public StringExpr(final String value) {
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
		return "\"" + value + "\"";
	}

}
