package com.eaf.qa.cloudops.pages;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.eaf.qa.base.BasePage;
import com.eaf.qa.utils.TestUtils;

public class SuppliersPage extends BasePage {

	public SuppliersPage(ThreadLocal<WebDriver> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	By supplierTab = By.xpath("//span[text()='Suppliers']");

	By AddSupplierIcon = By.xpath("//span[text()='Suppliers']//following-sibling::div");

	By ViewBar = By.xpath("//ul[@id='sortableList']");

	By saveBttn = By.xpath("//button[@id='btnTopSave']");
	
	By AddcontactsButton=By.xpath("//input[@id='SPAC']");
	
	private By ViewSaveBttn = By.id("saveBtn");	
	

	public void ClickOnSupplierTab() {

		waitForElementToBeClickable(supplierTab, longWait);
		clickAndWait(supplierTab, longWait);

		waitForElementToBeClickable(ViewBar, longWait);

	}

	public void AddSupplierAndVerifyAfterAdding(String SupplierNumber, String DescField,String Phone,String Address) 
	{
		DeleteSupplierIfAlreadyPresent(SupplierNumber);
		By numberfield = By.xpath("//input[@id='SPNO']");
		By descField = By.xpath("//input[@id='SPDE']");
		waitForElementToBeClickable(AddSupplierIcon, longWait);
		clickAndWait(AddSupplierIcon, longWait);
		waitForElementToBeClickable(numberfield, longWait);
		

		setText(numberfield, SupplierNumber, longWait);
		setText(descField, DescField, longWait);
		if(Phone!=null)
		{
			By phonefield=By.xpath("//input[@id='SPPH']");
			
			
			
		}
		
		if(Address!=null)
		{
			By Addressfield1=By.xpath("//input[@id='SPA1']");
			
			setText(Addressfield1, Address, longWait);
			
		}

		waitForElementToBeClickable(saveBttn, longWait);
		clickAndWait(saveBttn, longWait);
		Assert.assertTrue(verifySupplierLocationAfterCreating(SupplierNumber), "supplier not created");

	}

	public void DeleteSupplierIfAlreadyPresent(String NameOfSupplier)
	{
		int j=1;
		System.out.println("Desired name--------->>>>>>" + NameOfSupplier);
		By actionButton1 = By.xpath("//tbody[@role='rowgroup']//tr[1]//td[1]");
		getBasicControllersPage().ClickOnRefreshButtonOfDesiredView("Suppliers list");
		Outerloop: 
		while (j > 0) 
		{
			
		waitForElementToBeClickable(actionButton1, longWait);

		List<WebElement> code = driver.get().findElements(By.xpath("//tbody[@role='rowgroup']//tr"));
		int size = code.size();
		loop: for (int i = 1; i <= size; i++) 
		{
			WebElement el = driver.get().findElement(By.xpath("//tbody[@role='rowgroup']//tr[" + i + "]//td[3]//text"));

			el.click();
			System.out.println(
					"verification to delete start here------------------------>" + el.getText() + "------------->" + i);
			if (el.getText().equals(NameOfSupplier)) {
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

				getBasicControllersPage().ClickOnRefreshButtonOfDesiredView("Suppliers list");
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

	public boolean verifySupplierLocationAfterCreating(String NameOfSupplier) 
	{
		int j = 1;
		System.out.println(NameOfSupplier + "--------StorageLocationAfterCreating");
		boolean status = false;
		By actionButton1 = By.xpath("//tbody[@role='rowgroup']//tr[1]//td[1]");
		waitForElementToBeClickable(actionButton1, longWait);
		getBasicControllersPage().clickOnDesiredView("Suppliers list");
		getBasicControllersPage().ClickOnRefreshButtonOfDesiredView("Suppliers list");
		loop:
		while (j>0) 
		{
			waitForElementToBeClickable(actionButton1, longWait);
			
			List<WebElement> code = driver.get().findElements(By.xpath("//tbody[@role='rowgroup']//tr"));
			int size = code.size();
			 
				for (int i = 1; i <= size; i++) {
				WebElement el = driver.get()
						.findElement(By.xpath("//tbody[@role='rowgroup']//tr[" + i + "]//td[3]//text"));
				TestUtils.sleep(1);
				el.click();
				System.out.println("verification after creation start here------------------------>" + el.getText());
						
				if (el.getText().equals(NameOfSupplier)) {
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

	
	
	public boolean verifySupplierNumberAfterCreating(String NameOfSupplier) 
	{
		int j = 0;
		System.out.println(NameOfSupplier + "--------StorageLocationAfterCreating");
		boolean status = false;
		By actionButton1 = By.xpath("//tbody[@role='rowgroup']//tr[1]//td[1]");
		waitForElementToBeClickable(actionButton1, longWait);
		//getBasicControllersPage().clickOnDesiredView("Suppliers list");
		getBasicControllersPage().ClickOnRefreshButtonOfDesiredView("Suppliers list");
		loop:
		while (j == 0) 
		{
			waitForElementToBeClickable(actionButton1, longWait);
			List<WebElement> code = driver.get().findElements(By.xpath("//tbody[@role='rowgroup']//tr"));
			int size = code.size();
			 
				for (int i = 1; i <= size; i++) {
				WebElement el = driver.get().findElement(By.xpath("//tbody[@role='rowgroup']//tr[" + i + "]//td[3]//text"));
				el.click();
				System.out.println("verification after creation start here------------------------>" + getAttributeValue(By.xpath("//a[@title='Go to the next page']"), "class")
						+ "------------->" + i);
				if (el.getText().equals(NameOfSupplier)) {
					status = true;
					break loop;

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

	
	
	public void EditTheSupplier(String SupplierNumber,String DescField )
	{
		ClickOnEditButtonOfdesiredSupplier(SupplierNumber);
		
		By descField = By.xpath("//input[@id='SPDE']");
		
		setText(descField, DescField, longWait);
		
		waitForElementToBeClickable(saveBttn, longWait);
		clickAndWait(saveBttn, longWait);
		Assert.assertTrue(verifySupplierLocationAfterCreating(SupplierNumber), "supplier not created");

		
	}
	
	
	
	
	public void ClickOnEditButtonOfdesiredSupplier(String NameOfSupplier)
	{
		int j = 1;
		System.out.println("Desired name--------->>>>>>"+NameOfSupplier);
		

		By actionButton1=By.xpath("//tbody[@role='rowgroup']//tr[1]//td[1]");
		getBasicControllersPage().ClickOnRefreshButtonOfDesiredView("List of All Suppliers");
		while(j>0)
		{
	
		waitForElementToBeClickable(actionButton1, longWait);
		
		List<WebElement> code=driver.get().findElements(By.xpath("//tbody[@role='rowgroup']//tr"));
		int size=code.size();
		loop:
		for(int i=1;i<=size;i++)
		{
			WebElement el=driver.get().findElement(By.xpath("//tbody[@role='rowgroup']//tr["+i+"]//td[3]//text"));
			
			System.out.println("verification to edit start here------------------------>"+el.getText()+"------------->"+i);
			if(el.getText().equals(NameOfSupplier))
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
				
				waitForElementToBeClickable(AddcontactsButton, longWait);
				break loop;
		
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
		

	
	
	
	}
	
	public void ClickOnDeleteButtonOfdesiredSupplier(String NameOfSupplier)
	{    int j=1;
		System.out.println("Desired name--------->>>>>>"+NameOfSupplier);
		

		
		By actionButton1=By.xpath("//tbody[@role='rowgroup']//tr[1]//td[1]");
		
		
		getBasicControllersPage().ClickOnRefreshButtonOfDesiredView("List of All Suppliers");
		loop:
		while(j>0)
		{
	
		waitForElementToBeClickable(actionButton1, longWait);
		
		List<WebElement> code=driver.get().findElements(By.xpath("//tbody[@role='rowgroup']//tr"));
		int size=code.size();
		
		for(int i=1;i<=size;i++)
		{
			WebElement el=driver.get().findElement(By.xpath("//tbody[@role='rowgroup']//tr["+i+"]//td[3]//text"));
			
			System.out.println("verification to edit start here------------------------>"+el.getText()+"------------->"+i);
			if(el.getText().equals(NameOfSupplier))
			{
				System.out.println("<------------------------in if------------------------------------->");
				
				By actionButton=By.xpath("//tbody[@role='rowgroup']//tr["+i+"]//td[1]");
				By deleteButtonBox=By.xpath("//div[@role='tooltip']");
				By DeleteButton=By.xpath("//div[@role='tooltip']//div[text()='Delete']");
				//Click(actionButton);
				clickAndWait(actionButton, minimalWait);
				waitForElementToBeClickable(deleteButtonBox, minimalWait);
				waitForElementToBeClickable(DeleteButton, minimalWait);
				Click(DeleteButton);
				handleAlert();
				break loop;
		
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
	
	
	
	}
	
	
	public void AddcontactTc_4d(String NameOfSupplier)
	{
		ClickOnEditButtonOfdesiredSupplier(NameOfSupplier);
		verifyAndDeleteIfContactIsAlreadyPresent();
		By addcontactButton=By.xpath("//input[@id='SPAC']");
		clickAndWait(addcontactButton, longWait);
	
		By field1=By.xpath("//div[@id='groupBody_SPCL']//table//tbody//tr//td[2]//input");
		By field2=By.xpath("//div[@id='groupBody_SPCL']//table//tbody//tr//td[4]//input");
		By field3=By.xpath("//div[@id='groupBody_SPCL']//table//tbody//tr//td[6]//input");
		
		waitForElementToBeClickable(field1, longWait);
		setText(field1, "Frank Debaggio", longWait);
		setText(field2, "(438) 233-5522", longWait);
		setText(field3, "fdebag@energizer.ca", longWait);
		
		clickAndWait(saveBttn, longWait);
		waitTillTextPresent("Successfully updated 1 records.", longWait);
		
		
		
		
	}
	
	
	
	
	public void verifyAndDeleteIfContactIsAlreadyPresent()
	{
		System.out.println("in deleting a contact");
		
		TestUtils.sleep(3);
		
		if(getElementIfVisibleUsingXpath(By.xpath("//div[@id='groupBody_SPCL']//table//tbody//tr"), longWait))
		{
			
			clickAndWait(By.xpath("//td[@id='tdFieldCODC']//input"), longWait);
			
			
		}
		
		
		
	}
	
	
	
	
	
	
	
	public void AddfilterInAView(String NameOfView,List<String> list3 ) throws AWTException
	{
		
		getBasicControllersPage().ClickOnEditIconButtonOfDesiredView(NameOfView);
		getBasicControllersPage().addparametrs(null, list3, null);
		javascriptButtonClick(ViewSaveBttn);
		waitTillTextPresent("View was saved successfully.", longWait);
		Assert.assertTrue(getBasicControllersPage().verifyViewAfterCreation(NameOfView), "Created View, not found");
	
		getBasicControllersPage().ClickOnSetFilterButtonOfDesiredView(NameOfView);
		getBasicControllersPage().AddFilterFromView(list3.get(0), "Equal To","ON");
		Assert.assertTrue(verifyFilterEffect(NameOfView,"ON"), "filter effect is not seen");
					
	}
	
	public void Addfilter2InAView(String NameOfView,List<String> list3 ) throws AWTException
	{
		
		getBasicControllersPage().ClickOnEditIconButtonOfDesiredView(NameOfView);
		getBasicControllersPage().addparametrs(null, list3, null);
		javascriptButtonClick(ViewSaveBttn);
		waitTillTextPresent("View was saved successfully.", longWait);
		Assert.assertTrue(getBasicControllersPage().verifyViewAfterCreation(NameOfView), "Created View, not found");
	
		getBasicControllersPage().ClickOnSetFilterButtonOfDesiredView(NameOfView);
		getBasicControllersPage().AddFilterFromView(list3.get(0), "Contains","WA");
		Assert.assertTrue(verifyFilterEffect1(NameOfView,"WA"), "filter effect is not seen");
					
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public boolean verifyFilterEffect(String NameOfView,String NameToBVerified)
	{
		boolean status=false;
		 int j=1;
			//System.out.println("Desired name--------->>>>>>"+NameOfSupplier);
			

			
			By actionButton1=By.xpath("//tbody[@role='rowgroup']//tr[1]//td[1]");
			loop:
			while(j>0)
			{
			getBasicControllersPage().ClickOnRefreshButtonOfDesiredView("List of All Suppliers");
			waitForElementToBeClickable(actionButton1, longWait);
			
			List<WebElement> code=driver.get().findElements(By.xpath("//tbody[@role='rowgroup']//tr"));
			int size=code.size();
			
			for(int i=1;i<=size;i++)
			{
				WebElement el=driver.get().findElement(By.xpath("//tbody[@role='rowgroup']//tr["+i+"]//td[9]//text"));
				
				System.out.println("verification to edit start here------------------------>"+el.getText()+"------------->"+i);
				if(el.getText().equals(NameToBVerified))
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
	
	
	



public boolean verifyFilterEffect1(String NameOfView,String NameToBVerified)
{
	boolean status=false;
	 int j=1;
		//System.out.println("Desired name--------->>>>>>"+NameOfSupplier);
		

		
		By actionButton1=By.xpath("//tbody[@role='rowgroup']//tr[1]//td[1]");
		loop:
		while(j>0)
		{
		getBasicControllersPage().ClickOnRefreshButtonOfDesiredView("List of All Suppliers");
		waitForElementToBeClickable(actionButton1, longWait);
		
		List<WebElement> code=driver.get().findElements(By.xpath("//tbody[@role='rowgroup']//tr"));
		int size=code.size();
		
		for(int i=1;i<=size;i++)
		{
			WebElement el=driver.get().findElement(By.xpath("//tbody[@role='rowgroup']//tr["+i+"]//td[8]//text"));
			
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



