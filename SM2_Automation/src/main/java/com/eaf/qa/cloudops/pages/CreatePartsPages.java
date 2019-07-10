package com.eaf.qa.cloudops.pages;

import java.awt.AWTException;
import java.util.List;

import org.codehaus.groovy.runtime.wrappers.LongWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.eaf.qa.base.BasePage;
import com.eaf.qa.utils.DataUtils;
import com.eaf.qa.utils.TestUtils;

public class CreatePartsPages extends BasePage
{

	public CreatePartsPages(ThreadLocal<WebDriver> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	private By partsAndTradesTab = By.xpath("//div[@id='headerMenu_head-item-parts']");
	
	private By partsTab = By.xpath("//div[@id='pageMenu']//ul//li[1]//a//span[1]");
	
	private By addParts = By.xpath("//div[@id='pageMenu']//ul//li[1]//a//div");
	
	private By PartCodeField = By.xpath("//input[@id='PCII']");
	
	private By allPartLink = By.xpath("//ul[@id='sortableList']//li[1]//div[@index='0']//div[1]");
	
    private By starFilterIcon = By.xpath("//label[@title='Equal To']");
	
	private By starFilterIconField = By.xpath("//div[@class='filter-column-title selectedFilter']/following-sibling::div[2]/input");
	
	private By filterIcon = By.xpath("//div[@id='view-action-filter']");

	private By partNumberFilter = By.xpath("//div[contains(text(),'Part #')]");

	private By refreshIcon= By.xpath("//div[@class='buttonHeader']//div[@class='RefreshIcon ViewIcons']");
	
	private By descField = By.xpath("//input[@id='PCDE']");
	
	private By saveBttn = By.xpath("//button[@id='btnTopSave']");
	private By ViewSaveBttn = By.id("saveBtn");
	
	private By leftpanel=By.xpath("//ul[@id='sortableList']");
	
 
	public void addParts()
	{
			
		waitForElementToBeClickable(partsAndTradesTab, longWait);
		Click(partsAndTradesTab);
		waitForElementToBeClickable(partsTab, longWait);
		Click(partsTab);
		waitForElementToBeClickable(allPartLink, longWait);
		Click(allPartLink);
		
		
		
		for(int i=1;DataUtils.getTestData("PartsAndTrades", "Part", "Part"+i)!=null;i++)
		{
		creatingPart(i);
		}
		
		
	}
		
		
		
		public void creatingPart(int i)
		{
		System.out.println("--------------------------------->number="+i);
		waitForElementToBeClickable(filterIcon, longWait);
		clickAndWait(filterIcon, shortWait);
		TestUtils.sleep(2);
		if(i>1)
		{
			clickAndWait(partNumberFilter, shortWait);
			
		}
		clickAndWait(partNumberFilter, shortWait);
		waitForElementToBeClickable(starFilterIcon, longWait);
		clickAndWait(starFilterIcon, shortWait);
	
		setText(starFilterIconField, DataUtils.getTestData("PartsAndTrades", "Part", "Part"+i), shortWait);
		clickAndWait(refreshIcon, shortWait);
		TestUtils.sleep(5);
		if((isTextPresentOnPage(DataUtils.getTestData("PartsAndTrades", "Part", "Part"+i))))
		{

			System.out.println("inside for------------------------------------------");
			System.out.println("Part is already created");
			return;
		
			
			
		}

		else
		{
			Click(addParts);
			waitForElementToBeClickable(PartCodeField, shortWait);
			setText(PartCodeField, DataUtils.getTestData("PartsAndTrades", "Part", "Part"+i), shortWait);
			setText(descField, DataUtils.getTestData("PartsAndTrades", "Desc", "Desc"+i), shortWait);
			Click(saveBttn);
			
		}
		
		
		
	}
	
	
		
		public void AddAPartTC_4b()
		{
			
			//waitForElementToBeClickable(partsAndTradesTab, longWait);
			//Click(partsAndTradesTab);
			waitForElementToBeClickable(partsTab, longWait);
			Click(partsTab);
			

			Click(addParts);
			waitForElementToBeClickable(PartCodeField, shortWait);
			setText(PartCodeField, "041-001-000-8N-6309", shortWait);
			setText(descField, "Engine Air Filter for CAT 9S Generator", shortWait);
			
			Click(saveBttn);
			
		}
		
		
		
		public void ClickOnPartsSubTab()
		{
			
			
			waitForElementToBeClickable(partsTab, longWait);
			clickAndWait(partsTab, longWait);
			waitForElementToBeClickable(leftpanel, longWait);
			
		}
		
		
		
		
		public void Addfilter2InAView(String NameOfView,List<String> list3 ) throws AWTException
		{
			
			getBasicControllersPage().ClickOnEditIconButtonOfDesiredView(NameOfView);
			getBasicControllersPage().addparametrs(null, list3, null);
			javascriptButtonClick(ViewSaveBttn);
			waitTillTextPresent("View was saved successfully.", longWait);
			Assert.assertTrue(getBasicControllersPage().verifyViewAfterCreation(NameOfView), "Created View, not found");
		
			getBasicControllersPage().ClickOnSetFilterButtonOfDesiredView(NameOfView);
			getBasicControllersPage().AddFilterFromView(list3.get(0), "Contains","045-011-000-PF48");
			//Assert.assertTrue(verifyFilterEffect2(NameOfView,"045-011-000-PF48"), "filter effect is not seen");
						
		}
		
		
		
		public boolean verifyFilterEffect2(String NameOfView,String NameToBVerified)
		{
			boolean status=false;
			 int j=1;
				//System.out.println("Desired name--------->>>>>>"+NameOfSupplier);
				

				
				By actionButton1=By.xpath("//tbody[@role='rowgroup']//tr[1]//td[1]");
				
				while(j>0)
				{
				getBasicControllersPage().ClickOnRefreshButtonOfDesiredView(NameOfView);
				waitForElementToBeClickable(actionButton1, longWait);
				
				List<WebElement> code=driver.get().findElements(By.xpath("//tbody[@role='rowgroup']//tr"));
				int size=code.size();
				
				for(int i=1;i<=size;i++)
				{
					WebElement el=driver.get().findElement(By.xpath("//tbody[@role='rowgroup']//tr["+i+"]//td[7]//text"));
					
					System.out.println("verification to edit start here------------------------>"+el.getText()+"------------->"+i);
					if(el.getText().contains(NameToBVerified) )
					{System.out.println("All element with "+el.getText()+" is present");
					if( getElementIfVisibleUsingXpath(By.xpath("//tbody[@role='rowgroup']//tr["+i+"]//td[17]"), longWait))
					{
						status=true;
						return status;
					}
					}
				}
				
				if (getAttributeValue(By.xpath("//a[@title='Go to the next page']"), "class").contains("disabled"))
				{

					System.out.println("---------------here is ur thing"+getAttribute(By.xpath("//a[@title='Go to the next page']"), "class"));
					j = 0;

				}
				else 
				{
					System.out.println("---------------here is ur thing in else"+getAttributeValue(By.xpath("//a[@title='Go to the next page']"), "class"));
					
					clickAndWait(By.xpath("//a[@title='Go to the next page']//span"), longWait);

					j++;
				}

				
				
				
				}
			
			
			return status;
			
		}



		public void AddparametersinView(String NameOfView,List<String> list3) throws AWTException
		{
			
			getBasicControllersPage().ClickOnEditIconButtonOfDesiredView(NameOfView);
			getBasicControllersPage().addparametrs(list3, null, null);
			
			javascriptButtonClick(ViewSaveBttn);
			waitForElementToBeClickable(leftpanel, longWait);
			Assert.assertTrue(getBasicControllersPage().verifyViewAfterCreation(NameOfView), "Edited view not created");
			
			
			
		}
			
		public void verifySubViewAndItsFunctioning(String NameOfView)
		{
			getBasicControllersPage().ClickOnRefreshButtonOfDesiredView(NameOfView);
			
			By actionButton1=By.xpath("//tbody[@role='rowgroup']//tr[1]//td[1]//a");
			
		
			waitForElementToBeClickable(actionButton1, longWait);
			clickAndWait(actionButton1, longWait);
			
			waitForElementToBecomeVisible(By.xpath("//tr[@class='k-detail-row k-alt']"), longWait);
			
			
		}
		
		
		
		
}
	
	
	
	
	
	


