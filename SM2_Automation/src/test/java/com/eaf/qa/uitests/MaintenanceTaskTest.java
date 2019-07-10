package com.eaf.qa.uitests;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.eaf.qa.cloudops.pages.LoginPage;
import com.eaf.qa.utils.TestUtils;
import com.relevantcodes.extentreports.LogStatus;

public class MaintenanceTaskTest extends BaseTest {

	private static Logger Log = LogManager.getLogger(LoginPage.class.getName());
	
	@Test(enabled=true, description = "Create a view under Maintenance Task", retryAnalyzer= com.eaf.qa.base.RetryAnalyzer.class)
	public void createAView() throws AWTException
	{
		test = extent.startTest("Create a view under Maintenance Task");	
		Log.info("Create a view ");
		
		test.log(LogStatus.INFO, "Login to SM2 successfull");
		pages.getLoginPage().logInToSM2("Admin", "fz;1234");
		
		test.log(LogStatus.INFO, "Cliked on Maintenance");
		pages.getMaintenanceTaskPage().clickOnMaintenance();
		
		test.log(LogStatus.INFO, "Clicked on Maintenance Task");
		pages.getMaintenanceTaskPage().clickOnTasksSubTab();
		
		//test.log(LogStatus.INFO, "Delete a view if already exist");
		//pages.getBasicControllersPage().deleteView("Quick Search Task");
		
		test.log(LogStatus.INFO, "Creating a view");
		List<String> list1 = new ArrayList<String>();
		list1.add("Code");
		list1.add("Description");
		list1.add("Expected Time (hr)");
		list1.add("Type");
		pages.getBasicControllersPage().CreateAView("Quick Search Task", list1, null, null, null, null);
		
		test.log(LogStatus.INFO, "Columns were verified");
		pages.getBasicControllersPage().verifyColumns("Code", "Description", "Expected Time (hr)", "Type");
		
		test.log(LogStatus.INFO, "Newely created view was present in view left panel");
		pages.getBasicControllersPage().verifyView("Quick Search Task");
		
		test.log(LogStatus.INFO, "The view was refreshed");
		pages.getBasicControllersPage().ClickOnRefreshButtonOfDesiredView("Quick Search Task");
		
		Reporter.log("Create a view");
		test.log(LogStatus.PASS, "View was created successfully");		
	}	
	
	
	@Test(enabled=true, description = "Import a task under Imports in System Module",  retryAnalyzer= com.eaf.qa.base.RetryAnalyzer.class)
	public void ImportATask() throws AWTException
	{
		test = extent.startTest("Import a task under Imports in System Module");
		Log.info("import a task ");
		
		test.log(LogStatus.INFO, "Login to SM2 successfull");
		pages.getLoginPage().logInToSM2("Admin", "fz;1234");
		
		test.log(LogStatus.INFO, "Cliked on System tab");
		pages.getCreateEntityAtImportsSubTabUnderSystemTab().clickOnSystemTab();
		
		test.log(LogStatus.INFO, "Clicked on Import sub tab");
		pages.getCreateEntityAtImportsSubTabUnderSystemTab().clickOnImportsSubTab();
		
		test.log(LogStatus.INFO, "Create a task");
		List<String> list1 = new ArrayList<String>();
		list1.add("Code");
		list1.add("Description");
		list1.add("Expected Time (hr)");
		list1.add("Type");
		pages.getCreateEntityAtImportsSubTabUnderSystemTab().createEntity("Tasks", "TASKS IMPORT", null);
		
		test.log(LogStatus.INFO, "Created entity was present under Imports");
		pages.getCreateEntityAtImportsSubTabUnderSystemTab().VerifyEntityPageAfterAdding("Tasks", "TASKS IMPORT");
			
		Reporter.log("Create a Import for Task");
		test.log(LogStatus.PASS, "View was created successfully");
	}
	
	
	@Test(enabled=true, description = "Import a task under Imports in System Module")
	public void ImportAEntityGroupTask() throws AWTException
	{
		String filepath = "D:\\eclipse\\SM2\\SM2_Automation\\resources\\ImportCSV\\Entity Grouping IMPORT.csv";          
				         
		test = extent.startTest("Import a task under Imports in System Module");
		Log.info("import a task ");
		
		test.log(LogStatus.INFO, "Login to SM2 successfull");
		pages.getLoginPage().logInToSM2("Admin", "fz;1234");
		
		test.log(LogStatus.INFO, "Cliked on System tab");
		pages.getCreateEntityAtImportsSubTabUnderSystemTab().clickOnSystemTab();
		
		test.log(LogStatus.INFO, "Clicked on Import sub tab");
		pages.getCreateEntityAtImportsSubTabUnderSystemTab().clickOnImportsSubTab();
		
		test.log(LogStatus.INFO, "Create a task");
		List<String> list1 = new ArrayList<String>();
		list1.add("Group Code");
		list1.add("Group Description");
		pages.getCreateEntityAtImportsSubTabUnderSystemTab().createEntity("Entity Group", "IMPORT Group Entity", null);
		
		test.log(LogStatus.INFO, "Created entity was present under Imports");
		pages.getCreateEntityAtImportsSubTabUnderSystemTab().VerifyEntityPageAfterAdding("Entity Group", "IMPORT Group Entity");
		
		test.log(LogStatus.INFO, "Selected csv file was imported successfully");
		pages.getCreateEntityAtImportsSubTabUnderSystemTab().ExecuteEntity("Entity Group", "IMPORT Group Entity", filepath);
		
		test.log(LogStatus.INFO, "After import of csv file a success message 'Import completed' was appeared");
		actions.verify(pages.getCreateEntityAtImportsSubTabUnderSystemTab().verifySuccessMsg(), true, "Import sucess message was not present");
		
		Reporter.log("Create a Import for Task for Entity Group");
		test.log(LogStatus.PASS, "Entity was created successfully");
	}

}