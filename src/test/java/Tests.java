import environment.Environment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.BasePage;


public class Tests {


    public static void main(String[] args) {
        new Tests().checkEnvironment();
    }


    public void checkEnvironment() {
        BasePage basePage = new Environment().getBasePage();
        basePage.getDriver().manage().window().maximize();
        basePage.getDriver().get("https://google.com");
        WebElement element = basePage.getDriver().findElement(By.xpath("//div[2]/div[1]/div/a"));
        element.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        basePage.getDriver().quit();
    }
}