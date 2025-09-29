import com.alttester.AltDriver;
import com.alttester.AltObject;
import com.alttester.Commands.FindObject.AltFindObjectsParams;
import com.alttester.Commands.FindObject.AltWaitForObjectsParams;
import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomeScreen;
import pages.InventoryPage;

import java.io.IOException;

public class InventoryScreenTest extends BaseTest{
    private AltDriver altDriver;
    private InventoryPage inventoryPage;
    private HomeScreen homeScreen;

    @BeforeClass
    public void setUp() throws IOException
    {
        // Code is in BaseTest
        altDriver = new AltDriver("127.0.0.1", 13000);
        inventoryPage = new InventoryPage(altDriver);
        homeScreen = new HomeScreen(altDriver);
        System.out.println("InventoryPage setup");
    }

    @AfterClass
    public void tearDown() throws Exception
    {
        System.out.println("InventoryPage teardown");
        Thread.sleep(1000);
    }

    @Test(priority = 1)
    public void checkInventoryTapIsTappable()
    {
        homeScreen.tapInventoryTab();
        AltFindObjectsParams findParams = new AltFindObjectsParams.Builder(AltDriver.By.NAME, "Inventory").build();
        AltWaitForObjectsParams waitParams = new AltWaitForObjectsParams.Builder(findParams).build();
        altDriver.waitForObject(waitParams);
        Assert.assertTrue(homeScreen.getInventoryTabObject().isEnabled());
    }

    @Test(priority = 2)
    public void checkInventoryObjectIsEnabled()
    {
        Assert.assertTrue(inventoryPage.getInventoryPopUpObject().isEnabled());
    }

    public void checkBatSelectionUiIsTappable() {

    }

    public void checkIfScrollUpIsFunctional() throws InterruptedException
    {
        AltObject object = inventoryPage.getCardCollectionPanel();
        float initialPosY = object.getWorldY();

        inventoryPage.tapOnUIScrollButton();
        Thread.sleep(2000);

        AltObject objectModified = inventoryPage.getCardCollectionPanel();
        float modifiedPosY = objectModified.getWorldY();

        Assert.assertTrue("CardSelection Panel has moved Up", modifiedPosY > initialPosY);

    }

    public void checkIfScrollDownIsFunctional() throws InterruptedException
    {
        AltObject object = inventoryPage.getCardCollectionPanel();
        float initialPosY = object.getWorldY();

        inventoryPage.tapOnUIScrollButton();
        Thread.sleep(2000);

        AltObject objectModified = inventoryPage.getCardCollectionPanel();
        float modifiedPosY = objectModified.getWorldY();

        Assert.assertTrue("CardSelection Panel has moved Down", initialPosY > modifiedPosY);

    }
}
