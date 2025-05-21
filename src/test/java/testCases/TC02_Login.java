package testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.DataProviders;
import utilities.RetryAnalyzer;

public class TC02_Login extends BaseClass {

    private static final Logger logger = LogManager.getLogger(TC02_Login.class);

    @Test(
        groups = {"sanity", "regression", "datadriven"},
        dataProvider = "LoginData",
        dataProviderClass = DataProviders.class,
        retryAnalyzer = utilities.RetryAnalyzer.class
    )
    void testLogin(String email, String pwd) {
        logger.info("***** Starting TC02_Login test with email: " + email + " *****");

        try {
            HomePage hp = new HomePage(getDriver());
            logger.debug("Navigating to Login page from HomePage");

            hp.clickMyAccount();
            logger.debug("Clicked on My Account");

            hp.goToLogin();
            logger.debug("Clicked on Login");

            LoginPage lp = new LoginPage(getDriver());
            logger.debug("LoginPage object created");

            logger.debug("Entering email: " + email);
            lp.setEmail(email);

            logger.debug("Entering password");
            lp.setPwd(pwd);

            lp.clickLogin();
            logger.debug("Clicked on Login button");

            AccountPage ap = new AccountPage(getDriver());
            boolean status = ap.getMyAccountConfirmation().isDisplayed();
            logger.debug("Account confirmation visibility status: " + status);

            if (status) {
                logger.info("Login successful for user: " + email);
                ap.clickMyAccountDropDown();
                ap.clickLogout();
                Assert.assertTrue(true);
            } else {
                logger.warn("Login failed for user: " + email);
                Assert.fail("Login verification failed");
            }

        } catch (AssertionError ae) {
            logger.error("Assertion error during login test: " + ae.getMessage());
            Assert.fail("Test failed due to assertion error");
        } catch (Exception e) {
            logger.error("Exception during login test: ", e);
            Assert.fail("Test failed due to exception");
        }

        logger.info("***** Finished TC02_Login test with email: " + email + " *****");
    }
}
