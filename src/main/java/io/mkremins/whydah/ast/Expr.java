package io.mkremins.whydah.ast;

import io.mkremins.whydah.interpreter.Obj;
import io.mkremins.whydah.interpreter.Scope;

public interface Expr {
	
	Obj evaluateWithin(Scope scope);
	String print();

}
