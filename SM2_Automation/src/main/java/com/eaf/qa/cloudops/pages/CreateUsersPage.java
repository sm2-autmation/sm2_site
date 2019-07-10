package com.eaf.qa.cloudops.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eaf.qa.base.BasePage;
import com.eaf.qa.utils.DataUtils;
import com.eaf.qa.utils.TestUtils;

public class CreateUsersPage extends BasePage 

{
	private static Logger Log = LogManager.getLogger(CreateUsersPage.class.getName());
	
	public CreateUsersPage(ThreadLocal<WebDriver> driver) {
		super(driver);
	}

	private By personnelTab = By.xpath("//div[@id='headerMenu_head-item-users']");
	
	private By siteManagerClassicDefaultView = By.xpath("//div[@class='view-column-title']//span[contains(text(),'SiteManager Classic Default')]");
	
	private By  setFilter = By.xpath("//div[@id='view-action-filter']");
	
	private By userIDParameter = By.xpath("//div[contains(text(),'User ID')]");
	
	private By filterByA = By.xpath("//input[@id='USNO-r5']//preceding-sibling::label[1]//span");
	
	private By textFieldOfFilterByA = By.xpath("//div[@class='filter-column-title selectedFilter' and contains(text(),'User ID') ]//following-sibling::div[2]//input");
	
	private By refreshIcon= By.xpath("//div[@class='buttonHeader']//div[@class='RefreshIcon ViewIcons']");
	
	
	private By addUsersIcon = By.xpath("//div[@class='page_item page_item_add']");
	
	private By userIDFTextField = By.xpath("//input[@id='USNO']");
	
	private By userNameTextField = By.xpath("//input[@id='USDE']");
		
	private By saveBttn = By.xpath("//button[@id='btnTopSave']");
	
	

	    public void clickOnPersonnelTab()
	    {
		clickAndWait(personnelTab, longWait);
		Log.info("Personnel tab was clicked");
	    }
	
	    public void clickOnPlusIconToAddUser()
	    {
	    	clickAndWait(addUsersIcon, longWait);
	    	TestUtils.sleep(2);
	    	Log.info("Plus icon to create user was clicked");
	    }
	    
	    
	    public void verifyUserIDAndCreateUserID()
	    {
	    	for(int i = 1;DataUtils.getTestData1("CreateUserID", "User ID", "Option"+i)!=null;i++)
			{
				F1(DataUtils.getTestData1("CreateUserID", "User ID", "Option"+i),i);
			}
	    }
	    
	    private void F1(String Name, int i) 
		{
	    	waitForElementToBeClickable(siteManagerClassicDefaultView, longWait);
	    	clickAndWait(siteManagerClassicDefaultView, shortWait);
	    	Log.info("SiteManager Classic Default view was clicked");
	    	
	    	clickAndWait(setFilter, longWait);
			Log.info("Filter icon clicked");
			
			waitForElementToBeClickable(userIDParameter, longWait);
				    	
	    	if(i>1)
	    	{
	    	    clickAndWait(userIDParameter, shortWait);
				Log.info("User ID parameter is clicked");
	    	}
	    	
	    	clickAndWait(userIDParameter, shortWait);
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
				System.out.println("User ID is already in the list");
				return;	
			}
			else {
				System.out.println("User ID is not available in the list.. Creating Now.....");
				clickOnPlusIconToAddUser();
				waitForElementToBeClickable(userIDFTextField, shortWait);
				setDataForUserIDTextField(DataUtils.getTestData1("CreateUserID", "User ID", "Option"+i));
				setDataForUserName(DataUtils.getTestData1("CreateUserID", "Use Name", "Option"+i));
				clickAndWait(saveBttn, longWait);	
			}	
		}
	    
	    public void setDataForUserIDTextField(String Name)
	    {
	    	waitForElementToBeClickable(userIDFTextField, longWait);
			setText(userIDFTextField, Name, shortWait);	
	    }
 
	    public void setDataForUserName(String UserName)
	    {
	    	waitForElementToBeClickable(userNameTextField, longWait);
			setText(userNameTextField, UserName, shortWait);	
	    }

}