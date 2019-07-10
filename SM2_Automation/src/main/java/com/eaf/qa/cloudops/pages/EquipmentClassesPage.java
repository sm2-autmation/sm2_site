package com.eaf.qa.cloudops.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eaf.qa.base.BasePage;

public class EquipmentClassesPage extends BasePage
{
	private static Logger Log = LogManager.getLogger(CreateVehiclePage.class.getName());
	
	public EquipmentClassesPage(ThreadLocal<WebDriver> driver) 
	{
		super(driver);
	}
	
	    private By equipmentTab = By.xpath("//div[@id='headerMenu_head-item-assets']");
	
	    private By classesSubTab = By.xpath("//span[@class='page_item_text'][contains(text(),'Classes')]");
	
	    private By SiteManagerClassicDefaultView = By.xpath("//div[@class='view-column-title']//span[text()='SiteManager Classic Default']");

	public void clickOnEquipment()
	{	
		clickAndWait(equipmentTab, longWait);
        Log.info("Equipment tab clicked");
	}
	
	public void clickOnEquipmentClasses()
	{
		clickAndWait(classesSubTab, longWait);
		Log.info("Classes sub tab was clicked under Equipment");
	}
	
	public void clickOnSiteManagerClassicDefaultView()
	{
		clickAndWait(SiteManagerClassicDefaultView, longWait);
		Log.info("SiteManager Classic Default View was clicked");		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}