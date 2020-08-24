package utils;

import io.appium.java_client.MobileDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class Screen {

    private WebDriver driver;
    private Dimension dimension;
    private File file;


    public Screen(WebDriver driver) {
        this.driver = driver;
        this.dimension = driver.manage().window().getSize();
    }


    public Dimension getDimension() {
        dimension = driver.manage().window().getSize();
        return dimension;
    }


    public int getWidth() {
        dimension = driver.manage().window().getSize();
        return dimension.width;
    }


    public int getHeight() {
        dimension = driver.manage().window().getSize();
        return dimension.height;
    }


    public void takeScreenshot(ScreenshotPath path, String... marker) {

        assert (marker.length <= 1);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String initContext = "";
        if (driver instanceof MobileDriver) {
            Context context = new Context(driver);
            initContext = context.currentContext;
            ((MobileDriver) driver).context(context.nativeApp);
        }

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            String localtime = new SimpleDateFormat("_dd-MM-yyyy_HH:mm:ss").format(new Date());
            if (marker.length == 0) {
                FileUtils.copyFile(scrFile, new File(path.value + localtime + ScreenshotPath.FILE_TYPE.value));
            } else
                FileUtils.copyFile(scrFile, new File(path.value + marker[0] + localtime + ScreenshotPath.FILE_TYPE.value));

        } catch (IOException e) {
            e.printStackTrace();
        }
        if (driver instanceof MobileDriver)
            ((MobileDriver) driver).context(initContext);
        this.file = scrFile;
    }


//    public void takeScreenshotForAllure(ScreenshotPath path, String... marker) throws IOException {
//        assert (marker.length <= 1);
//        if(marker.length == 0) takeScreenshot(path);
//        else takeScreenshot(path, marker[0]);
//
//        InputStream inputStream = new FileInputStream(file);
//        Allure.addAttachment("Screenshot", "image/png", inputStream, "png");
//    }


    public enum ScreenshotPath {

        BASE_PATH                   ("src/test/screenshots/"),
        BUSINESS_ACCEPTANCE         (BASE_PATH.value + "business/acceptance/"),
        BUSINESS_HEADER             (BASE_PATH.value + "business/header/"),
        BUSINESS_FOOTER             (BASE_PATH.value + "business/footer/"),
        BUSINESS_FAQ                (BASE_PATH.value + "business/faq/"),
        BUSINESS_CONTACT_US         (BASE_PATH.value + "business/contact_us/"),
        BUSINESS_COOKIES_POLICY     (BASE_PATH.value + "business/cookies/"),
        BUSINESS_PRIVACY_POLICY     (BASE_PATH.value + "business/privacy/"),
        COMMON_HEADER               (BASE_PATH.value + "common/header/"),
        COMMON_FOOTER               (BASE_PATH.value + "common/footer/"),
        COMMON_PHONES               (BASE_PATH.value + "common/phones/"),
        COMMON_MAIN                 (BASE_PATH.value + "common/main/"),
        COMMON_ABOUT_US             (BASE_PATH.value + "common/about_us/"),
        COMMON_CONTACT_US           (BASE_PATH.value + "common/contact_us/"),
        PERSONAL_HEADER             (BASE_PATH.value + "personal/header/"),
        PERSONAL_FAQ                (BASE_PATH.value + "personal/faq/"),
        PERSONAL_FOOTER             (BASE_PATH.value + "personal/footer/"),
        PERSONAL_CONTACT_US         (BASE_PATH.value + "personal/contact_us"),
        FILE_TYPE                   (".png"),
        ;
        public final String value;

        ScreenshotPath(String value) {
            this.value = value;
        }
    }
}