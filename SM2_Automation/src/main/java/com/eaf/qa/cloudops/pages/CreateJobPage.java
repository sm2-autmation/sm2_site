package com.eaf.qa.cloudops.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.eaf.qa.base.BasePage;
import com.eaf.qa.utils.DataUtils;
import com.eaf.qa.utils.TestUtils;

public class CreateJobPage extends BasePage {

	public CreateJobPage(ThreadLocal<WebDriver> driver) {
		super(driver);
	}
	
	private By jobsTab = By.xpath("//span[@class='page_item_text'][contains(text(),'Jobs')]");
	
	//private By addJobsTab = By.xpath("//span[@class='page_item_text'][contains(text(),'Jobs')]/following-sibling::div");
	
	private By listOfJobs = By.xpath("//div[@class='view-column-title']//span[contains(text(),'Jobs / job parts')]");
	
	private By filterIconUnderListOftask = By.xpath("//div[@id='view-action-filter']");
	
	private By codeFilter = By.xpath("//div[contains(text(),'Name')]");
	
	private By starFilterIcon = By.xpath("//label[@title='Contains']//span[@class='ui-button-text'][contains(text(),'*')]");
	
	private By starFilterIconField = By.xpath("//div[@class='filter-column-title selectedFilter']/following-sibling::div[2]/input");
	
	private By filterIcon= By.xpath("//div[@class='buttonHeader']//div[@class='RefreshIcon ViewIcons']");
	
	private By addJobIcon= By.xpath("//span[@class='page_item_text'][contains(text(),'Jobs')]/following-sibling::div");
	
	private By nameField= By.xpath("//input[@id='RTDE']");
	
	private By addTaskGroupBttn= By.xpath("//td[@id='tdFieldRTAG']/input");
	
	private By addTaskGroupNameField= By.xpath("//input[@id='RTGN']");
	
	private By addTaskBttn= By.xpath("//input[@id='RTAT']");
	
	private By saveBttn= By.xpath("//*[@id='btnTopSave']");
	
	private By taskCodeField= By.xpath("//input[@class='form-control TANO k-input']");
	
	
	
	
	public void clickOnJobsSubTab()
	{
		waitForElementToBeClickable(jobsTab, longWait);
		clickAndWait(jobsTab, longWait);
		
	}
	
	public void clickOnListOfJobs()
	{
		waitForElementToBeClickable(listOfJobs, longWait);
		clickAndWait(listOfJobs, longWait);
			
	}
	
	public void verifyJobCodeAndCreateJob()
	{
		for(int i = 1;DataUtils.getTestData("TaskCode", "Name", "Name"+i)!=null;i++)
		{
			F1(DataUtils.getTestData("TaskCode", "Name", "Name"+i),i);	
		}	
	}

	public void F1(String Name, int i)
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
		setText(starFilterIconField, Name, shortWait);
		clickAndWait(filterIcon, longWait);
		TestUtils.sleep(5);
		if((isTextPresentOnPage(Name)))
		{
			System.out.println("Task is already created");
			return;
	
		}
		else {
			System.out.println("Task is not available in the list.. Creating Now.....");
			clickOnAddJobIcon();
			waitForElementToBeClickable(nameField, shortWait);
			setData(DataUtils.getTestData("TaskCode", "Name", "Name"+i));
			setDataForGroupName(Name);
			addTaskGroup(DataUtils.getTestData("TaskCode", "Taskname", "Taskname"+i));
			clickAndWait(saveBttn, longWait);
		}		
	}

	private void clickOnAddJobIcon() 
	{
		waitForElementToBeClickable(addJobIcon, longWait);
		clickAndWait(addJobIcon, longWait);
	}
	
	public void setData(String Name)
	{ 
		waitForElementToBeClickable(nameField, longWait);
		setText(nameField, Name, shortWait);
	}
	
	public void setDataForGroupName(String Name)
	{ 
		setText(nameField, Name, shortWait);
		
	}
	
	public void addTaskGroup(String Name)
	{ 
		for(int i=1;i>0;i--)
		{
			Click(addTaskGroupBttn);
		//clickAndWait(addTaskGroupBttn, longWait);
		//clickAndWait(addTaskGroupNameField, shortWait);
			pressEnter();
		TestUtils.sleep(5);
		setText(addTaskGroupNameField, DataUtils.getTestData("TaskCode", "GroupName", "GroupName"+i), shortWait);
		
		
		for(int j=1;j>0;j--)
		{
		    Click(addTaskBttn);
		    pressEnter();
		}
		
			//clickAndWait(taskCodeField, longWait);
		//int count=getElementsIfPresent(taskCodeField).size();
		
		List<WebElement> cc= getElementsIfPresent(taskCodeField);
	
		int count=cc.size();
		int k=count-1;
		for (WebElement myElement : cc)
		{
		
			//setText(taskCodeField, DataUtils.getTestData("TaskCode", "Code", "code"+i), shortWait);
			
		myElement.sendKeys(DataUtils.getTestData("TaskCode", "Code", "code"+(count-k)));
			k--;
		}		
			//setText(taskCodeField, DataUtils.getTestData("TaskCode", "Code", "code"+i), shortWait);
		}	
	}
}