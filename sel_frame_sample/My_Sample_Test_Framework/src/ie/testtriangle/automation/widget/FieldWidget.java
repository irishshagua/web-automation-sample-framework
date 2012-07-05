package ie.testtriangle.automation.widget;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import ie.testtriangle.automation.widget.iface.IWriteableWidget;

public class FieldWidget extends AbstractBaseWidget implements IWriteableWidget {

	public FieldWidget(String xPath) {
		super(xPath);
	}

	@Override
	public boolean exists() {
		try { 
			selenium.findElement(By.xpath(widgetXPath));
			
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	@Override
	public String getText() {
		try { 
			return selenium
					.findElement(By.xpath(widgetXPath))
					.getText();
		} catch (NoSuchElementException e) {
			return "";
		}
	}

	@Override
	public boolean compareText(String comparison) {
		try { 
			String actual = selenium
					.findElement(By.xpath(widgetXPath))
					.getText();
			
			return actual.equals(comparison);
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	@Override
	public void setText(String msg) {
		WebElement widget = selenium
						.findElement(By.xpath(widgetXPath));
		widget.clear();
		widget.sendKeys(msg);
	}

}
