package io.mkremins.whydah.ast;

import io.mkremins.whydah.interpreter.Scope;

public final class BlockExpr extends Scope implements Expr {

	private final Expr[] contents;

	public BlockExpr(final Scope parent, final Expr... contents) {
		super(parent);
		this.contents = contents;
	}

	public Expr call(final RecordExpr args) {
		set("args", args); // TODO ...or bind each argument directly by name?
		Expr value = null;
		for (final Expr expr : contents) {
			value = expr.evaluateWithin(this);
			if (expr instanceof ReturnExpr) {
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
	public Expr evaluateWithin(final Scope scope) {
		return this;
	}

	@Override
	public String print() {
		final StringBuilder code = new StringBuilder();
		code.append("[");
		for (final Expr expr : contents) {
			code.append(expr.print());
		}
		code.append("]");
		return code.toString();
	}

}
