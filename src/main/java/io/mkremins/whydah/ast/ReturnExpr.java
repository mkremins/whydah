package io.mkremins.whydah.ast;

import io.mkremins.whydah.interpreter.Obj;
import io.mkremins.whydah.interpreter.Scope;

public final class ReturnExpr implements Expr {

	private final Expr expr;

	public ReturnExpr(final Expr expr) {
		this.expr = expr;
	}

	@Override
	public Obj evaluateWithin(final Scope scope) {
		return expr.evaluateWithin(scope);
	}

	@Override
	public String print() {
		return "return " + expr.toString();
	}

}
