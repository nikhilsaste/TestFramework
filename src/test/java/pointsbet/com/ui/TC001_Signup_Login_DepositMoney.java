package pointsbet.com.ui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pointsbet.com.core.WebDriverController;
import pointsbet.com.page.HomePage;
import pointsbet.com.page.LoginPage;
import pointsbet.com.page.SignUpPage;

import java.net.MalformedURLException;

public class TC001_Signup_Login_DepositMoney extends WebDriverController {

    private HomePage homePage = null;
    private SignUpPage signUpPage = null;
    private LoginPage loginPage = null;

    private Logger logger = LogManager.getLogger(TC001_Signup_Login_DepositMoney.class);

    String pointsBetTestURL = "https://user.test.pointsbet.com.au/ft/b47554551c82474ea1ab3b3f273f5107";
    String browser = "chrome";
    String firstName = "Test";
    String lastName = "Test";
    String email = "latestEmail@test.com";
    String mobileNumber = "0400000000";
    String address = "101 Collins Pl, Evatt ACT 2617";
    String userName = "latestUseNameTest";
    String password = "Welcome123";
    String depositAmount = "10";
    String cardNumber = "4111111111111111";
    String CVC = "123";

    @BeforeTest
    public void before() throws MalformedURLException {

        // Load pointsbet application
        openBrowser(pointsBetTestURL,browser);
        logger.info("Pointsbet application loaded");

        signUpPage = new SignUpPage(driver);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    @Test
    public void TestSignUpPage(){

        try {

            // Handle testing pop-up
            signUpPage.handleTestingPopUp();

            // Signup to pointsbet
            signUpPage.signUp(firstName,lastName,email,mobileNumber,address,userName,password);
            logger.info("Sign-up completed");

            // Login to pointsbet
            loginPage.login(userName, password);
            logger.info("Login completed");

            // Handle testing pop-up
            signUpPage.handleTestingPopUp();

            // Verify deposit money
            homePage.depositMoney(depositAmount, cardNumber, lastName, CVC);
            logger.info("Deposit money completed");

        }

        catch (Exception e){
            logger.error("Scenario failed due to: "+e.getMessage());
            Assert.fail("Scenario failed due to: "+e.getMessage());
        }
    }

    @AfterTest
    public void after(){
        quitBrowser();
    }
}
