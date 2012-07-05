package ie.testtriangle.project.tests.area

import ie.testtriangle.project.dsl.TestController;

use(TestController) {
	test.browser.open('http://www.testtriangle.ie')
	
	test.browser.page('ContactUs').open()
	
	test.browser.page('ContactUs').nameField.setText 'John Doe'
	test.browser.page('ContactUs').emailField.setText 'invalid mail address'
	test.browser.page('ContactUs').subjectField.setText 'The Real Meaning of 47'
	test.browser.page('ContactUs').phoneNumberField.setText '112'
	test.browser.page('ContactUs').nameField.setText 'John Doe'
	test.browser.page('ContactUs').messageField.setText 'This is a message. Honest!'
		
	test.browser.page('ContactUs').submitBtn.click()
	
	assert test.browser.page('ContactUs').failMsg.exists()
	
	test.browser.page('ContactUs').emailField.setText 'brian_satchwannabe@hotmail.com'
	
	test.browser.page('ContactUs').submitBtn.click()
	
	assert test.browser.page('ContactUs').successMsg.exists()
}