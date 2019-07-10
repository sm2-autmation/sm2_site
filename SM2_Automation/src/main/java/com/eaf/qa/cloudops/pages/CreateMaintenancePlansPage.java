package com.eaf.qa.cloudops.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eaf.qa.base.BasePage;
import com.eaf.qa.utils.DataUtils;
import com.eaf.qa.utils.TestUtils;

public class CreateMaintenancePlansPage extends BasePage{

	public CreateMaintenancePlansPage(ThreadLocal<WebDriver> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	private By maintenancePlansTab = By.xpath("//span[contains(text(),'Maintenance Plans')]");
	
	private By listOfMaintenancePlans = By.xpath("//div[@class='view-column-title']//span[contains(text(),'Default Maintenance Plans')]");
	
	private By filterIconUnderListOftask = By.xpath("//div[@id='view-action-filter']");
	
	private By codeFilter = By.xpath("//div[contains(text(),'Name')]");
	
	private By starFilterIcon = By.xpath("//label[@title='Contains']//span[@class='ui-button-text'][contains(text(),'*')]");
	
	private By starFilterIconField = By.xpath("//div[@class='filter-column-title selectedFilter']/following-sibling::div[2]/input");
	
	private By filterIcon= By.xpath("//div[@class='buttonHeader']//div[@class='RefreshIcon ViewIcons']");
	
	private By addMaintenancePlansIcon= By.xpath("//span[@class='page_item_text'][contains(text(),'Maintenance Plans')]/following-sibling::div");
	
	private By nameField= By.xpath("//input[@id='PLDE']");
	
	private By addBttn= By.xpath("//select[@id='PMGT']//following-sibling::input");
	
	private By selectTriggerConfigurationDropDown = By.id("PMGT");
	
	private By selectJobArrow = By.xpath("//div[@class='dblBtnDiv']//input[1]");
	
	private By saveBttn = By.xpath("//button[@id='btnTopSave']");
	
	
	
	public void clickOnJobsSubTab()
	{
		waitForElementToBeClickable(maintenancePlansTab, longWait);
		clickAndWait(maintenancePlansTab, longWait);
		
	}
		
	public void clickOnListOfMaintenancePlans()
	{
		waitForElementToBeClickable(listOfMaintenancePlans, longWait);
		clickAndWait(listOfMaintenancePlans, longWait);
			
	}
	
	public void verifyJobCodeAndCreateJob()
	{
		for(int i = 1;DataUtils.getTestData("TaskCode", "Maintenance Plans Name", "Maintenance Plans Name"+i)!=null;i++)
		{
		
			F1(DataUtils.getTestData("TaskCode", "Maintenance Plans Name", "Maintenance Plans Name"+i),i);
				
		}	
	}

	public void F1(String maintenancePlansName,int i)
	{
		waitForElementToBeClickable(filterIconUnderListOftask, longWait);
		clickAndWait(filterIconUnderListOftask, shortWait);
		waitForElementToBeClickable(codeFilter, longWait);
		if(i>1)
		{
			clickAndWait(codeFilter, shortWait);
			
		}
		clickAndWait(codeFilter, shortWait);
		
		waitForElementToBeClickable(starFilterIcon, longWait);
		clickAndWait(starFilterIcon, shortWait);
		setText(starFilterIconField, maintenancePlansName, shortWait);
		clickAndWait(filterIcon, longWait);
		TestUtils.sleep(5);
		if((isTextPresentOnPage(maintenancePlansName)))
		{
			System.out.println("Task is already created");
			return;	
		}
		
		else {
			System.out.println("Task is not available in the list.. Creating Now.....");
			clickOnAddMaintenancePlans();
			waitForElementToBeClickable(nameField, shortWait);
			System.out.println("----------------------------------------------------->"+DataUtils.getTestData("TaskCode", "Maintenance Plans Name", "Maintenance Plans Name"+i));
			setData(DataUtils.getTestData("TaskCode", "Maintenance Plans Name", "Maintenance Plans Name"+i));
			selectTriggerConfiguration(DataUtils.getTestData("TaskCode", "selectTriggerConfigurationDropDownvalue", "selectTriggerConfigurationDropDownvalue"+i));
		
			clickOnAddBttn();
			selectjobs();
			clickAndWait(saveBttn, longWait);		
	         }
	}
	
	public void clickOnAddMaintenancePlans()
	{
		
		waitForElementToBeClickable(addMaintenancePlansIcon, longWait);
		clickAndWait(addMaintenancePlansIcon, longWait);
		
	}
	
	public void setData(String maintenancePlansName)
	{ 
		waitForElementToBeClickable(nameField, longWait);
		setText(nameField, maintenancePlansName, shortWait);
		
	}
	
	public void selectTriggerConfiguration(String Name)
	{
		selectByCompleteVisibleText(selectTriggerConfigurationDropDown, Name);
	
	}
		
	public By getXpathOfTriggerConfigurationValueField(int i)
	{
		return By.xpath("//li["+i+"]//span[2]//span[1]//input[1]");
		
	}
	
	public void clickOnAddBttn()
	{
		for(int k=1;k>0;k--)
		{
			//clickAndWait(addBttn, longWait);
			Click(addBttn);
			//pressEnter();
			
			setText(getXpathOfTriggerConfigurationValueField(k), DataUtils.getTestData("TaskCode", "TriggerConfigurationValue", "TriggerConfigurationValue"+k), longWait);		
		}
	}
	
	public void selectjobs()
	{
		for(int k=2;k>0;k--)
		{
		clickAndWait(By.xpath("//select[@name='availableList']//option[@value='"+k+"']"), longWait);
		TestUtils.sleep(2);
		clickAndWait(selectJobArrow, longWait);	
		}
		
	}

	public void clickOnMaintenancePlansTab()
	{
		waitForElementToBeClickable(maintenancePlansTab, longWait);
		clickAndWait(maintenancePlansTab, longWait);
		
	}
	
	
}
