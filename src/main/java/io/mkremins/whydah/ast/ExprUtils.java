package io.mkremins.whydah.ast;

import io.mkremins.whydah.interpreter.Scope;

public final class ExprUtils {

	public static Expr fullyEvaluate(Expr expr, final Scope scope) {
		while (!expr.isFullyEvaluated()) {
			expr = expr.evaluateWithin(scope);
		}
		return expr;
	}

}
