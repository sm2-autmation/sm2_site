package com.eaf.qa.cloudops.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.eaf.qa.base.BasePage;

public class UsersUnderPersonnelTabPage extends BasePage {

	public UsersUnderPersonnelTabPage(ThreadLocal<WebDriver> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	By personnelTab=By.xpath("//li[@title='Personnel']");
	
	By usersTab=By.xpath("//li[@title='Users']");
	
	By leftPanel=By.xpath("//div[@id='sortableList']");
	
	public void ClickOnPersonnelTab()
	{
		waitForElementToBeClickable(personnelTab, longWait);
		clickAndWait(personnelTab, longWait);
		waitForElementToBeClickable(usersTab, longWait);		
	}
	
	
	public void ClickOnUsersTab()
	{		
		waitForElementToBeClickable(usersTab, longWait);
		clickAndWait(usersTab, longWait);
		waitForElementToBeClickable(leftPanel, longWait);		
	}
	
	
	public void CreateUser(String UserID,String UserName,String Department,String CostCenterCode)
	{
		By addusericon=By.xpath("//li[@title='Users']//div");
		
		clickAndWait(addusericon, longWait);
				
		By UserIDfield=By.xpath("//td[@id='tdFieldUSNO']//input");
		
		By UserNamefield=By.xpath("//td[@id='tdFieldUSDE']//input");
		
		waitForElementToBeClickable(UserIDfield, longWait);
		setText(UserIDfield, UserID, longWait);
		
		waitForElementToBeClickable(UserNamefield, longWait);
		setText(UserNamefield, UserName, longWait);
		
		if(Department!=null)
		{			
			By dropDown=By.xpath("//select[@id='DPID']");
			clickAndWait(dropDown, longWait);
			
			By option=By.xpath("//select[@id='DPID']//option[text()='"+Department+"']");		
		}
		
		if(CostCenterCode!=null)
		{			
			By dropDown=By.xpath("//select[@id='CCID']");
			clickAndWait(dropDown, longWait);
			
			By option=By.xpath("//select[@id='CCID']//option[text()='"+CostCenterCode+"']");			
		}
		
		By saveBttn=By.xpath("//button[@id='btnTopSave']");
		Click(saveBttn);	
	}
	
	
	public void DeleteuserIfPresent(String UserName)
	{
		List<WebElement> el=driver.get().findElements(By.xpath("//label[text()='"+UserName+"']//parent::div//following-sibling::div[1][@class='individualTemplates']//div[@class='importTitleDiv']"));
		
		int size=el.size();
		loop:
		for(int i=1;i<=size;i++)
		{
			
			WebElement DesiredElement=driver.get().findElement(By.xpath("//label[text()='"+UserName+"']//parent::div//following-sibling::div//label[text()='"+UserName+"']"));
			if(DesiredElement.getText().equals(UserName))
			{
				System.out.println("entity page found and now deleting");
				By deleteButton=By.xpath("//label[text()='"+UserName+"']//parent::div//following-sibling::div//label[text()='"+UserName+"']//parent::div//following-sibling::div[@class='viewIcon deleteIcon']");
				javascriptButtonClick(deleteButton);
				By el1=By.xpath("//div[@class='filter-data view-delete-ground']//input");
				waitForElementToBeClickable(el1, longWait);
				clickAndWait(el1, longWait);
				waitTillTextPresent("View was deleted successfully.", longWait);
				break loop;
				
			}
			
		}
		
	}
	
}