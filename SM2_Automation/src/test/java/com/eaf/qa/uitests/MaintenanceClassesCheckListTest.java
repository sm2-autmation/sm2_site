package com.eaf.qa.uitests;

import java.awt.AWTException;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.eaf.qa.utils.DataUtils;
import com.relevantcodes.extentreports.LogStatus;

public class MaintenanceClassesCheckListTest extends BaseTest
{
	
@Test (enabled=true, retryAnalyzer= com.eaf.qa.base.RetryAnalyzer.class)
 public void maintenanceClassesCompleteFlow() throws AWTException
 {
		test = extent.startTest("Verify Maintenance Class Test scenarios");

		// Login Credentials
		test.log(LogStatus.INFO, "Successfully logged in as Admin");
		pages.getLoginPage().logInToSM2("Admin", "fz;1234");
		
		
		// Click on Maintenance tab
		test.log(LogStatus.INFO, "Maintenance Tab was clicked");
		pages.getMaintenanceClassPage().clickOnMaintenance();
		
		// Click On Maintenance Classes
		test.log(LogStatus.INFO, "Maintenance Classes Sub-Tab was clicked");
		pages.getMaintenanceClassPage().clickOnMaintenanceClasses(); 
	 
		
		test.log(LogStatus.INFO, "Clone a view Scenario");
		pages.getMaintenanceClassesChecklist().getBasicControllersPage().cloneView(DataUtils.getTestData("MaintenanceClasses", "NameOfView", "N1"), DataUtils.getTestData("MaintenanceClasses", "NameOfNewView", "N1"));
		
		test.log(LogStatus.INFO, "clone again with newly created view");
		pages.getMaintenanceClassesChecklist().getBasicControllersPage().cloneView(DataUtils.getTestData("MaintenanceClasses", "NameOfNewView", "N1"), DataUtils.getTestData("MaintenanceClasses", "NameOfNewView", "C1"));
		
		
		test.log(LogStatus.INFO, "Edit the Newly Created View,verify the columns and reediting the view");
		pages.getMaintenanceClassesChecklist().Test_004EditView("Vehicle & Maintenance Class Test");
		
		test.log(LogStatus.INFO, "verify columns after editing the view");
		actions.verify(pages.getMaintenanceClassesChecklist().verifyColumns("Equipment Desc.", "Equipment Number"), true, "columns are not present");
		
		test.log(LogStatus.INFO, "Redit the view");
		
		pages.getMaintenanceClassesChecklist().ReEdit("Vehicle & Maintenance Class Test");
		
		
		
		test.log(LogStatus.INFO, "Create a Maintenance Class");
		pages.getMaintenanceClassesChecklist().Test_005CreateAMaintenanceClass();
		
		test.log(LogStatus.INFO, "Edit the class created above");
		pages.getMaintenanceClassesChecklist().Test_006EditTheAboveClass();
		
		test.log(LogStatus.INFO, "Delete the above Class");
		pages.getMaintenanceClassesChecklist().Test_007DeleteTheAboveClass();
		
		Reporter.log("Created flow");
		test.log(LogStatus.PASS, "Created flow");
	 
 }


@Test (enabled=true, retryAnalyzer= com.eaf.qa.base.RetryAnalyzer.class)
public void CreateMultipleMaintenanceClassess()
{
	
	test = extent.startTest("Create Multiple Maintenance Classess");

	// Login Credentials
	test.log(LogStatus.INFO, "Successfully logged in as Admin");
	pages.getLoginPage().logInToSM2("Admin", "fz;1234");
	
	
	// Click on Maintenance tab
	test.log(LogStatus.INFO, "Maintenance Tab was clicked");
	pages.getMaintenanceClassPage().clickOnMaintenance();
	
	// Click On Maintenance Classes
	test.log(LogStatus.INFO, "Maintenance Classes Sub-Tab was clicked");
	pages.getMaintenanceClassPage().clickOnMaintenanceClasses(); 
	
	pages.getMaintenanceClassesChecklist().VerifySaveAndCancelButtonOnAddMaintenanceClassesPage();

	test.log(LogStatus.INFO, "Created Maintenanace classes");
	for(int i=3;i<=12;i++){	pages.getMaintenanceClassesChecklist().addMaintenanceClasses(DataUtils.getTestData("MaintenanceClasses", "Class Code", "Class Code"+i), DataUtils.getTestData("MaintenanceClasses", "Description", "Description"+i));}

	Reporter.log("Created classes");
	test.log(LogStatus.PASS, "Created Multiple classes");
 

}

@Test (enabled=true, retryAnalyzer= com.eaf.qa.base.RetryAnalyzer.class)
public void verifyMaintenanceClassesPage()
{
	
	test = extent.startTest("Verify Maintenance Class page");

	// Login Credentials
	test.log(LogStatus.INFO, "Successfully logged in as Admin");
	pages.getLoginPage().logInToSM2("Admin", "fz;1234");
	
	
	// Click on Maintenance tab
	test.log(LogStatus.INFO, "Maintenance Tab was clicked");
	pages.getMaintenanceClassPage().clickOnMaintenance();
	
	// Click On Maintenance Classes
	test.log(LogStatus.INFO, "Maintenance Classes Sub-Tab was clicked");
	pages.getMaintenanceClassPage().clickOnMaintenanceClasses();
	
	test.log(LogStatus.INFO, "verify add maintenance class icon");
	pages.getMaintenanceClassesChecklist().VerifyMaintenaceClassPage();

}


















}
