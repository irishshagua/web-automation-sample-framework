package ie.testtriangle.project.dsl;

import ie.testtriangle.automation.TestManager;
import ie.testtriangle.project.objects.SitePageFactory;

/*
* DSL for Tests
*/
class TestController {
	def selDriver // sel driver
	def page // AUT page object repository
	
	static getTest(self) {
		return new TestController()
	}
	
	static getBrowser(self) {
		self.selDriver = TestManager.getSeleniumInstance()
		return self
	}
	
	static open(self, url) {
		TestManager.openWebsite(url)
	}
	
	static page(self, pageID) {
		return SitePageFactory.getPage(pageID)
	}
	
	def sleep(numSecs) {
		TestManager.sleep(numSecs)
	}
}