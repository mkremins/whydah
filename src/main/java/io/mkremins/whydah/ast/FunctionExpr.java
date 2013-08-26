package io.mkremins.whydah.ast;

import java.util.Collections;
import java.util.List;

import io.mkremins.whydah.interpreter.Scope;

public final class FunctionExpr extends Scope implements Expr {

	private final Expr argsPattern;
	private final List<Expr> body;

	public FunctionExpr(final Expr argsPattern, final List<Expr> body) {
		this.argsPattern = argsPattern;
		this.body = body;
	}

	public Expr getArgsPattern() {
		return argsPattern;
	}
	
	public List<Expr> getBody() {
		return Collections.unmodifiableList(body);
	}

}
