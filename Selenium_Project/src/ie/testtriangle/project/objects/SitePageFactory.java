package ie.testtriangle.project.objects;

import ie.testtriangle.project.objects.webpage.ContactUs;
import ie.testtriangle.project.objects.webpage.IWebPage;

public class SitePageFactory {

	public static IWebPage getPage(String pageID) {
		switch (pageID) {
			case "ContactUs":
				return new ContactUs();
			default:
				return null;
		}
	}
}
