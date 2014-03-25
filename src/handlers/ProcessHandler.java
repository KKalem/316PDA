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
		
		if(pathInvalid(path)){		
			return false;
		}else{						
			nameToProcMap.put(name, new ProcessBuilder(path).start());
			return true;
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
	
	
	private boolean pathInvalid(String path){
		if(!(path.contains(":"))){		//there must be AT LEAST 1 ":" in a path. otherwise its probably wrong.
			return false;
		}else{
			return true;
		}
	}
	
	
}
