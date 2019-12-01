package pointsbet.com.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pointsbet.com.core.UserActions;

public class LoginPage extends UserActions {

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    @FindBy(css = "button[ng-click=\"$ctrl.openLoginModal()\"]")
    @CacheLookup
    private WebElement loginButtonMain;

    @FindBy(css = "input[ng-model=\"$ctrl.username\"]")
    @CacheLookup
    private WebElement userNameTextBox;

    @FindBy(css = "input[ng-model=\"$ctrl.password\"]")
    @CacheLookup
    private WebElement passwordTextBox;

    @FindBy(css = "button[ng-click=\"$ctrl.login()\"]")
    @CacheLookup
    private WebElement loginButton;

    /**
     *
     * @param userName
     * @param password
     * @throws Exception
     */
    public void login(String userName, String password) throws Exception{

        click(loginButtonMain);
        enter(userNameTextBox,userName);
        enter(passwordTextBox,password);
        click(loginButton);

    }

}
