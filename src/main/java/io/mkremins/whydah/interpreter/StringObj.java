package io.mkremins.whydah.interpreter;

public final class StringObj extends Obj {

	private final String value;
	
	public StringObj(final String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
}
