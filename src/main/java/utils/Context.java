package utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;


public class Context {

    public String webView;
    public String nativeApp;
    public String currentContext;


    public Context(WebDriver driver) {
        try {
            webView = "WEBVIEW_" + ((RemoteWebDriver) driver).getCapabilities().getCapability("appPackage").toString();
            nativeApp = "NATIVE_APP";
            currentContext = ((AppiumDriver) driver).getContext();
        }
        catch (Exception e) {
            webView = "";
            nativeApp = "";
            currentContext = "";
        }
    }
}