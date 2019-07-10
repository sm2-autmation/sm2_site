package com.eaf.qa.uitests;

import java.awt.AWTException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.eaf.qa.cloudops.pages.MaintenanceClassPage;
import com.eaf.qa.utils.TestUtils;
import com.relevantcodes.extentreports.LogStatus;

public class MaintenanceClassTest extends BaseTest {

	private static Logger Log = LogManager.getLogger(MaintenanceClassTest.class.getName());
	    

	
		@Test(enabled = true, description = "To verify Maintenance Classes Create New view form", groups = { "UITestsAdmin", "Login" }, retryAnalyzer= com.eaf.qa.base.RetryAnalyzer.class)
		public void verifyMaintenanceClassesSubTabCreateNewViewForm()
		{
			test = extent.startTest("Verify elements on cretae new view for Maintenance class");
						
			test.log(LogStatus.INFO, "Successfully logged in as Admin");
			pages.getLoginPage().logInToSM2("Admin", "fz;1234");
			
			//test.log(LogStatus.INFO, "Maintenance Tab verified");
			//pages.getMaintenanceClassPage().VerifyMaintenanceTab();
			
			test.log(LogStatus.INFO, "Maintenance Tab verified");
			actions.verify(pages.getMaintenanceClassPage().VerifyMaintenanceTab(), true, "Maintenance tab is not present");
			
			test.log(LogStatus.INFO, "Maintenance classes tab was clicked");
			pages.getMaintenanceClassPage().clickOnMaintenance();
			
			test.log(LogStatus.INFO, "Maintenance classes sub tab was clicked");
			pages.getMaintenanceClassPage().clickOnMaintenanceClasses();
			
			test.log(LogStatus.INFO, "Create New View plus icon was present");
			actions.verify(pages.getMaintenanceClassPage().verifyIconForCreateNewView(), true, "Create new view icon for maintenence class is not present");
			 
			// Click on Create New View "+" icon
			test.log(LogStatus.INFO, "Plus icon for create new view icon was clicked");
			pages.getMaintenanceClassPage().clickOnCreateNewViewIcon();
			
			// Verify Name text field on Create View page
			test.log(LogStatus.INFO, "Name text filed verified");
			actions.verify(pages.getMaintenanceClassPage().verifyNameTextField(), true, "Create View Name text filed is not available");
			
			// Click action on Export Options
			test.log(LogStatus.INFO, "Export option was clicked");
			pages.getMaintenanceClassPage().ClickOnExportOptions();
			
			// Verify Export Options text on page	
			test.log(LogStatus.INFO, "Export option text was verified");
			actions.verify(pages.getMaintenanceClassPage().VerifyExportOptionsText(), true, "Export options text is not present on the page");
			
			// Verify file type drop down menu
			test.log(LogStatus.INFO, "File Type text was present on Export options page");
			actions.verify(pages.getMaintenanceClassPage().VerifyFileTypeText(), true, "File Type text for drop down menu is not present");
			
			// Verify Encoding text
			test.log(LogStatus.INFO, "Encoding text was present on Export options page");
			actions.verify(pages.getMaintenanceClassPage().VerifyEncodingText(), true, "Encoding text for drop doen menu is not available");
			
			test.log(LogStatus.INFO, "Separator text was present on Export options page");
			actions.verify(pages.getMaintenanceClassPage().VerifySeparatorText(), true, "Separator text is not available on Export Options page");
			
			test.log(LogStatus.INFO, "Separator text was present on Export options page");
			actions.verify(pages.getMaintenanceClassPage().VerifyDelimiterText(), true, "Delimiter text is not available on Export Options page");
		
			//actions.verify(pages.getMaintenanceClassPage().verifySubViewDropDownIsDisabled(), false, "Su-view drop down is not disabled");
			
			// Verify Available Parameters section
			test.log(LogStatus.INFO, "Available Parameters section was present on create View page");
			actions.verify(pages.getMaintenanceClassPage().VerifyAvailableParametersSection(), true, "Available Parameters section is not present on create view page");
			
			// Verify Selected Parameters section
			test.log(LogStatus.INFO, "Selected Parameters section was present on create View page");
			actions.verify(pages.getMaintenanceClassPage().VerifySelectedParametersSection(), true, "Selected Parameters section is not present on create view page");
			
			// Verify DisplayTab under Selected Parameter section
			test.log(LogStatus.INFO, "'Display tab' is present under Selected Parameters section on create View page");
			actions.verify(pages.getMaintenanceClassPage().verifyDisplayTabUnderSelectedParametersSection(), true, "Display tab is not present under Selected Parameters section");
			
			// Verify Filtered by tab is present under Selected Parameter section
			test.log(LogStatus.INFO, "'Filtered by' tab is present under Selected Parameters section on create View page");
			actions.verify(pages.getMaintenanceClassPage().verifyFilteredByTabUnderSelectedParametersSection(), true, "Filtered by tab is not present under Selected Parameters section");
			
			// Verify Sort By tab is present under Selected Parameter section
			test.log(LogStatus.INFO, "'Sort By' tab is present under Selected Parameters section on create View page");
			actions.verify(pages.getMaintenanceClassPage().verifySortByTabUnderSelectedParametersSection(), true, "Sort By tab is not present under Selected Parameters section");
			
			// Verify Select Arrow Button
			test.log(LogStatus.INFO, "Select arrow button (>) was present between Available Parameters and Selected Parameters section");
			actions.verify(pages.getMaintenanceClassPage().VerifySelectArrowButton(), true, "Select Arrow button is not available in between Available parameters and selected parameters");
            
			// Verify DeSelect Arrow button
			test.log(LogStatus.INFO, "DeSelect arrow button (<) was present between Available Parameters and Selected Parameters section");
			actions.verify(pages.getMaintenanceClassPage().VerifyDeSelectArrowButton(), true, "Deselect button is not present on Create View page");
			
			// Verify ReOrder up arrow button
			test.log(LogStatus.INFO, "Reorder Up Arrow button was present between Available Parameters and Selected Parameters section");
			actions.verify(pages.getMaintenanceClassPage().VerifyReorderUpArrowButton(), true, "ReOrder up arrow button is not present on Create View page");
			
			// Verify ReOrder down arrow button
			test.log(LogStatus.INFO, "Reorder Down Arrow button was present between Available Parameters and Selected Parameters section");
			actions.verify(pages.getMaintenanceClassPage().VerifyReorderDownArrowButton(), true, "ReOrder down arrow button is not present on Create View page");
			
			// Verify Aggregate drop down is not present on page after removed all selected parameters
			test.log(LogStatus.INFO, "Aggregate drop down is present after selection of a parameter");
			actions.verify(pages.getMaintenanceClassPage().verifyAggregateDropDownNotPresent(), true, "Aggregate drop down is present on Create View page");
			 
			 Reporter.log("Elements of Maintenance class is verifiied");
			test.log(LogStatus.PASS, " Create new view form is verified under Maintenence class");
		}
		
		@Test(enabled = true, description = "Click action on elements of cretae new view of Maintenance classes", groups = { "UITestsAdmin", "Login" }, retryAnalyzer= com.eaf.qa.base.RetryAnalyzer.class)
		public void clickActionsOnMaintenanceClassesSubTab() throws AWTException 
		{
			test = extent.startTest("Verify elements on cretae new view for Maintenance class");
				
			// Login Credentials
			test.log(LogStatus.INFO, "Successfully logged in as Admin");
			pages.getLoginPage().logInToSM2("Admin", "fz;1234");
			
			//pages.getMaintenanceClassPage().VerifyMaintenanceTab();
			
			// Verify Maintenance tab
			test.log(LogStatus.INFO, "Maintenance Tab verified");
			actions.verify(pages.getMaintenanceClassPage().VerifyMaintenanceTab(), true, "Maintenance tab is not present");
			
			// Click on Maintenance tab
			test.log(LogStatus.INFO, "Maintenance tab was clicked");
			pages.getMaintenanceClassPage().clickOnMaintenance();
			
			// Click On Maintenance Classes
			test.log(LogStatus.INFO, "Maintenance classes tab was clicked");
			pages.getMaintenanceClassPage().clickOnMaintenanceClasses();
			
			//actions.verify(pages.getMaintenanceClassPage().verifyTooltipForMP(), true, "tooltip not appearing");
			
			// Click on Create New View "+" icon	
			test.log(LogStatus.INFO, "Plus icon for create new view icon was clicked");
			pages.getMaintenanceClassPage().clickOnCreateNewViewIcon();
			
			// Enter text in the text field
			test.log(LogStatus.INFO, "Text entered in Name Text field");
			pages.getMaintenanceClassPage().enterTextInNameField();

			// Verify Save button without selecting any parameter
			test.log(LogStatus.INFO, "Save button was clicked without selecting any parameter");
			pages.getMaintenanceClassPage().clickOnSaveButton();
			
			// Verify Cancel button without selecting any parameter
			test.log(LogStatus.INFO, "Cancel button was clicked without selecting any parameter");
			pages.getMaintenanceClassPage().clickOnCancelButtonWithoutParameter();
			
			// Click on Create New View "+" icon
			test.log(LogStatus.INFO, "Create new view icon was clicked");
			pages.getMaintenanceClassPage().clickOnCreateNewViewIcon();
						
			// Enter text in the text field
			test.log(LogStatus.INFO, "Text entered in Name Text field");
			pages.getMaintenanceClassPage().enterTextInNameField();
					
			// Check and Verify Is Default Check Box On Create View Page
			test.log(LogStatus.INFO, "Is Default check box was verified");
			actions.verify(pages.getMaintenanceClassPage().clickAndVerifyIsDefaultCheckBox(), true, "Is Default check box is not selected after click on respected check box");
			
			// Check and Verify Shared Check Box On Create View Page
			test.log(LogStatus.INFO, "Shared CheckBox was verified");
			actions.verify(pages.getMaintenanceClassPage().clickAndVerifySharedCheckBox(), true, "Shared check box is not selected after click on respected check box");
			
			// Click action on Export Options
			test.log(LogStatus.INFO, "'Export Options' was clicked");
			pages.getMaintenanceClassPage().ClickOnExportOptions();
			
			// Click and Verify header check box
			test.log(LogStatus.INFO, "'Header CheckBox was verified and clicked");
			actions.verify(pages.getMaintenanceClassPage().clickAndVerifyHeaderCheckBox(), true, "Header check box is not selected after click on check box");
					
			//click On Export Options To Hide
			test.log(LogStatus.INFO, "'Export Options' was clicked to hide");
		    pages.getMaintenanceClassPage().clickOnExportOptionsToHide();
		    
		    // Click on Display Tab under Selected Parameters section
		    test.log(LogStatus.INFO, "'Display' tab was clicked  under Selected Parameters");
		    pages.getMaintenanceClassPage().clickOnDisplayTab();
		    
		    // Click on Filtered by tab under Selected Parameters section
		    test.log(LogStatus.INFO, "'Filtered by' tab was clicked under Selected Parameters");
		 	pages.getMaintenanceClassPage().clickOnFilteredByTab();
		 		
		 	// Click on Sort By tab under Selected Parameters section
		 	test.log(LogStatus.INFO, "'Sort By' tab was clicked under Selected Parameters");
			pages.getMaintenanceClassPage().clickOnSortByTab();
			
			// Again Click on Display Tab under Selected Parameters section
			test.log(LogStatus.INFO, "'Display' tab was clicked under Selected Parameters");
			pages.getMaintenanceClassPage().clickOnDisplayTab();
		 		
			// Click on Created On parameter and click on Select arrow button
			test.log(LogStatus.INFO, "'Created On' parameter is selected");
			pages.getMaintenanceClassPage().SelectCreatedOnParameters();
			
			// Verify selected parameter in Selected Parameters section
			test.log(LogStatus.INFO, "'Selected Parameters' was verified");
			actions.verify(pages.getMaintenanceClassPage().verifySelectedParameter(), true, "Selected parameter is not present in Selected Parameters section");
			
			// Verify Aggregate drop down menu
			test.log(LogStatus.INFO, "'Aggregate' drop down was verified");
			actions.verify(pages.getMaintenanceClassPage().verifyAggregateDropDown(), true, "Aggregate drtop down menu is not available");
			TestUtils.sleep(2);
			
			// select Value from Aggregate drop down menu
			test.log(LogStatus.INFO, "Value is selected from Aggregate drop down menu");
			pages.getMaintenanceClassPage().selectValueInAggregateDropDownMenu();
				    
			// Remove selected parameter from Selected Parameters section
			test.log(LogStatus.INFO, "Selected parameter was removed");
		    pages.getMaintenanceClassPage().RemoveSelectedParameter();
			    
			// Click on Created On parameter and click on Select arrow button
		    test.log(LogStatus.INFO, "'Created On' parameter is selected");
		    pages.getMaintenanceClassPage().SelectCreatedOnParameters();
					
			// Select multiple parameters
		    test.log(LogStatus.INFO, "Multiple parameters were selected in 'Selected Parameters'");
			pages.getMaintenanceClassPage().SelectMultipleParameters();
			
			// Count options in selected parameters sections
			test.log(LogStatus.INFO, "Total number in 'Selected Parameters' section was counted ");
			int totalOptions= pages.getMaintenanceClassPage().countoptions();		
			actions.verify(pages.getMaintenanceClassPage().verifyCountOptionsInSelectedParameter(totalOptions), true, "Expected total number of options is not coming in selected parameter");
			Log.info("Count is pass");
			
			// Remove parameters from Selected Parameters section	
			test.log(LogStatus.INFO, "Parameter was removed from 'Selected Parameters' section");
			pages.getMaintenanceClassPage().RemoveParametersFromSelectedParametersSection();
				
			// Verify selected parameter removed from Selected Parameters
			test.log(LogStatus.INFO, "Selected parameters were reomoved");
			actions.verify(pages.getMaintenanceClassPage().verifySelectedParametersRemoved(), false, "Parameter selected in Selected Parameters is available");
			  
			// Click on entity drop down
			test.log(LogStatus.INFO, "Value selected from Entity drop down menu");
			pages.getMaintenanceClassPage().selectValueFromEntityDropDownMenu();
			    
			// Click and select value from Sub-View drop down
			test.log(LogStatus.INFO, "Value selected from Sub-View drop down menu");
			pages.getMaintenanceClassPage().selectValueFromSubViewDropDownMenu();
			
			Reporter.log("Click action performed on create new view form");
		    test.log(LogStatus.PASS, "Functionality on Cretae New View form was performed");
			
			
		}	
		
		@Test(enabled = true, description = "To verify Create a new view", groups = { "UITestsAdmin", "Login" })
		public void createNewView() throws AWTException
		{
			test = extent.startTest("Cretae new view for Maintenance class");
			
			            // Login Credentials
			            test.log(LogStatus.INFO, "Successfully logged in as Admin");
						pages.getLoginPage().logInToSM2("Admin", "fz;1234");

						//pages.getMaintenanceClassPage().VerifyMaintenanceTab();
						
						// Verify Maintenance tab
						test.log(LogStatus.INFO, "Maintenance Tab verified");
						actions.verify(pages.getMaintenanceClassPage().VerifyMaintenanceTab(), true, "Maintenance tab is not present");
						
						// Click on Maintenance tab
						test.log(LogStatus.INFO, "Maintenance Tab was Clicked");
						pages.getMaintenanceClassPage().clickOnMaintenance();
						
						// Click On Maintenance Classes
						test.log(LogStatus.INFO, "Maintenance Classes  Sub-Tab was Clicked");
						pages.getMaintenanceClassPage().clickOnMaintenanceClasses();
						
						//actions.verify(pages.getMaintenanceClassPage().verifyTooltipForMP(), true, "tooltip not appearing");
				
						// Click on Create New View "+" icon
						test.log(LogStatus.INFO, "Create New View Icon was Clicked");
						pages.getMaintenanceClassPage().clickOnCreateNewViewIcon();

						// Enter text in the text field
						test.log(LogStatus.INFO, "Text entered in Name Text field");
						pages.getMaintenanceClassPage().enterTextInNameField();
									
						// Click on "Created On" parameter and click on Select arrow button
						test.log(LogStatus.INFO, "'Created On' parameter is selected");
					    pages.getMaintenanceClassPage().SelectCreatedOnParameters();
					    TestUtils.sleep(2);
					    
						// Verify Save button without selecting any parameter
					    test.log(LogStatus.INFO, "Save button was clicked");
						pages.getMaintenanceClassPage().clickOnSaveButton();
						TestUtils.sleep(2);				
						
						Reporter.log("New view was cretaed");
						test.log(LogStatus.PASS, "A view was created");
        }
		

		@Test(enabled = true, description = "To verify newely created view", groups = { "UITestsAdmin", "Login" })
		public void verifyNewelyCreatedView()
		{
			test = extent.startTest("Verify newely created view for Maintenance classes");

			// Login Credentials	
            test.log(LogStatus.INFO, "Successfully logged in as Admin");
			pages.getLoginPage().logInToSM2("Admin", "fz;1234");
			
			pages.getMaintenanceClassPage().VerifyMaintenanceTab();
			
			// Verify Maintenance tab
			test.log(LogStatus.INFO, "Maintenance Tab verified");
			actions.verify(pages.getMaintenanceClassPage().VerifyMaintenanceTab(), true, "Maintenance tab is not present");
			
			// Click on Maintenance tab
			test.log(LogStatus.INFO, "Maintenance Tab was clicked");
			pages.getMaintenanceClassPage().clickOnMaintenance();
			
			// Click On Maintenance Classes
			test.log(LogStatus.INFO, "Maintenance classes Sub-Tab was clicked");
			pages.getMaintenanceClassPage().clickOnMaintenanceClasses();
			
			// Click on Create New View "+" icon
			test.log(LogStatus.INFO, "Create New View Icon was Clicked");
			pages.getMaintenanceClassPage().clickOnCreateNewViewIcon();
						
			// Enter text in the text field
			test.log(LogStatus.INFO, "Text entered in Name Text field");
			String viewName =  pages.getMaintenanceClassPage().enterTextInNameField();
			Log.info("Entered name is "+viewName);
						
			// Click on "Created On" parameter and click on Select arrow button		
			test.log(LogStatus.INFO, "'Created On' parameter is selected");
		    pages.getMaintenanceClassPage().SelectCreatedOnParameters();
		    TestUtils.sleep(2);
		    
			// Click Save button to create a new view
		    test.log(LogStatus.INFO, "Save button was clicked");
			pages.getMaintenanceClassPage().clickOnSaveButton();
			
			// Verify title of newly created view on details page just after creation of view
			test.log(LogStatus.INFO, "Grid Title is shown after creation of a New View");
			actions.verify(pages.getMaintenanceClassPage().VerifyGridTitleAfterCreationOfNewView(viewName), true, "View Name is not matched");	
		
			Reporter.log("Grid title is shown after creation of new view");
			test.log(LogStatus.PASS, "Grid Title is shown");
			
		}
		
		
		@Test(enabled = true, description = "To verify Delete a view on Maintenance classes sub tab", groups = { "UITestsAdmin", "Login" })
		public void verifyDeleteIconWithUserCreatedView()
		{
			test = extent.startTest("Verify delete Icon with user created view for Maintenance classes");
			
			// Login Credentials
			test.log(LogStatus.INFO, "Successfully logged in as Admin");
			pages.getLoginPage().logInToSM2("Admin", "fz;1234");
			
			//pages.getMaintenanceClassPage().VerifyMaintenanceTab();
			
			// Verify Maintenance tab
			test.log(LogStatus.INFO, "Maintenance Tab verified");
			actions.verify(pages.getMaintenanceClassPage().VerifyMaintenanceTab(), true, "Maintenance tab is not present");
			
			// Click on Maintenance tab
			test.log(LogStatus.INFO, "Maintenance Tab was clicked");
			pages.getMaintenanceClassPage().clickOnMaintenance();
			
			// Click On Maintenance Classes
			test.log(LogStatus.INFO, "Maintenance Classes Sub-Tab was clicked");
			pages.getMaintenanceClassPage().clickOnMaintenanceClasses();
			
			// Verify a view from views left panel
			test.log(LogStatus.INFO, "An individual view was verified");
			actions.verify(pages.getMaintenanceClassPage().VerifyIndividualView(), true, "View is not present");
			
			test.log(LogStatus.INFO, "An Individual view was clicked");
			pages.getMaintenanceClassPage().clickOnIndividualView();
			
			
			
			// Verify delete icon with user created view
			test.log(LogStatus.INFO, "Delete icon is present witha user created view ");
			actions.verify(pages.getMaintenanceClassPage().VerifyDeleteIconWithView(), true, "Delete icon is not present");

            // Delete a view from view left panel of Maintenance classes
			//pages.getMaintenanceClassPage().deleteTheView();	
			
			Reporter.log("Delete icon is verified with a user created view");
			test.log(LogStatus.PASS, "Delete icon is present with a user created view");
		}
		
		
		@Test(enabled = true, description = "To verify hide icon for a view on Maintenance classes sub tab", groups = { "UITestsAdmin", "Login" })
		public void verifyHideIconWithView()
		{
			test = extent.startTest("Verify Hide icon for a view");
			
			// Login Credentials
			
			pages.getLoginPage().logInToSM2("Admin", "fz;1234");
			
			test.log(LogStatus.INFO, "Maintenance Tab verified");
			pages.getMaintenanceClassPage().VerifyMaintenanceTab();
			
			// Click on Maintenance tab
			test.log(LogStatus.INFO, "Maintenance Tab was clicked");
			pages.getMaintenanceClassPage().clickOnMaintenance();
			
			// Click On Maintenance Classes
			test.log(LogStatus.INFO, "Maintenance Classes Sub-Tab was clicked");
			pages.getMaintenanceClassPage().clickOnMaintenanceClasses();
			
			test.log(LogStatus.INFO, "Hide icon is present with Default view");
			actions.verify(pages.getMaintenanceClassPage().hideIconOfDefaultView(), true, "Hide Icon is not present with default view");
		
			Reporter.log("Hide icon is present with a view");
			test.log(LogStatus.PASS, "Hide Icon is present");
		}
		
		
		@Test(enabled = true, description = "To hide a view on Maintenance classes sub tab", groups = { "UITestsAdmin", "Login" })
		public void HideAndUnhideView()
		{
			test = extent.startTest("Verify delete Icon with user created view for Maintenance classes");

			test.log(LogStatus.INFO, "Successfully logged in as Admin");
			pages.getLoginPage().logInToSM2("Admin", "fz;1234");
			
			test.log(LogStatus.INFO, "Maintenance Tab verified");
			pages.getMaintenanceClassPage().VerifyMaintenanceTab();
			
			test.log(LogStatus.INFO, "Maintenance Tab was clicked");
			pages.getMaintenanceClassPage().clickOnMaintenance();
			
			test.log(LogStatus.INFO, "Maintenance Classes Sub-Tab was clicked");
			pages.getMaintenanceClassPage().clickOnMaintenanceClasses();
			
			test.log(LogStatus.INFO, "Hide icon clicked for a view");
		    pages.getMaintenanceClassPage().ClickToHideAView();
		    
		    test.log(LogStatus.INFO, "Hide icon on view left panel is present");
		    pages.getMaintenanceClassPage().HideIconOnViewLeftPanel();
		    
		    test.log(LogStatus.INFO, "Hidden view is present in Views after click on hide button");
		    actions.verify(pages.getMaintenanceClassPage().hiddenView(), true, "Hidden view is not present inside view left panel");
		    
		    test.log(LogStatus.INFO, "Hide icon was click on  left panel");
		    //pages.getMaintenanceClassPage().clickOnHideIconViewLeftPanel();
		   
		    test.log(LogStatus.INFO, "Hide icon was click for a hidden view");
		    pages.getMaintenanceClassPage().clickOnHideiconOfHiddenView();
		    
		    test.log(LogStatus.INFO, "Show button was clciked");
		    pages.getMaintenanceClassPage().clickOnShowBttn();
		    
		    Reporter.log("Hide/Show action was performed for selected view");
			test.log(LogStatus.PASS, "The view was hide");
		}
		
		
		@Test(enabled = true, description = "Verify Clone Icon for a view in Maintenance classes sub tab", groups =  "CloneIcon")
		public void VerifyCloneIconWithView()
		{
			test = extent.startTest("Verify Clone Icon with view in Maintenance classes");

			// Login Credentials
			test.log(LogStatus.INFO, "Successfully logged in as Admin");
			pages.getLoginPage().logInToSM2("Admin", "fz;1234");
			
			test.log(LogStatus.INFO, "Maintenance Tab verified");
			pages.getMaintenanceClassPage().VerifyMaintenanceTab();
			
			// Click on Maintenance tab
			test.log(LogStatus.INFO, "Maintenance Tab was clicked");
			pages.getMaintenanceClassPage().clickOnMaintenance();
			
			// Click On Maintenance Classes sub-tab
			test.log(LogStatus.INFO, "Maintenance Classes Sub-Tab was clicked");
			pages.getMaintenanceClassPage().clickOnMaintenanceClasses();
			
			// Click on Default Maint Class View
			test.log(LogStatus.INFO, "'Default Maint Class View' was clicked");
		    pages.getMaintenanceClassPage().ClickOnDefaultMaintClassView();
		    
		    // Verify clone icon with view
		    test.log(LogStatus.INFO, "Clone icon is present");
		    actions.verify(pages.getMaintenanceClassPage().CloneIcon(), true, "Clone icon is not present with Default Maint Class view");
		
		    Reporter.log("Clone icon is present with view");
			test.log(LogStatus.PASS, "Clone Icon is present with view");
		    
		}
		
		@Test(enabled = true, description = "Verify Re-Order Icon for a view in Maintenance classes sub tab", groups =  "ReOrderIcon")
		public void VerifyReOrderIconWithView()
		{
			test = extent.startTest("Verify Re-Order Icon with view in Maintenance classes");

			// Login Credentials
			test.log(LogStatus.INFO, "Successfully logged in as Admin");
			pages.getLoginPage().logInToSM2("Admin", "fz;1234");
			
			test.log(LogStatus.INFO, "Maintenance Tab verified");
			pages.getMaintenanceClassPage().VerifyMaintenanceTab();
			
			// Click on Maintenance tab
			test.log(LogStatus.INFO, "Maintenance Tab was clicked");
			pages.getMaintenanceClassPage().clickOnMaintenance();
			
			// Click On Maintenance Classes sub-tab
			test.log(LogStatus.INFO, "Maintenance Classes Sub-Tab was clicked");
			pages.getMaintenanceClassPage().clickOnMaintenanceClasses();
			
			// Click on Default Maint Class View
			test.log(LogStatus.INFO, "'Default Maint Class View' was clicked");
		    pages.getMaintenanceClassPage().ClickOnDefaultMaintClassView();
		    
		    // Verify clone icon with view
		    test.log(LogStatus.INFO, "Clone icon is present");
		    actions.verify(pages.getMaintenanceClassPage().ReOrderIcon(), true, "Re-Order icon is not present with Default Maint Class view");
		
		    Reporter.log("Re-Order icon is present with view");
			test.log(LogStatus.PASS, "Re-Order Icon is present with view");
		    
		}
		
		
		@Test(enabled = true, description = "Verify Re-Order Icon for a view in Maintenance classes sub tab", groups =  "ReOrderIcon")
		public void VerifyReOrderOpertion() throws AWTException
		{
			test = extent.startTest("Verify Re-Order Icon with view in Maintenance classes");

			// Login Credentials
			test.log(LogStatus.INFO, "Successfully logged in as Admin");
			pages.getLoginPage().logInToSM2("Admin", "fz;1234");
			
			test.log(LogStatus.INFO, "Maintenance Tab verified");
			pages.getMaintenanceClassPage().VerifyMaintenanceTab();
			
			// Click on Maintenance tab
			test.log(LogStatus.INFO, "Maintenance Tab was clicked");
			pages.getMaintenanceClassPage().clickOnMaintenance();
			
			// Click On Maintenance Classes sub-tab
			test.log(LogStatus.INFO, "Maintenance Classes Sub-Tab was clicked");
			pages.getMaintenanceClassPage().clickOnMaintenanceClasses();
			
			// Click on Default Maint Class View
			test.log(LogStatus.INFO, "'Default Maint Class View' was clicked");
		    pages.getMaintenanceClassPage().ClickOnDefaultMaintClassView();
		    
		    test.log(LogStatus.INFO, "Re-Order operation is done successfully");
		    pages.getMaintenanceClassPage().ReOrderOperation();
		    
		    Reporter.log("Re-Order operation is done successfully");
			test.log(LogStatus.PASS, "Re-Order operation is Done for a view");	    
		}
		
		
		@Test(enabled = true, description = "Click action on a view in Maintenance classes sub tab", groups =  "ReOrderIcon")
		public void ClickOnAView()
		{
			test = extent.startTest("Verify Re-Order Icon with view in Maintenance classes");

			// Login Credentials
			test.log(LogStatus.INFO, "Successfully logged in as Admin");
			pages.getLoginPage().logInToSM2("Admin", "fz;1234");
			
			test.log(LogStatus.INFO, "Maintenance Tab verified");
			pages.getMaintenanceClassPage().VerifyMaintenanceTab();
			
			// Click on Maintenance tab
			test.log(LogStatus.INFO, "Maintenance Tab was clicked");
			pages.getMaintenanceClassPage().clickOnMaintenance();
			
			// Click On Maintenance Classes sub-tab
			test.log(LogStatus.INFO, "Maintenance Classes Sub-Tab was clicked");
			pages.getMaintenanceClassPage().clickOnMaintenanceClasses();
			
			test.log(LogStatus.INFO, "Click on a user created view");
			String viewName = pages.getMaintenanceClassPage().ClickOnAUserCreatedView();
			
			test.log(LogStatus.INFO, "View name is matched");			
			actions.verify(pages.getMaintenanceClassPage().VerifyGridTitleAfterClickOnAView(viewName), true, "View Name is matched");
			
			Reporter.log("A user created view was clicked");
			test.log(LogStatus.PASS, "A user created view was clicked and it grid is open");
		}
		
		
		@Test(enabled = true, description = "Verifyoptions after click on a view in Maintenance classes sub tab", groups =  "ReOrderIcon")
		public void VerifyViewOptionsAfterClick()
		{
			test = extent.startTest("Verify options after click on a view in Maintenance classes");

			// Login Credentials
			test.log(LogStatus.INFO, "Successfully logged in as Admin");
			pages.getLoginPage().logInToSM2("Admin", "fz;1234");
			
			test.log(LogStatus.INFO, "Maintenance Tab verified");
			pages.getMaintenanceClassPage().VerifyMaintenanceTab();
			
			// Click on Maintenance tab
			test.log(LogStatus.INFO, "Maintenance Tab was clicked");
			pages.getMaintenanceClassPage().clickOnMaintenance();
			
			// Click On Maintenance Classes sub-tab
			test.log(LogStatus.INFO, "Maintenance Classes Sub-Tab was clicked");
			pages.getMaintenanceClassPage().clickOnMaintenanceClasses();
			
			test.log(LogStatus.INFO, "User created view was clicked");
			pages.getMaintenanceClassPage().ClickOnAUserCreatedView();
			
			test.log(LogStatus.INFO, "View options are present after click on a view");			
			actions.verify(pages.getMaintenanceClassPage().OptionsAfterClickOnAView(), true, "Options for a view is not available after click on it");
			
			Reporter.log("View options are present after click");
			test.log(LogStatus.PASS, "View options are present after click on a view");
		}
		
		
		@Test(enabled = true, description = "Verify tooltip for edit option under maintenance classes", groups =  "ReOrderIcon")
		public void VerionsAfterClick() throws AWTException
		{
			test = extent.startTest("Verify tooltip for Edit option of a view in Maintenance classes");

			// Login Credentials
			test.log(LogStatus.INFO, "Successfully logged in as Admin");
			pages.getLoginPage().logInToSM2("Admin", "fz;1234");
			
			test.log(LogStatus.INFO, "Maintenance Tab verified");
			pages.getMaintenanceClassPage().VerifyMaintenanceTab();
			
			// Click on Maintenance tab
			test.log(LogStatus.INFO, "Maintenance Tab was clicked");
			pages.getMaintenanceClassPage().clickOnMaintenance();
			
			// Click On Maintenance Classes sub-tab
			test.log(LogStatus.INFO, "Maintenance Classes Sub-Tab was clicked");
			pages.getMaintenanceClassPage().clickOnMaintenanceClasses();
			
			test.log(LogStatus.INFO, "User created view was clicked");
			pages.getMaintenanceClassPage().ClickOnAUserCreatedView();
			
			test.log(LogStatus.INFO, "View options are present after click on a view");			
			actions.verify(pages.getMaintenanceClassPage().VerifyTooltipForEditOption(), true, "Tooltip for edit option is not showing");
			
			Reporter.log("Tooltip of edit is appear after mouse hover");
			test.log(LogStatus.PASS, "Tooltip is shown");
		}
		
		
		
		@Test(enabled = true, description = "Click on Edit view option under maintenance classes", groups =  "ReOrderIcon")
		public void ClickOnEditViewOption()
		{
			test = extent.startTest("Click on Edit option of a view in Maintenance classes");

			// Login Credentials
			test.log(LogStatus.INFO, "Successfully logged in as Admin");
			pages.getLoginPage().logInToSM2("Admin", "fz;1234");
			
			test.log(LogStatus.INFO, "Maintenance Tab verified");
			pages.getMaintenanceClassPage().VerifyMaintenanceTab();
			
			// Click on Maintenance tab
			test.log(LogStatus.INFO, "Maintenance Tab was clicked");
			pages.getMaintenanceClassPage().clickOnMaintenance();
			
			// Click On Maintenance Classes sub-tab
			test.log(LogStatus.INFO, "Maintenance Classes Sub-Tab was clicked");
			pages.getMaintenanceClassPage().clickOnMaintenanceClasses();
			
			test.log(LogStatus.INFO, "User created view was clicked");
			pages.getMaintenanceClassPage().ClickOnAUserCreatedView();
			
			test.log(LogStatus.INFO, "Edit View option was Clicked");			
			pages.getMaintenanceClassPage().ClickOnEditView();
			
			Reporter.log("Edit view option was clicked ");
			test.log(LogStatus.PASS, "Edit view option was clicked");
		}
		
		
		
		@Test(enabled = true, description = "Update Description for a view under maintenance classes", groups =  "ReOrderIcon")
		public void ClickOnEditViewOptionAndUpdateDescription()
		{
			test = extent.startTest("Click on Edit option of a view in Maintenance classes");

			// Login Credentials
			test.log(LogStatus.INFO, "Successfully logged in as Admin");
			pages.getLoginPage().logInToSM2("Admin", "fz;1234");
			
			test.log(LogStatus.INFO, "Maintenance Tab verified");
			pages.getMaintenanceClassPage().VerifyMaintenanceTab();
			
			// Click on Maintenance tab
			test.log(LogStatus.INFO, "Maintenance Tab was clicked");
			pages.getMaintenanceClassPage().clickOnMaintenance();
			
			// Click On Maintenance Classes sub-tab
			test.log(LogStatus.INFO, "Maintenance Classes Sub-Tab was clicked");
			pages.getMaintenanceClassPage().clickOnMaintenanceClasses();
			
			test.log(LogStatus.INFO, "User created view was clicked");
			pages.getMaintenanceClassPage().ClickOnAUserCreatedView();
			
			test.log(LogStatus.INFO, "Edit View option was Clicked");			
			pages.getMaintenanceClassPage().ClickOnEditView();
			
			test.log(LogStatus.INFO, "Test was entered in Description text field");
			pages.getMaintenanceClassPage().enterTextInDescriptionTextField();
			TestUtils.sleep(5);
			
			test.log(LogStatus.INFO, "Save button was clicked");
			pages.getMaintenanceClassPage().clickOnSaveButton();
			
			Reporter.log("Description text field was updated ");
			test.log(LogStatus.PASS, "Description text field was updated");
		}
		
		
		@Test(enabled = true, description = "Dashboard icon for a view under maintenance classes", groups =  "ReOrderIcon")
		public void VerifyDashboardOption()
		{
			test = extent.startTest("Dashboard icon of a view in Maintenance classes");

			// Login Credentials
			test.log(LogStatus.INFO, "Successfully logged in as Admin");
			pages.getLoginPage().logInToSM2("Admin", "fz;1234");
			
			test.log(LogStatus.INFO, "Maintenance Tab verified");
			pages.getMaintenanceClassPage().VerifyMaintenanceTab();
			
			// Click on Maintenance tab
			test.log(LogStatus.INFO, "Maintenance Tab was clicked");
			pages.getMaintenanceClassPage().clickOnMaintenance();
			
			// Click On Maintenance Classes sub-tab
			test.log(LogStatus.INFO, "Maintenance Classes Sub-Tab was clicked");
			pages.getMaintenanceClassPage().clickOnMaintenanceClasses();
			
			test.log(LogStatus.INFO, "User created view was clicked");
			pages.getMaintenanceClassPage().ClickOnAUserCreatedView();
			
			test.log(LogStatus.INFO, "Dashboard icon is present");
			actions.verify(pages.getMaintenanceClassPage().VerifyDashboardIcon(), true, "Dashboard icon is not present");
			
			test.log(LogStatus.INFO, "User created view is not disabled");
			actions.verify(pages.getMaintenanceClassPage().verifyDashboardIconEnabled(), true, "Dashboard icon is not disabled for user created view");
			
			test.log(LogStatus.INFO, "Dashboard icon is clicked");
			pages.getMaintenanceClassPage().clickOnDashboardIcon();
			
			test.log(LogStatus.INFO, "Dashboard page is present");
			actions.verify(pages.getMaintenanceClassPage().verifyDashboardPage(), true, "Dashboard page is not present");
			
			test.log(LogStatus.INFO, "Display Type drop down was clicked and value selected");
			pages.getMaintenanceClassPage().selectValueInDisplayTypeDropDown();
			
			Reporter.log("Dashboard icon is available and enabled with user created view ");
			test.log(LogStatus.PASS, "Dashboard icon and dashboard page is verified");
		}
		
		
		
		
		
		
		
		
		
	}