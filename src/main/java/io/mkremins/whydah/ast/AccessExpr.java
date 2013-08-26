package io.mkremins.whydah.ast;

public final class AccessExpr implements Expr {

	private final Expr index;
	private final Expr subject;
	
	public AccessExpr(final Expr index, final Expr subject) {
		this.index = index;
		this.subject = subject;
	}
	
	public Expr getIndex() {
		return index;
	}
	
	public Expr getSubject() {
		return subject;
	}
	
}
