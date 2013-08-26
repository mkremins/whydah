package io.mkremins.whydah.ast;

public final class AssignExpr implements Expr {

	private final Expr left;
	private final Expr right;

	public AssignExpr(final Expr left, final Expr right) {
		this.left = left;
		this.right = right;
	}

	public Expr getLeft() {
		return left;
	}
	
	public Expr getRight() {
		return right;
	}

}
