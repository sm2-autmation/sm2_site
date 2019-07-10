package com.eaf.qa.cloudops.pages;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.eaf.qa.base.BasePage;

public class StorageLocationPage extends BasePage {

	public StorageLocationPage(ThreadLocal<WebDriver> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	By PartsAndTradesSubTab=By.xpath("//li[@title='Parts and Trades']");
	
	By StorageLocationTab=By.xpath("//a//span[text()='Storage Locations']");
	
	By ViewBar=By.xpath("//ul[@id='sortableList']");
	
	By AddStorageLocationIcon =By.xpath("//a//span[text()='Storage Locations']//following-sibling::div");
	
	By StorageLocationField=By.xpath("//input[@id='STNO']");
	
	By StorageLocationDescField=By.xpath("//input[@id='STDE']");
	
	By SaveBttn=By.xpath("//button[@id='btnTopSave']");
	
	private By SaveBttnforView = By.id("saveBtn");
	

	
	public void ClickOnStorageLocationTab()
	{
		waitForElementToBeClickable(StorageLocationTab, longWait);
		clickAndWait(StorageLocationTab, longWait);
		waitForElementToBeClickable(ViewBar, longWait);
	}
	
	public void ClickOnPartsAndTradeSubTab()
	{
		waitForElementToBeClickable(PartsAndTradesSubTab, longWait);
		clickAndWait(PartsAndTradesSubTab, longWait);
		waitForElementToBeClickable(StorageLocationTab, longWait);
		
	}
	
	
	public void AddAndVerifyStorageLocationAfterCreating(String StorageLocationNumber,String StorageLocationDesc)
	{
		
		DeleteStorageLocationIfAlreadyPresent(StorageLocationNumber);
		clickAndWait(AddStorageLocationIcon, longWait);
		waitForElementToBeClickable(StorageLocationField, longWait);
		setText(StorageLocationField, StorageLocationNumber, longWait);
		setText(StorageLocationDescField, StorageLocationDesc, longWait);
		waitForElementToBeClickable(SaveBttn, longWait);
		clickAndWait(SaveBttn, longWait);
		Assert.assertTrue(verifyStorageLocationAfterCreating(StorageLocationNumber), "Storage location not created");
		
	}
	
	
	public void EditAndVerifyAfterEditingStorageLocation(String StorageLocationNumber,String UpdatedStorageLocationNumber,String UpdatedStorageLocationDesc)
	{
		getBasicControllersPage().ClickOnRefreshButtonOfDesiredView("Storage Locations List");
		
		DeleteStorageLocationIfAlreadyPresent(UpdatedStorageLocationNumber);
		
		ClickOnEditButtonOfdesiredLocation(StorageLocationNumber);
		
		if(UpdatedStorageLocationNumber!=null)
		{
			
			
			setText(StorageLocationField, UpdatedStorageLocationNumber, longWait);
			
			
		}
		
		
		if(UpdatedStorageLocationDesc!=null)
		{
			setText(StorageLocationDescField, UpdatedStorageLocationDesc, longWait);
			
			
		}
		waitForElementToBeClickable(SaveBttn, longWait);
		clickAndWait(SaveBttn, longWait);
		waitTillTextPresent("Successfully updated 1 records.", longWait);
		Assert.assertTrue(verifyStorageLocationAfterCreating(UpdatedStorageLocationNumber), "Storage location notr created");
		
		
		
		
		
	}
	
	
	
	public void editViewAndAddSubView(String NameOfView, String NameOfEntityToBeAdded, String NameOfSubViewToBeAdded,List<String>List1) throws AWTException
	{
		getBasicControllersPage().ClickOnEditIconButtonOfDesiredView(NameOfView);
		getBasicControllersPage().AddEntityandSubViewView(NameOfEntityToBeAdded, NameOfSubViewToBeAdded);
		getBasicControllersPage().addparametrs(null, List1, null);
		javascriptButtonClick(SaveBttnforView);
		waitTillTextPresent("View was saved successfully.", longWait);
		
	}
	
	
	
	
	
	
	
	
	
	
	public boolean verifyStorageLocationAfterCreating(String StorageLocationNumber)
	{
		System.out.println(StorageLocationNumber+"--------StorageLocationAfterCreating");
		boolean status=false;
		By actionButton1=By.xpath("//tbody[@role='rowgroup']//tr[1]//td[1]");
		waitForElementToBeClickable(actionButton1, longWait);
		getBasicControllersPage().clickOnDesiredView("Storage Locations List");
		getBasicControllersPage().ClickOnRefreshButtonOfDesiredView("Storage Locations List");
		List<WebElement> code=driver.get().findElements(By.xpath("//tbody[@role='rowgroup']//tr"));
		int size=code.size();
		loop:
		for(int i=1;i<=size;i++)
		{
			WebElement el=driver.get().findElement(By.xpath("//tbody[@role='rowgroup']//tr["+i+"]//td[3]//text"));
			el.click();
			System.out.println("verification after creation start here------------------------>"+el.getText()+"------------->"+i);
			if(el.getText().equals(StorageLocationNumber))
			{
				status=true;
				break loop;
				
			}
			
			
			}
		
		return status;
		
		
	}
	
	
	
	
	public void ClickOnEditButtonOfdesiredLocation(String NameOfStorageLocation)
	{
		System.out.println("Desired name--------->>>>>>"+NameOfStorageLocation);
		

		By actionButton1=By.xpath("//tbody[@role='rowgroup']//tr[1]//td[1]");
		getBasicControllersPage().ClickOnRefreshButtonOfDesiredView("Storage Locations List");
		waitForElementToBeClickable(actionButton1, longWait);
		
		List<WebElement> code=driver.get().findElements(By.xpath("//tbody[@role='rowgroup']//tr"));
		int size=code.size();
		loop:
		for(int i=1;i<=size;i++)
		{
			WebElement el=driver.get().findElement(By.xpath("//tbody[@role='rowgroup']//tr["+i+"]//td[3]//text"));
			
			System.out.println("verification to edit start here------------------------>"+el.getText()+"------------->"+i);
			if(el.getText().equals(NameOfStorageLocation))
			{
				System.out.println("<------------------------in if------------------------------------->");
				
				By actionButton=By.xpath("//tbody[@role='rowgroup']//tr["+i+"]//td[1]");
				By deleteButtonBox=By.xpath("//div[@role='tooltip']");
				By EditButton=By.xpath("//div[@role='tooltip']//div[text()='Edit']");
				//Click(actionButton);
				clickAndWait(actionButton, minimalWait);
				waitForElementToBeClickable(deleteButtonBox, minimalWait);
				waitForElementToBeClickable(EditButton, minimalWait);
				Click(EditButton);
				
				waitForElementToBeClickable(StorageLocationField, longWait);
				break loop;
		
			}
		}
	
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void DeleteStorageLocationIfAlreadyPresent(String NameOfStorageLocation)
	{
		

		System.out.println("Desired name--------->>>>>>"+NameOfStorageLocation);
		By actionButton1=By.xpath("//tbody[@role='rowgroup']//tr[1]//td[1]");
		getBasicControllersPage().ClickOnRefreshButtonOfDesiredView("Storage Locations List");
		waitForElementToBeClickable(actionButton1, longWait);
		
		List<WebElement> code=driver.get().findElements(By.xpath("//tbody[@role='rowgroup']//tr"));
		int size=code.size();
		loop:
		for(int i=1;i<=size;i++)
		{
			WebElement el=driver.get().findElement(By.xpath("//tbody[@role='rowgroup']//tr["+i+"]//td[3]//text"));
			
			System.out.println("verification to delete start here------------------------>"+el.getText()+"------------->"+i);
			if(el.getText().equals(NameOfStorageLocation))
			{
				System.out.println("<------------------------in if------------------------------------->");
				
				By actionButton=By.xpath("//tbody[@role='rowgroup']//tr["+i+"]//td[1]");
				By deleteButtonBox=By.xpath("//div[@role='tooltip']");
				By deleteButton=By.xpath("//div[@role='tooltip']//div[text()='Delete']");
				//Click(actionButton);
				clickAndWait(actionButton, minimalWait);
				waitForElementToBeClickable(deleteButtonBox, minimalWait);
				waitForElementToBeClickable(deleteButton, minimalWait);
				Click(deleteButton);
				handleAlert();
		
				getBasicControllersPage().ClickOnRefreshButtonOfDesiredView("Storage Locations List");
				waitForElementToBeClickable(actionButton1, longWait);
				break loop;
		
			}
		
		
		
		}
		
		
		
	}

}
