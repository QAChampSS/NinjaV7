package testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AllAddToCartProductsPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProductsSelectionPage;
import testBase.BaseClass;
import utilities.RetryAnalyzer;

public class TC05_AddToWishList extends BaseClass {

    private static final Logger logger = LogManager.getLogger(TC05_AddToWishList.class);

    @Test(groups = {"regression"}, retryAnalyzer = RetryAnalyzer.class)
    void TC05_AddToWishList() {
        logger.info("***** Starting TC05_AddToWishList test *****");

        try {
            HomePage hp = new HomePage(getDriver());
            logger.debug("Clicking My Account and navigating to Login page");
            hp.clickMyAccount();
            hp.goToLogin();

            LoginPage lp = new LoginPage(getDriver());
            logger.debug("Entering login credentials");
            lp.setEmail("smitasharma.qa@gmail.com");
            lp.setPwd("ss*QA123");
            lp.clickLogin();

            logger.debug("Navigating to Laptop & Notebooks section");
            hp.clickLogoOpenCart();
            hp.clickLapAndNotebooks();
            hp.clickAllLapAndNotebooks();

            ProductsSelectionPage pp = new ProductsSelectionPage(getDriver());
            logger.debug("Selecting product from list");
            try {
                pp.productSelect();
            } catch (InterruptedException e) {
                logger.error("InterruptedException during product selection", e);
                Assert.fail("Test failed due to interrupted exception in product selection");
            }

            AllAddToCartProductsPage atcp = new AllAddToCartProductsPage(getDriver());
            logger.debug("Attempting to add product to wishlist");
            atcp.addToWishList();

            boolean status = atcp.isSuccessMessageDisplayed();

            try {
                Assert.assertTrue(status, "Wishlist message not shown.");
                logger.info("Product successfully added to wishlist");
            } catch (AssertionError ae) {
                logger.error("Assertion failed - Wishlist message not displayed: " + ae.getMessage());
                Assert.fail("Assertion failed: Wishlist message was not displayed.");
            }

        } catch (Exception e) {
            logger.error("Exception encountered in TC05_AddToWishList: ", e);
            Assert.fail("Test failed due to unexpected exception.");
        }

        logger.info("***** Finished TC05_AddToWishList test *****");
    }
}
