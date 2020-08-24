package driver.constants;

import java.io.File;


public enum Browser {

    CHROME_79   (BrowserLabel.CHROME, "79.0", BrowserLabel.CHROME.path + File.separator + "chromedriver_79"),
    CHROME_80   (BrowserLabel.CHROME, "80.0", BrowserLabel.CHROME.path + File.separator + "chromedriver_80"),
    CHROME_81   (BrowserLabel.CHROME, "81.0", BrowserLabel.CHROME.path + File.separator + "chromedriver_81"),
    CHROME_83   (BrowserLabel.CHROME, "83.0", BrowserLabel.CHROME.path + File.separator + "chromedriver_83"),
    CHROME_84   (BrowserLabel.CHROME, "84.0", BrowserLabel.CHROME.path + File.separator + "chromedriver_84"),
    CHROME_85   (BrowserLabel.CHROME, "85.0", BrowserLabel.CHROME.path + File.separator + "chromedriver_85"),
    FIREFOX_026 (BrowserLabel.FF,     "26.0", BrowserLabel.FF.path     + File.separator + "geckodriver_026"),
    OPERA_64    (BrowserLabel.OPERA,  "64.0", BrowserLabel.OPERA.path  + File.separator + "operadriver_64"),
    OPERA_65    (BrowserLabel.OPERA,  "65.0", BrowserLabel.OPERA.path  + File.separator + "operadriver_65"),
    ;
    public final BrowserLabel label;
    public final String version;
    public final String filePath;


    Browser(BrowserLabel label, String version, String filePath) {
        this.label = label;
        this.version = version;
        this.filePath = filePath;
    }
}