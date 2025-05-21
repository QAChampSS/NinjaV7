package pageObjects;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MyAffiliateAccountPage extends BasePage {
	
	public MyAffiliateAccountPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy (xpath="//a[normalize-space()='Affiliate']") WebElement affiliateLink;
	
	@FindBy(xpath = "//input[@id='input-company']")
	WebElement txtCompany;
	
	@FindBy(xpath = "//input[@id='input-website']")
	WebElement txtWebsite;

	@FindBy(xpath = "//input[@id='input-tax']")
	WebElement txtTaxNum;
	
	@FindBy(xpath = "//input[@id='input-payment-cheque']")
	WebElement element1;
	
	@FindBy(xpath = "//input[@id='input-cheque']")
	WebElement payeeName;
	
	@FindBy(xpath = "//button[normalize-space()='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement SuccessTest;
	
	public void navigateToAffiliateForm() throws InterruptedException 
	{
        scrollToView(affiliateLink);
    	Thread.sleep(500);
    	scrollAndClick(affiliateLink);
    	
	}
    	

	
	public void fillAffiliateDetails(String company,String website,String taxnumber,String payeename) throws InterruptedException
	{
		txtCompany.clear();
		txtCompany.sendKeys(company);
		txtWebsite.clear();
		txtWebsite.sendKeys(website);
		txtTaxNum.clear();
		txtTaxNum.sendKeys(taxnumber);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);
		Thread.sleep(500);
		element1.click();
		payeeName.clear();
		payeeName.sendKeys(payeename);
		btnContinue.click();
	}
	 public boolean isAffiliateAdded() {
	        return SuccessTest.isDisplayed();
	    }

	    private void scrollToView(WebElement element) {
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	    }

	    private void scrollAndClick(WebElement element) throws InterruptedException {
	        scrollToView(element);
	        Thread.sleep(500);
	        element.click();

}
}