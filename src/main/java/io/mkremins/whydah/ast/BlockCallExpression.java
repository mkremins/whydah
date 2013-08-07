package io.mkremins.whydah.ast;

import io.mkremins.whydah.interpreter.Scope;

import java.util.List;

public final class BlockCallExpression implements Expression {

	private final BlockExpression block;
	private final List<Expression> args;

	public BlockCallExpression(final BlockExpression block,
			final List<Expression> args) {
		this.block = block;
		this.args = args;
	}

	@Override
	public boolean isFullyEvaluated() {
		return false;
	}

	@Override
	public Expression evaluateWithin(final Scope scope) {
		final Expression[] evaluated = new Expression[args.size()];
		for (int i = 0; i < args.size(); i++) {
			evaluated[i] = args.get(i).evaluateWithin(scope);
		}
		// TODO actually use the evaluated args
		return block.call(new RecordExpression(scope, args));
	}

	@Override
	public String print() {
		// TODO Auto-generated method stub
		return null;
	}

}
