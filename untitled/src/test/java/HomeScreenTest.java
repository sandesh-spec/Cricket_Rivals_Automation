import com.alttester.AltDriver;
import com.alttester.AltObject;
import com.alttester.Commands.FindObject.AltFindObjectsParams;
import com.alttester.Commands.FindObject.AltWaitForObjectsParams;
import org.junit.Assert;
import org.testng.SkipException;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pages.HomeScreen;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class HomeScreenTest extends BaseTest
{
    private AltDriver altDriver;
    private HomeScreen homeScreen;
    SoftAssert softAssert = new SoftAssert();


    @BeforeClass
    public void setUp() throws IOException
    {
        // Code is in BaseTest
        altDriver = new AltDriver("127.0.0.1", 13000);
        homeScreen = new HomeScreen(altDriver);
        System.out.println("HomeScreenTest setup");
    }

    @AfterClass
    public void tearDown() throws Exception
    {
        System.out.println("Homescreen teardown");
        Thread.sleep(1000);
    }

    @Test(priority = 0)
    public void testHomeScreenLoaded()
    {

//      homeScreen.loadHomeScreenScene();
        Assert.assertTrue(homeScreen.isHomeScreenLoaded());
    }

    @Test(priority = 1)
    public void testPlayButtonIsEnabled()
    {
        AltObject playButton = homeScreen.getPlayButton();
        Assert.assertTrue(playButton.isEnabled());
    }

    @Test(priority = 2)
    public void testClaimButtonIsEnabled()
    {
        AltObject claimButton = homeScreen.getClaimButton();
        Assert.assertTrue(claimButton.isEnabled());
    }

    @Test(priority = 3)
    public void testShopTabIsEnabled()
    {
        AltObject shopTab = homeScreen.getShopTabUI();
        Assert.assertTrue(shopTab.isEnabled());
    }

    @Test(priority = 4)
    public void testHomeTabIsEnabled()
    {
        AltObject homeTab = homeScreen.getHomeTab();
        Assert.assertTrue(homeTab.isEnabled());
    }

    @Test(priority = 5)
    public void testInventoryTabIsEnabled()
    {
        AltObject inventoryTab = homeScreen.getInventoryTab();
        Assert.assertTrue(inventoryTab.isEnabled());
    }

    @Test(priority = 6)
    public void testShopTabIsTappable()
    {
        //Add more assertions for objects inside shop when implemented inside the game (WIP)
        homeScreen.tapShopTab();
        AltFindObjectsParams findParams = new AltFindObjectsParams.Builder(AltDriver.By.NAME, "Shop").build();
        AltWaitForObjectsParams waitParams = new AltWaitForObjectsParams.Builder(findParams).build();
        altDriver.waitForObject(waitParams);
//        super.waitForObjectByName("Shop");
        Assert.assertTrue(homeScreen.getShopTabObject().isEnabled());
    }

    @Test(priority = 7)
    public void testHomeTabIsTappable()
    {
        homeScreen.tapHomeTab();
        AltFindObjectsParams findParams = new AltFindObjectsParams.Builder(AltDriver.By.NAME, "HomeScreen").build();
        AltWaitForObjectsParams waitParams = new AltWaitForObjectsParams.Builder(findParams).build();
        altDriver.waitForObject(waitParams);
//        super.waitForObjectByName("HomeScreen");
        Assert.assertTrue(homeScreen.getHomeTabObject().isEnabled());
    }

    @Test(priority = 8)
    public void testInventoryTabIsTappable()
    {
        homeScreen.tapInventoryTab();
        AltFindObjectsParams findParams = new AltFindObjectsParams.Builder(AltDriver.By.NAME, "Inventory").build();
        AltWaitForObjectsParams waitParams = new AltWaitForObjectsParams.Builder(findParams).build();
        altDriver.waitForObject(waitParams);
        Assert.assertTrue(homeScreen.getInventoryTabObject().isEnabled());
        testHomeTabIsTappable();
    }

    @Test(priority = 9)
    public void testClaimButtonIsTappable()
    {
        homeScreen.tapClaimButton();
        AltFindObjectsParams findParams = new AltFindObjectsParams.Builder(AltDriver.By.NAME, "TokenChestPopUp").build();
        AltWaitForObjectsParams waitParams = new AltWaitForObjectsParams.Builder(findParams).build();
        altDriver.waitForObject(waitParams);
        Assert.assertTrue(homeScreen.getTokenChestPopUp().isEnabled());
    }

    @Test(priority = 10)
    public void testOpenChestButtonIsTappable()
    {
        AltObject fillCountObj = homeScreen.getFillCountObject();
        String count = fillCountObj.getText().split("/")[0];
        int ownedToken = Integer.parseInt(count);
        System.out.println("Owned Token: "+ownedToken);
        if(ownedToken >= 30)
        {
            AltObject openChestButton = homeScreen.getOpenChestButton();
            openChestButton.tap();
            AltObject rewardScreen = homeScreen.getRewardScreenObject();
            Assert.assertTrue(rewardScreen.isEnabled());
        }
        else
        {
            throw new SkipException("Skipping test because ownedTokens are less than 30");
        }
    }

//    @Test(priority = 11)
//    public void testOpenChestButtonIsNotTappable()
//    {
//        AltObject fillCountObj = homeScreen.getFillCountObject();
//        String count = fillCountObj.getText().split("/")[0];
//        int ownedToken = Integer.parseInt(count);
//        System.out.println("Owned Token: "+ownedToken);
//        if(ownedToken < 30)
//        {
//            AltObject openChestButton = homeScreen.getOpenChestButton();
//            openChestButton.tap();
//            AltObject backButton = homeScreen.getBackButtonChestPopUp();
//            Assert.assertTrue(backButton.isEnabled());
//        }
//        else
//        {
//            AltObject backButton = homeScreen.getBackButtonChestPopUp();
//            homeScreen.tapBackButtonForChestPopUp();
//            throw new SkipException("Skipping test because ownedTokens are greater than 30");
//        }
//    }
}
