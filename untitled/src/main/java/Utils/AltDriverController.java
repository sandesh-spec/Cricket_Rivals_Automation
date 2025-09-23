package Utils;

import com.alttester.AltDriver;

import java.io.IOException;

public class AltDriverController {
    private static AltDriver driver;

    private AltDriverController() {}

    public static synchronized AltDriver getDriver() {
        if (driver == null) {
            driver = new AltDriver("127.0.0.1", 13000,true,60,"__default__","Android","Android OS 16 / API-36 (BE2A.250530.026.D1/13818094)","88ef62f18db902fe0e58a36200b57aa0","62B60000"); // Use correct host/port as per your config
        }
        return driver;
    }

    public static void quitDriver() throws IOException {
        if (driver != null) {
            driver.stop();
            driver = null;
        }
    }
}
