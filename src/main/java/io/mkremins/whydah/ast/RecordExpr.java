package io.mkremins.whydah.ast;

import io.mkremins.whydah.interpreter.Obj;
import io.mkremins.whydah.interpreter.Scope;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class RecordExpr implements Expr {
	
	private final Map<String, Obj> fields;

	public RecordExpr(final List<Obj> vars) {
		fields = new HashMap<String, Obj>();
		for (int i = 0; i < vars.size(); i++) {
			fields.put(String.valueOf(i), vars.get(i));
		}
	}
	
	public Map<String, Obj> getFields() {
		return Collections.unmodifiableMap(fields);
	}

	@Override
	public Obj evaluateWithin(final Scope scope) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String print() {
		// TODO Auto-generated method stub
		return null;
	}

}
