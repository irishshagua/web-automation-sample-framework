package ie.testtriangle.automation.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MyProjectLogger {
	
	private final Path myLogLocation;
	
	public MyProjectLogger(String path) {
		myLogLocation = Paths.get(path);
		initLogFile();
	}
	
	private void initLogFile() {
		// To be filled with project specific
		// log file implementation
		// This could be anythiong from generating
		// a html output to simply using log4j
		// or some other framework
		// It could also be used to log to some
		// external system.
		
		// Mock
		try {
			Files.createFile(myLogLocation);
		} catch (IOException e) {
			UncheckedThrow.throwUnchecked(
					new AutomationFrameworkException(
							"Creating log file failed "+
							"with an IOException"));
		}
	}
	
	public enum LogType {
		PASS, FAIL, INFO
	}
	
	public void logMessage(LogType type, String msg) {
		// This is where the message would be wrote to
		// the log. Again if there were streams needed 
		// to be handled or threading issues or formatting
		// or whatnot, it could be handled here
		
		
		// mock for the mo
		System.out.println("Logger ["+type+"] : " + msg);
	}
}
