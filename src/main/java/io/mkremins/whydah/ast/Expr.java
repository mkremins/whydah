package io.mkremins.whydah.ast;

import io.mkremins.whydah.interpreter.Scope;

public interface Expr {

	boolean isFullyEvaluated();

	Expr evaluateWithin(Scope scope);

	String print();

}
