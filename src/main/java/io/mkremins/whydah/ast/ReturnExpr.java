package io.mkremins.whydah.ast;

import io.mkremins.whydah.interpreter.Scope;

public final class ReturnExpr implements Expr {

	private final Expr expr;

	public ReturnExpr(final Expr expr) {
		this.expr = expr;
	}

	@Override
	public boolean isFullyEvaluated() {
		return false;
	}

	@Override
	public Expr evaluateWithin(final Scope scope) {
		return ExprUtils.fullyEvaluate(expr, scope);
	}

	@Override
	public String print() {
		return "return " + expr.toString();
	}

}
