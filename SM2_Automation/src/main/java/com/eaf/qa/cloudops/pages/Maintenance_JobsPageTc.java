package com.eaf.qa.cloudops.pages;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.eaf.qa.base.BasePage;

public class Maintenance_JobsPageTc extends BasePage{

	public Maintenance_JobsPageTc(ThreadLocal<WebDriver> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	private By editIconUnderView = By.xpath("//div[@id='view-action-edit']");
	
	private By viewNameField = By.xpath("//input[@id='view-name']");	
	
	private By SaveBttn = By.id("saveBtn");	

	 public void TC001CreateAView() throws AWTException
	 {
		 List<String> list1 = new ArrayList<String>();
			list1.add("Name");
			list1.add("Work Type Desc.");
			list1.add("Work Type");
			list1.add("Type");
			
			List<String> list2 = new ArrayList<String>();
			list2.add("Part Description");
			list2.add("Part Est. Qty");
			
			List<String> list3 = new ArrayList<String>();
			list3.add("Assembly Code");
			list3.add("Description");
		
			
			getBasicControllersPage().CreateAView("Jobs List Test", list1, null, null, null, null);
			
	 }

	 
	 public void EditViewAndAddEntityAndSubViewTc_006(String NameOfTheView,String NameOfEntityToBeAdded,String NameOfSubViewToBeAdded)
	 {
			By temp = By.xpath("//ul[@id='sortableList']//li//div//div//span[(text()='"+NameOfTheView+"')]");
			
			
			waitForElementToBeClickable(temp, longWait);
			Click(temp);
			waitForElementToBeClickable(editIconUnderView, shortWait);
			Click(editIconUnderView);
			waitForElementToBeClickable(viewNameField, longWait);
			getBasicControllersPage().AddEntityandSubViewView(NameOfEntityToBeAdded, NameOfSubViewToBeAdded);
			
		 javascriptButtonClick(SaveBttn);
		 waitTillTextPresent("View was saved successfully.", longWait);
		 Assert.assertTrue(getBasicControllersPage().verifyViewAfterCreation(NameOfTheView), "Created View, not found");
		 
	 }
	 
	 public void AddTheFilterName(String NameOfTheView,String FilterBy,String FilterByOption,String FilterByValue)
	 {
		 
		 
		 
		 
		 
		 
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 public void EditTheView_Tc_003(String NameOfView,String tabName,String ParameterName,String AggregateParameterName)
	 {
		 getBasicControllersPage().ClickOnEditIconButtonOfDesiredView(NameOfView);
		 AddparametersAndAggregate(tabName, ParameterName, AggregateParameterName);
		 javascriptButtonClick(SaveBttn);
		 waitTillTextPresent("View was saved successfully.", longWait);
		Assert.assertTrue(getBasicControllersPage().verifyViewAfterCreation(NameOfView), "Created View, not found");
		 
		 
		 
	 }
	 
	 
	 
	 
	 public void AddparametersAndAggregate(String tabName,String ParameterName,String AggregateParameterName)
	 {
		 
		 By TabName=By.xpath("//a[@id='tab2']");
		 
		 By temp = By.xpath("//select[@id='viewColumns']//option[contains(text(),'"+ParameterName+"')]");
		 
		 By aggDropDown=By.xpath("//div[@id='view-ground2']/div[@id='itemOption' and text() = 'Aggregate']/select[1]");
		 
		 By aggParameter=By.xpath("//select//option[text()='"+AggregateParameterName+"']");
		 
		 
		 
		 waitForElementToBeClickable(TabName, longWait);
		 
		 clickAndWait(TabName, longWait);
			

		 waitForElementToBeClickable(temp, longWait);
		 
		 clickAndWait(temp, longWait);
		
         //waitForElementToBeClickable(aggDropDown, longWait);
		 
		 clickAndWait(aggDropDown, longWait);
		
		 
          waitForElementToBeClickable(aggParameter, longWait);
		 
		 clickAndWait(aggParameter, longWait);
		
		 
		 
		 
		 
		 
		 
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	
	public void EditViewAndAddparameters(String NameOfTheView,String updatedNameOfTheView,List<String> listOfDispalyedParameters,List<String> listOfFilteredParameters,List<String> listOfSortByParameters) throws AWTException
	{
       By temp = By.xpath("//ul[@id='sortableList']//li//div//div//span[(text()='"+NameOfTheView+"')]");
		
		
		waitForElementToBeClickable(temp, longWait);
		Click(temp);
		waitForElementToBeClickable(editIconUnderView, shortWait);
		Click(editIconUnderView);
		waitForElementToBeClickable(viewNameField, longWait);
		
		if(!(updatedNameOfTheView==null))
		{
			setText(viewNameField, updatedNameOfTheView, longWait);
		}
		
		
		getBasicControllersPage().addparametrs(listOfDispalyedParameters, listOfFilteredParameters, listOfSortByParameters);
		
		javascriptButtonClick(SaveBttn);
		
		waitTillTextPresent("View was saved successfully.", longWait);
		Assert.assertTrue(getBasicControllersPage().verifyViewAfterCreation(NameOfTheView), "Created View, not found");
	
		Assert.assertTrue(getBasicControllersPage().VerifyEachColumn(listOfDispalyedParameters), "columns are not present");
		
	}
	
	
	
	
}
