package io.mkremins.whydah.ast;

import io.mkremins.whydah.interpreter.Scope;

public final class AssignmentExpression implements Expression {

	private final NameExpression left;
	private final Expression right;

	public AssignmentExpression(final NameExpression left,
			final Expression right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public boolean isFullyEvaluated() {
		return false;
	}

	@Override
	public Expression evaluateWithin(final Scope scope) {
		final Reference ref = left.evaluateWithin(scope);
		final Expression value = ExpressionUtils.fullyEvaluate(right, scope);
		ref.set(value);
		return value;
	}

	@Override
	public String print() {
		return left.toString() + " = " + right.toString();
	}

}
