package testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;
import utilities.RetryAnalyzer;

public class TC01_LaunchApplication extends BaseClass {

    // Create logger instance
    private static final Logger logger = LogManager.getLogger(TC01_LaunchApplication.class);

    @Test(groups = {"sanity", "regression"}, retryAnalyzer = utilities.RetryAnalyzer.class)
    void testLaunchApplication() {
        logger.info("***** Starting TC01_LaunchApplication *****");

        try {
            HomePage hp = new HomePage(getDriver());
            logger.debug("HomePage object created");

            String title = getDriver().getTitle();
            logger.debug("Application title retrieved: " + title);

            Assert.assertEquals(title, "Your store of fun");
            logger.info("Title assertion passed");

        } catch (AssertionError e) {
            logger.error("Assertion failed: " + e.getMessage());
            Assert.fail("Test failed due to title mismatch");
        } catch (Exception e) {
            logger.error("Unexpected error occurred: " + e.getMessage(), e);
            Assert.fail("Test failed due to unexpected exception");
        }

        logger.info("***** Finished TC01_LaunchApplication *****");
    }
}
