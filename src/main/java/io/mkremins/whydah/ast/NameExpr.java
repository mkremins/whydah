package io.mkremins.whydah.ast;

import io.mkremins.whydah.interpreter.Obj;
import io.mkremins.whydah.interpreter.Scope;

import java.util.List;

public final class NameExpr implements Expr {

	private final String left;
	private final NameExpr right;

	public NameExpr(final List<String> names) {
		left = names.get(0);
		right = names.size() == 1 ?
				null : new NameExpr(names.subList(1, names.size()));
	}
	
	@Override
	public Obj evaluateWithin(final Scope scope) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String print() {
		return left + " " + right.toString();
	}

	public Reference getReference() {
		// TODO Auto-generated method stub
		return null;
	}

}
