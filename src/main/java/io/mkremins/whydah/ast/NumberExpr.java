package io.mkremins.whydah.ast;

import io.mkremins.whydah.interpreter.Obj;
import io.mkremins.whydah.interpreter.Scope;

public final class NumberExpr implements Expr {

	private final Number value;

	public NumberExpr(final Number value) {
		this.value = value;
	}

	@Override
	public Obj evaluateWithin(final Scope scope) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String print() {
		return value.toString();
	}

}
