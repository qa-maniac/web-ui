package driver;

import driver.constants.Browser;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;


public class Selenoid implements UiWebDriver {

    private WebDriver driver;
    private Dimension dimension;


    public Selenoid(String serverUrl, Browser browser, int width, int height) {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setBrowserName(browser.label.name().toLowerCase());
        caps.setVersion(browser.version);
        caps.setCapability("enableVNC", true);
        caps.setCapability("enableVideo", false);
        caps.setCapability("screenResolution", width + "x" + height + "x24");
        dimension = new Dimension(width, height);
        try {
            this.driver = new RemoteWebDriver(new URL(serverUrl + "/wd/hub"), caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }


    public Selenoid(String serverUrl, DesiredCapabilities capabilities) {
        try {
            driver = new RemoteWebDriver(new URL(serverUrl + "/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public WebDriver driver() {
        return driver;
    }

    public Dimension dimension() {
        return dimension;
    }
}
