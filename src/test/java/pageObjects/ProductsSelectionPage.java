package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsSelectionPage extends BasePage {
	
	public ProductsSelectionPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath = "//div[@class='description']//a[contains(text(),'HP LP3065')]")
	WebElement element;
	
	
	
	public void productSelect() throws InterruptedException
	{
		Thread.sleep(500);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500);
		element.click();

}
}
