package com.eaf.qa.cloudops.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.internal.BaseAction;

// TODO: Auto-generated Javadoc
/**
 * Created By : Chandan.
 */

public class PageCollection {

	/** The Log. */
	private static Logger Log = LogManager.getLogger(PageCollection.class.getName());

	/** The driver. */
	protected ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	/** The login page. */
	private LoginPage loginPage;
	
	/** The login page. */
	private MaintenanceClassPage maintenanceClassPage;
	
	/** Create Job Page. */
	private CreateJobPage createJobPage;
	
	/** Create Task Page. */
	private CreateTasksPage createTasksPage;
	
	/** Create Maintenance Plans Page */
	private CreateMaintenancePlansPage createMaintenancePlansPage;
	
	/** Create Vehicle */
	private CreateVehiclePage createVehiclePage;
		
	/** Create WorkOrders */
	private CreateWorkOrdersPage  createWorkOrdersPage;
	
	/** Create User under Personnel tab  **/
	private CreateUsersPage createUsersPage;
	
	/** Create User under Personnel tab  **/
	private CreateDevicesPage createDevicesPage;
	
	private BasicControllersPage basicControllersPage;
	
	private EquipmentClassesPage equipmentClassesPage;
	
	private AddingJobs addingJobs;
	
	private MaintenanceTaskPage maintenanceTaskPage;
	private CreatePartsPages createPartsPages;
	
	private CreateEntityAtImportsSubTabUnderSystemTab createEntityAtImportsSubTabUnderSystemTab;
	
	private RefrenceTablePage refrenceTablePage;
	
	private UsersUnderPersonnelTabPage usersUnderPersonnelTabPage;
	
	private Maintenance_JobsPageTc maintenance_JobsPageTc;
	
	private MaintenanceClassesChecklist maintenanceClassesChecklist;
	
	private StorageLocationPage storageLocationPage;
	private SuppliersPage suppliersPage;
	private ManufacturerPage manufacturerPage;
	
	
	
	/**
	 * Instantiates a new page collection.
	 *
	 * @param driver the driver
	 */
	public PageCollection(ThreadLocal<WebDriver> driver) 
	{
		this.driver = driver;
		Log.info("Initialized Page Collection Class");
	}

	/**
	 * Gets the login page.
	 *
	 * @return the login page
	 */
	
	public MaintenanceClassesChecklist getMaintenanceClassesChecklist() 
	{
		return (maintenanceClassesChecklist == null) ? maintenanceClassesChecklist = new MaintenanceClassesChecklist(driver) : maintenanceClassesChecklist;

	}
	
	public LoginPage getLoginPage() 
	{
		return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
	}

	
	public MaintenanceClassPage getMaintenanceClassPage() 
	{
		return (maintenanceClassPage == null) ? maintenanceClassPage = new MaintenanceClassPage(driver) : maintenanceClassPage;

	}
	
	
	public CreateJobPage getCreateJobPage() 
	{
		return (createJobPage == null) ? createJobPage = new CreateJobPage(driver) : createJobPage;
	}
	
	
    public CreateTasksPage getCreateTasksPage() 
    {
		return (createTasksPage == null) ? createTasksPage = new CreateTasksPage(driver) : createTasksPage;
	}
	
    
    public CreateMaintenancePlansPage getCreateMaintenancePlansPage() 
    {
		return (createMaintenancePlansPage == null) ? createMaintenancePlansPage = new CreateMaintenancePlansPage(driver) : createMaintenancePlansPage;
	}
    
    
	public CreateVehiclePage getCreateVehiclePage() 
	{
		return (createVehiclePage == null) ? createVehiclePage = new CreateVehiclePage(driver) : createVehiclePage;
	}
	
	
	public CreateWorkOrdersPage getCreateWorkOrdersPage()
	{
		return (createWorkOrdersPage == null) ? createWorkOrdersPage = new CreateWorkOrdersPage(driver) : createWorkOrdersPage;
	}
	
	public CreateUsersPage getCreateUsersPage()
	{
		return (createUsersPage == null) ? createUsersPage = new CreateUsersPage(driver) : createUsersPage;
	}

	public CreateDevicesPage getCreateDevicesPage()
	{
		return (createDevicesPage == null) ? createDevicesPage = new CreateDevicesPage(driver) : createDevicesPage;
	}
	
	public BasicControllersPage getBasicControllersPage()
	{
		return (basicControllersPage == null) ? basicControllersPage = new BasicControllersPage(driver) : basicControllersPage;
	}
	
	public EquipmentClassesPage getEquipmentClassesPage()
	{
		return (equipmentClassesPage == null) ? equipmentClassesPage = new EquipmentClassesPage(driver) : equipmentClassesPage;
	}
	
	public AddingJobs getAddingJobs()
	{
		return (addingJobs == null) ? addingJobs = new AddingJobs(driver) : addingJobs;
	}
	
	public MaintenanceTaskPage getMaintenanceTaskPage() 
	{
		return (maintenanceTaskPage == null) ? maintenanceTaskPage = new MaintenanceTaskPage(driver) : maintenanceTaskPage;
	}
	
	public CreateEntityAtImportsSubTabUnderSystemTab getCreateEntityAtImportsSubTabUnderSystemTab() 
	{
		return (createEntityAtImportsSubTabUnderSystemTab == null) ? createEntityAtImportsSubTabUnderSystemTab = new CreateEntityAtImportsSubTabUnderSystemTab(driver) : createEntityAtImportsSubTabUnderSystemTab;
	}
	
	
	public RefrenceTablePage getRefrenceTablePage() 
	{
		return (refrenceTablePage == null) ? refrenceTablePage = new RefrenceTablePage(driver) : refrenceTablePage;
	}
	
	
	public UsersUnderPersonnelTabPage getUsersUnderPersonnelTabPage() 
	{
		return (usersUnderPersonnelTabPage == null) ? usersUnderPersonnelTabPage = new UsersUnderPersonnelTabPage(driver) : usersUnderPersonnelTabPage;

	}
	
	public Maintenance_JobsPageTc getMaintenance_JobsPageTc() 
	{
		return (maintenance_JobsPageTc == null) ? maintenance_JobsPageTc = new Maintenance_JobsPageTc(driver) : maintenance_JobsPageTc;

	}
	
	public StorageLocationPage getStorageLocationPage()
	{
		return (storageLocationPage == null) ? storageLocationPage = new StorageLocationPage(driver) : storageLocationPage;
	
	}
	public SuppliersPage getSuppliersPage()
	{
		return (suppliersPage == null) ? suppliersPage = new SuppliersPage(driver) : suppliersPage;
	
	}
	
	public ManufacturerPage getManufacturerPage()
	{
		return (manufacturerPage == null) ? manufacturerPage = new ManufacturerPage(driver) : manufacturerPage;
	
	}
	
	
	public CreatePartsPages getCreatePartsPages()
	{
		
		return (createPartsPages == null) ? createPartsPages = new CreatePartsPages(driver) : createPartsPages;
		
	}
	
	
	
}