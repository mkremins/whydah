package io.mkremins.whydah.ast;

import io.mkremins.whydah.interpreter.Scope;

public final class RecordExpression extends Scope implements Expression {

	public RecordExpression(final Scope parent, final Expression[] vars) {
		super(parent);
		for (int i = 0; i < vars.length; i++) {
			set(String.valueOf(i), vars[i]);
		}
	}

	@Override
	public boolean isFullyEvaluated() {
		return true;
	}

	@Override
	public Expression evaluateWithin(final Scope scope) {
		return this;
	}

	@Override
	public String print() {
		// TODO Auto-generated method stub
		return null;
	}

}
