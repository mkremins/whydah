package io.mkremins.whydah.interpreter;

import io.mkremins.whydah.ast.Expression;
import io.mkremins.whydah.ast.ExpressionUtils;

import java.util.HashMap;
import java.util.Map;

public class Scope {

	private final Map<String, Expression> vars;
	private final Scope parent;

	public Scope(final Scope parent) {
		vars = new HashMap<>();
		this.parent = parent;
	}

	public Scope() {
		this(null);
	}

	public void delete(final String varName) {
		getDeclaringScope(varName).vars.remove(varName);
	}

	public Expression get(final String varName) {
		return getDeclaringScope(varName).vars.get(varName);
	}

	public void set(final String varName, final Expression value) {
		Scope scope = getDeclaringScope(varName);
		if (scope == null) {
			scope = this;
		}
		scope.vars.put(varName, ExpressionUtils.fullyEvaluate(value, scope));
	}

	private Scope getDeclaringScope(final String varName) {
		Scope scope = this;
		while (scope != null && scope.vars.get(varName) == null) {
			scope = scope.parent;
		}
		return scope;
	}

}
