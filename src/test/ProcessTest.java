package test;

import static org.junit.Assert.assertEquals;
import handlers.ProcessHandler;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class ProcessTest {

	DummyProcessMap dummyProcessMap;
	ProcessHandler handler;
	String path =" C:\\Windows\\System32\\notepad.exe";
	
	
	@Before
	public void setUp() throws Exception {
		dummyProcessMap = new DummyProcessMap(path);
		handler = new ProcessHandler(dummyProcessMap);
	}

	@Test (expected = IOException.class)  //junit wont start the actual process.
	public void testPathCheck() throws IOException {
		assertEquals(true, handler.startProcess("notepad"));
	}

}
