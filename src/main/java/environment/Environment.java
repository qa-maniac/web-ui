package environment;

import config.DotEnvConfig;
import driver.MobileCapabilities;
import driver.Local;
import driver.Mobile;
import driver.Selenoid;
import driver.constants.Browser;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import ui.BasePage;


public class Environment {

    private DotEnvConfig config = new DotEnvConfig();
    private BasePage basePage;


    public Environment() {
        WebDriver driver = null;

        Browser browser = getBrowser();
        if(browser == null) {
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
                MobileCapabilities caps = new MobileCapabilities(browser, mode);
                driver = new Mobile(serverUrl, platform, caps).driver();
            } else if (config.getEnvironment().toLowerCase().equals(EnvironmentType.SELENOID.toString().toLowerCase())) {
                String serverUrl = config.getServerUrl();
                int screenWidth = Integer.parseInt(config.getScreenWidth());
                int screenHeight = Integer.parseInt(config.getScreenHeight());
                driver = new Selenoid(serverUrl, browser, screenWidth, screenHeight).driver();
            } else if (config.getEnvironment().toLowerCase().equals(EnvironmentType.LOCAL.toString().toLowerCase()))
                driver = new Local(browser).driver();
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


    private Browser getBrowser() {
        Browser result = null;
        for(Browser browser : Browser.values()) {
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