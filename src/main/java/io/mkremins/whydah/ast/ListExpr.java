package io.mkremins.whydah.ast;

import java.util.Collections;
import java.util.List;

public final class ListExpr implements Expr {
	
	private final List<Expr> items;
	
	public ListExpr(final List<Expr> items) {
		this.items = items;
	}
	
	public List<Expr> getItems() {
		return Collections.unmodifiableList(items);
	}
	
}
