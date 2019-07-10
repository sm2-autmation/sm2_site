package com.eaf.qa.cloudops.pages;

import java.util.List;

import javax.swing.text.DefaultEditorKit.DefaultKeyTypedAction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.eaf.qa.base.BasePage;
import com.eaf.qa.utils.TestUtils;
import com.thoughtworks.selenium.webdriven.commands.WaitForPageToLoad;

public class RefrenceTablePage extends BasePage {

	public RefrenceTablePage(ThreadLocal<WebDriver> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	private By addEntityButton=By.xpath("//ul[@id='btnList']//div");
	
	private By groupCodeField=By.xpath("//input[@id='EGCO']");
	
	private By groupDescriptionField=By.xpath("//input[@id='EGDE']");
	
	private By saveBttn=By.xpath("//button[@id='btnTopSave']");
	
	private By refrenceTableTab=By.xpath("//span[text()='Reference Tables']//parent::a");
	
	private By nextArrow=By.xpath("//a[@title='Go to the next page']");
	
	
	
	
	public void CreateEntityGroup(String GroupCode,String Description,List<String>ListOfentityToBeAdded)
	{
		clickOnDesiredView("Entity Grouping");
		verifyEntityGroupAndDeleteIfPresent(GroupCode);
		waitForElementToBeClickable(addEntityButton, longWait);
		clickAndWait(addEntityButton, longWait);
		waitForElementToBeClickable(groupCodeField, longWait);
		setText(groupCodeField, GroupCode, longWait);
		setText(groupDescriptionField, Description, longWait);
		
		if(ListOfentityToBeAdded!=null)
		{
			for(int i=0;i < ListOfentityToBeAdded.size();i++)
			{
				Addentities(ListOfentityToBeAdded.get(i));
			}
			
		}
		
		
		
		
		clickAndWait(saveBttn, longWait);
		waitTillTextPresent("Successfully inserted records.", longWait);
		ClickOnRefreshButtonOfDesiredView("Entity Grouping");
		
		Assert.assertTrue(VerifyClassCodeAfterCreation(GroupCode), "Entity group not created yet");
	
	}
	
	
	
	@SuppressWarnings("unlikely-arg-type")
	public void verifyEntityGroupAndDeleteIfPresent(String GroupCode )
	
	{
		ClickOnRefreshButtonOfDesiredView("Entity Grouping");
		int x=1;
		By actionButton1=By.xpath("//tbody[@role='rowgroup']//tr[1]//td[1]");
		waitForElementToBeClickable(actionButton1, longWait);
		outerloop:
		while(x>0)
		{
			TestUtils.sleep(5);
		List<WebElement> code=driver.get().findElements(By.xpath("//tbody[@role='rowgroup']//tr"));
		int size=code.size();
		System.out.println("size is here---------,,,,,,,,,,<<<<<<<<<"+size);
		for(int i=1;i<=size;i++)
		{
			
			WebElement el=driver.get().findElement(By.xpath("//tbody[@role='rowgroup']//tr["+i+"]//td[3]//text"));
			System.out.println("verification start here------------------------>"+el.getText()+"------------->"+i);
			if(el.getText().equals(GroupCode))
			{
				
				By actionButton=By.xpath("//tbody[@role='rowgroup']//tr["+i+"]//td[1]");
				By deleteButtonBox=By.xpath("//div[@role='tooltip']");
				By deleteButton=By.xpath("//div[@role='tooltip']//div[text()='Delete']");
				//Click(actionButton);
				clickAndWait(actionButton, minimalWait);
				waitForElementToBeClickable(deleteButtonBox, minimalWait);
				waitForElementToBeClickable(deleteButton, minimalWait);
				Click(deleteButton);
				handleAlert();
		
				System.out.println("in if^^^^^^^^^^");
				
				ClickOnRefreshButtonOfDesiredView("Entity Grouping");
				waitForElementToBeClickable(actionButton1, longWait);
				break outerloop;
		
			}	
		}
		System.out.println("-------------------------------------------class here"+getAttribute(nextArrow, "class")+"xxxxxxxxxxxxx---------"+x);
		if(getAttribute(nextArrow, "class").equals("k-link k-pager-nav"))
		{	
			By nextArrow1=By.xpath("//a[@title='Go to the next page']//span");
			
			clickAndWait(nextArrow1, longWait);
			x++;
		}
		else
		{		
			x=0;			
		}

		}
	}
	
	
	
	public void EditGroup(String GroupCode,String UpdatedNameOfGroupCode,String UpdatedDescription,List<String>listOfEntitiesToBeAdded,List<String>listOfEntitiesToBeDeleted)
	{
		if(UpdatedNameOfGroupCode!=null)
		{
			verifyEntityGroupAndDeleteIfPresent(UpdatedNameOfGroupCode);
		}
		
		ClickOnRefreshButtonOfDesiredView("Entity Grouping");
		
		
		ClickOnEditButtonOfDesiredGroupCode(GroupCode);
		if(UpdatedNameOfGroupCode!=null)
		{
			By GroupCodeField=By.xpath("//input[@id='EGCO']");
			System.out.println("we are looking here");
			setText(GroupCodeField, UpdatedNameOfGroupCode, longWait);
			
			
		}
		if(UpdatedDescription!=null)
		{
			setText(groupDescriptionField, UpdatedDescription, longWait);
			
		}
		if(listOfEntitiesToBeAdded!=null)
		{
			for(int i=0;i<listOfEntitiesToBeAdded.size();i++)
			{
			Addentities(listOfEntitiesToBeAdded.get(i));
			}
		}
		
			if(listOfEntitiesToBeDeleted!=null)
			{
				TestUtils.sleep(5);
			for(int i=0;i<listOfEntitiesToBeDeleted.size();i++)
			{
				
				DeleteEntities(listOfEntitiesToBeDeleted.get(i));
			}
			
			}
		
		clickAndWait(saveBttn, longWait);
		waitTillTextPresent("Successfully updated 1 records.", longWait);
		ClickOnRefreshButtonOfDesiredView("Entity Grouping");
		if(UpdatedNameOfGroupCode!=null)
		{
			Assert.assertTrue(VerifyClassCodeAfterCreation(UpdatedNameOfGroupCode), "Updated Entity group not created yet");
			
		}
		else
		{
		
		Assert.assertTrue(VerifyClassCodeAfterCreation(GroupCode), "Entity group not created yet");
	
		}
		
	}
	
	
	
	
	public void DeleteEntities(String EntityToBeDeleted)
	{
		if(EntityToBeDeleted!=null)
		{
		//By entityField=By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']//input");
			
		By EntityDeleteButton=By.xpath("//ul[@id='EGEN_taglist']//span[text()='"+EntityToBeDeleted+"']//following-sibling::span");
		waitForElementToBeClickable(EntityDeleteButton, longWait);
		clickAndWait(EntityDeleteButton, longWait);
		
		//javascriptButtonClick(EntityDeleteButton);	
			TestUtils.sleep(2);
		}
		
		
		
	}
	
	
	public void ClickOnEditButtonOfDesiredGroupCode(String GroupCode)
	{
		
		By currentView=By.xpath("//span[text()='Entity Grouping']//ancestor::div[@title='Entity Grouping']");
		if(getAttribute(currentView, "class").equals("filter-column-title filter-view"))
	{
		clickOnDesiredView("Entity Grouping");
	}	
		int x=1;
		By actionButton1=By.xpath("//tbody[@role='rowgroup']//tr[1]//td[1]");
		waitForElementToBeClickable(actionButton1, longWait);
		outerloop:
		while(x>0)
		{
			TestUtils.sleep(5);
		List<WebElement> code=driver.get().findElements(By.xpath("//tbody[@role='rowgroup']//tr"));
		int size=code.size();
		
		System.out.println("size is here---------,,,,,,,,,,<<<<<<<<<"+size);
		System.out.println("group code is ___________"+GroupCode);
		for(int i=1;i<=size;i++)
		{
			
			WebElement el=driver.get().findElement(By.xpath("//tbody[@role='rowgroup']//tr["+i+"]//td[3]//text"));
			System.out.println("verification start here------------------------>"+el.getText()+"------------->"+i);
			if(el.getText().equals(GroupCode))
			{
				
				By actionButton=By.xpath("//tbody[@role='rowgroup']//tr["+i+"]//td[1]");
				By deleteButtonBox=By.xpath("//div[@role='tooltip']");
				By EditButton=By.xpath("//div[@role='tooltip']//div[text()='Edit']");
				//Click(actionButton);
				clickAndWait(actionButton, minimalWait);
				waitForElementToBeClickable(deleteButtonBox, minimalWait);
				waitForElementToBeClickable(EditButton, minimalWait);
				Click(EditButton);
				break outerloop;
		
			}
			
		
		
		
		}
		System.out.println("-------------------------------------------class here"+getAttribute(nextArrow, "class")+"xxxxxxxxxxxxx---------"+x);
		if(getAttribute(nextArrow, "class").equals("k-link k-pager-nav"))
		{
			
			By nextArrow1=By.xpath("//a[@title='Go to the next page']//span");
			
			clickAndWait(nextArrow1, longWait);
			x++;
		}
		else
		{
			
			x=0;
			
		}

		}
	}	
		
	public boolean verifyEntitiesAfterAdding(String GroupCode, List<String>ListOfentity)
	{
		
		boolean status=false;
		ClickOnEditButtonOfDesiredGroupCode(GroupCode);
		int x=ListOfentity.size();
		int y=x;
		System.out.println("-------------------------------size of array"+x);
		int i=0;
		outerloop:
		for(i=0;i<x;i++)
		{
		By entity =By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']//span[text()='"+ListOfentity.get(i)+"']");
		
		By input=By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']//input");
		waitForPageLoaded();
		TestUtils.sleep(5);
		
		if(getElementIfVisibleUsingXpath(entity, shortWait))
		{
			y=y-1;
			
			System.out.println("--------------------------------->"+ListOfentity.get(i)+"entity is present<----------------------------");
		}
		else 
		{
			break outerloop;
		}
		
		
		}
		
		System.out.println("-------------------------->value of y-------------------------------------------------------------------------------------------------------------------------------------->"+y);	
		if(y==0)
		{
			clickAndWait(By.xpath("//button[@id='btnTopCancel']"), longWait);
			
			status=true;
			
		}
		return status;
	}
		
		
	public boolean VerifyEntitiesAfterDeleting(String GroupCode, List<String>ListOfentity)
	{
		boolean status=false;
		ClickOnEditButtonOfDesiredGroupCode(GroupCode);
		int x=ListOfentity.size();
		int y=x;
		System.out.println("-------------------------------size of array"+x);
		int i=0;
		outerloop:
		for(i=0;i<x;i++)
		{
		By entity =By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']//span[text()='"+ListOfentity.get(i)+"']");
		//By el=By.xpath("//td[@id='tdFieldEGEN']");
		//waitForElementToBeClickable(el, longWait);
		waitForPageLoaded();
		
		if(!getElementIfVisibleUsingXpath(entity, longWait))
		{
			y=y-1;
			
			System.out.println("--------------------------------->"+ListOfentity.get(i)+" entity is absent<----------------------------");
		}
		else 
		{
			break outerloop;
		}
		
		}
		
		System.out.println("-------------------------->value of y----------------------------------------->"+y);	
		if(y==0)
		{
			By cancel =By.xpath("//button[@id='btnTopCancel']");
			clickAndWait(cancel, longWait);
			By actionButton1=By.xpath("//tbody[@role='rowgroup']//tr[1]//td[1]");
			waitForElementToBeClickable(actionButton1, longWait);
			status=true;
			
		}
		return status;
	
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void ClickOnRefreshButtonOfDesiredView(String NameOfView)
	{
	
		clickOnDesiredView(NameOfView);
		By temp2= By.xpath("//div[@class='view-column-title']//span[text()='"+NameOfView+"']//parent::div[1]//parent::div[@class='filter-column-title filter-view current-view']//following-sibling::div[1]//div[@title='Refresh']");
		waitForElementToBeClickable(temp2, shortWait);	
		Click(temp2);
		By actionButton1=By.xpath("//tbody[@role='rowgroup']//tr[1]//td[1]");
		waitForElementToBeClickable(actionButton1, longWait);
		
	}
	
	
	public void ClickOnSystemTab()
	{
		
		By systemTab=By.xpath("//li[@title='System']//div");
		waitForElementToBeClickable(systemTab, longWait);
		
		clickAndWait(systemTab, longWait);
		waitForElementToBeClickable(refrenceTableTab, longWait);
		
	}
	
	public void ClickonRefrenceTableTab()
	{
		By Viewlist=By.xpath("//ul[@id='sortableList']");
		waitForElementToBeClickable(refrenceTableTab, longWait);
	
	    clickAndWait(refrenceTableTab, longWait);
	    waitForElementToBeClickable(Viewlist, longWait);
	
	}
	
	public void clickOnDesiredView(String NameOfView)
	{
		By currentView=By.xpath("//span[text()='Entity Grouping']//ancestor::div[@title='Entity Grouping']");
		if(getAttribute(currentView, "class").equals("filter-column-title filter-view"))
	{
		
		
        By temp1 = By.xpath("//ul[@id='sortableList']//li//div//div//span[(text()='"+NameOfView+"')]");
		
		waitForElementToBeClickable(temp1, longWait);
		clickAndWait(temp1, longWait);
		By actionButton1=By.xpath("//tbody[@role='rowgroup']//tr[1]//td[1]");
		waitForElementToBeClickable(actionButton1, longWait);
	}
		
	}
	
	
	public void Addentities(String entity1)
	{
		By entityField=By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']//input");
		if(entity1!=null)
		{
		
			
			setText(entityField, entity1, longWait);
			TestUtils.sleep(3);
			pressEnter();
			
		
		
		}
		
	}
	

	public boolean VerifyClassCodeAfterCreation(String GroupCode)
	{
		ClickOnRefreshTillCodeFound(GroupCode);
		
		boolean status=false;
		int x=1;
		By actionButton1=By.xpath("//tbody[@role='rowgroup']//tr[1]//td[1]");
		waitForElementToBeClickable(actionButton1, longWait);
		outerloop:
		while(x>0)
		{
			TestUtils.sleep(5);
		List<WebElement> code=driver.get().findElements(By.xpath("//tbody[@role='rowgroup']//tr"));
		int size=code.size();
		System.out.println("size is here---------,,,,,,,,,,<<<<<<<<<"+size);
		for(int i=1;i<=size;i++)
		{
			
			WebElement el=driver.get().findElement(By.xpath("//tbody[@role='rowgroup']//tr["+i+"]//td[3]//text"));
			System.out.println("verification start here------------------------>"+el.getText()+"------------->"+i);
			
			if(el.getText().equals(GroupCode))
			{
				System.out.println("IF ----------------------IF");
				status=true;
				
				break outerloop;
		
				
				
			}
			
		
		
		
		}
		System.out.println("-------------------------------------------class here"+getAttribute(nextArrow, "class")+"xxxxxxxxxxxxx---------"+x);
		if(getAttribute(nextArrow, "class").equals("k-link k-pager-nav"))
		{
			
			By nextArrow1=By.xpath("//a[@title='Go to the next page']//span");
			
			clickAndWait(nextArrow1, longWait);
			x++;
		}
		else
		{
			
			x=0;
			
		}

		}
	

		return status;
	}
	
	
	
	
	public void ClickOnRefreshTillCodeFound(String GroupCode)
	{
		
		for(int i=0;F1(GroupCode) ==!(false);i++)
		{
			ClickOnRefreshButtonOfDesiredView("Entity Grouping");
			
		}
		
		
		
	}
	
	
	
	public boolean F1(String GroupCode )
	{
		System.out.println("in the f1................,,,,,,,,============");
		boolean status=true;
		int x=1;
		By actionButton1=By.xpath("//tbody[@role='rowgroup']//tr[1]//td[1]");
		waitForElementToBeClickable(actionButton1, longWait);
		outerloop:
		while(x>0)
		{
			TestUtils.sleep(5);
		List<WebElement> code=driver.get().findElements(By.xpath("//tbody[@role='rowgroup']//tr"));
		int size=code.size();
		System.out.println("size is here---------,,,,,,,,,,<<<<<<<<<"+size);
		for(int i=1;i<=size;i++)
		{
			System.out.println("ALL THESE THINGS ARE IN f1()................,,,,,,,,============");
			
			WebElement el=driver.get().findElement(By.xpath("//tbody[@role='rowgroup']//tr["+i+"]//td[3]//text"));
			System.out.println("verification start here------------------------>"+el.getText()+"------------->"+i);
			System.out.println("Expected Group code"+GroupCode+"------------->"+i);
			
			if(el.getText().equals(GroupCode))
			{
				System.out.println("i want here");
				status=false;
				
				break outerloop;
		
				
			}
			
		
		
		
		}
		System.out.println("-------------------------------------------class here"+getAttribute(nextArrow, "class")+"xxxxxxxxxxxxx---------"+x);
		if(getAttribute(nextArrow, "class").equals("k-link k-pager-nav"))
		{
			
			By nextArrow1=By.xpath("//a[@title='Go to the next page']//span");
			
			clickAndWait(nextArrow1, longWait);
			x++;
		}
		else
		{
			
			x=0;
			
		}

		}
		return status;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
