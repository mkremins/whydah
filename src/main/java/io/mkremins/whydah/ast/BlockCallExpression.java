package io.mkremins.whydah.ast;

import io.mkremins.whydah.interpreter.Scope;

public final class BlockCallExpression implements Expression {

	private final BlockExpression block;
	private final Expression[] args;

	public BlockCallExpression(final BlockExpression block,
			final Expression[] args) {
		this.block = block;
		this.args = args;
	}

	@Override
	public boolean isFullyEvaluated() {
		return false;
	}

	@Override
	public Expression evaluateWithin(final Scope scope) {
		final Expression[] evaluated = new Expression[args.length];
		for (int i = 0; i < args.length; i++) {
			evaluated[i] = args[i].evaluateWithin(scope);
		}
		return block.call(new RecordExpression(scope, args));
	}

	@Override
	public String print() {
		// TODO Auto-generated method stub
		return null;
	}

}
