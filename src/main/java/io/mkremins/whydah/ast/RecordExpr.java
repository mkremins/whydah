package io.mkremins.whydah.ast;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class RecordExpr implements Expr {
	
	private final Map<String, Expr> fields;

	public RecordExpr(final List<Expr> vars) {
		fields = new HashMap<String, Expr>();
		for (int i = 0; i < vars.size(); i++) {
			fields.put(String.valueOf(i), vars.get(i));
		}
	}
	
	public Map<String, Expr> getFields() {
		return Collections.unmodifiableMap(fields);
	}

}
