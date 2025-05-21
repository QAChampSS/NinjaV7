
package pageObjects;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AllAddToCartProductsPage extends BasePage {

	public AllAddToCartProductsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='input-option-225']")
	WebElement input_DeliveryDate;

	@FindBy(xpath = "//button[@id='button-cart']")
	WebElement btn_AddToCart;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert_Success;

	// Wish List button
	@FindBy(xpath = "//div[@class=\"btn-group\"]/button[1]") 
	WebElement btnWishList;

	// Checkout
	@FindBy(xpath = "//a[@title='Checkout']//i[@class='fa-solid fa-share']")
	WebElement link_Checkout;

	@FindBy(xpath = "//div//button//i[@class='fa-solid fa-heart']")
	WebElement wishlistIcon;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement successMessage;

	public void addToWishlist() {
		// ((JavascriptExecutor)
		// driver).executeScript("arguments[0].scrollIntoView(true);", wishlistIcon);
		wishlistIcon.click();
	}

	public void setDeliveryDate() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", input_DeliveryDate);
		Thread.sleep(500);

		input_DeliveryDate.clear();

		LocalDate currentDate = LocalDate.now();
		// System.out.println(currentDate);
		LocalDate deliveryDate = currentDate.plusDays(5);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formattedDate = deliveryDate.format(formatter);
		input_DeliveryDate.sendKeys(formattedDate);
	}

	public void clickaddToCart() throws InterruptedException {
		//Scroll into view
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_AddToCart);

		Thread.sleep(500);
		btn_AddToCart.click();
	}

	public void addToWishList() {
		btnWishList.click();
	}

	public void clickcheckout() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", link_Checkout);
		Thread.sleep(500);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", link_Checkout);
		Thread.sleep(500);
		link_Checkout.click();
	}

	public boolean isSuccessMessageDisplayed() {
		return alert_Success.getText().contains("Success");
	}

	private void scrollToView(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	
	

}
