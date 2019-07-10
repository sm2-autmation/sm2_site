package com.eaf.qa.uitests;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.eaf.qa.cloudops.pages.LoginPage;
import com.eaf.qa.utils.TestUtils;
import com.relevantcodes.extentreports.LogStatus;

public class AddMaintenancePlanchecklistTest extends BaseTest{
	private static Logger Log = LogManager.getLogger(LoginPage.class.getName());
	
	
	@Test(enabled=true, retryAnalyzer= com.eaf.qa.base.RetryAnalyzer.class)
	public void PlanMaintenanceFlow() throws AWTException
	{
		
		test=extent.startTest("Creating a job code");
		test.log(LogStatus.INFO, "Successfully login to SM2");
		Log.info("login to SM2");
		pages.getLoginPage().logInToSM2("Admin", "fz;1234");
		
		test.log(LogStatus.INFO, "Clicked on maintenance tab");
		Log.info("Clicking on maintenance tab");
		pages.getCreateTasksPage().clickOnMaintenanceTab();
		
		test.log(LogStatus.INFO, "Clicked on maintenance plans sub tab");
		Log.info("Clicking on maintenance plans sub tab");
		pages.getCreateMaintenancePlansPage().clickOnMaintenancePlansTab();
		
		test.log(LogStatus.INFO, "Clicked on maintenance plans list");
		Log.info("Clicking on List of maintenance plans");
		pages.getCreateMaintenancePlansPage().clickOnListOfMaintenancePlans();
		
		List<String> list1 = new ArrayList<String>();
		list1.add("Name");
		list1.add("Job Name");
		list1.add("Warning Threshold");
		list1.add("Trigger Type");
		list1.add("Trigger Value");
		
		test.log(LogStatus.INFO, "Creating a View ");
		pages.getBasicControllersPage().CreateAView("Maintenance Plans TEST", list1, null, null, null, null);
		 
	    test.log(LogStatus.INFO, "Clone a View ");
	    pages.getBasicControllersPage().cloneView("Maintenance Plans TEST", "List of Silverado PM TEST");
		
		
		
		test.log(LogStatus.INFO, "Hide a View ");
		
		pages.getBasicControllersPage().hideView("Maintenance Plans TEST");
		
		test.log(LogStatus.INFO, "Click on hide icon of hidden view ");
		pages.getBasicControllersPage().clickOnHideiconOfHiddenView("Maintenance Plans TEST");
		
		test.log(LogStatus.INFO, "Editing a View ");
		pages.getBasicControllersPage().editView("List of Silverado PM TEST", null, null, null, null);
		
		
		String str=TestUtils.randomString();
		
		List<String> list2 = new ArrayList<String>();
		list2.add("Distance");
		
		List<String> list3 = new ArrayList<String>();
		list3.add("20");
		
		
		test.log(LogStatus.INFO, "Adding a Plan Maintenance ");
		pages.getBasicControllersPage().AddAPlanMaintenance("AABAACAABAACDABAACAE", "Silverado "+str, list2, list3);

		test.log(LogStatus.INFO, "Adding a Plan Maintenance ");
		pages.getBasicControllersPage().AddAPlanMaintenance("AABAACAABAACDABAACAE", "Plan Silverado "+str, list2, list3);

		test.log(LogStatus.INFO, "Adding a Plan Maintenance ");
		pages.getBasicControllersPage().AddAPlanMaintenance("AAAABAAAABAAAABAAAABAAAACAAAABAAAABAAAABAAAABAAAAD", "Generator Plan"+str, list2, list3);
		
		test.log(LogStatus.INFO, "Clicking on Refresh button of desired view");
		pages.getBasicControllersPage().ClickOnRefreshButtonOfDesiredView("Default Maintenance Plans");

		test.log(LogStatus.INFO, "Adding a Plan Maintenance ");
		pages.getBasicControllersPage().AddAPlanMaintenance("AAAABAAAABAAAABAAAABAAAACAAAABAAAABAAAABAAAABAAAAD", "Generator MAINTENANCE Plan"+str, list2, list3);
		

		test.log(LogStatus.INFO, "Clicking on Refresh button of desired view");
		pages.getBasicControllersPage().ClickOnRefreshButtonOfDesiredView("Default Maintenance Plans");

		test.log(LogStatus.INFO, "Editing a Plan Maintenance ");
		pages.getBasicControllersPage().EditAPlanMaintenance("Generator MAINTENANCE Plan"+str, "TGEN - Tower Generators without Automated Parts", "AAAABAAAABAAAABAAAABAAAACAAAABAAAABAAAABAAAABAAAAD", null);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
