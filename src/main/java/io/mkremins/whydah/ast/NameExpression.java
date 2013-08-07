package io.mkremins.whydah.ast;

import io.mkremins.whydah.interpreter.Scope;

import java.util.List;

public final class NameExpression implements Expression {

	private final String left;
	private final NameExpression right;

	public NameExpression(final List<String> names) {
		left = names.get(0);
		right = names.size() == 1 ?
				null : new NameExpression(names.subList(1, names.size()));
	}

	@Override
	public boolean isFullyEvaluated() {
		return false;
	}

	@Override
	public Reference evaluateWithin(final Scope scope) {
		return new Reference(resolveScope(scope), resolveBaseName());
	}

	@Override
	public String print() {
		return left + " " + right.toString();
	}

	private Scope resolveScope(final Scope starting) {
		if (right == null) {
			return starting;
		}
		final Expression leftValue = starting.get(left);
		if (leftValue instanceof RecordExpression) {
			return right.resolveScope((RecordExpression) leftValue);
		} else {
			return null; // TODO throw exception instead of returning null
		}
	}

	private String resolveBaseName() {
		NameExpression child = right;
		while (child.right != null) {
			child = child.right;
		}
		return child.left;
	}

}
