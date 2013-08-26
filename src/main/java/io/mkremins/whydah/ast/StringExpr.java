package io.mkremins.whydah.ast;

public final class StringExpr implements Expr {

	private final String value;

	public StringExpr(final String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
