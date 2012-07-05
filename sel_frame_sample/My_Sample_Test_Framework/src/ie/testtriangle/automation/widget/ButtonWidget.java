package ie.testtriangle.automation.widget;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import ie.testtriangle.automation.widget.iface.IClickableWidget;

public class ButtonWidget extends AbstractBaseWidget implements IClickableWidget {

	public ButtonWidget(String xPath) {
		super(xPath);
	}

	@Override
	public boolean exists() {
		try { 
			if (selenium.findElement(By.xpath(widgetXPath)).isEnabled())
				return true;
			else
				return false;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	@Override
	public void click() {
		selenium.findElement(By.xpath(widgetXPath)).click();	
	}
}
