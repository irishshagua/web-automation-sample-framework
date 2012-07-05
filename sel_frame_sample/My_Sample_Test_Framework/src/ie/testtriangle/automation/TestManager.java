package ie.testtriangle.automation;

import ie.testtriangle.automation.utils.MyProjectLogger;
import ie.testtriangle.automation.utils.MyProjectLogger.LogType;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestManager {
	
	private static MyProjectLogger log = null;
	
	/**
	 * Return one instance of the logging 
	 * object for the framework.
	 * ie. Singleton instance
	 * 
	 * @return
	 * 		<b>MyProjectLogger</b>
	 * 		This projects logging instance
	 */
	private static MyProjectLogger getLoggerInstance() {
		if (log != null)
			return log;
		
		// This log location could be loaded by some 
		// external properties file so as to keep
		// maintenance on the framework code to a 
		// minimum
		String logLocation = "/path/to/file.log";
		log = new MyProjectLogger(logLocation);
		
		return log;
	}
	
	
	private static WebDriver driver = null;
	
	/**
	 * Return one instance of the selenium 
	 * driver per test run.
	 * ie. Singleton instance
	 * 
	 * @return
	 * 		<b>WebDriver</b>
	 * 		The Selenium Web Driver instance
	 */
	public static WebDriver getSeleniumInstance() {
		if (driver != null)
			return driver;
		
		// Desired browser could be provided by some framework
		// mechanism
		String RUNTIME_ENVIRONMENT = "FIREFOX";
		switch (RUNTIME_ENVIRONMENT) {
			case "FIREFOX":
				driver = new FirefoxDriver();
				break;
			case "IEXPLORE":
				driver = new InternetExplorerDriver();
				break;
			case "CHROME":
				driver = new ChromeDriver();
				break;
			default:
				driver = new HtmlUnitDriver();
		}
		
		return driver;
	}
	
	/**
	 * Sleep wrapper to hide the exception
	 * handling required by Thread.sleep()
	 * 
	 * @param numSecs
	 * 		<b>int</b>
	 * 		The number of seconds to sleep for
	 */
	public static void sleep(int numSecs) {
		try {
			Thread.sleep(numSecs * 1000);
		} catch (InterruptedException e) {
			// Swallow exceptions
		}
	}
	
	/**
	 * Direct selenium Web Driver to a 
	 * specific website url
	 * 
	 * @param url
	 * 		<b>String</b>
	 * 		The url you wish the browser 
	 * 		to open
	 */
	public static void openWebsite(String url) {
		getSeleniumInstance().get(url);
	}
	
	
	// Below methods are exposed to allow for direct 
	// access to writing log events. This can be
	// further wrapped in a thin layer if required
	public static void logPass(String msg) {
		getLoggerInstance().logMessage(LogType.PASS, msg);
	}
	
	public static void logFail(String msg) {
		getLoggerInstance().logMessage(LogType.FAIL, msg);
	}
	
	public static void logInfo(String msg) {
		getLoggerInstance().logMessage(LogType.INFO, msg);
	}
}