package driver;

import driver.constants.MobileCapabilitiesField;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.Map;


public class Mobile {

    private URL url;
    private Platform platform;
    private DesiredCapabilities capabilities;


    public Mobile(String serverUrl, Platform platform, DesiredCapabilities capabilities) {
        try {
            this.url = new URL(serverUrl + "/wd/hub");
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.platform = platform;
        if(!isPlatformFieldPresent(capabilities))
            capabilities.setCapability(MobileCapabilitiesField.PLATFORM_NAME.key, platform);

        this.capabilities = capabilities;
    }

    public Mobile(String serverUrl, Platform platform, MobileCapabilities preset) {
        try {
            this.url = new URL(serverUrl + "/wd/hub");
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.platform = platform;
        DesiredCapabilities capabilities = preset.getCapabilities();
        if(!isPlatformFieldPresent(capabilities))
            capabilities.setCapability(MobileCapabilitiesField.PLATFORM_NAME.key, platform);

        this.capabilities = capabilities;
    }


    private boolean isPlatformFieldPresent(DesiredCapabilities capabilities) {
        boolean result = false;
        Map<String, Object> caps = capabilities.asMap();
        for (Map.Entry<String, Object> entry : caps.entrySet()) {
            if (entry.getKey().equals(MobileCapabilitiesField.PLATFORM_NAME.key)) {
                result = true;
                break;
            }
        }
        return result;
    }


    public WebDriver driver() {
        WebDriver driver = null;
        try {
            driver = getDriver();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return driver;
    }


    private WebDriver getDriver() throws Exception {
        if (platform.equals(Platform.ANDROID))
            return new AndroidDriver<MobileElement>(url, capabilities);
        else if (platform.equals(Platform.IOS))
            return new IOSDriver<MobileElement>(url, capabilities);
        else throw new Exception("Pay attention! You are trying to use non-mobile 'Platform' value in mobile context.");
    }
}