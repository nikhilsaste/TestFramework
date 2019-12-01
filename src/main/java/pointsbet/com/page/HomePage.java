package pointsbet.com.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import pointsbet.com.core.UserActions;

public class HomePage extends UserActions {

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    private Logger logger = LogManager.getLogger(HomePage.class);

    @FindBy(xpath = "//*[@id=\"user-nav-menu\"]/li[2]/a")
    @CacheLookup
    private WebElement depositLink;

    @FindBy(css = "input[ng-model=\"deposit.depositAmount\"]")
    @CacheLookup
    private WebElement depositAmountTextBox;

    @FindBy(css = "input[ng-model=\"deposit.cardNumber\"]")
    @CacheLookup
    private WebElement cardNumberTextBox;

    @FindBy(css = "input[ng-model=\"deposit.nameOnCard\"]")
    @CacheLookup
    private WebElement nameOnCardTextBox;

    @FindBy(css = "input[ng-model=\"deposit.cardCVC\"]")
    @CacheLookup
    private WebElement cardCVCTextBox;

    @FindBy(css = "button[class=\"btn btn-secondary btn-submit\"]")
    @CacheLookup
    private WebElement submitButton;

    @FindBy(css = "a[ng-click=\"makeAnotherDeposit()\"]")
    @CacheLookup
    private WebElement makeAnotherPaymentLink;

    @FindBy(css = "button[class=\"btn btn-user-nav ng-scope\"]")
    @CacheLookup
    private WebElement userNavigationMenuButton;

    @FindBy(xpath = "//*[@id=\"month\"]/span[1]")
    @CacheLookup
    private WebElement expiryMonthSpan;

    @FindBy(css = "a[ng-click=\"setExpiryMonth(n)\"")
    @CacheLookup
    private WebElement expiryMonth;

    @FindBy(xpath = "//*[@id=\"day\"]/span[1]")
    @CacheLookup
    private WebElement expiryYearSpan;

    @FindBy(css = "ng-click=\"setExpiryYear(n)\"")
    @CacheLookup
    private WebElement expiryYear;

    /**
     *
     * @param depositAmount
     * @param cardNumber
     * @param nameOnCard
     * @param CVC
     * @throws Exception
     */

    public void depositMoney(String depositAmount, String cardNumber, String nameOnCard, String CVC) throws Exception{

        click(userNavigationMenuButton);
        click(depositLink);
        enter(depositAmountTextBox,depositAmount);
        enter(cardNumberTextBox,cardNumber);
        enter(nameOnCardTextBox,nameOnCard);
        click(expiryMonthSpan);
        click(expiryMonth);
        click(expiryYearSpan);
        click(expiryYear);
        enter(cardCVCTextBox,CVC);
        click(submitButton);

        try {

            if (isDisplayed(makeAnotherPaymentLink)) {
                System.out.println("Deposit is successful...!!");
                logger.info("Deposit is successful");
            }
        }
        catch(NoSuchElementException e){
            logger.error("Deposit is not successful");
            throw new Exception("Deposit is not successful");
        }
    }

}
