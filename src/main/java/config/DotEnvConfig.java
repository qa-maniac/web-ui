package config;

import io.github.cdimascio.dotenv.Dotenv;


public class DotEnvConfig {

    private String environment;
    private String browser;
    private String browserVersion;
    private String serverUrl;
    private String platform;
    private String mode;
    private String screenWidth;
    private String screenHeight;
    private String timeout;
    private String poolingTime;


    public DotEnvConfig() {
        this.environment    = Dotenv.load().get(DotEnvField.ENVIRONMENT.toString());
        this.browser        = Dotenv.load().get(DotEnvField.BROWSER.toString());
        this.browserVersion = Dotenv.load().get(DotEnvField.BROWSER_VERSION.toString());
        this.serverUrl      = Dotenv.load().get(DotEnvField.SERVER_URL.toString());
        this.platform       = Dotenv.load().get(DotEnvField.PLATFORM.toString());
        this.mode           = Dotenv.load().get(DotEnvField.MODE.toString());
        this.screenWidth    = Dotenv.load().get(DotEnvField.SCREEN_WIDTH.toString());
        this.screenHeight   = Dotenv.load().get(DotEnvField.SCREEN_HEIGHT.toString());
        this.timeout        = Dotenv.load().get(DotEnvField.TIMEOUT.toString());
        this.poolingTime    = Dotenv.load().get(DotEnvField.POOLING_TIME.toString());
    }

    public String getEnvironment() {
        return environment;
    }

    public String getBrowser() {
        return browser;
    }

    public String getBrowserVersion() {
        return browserVersion;
    }

    public String getServerUrl() {
        return serverUrl;
    }

    public String getPlatform() {
        return platform;
    }

    public String getMode() {
        return mode;
    }

    public String getScreenWidth() {
        return screenWidth;
    }

    public String getScreenHeight() {
        return screenHeight;
    }

    public String getTimeout() {
        return timeout;
    }

    public String getPoolingTime() {
        return poolingTime;
    }
}