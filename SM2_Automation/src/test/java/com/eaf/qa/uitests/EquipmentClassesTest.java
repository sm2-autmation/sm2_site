package com.eaf.qa.uitests;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.eaf.qa.cloudops.pages.LoginPage;
import com.relevantcodes.extentreports.LogStatus;

public class EquipmentClassesTest extends BaseTest
{
	private static Logger Log = LogManager.getLogger(LoginPage.class.getName());

	
	@Test(enabled=true, description = "Equipment Classes cretae new view form ", retryAnalyzer= com.eaf.qa.base.RetryAnalyzer.class)
	public void verifyEquipmentClassesViewForm()
	{
		test = extent.startTest("Verify Equipment Classes create new view form");
		
		Log.info("Equipment Classes ");
		
		test.log(LogStatus.INFO, "Login to SM2 successfull");
		pages.getLoginPage().logInToSM2("Admin", "fz;1234");
		
		test.log(LogStatus.INFO, "Cliked on Equipment");
		pages.getEquipmentClassesPage().clickOnEquipment();
		
		test.log(LogStatus.INFO, "Clicked on Equipment classes");
		pages.getEquipmentClassesPage().clickOnEquipmentClasses();
		
		test.log(LogStatus.INFO, "Verifying all the elements on the create new view form");
		pages.getBasicControllersPage().verifyCreateNewViewForm(test);
		
		Reporter.log("Equipment Classes create new view form");
		test.log(LogStatus.PASS, "Equipment classes create new view form's element verified successfully");
	}	
	
	
	@Test(enabled=true, description = "Clone a view under Equipment Classes",retryAnalyzer= com.eaf.qa.base.RetryAnalyzer.class)
	public void cloneAndDeleteAView()
	{
		test = extent.startTest("Clone a view under Equipment classes");
		Log.info("Clone a view ");
		
		test.log(LogStatus.INFO, "Login to SM2 successfull");
		pages.getLoginPage().logInToSM2("Admin", "fz;1234");
		
		test.log(LogStatus.INFO, "Cliked on Equipment");
		pages.getEquipmentClassesPage().clickOnEquipment();
		
		test.log(LogStatus.INFO, "Clicked on Equipment classes");
		pages.getEquipmentClassesPage().clickOnEquipmentClasses();
		
		test.log(LogStatus.INFO, "Delete icon was present with user created view");
		pages.getBasicControllersPage().verifyDeleteIcon("Test view");
		
		test.log(LogStatus.INFO, "Delete a view if already exist");
		pages.getBasicControllersPage().deleteView("Test view");
		
		test.log(LogStatus.INFO, "Delete a view if already exist");
		pages.getBasicControllersPage().DeleteViewIfPresent("Test view");
		
		test.log(LogStatus.INFO, "Clone icon is available with every view");
		pages.getBasicControllersPage().verifyCloneIcon("SiteManager Classic Default");
		
		//test.log(LogStatus.INFO, "'Edit View' icon is disabled for default view");
		//actions.verify(pages.getBasicControllersPage().verifyEditViewIconDisabledForDefaultView(), true, "'Edit View' icon was enabled");
		
		
		test.log(LogStatus.INFO, "Clone a view");
		pages.getBasicControllersPage().cloneAView("SiteManager Classic Default", "Test view");
		
		test.log(LogStatus.INFO, "Newely cloned view was present in view left panel");
		pages.getBasicControllersPage().verifyView("Test view");
		
		Reporter.log("Clone/Delete a view");
		test.log(LogStatus.PASS, "Clone/Delete of a view was successfully done");
	}	
	

	@Test(enabled=true, description = "Clone a view under Equipment Classes", retryAnalyzer= com.eaf.qa.base.RetryAnalyzer.class)
	public void verifyAView()
	{
		test = extent.startTest("Clone a view under Equipment classes");
		Log.info("Clone a view ");
		
		test.log(LogStatus.INFO, "Login to SM2 successfull");
		pages.getLoginPage().logInToSM2("Admin", "fz;1234");
		
		test.log(LogStatus.INFO, "Cliked on Equipment");
		pages.getEquipmentClassesPage().clickOnEquipment();
		
		test.log(LogStatus.INFO, "Clicked on Equipment classes");
		pages.getEquipmentClassesPage().clickOnEquipmentClasses();
		
		test.log(LogStatus.INFO, "Clicked on a default view from list of view");
	    pages.getBasicControllersPage().clickOnDesiredView("SiteManager Classic Default");
	    
		test.log(LogStatus.INFO, "'Edit View' icon is disabled for default view");		
		actions.verify(pages.getBasicControllersPage().verifyEditViewIconDisabledForDefaultView(), true, "'Edit View' icon was enabled");	
	
		Reporter.log("'Edit View icon' was disabled for default view");
		test.log(LogStatus.PASS, "'Edit View icon' was disabled for Default View");
	}

	
	@Test(enabled=true, description = "Create a view under Equipment Classes", retryAnalyzer= com.eaf.qa.base.RetryAnalyzer.class)
	public void createAView() throws AWTException 
	{
		test = extent.startTest("Create a view under Equipment classes");	
		Log.info("Create a view ");
		
		test.log(LogStatus.INFO, "Login to SM2 successfull");
		pages.getLoginPage().logInToSM2("Admin", "fz;1234");
		
		test.log(LogStatus.INFO, "Cliked on Equipment");
		pages.getEquipmentClassesPage().clickOnEquipment();
		
		test.log(LogStatus.INFO, "Clicked on Equipment classes");
		pages.getEquipmentClassesPage().clickOnEquipmentClasses();
		
		test.log(LogStatus.INFO, "Creating a view");
		List<String> list1 = new ArrayList<String>();
		list1.add("Fluid Code");
		list1.add("Fluid Name");
		list1.add("Max. PTO");
		pages.getBasicControllersPage().CreateAView("Equipment Fuel Class 1", list1, null, null, null, null);
		
		test.log(LogStatus.INFO, "Columns were verified");
		pages.getBasicControllersPage().verifyColumns("Fluid Code", "Fluid Name", "Max. PTO", null);
		
		test.log(LogStatus.INFO, "Newely created view was present in view left panel");
		pages.getBasicControllersPage().verifyView("Equipment Fuel Class 1");
		
		Reporter.log("Create a view");
		test.log(LogStatus.PASS, "View was created successfully");		
	}	
	
	
	@Test(enabled=true, description = "Edit a view under Equipment Classes", retryAnalyzer= com.eaf.qa.base.RetryAnalyzer.class)
	public void editAView() throws AWTException
	{
		test = extent.startTest("Edit a view under Equipment classes");
		Log.info("Edit a view ");
		
		test.log(LogStatus.INFO, "Login to SM2 successfull");
		pages.getLoginPage().logInToSM2("Admin", "fz;1234");
		
		test.log(LogStatus.INFO, "Cliked on Equipment");
		pages.getEquipmentClassesPage().clickOnEquipment();
		
		test.log(LogStatus.INFO, "Clicked on Equipment classes");
		pages.getEquipmentClassesPage().clickOnEquipmentClasses();
		
		// Delete a view
//		test.log(LogStatus.INFO, "Existing view was deleted successfully as per test case");
//		pages.getBasicControllersPage().deleteView("Equipment Fuel Class Updated");
		
		test.log(LogStatus.INFO, "Editing a view");
		List<String> list1 = new ArrayList<String>();
		list1.add("Fluid Code");
		list1.add("Fluid Name");
		list1.add("Max. PTO");
		pages.getBasicControllersPage().editView("Equipment Fuel Class 1", "Equipment Fuel Class Updated", list1, null, null);
		
		test.log(LogStatus.INFO, "Entity drop down value selected successfully");
		pages.getBasicControllersPage().selectValueFromEntityDropDownMenu();
		
		test.log(LogStatus.INFO, "Entity drop down value selected successfully");
		actions.verify(pages.getBasicControllersPage().verifySubViewDropDownIsEnabled(), true, "After selection of entity the Sub-View drop down menu is enabled");
		
		test.log(LogStatus.INFO, "Save button was clicked successfully");
		pages.getBasicControllersPage().formSaveButton();
			
		Reporter.log("Edit a view");
		test.log(LogStatus.PASS, "View was edited successfully");
	}	
	

	@Test(enabled=true, description = "Hide a view under Equipment Classes", retryAnalyzer= com.eaf.qa.base.RetryAnalyzer.class)
	public void hideAndShowAView() throws AWTException
	{
		test = extent.startTest("Hide/Show a view under Equipment classes");
		
		Log.info("Hide/Show a view ");
		
		test.log(LogStatus.INFO, "Login to SM2 successfull");
		pages.getLoginPage().logInToSM2("Admin", "fz;1234");
		
		test.log(LogStatus.INFO, "Cliked on Equipment");
		pages.getEquipmentClassesPage().clickOnEquipment();
		
		test.log(LogStatus.INFO, "Clicked on Equipment classes");
		pages.getEquipmentClassesPage().clickOnEquipmentClasses();
		
		test.log(LogStatus.INFO, "Hide icon was present with view");
		pages.getBasicControllersPage().verifyHideViewIcon("List of generators");
		
		test.log(LogStatus.INFO, "Hiding a view");
		pages.getBasicControllersPage().hideView("List of generators");
		
		test.log(LogStatus.INFO, "View is now hidden");
		actions.verify(pages.getBasicControllersPage().verifySuccessMsgAfterhideAView(), true, "Success message is not appear after hide a view");
		
		//test.log(LogStatus.INFO, "Left panel hide icon was clicked");
		//pages.getBasicControllersPage().HideIconOnViewLeftPanel();
		
		test.log(LogStatus.INFO, "Hidden view is showing now");
		pages.getBasicControllersPage().clickOnHideiconOfHiddenView("List of generators");
		
		test.log(LogStatus.INFO, "Hidden view is shown now");
		actions.verify(pages.getBasicControllersPage().verifySuccessMsgAfterUnhideAView(), true, "After unhide a view success message is not appear");		
		
		Reporter.log("Hide/Show a view");
		test.log(LogStatus.PASS, "Hide/Show of a view was successful");
	}	

	
	@Test(enabled=true, description = "Reorder a view under Equipment Classes", retryAnalyzer= com.eaf.qa.base.RetryAnalyzer.class)
	public void reorderAView() throws AWTException
	{
		test = extent.startTest("Reorder a view under Equipment classes");		
		Log.info("Reorder a view ");
		
		test.log(LogStatus.INFO, "Login to SM2 successfull");
		pages.getLoginPage().logInToSM2("Admin", "fz;1234");
		
		test.log(LogStatus.INFO, "Cliked on Equipment");
		pages.getEquipmentClassesPage().clickOnEquipment();
		
		test.log(LogStatus.INFO, "Clicked on Equipment classes");
		pages.getEquipmentClassesPage().clickOnEquipmentClasses();
		
//		test.log(LogStatus.INFO, "Reorder icon was present with view");
//		pages.getBasicControllersPage().verifyReorderIcon("SiteManager Classic Default");
		
		pages.getBasicControllersPage().ReOrderOperation("List of vehicles", "Fluid capacities");
			
		Reporter.log("Reorder a view");
		test.log(LogStatus.PASS, "Reorder of a view was successfully done");
	}	
	

	@Test(enabled=true, description = "Validation of mandatory fields for create view form under Equipment Classes", retryAnalyzer= com.eaf.qa.base.RetryAnalyzer.class)
	public void validateAViewForm()
	{
		test = extent.startTest("Validation of mandatory fields for a create view form under Equipment classes"); 
		Log.info("Validation of mandatory fields for a create view form ");
		
		test.log(LogStatus.INFO, "Login to SM2 successfull");
		pages.getLoginPage().logInToSM2("Admin", "fz;1234");
		
		test.log(LogStatus.INFO, "Cliked on Equipment");
		pages.getEquipmentClassesPage().clickOnEquipment();
		
		test.log(LogStatus.INFO, "Clicked on Equipment classes");
		pages.getEquipmentClassesPage().clickOnEquipmentClasses();
		
		test.log(LogStatus.INFO, "Validation of mandatory fields for a create view form was in progress");
		pages.getBasicControllersPage().verifyValidationOnCreateNewViewForm(test);
		
		Reporter.log("Validation for a view form");
		test.log(LogStatus.PASS, "Validation of mandatory fields for a create view form was successfully validated");
	}	
	

	@Test(enabled=true, description = "Edit a view under Equipment Classes", retryAnalyzer= com.eaf.qa.base.RetryAnalyzer.class)
	public void editAParticularView() throws AWTException
	{
		test = extent.startTest("Edit a view under Equipment classes");
		Log.info("Edit a view ");
		
		test.log(LogStatus.INFO, "Login to SM2 successfull");
		pages.getLoginPage().logInToSM2("Admin", "fz;1234");
		
		test.log(LogStatus.INFO, "Cliked on Equipment");
		pages.getEquipmentClassesPage().clickOnEquipment();
		
		test.log(LogStatus.INFO, "Clicked on Equipment classes");
		pages.getEquipmentClassesPage().clickOnEquipmentClasses();
		
		test.log(LogStatus.INFO, "Deselecting parameters from 'Selected Parameters'");
		List<String> list1 = new ArrayList<String>();
		   list1.add("Eq. Class Code");
		   list1.add("Eq. Class Description");
		   list1.add("(Fuel) Fluid Code");
		   list1.add("Meter Type (Code)");
		   list1.add("Max. Allowed Distance (km)"); 
		   list1.add("Max. Allowed Engine Run Time (hr)");
		   list1.add("Max. Allowed PTO (hr)");
		   list1.add("Tank Capacity");
		   list1.add("(Fuel) Min. Qty");
		   list1.add("(Fuel) Exc. Qty");		
		pages.getBasicControllersPage().editView("Equipment Classes", null, list1, null, null);
		
		test.log(LogStatus.INFO, "Aggregate drop down is not present after deselecting all the parameters");
		actions.verify(pages.getBasicControllersPage().verifyAggregateDropDownNotPresent(), true, "Aggregate drop down is present on Create View page");
		
		test.log(LogStatus.INFO, "Selecting available parameter as mentioned in test case");
		List<String> list2 = new ArrayList<String>();
		   list2.add("Eq. Class Code");
		   list2.add("Eq. Class Description");
		   list2.add("(Fuel) Fluid Code");
		   list2.add("Meter Type (Code)");
		   list2.add("Max. Allowed Distance (km)"); 
		   list2.add("Max. Allowed Engine Run Time (hr)");
		   list2.add("Max. Allowed PTO (hr)");
		   list2.add("Tank Capacity");
		   list2.add("(Fuel) Min. Qty");
		   list2.add("(Fuel) Exc. Qty");
		pages.getBasicControllersPage().addparametrs(list2, null, null);
		
		test.log(LogStatus.INFO, "'Aggregate' drop down was present");
		actions.verify(pages.getMaintenanceClassPage().verifyAggregateDropDown(), true, "Aggregate drtop down menu is not available");
		
		test.log(LogStatus.INFO, "Aggregate drop down was functional");
		pages.getBasicControllersPage().selectValueFromEntityDropDownMenu();
		
		test.log(LogStatus.INFO, "Save button was clicked");
		pages.getBasicControllersPage().formSaveButton();
		      
		Reporter.log("Edit a view");
		test.log(LogStatus.PASS, "View was edited successfully");		
	}	

		
	@Test(enabled=true, description = "Validation of mandatory fields for create view form under Equipment Classes", retryAnalyzer= com.eaf.qa.base.RetryAnalyzer.class)
	public void dashboardUnderViewOption()
	{
		test = extent.startTest("Dashboard implimentation under Equipment classes"); 
		Log.info("Dashboard implimentation under Equipment classes ");
		
		test.log(LogStatus.INFO, "Login to SM2 successfull");
		pages.getLoginPage().logInToSM2("Admin", "fz;1234");
		
		test.log(LogStatus.INFO, "Cliked on Equipment");
		pages.getEquipmentClassesPage().clickOnEquipment();
		
		test.log(LogStatus.INFO, "Clicked on Equipment classes");
		pages.getEquipmentClassesPage().clickOnEquipmentClasses();
		
		test.log(LogStatus.INFO, "A desire view was clicked");
		pages.getBasicControllersPage().clickOnDesiredView("Equipment Classes");
		
		test.log(LogStatus.INFO, "Dashboard icon was present with desired view");
		actions.verify(pages.getBasicControllersPage().VerifyDashboardIcon(), true, "Dashboard icon was not present with view option");
				
		test.log(LogStatus.INFO, "Dashboard icon was enabled with user created view");
		actions.verify(pages.getBasicControllersPage().verifyDashboardIconEnabled(), true, "Dashboard icon was not enabled");
				
		test.log(LogStatus.INFO, "Dashboard icon was clicked");
		pages.getBasicControllersPage().ClickOnDashBoardButtonOfDesiredView("Equipment Classes");
		
		test.log(LogStatus.INFO, "By default value was None in drop down menu");
		pages.getBasicControllersPage().verifyDisplayTypeBydefault(); 
		
		test.log(LogStatus.INFO, "Display Type drop down was clicked and select value from it");
		pages.getBasicControllersPage().ClickOnDisplayTypeDropDown();
		
		test.log(LogStatus.INFO, "Selected value is verified on 'Display Type' drop down menu");
		pages.getBasicControllersPage().verifyDisplayTypeAfterSelectingAValue();
		
		test.log(LogStatus.INFO, "Save button was clicked");
		pages.getBasicControllersPage().saveButton();
		
		test.log(LogStatus.INFO, "A success message 'View was saved successfully.' appeared"); 
		pages.getBasicControllersPage().verifySuccessMessageAfterSaveAView();
		
		test.log(LogStatus.INFO, "Dashboard icon was clicked");
		pages.getBasicControllersPage().ClickOnDashBoardButtonOfDesiredView("Equipment Classes");
		
		test.log(LogStatus.INFO, "Selected value is verified on 'Display Type' drop down menu");
		pages.getBasicControllersPage().verifyDisplayTypeAfterSelectingAValue();
		
		test.log(LogStatus.INFO, "Cancel button was clicked");
		pages.getBasicControllersPage().cancelBttn();
		
		Reporter.log("Dashboard icon under view option");
		test.log(LogStatus.PASS, "Operations for Dashboard is completed successfully");
	}	
	
	
	@Test(enabled=true, description = "'Web Services' under Equipment Classes", retryAnalyzer= com.eaf.qa.base.RetryAnalyzer.class)
	public void WebServicesUnderViewOption()
	{
		test = extent.startTest("'Web Services' implimentation under Equipment classes"); 
		Log.info("'Web Services' implimentation under Equipment classes ");
		
		test.log(LogStatus.INFO, "Login to SM2 successfull");
		pages.getLoginPage().logInToSM2("Admin", "fz;1234");
		
		test.log(LogStatus.INFO, "Cliked on Equipment");
		pages.getEquipmentClassesPage().clickOnEquipment();
		
		test.log(LogStatus.INFO, "Clicked on Equipment classes");
		pages.getEquipmentClassesPage().clickOnEquipmentClasses();
		
		test.log(LogStatus.INFO, "A desired view was clicked");
		pages.getBasicControllersPage().clickOnDesiredView("Equipment Classes");
		
		test.log(LogStatus.INFO, "'Web Services' icon was present with desired view");
		actions.verify(pages.getBasicControllersPage().VerifyWebServicesIcon(), true, "'Web Services' icon was not present with view option");
				
		test.log(LogStatus.INFO, "'Web Services' icon was enabled with user created view");
		actions.verify(pages.getBasicControllersPage().verifyWebServicesIconEnabled(), true, "'Web Services' icon was not enabled");
                                                                                                                                                        
		test.log(LogStatus.INFO, "'Web Services' icon was clicked");
		pages.getBasicControllersPage().ClickOnWebServiceOfDesiredView("Equipment Classes");
		
		test.log(LogStatus.INFO, "Element of 'Web Services' page was verified");
		pages.getBasicControllersPage().verifyWebServicesPage(test); 
	
		Reporter.log("Web Services implimentations under view option");
		test.log(LogStatus.PASS, "Operations for Web Services is completed successfully");
	}		
	
	
	@Test(enabled=true, description = "'Web Services' under Equipment Classes", retryAnalyzer= com.eaf.qa.base.RetryAnalyzer.class)
	public void exportUnderViewOption() throws IOException, InterruptedException
	{
		test = extent.startTest("'Export' implimentation under Equipment classes"); 
		Log.info("'Export' implimentation under Equipment classes ");
		
		test.log(LogStatus.INFO, "Login to SM2 successfull");
		pages.getLoginPage().logInToSM2("Admin", "fz;1234");
		
		test.log(LogStatus.INFO, "Cliked on Equipment");
		pages.getEquipmentClassesPage().clickOnEquipment();
		
		test.log(LogStatus.INFO, "Clicked on Equipment classes");
		pages.getEquipmentClassesPage().clickOnEquipmentClasses();
		
		test.log(LogStatus.INFO, "A desired view was clicked");
		pages.getBasicControllersPage().clickOnDesiredView("Fluid capacities");
		
		test.log(LogStatus.INFO, "'Export' icon was present with desired view");
		actions.verify(pages.getBasicControllersPage().VerifyWebServicesIcon(), true, "'Export' icon was not present with view option");
				
		test.log(LogStatus.INFO, "'Export' icon was enabled with user created view");
		actions.verify(pages.getBasicControllersPage().verifyExportIconEnabled(), true, "'Export' icon was not enabled");
                        
		pages.getBasicControllersPage().deleteDownlodedFile();
		
		test.log(LogStatus.INFO, "'Export' icon was clicked");
		pages.getBasicControllersPage().ClickOnExportOptionOfDesiredView("Fluid capacities");
		
		test.log(LogStatus.INFO, "CSV file was downloaded and verified"); 
		actions.verify(pages.getBasicControllersPage().verifyExportedFileName("./resources/downloadedFiles", "Fluid capacities"), true, "File was not downloaded or file name is different as excepted");
			
		Reporter.log("Export under view option");
		test.log(LogStatus.PASS, "Operations for Export is completed successfully");
	}	

	
}