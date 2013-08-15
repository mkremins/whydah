package io.mkremins.whydah.ast;

import io.mkremins.whydah.interpreter.Obj;
import io.mkremins.whydah.interpreter.Scope;
import io.mkremins.whydah.interpreter.StringObj;

public final class StringExpr implements Expr {

	private final String value;

	public StringExpr(final String value) {
		this.value = value;
	}

	@Override
	public Obj evaluateWithin(final Scope scope) {
		return new StringObj(value);
	}

	@Override
	public String print() {
		return "\"" + value + "\"";
	}

}
