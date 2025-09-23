import Pages.HomeScreen;
import Utils.AltDriverController;
import com.alttester.AltDriver;
import org.glassfish.grizzly.compression.lzma.impl.Base;
import org.junit.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import Pages.HomeScreen;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HomeScreenTest extends BaseTest {
        AltDriver altDriver = AltDriverController.getDriver();
        HomeScreen homeScreen;


        @BeforeClass
        public static void setUp() {
//            homeScreen = new HomeScreen(altDriver);
        }

        @AfterClass
        public static void tearDown() throws IOException {

        }

        @Test
        @Order(1)
        public void verifyGameScene() {
            String CurrentSceneName = altDriver.getCurrentScene();
            Assert.assertEquals(CurrentSceneName, "HomeScreen");
        }

        @Test
        @Order(2)
        public void verifyPlayButtonDisplayed()
        {
            Assert.assertTrue(homeScreen.isDisplayed());
        }

    }
