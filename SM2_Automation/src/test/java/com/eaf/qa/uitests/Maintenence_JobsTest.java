package com.eaf.qa.uitests;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.eaf.qa.utils.TestUtils;
import com.relevantcodes.extentreports.LogStatus;

public class Maintenence_JobsTest extends BaseTest
{

	@Test (enabled=true, retryAnalyzer= com.eaf.qa.base.RetryAnalyzer.class)
	public void MaintenanceJobsTc_001ToTc_005() throws AWTException
	{
       test=extent.startTest("Creating a job");
		
		test.log(LogStatus.INFO, "Successfully login to SM2");
		pages.getLoginPage().logInToSM2("Admin", "fz;1234");
		
		test.log(LogStatus.INFO, "Clicked on maintenance tab");
		pages.getCreateTasksPage().clickOnMaintenanceTab();
		
		test.log(LogStatus.INFO, "Clicked on jobs sub tab");
		pages.getCreateJobPage().clickOnJobsSubTab();
		
		test.log(LogStatus.INFO, "Creating View");
		List<String> list0 = new ArrayList<String>();
		list0.add("Name");
		list0.add("Work Type Desc.");
		list0.add("Work Type");
		list0.add("Type");
	
		pages.getBasicControllersPage().CreateAView("Jobs List Test", list0, null, null, null, null);
		
		
		List<String> list1 = new ArrayList<String>();
		list1.add("Expected Time (hr)");
		
		test.log(LogStatus.INFO, "Editing View and adding parameters");
		
		pages.getMaintenance_JobsPageTc().EditViewAndAddparameters("Jobs List Test", null, list1, null, null);
		
//		test.log(LogStatus.INFO, "Editing View and adding aggregate");
//		pages.getMaintenance_JobsPageTc().EditTheView_Tc_003("Jobs List Test", "Display", "Expected Time (hr)", "Sum");
//		
//		List<String> list3 = new ArrayList<String>();
//		list3.add("Task Expected Time (hr)");
//		
//		test.log(LogStatus.INFO, "Editing View and adding parameters");
//		pages.getMaintenance_JobsPageTc().EditViewAndAddparameters("Jobs List Test", null, list3, null, null);
//		
//
//		test.log(LogStatus.INFO, "Editing View and adding aggregate");
//		pages.getMaintenance_JobsPageTc().EditTheView_Tc_003("Jobs List Test", "Display", "Task Expected Time (hr)", "Sum");
//		
//		List<String> list2 = new ArrayList<String>();
//		list2.add("Task Code");
//		list2.add("Task Description");
//		list2.add("Task Expected Time (hr)");
//
//		test.log(LogStatus.INFO, "Creating a View ");
//		pages.getBasicControllersPage().CreateAView("Test Task Subview", list2, null, null, null, null);
//		
//		test.log(LogStatus.INFO, "Creating a View and adding entity and sub-view ");
//	    pages.getMaintenance_JobsPageTc().EditViewAndAddEntityAndSubViewTc_006("Jobs List Test", "Jobs", "Test Task Subview");
//		
//	    test.log(LogStatus.INFO, "Clicking on refresh button ");
//	    pages.getBasicControllersPage().ClickOnRefreshButtonOfDesiredView("Jobs List Test");
//	
//	   
//		
//		Reporter.log("New job was cretaed");
//		test.log(LogStatus.PASS, "A job was created");
		
		
	}

	@Test (enabled=true, retryAnalyzer= com.eaf.qa.base.RetryAnalyzer.class)
	public void AddAJobSample() throws AWTException
	{

		test=extent.startTest("Creating a job");
		
		test.log(LogStatus.INFO, "Successfully login to SM2");
		pages.getLoginPage().logInToSM2("Admin", "fz;1234");
		
		test.log(LogStatus.INFO, "Clicked on maintenance tab");
		pages.getCreateTasksPage().clickOnMaintenanceTab();
		
		test.log(LogStatus.INFO, "Clicked on jobs sub tab");
		pages.getCreateJobPage().clickOnJobsSubTab();
		
		String str=TestUtils.randomString();
		pages.getBasicControllersPage().AddAJob("jobtype"+str, "Inspection", "2.2", 1, 1);
		   
		
		Reporter.log("New job was cretaed");
		test.log(LogStatus.PASS, "A job was created");
		
	}
	
	

}
