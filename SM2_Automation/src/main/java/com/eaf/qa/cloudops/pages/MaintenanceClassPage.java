package com.eaf.qa.cloudops.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.List;

import javax.swing.Action;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.eaf.qa.base.BasePage;

import com.eaf.qa.utils.DataUtils;
import com.eaf.qa.utils.TestUtils;

public class MaintenanceClassPage extends BasePage 
{
	private static Logger Log = LogManager.getLogger(LoginPage.class.getName());
	
	// Verify Maintenance tab
	private By maintenanceTab = By.xpath("//div[@id='headerMenu_head-item-maintenance']");
	
	// Maintenance classes
	private By maintenanceClasses = By.xpath("//span[contains(text(),'Maintenance Classes')]");
	
	// Create new Maintenance view by "+" icon
	private By createNewViewIcon = By.xpath("//span[@class='halflings-icon plus floatRight']");
	
	// Name text field
	private By nameTextField = By.xpath("//input[@id='view-name']");
	
	//IsDefaultCheckBox
	private By IsDefaultCheckBox = By.id("IsDft");
	
	//Shared Check box
	private By SharedCheckBox = By.id("IsShd");
	
	//Export Options
	private By ExportOptions = By.xpath("//label[@for='ExportExpandButton']");
	
	//Export Options page
	private By ExportOptionsPage = By.xpath("//span[@class='form-title expandedTitle']");
	
	//Header check box
	private By HeaderCheckBox = By.id("ExpHeader");

	//Export File Type drop down menu
	private By ExportFileType =  By.id("ExportType");
	
	//Encoding drop down menu
	private By EncodingDropDown = By.id("ExportEncoding");
	
	// Separator text field
	private By SeparatorText = By.xpath("//span[contains(text(),'Separator')]");
	
	// Delimiter text field
	private By DelimiterText = By.xpath("//span[@id='ExportDelimitor']");
	
	// Field Format Text
	private By FieldFormatText = By.xpath("//p[@class='fieldTitle']");
	
	//Export Options To Hide
	private By ExportOptionsToHide = By.xpath("//label[@for='ExportExpandButton']");
	
	// Sub-View drop down menu
	//private By SubViewDropDownDisabled = By.xpath("//select[@id='Child']");
	
	//Available Parameters section 
	private By AvailableParametersSection = By.xpath("//select[@id='all-columns']");
	
	//Selected Parameters section
	private By SelectedParametersSection = By.xpath("//select[@id='viewColumns']");
	
	//Select arrow button
	private By SelectArrowButton = By.xpath("//div[@id='view-ground2']//div[@class='btnHolder']//div//input[@value='>']");
	
	//DeSelect arrow button
	private By DeselectArrowButton = By.xpath("//div[@id='view-ground2']//div[@class='btnHolder']//div//input[@id='removeFilter']");
	//private By DeselectArrowButton = By.xpath("//div[@class='tab-pane fade in active']//div[@class='btnHolder']//div//input[@value='<']");
	                                           
	// ReOrder Up arrow button
	private By ReOrderUpArrowButton  = By.xpath("//div[@id='view-ground2']//div[@class='btnHolder']//div[1]//input[1]");
	
	// Reorder down arrow button
	private By ReOrderDownArrowButton = By.xpath("//div[@id='view-ground2']//div[@class='btnHolder']//div[1]//input[2]");
	
	// Select Created On parameter from Available parameters section
	private By SelectCreatedOnParameter = By.xpath("//select[@id='all-columns']//option[@title='Created On'][contains(text(),'Created On')]");
	
	// Selected parameter 'Created On' in Selected parameters section
	private By CreatedOnInSelectedParameter = By.xpath("//select[@id='viewColumns']//option[@title='Created On'][contains(text(),'Created On')]");
	
	// Select parameter 'Default Condition' from Available parameters section
	private By SelectDefaultConditionParameter = By.xpath("//select[@id='all-columns']//option[@title='Default Condition'][contains(text(),'Default Condition')]");
	
	// Select 'Equipment Desc.' from Available Parameter section
	private By SelectEquipmentDescParameter  = By.xpath("//select[@id='all-columns']//option[@title='Equipment Desc.'][contains(text(),'Equipment Desc.')]");
	
	// Count Options in selected parameters section
	private By CountOptionInSelected = By.xpath("//div[@id='viewGround']//option");
	
	// Selected parameter 'Default Condition' in Selected parameters section
	private By DefaultConditionInSelectedParameters = By.xpath("//div[@id='viewGround']//option[contains(text(),'Default Condition')]");
	
	// Xpath for Aggregate drop down
	private By AggregateDropDown = By.xpath("//div[contains(text(),'Aggregate')]");
	
	// Xpath for Aggregate drop down
	private By selectFromAggregateDropDown = By.xpath("//div[@id='view-ground2']//div[@id='itemOption']//select[1]");
	
	// Equipment Desc. parameter in selected parameters
	private By EquipmentDescInSelectedParameters = By.xpath("//select[@id='viewColumns']//option[contains(text(),'Equipment Desc.')]");
	
	// Entity drop down menu on Create View page
	private By EntityDropDownMenu = By.id("Entity");
	
	// Sub-view drop down on Create View page
    private By SubViewDropDrownMenu = By.id("Child");
	
    // Display tab under Selected Parameters section
    private By displayTab = By.id("tab2");
    
    // Filtered by tab under Selected Parameters section
    private By filteredByTab = By.id("tab3");
    
    // Filtered by tab under Selected Parameters section
    private By sortByTab = By.id("tab5");
	
    // Save button on Create View page
    private By saveButton = By.id("saveBtn");
    
	// Cancel Button on Create View page
    private By cancelButton = By.xpath("//input[@value='Cancel']");
    
    // An Individual view
    private By IndividualView = By.xpath("//div[@class='view-column-title']//span[contains(text(),'sm29598view')]");
    
    // Delete icon
    private By deleteIcon = By.xpath("//div[@class='view-column-title']//span[contains(text(),'sm29598view')]//parent::div//following-sibling::div[@title='Delete']");
    
    private By viewNameGridTitle = By.xpath("//span[@class='gridTitle']");
    
    private By DefaultMaintClassView = By.xpath("//div[@class='view-column-title']//span[contains(text(),'Default Maint Class View')]");
      
    private By hideIconOfDefaultMaintClassView = By.xpath("//div[@class='view-column-title']//span[contains(text(),'Default Maint Class View')]//parent::div//following-sibling::div[@title='Hide this view']");
    
    private By hideButtonOfAView = By.xpath("//input[@id='view-action-delete']");
    
    //private By hideButtonOnViewLeftPanel = By.xpath("//div[@class='halflings-icon eye-close floatLeft']");
    
    private By openEyeHideButtonOnViewLeftPanel  = By.xpath("//div[text()='Views']//span[2]//following-sibling::div/input");
    
    //private By  hiddenView = By.xpath("//div[@class='view-column-title']//span[contains(text(),'Default Maint Class View')]");
    
    private By hiddenDefaultMaintClassView = By.xpath("//div[@class='view-column-title']//span[contains(text(),'Default Maint Class View')]");
                                                       
    private By eyeIconOfHiddenView = By.xpath("//div[@class='view-column-title']//span[contains(text(),'Default Maint Class View')]//parent::div//following-sibling::div[@title='Unhide view']");
    
    private By showBttnOfHiddenView = By.xpath("//span[text()='Show this view?']//following-sibling::input");
    
    private By CloneIconOfDefaultMaintClassView = By.xpath("//div[@class='view-column-title']//span[contains(text(),'Default Maint Class View')]//parent::div//following-sibling::div[@title='Clone']");
    
    private By ReOrderIconOfDefaultMaintClassView = By.xpath("//div[@class='view-column-title']//span[contains(text(),'Default Maint Class View')]//parent::div//following-sibling::div[@title='Re-order views']");
    
    private By ClickOnAView = By.xpath("//div[@class='view-column-title']//span[text()='Maintenance Class Test 1']");
    
    private By EditOptionForAView = By.xpath("//div[@id='view-action-edit']");
    
    private By DashboardOptionForAView = By.xpath("//div[@id='view-action-dashboard']");
    
    private By WebServicesOptionForAView = By.xpath("//div[@id='view-action-webservice']");
    
    private By ExportOptionForAView = By.xpath("//div[@id='view-action-export']");
    
    private By FilteredByOptionForAView = By.xpath("//div[@id='view-action-filter']");
    
    private By RefreshOptionForAView = By.xpath("//div[@id='view-action-execute']");
      
    private By DescriptionOfAView = By.xpath("//input[@id='view-desc']");
    
    private By DashBoardIcon = By.xpath("//div[@id='view-action-dashboard']");
    
    private By dashboardPage = By.xpath("//div[@id='dashParams']");
    
    private By displayTypeDropDown = By.xpath("//select[@id='TYPE']");
    
    private By hiddenViewNameToHover = By.xpath("//li[@class='hiddenView']");
    
    private By showBttn = By.xpath("//div[@class='filter-data view-show-ground']//input");
    
    
    
    
    
    
    
    
    
	public MaintenanceClassPage(ThreadLocal<WebDriver> driver) {
		super(driver);
		this.driver = driver;
		Log.info("Initializing login Page Objects");
		PageFactory.initElements(driver.get(), maintenanceTab);
	}
	
	public boolean VerifyMaintenanceTab() {
		boolean status = false;
		if (getElementIfVisibleUsingXpath(maintenanceTab, longWait)) {
			//waitForElementToBeClickable(logoutDropDown, longWait);
			status = true;
			Log.info("Maintenance tab verified");
		}
		return status;		
	}
	
	public void clickOnMaintenance() {
		
		
		clickAndWait(maintenanceTab, longWait);
		TestUtils.sleep(15);
		
		waitTillTextPresent("VIEWS", longWait);
		Log.info("Left panel of Views is visible");
	}
	
	public void clickOnMaintenanceClasses() 
	{	
		clickAndWait(maintenanceClasses, longWait);
		waitForElementToBeClickable(createNewViewIcon, longWait);
		Log.info("Maintenance tab clicked");	
	}
	
	public boolean verifyIconForCreateNewView() 
	{		
			boolean status = false;
			if (getElementIfVisibleUsingXpath(createNewViewIcon, longWait)) {	
				status = true;
			}
			Log.info("Vreate new view icon is verified");
			return status;
	}
	
	/*
	public boolean verifyTooltip()
	{
		boolean status = false;
		 status = verifyTitle(createViewIcon, "CREATE NEW VIEW", longWait);
		 return status;
    }
	public boolean verifyTooltipForMP()
	{
		boolean status= false;
		Actions builder = new Actions((WebDriver) driver);
		builder.moveToElement((WebElement) createViewIcon).perform();
		TestUtils.sleep(2);
		String actTooltip = ((WebElement) createViewIcon).getAttribute("title");
		String expTooltip = "CREATE NEW VIEW";
		if (actTooltip.equals(expTooltip)) {
			status= true;
		}
		return status;
    }  */
	
	
      public void clickOnCreateNewViewIcon() 
      {  
		clickAndWait(createNewViewIcon, longWait);
		
		TestUtils.sleep(4);
		waitTillTextPresent("Create View", longWait);
		Log.info("Create View page is visible");
	  }

      
      public boolean verifyNameTextField() 
      {
			boolean status = false;
			if (getElementIfVisibleUsingXpath(nameTextField, longWait)) {
				status = true;
			}
			//Log.info("Name text field verified");
			return status;
	}

	public String enterTextInNameField()
	{
		String uniqueString = TestUtils.randomString();
		setText(nameTextField, uniqueString);
		Log.info("Text enetered in Name text field");
		return uniqueString;
	}
	 
      
	public boolean VerifyGridTitleAfterCreationOfNewView(String enteredViewName)
	{
	 getElementIfVisibleUsingXpath(viewNameGridTitle, longWait);
		boolean status = false;
		String actualViewName = getText(viewNameGridTitle);
		
	    Log.info("Actual view name is "+actualViewName);
		String expectedViewName = enteredViewName;

		if (actualViewName.equals(expectedViewName)) 
		{
			status = true;
			Log.info("View name verified");
		}
		return status;
	}
     
	
	public void clickOnSaveButtonWithoutParameter() 
      { 
  		javascriptButtonClick(saveButton);
		
  		Log.info("Saved Button clicked successfully");
		
		waitTillTextPresent("At least one item must be selected.", longWait);
		TestUtils.sleep(4);
		Log.info("Warning message with red color is present below Selected Parameter section");
	  }
      
       
      public void clickOnSaveButton() 
      { 
    	  
  		javascriptButtonClick(saveButton);
		
  		Log.info("Saved Button clicked successfully");
		
	  }
      
      
      public void clickOnCancelButtonWithoutParameter() throws AWTException 
      {
  		javascriptButtonClick(cancelButton);
  		// clickAndWait(cancelButton, longWait);
  		TestUtils.sleep(5);
  		Log.info("Cancel button was clicked");
      }
      

      public boolean clickAndVerifyIsDefaultCheckBox()
      {
    	  clickAndWait(IsDefaultCheckBox, longWait);
    	  boolean status= isSelected(IsDefaultCheckBox, shortWait);
    	  if(status){	    
    		  Log.info("IsDefault Check box verified");
                    }
    	  return status;    	 
      }
      
      
      public boolean clickAndVerifySharedCheckBox()
      {
    	  clickAndWait(SharedCheckBox, longWait);
    	  boolean status= isSelected(SharedCheckBox, shortWait);
    	  if(status){	    
    		  Log.info("Shared Check box verified");
                    }
    	  return status;    	 
      }
     
      
      
      public void ClickOnExportOptions()
      {
    	  clickAndWait(ExportOptions, shortWait);
    	   
      }
      
      public boolean VerifyExportOptionsText()
      {
      boolean status = false;
		if (getElementIfVisibleUsingXpath(ExportOptionsPage, longWait)) 
		{
			
			status = true;
		}
		return status;
      }
      
      public boolean clickAndVerifyHeaderCheckBox()
      {
    	  clickAndWait(HeaderCheckBox, longWait);
    	  boolean status= isSelected(HeaderCheckBox, shortWait);
    	  if(status){	    
    		  Log.info("Header Check box clicked and verified");
                    }
    	  return status;    	 
      }
      
      public boolean VerifyFileTypeText()
      {
      boolean status = false;
		if (getElementIfVisibleUsingXpath(ExportFileType, longWait)) 
		{
			status = true;
		}
		Log.info("File Type text is present on Export Options window");
		return status;
      }
      
      public boolean VerifyEncodingText()
      {
      boolean status = false;
		if (getElementIfVisibleUsingXpath(EncodingDropDown, longWait)) 
		{
			status = true;
		}
		Log.info("Encoding text is present on Export Options window");
		return status;
      }
     
      public boolean VerifySeparatorText() 
      {
    	boolean status = false;
    	if(getElementIfVisibleUsingXpath(SeparatorText, longWait))
    	{
    		status = true;
    	}
    	Log.info("Separator text is present on Export Options window");
		return status;
    	
      }
      
      public boolean VerifyDelimiterText() 
      {
    	boolean status = false;
    	if(getElementIfVisibleUsingXpath(DelimiterText, longWait))
    	{
    		status = true;
    	}
    	Log.info("Delimiter text is present on Export Options window");
		return status;
    	
      }
      
      public boolean VerifyFieldFormatText() 
      {
    	boolean status = false;
    	if(getElementIfVisibleUsingXpath(FieldFormatText, longWait))
    	{
    		status = true;
    	}
    	Log.info("Field Format text is present on Export Options window");
		return status;    	
      }
      
      public void clickOnExportOptionsToHide() 
      { 
		clickAndWait(ExportOptionsToHide, longWait);
		waitTillTextPresent("Create View", longWait);
		Log.info("Export Options window is hide and Create View page is visible");
	  }
      
//      public boolean verifySubViewDropDownIsDisabled()
//      {  	 
//    	  boolean status= verifyIsEnabled(SubViewDropDownDisabled, longWait);
//    	  if(status){	    
//    		      Log.info("Sub-view drop down menu verified");           
//    		        }
//    	  return status;	 
//      }
      
      public boolean VerifyAvailableParametersSection() 
      {
    	boolean status = false;
    	if(getElementIfVisibleUsingXpath(AvailableParametersSection, longWait))
    	{
    		status = true;
    	}
    	Log.info("Available Parameters section is present on Create View page");
		return status;    	
      }
      
      public boolean VerifySelectedParametersSection() 
      {
    	boolean status = false;
    	if(getElementIfVisibleUsingXpath(SelectedParametersSection, longWait))
    	{
    		status = true;
    	}
    	
    	Log.info("Selected Parameters section is present on Create View page");
		return status;    	
      }
      
      
      public boolean verifyDisplayTabUnderSelectedParametersSection() 
      {
    	boolean status = false;
    	if(getElementIfVisibleUsingXpath(displayTab, longWait))
    	{
    		status = true;
    	}
    	Log.info("Display tab is present under Selected Parameters section");
		return status;    	
      }
      
      public void clickOnDisplayTab()
      {
    	  clickAndWait(displayTab, longWait);
    	  Log.info("Display tab is clicked");
      }
      
      public boolean verifyFilteredByTabUnderSelectedParametersSection() 
      {
    	boolean status = false;
    	if(getElementIfVisibleUsingXpath(filteredByTab, longWait))
    	{
    		status = true;
    	}
    	Log.info("'Filtered by' tab is present under Selected Parameters section");
		return status;    	
      }
      
      public void clickOnFilteredByTab()
      {
    	  clickAndWait(filteredByTab, longWait);
    	  Log.info("Filtered by tab is clicked");
      }
      
      public boolean verifySortByTabUnderSelectedParametersSection() 
      {
    	boolean status = false;
    	if(getElementIfVisibleUsingXpath(sortByTab, longWait))
    	{
    		status = true;
    	}
    	Log.info("'Sort By' tab is present under Selected Parameters section");
		return status;    	
      }
      
      public void clickOnSortByTab()
      {
    	  clickAndWait(sortByTab, longWait);
    	  TestUtils.sleep(5);
    	  Log.info("Sort By tab is clicked");
      }
      
    
      public boolean VerifySelectArrowButton() 
      {
    	boolean status = false;
    	if(getElementIfVisibleUsingXpath(SelectArrowButton, longWait))
    	{
    		status = true;
    	}
    	Log.info("Select arrow button is present on Create View page");
		return status;    	
      }
      
      public boolean VerifyDeSelectArrowButton() 
      {
    	boolean status = false;
    	if(getElementIfVisibleUsingXpath(DeselectArrowButton, longWait))
    	{
    		status = true;
    	}
    	Log.info("DeSelect arrow button is present on Create View page");
		return status;    	
      }
      
      public boolean VerifyReorderUpArrowButton() 
      {
    	boolean status = false;
    	if(getElementIfVisibleUsingXpath(ReOrderUpArrowButton, longWait))
    	{
    		status = true;
    	}
    	Log.info("ReOrder Up arrow button is present on Create View page");
		return status;    	
      }
      
      public boolean VerifyReorderDownArrowButton() 
         {
    	  boolean status = false;
    	  if(getElementIfVisibleUsingXpath(ReOrderDownArrowButton, longWait))
    	   {
    		status = true;
    	   }
		  return status;    	
         }
      
      public void SelectCreatedOnParameters()    
      {
    	waitForElementToBeClickable(SelectCreatedOnParameter, longWait);
		clickAndWait(SelectCreatedOnParameter, shortWait);
		Log.info("Clicked on Created On parameter");
		clickAndWait(SelectArrowButton, shortWait);
	  }
      
      public boolean verifySelectedParameter()
      {
      	boolean status = false;
      	if(getElementIfVisibleUsingXpath(CreatedOnInSelectedParameter, longWait))
      	{
      		status = true;
      	}
      	Log.info("Selected parameter is verified in Selected Parameters section");
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
      
      public void RemoveSelectedParameter()    
      {
    	waitForElementToBeClickable(CreatedOnInSelectedParameter, longWait);
		clickAndWait(CreatedOnInSelectedParameter, longWait);
		clickAndWait(CreatedOnInSelectedParameter, longWait);
		//waitForElementToBeClickable(DeselectArrowButton, longWait);
		clickAndWait(DeselectArrowButton, longWait);
		Log.info("Parameter is removed");	
	  }
      
      public boolean verifySelectedParametersRemoved()
      {
      	boolean status = false;
      	if(getElementIfVisibleUsingXpath(CreatedOnInSelectedParameter, longWait))
      	{
      		status = true;
      	}
      	Log.info("Selected parameters are removed");
  		return status;    	
      }
      
 
      public void SelectMultipleParameters()    
      {
    	waitForElementToBeClickable(SelectDefaultConditionParameter, longWait);
		clickAndWait(SelectDefaultConditionParameter, shortWait);
		Log.info("Clicked on Default Condition parameter");
		clickAndWait(SelectArrowButton, shortWait);
		
		waitForElementToBeClickable(SelectEquipmentDescParameter, longWait);
		clickAndWait(SelectEquipmentDescParameter, shortWait);
		Log.info("Clicked on Equipment Desc. parameter");
		clickAndWait(SelectArrowButton, shortWait);     	
	  }
      
      public int countoptions() 
      {  
    	  getElementCountIfPresent(CountOptionInSelected);  
    	  Log.info("Size is "+getElementCountIfPresent(CountOptionInSelected));
    	  return getElementCountIfPresent(CountOptionInSelected);
      }
      
      public boolean verifyCountOptionsInSelectedParameter(int totaloptions) 
      {  
    	  boolean status= false;
    	  if(getElementCountIfPresent(CountOptionInSelected)>1 && getElementCountIfPresent(CountOptionInSelected)==totaloptions);
    	  {
    		  status=true;
    	  }
    	  Log.info("Count is pass");
    	  return status;  
      }
      
      public void RemoveParametersFromSelectedParametersSection()    
      {
    	TestUtils.sleep(2);
    	waitForElementToBeClickable(EquipmentDescInSelectedParameters, longWait);
  		clickAndWait(EquipmentDescInSelectedParameters, longWait);
  		clickAndWait(EquipmentDescInSelectedParameters, longWait);
  		waitForElementToBeClickable(DeselectArrowButton, longWait);
  		clickAndWait(DeselectArrowButton, shortWait);
  		Log.info("Eq. Condition Point parameter is removed");	
	  
    	 TestUtils.sleep(4);
    	waitForElementToBeClickable(DefaultConditionInSelectedParameters, longWait);
		clickAndWait(DefaultConditionInSelectedParameters, longWait);
		//clickAndWait(DefaultConditionInSelectedParameters, longWait);
		waitForElementToBeClickable(DeselectArrowButton, longWait);
		clickAndWait(DeselectArrowButton, shortWait);
		Log.info("Default Condition parameter is removed");	
		
		 TestUtils.sleep(4);
	    waitForElementToBeClickable(DefaultConditionInSelectedParameters, longWait);
		clickAndWait(DefaultConditionInSelectedParameters, longWait);
		//clickAndWait(DefaultConditionInSelectedParameters, longWait);
		waitForElementToBeClickable(DeselectArrowButton, longWait);
		clickAndWait(DeselectArrowButton, shortWait);
		Log.info("Default Condition parameter is removed");
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
      
      
      public void selectValueFromEntityDropDownMenu()
      {
    	  selectByCompleteVisibleText(EntityDropDownMenu, DataUtils.getTestData1("CreateView", "Entity", "Option1")); 
    	  Log.info("Entity drop down menu is clicked and value selected");
      }
      
      
      public void selectValueFromSubViewDropDownMenu()
      {
    	  selectByCompleteVisibleText(SubViewDropDrownMenu, DataUtils.getTestData1("CreateView", "SubView", "Option1"));
    	  Log.info("Sub-view drop down menu is clicked and value selected");
      }
      
      
      public boolean VerifyDeleteIconWithView()
      {
      boolean status = false;
		if (getElementIfVisibleUsingXpath(deleteIcon, longWait)) 
		{	
			status = true;
		}
		Log.info("Delete icon is present");
		return status;
      }
      
      
      
      public void clickOnIndividualView()
      {
    	  clickAndWait(IndividualView, longWait);
    	  TestUtils.sleep(5);
    	 // clickAndWait(IndividualView, longWait);
    	  Log.info("View was clicked");
      }
      
      
      public boolean VerifyIndividualView()
      {
      boolean status = false;
		if (getElementIfVisibleUsingXpath(IndividualView, longWait)) 
		{
			
			status = true;
		}
		Log.info("View is present");
		return status;
      }
      
      
      public void deleteTheView()
      {
    	  clickAndWait(deleteIcon, longWait);
    	  Log.info("The view was deleted successfully");
      }
      
      
      public boolean hideIconOfDefaultView() 
      {
    	  clickAndWait(DefaultMaintClassView, longWait);
    	  Log.info("Defaul tMaint Class View was clicked");
    	  
    	  boolean status = false;
    	    if(getElementIfVisibleUsingXpath(hideIconOfDefaultMaintClassView, longWait))
    	    {
    	    	status = true;
    	    }
    	    Log.info("Hide Button is present with default view");
    	    return status;
      }
      
      public void ClickOnDefaultMaintClassView()
      {
    	  clickAndWait(DefaultMaintClassView, longWait);
    	  Log.info("Default Maint Class View was clicked");
      }
      
      
      
      
      public void ClickToHideAView()
      {
    	  clickAndWait(DefaultMaintClassView, longWait);
    	  Log.info("Default Maint Class View was clicked");
    	  
    	  clickAndWait(hideIconOfDefaultMaintClassView, longWait);
    	  Log.info("Eye Icon was clicked");
    	  
    	  clickAndWait(hideButtonOfAView, longWait);
    	  Log.info("Hide Icon was clicked");
    	  
      }
      
      
      public void HideIconOnViewLeftPanel() 
      {  
    	  TestUtils.sleep(3);
    	  By ClosedEyeHideIcon= By.xpath("//div[text()='Views']/div");
    	  		//isElementPresent(ClosedEyeHideIcon);	  
    	  		javascriptButtonClick(ClosedEyeHideIcon);
    	  		
    	  		//clickAndWait(ClosedEyeHideIcon, longWait);
    	  		TestUtils.sleep(2);
//    	  		By OpenEyeHideIcon= By.xpath("//div[text()='Views']//span[2]//following-sibling::div");
//    	  		isElementPresent(OpenEyeHideIcon);  	  		
      }
      
      
      public boolean hiddenView()
      {
    	  boolean status = false;
    	  if(getElementIfVisibleUsingXpath(hiddenDefaultMaintClassView, longWait))
  	    {
  	    	status = true;
  	    }
    	 
  	    Log.info("Hidden view is present in VIEWS left panel");
  	    return status;
      }
      

      public void clickOnHideIconViewLeftPanel()
      {
    	  clickAndWait(openEyeHideButtonOnViewLeftPanel, longWait);
    	  Log.info("Eye icon was clicked on Views left panel");
    	  TestUtils.sleep(3);
      }
      
      
      public void clickOnHideiconOfHiddenView()
      {     	  
    	 List<WebElement> mouserToHover = getElementsIfPresent(hiddenViewNameToHover);
    	loop:
    	 for(WebElement el: mouserToHover) {
    	 clickAndWait(hiddenViewNameToHover, shortWait);
    		// javascriptButtonClick(el);
    	 clickAndWait(eyeIconOfHiddenView, shortWait);
    	 // clickAndWait(eyeIconOfHiddenView, longWait);
    	  break loop;	  
          }
    	 TestUtils.sleep(4);
    	 System.out.println("Hide icon is clicked");
	  }
      
      
     public void clickOnShowBttn()
      {
    	  TestUtils.sleep(3);
    	  clickAndWait(showBttn, longWait);
    	  Log.info("Show button was clicked");
      }
      
      
      
		/*
		 * Point coordinates = driver.get().findElement(By.
		 * xpath("//div[@class='halflings-icon eye-close floatLeft']")).getLocation();
		 * Robot robot; try { robot = new Robot();
		 * robot.mouseMove(coordinates.getX(),coordinates.getY()); TestUtils.sleep(10);
		 * } catch (AWTException e1) { e1.printStackTrace(); }
		 */
//    	  clickAndWait(eyeIconOfHiddenView, longWait);
//    	 TestUtils.sleep(10);
//    	 System.out.println("------------------------------------------------>");
    	  //getBasicControllersPage().clickOnDesiredView("Default Maint Class View");
    	  
//    	  waitForElementToBeClickable(eyeIconOfHiddenView, shortWait);
//    	  javascriptButtonClick(eyeIconOfHiddenView);
//    	  Log.info("Eye icon of hidden view was clicked");
    	  
    	 //clickAndWait(hiddenDefaultMaintClassView, longWait);
    	  
//    	  clickAndWait(showBttnOfHiddenView, longWait);
//    	  Log.info("Show button was clicked successfully");	 
    	  
    	  
    	  
    	  
      
      
      
      public void hovertoanelement(By locator)
      {
    	  WebElement el=driver.get().findElement(locator);	     
      }
      

      public void f1()
       {
    	 verifyCloneIcon("TestView");
       }
      
      
      
      
      public void verifyCloneIcon(String NameOfView)
  	  {
  		By CloneIcon= By.xpath("//div[@class='view-column-title']//span[contains(text(),'"+NameOfView+"')]//parent::div//following-sibling::div[@title='Clone']");
  		isElementPresent(CloneIcon); 		
  	  }
      
    public boolean CloneIcon()
    {
    	  boolean status = false;
    	  if(getElementIfVisibleUsingXpath(CloneIconOfDefaultMaintClassView, longWait))
  	    {
  	    	status = true;
  	    }
    	 
  	    Log.info("Clone Icon is present with Default Maint Class View");
  	    return status;	
    }
    
    
    public boolean ReOrderIcon()
    {
    	  boolean status = false;
    	  if(getElementIfVisibleUsingXpath(ReOrderIconOfDefaultMaintClassView, longWait))
  	       {
  	    	status = true;
  	       }
    	 
  	    Log.info("Re-Order Icon is present with Default Maint Class View");
  	    return status;	
    }
    
    
    public void ReOrderOperation() throws AWTException
    {
    	WebElement Image1 = driver.get().findElement(By.xpath("//div[@class='view-column-title']//span[text()='sm21045view']"));
    	WebElement Image2 = driver.get().findElement(By.xpath("//div[@class='view-column-title']//span[text()='Default Maint Class View']//parent::div//following-sibling::div[@title='Re-order views']"));
       
    	 //Used points class to get x and y coordinates of element.
         Point classname1 = Image1.getLocation();
         Point classname2 = Image2.getLocation();
         
         int xcordi1 = classname1.getX();
         int xcordi2 = classname2.getX();
         
         System.out.println("Element's Position from left side"+xcordi1 +" pixels.");
         int ycordi1 = classname1.getY();
         int ycordi2 = classname2.getY();
         System.out.println("Element's Position from top"+ycordi1 +" pixels.");
    		
    	 Robot robot = new Robot ();

         robot.mouseMove(xcordi2, ycordi2);
         robot.keyPress(InputEvent.BUTTON1_MASK);
        
         robot.mouseMove(xcordi1, ycordi1);
         robot.keyRelease(InputEvent.BUTTON1_MASK);
    }
    
    
    
    public String ClickOnAUserCreatedView()
      {
    	clickAndWait(ClickOnAView, longWait);
    	Log.info("User cretaed view was clicked");
		return null;
      }
     
    
    public boolean VerifyGridTitleAfterClickOnAView(String enteredViewName)
	 {
	   getElementIfVisibleUsingXpath(viewNameGridTitle, longWait);
		boolean status = false;
		String actualViewName = getText(viewNameGridTitle);
		
	    Log.info("Actual view name is "+actualViewName);
		String expectedViewNmae = enteredViewName;

		if (actualViewName.equals(expectedViewNmae)) 
		  {
			status = true;
			Log.info("View name verified");
		  }
		return status;
	 }
    
    
    public boolean OptionsAfterClickOnAView()
    {
    	 boolean status = false;
   	  if(getElementIfVisibleUsingXpath(EditOptionForAView, longWait))
   		 getElementIfVisibleUsingXpath(DashboardOptionForAView, longWait);
   	     getElementIfVisibleUsingXpath(WebServicesOptionForAView, longWait);
   	     getElementIfVisibleUsingXpath(ExportOptionForAView, longWait);
    	 getElementIfVisibleUsingXpath(FilteredByOptionForAView, longWait);
    	 getElementIfVisibleUsingXpath(RefreshOptionForAView, longWait);
 	       {
 	    	status = true;
 	       }
 	    Log.info("View options 'Edit, Dashboard, Web Service, Export, Filtered By and Refresh' are present after click on a view");
 	    return status;	
    }
    
    
    public boolean VerifyTooltipForEditOption() throws AWTException
    {
    	WebElement coordinates = driver.get().findElement(By.xpath("//div[@id='view-action-edit']"));
    	
    	Point classname1 = coordinates.getLocation();
    	
    	Robot robot = new Robot();
    	robot.mouseMove(classname1.getX(),classname1.getY());
		return false;	
    }
    
    
    public void ClickOnEditView()
    {
    	clickAndWait(EditOptionForAView, longWait);
    	Log.info("Edit view option was clciked");
    }
    
    
    public String enterTextInDescriptionTextField() 
    {	
		setText(DescriptionOfAView, "Updated", longWait);
		Log.info("Text enetered in Description text field");
		return null;	
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
    
    
    public void clickOnDashboardIcon()
    {
    	clickAndWait(DashBoardIcon, longWait);
    	Log.info("Dashboard icon was clicked");
    }

    
    public boolean verifyDashboardPage()
    {
    	  boolean status = false;
    	  if(getElementIfVisibleUsingXpath(dashboardPage, longWait))
  	    {
  	    	status = true;
  	    }
    	 
  	    Log.info("Dashboard page is present");
  	    return status;	
    }
    
    
    public void selectValueInDisplayTypeDropDown()
    {
  	  selectByCompleteVisibleText(displayTypeDropDown, DataUtils.getTestData1("CreateView", "Display Type", "Option2"));
  	  Log.info("Value is selected in Display Type drop down menu");
    }
    
    
    
    
    
} 