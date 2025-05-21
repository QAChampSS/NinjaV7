package testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AllAddToCartProductsPage;
import pageObjects.CheckoutPage;
import pageObjects.ShippingDetailsPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProductsSelectionPage;
import testBase.BaseClass;
import utilities.RetryAnalyzer;

public class TC04_CompletePurchase_SidCode extends BaseClass {

    private static final Logger logger = LogManager.getLogger(TC04_CompletePurchase_SidCode.class);

    @Test(groups = { "sanity", "regression" }, retryAnalyzer = RetryAnalyzer.class)
    void addToCart() throws InterruptedException {
        logger.info("***** Starting TC04_CompletePurchase_SidCode test *****");

        try {
            HomePage hp = new HomePage(getDriver());
            logger.debug("Navigating to Laptops and Notebooks section");
            hp.clickLapAndNotebooks();
            hp.clickAllLapAndNotebooks();

            ProductsSelectionPage pp = new ProductsSelectionPage(getDriver());
            logger.debug("Selecting product from product listing");
            pp.productSelect();

            AllAddToCartProductsPage atcp = new AllAddToCartProductsPage(getDriver());
            logger.debug("Setting delivery date and adding product to cart");
            atcp.setDeliveryDate();
            atcp.clickaddToCart();
            atcp.clickcheckout();

            CheckoutPage cp = new CheckoutPage(getDriver());
            logger.debug("Navigating to login page from checkout");
            cp.clickLoginLink();

            LoginPage lp = new LoginPage(getDriver());
            logger.debug("Entering login credentials");
            lp.setEmail("smitasharma.qa@gmail.com");
            lp.setPwd("ss*QA123");
            lp.clickLogin();

            ShippingDetailsPage sdp = new ShippingDetailsPage(getDriver());
            logger.debug("Filling shipping and payment details");
            sdp.selectShippingAddress();
            sdp.fillShippingAndPaymentDetails();
            sdp.confirmOrder();

            logger.debug("Validating confirmation page");
            boolean status = sdp.confirmationPage().isDisplayed();

            try {
                Assert.assertTrue(status, "Order confirmation page not displayed.");
                logger.info("Order placed and confirmation page displayed.");
            } catch (AssertionError ae) {
                logger.error("Assertion failed: " + ae.getMessage());
                Assert.fail("Order confirmation assertion failed.");
            }

        } catch (Exception e) {
            logger.error("Exception occurred during TC04_CompletePurchase_SidCode test: ", e);
            Assert.fail("Test failed due to an unexpected exception.");
        }

        logger.info("***** Finished TC04_CompletePurchase_SidCode test *****");
    }
}
