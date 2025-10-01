import Mapper.PlayerMapper;
import Pojo.PlayerCard;
import Utilities.Utility;
import com.alttester.AltDriver;
import com.alttester.AltObject;
import com.alttester.Commands.FindObject.AltFindObjectsParams;
import com.alttester.Commands.FindObject.AltWaitForObjectsParams;
import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomeScreen;
import pages.InventoryPage;

import java.io.IOException;
import java.util.List;

public class InventoryScreenTest extends BaseTest{
    private AltDriver altDriver;
    private InventoryPage inventoryPage;
    private HomeScreen homeScreen;
    private AltObject[] playerCardObjects;
    private PlayerMapper playerMapper;
    SoftAssert softAssert = new SoftAssert();


    //region Set&TearDown
    @BeforeClass
    public void setUp() throws IOException
    {
        // Code is in BaseTest
        altDriver = new AltDriver();
        inventoryPage = new InventoryPage(altDriver);
        homeScreen = new HomeScreen(altDriver);
        playerMapper = new PlayerMapper();
//        AltFindObjectsParams playerCard = new AltFindObjectsParams.Builder(AltDriver.By.NAME, "PlayerCard(Clone)").build();
//        playerCardObjects = altDriver.findObjects(playerCard);
//        System.out.println("InventoryPage setup, number of player cards found: " + playerCardObjects.length);
    }

    @AfterClass
    public void tearDown() throws Exception
    {
        System.out.println("InventoryPage teardown");
        altDriver.stop();
        Thread.sleep(1000);
    }
    //endregion

    //region DataProvider
    @DataProvider(name = "playerCardData")
    public Object[][] playerCardData() {
        return new Object[][]{
                {0, "Rinku Singh", "Common"},
                {1, "Ishan Kishan", "Common"},
                {2, "Ravindra Jadeja", "Common"},
                {3, "Hardik Pandya", "Rare"},
                {4, "", ""},
                {5, "", ""},
                {6, "", ""},
                {7, "", ""}
                // Add more cards as required
        };
    }

    @DataProvider(name = "batCardData")
    public Object[][] batCardData() {
        return new Object[][]{
                {0, "SachinBat", "Common"},
                {1, "ViratBat", "Common"},
                {2, "RohitBat", "Legendary"},
                {3, "RohitBat", "Legendary"},
                {4, "", ""},
                {5, "", ""},
                {6, "", ""}
                // Add more cards as required
        };
    }
//endregion

    //region Tests
    @Test(priority = 1)
    public void checkInventoryTabIsTappable()
    {
        AltObject inventory = homeScreen.getInventoryTab();
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

    @Test(priority = 3)
    public void checkBatSelectionUiIsTappable() throws InterruptedException {
        AltObject object = inventoryPage.getBatSelectionUI();
        object.tap();
        AltObject batCardName = inventoryPage.getNameText();
        String cardName = batCardName.getText();
        System.out.println(cardName);
        Assert.assertEquals("SachinBat",cardName);
        Thread.sleep(1000);
    }


    @Test(priority = 5)
    public void checkCharacterSelectionUiIsTappable() throws InterruptedException {
        AltObject obj = inventoryPage.getCharacterSelectionUI();
        obj.tap();
        AltObject charCardName = inventoryPage.getNameText();
        String chcardName = charCardName.getText();
        System.out.println(chcardName);
        Assert.assertEquals("Rinku Singh",chcardName);
        Thread.sleep(1000);
    }

    @Test(priority = 6)
    public void checkIfScrollUpIsFunctional() throws InterruptedException
    {
        AltObject object = inventoryPage.getCardCollectionPanel();
        float initialPosY = object.getWorldY();

        inventoryPage.tapOnUIScrollButton();
        Thread.sleep(1000);

        AltObject objectModified = inventoryPage.getCardCollectionPanel();
        float modifiedPosY = objectModified.getWorldY();

        Assert.assertTrue("CardSelection Panel has moved Up", modifiedPosY > initialPosY);

    }

    @Test(priority = 7)
    public void checkIfScrollDownIsFunctional() throws InterruptedException
    {
        AltObject object = inventoryPage.getCardCollectionPanel();
        float initialPosY = object.getWorldY();

        inventoryPage.tapOnUIScrollButton();
        Thread.sleep(1000);

        AltObject objectModified = inventoryPage.getCardCollectionPanel();
        float modifiedPosY = objectModified.getWorldY();

        Assert.assertTrue("CardSelection Panel has moved Down", initialPosY > modifiedPosY);
    }

    @Test(priority = 8)
    public void checkIfPlayerCardIsTappable()
    {
        AltObject obj = inventoryPage.getPlayerCard();
        obj.tap();
        AltObject cardPopUp = inventoryPage.getPlayerCardPopUp();
        Assert.assertTrue(cardPopUp.isEnabled());
    }

    @Test(priority = 9)
    public void checkIfStatTextIsSpelledCorrectly()
    {
        AltObject power = inventoryPage.getPowerTxt();
        AltObject precision = inventoryPage.getPrecisionTxt();
        AltObject speed = inventoryPage.getSpeedTxt();
        AltObject chances = inventoryPage.getChancesTxt();

        Assert.assertEquals("Power: ", power.getText());
        Assert.assertEquals("Precision: ", precision.getText());
        Assert.assertEquals("Speed: ", speed.getText());
        Assert.assertEquals("Chances: ", chances.getText());
    }

    @Test(priority = 10)
    public void checkIfCardIsUpgradeAble()
    {
        int piece = Utility.getStatValue(() -> inventoryPage.getPieces());
        int reqPiece = Utility.getStatValue(() -> inventoryPage.getPiecesRequired());
        int ownedCoin = Utility.getStatValue(() -> inventoryPage.getTopUICoinsText());
        int upgradeCost = Utility.getStatValue(() -> inventoryPage.getUpgradeCostText());

        inventoryPage.getInventoryPopUpCloseButton().tap();
        softAssert.assertTrue(piece >= reqPiece, "ownedPieces are lower than required Pieces");
        softAssert.assertTrue(ownedCoin >= upgradeCost, "ownedCoins are lower than UpgradeCost");
        softAssert.assertAll();
    }

    @Test(priority = 11, dependsOnMethods = {"checkIfCardIsUpgradeAble"})
    public void checkIfCardIsUpgraded()
    {
        AltObject upgradeButton = inventoryPage.getUpgradeButton();

        int initialSpeedValue = Utility.getStatValue(() -> inventoryPage.getSpeedValue());
        int initialPowerValue = Utility.getStatValue(() -> inventoryPage.getPowerValue());
        int initialPrecisionValue = Utility.getStatValue(() -> inventoryPage.getPrecisionValue());

        upgradeButton.tap();

        int updatedSpeedValue = Utility.getStatValue(() -> inventoryPage.getSpeedValue());
        int updatedPowerValue = Utility.getStatValue(() -> inventoryPage.getPowerValue());
        int updatedPrecisionValue = Utility.getStatValue(() -> inventoryPage.getPrecisionValue());

        Assert.assertTrue(initialPowerValue < updatedPowerValue);
        Assert.assertTrue(initialSpeedValue <= updatedSpeedValue);
        softAssert.assertTrue(initialPrecisionValue < updatedPrecisionValue);
        inventoryPage.tapOnInventoryCloseButton();
    }

    @Test(dataProvider = "playerCardData", priority = 12)
    public void validatePlayerCard(int index, String expectedName, String expectedRarity) throws InterruptedException {

        AltFindObjectsParams playerCard = new AltFindObjectsParams.Builder(AltDriver.By.NAME, "PlayerCard(Clone)").build();
        playerCardObjects = altDriver.findObjects(playerCard);

        AltObject cardObject = playerCardObjects[index];

        PlayerCard actualCard = playerMapper.mapAltObjectToPlayerCard(cardObject);
        PlayerCard expectedCard = playerMapper.buildExpectedPlayerCard(expectedName, expectedRarity, null, null);

        Assert.assertEquals(actualCard.getNameText(), expectedCard.getNameText());
        Assert.assertEquals(actualCard.getRarityTxt(), expectedCard.getRarityTxt());
    }

    @Test(priority = 13)
    public void reRunBatSelectionUiTest()
    {
        AltObject object = inventoryPage.getBatSelectionUI();
        object.tap();
        AltObject batCardName = inventoryPage.getNameText();
        String cardName = batCardName.getText();
        System.out.println(cardName);
        Assert.assertEquals("SachinBat",cardName);
    }

    @Test(dataProvider = "batCardData", priority = 14)
    public void validateBatCard(int index, String expectedName, String expectedRarity)
    {

        AltFindObjectsParams playerCard = new AltFindObjectsParams.Builder(AltDriver.By.NAME, "PlayerCard(Clone)").build();
        playerCardObjects = altDriver.findObjects(playerCard);

        AltObject cardObject = playerCardObjects[index];

        PlayerCard actualCard = playerMapper.mapAltObjectToPlayerCard(cardObject);
        PlayerCard expectedCard = playerMapper.buildExpectedBatCard(expectedName, expectedRarity, null, null);

        Assert.assertEquals(actualCard.getNameText(), expectedCard.getNameText());
        Assert.assertEquals(actualCard.getRarityTxt(), expectedCard.getRarityTxt());
    }
    //endregion
}
