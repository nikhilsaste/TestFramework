package pointsbet.com.core;

import org.openqa.selenium.WebDriver;

public abstract class WebDriverParent extends UserActions {

    public WebDriverParent(WebDriver driver) {
        super(driver);
    }
}