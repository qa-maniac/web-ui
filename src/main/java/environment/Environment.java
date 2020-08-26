package environment;

import config.DotEnvConfig;
import driver.MobileCapabilities;
import driver.Local;
import driver.Mobile;
import driver.Selenoid;
import driver.constants.BrowserLabel;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import ui.BasePage;


public class Environment {

    private DotEnvConfig config = new DotEnvConfig();
    private BasePage basePage;


    public Environment() {
        WebDriver driver = null;

        BrowserLabel browserLabel = getBrowserLabel();
        String browserVersion = config.getBrowserVersion();
        if(browserLabel == null) {
            try {
                throw new Exception("Pay attention! Check a browser value in '.env' file.");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            if (config.getEnvironment().toLowerCase().equals(EnvironmentType.MOBILE.toString().toLowerCase())) {
                String serverUrl = config.getServerUrl();
                Platform platform = getPlatform();
                String mode = config.getMode();
                MobileCapabilities caps = new MobileCapabilities(browserLabel, browserVersion, mode);
                driver = new Mobile(serverUrl, platform, caps).driver();
            } else if (config.getEnvironment().toLowerCase().equals(EnvironmentType.SELENOID.toString().toLowerCase())) {
                String serverUrl = config.getServerUrl();
                int screenWidth = Integer.parseInt(config.getScreenWidth());
                int screenHeight = Integer.parseInt(config.getScreenHeight());
                driver = new Selenoid(serverUrl, browserLabel, browserVersion, screenWidth, screenHeight).driver();
            } else if (config.getEnvironment().toLowerCase().equals(EnvironmentType.LOCAL.toString().toLowerCase()))
                driver = new Local(browserLabel, browserVersion).getDriver();
            else
                try {
                    throw new Exception("Pay attention! Check an environment value in '.env' file.");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
        }
        this.basePage = new BasePage(driver);
    }


    public BasePage getBasePage() {
        return basePage;
    }


    private BrowserLabel getBrowserLabel() {
        BrowserLabel result = null;
        for(BrowserLabel browser : BrowserLabel.values()) {
            if(browser.toString().toLowerCase().equals(config.getBrowser().toLowerCase())) {
                result = browser;
                break;
            }
        }
        return result;
    }


    private Platform getPlatform() {
        Platform result = null;
        for(Platform platform : Platform.values()) {
            if(platform.toString().toLowerCase().equals(config.getPlatform().toLowerCase())) {
                result = platform;
                break;
            }
        }
        return result;
    }
}