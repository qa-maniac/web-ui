package driver.constants;

public enum BrowserLabel {

    CHROME  (System.getProperty("user.dir") + "/src/main/resources/chrome"),
    EDGE    (System.getProperty("user.dir") + "/src/main/resources/edge"),
    FF      (System.getProperty("user.dir") + "/src/main/resources/firefox"),
    IE      (System.getProperty("user.dir") + "/src/main/resources/ie"),
    OPERA   (System.getProperty("user.dir") + "/src/main/resources/opera"),
    SAFARI  (System.getProperty("user.dir") + "/src/main/resources/safari"),
    ;
    public final String path;

    BrowserLabel(String path) {
        this.path = path;
    }
}
