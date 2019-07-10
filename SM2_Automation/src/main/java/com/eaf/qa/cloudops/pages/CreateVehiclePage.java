package com.eaf.qa.cloudops.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eaf.qa.base.BasePage;
import com.eaf.qa.utils.DataUtils;
import com.eaf.qa.utils.TestUtils;


public class CreateVehiclePage extends BasePage 
{
	private static Logger Log = LogManager.getLogger(CreateVehiclePage.class.getName());

	public CreateVehiclePage(ThreadLocal<WebDriver> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
		private By equipmentTab = By.xpath("//div[@id='headerMenu_head-item-assets']");
	
		private By createVehicleIcon = By.xpath("//a[@id='secondLvlBtns_16']//div[@class='page_item page_item_add']");
		
		private By clickOnSiteManagerClassicDefault = By.xpath("//div[@class='view-column-title']//span[contains(text(),'SiteManager Classic Default')]");	
		
		private By  setFilter = By.xpath("//div[@id='view-action-filter']");
		
		private By eqNumberParameter = By.xpath("//div[contains(text(),'Eq. Number')]");
		
		private By filterByA = By.xpath("//input[@id='EQNO-r5']//preceding-sibling::label[1]//span");
		
		private By textFieldOfFilterByA = By.xpath("//form[@id='filterColumnsForm']//div[7]//div[3]//input");
		
		private By refreshIcon= By.xpath("//div[@class='buttonHeader']//div[@class='RefreshIcon ViewIcons']");
				
		private By eqNumberTextField = By.xpath("//input[@id='EQNO']");
		
		private By eqDescriptionTextField = By.xpath("//input[@id='EQDE']");
				
		private By saveBttn = By.xpath("//button[@id='btnTopSave']");
		

		public void clickOnEquipmentTab()
		{
			clickAndWait(equipmentTab, longWait);
            Log.info("Equipment tab clicked");
		}
		
		public void clickOnCreateVehiclePlusIcon()
		{
			clickAndWait(createVehicleIcon, longWait);
	        Log.info("Create new vehicle "+" icon clicked");
		}
					
		public void verifyEqNumberAndCreateVehicle()
		{
			for(int i = 1;DataUtils.getTestData1("CreateVehicle", "EqNumber", "Option"+i)!=null;i++)
			{
				F1(DataUtils.getTestData1("CreateVehicle", "EqNumber", "Option"+i),i);
			}	
		}

		private void F1(String Name, int i) 
		{
			waitForElementToBeClickable(clickOnSiteManagerClassicDefault, longWait);
			clickAndWait(clickOnSiteManagerClassicDefault, shortWait);
			Log.info("SiteManager Classic Default view was clicked");
			
			clickAndWait(setFilter, longWait);
			Log.info("Filter icon clicked");
			
			waitForElementToBeClickable(eqNumberParameter, longWait);
		
			if(i>1)
			{
				clickAndWait(eqNumberParameter, shortWait);
				Log.info("Eq. Number parameter is clicked");	
			}
			
			clickAndWait(eqNumberParameter, shortWait);
			Log.info("Eq. Number parameter is again clicked");
			
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
				System.out.println("Equipment Number is already in the list");
				return;	
			}
			else {
				System.out.println("Equipment Number is not available in the list.. Creating Now.....");
				
				clickOnCreateVehiclePlusIcon();
				
				waitForElementToBeClickable(eqNumberTextField, shortWait);
				
				setDataForEqNumberTextField(DataUtils.getTestData1("CreateVehicle", "EqNumber", "Option"+i));
				
				setDataForEqDescription(DataUtils.getTestData1("CreateVehicle", "EqDescription", "Option"+i));
				
				clickAndWait(saveBttn, longWait);	
				
				TestUtils.sleep(5);
			}			
		}
		
		public void setDataForEqNumberTextField(String Name)
		{
			waitForElementToBeClickable(eqNumberTextField, longWait);
			setText(eqNumberTextField, Name, shortWait);
		}
		
		public void setDataForEqDescription(String Description)
		{ 
			setText(eqDescriptionTextField, Description, shortWait);
			
		}
}