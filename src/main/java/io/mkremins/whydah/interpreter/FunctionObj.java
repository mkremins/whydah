package io.mkremins.whydah.interpreter;

import java.util.Collections;
import java.util.List;

import io.mkremins.whydah.ast.Expr;

public final class FunctionObj extends Obj {

	private final List<Expr> body;
	
	public FunctionObj(final List<Expr> body) {
		this.body = body;
	}
	
	public List<Expr> getBody() {
		return Collections.unmodifiableList(body);
	}
	
}
