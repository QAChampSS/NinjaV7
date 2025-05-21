package testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AllAddToCartProductsPage;
import pageObjects.HomePage;
import pageObjects.ProductsSelectionPage;
import testBase.BaseClass;
import utilities.RetryAnalyzer;

public class TC03_AddToCart extends BaseClass {

    private static final Logger logger = LogManager.getLogger(TC03_AddToCart.class);

    @Test(groups = {"sanity", "regression"}, retryAnalyzer = utilities.RetryAnalyzer.class)
    void addToCart() throws InterruptedException {
        logger.info("***** Starting TC03_AddToCart test *****");

        try {
            HomePage hp = new HomePage(getDriver());
            logger.debug("HomePage object created");

            hp.clickLapAndNotebooks();
            logger.debug("Clicked on 'Laptops & Notebooks'");

            hp.clickAllLapAndNotebooks();
            logger.debug("Clicked on 'Show All Laptops & Notebooks'");

            ProductsSelectionPage pp = new ProductsSelectionPage(getDriver());
            logger.debug("ProductsSelectionPage object created");

            pp.productSelect();
            logger.debug("Product selected from the list");

            AllAddToCartProductsPage atcp = new AllAddToCartProductsPage(getDriver());
            logger.debug("AllAddToCartProductsPage object created");

            atcp.setDeliveryDate();
            logger.debug("Set delivery date");

            atcp.clickaddToCart();
            logger.debug("Clicked 'Add to Cart'");

            boolean isSuccess = atcp.isSuccessMessageDisplayed();
            logger.debug("Success message displayed: " + isSuccess);

            Assert.assertTrue(isSuccess, "Add to Cart Failed!");
            logger.info("Product added to cart successfully");

        } catch (AssertionError ae) {
            logger.error("Assertion failed: " + ae.getMessage());
            Assert.fail("Test failed due to assertion error");
        } catch (Exception e) {
            logger.error("Exception occurred during addToCart test: ", e);
            Assert.fail("Test failed due to unexpected exception");
        }

        logger.info("***** Finished TC03_AddToCart test *****");
    }
}
