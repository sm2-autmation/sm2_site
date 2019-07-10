package com.eaf.qa.cloudops.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.eaf.qa.base.BasePage;
import com.eaf.qa.utils.DataUtils;
import com.eaf.qa.utils.TestUtils;

public class CreateTasksPage extends BasePage{
	
	public CreateTasksPage(ThreadLocal<WebDriver> driver) {
		super(driver);
		
		this.driver = driver;
		Log.info("Initializing login Page Objects");
		PageFactory.initElements(driver.get(), taskSubTab);
	}
	
	private static Logger Log = LogManager.getLogger(LoginPage.class.getName());

	private By taskSubTab = By.xpath("//span[contains(text(),'Tasks')]");
	
	private By addTaskIcon = By.xpath("//li[@title='Tasks']//a[@href='javascript:void(0)']//div[@class='page_item page_item_add']");
	
	private By codeField = By.xpath("//input[@id='TANO']");
	
	private By descriptionField = By.xpath("//input[@id='TADE']");
	
	private By maintenancetab = By.xpath("//div[@id='headerMenu_head-item-maintenance']");
	
	private By listOfTask = By.xpath("//div[@title='List of tasks and their description']/div/span");
	
	private By filterIconUnderListOftask = By.xpath("//div[@id='view-action-filter']");
	
	private By codeFilter = By.xpath("//div[contains(text(),'Code')]");
	
	private By starFilterIcon = By.xpath("//input[@id='TANO-r2']/preceding-sibling::label[@title='Contains']/span");
	
	private By starFilterIconField = By.xpath("//div[@class='filter-column-title selectedFilter']/following-sibling::div[2]/input");
	
	private By filterIcon= By.xpath("//div[@class='buttonHeader']//div[@class='RefreshIcon ViewIcons']");
	
	private By saveBttn= By.xpath("//button[@id='btnTopSave']");
	
	
	public void clickOnMaintenanceTab()
	{	
		waitForElementToBeClickable(maintenancetab, longWait);
		clickAndWait(maintenancetab, shortWait);	
	}

	public void clickOnTasksSubTab()
	{
		waitForElementToBeClickable(taskSubTab, longWait);
		clickAndWait(taskSubTab, shortWait);
		System.out.println("ye -------------------------------------------> chala task wala");	
	}
	
	public void verifyTaskCodeAndCreateTask()
	{	
		for(int i = 1;DataUtils.getTestData("TaskCode", "Code", "code"+i)!=null;i++)
		{
			System.out.println("ye -------------------------------------------> chala");
			F1(DataUtils.getTestData("TaskCode", "Code", "code"+i),i);		
		}
	}

	public void F1(String code,int i)
	{ 
		System.out.println("----------------------------------->"+DataUtils.getTestData("TaskCode", "Code", "code"+i));
		waitForElementToBeClickable(listOfTask, longWait);
		clickAndWait(listOfTask, shortWait);
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
		setText(starFilterIconField, code, shortWait);
		clickAndWait(filterIcon, longWait);
		TestUtils.sleep(5);
		if((isTextPresentOnPage(code)))
		{
			System.out.println("Task is already created");
			return;	
		}
		else {
			System.out.println("Task is not available in the list.. Creating Now.....");
			clickOnAddTaskIcon();
			waitForElementToBeClickable(codeField, shortWait);
			setData(DataUtils.getTestData("TaskCode", "Code", "code"+i),
					DataUtils.getTestData("TaskCode", "Desc", "Desc"+i));
			clickAndWait(saveBttn, shortWait);			
		}
	}

	public void clickOnAddTaskIcon()
	{
		waitForElementToBeClickable(addTaskIcon, longWait);
		clickAndWait(addTaskIcon, longWait);
		Log.info("click on add task icon");	
	}
	
	public void addTask(String code, String Desc)
	{
			
	}
	
	public void setData(String code, String Desc)
	{ 
		waitForElementToBeClickable(codeField, longWait);
		setText(codeField, code, shortWait);
		setText(descriptionField, Desc, shortWait);
		Log.info("Value from sheet is Pass");
	}
}