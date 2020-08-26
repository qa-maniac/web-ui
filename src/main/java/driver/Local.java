package driver;

import driver.constants.Browser;
import driver.constants.BrowserLabel;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.io.File;


public class Local implements UiWebDriver {

    private Browser browser;


    public Local(Browser browser) {
        this.browser = browser;
    }

    @Override
    public synchronized WebDriver driver() {
        if      (browser.label.equals(BrowserLabel.IE))     return setInternetExplorerDriver();
        else if (browser.label.equals(BrowserLabel.FF))     return setFireFoxDriver();
        else if (browser.label.equals(BrowserLabel.OPERA))  return setOperaDriver();
        else if (browser.label.equals(BrowserLabel.EDGE))   return setEdgeDriver();
        else if (browser.label.equals(BrowserLabel.CHROME)) return setChromeDriver();
        else {
            try {
                throw new Exception("Pay attention! You are trying to use unknown browser.");
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    private WebDriver setFireFoxDriver() {
//        String driverPath = new File(browser.filePath).getAbsolutePath();
//        System.setProperty("webdriver.gecko.driver", driverPath);
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    private WebDriver setChromeDriver() {
//        String driverPath = new File(browser.filePath).getAbsolutePath();
//        System.setProperty("webdriver.chrome.driver", driverPath);
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    private WebDriver setOperaDriver() {
//        String driverPath = new File(browser.filePath).getAbsolutePath();
//        System.setProperty("webdriver.opera.driver", driverPath);
        WebDriverManager.operadriver().setup();
        return new OperaDriver();
    }

    private WebDriver setEdgeDriver() {
//        String driverPath = new File(browser.filePath).getAbsolutePath();
//        System.setProperty("webdriver.edge.driver", driverPath);
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }

    private WebDriver setInternetExplorerDriver() {
        String driverPath = new File(browser.filePath).getAbsolutePath();
        System.setProperty("webdriver.ie.driver", driverPath);
        return new InternetExplorerDriver();
    }
}