package pointsbet.com.core;

import org.apache.commons.lang3.SystemUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;

abstract class DriverOptions {
    private Logger logger = LogManager.getLogger(DriverOptions.class);

    /**
     * get chrome options
     *
     * @return chrome
     */
    protected static ChromeOptions getChromeOptions() {
        setChromeSystemProperty();
        ChromeOptions options = new ChromeOptions();
        //options.setHeadless(true);
        options.addArguments("enable-automation");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-extensions");
        options.addArguments("--dns-prefetch-disable");
        options.addArguments("--disable-gpu");
        options.addArguments("enable-features=NetworkServiceInProcess");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        return options;
    }

    /**
     * get firefox options
     *
     * @return options
     */
    protected static FirefoxOptions getFirefoxOptions() {
        setFirefoxSystemProperty();
        System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        FirefoxOptions options = new FirefoxOptions();
        FirefoxProfile profile = new FirefoxProfile();
        profile.setAcceptUntrustedCertificates(true);
        profile.setAssumeUntrustedCertificateIssuer(false);
        profile.setPreference("network.proxy.type", 0);
        //options.setHeadless(true);
        options.setCapability(FirefoxDriver.PROFILE, profile);
        return options;
    }

    /**
     * Set chrome system property
     */
    private static void setChromeSystemProperty() {
        System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
    }

    /**
     * Set firefox system property
     */
    private static void setFirefoxSystemProperty() {
        System.setProperty("webdriver.gecko.driver", "Driver/geckodriver.exe");
    }

    /**
     * get IE options
     *
     * @return options
     */
    protected InternetExplorerOptions getIEOptions() {
        System.setProperty("webdriver.ie.driver", "Driver/IEDriverServer.exe");
        InternetExplorerOptions options = new InternetExplorerOptions();
        options.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
        options.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, true);
        options.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
        options.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        options.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
        logger.info("IE options added");
        return options;
    }

}
