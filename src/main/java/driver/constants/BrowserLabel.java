package driver.constants;

public enum BrowserLabel {

    CHROME  (System.getProperty("user.dir") + "/src/main/java/driver/constants/chrome"),
    EDGE    (System.getProperty("user.dir") + "/src/main/java/driver/constants/edge"),
    FF      (System.getProperty("user.dir") + "/src/main/java/driver/constants/firefox"),
    IE      (System.getProperty("user.dir") + "/src/main/java/driver/constants/ie"),
    OPERA   (System.getProperty("user.dir") + "/src/main/java/driver/constants/opera"),
    SAFARI  (System.getProperty("user.dir") + "/src/main/java/driver/constants/safari"),
    ;
    public final String path;

    BrowserLabel(String path) {
        this.path = path;
    }
}
