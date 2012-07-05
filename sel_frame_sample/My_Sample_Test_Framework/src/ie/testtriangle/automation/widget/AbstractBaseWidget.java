package ie.testtriangle.automation.widget;

import org.openqa.selenium.WebDriver;

import ie.testtriangle.automation.TestManager;

public abstract class AbstractBaseWidget {

	protected final String widgetXPath;
	protected final WebDriver selenium;
	
	// Instance Init Block
	{
		selenium = TestManager.getSeleniumInstance();
	}
	
	protected AbstractBaseWidget(String xPath) {
		this.widgetXPath = xPath;
	}
	
	/**
	 * Check if a widget is visible on
	 * the screen
	 * 
	 * @return
	 * 		<b>boolean</b>
	 * 		True or False depending whether
	 * 		the widget can be found
	 */
	public abstract boolean exists();
	
	/**
	 * Wait for widget to appear on
	 * the screen
	 * 
	 * @param numChecks
	 * 		<b>int</b>
	 * 		The number of iterations the loop
	 * 		will run for, pausing for one second
	 * 		between each loop
	 * 
	 * @return
	 * 		<b>boolean</b>
	 * 		True or False depending on whether
	 * 		the widget was found within the 
	 * 		timeout
	 */
	public boolean waitForWidget(int numChecks) {
		while (numChecks-- > 0) {
			if (exists())
				return true;
			
			TestManager.sleep(1);
		}
		
		return false;
	}
}