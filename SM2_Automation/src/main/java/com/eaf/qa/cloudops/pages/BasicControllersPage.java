package com.eaf.qa.cloudops.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.eaf.qa.base.BasePage;
import com.eaf.qa.utils.DataUtils;
import com.eaf.qa.utils.TestUtils;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.eaf.qa.cloudops.pages.AddingJobs;
import com.eaf.qa.cloudops.pages.AddingJobs.Jobs;

public class BasicControllersPage extends BasePage {
	private static Logger Log = LogManager.getLogger(CreateVehiclePage.class.getName());

	public BasicControllersPage(ThreadLocal<WebDriver> driver) {
		super(driver);
	}

	private By createViewIcon = By.xpath("//span[@class='halflings-icon plus floatRight']");

	private By viewNameField = By.xpath("//input[@id='view-name']");

	private By SaveBttn = By.id("saveBtn");

	private By selectParameterBttn = By.xpath("//div[@id='view-ground2']//div[2]//input[1]");

	private By deSelectParameterBttn = By.xpath("//div[@id='view-ground2']//div[2]//input[2]");

	private By deSelectParameterBttn2 = By.xpath("//div[@id='view-ground3']//div[@class='btnHolder']//div//input[@id='removeFilter']");

	private By selectParameterBttn2 = By.xpath("//div[@id='view-ground3']//div[@class='btnHolder']//div[2]//input[1]");

	private By selectParameterBttn3 = By.xpath("//div[@id='view-ground5']//div[2]//input[1]");

	private By deSelectParameterBttn3 = By.xpath("//div[@id='view-ground5']//div[2]//input[2]");

	private By editIconUnderView = By.xpath("//div[@id='view-action-edit']");

	// Create new Maintenance view by "+" icon
	private By createNewViewIcon = By.xpath("//span[@class='halflings-icon plus floatRight']");

	// Name text field
	private By nameTextField = By.xpath("//input[@id='view-name']");

	// Description text field
	private By descriptionTextField = By.xpath("//input[@id='view-desc']");

	// Row Count text field
	private By rowCountTextField = By.xpath("//span[@class='k-widget k-numerictextbox viewRowCount']");

	// Entity drop down menu on Create View page
	private By EntityDropDownMenu = By.xpath("//select[@id='Entity']");

	// Sub-View drop down menu on Create View page
	private By subViewDropDown = By.xpath("//select[@id='Child']");

	// IsDefaultCheckBox
	private By IsDefaultCheckBox = By.id("IsDft");

	// Shared Check box
	private By SharedCheckBox = By.id("IsShd");

	// Available Parameters section
	private By availableParametersSection = By.xpath("//select[@id='all-columns']");

	// Selected Parameters section
	private By selectedParametersSection = By.xpath("//select[@id='viewColumns']");

	// Select arrow button
	private By selectArrowButton = By.xpath("//div[@id='view-ground2']//div[@class='btnHolder']//div//input[@value='>']");

	// DeSelect arrow button
	private By deSelectArrowButton = By.xpath("//div[@id='view-ground2']//div[@class='btnHolder']//div//input[@id='removeFilter']");

	// ReOrder Up arrow button
	private By reOrderUpArrowButton = By.xpath("//div[@id='view-ground2']//div[@class='btnHolder']//div[1]//input[1]");

	// Reorder down arrow button
	private By reOrderDownArrowButton = By.xpath("//div[@id='view-ground2']//div[@class='btnHolder']//div[1]//input[2]");

	// Display tab under Selected Parameters section
	private By displayTab = By.id("tab2");

	// Filtered by tab under Selected Parameters section
	private By filteredByTab = By.id("tab3");

	// Filtered by tab under Selected Parameters section
	private By sortByTab = By.id("tab5");

	// Export Options
	private By exportOptions = By.xpath("//label[@for='ExportExpandButton']");

	// Export Options page
	private By exportOptionsPage = By.xpath("//span[@class='form-title expandedTitle']");

	// Header check box
	private By headerCheckBox = By.id("ExpHeader");

	// Export File Type drop down menu
	private By fileType = By.xpath("//select[@id='ExpCsvFixed']");

	// Encoding drop down menu
	private By encodingDropDown = By.xpath("//select[@id='ExpEncoding']");

	// Separator text field
	private By separatorTextField = By.xpath("//input[@id='ExpSeparator']");

	// Delimiter text field
	private By delimiterTextField = By.xpath("//input[@id='ExpDelimitor']");

	// Field Format Text
	private By fieldFormatText = By.xpath("//p[@class='fieldTitle']");

	// Save button on Create View page
	private By saveButton = By.id("saveBtn");

	// Cancel Button on Create View page
	private By cancelButton = By.xpath("//input[@value='Cancel']");

	private By showBttn = By.xpath("//div[@class='filter-data view-show-ground']//input");
	
	// X-path for Aggregate drop down
	private By AggregateDropDown = By.xpath("//div[contains(text(),'Aggregate')]");
	
	// X-path for Aggregate drop down
	private By selectFromAggregateDropDown = By.xpath("//div[@id='view-ground2']//div[@id='itemOption']//select[1]");
		
	// Sub-view drop down on Create View page
    private By SubViewDropDrownMenu = By.id("Child");
    
    // Dashboard icon
    private By DashBoardIcon = By.xpath("//div[@id='view-action-dashboard']");
    
    // Display type drop down menu
    private By displayType = By.xpath("//select[@id='TYPE']");
    
    // 'None' drop down option in Display type
    private By displayTypeDropDownByDefault = By.xpath("//select[@id='TYPE']//option[1]");
    
    // 'View Result' drop down option in Display type
    private By displayTypeDropDownForViewResult = By.xpath("//select[@id='TYPE']//option[16]");
    
    private By dashboardSaveBttn = By.xpath("//input[@id='saveDash']");
    
    private By dashboardCancelBttn = By.xpath("//input[@id='cancelDash']");
    
    // Web Services icon
    private By webserviceIcon = By.xpath("//div[@id='view-action-webservice']");
    
    private By webServicesCancelBttn = By.xpath("//input[@id='cancelWs']");
    
    private By exportIcon = By.xpath("//div[@id='view-action-export']");
    
    private By editView = By.xpath("//div[@id='view-action-edit']");
    
    private By formSaveBttn = By.xpath("//input[@id='saveBtn']");
    
    private By hiddenViewNameToHover = By.xpath("//li[@class='hiddenView']");
    
    
    
    

	public void verifyDeleteIcon(String NameOfView) {
		By DeleteIcon = By.xpath("//div[@class='view-column-title']//span[contains(text(),'" + NameOfView + "')]//parent::div//following-sibling::div[@title='Clone']");
		isElementPresent(DeleteIcon);
	}
    
	
	public void deleteView(String NameOfView) 
	{
		clickOnDesiredView(NameOfView);

		By temp2 = By.xpath("//div[@class='view-column-title']//span[text()='" + NameOfView + "']//parent::div//following-sibling::div[@title='Delete']");
		waitForElementToBeClickable(temp2, shortWait);
		Click(temp2);

		By el3 = (By.xpath("//input[@id='view-action-delete']"));

		waitForElementToBeClickable(el3, shortWait);
		Click(el3);
	}

	
	public void clickOnDesiredView(String NameOfView) 
	{
		By viewName = By.xpath("//ul[@id='sortableList']//li//div//div//span[(text()='" + NameOfView + "')]");

		waitForElementToBeClickable(viewName, longWait);
		Click(viewName);
	}

	public void verifyHideViewIcon(String NameOfView) 
	{
		By HideIcon = By.xpath("//div[@class='view-column-title']//span[contains(text(),'" + NameOfView + "')]//parent::div//following-sibling::div[@title='Hide this view']");
		isElementPresent(HideIcon);
	}

	public void hideView(String NameOfView) 
	{
		clickOnDesiredView(NameOfView);

		By temp2 = By.xpath("//div[@class='view-column-title']//span[contains(text(),'" + NameOfView + "')]//parent::div//following-sibling::div[@title='Hide this view']");
		waitForElementToBeClickable(temp2, shortWait);
		Click(temp2);

		By el3 = By.xpath("//input[@id='view-action-delete']");

		waitForElementToBeClickable(el3, shortWait);

		Click(el3);
		TestUtils.sleep(4);
		HideIconOnViewLeftPanel();
		
	}

	public void HideIconOnViewLeftPanel() 
	{
		TestUtils.sleep(3);
		By ClosedEyeHideIcon = By.xpath("//div[text()='Views']/div");

		javascriptButtonClick(ClosedEyeHideIcon);
		TestUtils.sleep(2);
	}

	
	public void showView(String NameOfView) 
	{
		clickOnDesiredView(NameOfView);

		By temp2 = By.xpath("//div[@class='view-column-title']//span[contains(text(),'" + NameOfView + "')]//parent::div//following-sibling::div[@title='Hide this view']");
		waitForElementToBeClickable(temp2, shortWait);
		Click(temp2);

		By el3 = By.xpath("//input[@id='view-action-delete']");

		waitForElementToBeClickable(el3, shortWait);

		Click(el3);
		TestUtils.sleep(4);
	}
	
	
	public void clickOnHideiconOfHiddenView(String NameOfView) 
	{
		List<WebElement> mouserToHover = getElementsIfPresent(hiddenViewNameToHover);
		loop: for (WebElement el : mouserToHover) 
		{
			clickAndWait(hiddenViewNameToHover, shortWait);
			// javascriptButtonClick(el);
			
			clickOnDesiredView(NameOfView);
			By eyeIconOfHiddenView = By.xpath("//div[@class='view-column-title']//span[contains(text(),'" + NameOfView + "')]//parent::div//following-sibling::div[@title='Unhide view']");
					
			clickAndWait(eyeIconOfHiddenView, shortWait);
			// clickAndWait(eyeIconOfHiddenView, longWait);
			break loop;
		}
		TestUtils.sleep(4);
		System.out.println("Hide icon is clicked");

		TestUtils.sleep(3);
		clickAndWait(showBttn, longWait);
	}

	
	public void cloneAView(String NameOfView, String NameOfNewView) 
	{
		clickOnDesiredView(NameOfView);
		By temp2 = By.xpath("//div[@class='view-column-title']//span[contains(text(),'" + NameOfView + "')]//parent::div//following-sibling::div[@title='Clone']");
		waitForElementToBeClickable(temp2, shortWait);
		Click(temp2);
		FillAViewForm(NameOfNewView);
		TestUtils.sleep(4);
	}

	
	public void ClickOnEditIconButtonOfDesiredView(String NameOfView) 
	{
		clickOnDesiredView(NameOfView);
		By temp2= By.xpath("//div[@class='view-column-title']//span[text()='"+NameOfView+"']//parent::div[1]//parent::div[@class='filter-column-title filter-view current-view edit-view']//following-sibling::div[1]//div[@title='Edit View']");
		waitForElementToBeClickable(temp2, shortWait);
		Click(temp2);
	}
	

	public void ClickOnSetFilterButtonOfDesiredView(String NameOfView) 
	{
		clickOnDesiredView(NameOfView);
		By temp2 = By.xpath("//div[@class='view-column-title']//span[contains(text(),'" + NameOfView + "')]//parent::div[1]//parent::div[@class='filter-column-title filter-view current-view edit-view']//following-sibling::div[1]//div[@title='Set Filter']");
		waitForElementToBeClickable(temp2, shortWait);
		Click(temp2);
	}

	public void ClickOnRefreshButtonOfDesiredView(String NameOfView) 
	{
		clickOnDesiredView(NameOfView);
		By temp2 = By.xpath("//div[@class='view-column-title']//span[contains(text(),'" + NameOfView + "')]//parent::div[1]//parent::div[@class='filter-column-title filter-view current-view edit-view']//following-sibling::div[1]//div[@title='Refresh']");
		waitForElementToBeClickable(temp2, shortWait);
		Click(temp2);
		TestUtils.sleep(5); 
	}

	
	
    
	
    public boolean verifyDashboardIconEnabled()
    {	
    	 boolean status = true;
    	String  attribute= giveAttribute(DashBoardIcon, "class");
    	
    	Log.info(attribute);
    	
   	  if(attribute.contains("disabled"))
 	       {
 	    	status = false;
 	       }	 
 	    Log.info("Dashboard Icon is enabled for a user created view");
 	    return status;		
    }
	
	
    public void ClickOnDashBoardButtonOfDesiredView(String NameOfView) 
    {
		clickOnDesiredView(NameOfView);
		By dashBoardIcon = By.xpath("//div[@class='view-column-title']//span[contains(text(),'" + NameOfView + "')]//parent::div[1]//parent::div[@class='filter-column-title filter-view current-view edit-view']//following-sibling::div[1]//div[@title='Dashboard']");
		waitForElementToBeClickable(dashBoardIcon, shortWait);
		Click(dashBoardIcon);
	}
	
	
	public void ClickOnDisplayTypeDropDown()
	{		
		selectByCompleteVisibleText(displayType, DataUtils.getTestData1("CreateView", "Display Type", "Option16"));
		Log.info("Value is selected in Display Type drop down menu");
	}
	
	
	public boolean verifyDisplayTypeAfterSelectingAValue()
	{	
		 boolean status = false;
		 String actValue = getText(displayTypeDropDownForViewResult);
		 String expValue = (DataUtils.getTestData1("CreateView", "Display Type", "Option16"));
	   	  if(actValue.equals(expValue))
	 	       {
	 	    	status = true;
	 	       }	 
	 	    Log.info("'View Result' option is selected in drop down menu");
	 	    return status;	
	}
	
	
	public boolean verifyDisplayTypeBydefault()
	{	
		 boolean status = false;
		 String actValue = getText(displayTypeDropDownByDefault);
		 String expValue = "None";
	   	  if(actValue.equals(expValue))
	 	       {
	 	    	status = true;
	 	       }	 
	 	    Log.info("'Display Type' drop down is selected 'None' as Bydefault");
	 	    return status;	
	}
	
	
	public void formSaveButton()
	{
		javascriptButtonClick(formSaveBttn);
		Log.info("Save button was clicked");
	}
	
	
	
	public void ClickOnExportButtonOfDesiredView(String NameOfView) {
		clickOnDesiredView(NameOfView);
		By temp2 = By.xpath("//div[@class='view-column-title']//span[contains(text(),'" + NameOfView + "')]//parent::div[1]//parent::div[@class='filter-column-title filter-view current-view edit-view']//following-sibling::div[1]//div[@title='Export']");
		waitForElementToBeClickable(temp2, shortWait);
		Click(temp2);
	}

	public void ClickOnWebServicesButtonOfDesiredView(String NameOfView) {
		clickOnDesiredView(NameOfView);
		By temp2 = By.xpath("//div[@class='view-column-title']//span[contains(text(),'" + NameOfView + "')]//parent::div[1]//parent::div[@class='filter-column-title filter-view current-view edit-view']//following-sibling::div[1]//div[@title='Web Services']");
		waitForElementToBeClickable(temp2, shortWait);
		Click(temp2);
	}

	// Verify Clone icon
	public void verifyCloneIcon(String NameOfView) 
	{
		By CloneIcon = By.xpath("//div[@class='view-column-title']//span[contains(text(),'" + NameOfView + "')]//parent::div//following-sibling::div[@title='Clone']");
		isElementPresent(CloneIcon);
	}

	
	// Reorder icon
	public void verifyReorderIcon(String NameOfView) {
		By ReorderIcon = By.xpath("//div[@class='view-column-title']//span[contains(text(),'" + NameOfView + "')]//parent::div//following-sibling::div[@title='Re-order views']");
		isElementPresent(ReorderIcon);
	}

	public void AddEntityandSubViewView(String NameOfEntityToBeAdded, String NameOfSubViewToBeAdded) {
		By EntityDropDown = By.xpath("//select[@id='Entity']");
		By SubViewDropDown = By.xpath("//select[@id='Child']");
		if (NameOfEntityToBeAdded != null) {
			waitForElementToBeClickable(EntityDropDown, longWait);

			Click(EntityDropDown);
			By option = By.xpath("//select[@id='Entity']//option[text()='" + NameOfEntityToBeAdded + "']");
			waitForElementToBeClickable(option, longWait);
			
			Click(option);

			if (NameOfSubViewToBeAdded != null) {
				Click(SubViewDropDown);
				waitForElementToBeClickable(EntityDropDown, longWait);
				By option1 = By.xpath("//select[@id='Child']//option[text()='" + NameOfSubViewToBeAdded + "']");
				waitForElementToBeClickable(option, longWait);

				Click(option1);
			}
		}
	}

	
	public void AddATask(String Code, String Desc, String Type, String ExpectedTime) {
		By taskSubTab = By.xpath("//span[contains(text(),'Tasks')]");

		By addTaskIcon = By
				.xpath("//li[@title='Tasks']//a[@href='javascript:void(0)']//div[@class='page_item page_item_add']");

		By codeField = By.xpath("//input[@id='TANO']");

		By descriptionField = By.xpath("//input[@id='TADE']");

		By typeOfTask = By.xpath("//select[@id='TACA']");

		By ExpectedTimeField = By.xpath("//input[@id='TATO']");

		waitForElementToBeClickable(taskSubTab, shortWait);
		Click(taskSubTab);

		waitForElementToBeClickable(addTaskIcon, shortWait);
		Click(addTaskIcon);
		setText(codeField, Code, longWait);
		setText(descriptionField, Desc, shortWait);
		if (typeOfTask != null) {
			Click(typeOfTask);
			selectByCompleteVisibleText(typeOfTask, Type);
		}

		if (ExpectedTime != null) {
			setText(ExpectedTimeField, ExpectedTime, longWait);
		}
	}

	public void AddAJob(String NameofJob, String TypeOfJob, String ExpectedTime, int numberOfTaskGroup,
			int numberOfCodes) {
		By nameField= By.xpath("//input[@id='RTDE']");
		
		 
		 By addTaskGroupNameField= By.xpath("//input[@id='RTGN']");
		
		 
		 By saveBttn= By.xpath("//*[@id='btnTopSave']");
		
		 By addJobicon=By.xpath("//span[text()='Jobs']//following-sibling::div");
		
		 By typeDropDown = By.xpath("//select[@id='RTCA']");
		
		 By ExpectedTimeField=By.xpath("//input[@id='RTEH']");
		   
		 waitForElementToBeClickable(addJobicon, longWait);
		 clickAndWait(addJobicon, longWait);
		 
		waitForElementToBeClickable(nameField, longWait);
		
		
		
		
		setText(nameField, NameofJob, shortWait);
		selectByCompleteVisibleText(typeDropDown, TypeOfJob);
		//Click(ExpectedTimeField);
		//setText(ExpectedTimeField, ExpectedTime, shortWait);
		CreateTaskGroup(numberOfTaskGroup, numberOfCodes);
		/*for (String S1 : ListOfGroupNames)
		{
			int i=0;
			Click(addTaskGroupBttn);
			setText(addTaskGroupNameField, S1, shortWait);
			innerloop:
		   for(int k=0;ListOfLimit.get(i)>0;k++)
		   {
			   Click(addTaskBttn);
			   waitForElementToBeClickable(taskCodeField, longWait);
			   setText(taskCodeField, ListOfCodes.get(k), shortWait);
			   if(k<ListOfLimit.get(i))
			   {
				   break innerloop;
				   
			   }
			   
		   }
			   
			   i++;
		   }*/
		
		TestUtils.sleep(5);
		clickAndWait(By.xpath("//button[@id='btnTopSave']"), longWait);
		waitTillTextPresent("Successfully inserted records.", longWait);
		Assert.assertTrue(verifyJobsAfterCreating(NameofJob), "created job doesnt appear on show view page");
		
		
		
	}

	public void CreateTaskGroup(int numberOfTaskGroup, int numberOfCodes)
	{

		By addTaskGroupBttn= By.xpath("//td[@id='tdFieldRTAG']/input");
		
		waitForElementToBeClickable(addTaskGroupBttn, longWait);
		
		for(int i=1;i<=numberOfTaskGroup;i++)
		{
		Click(addTaskGroupBttn);
		By taskGroupField= By.xpath("//tr["+i+"]//td[2]//div[1]//div[1]//div[1]//div[1]//table[1]//tbody[1]//tr[1]//td[1]//div[1]//input[1]");
		setText(taskGroupField, DataUtils.getTestData("TaskGroupNameAndCodes", "GroupName", "GroupName"+i), shortWait);
		TestUtils.sleep(10);
		Addcodes(numberOfCodes,i);
				}
	}

	@SuppressWarnings({ "unchecked", "unchecked" })
	public void Addcodes(int numberOfCodes, int i)
	{

		By taskCodeField= By.xpath("//div[@id='groupBody_TAGR']/table/tbody/tr["+i+"]//div[@id='groupBody_TaskGroupElement']//input[@id='TANO']");
		for(int k=1;k<=numberOfCodes;k++)
		{
		By addTaskBttn= By.xpath("//tr["+i+"]//td[2]//div[1]//div[1]//div[1]//div[1]//table[1]//tbody[1]//tr[1]//td[1]//div[1]//input[2]");
		
	
		
		
		clickAndWait(addTaskBttn, shortWait);
			//Click(addTaskBttn);	
			TestUtils.sleep(5);
		}
		
		List<WebElement> el=driver.get().findElements(taskCodeField);
		int p=1;
		for(WebElement el1:el)
		{
		
			setTextBY(el1,DataUtils.getTestData("TaskGroupNameAndCodes", "Code", "Code"+p), shortWait);
			p++;
			
		}
	
	}
	
	
	public boolean verifyJobsAfterCreating(String NameofJob)
	{
		boolean status=false;
		clickOnDesiredView("Jobs / tasks / parts");
		By action1=By.xpath("//tbody[@role='rowgroup']//tr[1]");
		
		waitForElementToBeClickable(action1, longWait);
		
	
		List<WebElement>Totalrows=driver.get().findElements(By.xpath("//tbody[@role='rowgroup']//tr"));
		
		int size=Totalrows.size();
		loop:
		for(int i=1;i<=size;i++)
		{
			By el=By.xpath("//tbody[@role='rowgroup']//tr["+i+"]//td[5]/text");
			clickAndWait(el, longWait);
			if(driver.get().findElement(el).getText().equals(NameofJob))
			{
				status=true;
				break loop;
			}
			
			
		}
		
		return status;
	}
	

	
	public void AddAPlanMaintenance(String JobPattern,String NameOfPlanMaintenance,List<String>triggerConfigurationList,List<String>valuesOfTriggerConfiguration) throws AWTException
	{
		/*By addPlannedMaintenanceIcon=By.xpath("//span[@class='page_item_text'][contains(text(),'Maintenance Plans')]/following-sibling::div");
		waitForElementToBeClickable(addPlannedMaintenanceIcon, minimalWait);
		Click(addPlannedMaintenanceIcon);
		*/

		By addPlan=By.xpath("//span[text()='Maintenance Plans']//following-sibling::div");
		clickAndWait(addPlan, longWait);
		By NameField = By.xpath("//input[@id='PLDE']");
		waitForElementToBeClickable(NameField, minimalWait);
		setText(NameField, NameOfPlanMaintenance, minimalWait);
		AddJobsInsideMaintenancePlan(JobPattern);
		if(triggerConfigurationList!=null)
		{
			for(String Str :triggerConfigurationList )
			{
				System.out.println("in for looop for creating triggerconfig");
				By DropDown=By.xpath("//select[@id='PMGT']");
				By AddButton=By.xpath("//input[@id='PMAT']");
				By Option =By.xpath("//select[@id='PMGT']//option[text()='"+Str+"']");
				clickAndWait(DropDown, longWait);
				TestUtils.sleep(3);
				clickAndWait(Option, minimalWait);
				Click(AddButton);
			}
			
			if(valuesOfTriggerConfiguration!=null)
			{
				List<WebElement> el =driver.get().findElements(By.xpath("//div[@id='editor-area']//li//span//span//input[1]"));
				int i=0;
				for(WebElement Element:el)
				{System.out.println("in for looop for putting value in  triggerconfig");
				
					
					Element.sendKeys(valuesOfTriggerConfiguration.get(i));
					i++;					
				}			
				TestUtils.sleep(10);
			}	
		}	
		Click(By.xpath("//button[@id='btnTopSave']"));
		
		waitTillTextPresent("Successfully inserted records.", longWait);		
	}
	
	
	
	
	public void EditAPlanMaintenance(String NameOfPlanMaintenance,String NameOfClass,String NewJobpattern,String ValueOfCustomTriggerInputField) throws AWTException
	{
		By addPlannedMaintenanceIcon=By.xpath("//span[@class='page_item_text'][contains(text(),'Maintenance Plans')]/following-sibling::div");
		
		
		waitForElementToBeClickable(addPlannedMaintenanceIcon, minimalWait);
		
		clickOnDesiredView("Default Maintenance Plans");
		
		By NamesFromTable= By.xpath("//table[@class='k-selectable']//tbody//tr//td[4]");
		
		waitForElementToBeClickable(NamesFromTable, minimalWait);
		
		List<WebElement> Names= driver.get().findElements(NamesFromTable);
	for(WebElement el : Names)
	{
		TestUtils.sleep(3);
		el.click();
	
		if(el.getText().equals(NameOfPlanMaintenance))
		{
			//Robot robot = new Robot();
			System.out.println("---------------------------------------->");
			// first click
			
			javascriptButtonDoubleClick(el);
			addMaintenanceClassSpecificConfigurationInsideMaintenancePlan(NameOfClass);
		
			AddJobsInsideMaintenancePlanWhileEditing(NewJobpattern);
			TestUtils.sleep(10);
			if(ValueOfCustomTriggerInputField!=null)
			{
			AddCustomTrigger(ValueOfCustomTriggerInputField);
			}
			Click(By.xpath("//button[@id='btnTopSave']"));
		}		
	}
	}

	
	public void addMaintenanceClassSpecificConfigurationInsideMaintenancePlan(String NameOfClass)
	{
		By AddBttn=By.xpath("//input[@id='PL_ADD_CLASS']");
		By Dropdown=By.id("PL_CLASS");
		By ExpandArrow=By.xpath("//input[@id='PL_EXP_CLASS']");

		clickAndWait(AddBttn, shortWait);
		waitForElementToBeClickable(Dropdown, shortWait);
		
		selectByCompleteVisibleText(Dropdown, NameOfClass);
		waitForElementToBeClickable(ExpandArrow, shortWait);
		
		//Click(ExpandArrow);
		
	}
	

	public void AddCustomTrigger(String ValueOfCustomTriggerInputField)
	{
		clickAndWait((By.xpath("//input[@id='GLO_INFO_GROUP']")), minimalWait);
		
		By inputField=By.xpath("//input[@class='k-formatted-value form-control FDVL k-input k-valid']");
		
		waitForElementToBeClickable(inputField, minimalWait);
		
		setText(inputField, ValueOfCustomTriggerInputField, minimalWait);
	
	}

	
	public void AddJobsInsideMaintenancePlan(String JobPattern) throws AWTException
	{
		TestUtils.sleep(7);
		By sendJobButton=By.xpath("//div[@class='dblBtnDiv']//input[1]");
		
		for(int i=0; i<JobPattern.length();i++)
		{  
			String a=Character.toString(JobPattern.charAt(i));
			
			System.out.println("------------------------------------------->>>>>>>>>>>>>>>"+AddingJobs.staticMap.get(a));
			By job=By.xpath("//option[(text()='"+AddingJobs.staticMap.get(a)+"')]");
			
			Click(job);
			Click(sendJobButton);
		}	
	}
	

	public void AddJobsInsideMaintenancePlanWhileEditing(String NewJobPattern) throws AWTException
	{
		TestUtils.sleep(7);
		By sendJobButton=By.xpath("//div[@id='groupBody_CL_INFO']//div//table[@class='formTable col-sm-6 col-md-6']//td[@id='tdFieldGLO_JOBS_GROUP']//div//div[@id='divWrapper_GLO_JOBS']//div[@id='groupBody_GLO_JOBS']//div//tbody//tr//input[@class='halflings-icon chevron-right dblListBtn']");
		
		for(int i=0; i<NewJobPattern.length();i++)
		{ 			 
			String a=Character.toString(NewJobPattern.charAt(i));
			
			System.out.println("------------------------------------------->>>>>>>>>>>>>>>"+AddingJobs.staticMap.get(a));
			By job=By.xpath("//div[@id='groupBody_CL_INFO']//div//table[@class='formTable col-sm-6 col-md-6']//td[@id='tdFieldGLO_JOBS_GROUP']//div//div[@id='divWrapper_GLO_JOBS']//div[@id='groupBody_GLO_JOBS']//div//tbody//tr//option[(text()='"+AddingJobs.staticMap.get(a)+"')]");
			
			Click(job);
			Click(sendJobButton);
		}		
	}

	
	/*
	 * public void CreateAView(String NameOfView, List<String>
	 * listOfDispalyedParameters, List<String> listOfFilteredParameters,
	 * List<String> listOfSortByParameters, String NameOfEntityToBeAdded, String
	 * NameOfSubViewToBeAdded) throws AWTException {
	 * waitForElementToBeClickable(createViewIcon, shortWait);
	 * Click(createViewIcon); waitForElementToBeClickable(createViewIcon,
	 * shortWait); setText(viewNameField, NameOfView, shortWait);
	 * getBasicControllersPage().AddEntityandSubViewView(NameOfEntityToBeAdded,
	 * NameOfSubViewToBeAdded);
	 * 
	 * addparametrs(listOfDispalyedParameters, listOfFilteredParameters,
	 * listOfSortByParameters); TestUtils.sleep(3); javascriptButtonClick(SaveBttn);
	 * }
	 */

	
	public void CreateAView(String NameOfView,List<String> listOfDispalyedParameters,List<String> listOfFilteredParameters,List<String> listOfSortByParameters, String NameOfEntityToBeAdded, String NameOfSubViewToBeAdded) throws AWTException
	{
		waitForElementToBeClickable(createViewIcon, shortWait);
		DeleteViewIfPresent(NameOfView);
		Click(createViewIcon);
		waitForElementToBeClickable(createViewIcon, shortWait);
		setText(viewNameField, NameOfView, shortWait);
		
		getBasicControllersPage().AddEntityandSubViewView(NameOfEntityToBeAdded, NameOfSubViewToBeAdded);
		
		addparametrs(listOfDispalyedParameters,listOfFilteredParameters,listOfSortByParameters);
		TestUtils.sleep(3);
		javascriptButtonClick(SaveBttn);
		waitTillTextPresent("View was saved successfully.", longWait);
		Assert.assertTrue(verifyViewAfterCreation(NameOfView), "Created View, not found");
	}
	
	
	public boolean verifyViewAfterCreation(String NameOfView)
	{
		boolean status=false;
		By view=By.xpath("//ul[@id='sortableList']//li//div//span[text()='"+NameOfView+"']");
		if(getElementIfVisibleUsingXpath(view, longWait))
		{
			status=true;	
		}		
		return status;		
	}
	

	public void DeleteViewIfPresent(String NameOfView)
	{
		By view=By.xpath("//ul[@id='sortableList']//li//div//div//span[text()='"+NameOfView+"']");
		if(getElementIfVisibleUsingXpath(view, longWait))
		{
			System.out.println("view already exist and now deleting");
			deleteView(NameOfView);
			System.out.println("Deleted view");
			
		}

	}
	
	
	
	public void addparametrs(List<String> listOfDispalyedParameters, List<String> listOfFilteredParameters,
			List<String> listOfSortByParameters) throws AWTException {
		if (!(listOfDispalyedParameters == null)) {
			for (String parameterName : listOfDispalyedParameters) {
				By temp = By.xpath("//div[@class='availablePanel']//select[1]//option[@title='" + parameterName + "']");

				Click(temp);
				TestUtils.sleep(3);

				Click(selectParameterBttn);

				Robot robot = new Robot();
				robot.keyPress(KeyEvent.VK_CONTROL);

				Click(temp);

				robot.keyRelease(KeyEvent.VK_CONTROL);
				System.out.println("------------------->at loop 1");
			}
		}
		System.out.println("-------------------->>>>>>>outsidenull");
		if (!(listOfFilteredParameters == null)) {
			System.out.println("-------------------->>>>>>>insidenull");
			for (String parameterName : listOfFilteredParameters) {
				System.out.println("Started executing in loop 2");
				By temp = By.xpath("//div[@class='availablePanel']//select[2]//option[@title='" + parameterName + "']");
				Click(filteredByTab);
				waitForElementToBeClickable(temp, shortWait);

				Click(temp);
				TestUtils.sleep(3);

				Click(selectParameterBttn2);

				Robot robot = new Robot();
				robot.keyPress(KeyEvent.VK_CONTROL);

				Click(temp);

				robot.keyRelease(KeyEvent.VK_CONTROL);
				System.out.println("------------------->at loop 2");
			}
		}

		if (!(listOfSortByParameters == null)) {
			for (String parameterName : listOfSortByParameters) {

				By temp = By.xpath("//div[@class='availablePanel']//select[3]//option[@title='" + parameterName + "']");
				Click(sortByTab);
				waitForElementToBeClickable(temp, shortWait);

				Click(temp);
				TestUtils.sleep(3);

				Click(selectParameterBttn3);

				Robot robot = new Robot();
				robot.keyPress(KeyEvent.VK_CONTROL);

				Click(temp);

				robot.keyRelease(KeyEvent.VK_CONTROL);
				System.out.println("------------------->at loop 3");
			}
		}
	}

	
	public void editView(String NameOfTheView, String updatedNameOfTheView, List<String> listOfDispalyedParameters,
			List<String> listOfFilteredParameters, List<String> listOfSortByParameters) throws AWTException 
	{ 
		int i=1;
		By temp = By.xpath("//ul[@id='sortableList']//li//div//div//span[(text()='" + NameOfTheView + "')]");

		waitForElementToBeClickable(temp, longWait);
		Click(temp);
		waitForElementToBeClickable(editIconUnderView, shortWait);
		Click(editIconUnderView);
		waitForElementToBeClickable(viewNameField, longWait);
		if (!(updatedNameOfTheView == null)) {
			setText(viewNameField, updatedNameOfTheView, longWait);
			i=0;
		}
		DeSelectSortByParameters(listOfSortByParameters);
		DeSelectFilteredByparameters(listOfFilteredParameters);
		DeSelectDisplayparameters(listOfDispalyedParameters);
		//javascriptButtonClick(SaveBttn);
		
		
		javascriptButtonClick(By.xpath("//input[@id='saveBtn']"));
		if(i==0)
		{
		Assert.assertTrue(verifyViewAfterCreation(updatedNameOfTheView), "Updated view not created");
	}
		
		
	}

	
	public void DeSelectDisplayparameters(List<String> listOfDispalyedParameters) throws AWTException {
		javascriptButtonClick(displayTab);
		if (!(listOfDispalyedParameters == null)) {
			for (String parameterName : listOfDispalyedParameters) {
				By temp = By.xpath("//select[@id='viewColumns']//option[contains(text(),'" + parameterName + "')]");
                
				waitForElementToBeClickable(temp, shortWait);
				Click(temp);
				
				TestUtils.sleep(5);
				Click(deSelectParameterBttn);
				/*
				 * Robot robot = new Robot(); robot.keyPress(KeyEvent.VK_CONTROL); Click(temp);
				 * robot.keyRelease(KeyEvent.VK_CONTROL);
				 */
				System.out.println("---->at loop 1");
			}
		}
	}

	
	public void DeSelectFilteredByparameters(List<String> listOfFilteredParameters) throws AWTException {
		Click(filteredByTab);
		TestUtils.sleep(3);
		System.out.println("----> Clicked on Filter By tab");
		if (!(listOfFilteredParameters == null)) {
			System.out.println("---->insidenull");
			for (String parameterName : listOfFilteredParameters) {
				System.out.println("Started executing in loop 2");
				By temp = By.xpath("//div[@class='filter-column-title' and text()='" + parameterName + "']");

				waitForElementToBeClickable(temp, shortWait);

				Click(temp);
				TestUtils.sleep(3);

				Click(deSelectParameterBttn2);

				/*
				 * Robot robot = new Robot(); robot.keyPress(KeyEvent.VK_CONTROL); Click(temp);
				 * robot.keyRelease(KeyEvent.VK_CONTROL);
				 */
				System.out.println("---->at loop 2");
			}
		}
	}

	public void DeSelectSortByParameters(List<String> listOfSortByParameters) throws AWTException {
		javascriptButtonClick(sortByTab);
		TestUtils.sleep(3);
		System.out.println("----> clicked on Sort By tab");
		if (!(listOfSortByParameters == null)) {
			for (String parameterName : listOfSortByParameters) {
				By temp = By.xpath("//select[@id='orderColumns']//option[contains(text(),'" + parameterName + "')]");

				waitForElementToBeClickable(temp, longWait);
				Click(temp);
				TestUtils.sleep(3);

				Click(deSelectParameterBttn3);
				/*
				 * Robot robot = new Robot(); robot.keyPress(KeyEvent.VK_CONTROL); Click(temp);
				 * 
				 * robot.keyRelease(KeyEvent.VK_CONTROL);
				 */
				System.out.println("---->at loop 3");
			}
		}
	}

	
	public void FillAViewForm(String NameOfNewView) {
		By nameText = By.xpath("//input[@id='view-name']");
		waitForElementToBeClickable(nameText, minimalWait);
		setText(nameText, NameOfNewView, minimalWait);

		By saveButton = By.xpath("//input[@id='saveBtn']");
		javascriptButtonClick(saveButton);
	}

	public void verifyCreateNewViewForm(ExtentTest test) {
		verify(isElementPresent(createNewViewIcon), true, "'+' icon was not present");
		test.log(LogStatus.INFO, "'+' icon was present on view's left panel");
		Log.info("'+' icon was present");

		TestUtils.sleep(4);
		test.log(LogStatus.INFO, "'+' icon was clicked");
		clickAndWait(createNewViewIcon, longWait);
		Log.info("'+' icon was clicked");

		// waitForElementToBecomeInvisible(saveButton, longWait);
		TestUtils.sleep(7);
		verify(isElementPresent(nameTextField), true, "'Name' text field was not present on cretae view form");
		test.log(LogStatus.INFO, "'Name' text field was present on cretae view form");
		Log.info("'Name' text field was present");

		verify(isElementPresent(descriptionTextField), true,
				"'Description' text field was not present on cretae view form");
		test.log(LogStatus.INFO, "'Description' text field was present");
		Log.info("'Description' text field was present");

		verify(isElementPresent(rowCountTextField), true, "'Row Count' text field was not present on cretae view form");
		test.log(LogStatus.INFO, "'Row Count' text field was present");
		Log.info("'Row Count' text field was present");

		verify(isElementPresent(EntityDropDownMenu), true,
				"'Entity' drop down menu was not present on cretae view form");
		test.log(LogStatus.INFO, "'Entity' drop down menu was present");
		Log.info("'Entity' drop down menu was present");

		verify(isElementPresent(subViewDropDown), true,
				"'Sub-View' drop down menu was not present on cretae view form");
		test.log(LogStatus.INFO, "'Sub-View' drop down menu was present");
		Log.info("'Sub-View' drop down menu was present");

		verify(isElementPresent(IsDefaultCheckBox), true, "'Is Default' checkbox was not present on cretae view form");
		test.log(LogStatus.INFO, "'Is Default' checkbox was present");
		Log.info("'Is Default' checkbox was present");

		verify(isElementPresent(SharedCheckBox), true, "'Shared' checkbox was not present on cretae view form");
		test.log(LogStatus.INFO, "'Shared' checkbox was present");
		Log.info("'Shared' checkbox was present");

		verify(isElementPresent(availableParametersSection), true,
				"'Available Parameters' section was not present on cretae view form");
		test.log(LogStatus.INFO, "'Available Parameters' section was present");
		Log.info("'Available Parameters' section was present");

		verify(isElementPresent(selectedParametersSection), true,
				"'Selected Parameters' section was not present on cretae view form");
		test.log(LogStatus.INFO, "'Selected Parameters' section was present");
		Log.info("'Selected Parameters' section was present");

		verify(isElementPresent(selectArrowButton), true, "'Selecte Arrow' button was not present on cretae view form");
		test.log(LogStatus.INFO, "'Selecte Arrow' button was present");
		Log.info("'Selecte Arrow' button was present");

		verify(isElementPresent(deSelectArrowButton), true,
				"'Deselecte Arrow' button was not present on cretae view form");
		test.log(LogStatus.INFO, "'Deselecte Arrow' button was present");
		Log.info("'Deselecte Arrow' button was present");

		verify(isElementPresent(reOrderUpArrowButton), true,
				"'Reorder up arrow' button was not present on cretae view form");
		test.log(LogStatus.INFO, "'Reorder up arrow' button was present");
		Log.info("'Reorder up arrow' button was present");

		verify(isElementPresent(reOrderDownArrowButton), true,
				"'Reorder down arrow' button was not present on cretae view form");
		test.log(LogStatus.INFO, "'Reorder down arrow' button was present");
		Log.info("'Reorder down arrow' button was present");

		verify(isElementPresent(displayTab), true,
				"'Display' tab was not present on cretae view form under Selected Parameters section");
		test.log(LogStatus.INFO, "'Display' tab was present");
		Log.info("'Display' tab was present");

		verify(isElementPresent(filteredByTab), true, "'Filtered By' tab was not present on cretae view form");
		test.log(LogStatus.INFO, "'Filtered By' tab was present");
		Log.info("'Filtered By' tab was present");

		verify(isElementPresent(sortByTab), true, "'sort By' tab was not present on cretae view form");
		test.log(LogStatus.INFO, "'Sort By' tab was present");
		Log.info("'Sort By' tab was present");

		clickAndWait(exportOptions, longWait);
		test.log(LogStatus.INFO, "'Export Options' was clicked");
		Log.info("'Export Options' was clicked");

		verify(isElementPresent(exportOptionsPage), true,
				"'Export Options' title was not present on Export options page under cretae view form");
		test.log(LogStatus.INFO, "'Export Options' text was present");
		Log.info("'Export Options' text was present");

		verify(isElementPresent(headerCheckBox), true, "'Header' checkbox was not present on Export options page");
		test.log(LogStatus.INFO, "'Header' checkbox was present");
		Log.info("'Header' checkbox was present");

		verify(isElementPresent(fileType), true, "'File Type' drop down menu was not present on Export options page");
		test.log(LogStatus.INFO, "'File Type' drop down menu was present");
		Log.info("'File Type' drop down menu was present");

		verify(isElementPresent(separatorTextField), true,
				"'Separator' text field was not present on cretae view form");
		test.log(LogStatus.INFO, "'Separator' text field was present");
		Log.info("'Separator' text field was present");

		verify(isElementPresent(delimiterTextField), true,
				"'Separator' text field was not present on cretae view form");
		test.log(LogStatus.INFO, "'Separator' text field was present");
		Log.info("'Separator' text field was present");

		verify(isElementPresent(encodingDropDown), true,
				"'Encoding' drop down menu was not present on Export options page");
		test.log(LogStatus.INFO, "'Encoding' drop down menu was present");
		Log.info("'Encoding' drop down menu was present");

		verify(isElementPresent(fieldFormatText), true,
				"'Field Format' text was not present on Export options page under cretae view form");
		test.log(LogStatus.INFO, "'Field Format' text was present");
		Log.info("'Field Format' text was present");

		clickAndWait(exportOptions, longWait);
		test.log(LogStatus.INFO, "'Export Options' was closed");
		Log.info("'Export Options' was closed");

		verify(isElementPresent(saveButton), true, "'Save' Button was not present on cretae view form");
		test.log(LogStatus.INFO, "'Save' Button was present on cretae view form");
		Log.info("'Save' Button was present on cretae view form");

		verify(isElementPresent(cancelButton), true, "'Save' Button was not present on cretae view form");
		test.log(LogStatus.INFO, "'Cancel' Button was present on cretae view form");
		Log.info("'Cancel' Button was present on cretae view form");
	}

	public void verifyValidationOnCreateNewViewForm(ExtentTest test) {
		TestUtils.sleep(4);
		test.log(LogStatus.INFO, "'+' icon was clicked");
		clickAndWait(createNewViewIcon, longWait);
		Log.info("'+' icon was clicked");

		TestUtils.sleep(4);
		javascriptButtonClick(saveButton);
		test.log(LogStatus.INFO, "'Save' button was clicked");
		Log.info("Save button was clicked");

		isTextPresentOnPage("The Name must be between 1 and 30 characters.");
		test.log(LogStatus.INFO,
				"'The Name must be between 1 and 30 characters.' validation text was appeared just below Name text field");
		Log.info("Name text field validation message was appeared");

		isTextPresentOnPage("At least one item must be selected.");
		test.log(LogStatus.INFO,
				"'At least one item must be selected.' validation text was appeared just below Name text field");
		Log.info("Parameter selection validation message was appeared");

		javascriptButtonClick(cancelButton);
		test.log(LogStatus.INFO, "Cancel button was clicked");
		Log.info("Cancel button was clicked");
	}

	public boolean verifyColumns(String ColumnName1, String ColumnName2, String ColumnName3, String ColumnName4) {
		By column1 = By.xpath("//div[@id='grid']//table[@role='grid']//tr[1]//th[text()='" + ColumnName1 + "']");
		By column2 = By.xpath("//div[@id='grid']//table[@role='grid']//tr[1]//th[text()='" + ColumnName2 + "']");
		By column3 = By.xpath("//div[@id='grid']//table[@role='grid']//tr[1]//th[text()='" + ColumnName3 + "']");
		By column4 = By.xpath("//div[@id='grid']//table[@role='grid']//tr[1]//th[text()='" + ColumnName4 + "']");

		boolean status = false;
		if (getElementIfVisibleUsingXpath(column1, longWait) && getElementIfVisibleUsingXpath(column2, longWait)
				&& getElementIfVisibleUsingXpath(column3, longWait) && getElementIfVisibleUsingXpath(column4, longWait)) {
			status = true;
		}
		return status;
	}

	
	public boolean VerifyEachColumn(List<String>List1)
	{
		
		boolean status=false;
		int i=0;
		int size=List1.size();
		System.out.println("size is here------------"+size);
		loop:
		for(String str:List1)
		{
			By column1 = By.xpath("//div[@id='grid']//table[@role='grid']//tr[1]//th[text()='" + List1.get(i) + "']");
			
			if(getElementIfVisibleUsingXpath(column1, longWait))
			{
				
				System.out.println(i+" column is present");
				
				
				
			}
			else 
			{
				
				status=false;
			
				break loop;
			}
			
			
			i++;
		}
		
		System.out.println("value of i-------->"+i);
		if(i==size)
		{
			
			status=true;
		}
		
		
		
		
		return status;
	}
	
	
	
	
	
	
	public void ReOrderOperation(String NameOfTheView1, String NameOfTheView2) throws AWTException 
	{
		WebElement Image1 = driver.get().findElement(By.xpath("//div[@class='view-column-title']//span[text()='" + NameOfTheView1 + "']"));
		WebElement Image2 = driver.get().findElement(By.xpath("//div[@class='view-column-title']//span[text()='"+ NameOfTheView2 + "']//parent::div//following-sibling::div[@title='Re-order views']"));

		// Used points class to get x and y coordinates of element.
		Point classname1 = Image1.getLocation();
		Point classname2 = Image2.getLocation();

		int xcordi1 = classname1.getX();
		int xcordi2 = classname2.getX();

		System.out.println("Element's Position from left side" + xcordi1 + " pixels.");
		int ycordi1 = classname1.getY();
		int ycordi2 = classname2.getY();
		System.out.println("Element's Position from top" + ycordi1 + " pixels.");

		Robot robot = new Robot();

		  robot.mouseMove(xcordi2, ycordi2); 
		  robot.keyPress(InputEvent.BUTTON1_MASK);
		  System.out.println("------------------- Mouse button pressed");
		  TestUtils.sleep(4);
		  robot.mouseMove(xcordi1, ycordi1);
		  robot.keyRelease(InputEvent.BUTTON1_MASK);
		  System.out.println("------------------- Mouse button released");
    }
	

	public void verifyView(String NameOfView) 
	{
		By view = By.xpath("//div[@class='view-column-title']//span[contains(text(),'" + NameOfView
				+ "')]//parent::div//following-sibling::div[@title='Clone']");
		isElementPresent(view);
	}
	
	
	public boolean verifyAggregateDropDownNotPresent()
    {
  	  boolean status = false;
      	if(!getElementIfVisibleUsingXpath(AggregateDropDown, longWait))
      	{
      		status = true;
      	}
      	Log.info("Aggregate drop down was not present");	
  		return status;    
    }
	
	
	 // Verify Aggregate drop down menu
    public boolean verifyAggregateDropDown()
    {
    	boolean status = false;
    	if(getElementIfVisibleUsingXpath(AggregateDropDown, longWait))
    	{
    		status = true;
    	}
    	Log.info("Aggregate drop down menu is present on Create View page");
		return status;    	
    }
	
	
	 public void selectValueInAggregateDropDownMenu()
     {
   	  selectByCompleteVisibleText(selectFromAggregateDropDown, DataUtils.getTestData1("CreateView", "Aggregate", "Option1"));
   	  Log.info("Value is selected in Aggregate drop down menu");
     }
	

    public void selectValueFromEntityDropDownMenu()
    {
  	  selectByCompleteVisibleText(EntityDropDownMenu, DataUtils.getTestData1("CreateView", "Entity", "Option1")); 
  	  Log.info("Entity drop down menu is clicked and value selected");
    }
    
    
    
    
    
    @SuppressWarnings("unchecked")
	public boolean verifySubViewDropDownIsEnabled()
    {
    	boolean status = false;
    	if(verifyIsEnabled(SubViewDropDrownMenu, longWait))
    	{
    		status = true;
    	}
    	Log.info("After selection of entity the Sub-View drop down menu is enabled");
		return status;    	
    }
    
	
	public void saveButton()
	{
		javascriptButtonClick(dashboardSaveBttn);
		Log.info("Save button was clicked");
	}
	
	
	public void cancelBttn()
	{
		javascriptButtonClick(dashboardCancelBttn);
		Log.info("Save button was clicked");
		
	}
	
 	public void verifySuccessMessageAfterSaveAView()
	{
		waitTillTextPresent("View was saved successfully.", longWait);
		isTextPresentOnPage("View was saved successfully.");
	}
 	
 	
 	public boolean VerifyWebServicesIcon()
    {
    	 boolean status = false;
   	  if(getElementIfVisibleUsingXpath(webserviceIcon, longWait))
 	       {
 	    	status = true;
 	       }	 
 	    Log.info("Dashboard Icon is present with a user created view");
 	    return status;		
    }
 	
 	
 	
 	public boolean verifyWebServicesIconEnabled()
    {	
    	 boolean status = true;
    	String  attribute= giveAttribute(webserviceIcon, "class");
    	
    	Log.info(attribute);
    	
   	  if(attribute.contains("disabled"))
 	       {
 	    	status = false;
 	       }	 
 	    Log.info("Web Services Icon is enabled for a user created view");
 	    return status;		
     }
 	
 	
 	public boolean verifyExportIconEnabled()
    {	
    	 boolean status = true;
    	String  attribute= giveAttribute(exportIcon, "class");
    	
    	Log.info(attribute);
    	
   	  if(attribute.contains("disabled"))
 	       {
 	    	status = false;
 	       }	 
 	    Log.info("Export Icon is enabled for a view if 'Entity' is selected as 'None'");
 	    return status;		
    }
 	
 	
 	
	
 	
 	 public void ClickOnWebServiceOfDesiredView(String NameOfView) 
     {
 		clickOnDesiredView(NameOfView);
 		By dashBoardIcon = By.xpath("//div[@class='view-column-title']//span[contains(text(),'" + NameOfView + "')]//parent::div[1]//parent::div[@class='filter-column-title filter-view current-view edit-view']//following-sibling::div[1]//div[@title='Web Services']");
 		waitForElementToBeClickable(dashBoardIcon, shortWait);
 		Click(dashBoardIcon);
 	 }
 	
 	 
 	 public void ClickOnExportOptionOfDesiredView(String NameOfView) 
     {
 		clickOnDesiredView(NameOfView);
 		By exportIcon = By.xpath("//div[@class='view-column-title']//span[contains(text(),'" + NameOfView + "')]//parent::div[1]//parent::div[@class='filter-column-title filter-view current-view edit-view']//following-sibling::div[1]//div[@title='Export']");
 		waitForElementToBeClickable(exportIcon, shortWait);
 		Click(exportIcon);
 		TestUtils.sleep(4);	
 	 }
 	 
 	 
 	public void verifyWebServicesPage(ExtentTest test) 
 	{
		isTextPresentOnPage("Web Service Permissions");
		test.log(LogStatus.INFO,"'Web Service Permissions' page title text was appeared on top of the page");
		Log.info("Page title text was appeared on top of the page");

		isTextPresentOnPage("Available Agents");
		test.log(LogStatus.INFO,"'Available Agents' text was appeared on Web Service Permissions page");
		Log.info("'Available Agents' text was appeared on Web Service Permissions page");

		isTextPresentOnPage("Assigned Agents");
		test.log(LogStatus.INFO,"'Assigned Agents' text was appeared on Web Service Permissions page");
		Log.info("'Assigned Agents' text was appeared on Web Service Permissions page");
		TestUtils.sleep(4);		
		javascriptButtonClick(webServicesCancelBttn);
		test.log(LogStatus.INFO, "Cancel button was clicked");
		Log.info("Cancel button was clicked");
	}
 	 
 	 
 	 
 	public String verifyExportedFile(String dirPath) throws IOException {
		// String filePath= "./Exported file folder";

		File folder = new File(dirPath);

		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				String fileName = listOfFiles[i].getName();
				System.out.println("File is -------------- " + fileName);

				//String excelFilePath = "./Exported file folder/" + (fileName);
			}
 	
		}
		return dirPath;
	}
 	
 	public boolean verifyExportedFileName(String dirPath, String NameOfView) throws IOException {
		// String filePath= "./Exported file folder";

		File folder = new File(dirPath);

		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				boolean fileName = listOfFiles[i].getName().contains(NameOfView);
				System.out.println("File is -------------- " + fileName);
							
			}
		}
		return true;
	}
	
 	
 	public void deleteDownlodedFile() throws InterruptedException 
 	{
		File folder = new File("./resources/downloadedFiles");
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) 
		{
			if (listOfFiles[i].isFile()) 
			{
				listOfFiles[i].delete();
				System.out.println("File Deleted");
			}
		}
	}
 	
 	
 	public boolean verifyEditViewIconDisabledForDefaultView()
    {	
 		waitForElementToBeClickable(editView, longWait);
    	boolean status = false;
    	String  attribute= giveAttribute(editView, "class");
    	Log.info("my attribute is ----------"+attribute);
    	System.out.println("my attribute isssssssssss----"+attribute);
    	
   	    if(attribute.contains("disabled"))
 	       {
 	    	status = true;
 	       }	 
 	    Log.info("Edit view Icon is disabled for a  default view");
 	    return status;
    }
 	
 	
 	public boolean verifySuccessMsgAfterUnhideAView()
	{
		waitTillTextPresent("The view is now visible." , longWait);
		
		 boolean status = false;
	   	  if(isTextPresentOnPage("The view is now visible."));
	 	       {
	 	    	status = true;
	 	       }	 
	   	TestUtils.sleep(6);
	 	    Log.info("Hidden view is now visible");
	 	    return status;	 	    
	}
 	
 	
 	public boolean verifySuccessMsgAfterhideAView()
	{
 		boolean status = false;
		//waitTillTextPresent("The selected view was hidden" , longWait);
 		TestUtils.sleep(2);
	 
	   	  if(isTextPresentOnPage("The selected view was hidden"));
	 	       {
	 	    	status = true;
	 	       }	    
	 	    Log.info("View is hidden now");
	 	    return status;	 	    
	}
 	
 	public boolean VerifyDashboardIcon()
    {
    	 boolean status = false;
   	  if(getElementIfVisibleUsingXpath(DashBoardIcon, longWait))
 	       {
 	    	status = true;
 	       }	 
 	    Log.info("Dashboard Icon is present with a user created view");
 	    return status;		
    }
 		
 	
 	public void AddFilterFromView(String FilterBy,String FilterByOption,String FilterByValue)
	{
		
		By FilterByIcon=By.xpath("//div[@id='filter-ground']//div[text()='"+FilterBy+"']");
		
		clickAndWait(FilterByIcon, longWait);
		TestUtils.sleep(5);
		
		By FilterbyOptionIcon=By.xpath("//div[@id='filter-ground']//div[text()='"+FilterBy+"']//following-sibling::div[1]//label[@title='"+FilterByValue+"']");
		
		clickAndWait(FilterbyOptionIcon, longWait);
		
		By FilterByField=By.xpath("//div[@id='filter-ground']//div[text()='"+FilterBy+"']//following-sibling::div[1]//label[@title='"+FilterByValue+"']//parent::div//following-sibling::div[2]//input");
		
		TestUtils.sleep(3);
		
		setText(FilterByField, FilterByValue, longWait);
		
		
		By refresh=By.xpath("//form[@id='filterColumnsForm']//div[@class='RefreshIcon ViewIcons']");
		
		clickAndWait(refresh, longWait);
		
		By el=By.xpath("//tbody[@role='rowgroup']//tr[1]");
		
		waitForElementToBeClickable(el, longWait);
		
		
	}
 	
 	public void cloneView(String NameOfView,String NameOfNewView)
	{
		waitForElementToBeClickable(createViewIcon, shortWait);
		DeleteViewIfPresent(NameOfNewView);
		
		clickOnDesiredView(NameOfView);
		By temp2= By.xpath("//div[@class='view-column-title']//span[text()='"+NameOfView+"']//parent::div//following-sibling::div[@title='Clone']");
		waitForElementToBeClickable(temp2, shortWait);
		Click(temp2);
		TestUtils.sleep(4);
		FillAViewForm(NameOfNewView);		
	}
 	
 	public void ClickOnTriggerResetHistory()
 	{
 		
 		
 		By TriggerResetHistory=By.xpath("//span[text()='Trigger Resets History']");
 		waitForElementToBeClickable(TriggerResetHistory, longWait);
 		clickAndWait(TriggerResetHistory, longWait);
 		
 	}
}