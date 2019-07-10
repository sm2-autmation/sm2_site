package com.eaf.qa.cloudops.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eaf.qa.base.BasePage;
import com.eaf.qa.utils.DataUtils;
import com.eaf.qa.utils.TestUtils;

public class CreateDevicesPage extends BasePage 
{	
	private static Logger Log = LogManager.getLogger(CreateUsersPage.class.getName());

	public CreateDevicesPage(ThreadLocal<WebDriver> driver) {
		super(driver);
	}
	
	private By equipmentTab = By.xpath("//div[@id='headerMenu_head-item-assets']");
	
	private By devicesSubTab = By.xpath("//span[contains(text(),'Devices')]");
	
	private By plusIconOfDevices = By.xpath("//a[@id='secondLvlBtns_319']//div[@class='page_item page_item_add']");
	
	private By listOfDevicesView = By.xpath("//div[@class='view-column-title']//span[contains(text(),'List of devices')]");
	
	private By setFilter = By.xpath("//div[@id='view-action-filter']");
	
	private By deviceCodeParameter = By.xpath("//form[@id='filterColumnsForm']//div[2]");
	
	private By filterByA = By.xpath("//input[@id='DDNOD-r5']//preceding-sibling::label[1]");
	
	private By textFieldOfFilterByA = By.xpath("//form[@id='filterColumnsForm']//div[2]//div[3]//input");
	
	private By refreshIcon = By.xpath("//div[@id='view-action-execute']");

	private By codeTextFied = By.xpath("//input[@id='DDNO']");
	
	private By descriptionTextField = By.xpath("//input[@id='DDDE']");
	
	private By saveBttn = By.xpath("//button[@id='btnTopSave']");
	
	private By eqNumberTextField = By.xpath("//input[@id='EQNO']");
	
	
	public void clickOnEquipmentTab()
	{
		clickAndWait(equipmentTab, longWait);
		Log.info("Equipment tab was clicked");
	}
	
	public void clickOnDevicesSubTab()
	{
		clickAndWait(devicesSubTab, longWait);
		Log.info("Devices Sub Tab was clicked");
	}
	
	public void clickOnPlusIconToAddDevices()
	{
		clickAndWait(plusIconOfDevices, longWait);
		Log.info("Plus icon was clicked successfully");
	}
      
	
	
	public void verifyDeviceAndCreateDevice()
    {
    	for(int i = 1;DataUtils.getTestData1("CreateDevices", "Device Code", "Option"+i)!=null;i++)
		{
			F1(DataUtils.getTestData1("CreateDevices", "Device Code", "Option"+i),i);
		}
    }
    
    private void F1(String Name, int i) 
	{
    	waitForElementToBeClickable(listOfDevicesView, longWait);
    	clickAndWait(listOfDevicesView, shortWait);
    	Log.info("List Of Devices view was clicked");
    	
    	clickAndWait(setFilter, longWait);
		Log.info("Filter icon clicked");
		
		waitForElementToBeClickable(deviceCodeParameter, longWait);
			    	
		/*
		 * if(i>1) { clickAndWait(deviceCodeParameter, shortWait);
		 * Log.info("User ID parameter is clicked"); }
		 */
    	
    	clickAndWait(deviceCodeParameter, shortWait);
		Log.info("User ID parameter is clicked");	
		
		waitForElementToBeClickable(filterByA, longWait);
		clickAndWait(filterByA, shortWait);
		Log.info("Filter value A is clicked");
		
		setText(textFieldOfFilterByA, Name, shortWait);
		Log.info("Text entered in filter text box");
		
		clickAndWait(refreshIcon, longWait);
		Log.info("Refresh icon is clicked");
		
		TestUtils.sleep(5);
		if((isTextPresentOnPage(Name)))
		   {
			System.out.println("Device Code is already in the list");
			return;	
		   }
		else{
			System.out.println("User ID is not available in the list.. Creating Now.....");
			clickOnPlusIconToAddDevices();
			
			waitForElementToBeClickable(codeTextFied, shortWait);
			
			setDataForCodeTextField(DataUtils.getTestData1("CreateDevices", "Device Code", "Option"+i));
			Log.info("Device code entered successfully");
			
			setDataForDescription(DataUtils.getTestData1("CreateDevices", "Description", "Option"+i));
			Log.info("Description entered successfully");
			System.out.println("--------------------------->"+DataUtils.getTestData1("CreateVehicle", "EqNumber", "Option"+i));
			setDataForEqNumberTextField(DataUtils.getTestData1("CreateVehicle", "EqNumber", "Option"+i));
			Log.info("Equipment Number entered successfully");
			
			clickAndWait(saveBttn, longWait);	
			Log.info("Save button clicke successfully");
		    }	
	}
	
    public void setDataForCodeTextField(String Name)
	{
		waitForElementToBeClickable(codeTextFied, longWait);
		setText(codeTextFied, Name, shortWait);	
	}
	
	public void setDataForDescription(String Description)
	{ 
		setText(descriptionTextField, Description, shortWait);	
	}
	
	public void setDataForEqNumberTextField(String Description)
	{ 
		setText(eqNumberTextField, Description, shortWait);
	}
}