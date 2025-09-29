import com.alttester.AltDriver;
import com.alttester.AltObject;
import com.alttester.AltReversePortForwarding;
import com.alttester.Commands.FindObject.AltFindObjectsParams;
import com.alttester.Commands.FindObject.AltWaitForObjectsParams;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

public class BaseTest {

     public AltDriver altDriver;

    @BeforeClass
    public void setUp() throws IOException
    {
        AltReversePortForwarding.reversePortForwardingAndroid();
        altDriver = new AltDriver("127.0.0.1", 13000);
        System.out.println("BaseTest setup");
    }

    @AfterClass
    public void tearDown() throws Exception {

        altDriver.stop();
        System.out.print("BaseTest tearDown");
        AltReversePortForwarding.removeReversePortForwardingAndroid();
    }

//    public AltObject waitForObjectByName(String objectName) {
//        AltFindObjectsParams findParams = new AltFindObjectsParams.Builder(AltDriver.By.NAME, objectName).build();
//        AltWaitForObjectsParams waitParams = new AltWaitForObjectsParams.Builder(findParams).build();
//        return altDriver.waitForObject(waitParams);
//    }
}
