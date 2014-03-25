package test;

import interfaces.IProcessMap;

public class DummyProcessMap implements IProcessMap {

	String path="";
	
	public DummyProcessMap(String path) {
		this.path = path;
	}
	
	@Override
	public String getProcessPath(String key) {
		return path;
	}

	
}
