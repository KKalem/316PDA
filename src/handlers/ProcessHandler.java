package handlers;

import java.io.IOException;
import java.util.HashMap;

import interfaces.IProcessMap;

public class ProcessHandler {

	IProcessMap procMap;
	HashMap<String,Process> nameToProcMap; 
	
	
	public ProcessHandler(IProcessMap procMap){
		this.procMap = procMap;
	}
	
	
	public boolean startProcess(String name) throws IOException{
		String path = procMap.getProcessPath(name);
		
		if(pathValid(path)){		
			nameToProcMap.put(name, new ProcessBuilder(path).start());
			return true;
		}else{						
			return false;
		}
	}
	
	
	public boolean killProcess(String name){
		if(nameToProcMap.containsKey(name)){ //the given process was started by us
			Process p = nameToProcMap.get(name);
			p.destroy();
			System.out.println("["+name+"] exited with:"+p.exitValue());
			nameToProcMap.remove(name);
			return true;			
		}else{								//not meddling with processes started outside of our control is better imo.
			return false;
		}
	}
	
	
	private boolean pathValid(String path){
		if(path.contains(":") && path.contains(".exe")){
			return true;
		}
		return false;
	}
	
	
}
