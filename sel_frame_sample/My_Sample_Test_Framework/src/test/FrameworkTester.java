package test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import ie.testtriangle.automation.TestManager;

public class FrameworkTester {
	
	@Test
	public void getSeleniumInstance() {
		WebDriver sel = TestManager.getSeleniumInstance();
		Class<? extends WebDriver> clazz = sel.getClass();
		assertTrue(clazz.equals(FirefoxDriver.class));
	}
	
	@Test
	public void openWebsite() {
		WebDriver sel = TestManager.getSeleniumInstance();
		
		String url = "http://www.google.ie";
		TestManager.openWebsite(url);
		
		String title = sel.getTitle();
		
		assertTrue(title.equalsIgnoreCase(url));
	}
}
