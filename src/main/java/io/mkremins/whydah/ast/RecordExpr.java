package io.mkremins.whydah.ast;

import io.mkremins.whydah.interpreter.Obj;
import io.mkremins.whydah.interpreter.Scope;

import java.util.List;

public final class RecordExpr extends Scope implements Expr {

	public RecordExpr(final Scope parent, final List<Obj> vars) {
		super(parent);
		for (int i = 0; i < vars.size(); i++) {
			set(String.valueOf(i), vars.get(i));
		}
	}

	@Override
	public Obj evaluateWithin(final Scope scope) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String print() {
		// TODO Auto-generated method stub
		return null;
	}

}
