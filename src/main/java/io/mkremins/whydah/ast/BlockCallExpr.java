package io.mkremins.whydah.ast;

import io.mkremins.whydah.interpreter.Scope;

import java.util.List;

public final class BlockCallExpr implements Expr {

	private final BlockExpr block;
	private final List<Expr> args;

	public BlockCallExpr(final BlockExpr block,
			final List<Expr> args) {
		this.block = block;
		this.args = args;
	}

	@Override
	public boolean isFullyEvaluated() {
		return false;
	}

	@Override
	public Expr evaluateWithin(final Scope scope) {
		final Expr[] evaluated = new Expr[args.size()];
		for (int i = 0; i < args.size(); i++) {
			evaluated[i] = args.get(i).evaluateWithin(scope);
		}
		// TODO actually use the evaluated args
		return block.call(new RecordExpr(scope, args));
	}

	@Override
	public String print() {
		// TODO Auto-generated method stub
		return null;
	}

}
