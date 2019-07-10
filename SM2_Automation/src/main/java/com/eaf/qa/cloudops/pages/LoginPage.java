/*
 *
 */
package com.eaf.qa.cloudops.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.eaf.qa.base.BasePage;
import com.eaf.qa.utils.TestUtils;

/**
 * Created By : Adeeb.
 */

public class LoginPage extends BasePage {

	/** The Log. */
	private static Logger Log = LogManager.getLogger(LoginPage.class.getName());
	
	/** The sign in link. */
	private By loginBttn = By.xpath("//form[@action='/LoginSM2/LoginSM2']//input[@value='Log in']");
	
	/** The email. */
	private By emailField = By.id("txtLogin");

	/** The password. */
	private By passwordField = By.id("txtPass");
		

	/**
	 * Instantiates a new login page.
	 *
	 * @param driver the driver
	 */
	// initialize elements
	public LoginPage(ThreadLocal<WebDriver> driver) {

		super(driver);
		this.driver = driver;
		Log.info("Initializing login Page Objects");
		PageFactory.initElements(driver.get(), emailField);

	}
	
	/**
	 * Login Page.
	 *
	 * @return true, if is Login Page present
	 */
	public boolean isLoginPagePresent() {
		boolean status = false;
		if (getElementIfVisibleUsingXpath(emailField, longWait)) {
			waitForElementToBeClickable(emailField, longWait);
			status = true;
		}
		return status;

	}

//add all actions method here

	/**
	 * Login into UI.
	 */
	public void logInToSM2(String username, String password) {
		gotoURL(TestUtils.getProperty("sm2.adminurl"));
//		String username = TestUtils.decodeText(TestUtils.getProperty("engineer.ai.cloudops.username"));
//		String uipassword = TestUtils.decodeText(TestUtils.getProperty("engineer.ai.cloudops.password"));

	    setText(emailField, username);
		setText(passwordField, password);
		clickAndWait(loginBttn, longWait);
		
		
		
		waitTillTextPresent("DASHBOARDS", longWait);
		Log.info("Login Successfull");

	}
			
}