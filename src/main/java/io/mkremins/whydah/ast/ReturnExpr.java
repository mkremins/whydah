package io.mkremins.whydah.ast;

public final class ReturnExpr implements Expr {

	private final Expr returnValue;

	public ReturnExpr(final Expr returnValue) {
		this.returnValue = returnValue;
	}

	public Expr getReturnValue() {
		return returnValue;
	}
	
}
