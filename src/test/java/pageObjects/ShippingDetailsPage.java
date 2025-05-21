package pageObjects;

import java.time.Duration;

//import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShippingDetailsPage extends BasePage {

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	
	public ShippingDetailsPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath = "//select[@id='input-shipping-address']")
	WebElement dropdownElement;
	
	@FindBy(xpath = "//button[@id='button-shipping-methods']")
	WebElement chooseShipping;
	
	
	
	@FindBy(xpath = "//button[@id='button-shipping-method']")
	WebElement clickContinue;
	
	@FindBy(xpath = "//button[@id='button-payment-methods']")
	WebElement choosePayment;
	
	
	
	@FindBy(xpath = "//button[@id='button-payment-method']")
	WebElement clickContinueForPayment;
	
	 @FindBy(xpath = "//div[@class='text-end']//button[contains(text(), 'Confirm')]")
	 WebElement element3;
	
	 @FindBy(xpath = "//div[@class='text-end']//button[contains(text(), 'Confirm')]")
	 WebElement element4;
	 
	 @FindBy(xpath = "//h1[normalize-space()='Your order has been placed!']")
	WebElement message;
	
	public void selectShippingAddress()
	{
		Select addressDropdown = new Select(dropdownElement);
		addressDropdown.selectByIndex(1);
	}
	
	public void fillShippingAndPaymentDetails() throws InterruptedException 
	{
		chooseShipping.click();
		clickContinue.click();
		Thread.sleep(Duration.ofSeconds(20));
		choosePayment.click();
		Thread.sleep(Duration.ofSeconds(20));
		clickContinueForPayment.click();
	}
	
	public void confirmOrder() throws InterruptedException
	{
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element3);
		Thread.sleep(1000);
		
		element4.click();
	}
	
	public WebElement confirmationPage()
	{
		return message;
	}

}