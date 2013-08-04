package io.mkremins.whydah.ast;

import io.mkremins.whydah.interpreter.Scope;

public interface Expression {

	boolean isFullyEvaluated();

	Expression evaluateWithin(Scope scope);

	String print();

}
