package pageObjects;

import java.time.Duration;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends BasePage {
	
	public CheckoutPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath = "//strong[normalize-space()='login page']") //strong[normalize-space()='login page']
	WebElement loginLink;
	
	public void clickLoginLink() throws InterruptedException
	{
		Thread.sleep(Duration.ofSeconds(20));
		loginLink.click();
	}

}