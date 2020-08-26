package driver;

import driver.constants.BrowserLabel;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;


public class Local {

    private BrowserLabel browserLabel;
    private String browserVersion;
    private WebDriver driver;
    private String driverPath;


    public Local(BrowserLabel browserLabel, String browserVersion) {
        this.browserLabel = browserLabel;
        this.browserVersion = browserVersion;
        this.driver = setDriver();
    }


    private synchronized WebDriver setDriver() {
        if(browserVersion != null) {
            if (browserLabel.equals(BrowserLabel.IE)) return setInternetExplorerDriver(browserVersion);
            else if (browserLabel.equals(BrowserLabel.FF)) return setFireFoxDriver(browserVersion);
            else if (browserLabel.equals(BrowserLabel.OPERA)) return setOperaDriver(browserVersion);
            else if (browserLabel.equals(BrowserLabel.EDGE)) return setEdgeDriver(browserVersion);
            else if (browserLabel.equals(BrowserLabel.CHROME)) return setChromeDriver(browserVersion);
            else {
                try {
                    throw new Exception("Pay attention! You are trying to use unknown browser.");
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
        } else {
            if (browserLabel.equals(BrowserLabel.IE)) return setLastInternetExplorerDriver();
            else if (browserLabel.equals(BrowserLabel.FF)) return setLastFireFoxDriver();
            else if (browserLabel.equals(BrowserLabel.OPERA)) return setLastOperaDriver();
            else if (browserLabel.equals(BrowserLabel.EDGE)) return setLastEdgeDriver();
            else if (browserLabel.equals(BrowserLabel.CHROME)) return setLastChromeDriver();
            else {
                try {
                    throw new Exception("Pay attention! You are trying to use unknown browser.");
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
    }

    private WebDriver setFireFoxDriver(String version) {
        WebDriverManager.firefoxdriver().driverVersion(version).setup();
        driverPath = WebDriverManager.firefoxdriver().browserVersion(version).getDownloadedDriverPath();
        return new FirefoxDriver();
    }

    private WebDriver setChromeDriver(String version) {
        WebDriverManager.chromedriver().driverVersion(version).setup();
        driverPath = WebDriverManager.chromedriver().browserVersion(version).getDownloadedDriverPath();
        return new ChromeDriver();
    }

    private WebDriver setOperaDriver(String version) {
        WebDriverManager.operadriver().browserVersion(version).setup();
        driverPath = WebDriverManager.operadriver().browserVersion(version).getDownloadedDriverPath();
        return new OperaDriver();
    }

    private WebDriver setEdgeDriver(String version) {
        WebDriverManager.edgedriver().driverVersion(version).setup();
        driverPath = WebDriverManager.edgedriver().browserVersion(version).getDownloadedDriverPath();
        return new EdgeDriver();
    }

    private WebDriver setInternetExplorerDriver(String version) {
        WebDriverManager.iedriver().driverVersion(version).setup();
        driverPath = WebDriverManager.iedriver().browserVersion(version).getDownloadedDriverPath();
        return new InternetExplorerDriver();
    }

    private WebDriver setLastFireFoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        driverPath = WebDriverManager.firefoxdriver().getDownloadedDriverPath();
        return new FirefoxDriver();
    }

    private WebDriver setLastChromeDriver() {
        WebDriverManager.chromedriver().setup();
        driverPath = WebDriverManager.chromedriver().getDownloadedDriverPath();
        return new ChromeDriver();
    }

    private WebDriver setLastOperaDriver() {
        WebDriverManager.operadriver().setup();
        driverPath = WebDriverManager.operadriver().getDownloadedDriverPath();
        return new OperaDriver();
    }

    private WebDriver setLastEdgeDriver() {
        WebDriverManager.edgedriver().setup();
        driverPath = WebDriverManager.edgedriver().getDownloadedDriverPath();
        return new EdgeDriver();
    }

    private WebDriver setLastInternetExplorerDriver() {
        WebDriverManager.iedriver().setup();
        driverPath = WebDriverManager.iedriver().getDownloadedDriverPath();
        return new InternetExplorerDriver();
    }

    public BrowserLabel getBrowserLabel() {
        return browserLabel;
    }

    public String getBrowserVersion() {
        return browserVersion;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public String getDriverPath() {
        return driverPath;
    }
}