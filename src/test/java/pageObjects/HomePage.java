package pageObjects;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

	//constructor
	//HomePage is a subclass of BasePage.

	//When a HomePage object is created, it needs a WebDriver instance to work with.

	//super(driver); is a call to the constructor of the parent class (BasePage), passing along the WebDriver.

	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	
	//Locators
	
	//Link - My Account
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement link_MyAccount;

	//Link - Login
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement link_Login;
	
	//Verify Logo
	@FindBy(xpath = "//img[@title='Your Store']")
	WebElement logoOpenCart;
	
	//tab_LapAndNotebook
	@FindBy(xpath = "//a[normalize-space()='Laptops & Notebooks']")
	WebElement tab_LapAndNotebooks;
	
	//show_AllLapAndNotebook
	@FindBy(xpath = "//a[normalize-space()='Show All Laptops & Notebooks']")
	WebElement show_AllLapAndNotebooks;
	
	
	
	
	
	//Action Methods
		
		public void clickMyAccount()
		{
			 link_MyAccount.click();
		}
		
		public void goToLogin()
		{
			link_Login.click();
		}
		
		
		public void clickLogoOpenCart()
		{
			logoOpenCart.click();
		}	
		
		public void clickLapAndNotebooks()
		{
			tab_LapAndNotebooks.click();
		}
		
		public void clickAllLapAndNotebooks()
		{
			show_AllLapAndNotebooks.click();
		}
	

}