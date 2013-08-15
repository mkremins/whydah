package io.mkremins.whydah.interpreter;

import io.mkremins.whydah.ast.Expr;
import io.mkremins.whydah.ast.ExprUtils;

import java.util.HashMap;
import java.util.Map;

public class Scope {

	private final Map<String, Expr> vars;
	private final Scope parent;

	public Scope(final Scope parent) {
		vars = new HashMap<String, Expr>();
		this.parent = parent;
	}

	public Scope() {
		this(null);
	}

	public void delete(final String varName) {
		getDeclaringScope(varName).vars.remove(varName);
	}

	public Expr get(final String varName) {
		return getDeclaringScope(varName).vars.get(varName);
	}

	public void set(final String varName, final Expr value) {
		Scope scope = getDeclaringScope(varName);
		if (scope == null) {
			scope = this;
		}
		scope.vars.put(varName, ExprUtils.fullyEvaluate(value, scope));
	}

	private Scope getDeclaringScope(final String varName) {
		Scope scope = this;
		while (scope != null && scope.vars.get(varName) == null) {
			scope = scope.parent;
		}
		return scope;
	}

}
