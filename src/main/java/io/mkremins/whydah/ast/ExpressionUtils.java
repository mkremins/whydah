package io.mkremins.whydah.ast;

import io.mkremins.whydah.interpreter.Scope;

public final class ExpressionUtils {

	public static Expression fullyEvaluate(Expression expr, final Scope scope) {
		while (!expr.isFullyEvaluated()) {
			expr = expr.evaluateWithin(scope);
		}
		return expr;
	}

}
