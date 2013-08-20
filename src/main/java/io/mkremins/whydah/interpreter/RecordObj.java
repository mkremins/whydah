package io.mkremins.whydah.interpreter;

import java.util.HashMap;
import java.util.Map;

public final class RecordObj extends Obj {
	
	private final Map<String, Obj> fields;

	public RecordObj(final Map<String, Obj> fields) {
		this.fields = fields;
	}
	
	public Obj getField(final String name) {
		return hasField(name) ? NothingObj.INSTANCE : fields.get(name);
	}
	
	public Obj setField(final String name, final Obj obj) {
		// TODO return exception object instead of `nothing` if field undefined?
		return hasField(name) ? cloneWithChange(name, obj) : this;
	}
	
	private boolean hasField(final String name) {
		return fields.containsKey(name);
	}
	
	private RecordObj cloneWithChange(final String name, final Obj newObj) {
		final Map<String, Obj> newFields = new HashMap<String, Obj>(fields.size());
		for (final String fieldName : fields.keySet()) {
			final Obj obj = name == fieldName ? newObj : fields.get(fieldName);
			newFields.put(fieldName, obj);
		}
		return new RecordObj(newFields);
	}
	
}
