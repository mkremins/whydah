package io.mkremins.whydah.ast;

public final class NumberExpr implements Expr {

	private final Number value;

	public NumberExpr(final Number value) {
		this.value = value;
	}

	public Number getValue() {
		return value;
	}

}
