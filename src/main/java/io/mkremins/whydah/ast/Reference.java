package io.mkremins.whydah.ast;

import io.mkremins.whydah.interpreter.Obj;
import io.mkremins.whydah.interpreter.Scope;

public final class Reference implements Expr {

	private final Scope scope;
	private final String name;

	public Reference(final Scope scope, final String name) {
		this.scope = scope;
		this.name = name;
	}

	public Obj get() {
		return scope.get(name);
	}

	public void set(final Obj value) {
		scope.set(name, value);
	}
	
	@Override
	public Obj evaluateWithin(final Scope scope) {
		return get();
	}

	@Override
	public String print() {
		// TODO Auto-generated method stub
		return null;
	}

}
