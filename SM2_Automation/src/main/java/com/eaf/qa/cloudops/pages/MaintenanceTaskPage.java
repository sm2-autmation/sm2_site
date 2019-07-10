package com.eaf.qa.cloudops.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.eaf.qa.base.BasePage;
import com.eaf.qa.utils.TestUtils;

public class MaintenanceTaskPage extends BasePage {

	private static Logger Log = LogManager.getLogger(LoginPage.class.getName());

	// Verify Maintenance tab
	private By maintenanceTab = By.xpath("//div[@id='headerMenu_head-item-maintenance']");
	
	// Maintenance classes
	private By maintenanceTask = By.xpath("//span[contains(text(),'Tasks')]");
	
	private By createViewIcon = By.xpath("//span[@class='halflings-icon plus floatRight']");

	public MaintenanceTaskPage(ThreadLocal<WebDriver> driver) {
		super(driver);
		this.driver = driver;
		Log.info("Initializing login Page Objects");
		PageFactory.initElements(driver.get(), maintenanceTab);
	}
	
	
	public void clickOnMaintenance() {

		clickAndWait(maintenanceTab, longWait);
		//TestUtils.sleep(15);
		waitTillTextPresent("VIEWS", longWait);
		Log.info("Left panel of Views is visible");
	}
	
	public void clickOnTasksSubTab() {

		clickAndWait(maintenanceTask, longWait);
		//TestUtils.sleep(15);
		waitTillTextPresent("VIEWS", longWait);
		Log.info("Left panel of Views is visible");
	}
}
