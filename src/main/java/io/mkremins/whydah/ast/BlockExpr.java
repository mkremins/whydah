package io.mkremins.whydah.ast;

import io.mkremins.whydah.interpreter.BlockObj;
import io.mkremins.whydah.interpreter.Obj;
import io.mkremins.whydah.interpreter.RecordObj;
import io.mkremins.whydah.interpreter.Scope;

public final class BlockExpr extends Scope implements Expr {

	private final Expr[] body;

	public BlockExpr(final Scope parent, final Expr... body) {
		super(parent);
		this.body = body;
	}

	public Obj call(final RecordObj args) {
		set("args", args); // TODO use a Pattern to handle binding
		Obj value = null;
		for (final Expr expr : body) {
			value = expr.evaluateWithin(this);
			if (expr instanceof ReturnExpr) {
				return value;
			}
		}
		return value;
	}

	@Override
	public Obj evaluateWithin(final Scope scope) {
		return new BlockObj(body);
	}

	@Override
	public String print() {
		final StringBuilder code = new StringBuilder();
		code.append("[");
		for (final Expr expr : body) {
			code.append(expr.print());
		}
		code.append("]");
		return code.toString();
	}

}
