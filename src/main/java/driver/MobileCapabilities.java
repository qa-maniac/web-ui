package driver;

import config.PropertiesConfig;
import driver.constants.Browser;
import driver.constants.MobileCapabilitiesField;
import driver.constants.MobileCapabilitiesMode;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;


public class MobileCapabilities {

    private PropertiesConfig config = new PropertiesConfig(MobileCapabilitiesField.FILE_PATH.key);
    private DesiredCapabilities caps = new DesiredCapabilities();


    public MobileCapabilities(Browser browser, String modeLabel) {
        MobileCapabilitiesMode mode = null;
        try {
           mode = getMode(modeLabel);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        if(mode == MobileCapabilitiesMode.WEB)
            setWebCapabilities(browser);
        else setCapabilitiesFromFile();
    }


    public MobileCapabilities(Browser browser, MobileCapabilitiesMode mode) {
        if(mode == MobileCapabilitiesMode.WEB)
            setWebCapabilities(browser);
        else setCapabilitiesFromFile();
    }


    private void setWebCapabilities(Browser browser) {
        caps.setCapability(MobileCapabilitiesField.DEVICE_NAME.key, "device");
        caps.setBrowserName(browser.label.toString().toLowerCase());
        caps.setCapability(MobileCapabilitiesField.CHROME_DRIVER_EXECUTABLE.key, new File(browser.filePath).getAbsolutePath());
    }


    private void setCapabilitiesFromFile() {
        caps.setCapability(MobileCapabilitiesField.APP.key,                      config.get(MobileCapabilitiesField.APP.key));
        caps.setCapability(MobileCapabilitiesField.APP_ACTIVITY.key,             config.get(MobileCapabilitiesField.APP_ACTIVITY.key));
        caps.setCapability(MobileCapabilitiesField.APP_PACKAGE.key,              config.get(MobileCapabilitiesField.APP_PACKAGE.key));
        caps.setCapability(MobileCapabilitiesField.AUTO_WEB_VIEW.key,            config.get(MobileCapabilitiesField.AUTO_WEB_VIEW.key));
        caps.setCapability(MobileCapabilitiesField.AUTOMATION_NAME.key,          config.get(MobileCapabilitiesField.AUTOMATION_NAME.key));
        caps.setCapability(MobileCapabilitiesField.AUTO_GRAND_PERMISSIONS.key,   config.get(MobileCapabilitiesField.AUTO_GRAND_PERMISSIONS.key));
        caps.setCapability(MobileCapabilitiesField.DEVICE_NAME.key,              config.get(MobileCapabilitiesField.DEVICE_NAME.key));
        caps.setCapability(MobileCapabilitiesField.PLATFORM_NAME.key,            config.get(MobileCapabilitiesField.PLATFORM_NAME.key));
        caps.setCapability(MobileCapabilitiesField.PLATFORM_VERSION.key,         config.get(MobileCapabilitiesField.PLATFORM_VERSION.key));
        caps.setCapability(MobileCapabilitiesField.CHROME_DRIVER_EXECUTABLE.key, config.get(MobileCapabilitiesField.CHROME_DRIVER_EXECUTABLE.key));
//        setFullReset();
//        setNewCommandTimeout();
//        setPermissions();
//        setW3c();
//        recreateChromeDriverSessions();
    }

    public DesiredCapabilities getCapabilities() {
        return caps;
    }


    private MobileCapabilitiesMode getMode(String mode) throws Exception {
        MobileCapabilitiesMode result = null;
        for(MobileCapabilitiesMode mobileCapabilitiesMode : MobileCapabilitiesMode.values()) {
            if(mobileCapabilitiesMode.toString().toLowerCase().equals(mode.toLowerCase())) {
                result = mobileCapabilitiesMode;
                break;
            }
        }
        if (result == null)
            throw new Exception("Pay attention! You are trying to use incorrect Mode in '.env' file");
        else return result;
    }
}