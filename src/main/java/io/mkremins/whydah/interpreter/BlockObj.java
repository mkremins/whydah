package io.mkremins.whydah.interpreter;

import io.mkremins.whydah.ast.Expr;

public final class BlockObj extends Obj {

	private final Expr[] body;
	
	public BlockObj(final Expr[] body) {
		this.body = body;
	}
	
	public Expr[] getBody() {
		return body;
	}
	
}
