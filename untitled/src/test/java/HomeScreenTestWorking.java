//import com.alttester.AltDriver;
//import org.junit.*;
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.TestMethodOrder;
//
//import java.io.IOException;
//
//import static org.junit.Assert.assertTrue;
//
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//public class HomeScreenTestWorking {
//        AltDriver altDriver;
//
//
//        @Before
//        public void setUp() {
//            altDriver = new AltDriver("127.0.0.1", 13000);
//        }
//
//        @After
//        public void tearDown() throws IOException {
//                altDriver.stop();
//        }
//
//        @Test
//        @Order(1)
//        public void verifyGameScene() {
//            String CurrentSceneName = altDriver.getCurrentScene();
//            Assert.assertEquals(CurrentSceneName, "HomeScreen");
//        }
//
//        @Test
//        @Order(2)
//        public void verifyPlayButtonDisplayed()
//        {
//
//        }
//
////        @Test
////        @Order(3)
////        public void verifyPlayButtonIsTappable()
////        {
////                AltFindObjectsParams object = new AltFindObjectsParams.Builder(AltDriver.By.NAME, "PlayBtn").build();
////                AltObject PlayButton = altDriver.findObject(object);
////                PlayButton.tap();
////        }
//}
