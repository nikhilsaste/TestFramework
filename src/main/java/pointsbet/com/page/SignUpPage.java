package pointsbet.com.page;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pointsbet.com.core.UserActions;

public class SignUpPage extends UserActions {

    public SignUpPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a[ng-click=\"$ctrl.hideAllNav(); $ctrl.setLogo.showLogo();\"]")
    @CacheLookup
    private WebElement signUpButton;

    @FindBy(css = "button[ng-click=\"$ctrl.openLoginModal()\"]")
    @CacheLookup
    private WebElement loginButton;

    @FindBy(css = "input[ng-model=\"$ctrl.user.firstName\"]")
    @CacheLookup
    private WebElement firstNameTextBox;

    @FindBy(css = "input[ng-model=\"$ctrl.user.lastName\"]")
    @CacheLookup
    private WebElement lastNameTextBox;

    @FindBy(css = "button[ng-click=\"$ctrl.goToStep(2)\"]")
    @CacheLookup
    private WebElement contiueButton;

    @FindBy(css = "input[ng-model=\"$ctrl.user.email\"]")
    @CacheLookup
    private WebElement emailTextbox;

    @FindBy(xpath = "/html/body/div[1]/div[2]/account-signup-component/div/div[2]/div[1]/form/div[2]/fieldset[1]/div/div[1]/div/ul/li[1]/label")
    @CacheLookup
    private WebElement mrSalutationRadioButton;


    @FindBy(css = "input[ng-model=\"$ctrl.user.contactNumber\"]")
    @CacheLookup
    private WebElement mobileNumberTextBox;

    @FindBy(css = "input[ng-model=\"$ctrl.address.value\"]")
    @CacheLookup
    private WebElement addressTextBox;

    @FindBy(css = "input[ng-model=\"$ctrl.user.userName\"]")
    @CacheLookup
    private WebElement userNameTextBox;

    @FindBy(css = "input[ng-model=\"$ctrl.user.password\"]")
    @CacheLookup
    private WebElement passwordTextBox;

    @FindBy(css = "input[ng-model=\"$ctrl.user.confirmPassword\"]")
    @CacheLookup
    private WebElement confirmPasswordTextBox;

    @FindBy(css = "div[class=\"form-group custom-checkbox extra-space\"]")
    @CacheLookup
    private WebElement conditionsCheckBox;

    @FindBy(css = "button[type=\"submit\"]")
    @CacheLookup
    private WebElement joinPointsBetButton;

    @FindBy(css = "button[class=\"ab-message-button\"]")
    @CacheLookup
    private WebElement testingSubmitButton;

    @FindBy(xpath = "//*[@id=\"user-nav-menu\"]/li[8]/a")
    @CacheLookup
    private WebElement logoutLink;

    @FindBy(xpath = "//*[@id=\"day\"]/span[1]")
    @CacheLookup
    private WebElement dobDaySpan;

    @FindBy(css = "a[ng-click=\"$ctrl.setDropdownValue('DOBDay', $root.getWithLeadingZeros(n, 2))\"]")
    @CacheLookup
    private WebElement dobDay;

    @FindBy(xpath = "//*[@id=\"month\"]/span[1]")
    @CacheLookup
    private WebElement dobMonthSpan;

    @FindBy(css = "a[ng-click=\"$ctrl.setDropdownValue('DOBMonth', $root.getWithLeadingZeros(n, 2))\"]")
    @CacheLookup
    private WebElement dobMonth;

    @FindBy(xpath = "//*[@id=\"year\"]/span[1]")
    @CacheLookup
    private WebElement dobYearSpan;

    @FindBy(css = "a[ng-click=\"$ctrl.setDropdownValue('DOBYear', year)\"]")
    @CacheLookup
    private WebElement dobYear;


    /**
     *
     * @param firstName
     * @param lastName
     * @param email
     * @param mobileNumber
     * @param address
     * @param userName
     * @param password
     * @throws Exception
     */
    public void signUp(String firstName, String lastName, String email, String mobileNumber, String address, String userName, String password) throws Exception{

        waitUntilElementVisible(signUpButton);
        click(signUpButton);

        waitUntilElementVisible(firstNameTextBox);
        enter(firstNameTextBox,firstName);
        enter(lastNameTextBox,lastName);
        enter(emailTextbox,email);
        click(contiueButton);

        click(mrSalutationRadioButton);

        click(dobDaySpan);
        click(dobDay);
        click(dobMonthSpan);
        click(dobMonth);
        click(dobYearSpan);
        click(dobYear);

        enter(mobileNumberTextBox,mobileNumber);
        enter(addressTextBox,address);
        click(userNameTextBox);
        enter(userNameTextBox,userName);
        enter(passwordTextBox,password);
        enter(confirmPasswordTextBox,password);
        click(conditionsCheckBox);

        click(joinPointsBetButton);

        click(logoutLink);
    }

    /**
     *
     */
    public void handleTestingPopUp() {

        try {

            if (isDisplayed(testingSubmitButton)) {
                click(testingSubmitButton);
            }
        }
        catch(NoSuchElementException e){
            return;
        }
    }

}
