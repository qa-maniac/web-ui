package ui;

import config.DotEnvConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class BasePage {

    private WebDriver driver;
    private WebDriverWait wait;


    public BasePage(WebDriver driver) {
        this.driver = driver;
//        this.driver.manage().window().maximize(); // TODO: move this to suite cause MOBILE environment gets an Exception when using window -> maximize

        long timeout = Long.parseLong(new DotEnvConfig().getTimeout());

        this.driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
        this.wait = new WebDriverWait(driver, timeout);
    }


    public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass) {
        try {
            return PageFactory.initElements(driver, pageClass);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }
}