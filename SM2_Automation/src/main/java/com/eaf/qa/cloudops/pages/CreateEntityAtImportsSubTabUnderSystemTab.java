package com.eaf.qa.cloudops.pages;

import static org.testng.Assert.assertTrue;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.eaf.qa.base.BasePage;
import com.eaf.qa.utils.TestUtils;

public class CreateEntityAtImportsSubTabUnderSystemTab extends BasePage{
	
	private static Logger Log = LogManager.getLogger(CreateVehiclePage.class.getName());

	public CreateEntityAtImportsSubTabUnderSystemTab(ThreadLocal<WebDriver> driver) 
	   {
		super(driver);
	   }

	private By importsSubTab = By.xpath("//span[contains(text(),'Imports')]");	
	
	private By systemTab = By.xpath("//div[@id='headerMenu_head-item-system']");	
	
	private By leftPanel = By.xpath("//div[@id='indEntities']");	
	
	private By nameFieldOnCreateEntityPage = By.xpath("//input[@id='txtName']");	
	
	private By AddFieldDropDown = By.xpath("//select[@id='selectItems']");	
	
	private By AddBttnForDropDown = By.xpath("//input[@class='addButton btn-default']");	
	
	private By saveBttn = By.xpath("//input[@id='btnSave']");	
	
	private By successMsg = By.xpath("//div[@id='successMsgs']");
	
	//private By successMsg = By.xpath("//p[@class='errorMsgBody']");
	
	
	
	
	public void clickOnSystemTab()
	{
		clickAndWait(systemTab, longWait);
	}

	
	public void createsomeentity()
	 {
		List<String> li = new ArrayList<String>();
		li.add("Cost Center Code");
		li.add("Department Name");
		li.add("Encrypted Card #1");
		li.add("Force Password Change");
		String[] myStringArray = {"a", "b", "c"};
		myStringArray[3]="ashraf";
		System.out.println("---------//---------------->"+myStringArray[3]+"-----------------");
		createEntity("Equipment","losangeles",li);
		
	 }
	
	public void clickOnImportsSubTab()
	 {
		waitForElementToBeClickable(importsSubTab, longWait);
		Click(importsSubTab);
		waitForElementToBeClickable(leftPanel, longWait);		
	 }
	
	
	public void createEntity(String EntityName,String EntityPageName,List<String> Str)
	 {	
		waitForElementToBeClickable(importsSubTab, longWait);
		Click(importsSubTab);
		waitForElementToBeClickable(leftPanel, longWait);
		DeleteEntityIfPresent(EntityName, EntityPageName);
		By DesirableEntity = By.xpath("//label[@class='view-column-title' and text()='"+EntityName+"']");	
		waitForElementToBeClickable(DesirableEntity, longWait);
		Click(DesirableEntity);
		waitForElementToBeClickable(nameFieldOnCreateEntityPage, longWait);
		setText(nameFieldOnCreateEntityPage, EntityPageName, longWait);
		if(Str!=null)
		{
		for (String qtr :Str )
		  {		
			//Click(AddFieldDropDown);
			waitTillTextPresent(qtr, longWait);
			selectByCompleteVisibleText(AddFieldDropDown, qtr);
			TestUtils.sleep(2);
			//Click(AddBttnForDropDown);
			clickAndWait(AddBttnForDropDown, shortWait);
			TestUtils.sleep(2);	
		  }
		}
		 Click(saveBttn);
		 waitTillTextPresent("View was saved successfully.", longWait);
		 waitForElementToBeClickable(leftPanel, longWait);
		 Assert.assertTrue(VerifyEntityPageAfterAdding(EntityName, EntityPageName), "Not found Entity Page");
	 }
	
	
	public void DeleteEntityIfPresent(String EntityName,String EntityPageName)
	{
		List<WebElement> el=driver.get().findElements(By.xpath("//label[text()='"+EntityName+"']//parent::div//following-sibling::div[1][@class='individualTemplates']//div[@class='importTitleDiv']"));
		
		int size=el.size();
		loop:
		for(int i=1;i<=size;i++)
		{			
			WebElement DesiredElement=driver.get().findElement(By.xpath("//label[text()='"+EntityName+"']//parent::div//following-sibling::div//label[text()='"+EntityPageName+"']"));
			if(DesiredElement.getText().equals(EntityPageName))
			{
				System.out.println("entity page found and now deleting");
				By deleteButton=By.xpath("//label[text()='"+EntityName+"']//parent::div//following-sibling::div//label[text()='"+EntityPageName+"']//parent::div//following-sibling::div[@class='viewIcon deleteIcon']");
				javascriptButtonClick(deleteButton);
				By el1=By.xpath("//div[@class='filter-data view-delete-ground']//input");
				waitForElementToBeClickable(el1, longWait);
				clickAndWait(el1, longWait);
				waitTillTextPresent("View was deleted successfully.", longWait);
				break loop;		
			}	
		}	
	}
	
	
	public boolean VerifyEntityPageAfterAdding(String EntityName,String EntityPageName)
	{
		boolean status=false;
		
     List<WebElement> el=driver.get().findElements(By.xpath("//label[text()='"+EntityName+"']//parent::div//following-sibling::div[1][@class='individualTemplates']//div[@class='importTitleDiv']"));
		
		int size=el.size();
		loop:
		for(int i=1;i<=size;i++)
		{
			WebElement DesiredElement=driver.get().findElement(By.xpath("//label[text()='"+EntityName+"']//parent::div//following-sibling::div//label[text()='"+EntityPageName+"']"));
			if(DesiredElement.getText().equals(EntityPageName))
			{System.out.println("found the entity page");
				status=true;
				break loop;		
			}		
		}		
		return status;
	}
	
	
	public void ExecuteEntity(String EntityName,String EntityPageName,String filepath)
	 {
		List<WebElement> el=driver.get().findElements(By.xpath("//label[text()='"+EntityName+"']//parent::div//following-sibling::div[1][@class='individualTemplates']//div[@class='importTitleDiv']"));
		
		int size=el.size();
		loop:
		for(int i=1;i<=size;i++)
		 {		
			WebElement DesiredElement=driver.get().findElement(By.xpath("//label[text()='"+EntityName+"']//parent::div//following-sibling::div//label[text()='"+EntityPageName+"']"));
			if(DesiredElement.getText().equals(EntityPageName))
			 {
				By editButton=By.xpath("//label[text()='"+EntityPageName+"']");
				clickAndWait(editButton, longWait);
				break loop;		
			 }
		 }
		
		By uploadButton=By.xpath("//input[@id='SessionId2']//following-sibling::input[1]");
		waitForElementToBeClickable(uploadButton, longWait);
		uploadFile(uploadButton, filepath, longWait);
		
		TestUtils.sleep(5);
		By ImportBttn=By.xpath("//input[@id='btnStartUpload']");
		clickAndWait(ImportBttn, longWait);
		SoftAssert sa = new SoftAssert(); 
		sa.assertTrue(isTextPresentOnPage(""), "error found,csv file not uploaded ");
	 }	
	
	public boolean verifySuccessMsg()
	{
		//waitForElementToBecomeInvisible(successMsg, longWait);
		waitTillTextPresent("Import completed" , longWait);
		
		 boolean status = false;
	   	  if(isTextPresentOnPage("Import completed"));
	 	       {
	 	    	status = true;
	 	       }	 
	   	TestUtils.sleep(6);
	 	    Log.info("Success message was appear after import of a csv file");
	 	    return status;	
	 	    
	}
	
	
	public void clickOnImportsTab()
	{
		waitForElementToBeClickable(importsSubTab, longWait);
		Click(importsSubTab);
		waitForElementToBeClickable(leftPanel, longWait);		
	}
	
	
}