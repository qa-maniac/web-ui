package driver.constants;

public enum MobileCapabilitiesField {

    FILE_PATH               ("caps.properties"),
    APP                     ("app"),
    APP_ACTIVITY            ("appActivity"),
    APP_PACKAGE             ("appPackage"),
    AUTO_WEB_VIEW           ("autoWebview"),
    AUTOMATION_NAME         ("automationName"),
    DEVICE_NAME             ("deviceName"),
    PLATFORM_VERSION        ("platformVersion"),
    PLATFORM_NAME           ("platformName"),
    AUTO_GRAND_PERMISSIONS  ("autoGrantPermissions"),
    //        UDID                    ("udid"),
    CHROME_DRIVER_EXECUTABLE("chromedriverExecutable"),
    ;
    public final String key;

    MobileCapabilitiesField(String key) {
        this.key = key;
    }
}