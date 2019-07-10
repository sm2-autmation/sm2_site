package com.eaf.qa.uitests;

import java.net.URISyntaxException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.eaf.qa.utils.TestUtils;
import com.relevantcodes.extentreports.LogStatus;
import com.thoughtworks.selenium.webdriven.commands.GetText;

/**
 * The Class BuilderTests for writing UI Test cases for Builder.
 *
 * @author Adeeb Khan
 */

public class LoginTest extends BaseTest {

	/** The Log. */
	private static Logger Log = LogManager.getLogger(LoginTest.class.getName());

	
	/**
	 * Test Admin Login Flow.
	 * @throws URISyntaxException 
	 */
	@Test(description = "To verify login on SM2", groups = { "UITestsAdmin", "Login" },retryAnalyzer= com.eaf.qa.base.RetryAnalyzer.class)
	public void testSM2LoginFlow() throws URISyntaxException 
	{	
		test = extent.startTest("Login to SM2 as Admin");
			
		createTicketInTFS();
		
//		pages.getLoginPage().logInToSM2("Admin", "fz;1234");
//		pages.getMaintenanceClassPage().VerifyMaintenanceTab();
//		actions.verify(pages.getMaintenanceClassPage().VerifyMaintenanceTab(), true, "Maintenance tab is not present");
//			
//		Reporter.log("Logged in to SM2 application as admin");
//		test.log(LogStatus.PASS, "LOGGEN IN TO SM2 APPLICATION");
//		
//		pages.getLoginPage().logInToSM2(TestUtils.decodeText(TestUtils.getProperty("sm2.user.name")),
//	    TestUtils.decodeText(TestUtils.getProperty("sm2.user.password")));
	}		
}