package ie.testtriangle.project.objects.webpage;

import ie.testtriangle.automation.TestManager;
import ie.testtriangle.automation.widget.ButtonWidget;
import ie.testtriangle.automation.widget.FieldWidget;
import ie.testtriangle.automation.widget.MessageWidget;

public class ContactUs implements IWebPage {
	
	private final String url = "http://www.testtriangle.ie/contactus";
	
	public FieldWidget nameField = new FieldWidget("//input[@title='Name']");
	public FieldWidget emailField = new FieldWidget("//input[@title='Email Id']");
	public FieldWidget subjectField = new FieldWidget("//input[@title='Subject']");
	public FieldWidget phoneNumberField = new FieldWidget("//input[@title='Phone Number']");
	public FieldWidget messageField = new FieldWidget("//textarea[@title='Message']");
	public ButtonWidget submitBtn = new ButtonWidget("//button[@class='foxbutton' and @type='submit']");
	
	public MessageWidget failMsg = new MessageWidget("//ul[@class='fox_messages']/li[contains(text(), 'Invalid field:')]");
	public MessageWidget successMsg = new MessageWidget("//ul[@class='fox_messages']/li[contains(text(), 'Thank You For Your E-Mail.')]");
	
	private ButtonWidget contactUsLink = new ButtonWidget("//a[@title='Contact Us']");
	

	@Override
	public void open() {
		if (contactUsLink.waitForWidget(5))
			contactUsLink.click();
		
		TestManager.openWebsite(getUrl());
	}

	@Override
	public String getUrl() {
		return url;
	}
}