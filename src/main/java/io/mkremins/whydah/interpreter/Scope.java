package io.mkremins.whydah.interpreter;

import java.util.HashMap;
import java.util.Map;

public class Scope {

	private final Map<String, Obj> vars;
	private final Scope parent;

	public Scope(final Scope parent) {
		vars = new HashMap<String, Obj>();
		this.parent = parent;
	}

	public Scope() {
		this(null);
	}

	public void delete(final String varName) {
		getDeclaringScope(varName).vars.remove(varName);
	}

	public Obj get(final String varName) {
		return getDeclaringScope(varName).vars.get(varName);
	}

	public void set(final String varName, final Obj value) {
		Scope scope = getDeclaringScope(varName);
		if (scope == null) {
			scope = this;
		}
		scope.vars.put(varName, value);
	}

	private Scope getDeclaringScope(final String varName) {
		Scope scope = this;
		while (scope != null && scope.vars.get(varName) == null) {
			scope = scope.parent;
		}
		return scope;
	}

}
