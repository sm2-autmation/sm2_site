package com.eaf.qa.uitests;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class TriggerResetHistoryTest extends BaseTest {
	
	@Test(enabled=true, retryAnalyzer= com.eaf.qa.base.RetryAnalyzer.class)
	public void TriggerResetHistoryTc_001ToTc_003() throws AWTException
	{
       test=extent.startTest("Creating,editing and deleting a view in Trigger Reset History ");
		
		test.log(LogStatus.INFO, "Successfully login to SM2");
		pages.getLoginPage().logInToSM2("Admin", "fz;1234");
		
		test.log(LogStatus.INFO, "Clicked on maintenance tab");
		pages.getCreateTasksPage().clickOnMaintenanceTab();
		
		pages.getBasicControllersPage().ClickOnTriggerResetHistory();
		
		List<String> list0 = new ArrayList<String>();
		list0.add("Department Name");
		list0.add("Eq. Class Code");
		list0.add("Eq. Class Description");
		list0.add("Eq. Number");
		
		test.log(LogStatus.INFO, "Create A View");
		
		pages.getBasicControllersPage().CreateAView("Test trigger", list0, null, null, null, null);
		
		test.log(LogStatus.INFO, "edit view and change the name of the view");
		pages.getBasicControllersPage().editView("Test trigger", "WO testing 10", null, null, null);
		
		test.log(LogStatus.INFO, "Click on refresh button of a view");
		pages.getBasicControllersPage().ClickOnRefreshButtonOfDesiredView("WO testing 10");
		
		test.log(LogStatus.INFO, "Delete the above edited view");
		pages.getBasicControllersPage().deleteView("WO testing 10");
		

}
}