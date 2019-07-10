package com.eaf.qa.uitests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.eaf.qa.cloudops.pages.LoginPage;
import com.relevantcodes.extentreports.LogStatus;

public class PrerequisiteForSM2Test extends BaseTest {

	private static Logger Log = LogManager.getLogger(LoginPage.class.getName());
	
	@Test(enabled=true, description = "To full fill prerequisites of Maintenance Plans", retryAnalyzer= com.eaf.qa.base.RetryAnalyzer.class)
	public void PrerequisiteForMaintenancePlans() {
		Log.info("Maintenance Plans");
		pages.getLoginPage().logInToSM2("Admin", "fz;1234");
		pages.getCreateTasksPage().clickOnMaintenanceTab();
		pages.getCreateMaintenancePlansPage().clickOnJobsSubTab();
		pages.getCreateMaintenancePlansPage().clickOnListOfMaintenancePlans();
		pages.getCreateMaintenancePlansPage().verifyJobCodeAndCreateJob();	
	}
	
	@Test(enabled=true, description = "To full fill prerequisites of jobs",retryAnalyzer= com.eaf.qa.base.RetryAnalyzer.class)//, dependsOnMethods="PrerequisiteForTasks")
     public void PrerequisiteForjobs() {
		Log.info("jobs");
		pages.getLoginPage().logInToSM2("Admin", "fz;1234");
		pages.getCreateTasksPage().clickOnMaintenanceTab();
		pages.getCreateJobPage().clickOnJobsSubTab();
		pages.getCreateJobPage().clickOnListOfJobs();
		pages.getCreateJobPage().verifyJobCodeAndCreateJob();
	}
	
	@Test(enabled=false, description = "To full fill prerequisites of Tasks",retryAnalyzer= com.eaf.qa.base.RetryAnalyzer.class)
	public void PrerequisiteForTasks() 
	{
		Log.info("Tasks");
			pages.getLoginPage().logInToSM2("Admin", "fz;1234");
			pages.getCreateTasksPage().clickOnMaintenanceTab();
			pages.getCreateTasksPage().clickOnTasksSubTab();
			pages.getCreateTasksPage().verifyTaskCodeAndCreateTask();				
		}
	
	
	@Test(priority=1, enabled = true, groups= "WorkOrders", description = "To full fill prerequisites of Work Orders",retryAnalyzer= com.eaf.qa.base.RetryAnalyzer.class)
	public void PrerequisiteToAddVehicleForWorkOrders() 
	{
		test = extent.startTest("Create vehicles for Equipment Number in order to create work orders");
		
		Log.info("Add vehicles for Work Orders");
		
		    test.log(LogStatus.INFO, "User sccessfully logged in as Admin");
			pages.getLoginPage().logInToSM2("Admin", "fz;1234");
			
			test.log(LogStatus.INFO, "Equipment tab was clicked successfully");
		    pages.getCreateVehiclePage().clickOnEquipmentTab();	
		    //pages.getCreateVehiclePage().clickOnCreateVehiclePlusIcon();
		    
		    test.log(LogStatus.INFO, "Eq. Number was searched in list and if not present then going to create a new one");
		    pages.getCreateVehiclePage().verifyEqNumberAndCreateVehicle();
		    
		    Reporter.log("Creating vehicle for Eq. Number");
			test.log(LogStatus.PASS, "Vehicle was created");
    }
	
	@Test(priority=2, enabled=true, groups= "AddUsers", description = "To full fill prerequisites of Work Orders",retryAnalyzer= com.eaf.qa.base.RetryAnalyzer.class)
	public void PrerequisiteToAddUserForWorkOrders() 
	{
		test = extent.startTest("Create vehicles for Equipment Number in order to create work orders");
		
		Log.info("Adding users");
		
		    test.log(LogStatus.INFO, "Successfully logged in as Admin");		
			pages.getLoginPage().logInToSM2("Admin", "fz;1234");
			
			test.log(LogStatus.INFO, "Personnel tab was clicked");
		    pages.getCreateUsersPage().clickOnPersonnelTab();
		    
		    //pages.getCreateUsersPage().clickOnPlusIconToAddUser();
		    
		    test.log(LogStatus.INFO, "User ID was searched in list and if not present then going to create a new one");
		    pages.getCreateUsersPage().verifyUserIDAndCreateUserID();
		    
		    Reporter.log("User added");
			test.log(LogStatus.PASS, "Users were added");	    
    }
	
	@Test(priority=3, enabled=true, description = "To add Work Orders",retryAnalyzer= com.eaf.qa.base.RetryAnalyzer.class)
	public void AddWorkOrders() 
	{
		test = extent.startTest("Adding work orders");
		
		Log.info("Adding Work Orders");
		    test.log(LogStatus.INFO, "User sccessfully logged in as Admin");
			pages.getLoginPage().logInToSM2("Admin", "fz;1234");
			
			test.log(LogStatus.INFO, "Maintenance tab was clicked");
		    pages.getCreateWorkOrdersPage().clickOnMaintenanceTab();
		    
		    test.log(LogStatus.INFO, "Work Orders sub-tab was clicked");
		    pages.getCreateWorkOrdersPage().clickOnWorkOrders();
		    
		    test.log(LogStatus.INFO, "Plus icon to add work order was clicked");
		    pages.getCreateWorkOrdersPage().clickOnPlusIconOfWorkOrders();
		    
		    
		    test.log(LogStatus.INFO, "Work Orders created successfully");
		    pages.getCreateWorkOrdersPage().createWorkOrders();
		    
		    Reporter.log("Work order added");
			test.log(LogStatus.PASS, "Work order added");
		    
    }
	
	@Test(priority=4, enabled=true, description = "To add Devices",retryAnalyzer= com.eaf.qa.base.RetryAnalyzer.class)
	public void AddDevices() 
	{
		test = extent.startTest("Adding Devices");
	
		Log.info("Adding Devices");
		
		    test.log(LogStatus.INFO, "User sccessfully logged in as Admin");
			pages.getLoginPage().logInToSM2("Admin", "fz;1234");
			
			test.log(LogStatus.INFO, "Equipment tab was clicked");
		    pages.getCreateDevicesPage().clickOnEquipmentTab();
		    
		    test.log(LogStatus.INFO, "Device sub-tab was clicked");
		    pages.getCreateDevicesPage().clickOnDevicesSubTab();
		    
		   // pages.getCreateDevicesPage().clickOnPlusIconToAddDevices();
		    
		    test.log(LogStatus.INFO, "Device was searched in list and if not present then going to create a new one");
		    pages.getCreateDevicesPage().verifyDeviceAndCreateDevice();
		    
		    Reporter.log("Device added");
			test.log(LogStatus.PASS, "Device added to the list");
    }
}