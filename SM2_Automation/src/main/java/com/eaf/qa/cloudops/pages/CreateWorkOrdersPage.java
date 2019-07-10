package com.eaf.qa.cloudops.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eaf.qa.base.BasePage;
import com.eaf.qa.utils.DataUtils;
import com.eaf.qa.utils.TestUtils;

public class CreateWorkOrdersPage extends BasePage {
	private static Logger Log = LogManager.getLogger(CreateUsersPage.class.getName());

	public CreateWorkOrdersPage(ThreadLocal<WebDriver> driver) {
		super(driver);
		
	}

	private By maintenanceTab = By.xpath("//div[@id='headerMenu_head-item-maintenance']");

	private By workOrdersSubTab = By.xpath("//span[contains(text(),'Work Orders')]");

	private By plusIconOfWorkOrders = By.xpath("//span[@class='page_item_text']//following-sibling::div");

	private By eqNumberTextField = By.xpath("//div[@id='hrzGrpHrzGrpEquip']//span//input[1]");
	
	private By requestedByTextField = By.xpath("//input[@id='WORB']");
	
	private By saveBttn = By.xpath("//button[@id='btnTopSave']");
	
	
	

	public void clickOnMaintenanceTab() {
		clickAndWait(maintenanceTab, longWait);
		Log.info("Maintenance tab clicked");
	}

	public void clickOnWorkOrders() {
		clickAndWait(workOrdersSubTab, longWait);
		Log.info("Work Orders sub tab clicked");
	}

	public void clickOnPlusIconOfWorkOrders() {
		javascriptButtonClick(plusIconOfWorkOrders);
		// Click(plusIconOfWorkOrders);
		// TestUtils.sleep(5);
		// clickAndWait(plusIconOfWorkOrders, longWait);
		Log.info("Plus icon of Work Orders was clicked");
		TestUtils.sleep(5);
	}

	  public void createWorkOrders() 
	  {
		  for(int i =  1; DataUtils.getTestData1("CreateVehicle", "Eq. Number", "Option"+i)!=null;i++)
	      { 
		  F1(DataUtils.getTestData1("CreateVehicle", "Eq. Number", "Option"+i),i);
		  }
	  }

	private void F1(String Name, int i) 
	  {
		waitForElementToBeClickable(eqNumberTextField, longWait);
		setText(eqNumberTextField, Name, longWait);
	
	    if((isTextPresentOnPage(Name)))
	     {
		  System.out.println("Eq. Number is already in the list");
		  return;	
	     }
	    else {
		  System.out.println("User ID is not available in the list.. Creating Now.....");
		  //clickOnPlusIconToAddUser();
		  waitForElementToBeClickable(eqNumberTextField, shortWait);
		             
		  // Eq. Number from CreateVehicle sheet
		  setDataForEqNumberTextField(DataUtils.getTestData1("CreateVehicle", "Eq. Number", "Option" +i));
		  Log.info("Eq. Number was entered");
		           
		  // User from CreateUserID sheet
		  setDataForRequestedByTextField(DataUtils.getTestData1("CreateUserID", "User ID", "Option"+i));
		  Log.info("User ID was entered");
		  
		  clickAndWait(saveBttn, longWait);	
		  Log.info("Save Button was clicked"); 
	         }	
	  }
	
	public void setDataForEqNumberTextField(String Name)
    {
    	waitForElementToBeClickable(eqNumberTextField, longWait);
		setText(eqNumberTextField, Name, shortWait);	
    }
	
	public void setDataForRequestedByTextField(String Name)
    {
    	waitForElementToBeClickable(requestedByTextField, longWait);
		setText(requestedByTextField, Name, shortWait);	
    }
	
	
}