package io.mkremins.whydah.ast;

import io.mkremins.whydah.interpreter.Scope;

public final class AssignExpr implements Expr {

	private final NameExpr left;
	private final Expr right;

	public AssignExpr(final NameExpr left,
			final Expr right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public boolean isFullyEvaluated() {
		return false;
	}

	@Override
	public Expr evaluateWithin(final Scope scope) {
		final Reference ref = left.evaluateWithin(scope);
		final Expr value = ExprUtils.fullyEvaluate(right, scope);
		ref.set(value);
		return value;
	}

	@Override
	public String print() {
		return left.toString() + " = " + right.toString();
	}

}
