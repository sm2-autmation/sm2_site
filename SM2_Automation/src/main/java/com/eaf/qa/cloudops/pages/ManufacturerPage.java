package com.eaf.qa.cloudops.pages;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.eaf.qa.base.BasePage;
import com.eaf.qa.utils.TestUtils;

public class ManufacturerPage extends BasePage{

	public ManufacturerPage(ThreadLocal<WebDriver> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	By ManufacturerTab=By.xpath("//span[text()='Manufacturers']");
	
	By AddManufacturerIcon=By.xpath("//span[text()='Manufacturers']//following-sibling::div");
	
	By sidePanel=By.xpath("//ul[@id='sortableList']");
	
	private By ViewSaveBttn = By.id("saveBtn");
	
	By SaveBttn=By.xpath("//button[@id='btnTopSave']");
	
	public void clickOnManufacturerTab()
	{
		
		waitForElementToBeClickable(ManufacturerTab, longWait);
		clickAndWait(ManufacturerTab, longWait);
		waitForElementToBeClickable(sidePanel, longWait);
	}
	
	
	
	public void AddManufacturerAndVerifyAfterAdding(String ManufacturerNumber, String DescField,String Phone) 
	{
		DeleteManufacturerIfAlreadyPresent(ManufacturerNumber);
		By ManufacurerNumber=By.xpath("//input[@id='MANO']");
		By ManufacurerName=By.xpath("//input[@id='MADE']");
		By phoneNumber=By.xpath("//input[@id='SPPH']");
		waitForElementToBeClickable(AddManufacturerIcon, longWait);
		clickAndWait(AddManufacturerIcon, longWait);
		setText(ManufacurerNumber, ManufacturerNumber, longWait);
		setText(ManufacurerName, DescField, longWait);
		if(Phone!=null)
		{
			setText(phoneNumber, Phone, longWait);
			
			
			
		}
		
		waitForElementToBeClickable(SaveBttn, longWait);
		clickAndWait(SaveBttn, longWait);
		
		Assert.assertTrue(verifyManufacturerLocationAfterCreating(ManufacturerNumber), "Manufacturer not created");

		
		
	}
	
	public void EditManufacturer(String ManufacturerNumber,String Phone)
	{
		ClickOnEditButtonOfdesiredSupplier(ManufacturerNumber);
		By phoneNumber=By.xpath("//input[@id='SPPH']");
		
		setText(phoneNumber, Phone, longWait);
		
		waitForElementToBeClickable(SaveBttn, longWait);
		clickAndWait(SaveBttn, longWait);
		
		Assert.assertTrue(verifyManufacturerLocationAfterCreating(ManufacturerNumber), "manufacturer not created");

		
	}
	
	public void ClickOnEditButtonOfdesiredSupplier(String NameOfManufacturer)
	{
		System.out.println("Desired name--------->>>>>>"+NameOfManufacturer);
		

		By actionButton1=By.xpath("//tbody[@role='rowgroup']//tr[1]//td[1]");
		getBasicControllersPage().ClickOnRefreshButtonOfDesiredView("Default Manufacterer List");
		waitForElementToBeClickable(actionButton1, longWait);
		
		List<WebElement> code=driver.get().findElements(By.xpath("//tbody[@role='rowgroup']//tr"));
		int size=code.size();
		loop:
		for(int i=1;i<=size;i++)
		{
			WebElement el=driver.get().findElement(By.xpath("//tbody[@role='rowgroup']//tr["+i+"]//td[4]//text"));
			
			System.out.println("verification to edit start here------------------------>"+el.getText()+"------------->"+i);
			if(el.getText().equals(NameOfManufacturer))
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
				By ManufacurerNumber=By.xpath("//input[@id='MANO']");
				
				waitForElementToBeClickable(ManufacurerNumber, longWait);
				break loop;
		
			}
			
		}
		
	
	
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void DeleteManufacturerIfAlreadyPresent(String NameOfManufacturer)
	{
		int j=1;
		System.out.println("Desired name--------->>>>>>" + NameOfManufacturer);
		By actionButton1 = By.xpath("//tbody[@role='rowgroup']//tr[1]//td[1]");
		getBasicControllersPage().ClickOnRefreshButtonOfDesiredView("Default Manufacterer List");
		Outerloop: 
		while (j > 0) 
		{
			
		waitForElementToBeClickable(actionButton1, longWait);

		List<WebElement> code = driver.get().findElements(By.xpath("//tbody[@role='rowgroup']//tr"));
		int size = code.size();
		loop: for (int i = 1; i <= size; i++) 
		{
			WebElement el = driver.get().findElement(By.xpath("//tbody[@role='rowgroup']//tr[" + i + "]//td[4]//text"));

			el.click();
			System.out.println(
					"verification to delete start here------------------------>" + el.getText() + "------------->" + i);
			if (el.getText().equals(NameOfManufacturer)) {
				System.out.println("<------------------------in if------------------------------------->");

				By actionButton = By.xpath("//tbody[@role='rowgroup']//tr[" + i + "]//td[1]");
				By deleteButtonBox = By.xpath("//div[@role='tooltip']");
				By deleteButton = By.xpath("//div[@role='tooltip']//div[text()='Delete']");
				// Click(actionButton);
				clickAndWait(actionButton, minimalWait);
				waitForElementToBeClickable(deleteButtonBox, minimalWait);
				waitForElementToBeClickable(deleteButton, minimalWait);
				Click(deleteButton);
				handleAlert();

				getBasicControllersPage().ClickOnRefreshButtonOfDesiredView("Default Manufacterer List");
				waitForElementToBeClickable(actionButton1, longWait);
				break Outerloop;

			}

		}if (getAttributeValue(By.xpath("//a[@title='Go to the next page']"), "class").contains("disabled"))
		{

			System.out.println("---------------here is ur thing in if"+getAttribute(By.xpath("//a[@title='Go to the next page']"), "class"));
			j = 0;

		}
		else 
		{
			System.out.println("---------------here is ur thing in else"+getAttributeValue(By.xpath("//a[@title='Go to the next page']"), "class"));
			j++;
			clickAndWait(By.xpath("//a[@title='Go to the next page']//span"), longWait);

			
		}

		}
	}

	
	
	
	public boolean verifyManufacturerLocationAfterCreating(String NameOfManufacturer) 
	{
		int j = 1;
		System.out.println(NameOfManufacturer + "--------ManufacturerAfterCreating");
		boolean status = false;
		By actionButton1 = By.xpath("//tbody[@role='rowgroup']//tr[1]//td[1]");
		waitForElementToBeClickable(actionButton1, longWait);
		getBasicControllersPage().ClickOnRefreshButtonOfDesiredView("Default Manufacterer List");
		loop:
		while (j>0) 
		{
			waitForElementToBeClickable(actionButton1, longWait);
			
			List<WebElement> code = driver.get().findElements(By.xpath("//tbody[@role='rowgroup']//tr"));
			int size = code.size();
			 
				for (int i = 1; i <= size; i++) {
				WebElement el = driver.get()
						.findElement(By.xpath("//tbody[@role='rowgroup']//tr[" + i + "]//td[4]//text"));
				
				el.click();
				System.out.println("verification after creation start here------------------------>" + el.getText());
						
				if (el.getText().equals(NameOfManufacturer)) {
					status = true;
					return status;

				}
			}
			if (getAttributeValue(By.xpath("//a[@title='Go to the next page']"), "class").contains("disabled"))
			{

				System.out.println("---------------here is ur thing"+getAttribute(By.xpath("//a[@title='Go to the next page']"), "class"));
				j = 0;

			}
			else 
			{
				System.out.println("---------------here is ur thing in else"+getAttributeValue(By.xpath("//a[@title='Go to the next page']"), "class"));
				
				clickAndWait(By.xpath("//a[@title='Go to the next page']//span"), longWait);

				j++;
			}
		}
		return status;

	}

	
	public void Addfilter2InAView(String NameOfView,List<String> list3 ) throws AWTException
	{
		
		getBasicControllersPage().ClickOnEditIconButtonOfDesiredView(NameOfView);
		getBasicControllersPage().addparametrs(null, list3, null);
		javascriptButtonClick(ViewSaveBttn);
		waitTillTextPresent("View was saved successfully.", longWait);
		Assert.assertTrue(getBasicControllersPage().verifyViewAfterCreation(NameOfView), "Created View, not found");
	
		getBasicControllersPage().ClickOnSetFilterButtonOfDesiredView(NameOfView);
		getBasicControllersPage().AddFilterFromView(list3.get(0), "Contains","Q");
		Assert.assertTrue(verifyFilterEffect1(NameOfView,"Q"), "filter effect is not seen");
					
	}
	
	
	
	
	public boolean verifyFilterEffect1(String NameOfView,String NameToBVerified)
	{
		boolean status=false;
		 int j=1;
			//System.out.println("Desired name--------->>>>>>"+NameOfSupplier);
			

			
			By actionButton1=By.xpath("//tbody[@role='rowgroup']//tr[1]//td[1]");
			loop:
			while(j>0)
			{
			getBasicControllersPage().ClickOnRefreshButtonOfDesiredView(NameOfView);
			waitForElementToBeClickable(actionButton1, longWait);
			
			List<WebElement> code=driver.get().findElements(By.xpath("//tbody[@role='rowgroup']//tr"));
			int size=code.size();
			
			for(int i=1;i<=size;i++)
			{
				WebElement el=driver.get().findElement(By.xpath("//tbody[@role='rowgroup']//tr["+i+"]//td[11]//text"));
				
				System.out.println("verification to edit start here------------------------>"+el.getText()+"------------->"+i);
				if(el.getText().contains(NameToBVerified))
				{
					status=true;
					return status;
			
				}
			}
			
			if (getAttributeValue(By.xpath("//a[@title='Go to the next page']"), "class").contains("disabled"))
			{

				System.out.println("---------------here is ur thing"+getAttribute(By.xpath("//a[@title='Go to the next page']"), "class"));
				j = 0;

			}
			else 
			{
				System.out.println("---------------here is ur thing in else"+getAttributeValue(By.xpath("//a[@title='Go to the next page']"), "class"));
				
				clickAndWait(By.xpath("//a[@title='Go to the next page']//span"), longWait);

				j++;
			}

			
			
			
			}
		
		
		return status;
		
	}



	}


	
	
	
	
	
	
	
	
