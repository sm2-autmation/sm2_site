package com.eaf.qa.uitests;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.eaf.qa.utils.DataUtils;
import com.relevantcodes.extentreports.LogStatus;

public class RefrenceTableTest extends BaseTest{
	
	@Test (enabled=true, retryAnalyzer= com.eaf.qa.base.RetryAnalyzer.class)
	 public void CreateMultipleEntityGroup() throws AWTException
	 {
			test = extent.startTest("Verify Maintenance Class Test scenarios");

			// Login Credentials
			test.log(LogStatus.INFO, "Successfully logged in as Admin");
			pages.getLoginPage().logInToSM2("Admin", "fz;1234");
			
			
			
			test.log(LogStatus.INFO, "Successfully Clicked on System Tab");
			pages.getRefrenceTablePage().ClickOnSystemTab();
			
			test.log(LogStatus.INFO, "Successfully Clicked on reference table Tab");
			pages.getRefrenceTablePage().ClickonRefrenceTableTab();
			
			List<String> list1 = new ArrayList<String>();
			list1.add("Users");
			list1.add("Parts");
			
			
			
			
			List<String> list2 = new ArrayList<String>();
			list2.add("Users");
			
			test.log(LogStatus.INFO, "Creating entity group and deleting if present");
			pages.getRefrenceTablePage().CreateEntityGroup(DataUtils.getTestData("SystemTab", "GroupCode", "GroupCode1"), DataUtils.getTestData("SystemTab", "Description", "Description1"),list1);
			
			test.log(LogStatus.INFO, "verifying entities after adding");
			actions.verify(pages.getRefrenceTablePage().verifyEntitiesAfterAdding(DataUtils.getTestData("SystemTab", "GroupCode", "GroupCode1"), list1),true);
			
			test.log(LogStatus.INFO, "Editing the group");
			pages.getRefrenceTablePage().EditGroup(DataUtils.getTestData("SystemTab", "GroupCode", "GroupCode1"),null,null,null,list2);
			
			test.log(LogStatus.INFO, "verifying entities after deleting");
			actions.verify(pages.getRefrenceTablePage().VerifyEntitiesAfterDeleting(DataUtils.getTestData("SystemTab", "GroupCode", "GroupCode1"), list2),true);
			
			List<String> list3 = new ArrayList<String>();
			list3.add("Users");
			list3.add("Equipment");
			list3.add("Parts");
			
			test.log(LogStatus.INFO, "Creating entity group and deleting if present");
			pages.getRefrenceTablePage().CreateEntityGroup(DataUtils.getTestData("SystemTab", "GroupCode", "GroupCode2"), DataUtils.getTestData("SystemTab", "Description", "Description2"),null);
			
			test.log(LogStatus.INFO, "Edit entity group");
			pages.getRefrenceTablePage().EditGroup(DataUtils.getTestData("SystemTab", "GroupCode", "GroupCode2"),null,null,list3,null);
			
			test.log(LogStatus.INFO, "verifying entities after adding");
			actions.verify(pages.getRefrenceTablePage().verifyEntitiesAfterAdding(DataUtils.getTestData("SystemTab", "GroupCode", "GroupCode2"), list3),true);
			
			test.log(LogStatus.INFO, "Editing the group");
			pages.getRefrenceTablePage().EditGroup(DataUtils.getTestData("SystemTab", "GroupCode", "GroupCode2"),null,DataUtils.getTestData("SystemTab", "Description", "Description4"),null,list3);
			
			test.log(LogStatus.INFO, "verifying entities after deleting");
			actions.verify(pages.getRefrenceTablePage().VerifyEntitiesAfterDeleting(DataUtils.getTestData("SystemTab", "GroupCode", "GroupCode2"), list3),true);
			
			
			test.log(LogStatus.INFO, "Editing the group");
			pages.getRefrenceTablePage().EditGroup(DataUtils.getTestData("SystemTab", "GroupCode", "GroupCode2"),DataUtils.getTestData("SystemTab", "GroupCode", "GroupCode5"),DataUtils.getTestData("SystemTab", "Description", "Description5"),list3,null);
			
			test.log(LogStatus.INFO, "Editing the group");
			pages.getRefrenceTablePage().EditGroup(DataUtils.getTestData("SystemTab", "GroupCode", "GroupCode5"), DataUtils.getTestData("SystemTab", "GroupCode", "GroupCode6"), DataUtils.getTestData("SystemTab", "Description", "Description6"), null, null);
			
			test.log(LogStatus.INFO, "verifying entity-group and deletingf if present");
			pages.getRefrenceTablePage().verifyEntityGroupAndDeleteIfPresent(DataUtils.getTestData("SystemTab", "GroupCode", "GroupCode6"));
			
			
			List<String> list4 = new ArrayList<String>();
			list4.add("Users");
			list4.add("Generator");
			list4.add("Parts");

			test.log(LogStatus.INFO, "Creating entity group and deleting if present");
			pages.getRefrenceTablePage().CreateEntityGroup(DataUtils.getTestData("SystemTab", "GroupCode", "GroupCode3"), DataUtils.getTestData("SystemTab", "Description", "Description3"),list4);

			test.log(LogStatus.INFO, "verifying entities after adding");
			actions.verify(pages.getRefrenceTablePage().verifyEntitiesAfterAdding(DataUtils.getTestData("SystemTab", "GroupCode", "GroupCode3"), list1),true);
			
			test.log(LogStatus.INFO, "Creating entity group and deleting if present");
			pages.getRefrenceTablePage().CreateEntityGroup(DataUtils.getTestData("SystemTab", "GroupCode", "GroupCode7"), DataUtils.getTestData("SystemTab", "Description", "Description7"), null);
			
	 }


@Test(enabled=true, retryAnalyzer= com.eaf.qa.base.RetryAnalyzer.class)
public void ImportOfUserTest()
{
	
	test = extent.startTest("Verify Maintenance Class Test scenarios");

	// Login Credentials
	test.log(LogStatus.INFO, "Successfully logged in as Admin");
	pages.getLoginPage().logInToSM2("Admin", "fz;1234");
	
	
	
	test.log(LogStatus.INFO, "Successfully Clicked on System Tab");
	pages.getRefrenceTablePage().ClickOnSystemTab();
	
	
	test.log(LogStatus.INFO, "Clicking on Imports Tab");
	pages.getCreateEntityAtImportsSubTabUnderSystemTab().clickOnImportsTab();
	
	
	List<String> list1 = new ArrayList<String>();
	list1.add("Active");
	list1.add("Comment");
	list1.add("Cost Center Code");
	list1.add("Department Name");
	 String filepath ="D:\\eclipse\\SM2\\SM2_Automation\\resources\\ImportCSV\\USERS for IMPORT.csv";

	 test.log(LogStatus.INFO, "Creating entity page and deleting if present");
		
	 pages.getCreateEntityAtImportsSubTabUnderSystemTab().createEntity("User", "IMPORT of USERS", list1);

	 test.log(LogStatus.INFO, "Executing entity and importing csv file");
	 pages.getCreateEntityAtImportsSubTabUnderSystemTab().ExecuteEntity("User", "IMPORT of USERS", filepath);
	 
	 
	 List<String> list2 = new ArrayList<String>();
		list2.add("Unit Type Abbreviation");
		list2.add("Cost ($)");
		list2.add("Price ($)");
		list2.add("Additional Information");
		
		test.log(LogStatus.INFO, "Creating entity page and deleting if present");	
	pages.getCreateEntityAtImportsSubTabUnderSystemTab().createEntity("Part", "Parts Generators IMPORT", list2);
	
	
	List<String> list3 = new ArrayList<String>();
	list3.add("Unit Type Abbreviation");
	list3.add("Cost ($)");
	list3.add("Price ($)");
	list3.add("Additional Information");

	test.log(LogStatus.INFO, "Creating entity page and deleting if present");
	pages.getCreateEntityAtImportsSubTabUnderSystemTab().createEntity("Part", "Parts IMPORT", list3);
	
	
	List<String> list4 = new ArrayList<String>();
	list4.add("OEM #");
	
	test.log(LogStatus.INFO, "Creating entity page and deleting if present");
	pages.getCreateEntityAtImportsSubTabUnderSystemTab().createEntity("Association Part - Manufacturers", "Parts to Manufacturers IMPORT", null);

}

@Test(enabled=true, retryAnalyzer= com.eaf.qa.base.RetryAnalyzer.class)
public void CreateUser() throws AWTException
{
	test = extent.startTest("Verify Maintenance Class Test scenarios");

	// Login Credentials
	test.log(LogStatus.INFO, "Successfully logged in as Admin");
	pages.getLoginPage().logInToSM2("Admin", "fz;1234");
	
	test.log(LogStatus.INFO, "Click on personnel Tab");
	pages.getUsersUnderPersonnelTabPage().ClickOnPersonnelTab();
	
	//pages.getUsersUnderPersonnelTabPage().ClickOnUsersTab();
	
	
	List<String> list1 = new ArrayList<String>();
	list1.add("User ID");
	list1.add("User Name");
	list1.add("Active");
	list1.add("Attached File");
	list1.add("Comment");
	list1.add("Cost Center Code");
	list1.add("Department Name");
	
	test.log(LogStatus.INFO, "Creating a view");
	pages.getBasicControllersPage().CreateAView("Personnel", list1, null, null, null, null);

	test.log(LogStatus.INFO, "Creating a User");
	pages.getUsersUnderPersonnelTabPage().CreateUser("YANRAM", "Yanelli Ramones", "Administration", "ADMIN");

}

}