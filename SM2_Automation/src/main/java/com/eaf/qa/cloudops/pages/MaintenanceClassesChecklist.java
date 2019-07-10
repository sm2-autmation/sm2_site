package com.eaf.qa.cloudops.pages;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.eaf.qa.base.BasePage;
import com.eaf.qa.utils.DataUtils;
import com.eaf.qa.utils.TestUtils;

public class MaintenanceClassesChecklist extends BasePage {

	public MaintenanceClassesChecklist(ThreadLocal<WebDriver> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	public void Test_001CloneAViewByCreatingNewView(String NameOfView, String NameOfNewView)
	{
		
		getBasicControllersPage().cloneView(NameOfView,NameOfNewView);
			
	}
	
	
	public void Test_002HideAView()
	{
		getBasicControllersPage().hideView("Default Maint Class View");
	
	}
	
	public void Test_003CloneTheCreatedViewToOtherView(String NameOfView, String NameOfNewView )
	{
		
		getBasicControllersPage().cloneView(NameOfView,NameOfNewView);
		
	}
	
	public void Test_004EditView(String viewName) throws AWTException
	{
		List<String> list1 = new ArrayList<String>();
		list1.add("Equipment Desc.");
		list1.add("Equipment Number");
		
		getBasicControllersPage().ClickOnEditIconButtonOfDesiredView(viewName);
		By nameText = By.xpath("//input[@id='view-name']") ;
		waitForElementToBeClickable(nameText, longWait);
		getBasicControllersPage().addparametrs(list1, null, null);
		By saveButton = By.xpath("//input[@id='saveBtn']");
		javascriptButtonClick(saveButton);
		TestUtils.sleep(5);
		
		//Verify if the columns are added
		
	}
		
	public void ReEdit(String viewName) throws AWTException
	{
		List<String> list1 = new ArrayList<String>();
		list1.add("Equipment Desc.");
		list1.add("Equipment Number");
		
		By nameText = By.xpath("//input[@id='view-name']") ;
		
		By saveButton = By.xpath("//input[@id='saveBtn']");
		
		
		getBasicControllersPage().ClickOnEditIconButtonOfDesiredView(viewName);
		waitForElementToBeClickable(saveButton, minimalWait);
		getBasicControllersPage().DeSelectDisplayparameters(list1);
		javascriptButtonClick(saveButton);
		
	}
	
	
	public void Test_005CreateAMaintenanceClass()
	{
		getBasicControllersPage().clickOnDesiredView("Default Maint Class View");
		TestUtils.sleep(5);
		
		addMaintenanceClasses(DataUtils.getTestData("MaintenanceClasses", "Class Code", "Class Code2"), DataUtils.getTestData("MaintenanceClasses", "Description", "Description2"));
		
	}
	
	public void Test_006EditTheAboveClass()
	{
		
		
		getBasicControllersPage().ClickOnRefreshButtonOfDesiredView("Default Maint Class View");
		By actionButton=By.xpath("//tbody[@role='rowgroup']//tr[1]//td[1]");
		System.out.println("helllllllllloooooooooooooooooooooooooooooooooooooooooooooooo");
		waitForElementToBeClickable(actionButton, longWait);
		EditMaintenanceClass(DataUtils.getTestData("MaintenanceClasses", "Class Code", "Class Code2"), DataUtils.getTestData("MaintenanceClasses", "Description", "Description3"));
		
		
	}
	
	public void Test_007DeleteTheAboveClass()
	{
		
		
		
		DeleteMaintenanceClass(DataUtils.getTestData("MaintenanceClasses", "Class Code", "Class Code2"));
		
		
	}
	
	
	public void Test_008CreateAMaintenanceClass()
	{
		
		
		addMaintenanceClasses(DataUtils.getTestData("MaintenanceClasses", "Class Code", "Class Code3"), DataUtils.getTestData("MaintenanceClasses", "Description", "Description3"));
		
		
		
	}
	
	
	public void VerifyAndDeleteViewIfPresent(String NameOFView)
	{
		
		List<WebElement> sortableList =driver.get().findElements(By.xpath("//ul[@id='sortableList']//li"));
		int size=sortableList.size();
	
		for(int i=1;i<=size;i++)
		{
			 By temp1 = By.xpath("//ul[@id='sortableList']//li["+i+"]//div//div//span");
			 System.out.println("------------------------>>>>>>>>>>>>>>>>>>>>>>"+getText(temp1));
				if(getText(temp1).equals(NameOFView))
				{
					getBasicControllersPage().deleteView(NameOFView);
					break;
					
				}
			
			
			
		}
		
		
		
		
		
		
	}
	
	
	
	public boolean verifyColumns(String ColumnName1,String ColumnName2)
	{
		By column1=By.xpath("//div[@id='grid']//table[@role='grid']//tr[1]//th[text()='"+ColumnName1+"']");
		
		By column2=By.xpath("//div[@id='grid']//table[@role='grid']//tr[1]//th[text()='"+ColumnName2+"']");
		
		
		boolean status=false;
		if(getElementIfVisibleUsingXpath(column1, longWait) && getElementIfVisibleUsingXpath(column2, longWait))
		{
			
			
			status=true;
			
			
		}
		
		return status;
		
	}
	
	
	
	
	public void maintainFlow()
	{
		getBasicControllersPage().clickOnDesiredView("Default Maint Class View");
		TestUtils.sleep(5);
		if(VerifyMaintenanceClasses(DataUtils.getTestData("MaintenanceClasses", "Class Code", "Class Code1"),DataUtils.getTestData("MaintenanceClasses", "Description", "Description1")))
		{
			
			return;
		}
		else
		{
			addMaintenanceClasses(DataUtils.getTestData("MaintenanceClasses", "Class Code", "Class Code1"),DataUtils.getTestData("MaintenanceClasses", "Description", "Description1"));
		}
	}
	
	public boolean VerifyMaintenanceClasses(String ClassCode,String Description)
	{
		boolean status=false;
		
		List<WebElement> code=driver.get().findElements(By.xpath("//tbody[@role='rowgroup']//tr"));
		int size=code.size();
		
		for(int i=1;i<=size;i++)
		{
			WebElement el=driver.get().findElement(By.xpath("//tbody[@role='rowgroup']//tr["+i+"]//td[3]//text"));
			System.out.println("------------------------>"+el.getText()+"------------->"+i);
			if(el.getText().equals(ClassCode))
			{
				
				By actionButton=By.xpath("//tbody[@role='rowgroup']//tr["+i+"]//td[1]");
				By deleteButtonBox=By.xpath("//div[@role='tooltip']");
				By deleteButton=By.xpath("//div[@role='tooltip']//div[text()='Delete']");
				//Click(actionButton);
				clickAndWait(actionButton, minimalWait);
				waitForElementToBeClickable(deleteButtonBox, minimalWait);
				waitForElementToBeClickable(deleteButton, minimalWait);
				Click(deleteButton);
				handleAlert();
				//addMaintenanceClasses(ClassCode, Description);
				status=true;
				return status;
			}
		
		}
		return status;
		
	}
	
	
	public void verifyMaintenanceClassesAndDeleteIfPresent(String ClassCode )
	{
		By actionButton1=By.xpath("//tbody[@role='rowgroup']//tr[1]//td[1]");
		waitForElementToBeClickable(actionButton1, longWait);
		List<WebElement> code=driver.get().findElements(By.xpath("//tbody[@role='rowgroup']//tr"));
		int size=code.size();
		
		for(int i=1;i<=size;i++)
		{
			WebElement el=driver.get().findElement(By.xpath("//tbody[@role='rowgroup']//tr["+i+"]//td[3]//text"));
			System.out.println("verification start here------------------------>"+el.getText()+"------------->"+i);
			if(el.getText().equals(ClassCode))
			{
				
				By actionButton=By.xpath("//tbody[@role='rowgroup']//tr["+i+"]//td[1]");
				By deleteButtonBox=By.xpath("//div[@role='tooltip']");
				By deleteButton=By.xpath("//div[@role='tooltip']//div[text()='Delete']");
				//Click(actionButton);
				clickAndWait(actionButton, minimalWait);
				waitForElementToBeClickable(deleteButtonBox, minimalWait);
				waitForElementToBeClickable(deleteButton, minimalWait);
				Click(deleteButton);
				handleAlert();
		
				getBasicControllersPage().ClickOnRefreshButtonOfDesiredView("Default Maint Class View");
				waitForElementToBeClickable(actionButton1, longWait);
				break;
		
			}
		
		
		
		}
		
		
	}
	
	
	
	public void addMaintenanceClasses(String ClassCode,String Description)
	{
		By addMaintenanceClassesIcon=By.xpath("//li[@title='Maintenance Classes']//div");
		By ClassCodeField=By.xpath("//input[@id='MCNOL']");
		By DescriptionField=By.xpath("//input[@id='MCDEL']");
		By SaveBttn=By.xpath("//button[@id='btnTopSave']");
		
		/*getBasicControllersPage().ClickOnRefreshButtonOfDesiredView("Default Maint Class View");
		By actionButton1=By.xpath("//tbody[@role='rowgroup']//tr[1]//td[1]");
		waitForElementToBeClickable(actionButton1, longWait);
		*/verifyMaintenanceClassesAndDeleteIfPresent(ClassCode );
		
		Click(addMaintenanceClassesIcon);
		waitForElementToBeClickable(addMaintenanceClassesIcon, minimalWait);
		
		waitForElementToBeClickable(ClassCodeField, minimalWait);
		setText(ClassCodeField, ClassCode, shortWait);
		setText(DescriptionField, Description, minimalWait);
		Click(SaveBttn);
		VerifyMaintenanceClassAfterCreation(ClassCode);
		
	}
	public void EditMaintenanceClass(String ClassCode,String Description)
	{
		getBasicControllersPage().clickOnDesiredView("Default Maint Class View");
		By actionButton1=By.xpath("//tbody[@role='rowgroup']//tr[1]//td[1]");
		waitForElementToBeClickable(actionButton1, longWait);
		List<WebElement> code=driver.get().findElements(By.xpath("//tbody[@role='rowgroup']//tr"));
		int size=code.size();
		
		for(int i=1;i<=size;i++)
		{
			WebElement el=driver.get().findElement(By.xpath("//tbody[@role='rowgroup']//tr["+i+"]//td[3]//text"));
			System.out.println("------------------------>"+el.getText()+"------------->"+i);
			if(el.getText().equals(ClassCode))
			{
				
				By actionButton=By.xpath("//tbody[@role='rowgroup']//tr["+i+"]//td[1]");
				By deleteButtonBox=By.xpath("//div[@role='tooltip']");
				By EditButton=By.xpath("//div[@role='tooltip']//div[text()='Edit']");
				//Click(actionButton);
				clickAndWait(actionButton, minimalWait);
				waitForElementToBeClickable(deleteButtonBox, minimalWait);
				waitForElementToBeClickable(EditButton, minimalWait);
				Click(EditButton);
		
		

				
				By DescriptionField=By.xpath("//input[@id='MCDEL']");
				By SaveBttn=By.xpath("//button[@id='btnTopSave']");
				
				
				waitForElementToBeClickable(DescriptionField, minimalWait);
				
				setText(DescriptionField, Description, minimalWait);
				Click(SaveBttn);
		
			}
			
		}
		
	}
	
	public void DeleteMaintenanceClass(String ClassCode)
	{
		getBasicControllersPage().clickOnDesiredView("Default Maint Class View");
		By actionButton1=By.xpath("//tbody[@role='rowgroup']//tr[1]//td[1]");
		waitForElementToBeClickable(actionButton1, longWait);
		List<WebElement> code=driver.get().findElements(By.xpath("//tbody[@role='rowgroup']//tr"));
		int size=code.size();
		for(int i=1;i<=size;i++)
		{
			WebElement el=driver.get().findElement(By.xpath("//tbody[@role='rowgroup']//tr["+i+"]//td[3]//text"));
			System.out.println("------------------------>"+el.getText()+"------------->"+i);
			if(el.getText().equals(ClassCode))
			{
				
				By actionButton=By.xpath("//tbody[@role='rowgroup']//tr["+i+"]//td[1]");
				By deleteButtonBox=By.xpath("//div[@role='tooltip']");
				By deleteButton=By.xpath("//div[@role='tooltip']//div[text()='Delete']");
				//Click(actionButton);
				clickAndWait(actionButton, minimalWait);
				waitForElementToBeClickable(deleteButtonBox, minimalWait);
				waitForElementToBeClickable(deleteButton, minimalWait);
				Click(deleteButton);
				handleAlert();
		
		
			}
		
		
		}
		
		
		
	}
	
	
	public void VerifyMaintenanceClassAfterCreation(String ClassCode)
	{
		By actionButton1=By.xpath("//tbody[@role='rowgroup']//tr[1]//td[1]");
		waitForElementToBeClickable(actionButton1, longWait);
		getBasicControllersPage().clickOnDesiredView("Default Maint Class View");
		List<WebElement> code=driver.get().findElements(By.xpath("//tbody[@role='rowgroup']//tr"));
		int size=code.size();
		
		for(int i=1;i<=size;i++)
		{
			WebElement el=driver.get().findElement(By.xpath("//tbody[@role='rowgroup']//tr["+i+"]//td[3]//text"));
			System.out.println("verification start here------------------------>"+el.getText()+"------------->"+i);
			if(el.getText().equals(ClassCode))
			{
				Assert.assertTrue(el.getText().equals(ClassCode), "classcode not created");
				break;
				
			}
			
			
			}
		
	}
	
	
	public void VerifySaveAndCancelButtonOnAddMaintenanceClassesPage()
	{
		By addMaintenanceClassesIcon=By.xpath("//li[@title='Maintenance Classes']//div");
		waitForElementToBeClickable(addMaintenanceClassesIcon, longWait);
		clickAndWait(addMaintenanceClassesIcon, longWait);
		

		By CancelBttn=By.xpath("//button[@id='btnTopCancel']");
		By SaveBttn=By.xpath("//button[@id='btnTopSave']");		
		
		waitForElementToBeClickable(CancelBttn, longWait);
		TestUtils.sleep(4);
		Assert.assertTrue(getElementIfVisibleUsingXpath(SaveBttn, longWait), "Save button is not present");
		Assert.assertTrue(getElementIfVisibleUsingXpath(CancelBttn, longWait), "Cancel button is not present");
		clickAndWait(CancelBttn, longWait);

		getBasicControllersPage().ClickOnRefreshButtonOfDesiredView("Default Maint Class View");
	}
	
	
	public void VerifyMaintenaceClassPage()
	{
		
		
		Assert.assertTrue(verifyPlusIcon(), "plus icon is not present");
		Assert.assertTrue(verifyClickFunctionalityOfPlusIcon(), "Click functionality of plus icon not working");
		Assert.assertTrue(verifyCancelButton(), "Cancel button is not present");
		Assert.assertTrue(verifySaveButton(), "Save button is not present");
		Assert.assertTrue(verifyClassCodeField(), "Class Code Field is not present");
		Assert.assertTrue(verifyDescriptionField(), "Description Field is not present");
		Assert.assertTrue(verifyFuncitionalityOfSaveButton(), "Save button is not working properly");
		Assert.assertTrue(verifyFuncitionalityOfCancelButton(), "Cancel button is not working properly");
		Assert.assertTrue(verifyErrormsgsOnMaintenanceClassesPage(), "Error msg on maintenance classes page not showing up");
		
		
	}
	
	
	
	
	public boolean verifyPlusIcon()
	{
		By addMaintenanceClassesIcon=By.xpath("//li[@title='Maintenance Classes']//div");
		waitForElementToBeClickable(addMaintenanceClassesIcon, longWait);
		
		
	boolean status=false;
	if(getElementIfVisibleUsingXpath(addMaintenanceClassesIcon, longWait))
	{
		status=true;
		
		
	}
		
		return status;
		
	}
	
	
	public boolean verifyClickFunctionalityOfPlusIcon()
	{ 
		boolean status=false;
		By CancelBttn=By.xpath("//button[@id='btnTopCancel']");
		
		By addMaintenanceClassesIcon=By.xpath("//li[@title='Maintenance Classes']//div");
		waitForElementToBeClickable(addMaintenanceClassesIcon, longWait);
		clickAndWait(addMaintenanceClassesIcon, longWait);
	     if(getElementIfVisibleUsingXpath(CancelBttn, shortWait))
	     {
	    
	    	 status=true;
	    	 
	    	 
	     }
		
		return status;
		
		
	}
	
	public boolean verifyCancelButton()
	{
		boolean status=false;
		By CancelBttn=By.xpath("//button[@id='btnTopCancel']");
		waitForElementToBeClickable(CancelBttn, longWait);
		
		if(getElementIfVisibleUsingXpath(CancelBttn, longWait))
		{
			status=true;
			
		}
		
		return status;
		
	}
	
	public boolean verifyFuncitionalityOfCancelButton()
	{
		
		By addMaintenanceClassesIcon=By.xpath("//li[@title='Maintenance Classes']//div");
		waitForElementToBeClickable(addMaintenanceClassesIcon, longWait);
		clickAndWait(addMaintenanceClassesIcon, longWait);
	     
		
		boolean status=false;
		By CancelBttn=By.xpath("//button[@id='btnTopCancel']");
		waitForElementToBeClickable(CancelBttn, longWait);
		clickAndWait(CancelBttn, longWait);
		By Help=By.xpath("//a[@class='secondMenu secondMenu-Right']");
		waitForElementToBeClickable(Help, longWait);
		if(getElementIfVisibleUsingXpath(Help, longWait))
		{
			
			status=true;
			
		}
		
		
		return status;
	}
	
	
	public boolean verifySaveButton()
	{
		boolean status=false;
		By SaveBttn=By.xpath("//button[@id='btnTopSave']");		
		
		waitForElementToBeClickable(SaveBttn, longWait);
		
		if(getElementIfVisibleUsingXpath(SaveBttn, longWait))
		{
			status=true;
			
		}
		
		return status;
		
	}
	
	public boolean verifyFuncitionalityOfSaveButton()
	{
		By addMaintenanceClassesIcon=By.xpath("//li[@title='Maintenance Classes']//div");
	    waitForElementToBeClickable(addMaintenanceClassesIcon, longWait);
	    clickAndWait(addMaintenanceClassesIcon, longWait);
		By ClassCodeField=By.xpath("//input[@id='MCNOL']");
		By DescriptionField=By.xpath("//input[@id='MCDEL']");
		boolean status=false;
		By SaveBttn=By.xpath("//button[@id='btnTopSave']");
		waitForElementToBeClickable(SaveBttn, longWait);
		setText(ClassCodeField, randomString(), longWait);
		setText(DescriptionField, randomString(), longWait);
		clickAndWait(SaveBttn, longWait);
		waitTillTextPresent("Successfully inserted records.", longWait);
		if((isTextPresentOnPage("Successfully inserted records.")))
		{
			
			status=true;
			
		}
		
		
		return status;
	}
	
	
	public boolean verifyClassCodeField()
	{
		boolean status=false;
		By ClassCodeField=By.xpath("//input[@id='MCNOL']");
		waitForElementToBeClickable(ClassCodeField, longWait);
		
		if(getElementIfVisibleUsingXpath(ClassCodeField, longWait))
		{
			status=true;
			
		}
		
		return status;
		
	}
	
	public boolean verifyDescriptionField()
	{
		By DescriptionField=By.xpath("//input[@id='MCDEL']");
		
		boolean status=false;
		By CancelBttn=By.xpath("//button[@id='btnTopCancel']");
		//waitForElementToBeClickable(CancelBttn, longWait);
		
		if(getElementIfVisibleUsingXpath(DescriptionField, longWait))
		{
			status=true;
			
		}
		
		return status;
		}
	
	public boolean verifyErrormsgsOnMaintenanceClassesPage()
	{
		
		By addMaintenanceClassesIcon=By.xpath("//li[@title='Maintenance Classes']//div");
	    waitForElementToBeClickable(addMaintenanceClassesIcon, longWait);
	    clickAndWait(addMaintenanceClassesIcon, longWait);
		boolean status=false;
		By SaveBttn=By.xpath("//button[@id='btnTopSave']");
		waitForElementToBeClickable(SaveBttn, longWait);
		clickAndWait(SaveBttn, longWait);
		waitTillTextPresent("The maintenance class code is mandatory", longWait);
		if(isTextPresentOnPage("The maintenance class code is mandatory")&& isTextPresentOnPage("The maintenance class description is mandatory"))
		{
			
			status=true;
			
		}
		
		return status;
		
		
	}
	
	
	
	
	
	
	

}
