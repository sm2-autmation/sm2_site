package com.eaf.qa.uitests;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.List;

import org.apache.bcel.verifier.exc.AssertionViolatedException;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class PartsAndTradesTest4 extends BaseTest 
{
	@Test
	 public void CreateStoragelocationsUnderPartsAndTrades4() throws AWTException
	 {
		
	test = extent.startTest("Create Storagelocations Under Parts And Trades");

	// Login Credentials
	test.log(LogStatus.INFO, "Successfully logged in as Admin");
	pages.getLoginPage().logInToSM2("Admin", "fz;1234");
	
	test.log(LogStatus.INFO, "Successfully Clicked on Parts and Trade Sub Tab ");
	pages.getStorageLocationPage().ClickOnPartsAndTradeSubTab();
	
	test.log(LogStatus.INFO, "Successfully Clicked on Storage Location Sub Tab ");
	pages.getStorageLocationPage().ClickOnStorageLocationTab();
	
	test.log(LogStatus.INFO, "Adding a storage Location And verifying After Creation");
	pages.getStorageLocationPage().AddAndVerifyStorageLocationAfterCreating("EXAPLE", "De Gaspé 6700");
	
	test.log(LogStatus.INFO, "Editing a storage Location And verifying After Editing");
	pages.getStorageLocationPage().EditAndVerifyAfterEditingStorageLocation("EXAPLE", "TYTYTYTT", "popopopo");
	
	test.log(LogStatus.INFO, "Clone a view");
	pages.getBasicControllersPage().cloneView("Storage Locations List", "Storage Locations and Shelves");
	List<String> list1 = new ArrayList<String>();
	list1.add("Storage Location #");
	
	test.log(LogStatus.INFO, "Editing a View And Adding a sub-View");
	pages.getStorageLocationPage().editViewAndAddSubView("Storage Locations and Shelves", "Parts", "ALL Parts",list1);
	
//	test.log(LogStatus.INFO, "Adding a storage Location And verifying After Creation");
//	pages.getStorageLocationPage().AddAndVerifyStorageLocationAfterCreating("WVA-3200", "Workshop Vancouver Airport Ave");
//	
//	
//	test.log(LogStatus.INFO, "Adding a storage Location And verifying After Creation");
//	pages.getStorageLocationPage().AddAndVerifyStorageLocationAfterCreating("POR-0970", "Workshop Maxim Service on Portage");
//	
//	
//	test.log(LogStatus.INFO, "Adding a storage Location And verifying After Creation");
//	pages.getStorageLocationPage().AddAndVerifyStorageLocationAfterCreating("GCA-1000", "Garage Central Ave 1000 Halifax");
//	
	test.log(LogStatus.INFO, "Adding a storage Location And verifying After Creation");
	pages.getStorageLocationPage().AddAndVerifyStorageLocationAfterCreating("WDI-3205", "Workshop De-Icing");
	
	
	Reporter.log("Created Storage Location");
	test.log(LogStatus.PASS, "Created Storage locations Under PartsAndTrades");
	 }
	
	@Test
	 public void SuppliersTestingManualEntryUnderPartsAndTrades4a() throws AWTException
	 {
		
	test = extent.startTest("Create Suppliers Under Parts And Trades");

	test.log(LogStatus.INFO, "Successfully logged in as Admin");
	pages.getLoginPage().logInToSM2("Admin", "fz;1234");
	
	test.log(LogStatus.INFO, "Successfully Clicked on Parts and Trade Sub Tab ");
	pages.getStorageLocationPage().ClickOnPartsAndTradeSubTab();
	
	test.log(LogStatus.INFO, "Successfully Clicked on Supplier Sub Tab ");
	pages.getSuppliersPage().ClickOnSupplierTab();
	
	test.log(LogStatus.INFO, "Adding supplier and verify supplier after adding ");
	pages.getSuppliersPage().AddSupplierAndVerifyAfterAdding("MIDLAND-023", "Midland Lubricants Ltd.",null,null);			
	
	
	
	
	
	Reporter.log("Created Supplier");
	test.log(LogStatus.PASS, "Created supplier Under PartsAndTrades");
	 
	 }
	
	@Test(enabled=false)
	 public void CreateAPartUnderPartsAndTrades4b() throws AWTException
	 {
		
	test = extent.startTest("Create Suppliers Under Parts And Trades");

	

	pages.getLoginPage().logInToSM2("Admin", "fz;1234");
	
	pages.getStorageLocationPage().ClickOnPartsAndTradeSubTab();
	
	
	
	
	
	 }
	
	
	
	@Test(enabled=true)
	 public void CreateImportModelForSupplierUnderImportsTab4c() throws AWTException
	 {
		
		test = extent.startTest("Create Import Model For Supplier");

		List<String> list3 = new ArrayList<String>();
		list3.add("Phone");
		list3.add("Address 1");
		list3.add("Address 2");
		list3.add("City");
		list3.add("Province / State");
		System.out.println("index of----------->"+list3.indexOf("City"));


		test.log(LogStatus.INFO, "Successfully logged in as Admin");
		pages.getLoginPage().logInToSM2("Admin", "fz;1234");
		
		test.log(LogStatus.INFO, "Successfully Clicked on System Tab");
		pages.getRefrenceTablePage().ClickOnSystemTab();
		
		test.log(LogStatus.INFO, "Clicking on Imports Tab");
		pages.getCreateEntityAtImportsSubTabUnderSystemTab().clickOnImportsTab();
		
	
		
		
		test.log(LogStatus.INFO, "Creating entity page and deleting if present");
		pages.getCreateEntityAtImportsSubTabUnderSystemTab().createEntity("Supplier", "IMPORT of Suppliers", list3);
		
		String filepath =System.getProperty("user.dir") + "/" + "resources" + "/" + "importfiles" + "/"+ "Suppliers - ALL.csv";


		test.log(LogStatus.INFO, "Execute entity and adding csv file");
		pages.getCreateEntityAtImportsSubTabUnderSystemTab().ExecuteEntity("Supplier", "IMPORT of Suppliers", filepath);
		
		
		
		
	 }
	@Test
	 public void CreateAViewUnderSupplier4cand4d() throws AWTException
	 {
		
	test = extent.startTest("Create View under suppliers");

	List<String> list3 = new ArrayList<String>();
	list3.add("Supplier #");
	list3.add("Supplier Name");
	list3.add("Phone");
	list3.add("Address 1");
	list3.add("Address 2");
	list3.add("City");
	list3.add("Province / State");
	list3.add("Country");
	list3.add("Postal Code");


	test.log(LogStatus.INFO, "Successfully logged in as Admin");
	pages.getLoginPage().logInToSM2("Admin", "fz;1234");
	
	test.log(LogStatus.INFO, "Successfully Clicked on Parts and Trade Tab ");
	pages.getStorageLocationPage().ClickOnPartsAndTradeSubTab();
	
	test.log(LogStatus.INFO, "Successfully Clicked on Supplier Sub Tab ");
	pages.getSuppliersPage().ClickOnSupplierTab();
	
	test.log(LogStatus.INFO, "Creating a view ");
	pages.getBasicControllersPage().CreateAView("List of All Suppliers", list3, null, null, null, null);
	
	test.log(LogStatus.INFO, "Verify Supplier After Creating");
	pages.getSuppliersPage().verifySupplierNumberAfterCreating("COENCORP-999");
	
	test.log(LogStatus.INFO, "Add contact");
	pages.getSuppliersPage().AddcontactTc_4d("ENERGIZER-215");
	
	test.log(LogStatus.INFO, "Adding supplier and verify after adding");
	pages.getSuppliersPage().AddSupplierAndVerifyAfterAdding("SUP-001", "Battery Supplier",null,null);

	test.log(LogStatus.INFO, "Edit the supplier and changing description");
	pages.getSuppliersPage().EditTheSupplier("SUP-001", " not a Battery Supplier");	
	
	test.log(LogStatus.INFO, "Deleting the supplier");
	pages.getSuppliersPage().ClickOnDeleteButtonOfdesiredSupplier("SUP-001");
	
	
	List<String> list4 = new ArrayList<String>();
	list4.add("Province / State");
	
	//pages.getSuppliersPage().AddfilterInAView("List of All Suppliers", list4);
	
	List<String> list5 = new ArrayList<String>();
	list5.add("City");
	

	test.log(LogStatus.INFO, "Edit a view and adding a Filter ");
	pages.getSuppliersPage().Addfilter2InAView("List of All Suppliers", list5);
	
	
	
	
	
	
	
	 }
	
	
	
	
	@Test
	 public void SuppliersForGeneratorsTestingManualEntries4e() throws AWTException
	 {
		
	test = extent.startTest("Adding Multiple suppliers");

	

	test.log(LogStatus.INFO, "Successfully logged in as Admin");
	
	pages.getLoginPage().logInToSM2("Admin", "fz;1234");
	

	test.log(LogStatus.INFO, "Successfully Clicked on Parts and Trade Tab ");
	pages.getStorageLocationPage().ClickOnPartsAndTradeSubTab();
	
	test.log(LogStatus.INFO, "Successfully Clicked on Supplier Sub Tab ");
	pages.getSuppliersPage().ClickOnSupplierTab();
	
	test.log(LogStatus.INFO, "Adding supplier and verify after adding");
	pages.getSuppliersPage().AddSupplierAndVerifyAfterAdding("CLARM-N-WINTER-025", "CLARMO & WINTER TRUCKING","(613) 822-4548"," 3300 A RIDEAU RD.OTTAWA, ON, Canada, K1G 3N4");			
	
	test.log(LogStatus.INFO, "Adding supplier and verify after adding");
	pages.getSuppliersPage().AddSupplierAndVerifyAfterAdding("CPL-SYSTEMS-036", "CPL SYSTEMS CANADA INC","(905) 875-1017"," 8450 LAWSON ROAD,MILTON, ON, Canada, L9T 0J8");			
	
	test.log(LogStatus.INFO, "Adding supplier and verify after adding");
	pages.getSuppliersPage().AddSupplierAndVerifyAfterAdding("LUBRI-EXP-108", "Lubri-Expert Inc.","(450) 687-4334"," 3166, boul. Le Corbusier, Laval, QC, Canada, H7L 4S8");			
	
	
	 }
	
	@Test
	 public void CreateManufacturer5() throws AWTException
	 {
		
	test = extent.startTest("Creating multiple manufacturer");

	

	test.log(LogStatus.INFO, "Successfully logged in as Admin");
	
	pages.getLoginPage().logInToSM2("Admin", "fz;1234");
	
	test.log(LogStatus.INFO, "Successfully Clicked on Parts and Trade Tab ");
	pages.getStorageLocationPage().ClickOnPartsAndTradeSubTab();
	
	test.log(LogStatus.INFO, "Successfully Clicked on Manufacturer Sub Tab ");
	pages.getManufacturerPage().clickOnManufacturerTab();
	
	test.log(LogStatus.INFO, "Adding Manufacturer and verify after adding");
	pages.getManufacturerPage().AddManufacturerAndVerifyAfterAdding("MANUF-003", "General Tires of Canada", null);
	
	test.log(LogStatus.INFO, "Editing Manufacturer and verify after adding");
	pages.getManufacturerPage().EditManufacturer("MANUF-003", "(800) 630-446-7487");
	
	test.log(LogStatus.INFO, "Adding Manufacturer and verify after adding");
	pages.getManufacturerPage().AddManufacturerAndVerifyAfterAdding("SHELL-CAN-211", "Shell Canada", "(514) 356-7000");
	
	
	
	
	 }
	
	
	@Test
	public void ImportOfManufacturer5a()
	{
		
		test = extent.startTest("Verify import of manufacturer");

		// Login Credentials
		test.log(LogStatus.INFO, "Successfully logged in as Admin");
		pages.getLoginPage().logInToSM2("Admin", "fz;1234");
		
		
		
		test.log(LogStatus.INFO, "Successfully Clicked on System Tab");
		pages.getRefrenceTablePage().ClickOnSystemTab();
		
		
		test.log(LogStatus.INFO, "Clicking on Imports Tab");
		pages.getCreateEntityAtImportsSubTabUnderSystemTab().clickOnImportsTab();
		
		
		List<String> list1 = new ArrayList<String>();
		list1.add("Phone");
		list1.add("Address 1");
		list1.add("Address 2");
		list1.add("City");
		list1.add("Province / State");
		list1.add("Country");
		list1.add("Postal Code");
		
		 String filepath =System.getProperty("user.dir") + "/" + "resources" + "/" + "importfiles" + "/"+ "Manufacturers - All.csv";

		 test.log(LogStatus.INFO, "Creating entity page and deleting if present");
			
		 pages.getCreateEntityAtImportsSubTabUnderSystemTab().createEntity("Manufacturer", "IMPORT of Manufacturers", list1);

		 test.log(LogStatus.INFO, "Executing entity and importing csv file");
		 pages.getCreateEntityAtImportsSubTabUnderSystemTab().ExecuteEntity("Manufacturer", "IMPORT of Manufacturers", filepath);
		 
	}
	
	
	
	
	
	@Test
	 public void CreateAViewUnderManufacturer5b() throws AWTException
	 {
		
	test = extent.startTest("Create View under suppliers");

	

	test.log(LogStatus.INFO, "Successfully logged in as Admin");
	pages.getLoginPage().logInToSM2("Admin", "fz;1234");
	
	test.log(LogStatus.INFO, "Successfully Clicked on Parts and Trade Tab ");
	
	pages.getStorageLocationPage().ClickOnPartsAndTradeSubTab();
	
	test.log(LogStatus.INFO, "Successfully Clicked on Manufacturer Tab ");
	
	pages.getManufacturerPage().clickOnManufacturerTab();
	
	List<String> list1 = new ArrayList<String>();
	list1.add("Manufacturer #");
	list1.add("Manufacturer Name");
	list1.add("Hidden");
	list1.add("Phone");
	list1.add("Address 1");
	list1.add("Address 2");
	list1.add("City");
	list1.add("Province / State");
	list1.add("Country");
	list1.add("Postal Code");
	list1.add("Contact Email");
	
	test.log(LogStatus.INFO, "creating a view");
	pages.getBasicControllersPage().CreateAView("Manufacturers List-Duplicate", list1, null, null, null, null);
	
	test.log(LogStatus.INFO, "verifying manufacturer after creating view");
	actions.verify(pages.getManufacturerPage().verifyManufacturerLocationAfterCreating("BALDWIN-020"), true, "Manufacturer not created");
	
	List<String> list3 = new ArrayList<String>();
	list3.add("Province / State");
	
	test.log(LogStatus.INFO, "Adding filter in a view and and verifying its effect");
	 pages.getManufacturerPage().Addfilter2InAView("Manufacturers List-Duplicate", list3);
	 }
	
	
	@Test
	 public void  PartsTestingASubViewsupplierHavingApictureInAView5c() throws AWTException
	 {
		
	test = extent.startTest("Create View under suppliers");

	test.log(LogStatus.INFO, "Successfully logged in as Admin");
	
	pages.getLoginPage().logInToSM2("Admin", "fz;1234");
	
	test.log(LogStatus.INFO, "Successfully Clicked on Parts and Trade Tab ");
	pages.getStorageLocationPage().ClickOnPartsAndTradeSubTab();
	
	test.log(LogStatus.INFO, "Successfully Clicked on Parts Sub Tab ");
	pages.getCreatePartsPages().ClickOnPartsSubTab();
	
	
	List<String> list1 = new ArrayList<String>();
	list1.add("Part #");
	list1.add("Description");
	list1.add("Shelf Number");
	list1.add("Manufacturer #");
	list1.add("Manufacturer Name");
	list1.add("Cost ($)");
	list1.add("Group Code");
	list1.add("Price ($)");
	list1.add("Inventory");
	list1.add("Reorder Level");
	
	test.log(LogStatus.INFO, "creating a view");
	pages.getBasicControllersPage().CreateAView("Parts with Suppliers", list1, null, null, "Supplier", "List of All Suppliers");
	
	List<String> list3 = new ArrayList<String>();
	list3.add("Part #");
	
	test.log(LogStatus.INFO, "Adding filter in a view and and verifying its effect");
	 pages.getCreatePartsPages().Addfilter2InAView("Parts with Suppliers", list3);
		
	 
	 List<String> list4 = new ArrayList<String>();
		list4.add("Attached File");
		test.log(LogStatus.INFO, "verifying sub-view and its functioning");
		 pages.getCreatePartsPages().verifySubViewAndItsFunctioning("Parts with Suppliers");
		 
		 test.log(LogStatus.INFO, "Adding parameter in view");
		 pages.getCreatePartsPages().AddparametersinView("Parts with Suppliers", list4);
		 
		 test.log(LogStatus.INFO, "Adding filter in a view and and verifying its effect");
		actions.verify(pages.getCreatePartsPages().verifyFilterEffect2("Parts with Suppliers", "045-011-000-PF48"), true, "attached file is not showing images"); ;
		
		test.log(LogStatus.INFO, "Editing a view");		
		pages.getBasicControllersPage().editView("Parts with Suppliers", null, list4, null, null);
		 
	 
		test.log(LogStatus.INFO, "Adding filter in a view and and verifying its effect");
		actions.verify(pages.getCreatePartsPages().verifyFilterEffect2("Parts with Suppliers", "045-011-000-PF48"), false, "attached file is still showing images"); 
		
	 }
	
	
	

	@Test
	 public void  PartsTestingASubViewManufacturerHavingApictureInAView5d() throws AWTException
	 {
		
	test = extent.startTest("Create View under Manufacturer");

	

	test.log(LogStatus.INFO, "Successfully logged in as Admin");
	
	pages.getLoginPage().logInToSM2("Admin", "fz;1234");
	
	test.log(LogStatus.INFO, "Successfully Clicked on Parts and Trade Tab ");
	pages.getStorageLocationPage().ClickOnPartsAndTradeSubTab();
	
	test.log(LogStatus.INFO, "Successfully Clicked on Parts Sub Tab ");
	
	pages.getCreatePartsPages().ClickOnPartsSubTab();
	
	
	List<String> list1 = new ArrayList<String>();
	list1.add("Part #");
	list1.add("Description");
	list1.add("Shelf Number");
	list1.add("Manufacturer #");
	list1.add("Manufacturer Name");
	list1.add("Cost ($)");
	list1.add("Group Code");
	list1.add("Price ($)");
	list1.add("Inventory");
	list1.add("Reorder Level");
	
	test.log(LogStatus.INFO, "creating a view");
	pages.getBasicControllersPage().CreateAView("Parts with Manufacturers", list1, null, null, "Manufacturers", "Manufacturers List");
	List<String> list3 = new ArrayList<String>();
	list3.add("Part #");
	
	test.log(LogStatus.INFO, "Adding filter in a view and and verifying its effect");
	 pages.getCreatePartsPages().Addfilter2InAView("Parts with Manufacturers", list3);
		
	 
	 List<String> list4 = new ArrayList<String>();
		list4.add("Attached File");
		
		test.log(LogStatus.INFO, "verifying sub-view and its functioning");
		 pages.getCreatePartsPages().verifySubViewAndItsFunctioning("Parts with Manufacturers");
		 
		 test.log(LogStatus.INFO, "Adding parameter in view");
		 
		 pages.getCreatePartsPages().AddparametersinView("Parts with Manufacturers", list4);
		 
		 test.log(LogStatus.INFO, "Adding filter in a view and and verifying its effect");
		actions.verify(pages.getCreatePartsPages().verifyFilterEffect2("Parts with Manufacturers", "045-011-000-PF48"), true, "attached file is not showing images"); ;
		
		test.log(LogStatus.INFO, "Editing a view");		
		pages.getBasicControllersPage().editView("Parts with Manufacturers", null, list4, null, null);
		 
	 
		test.log(LogStatus.INFO, "Adding filter in a view and and verifying its effect");
		actions.verify(pages.getCreatePartsPages().verifyFilterEffect2("Parts with Manufacturers", "045-011-000-PF48"), false, "attached file is still showing images"); 
		
	 }
	
	
	
	
	
	
	
	
	
	
	
}
