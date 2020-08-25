package driver.constants;

public enum BrowserLabel {

    CHROME  (System.getProperty("user.dir") + "/chrome"),
    EDGE    (System.getProperty("user.dir") + "/edge"),
    FF      (System.getProperty("user.dir") + "/firefox"),
    IE      (System.getProperty("user.dir") + "/ie"),
    OPERA   (System.getProperty("user.dir") + "/opera"),
    SAFARI  (System.getProperty("user.dir") + "/safari"),
    ;
    public final String path;

    BrowserLabel(String path) {
        this.path = path;
    }
}
