package io.mkremins.whydah.ast;

import io.mkremins.whydah.interpreter.Scope;

public final class BlockExpression extends Scope implements Expression {

	private final Expression[] contents;

	public BlockExpression(final Scope parent, final Expression... contents) {
		super(parent);
		this.contents = contents;
	}

	public Expression call(final RecordExpression args) {
		set("args", args); // TODO ...or bind each argument directly by name?
		Expression value = null;
		for (final Expression expr : contents) {
			value = expr.evaluateWithin(this);
			if (expr instanceof ReturnExpression) {
				return value;
			}
		}
		return value;
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
		final StringBuilder code = new StringBuilder();
		code.append("[");
		for (final Expression expr : contents) {
			code.append(expr.print());
		}
		code.append("]");
		return code.toString();
	}

}
