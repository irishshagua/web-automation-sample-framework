package ie.testtriangle.automation.widget;

import ie.testtriangle.automation.widget.iface.IReadableWidget;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class MessageWidget extends AbstractBaseWidget implements IReadableWidget {

	private final String msg;
	
	public MessageWidget(String xPath) {
		super(xPath);
		
		this.msg = null;
	}
	
	public MessageWidget(String xPath, String msg) {
		super(xPath);
		
		this.msg = msg;
	}
	
	/**
	 * Checks both that the widget is present on
	 * screen and that the text is as expected
	 */
	@Override
	public boolean exists() {
		try { 
			WebElement widget = selenium.findElement(By.xpath(widgetXPath));
			if (widget.getText().equals(this.msg) || this.msg == null)
				return true;
			else
				return false;
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
}