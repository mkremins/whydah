package io.mkremins.whydah.interpreter;

public final class NothingObj extends Obj {
	
	private NothingObj() {}

	public final static NothingObj INSTANCE;
	
	static {
		INSTANCE = new NothingObj();
	}
	
}
