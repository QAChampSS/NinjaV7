package testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAffiliateAccountPage;
import testBase.BaseClass;
import utilities.RetryAnalyzer;

public class TC06_AddAffiliate extends BaseClass {

    private static final Logger logger = LogManager.getLogger(TC06_AddAffiliate.class);

    @Test(groups = { "regression" }, retryAnalyzer = RetryAnalyzer.class)
    void testAddAffiliate() throws InterruptedException {
        logger.info("***** Starting TC06_AddAffiliate test *****");

        try {
            HomePage hp = new HomePage(getDriver());
            logger.debug("Navigating to login page");
            hp.clickMyAccount();
            hp.goToLogin();

            LoginPage lp = new LoginPage(getDriver());
            logger.debug("Entering login credentials");
            lp.setEmail("smitasharma.qa@gmail.com");
            lp.setPwd("ss*QA123");
            lp.clickLogin();

            MyAffiliateAccountPage ap = new MyAffiliateAccountPage(getDriver());
            logger.debug("Navigating to affiliate form");
            ap.navigateToAffiliateForm();

            logger.debug("Filling affiliate details");
            ap.fillAffiliateDetails("Infoqasis", "QASolutions.com", "1234", "SSQA");

            boolean status = ap.isAffiliateAdded();

            try {
                Assert.assertTrue(status, "Affiliate details not added successfully.");
                logger.info("Affiliate details added successfully.");
            } catch (AssertionError ae) {
                logger.error("Assertion failed: Affiliate not added - " + ae.getMessage());
                Assert.fail("Assertion failed: Affiliate addition did not succeed.");
            }

        } catch (Exception e) {
            logger.error("Exception encountered in TC06_AddAffiliate: ", e);
            Assert.fail("Test failed due to unexpected exception.");
        }

        logger.info("***** Finished TC06_AddAffiliate test *****");
    }
}
