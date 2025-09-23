import Utils.AltDriverController;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import java.io.IOException;

public class BaseTest {

    @BeforeClass
    public static void setUp() {
        AltDriverController.getDriver();
    }

    @AfterClass
    public static void tearDown() throws IOException {
        AltDriverController.quitDriver();
    }
}
