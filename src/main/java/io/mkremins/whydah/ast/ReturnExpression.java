package io.mkremins.whydah.ast;

import io.mkremins.whydah.interpreter.Scope;

public final class ReturnExpression implements Expression {

	private final Expression expr;

	public ReturnExpression(final Expression expr) {
		this.expr = expr;
	}

	@Override
	public boolean isFullyEvaluated() {
		return false;
	}

	@Override
	public Expression evaluateWithin(final Scope scope) {
		return ExpressionUtils.fullyEvaluate(expr, scope);
	}

	@Override
	public String print() {
		return "return " + expr.toString();
	}

}
