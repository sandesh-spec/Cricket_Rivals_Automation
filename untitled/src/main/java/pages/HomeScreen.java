package pages;

import com.alttester.AltDriver;
import com.alttester.AltObject;
import com.alttester.Commands.FindObject.AltFindObjectsParams;
import com.alttester.Commands.UnityCommand.AltLoadSceneParams;

public class HomeScreen extends BasePage {
    public AltObject playButton;
    public String playText;
    public AltObject shopTab;
    public AltObject shopTabObject;
    public AltObject homeTab;
    public AltObject homeTabObject;
    public AltObject inventoryTab;
    public AltObject inventoryObject;
    public AltObject claimButton;
    public AltObject tokenChestPopUp;
    public AltObject openChestButton;
    public AltObject backButtonChestPopUp;
    public AltObject Character3D;
    public String sceneName;
    public AltObject rewardScreenObject;
    public AltObject fillCountObject;

    public HomeScreen(AltDriver driver) {
        super(driver);
    }

    public void loadHomeScreenScene() {
        getDriver().loadScene(new AltLoadSceneParams.Builder("HomeScreen").build());
    }

    public AltObject getPlayButton() {
        AltFindObjectsParams playObject = new AltFindObjectsParams.Builder(AltDriver.By.NAME, "PlayBtn").build();
        playButton = getDriver().findObject(playObject);
        return playButton;
    }

    public AltObject getShopTabUI() {
        AltFindObjectsParams shopTabObject = new AltFindObjectsParams.Builder(AltDriver.By.NAME, "NavigationButton_Shop").build();
        shopTab = getDriver().findObject(shopTabObject);
        return shopTab;
    }

    public AltObject getShopTabObject() {
        AltFindObjectsParams shopObject = new AltFindObjectsParams.Builder(AltDriver.By.NAME, "Shop").build();
        shopTabObject = getDriver().findObject(shopObject);
        return shopTabObject;
    }

    public AltObject getHomeTab() {
        AltFindObjectsParams homeTabObject = new AltFindObjectsParams.Builder(AltDriver.By.NAME, "NavigationButton_Home").build();
        homeTab = getDriver().findObject(homeTabObject);
        return homeTab;
    }

    public AltObject getHomeTabObject() {
        AltFindObjectsParams homeObject = new AltFindObjectsParams.Builder(AltDriver.By.NAME, "HomeScreen").build();
        homeTabObject = getDriver().findObject(homeObject);
        return homeTabObject;
    }

    public AltObject getInventoryTab() {
        AltFindObjectsParams inventoryTabObject = new AltFindObjectsParams.Builder(AltDriver.By.NAME, "NavigationButton_Inventory").build();
        inventoryTab = getDriver().findObject(inventoryTabObject);
        return inventoryTab;
    }

    public AltObject getInventoryTabObject() {
        AltFindObjectsParams inventoryTabObject = new AltFindObjectsParams.Builder(AltDriver.By.NAME, "Inventory").build();
        inventoryObject = getDriver().findObject(inventoryTabObject);
        return inventoryObject;
    }

    public AltObject getClaimButton() {
        AltFindObjectsParams claimButtonObject = new AltFindObjectsParams.Builder(AltDriver.By.ID, "853faa12-a6c7-4346-83f4-b3990e26d85d").build();
        claimButton = getDriver().findObject(claimButtonObject);
        return claimButton;
    }

    public AltObject getTokenChestPopUp() {
        AltFindObjectsParams tokenChest = new AltFindObjectsParams.Builder(AltDriver.By.NAME, "TokenChestPopUp").build();
        tokenChestPopUp = getDriver().findObject(tokenChest);
        return tokenChestPopUp;
    }

    public AltObject getFillCountObject()
    {
        AltFindObjectsParams countTxt = new AltFindObjectsParams.Builder(AltDriver.By.NAME, "CountTxt").build();
        fillCountObject = getDriver().findObject(countTxt);
        return fillCountObject;
    }

    public AltObject getOpenChestButton() {
        AltFindObjectsParams openChest = new AltFindObjectsParams.Builder(AltDriver.By.ID, "ebfd1f2e-31d2-46ba-8db9-74287962f878").build();
        openChestButton = getDriver().findObject(openChest);
        return openChestButton;
    }

    public AltObject getBackButtonChestPopUp()
    {
        AltFindObjectsParams backButton = new AltFindObjectsParams.Builder(AltDriver.By.ID, "e0a780d8-71cc-41f1-a44b-a2f2a064a7f5").build();
        backButtonChestPopUp = getDriver().findObject(backButton);
        return backButtonChestPopUp;
    }

    public String getSceneName()
    {
        sceneName = getDriver().getCurrentScene();
        return sceneName;
    }

    public AltObject getRewardScreenObject()
    {
        AltFindObjectsParams rewardScreenObj = new AltFindObjectsParams.Builder(AltDriver.By.NAME, "RewardScreen").build();
        rewardScreenObject = getDriver().findObject(rewardScreenObj);
        return rewardScreenObject;
    }

    public boolean isHomeScreenLoaded()
    {
        String currentSceneName = getSceneName();
        System.out.println(currentSceneName+" is Loaded");
        return sceneName.equals(currentSceneName);
    }

    public boolean isPlayTextDisplayed()
    {
        return playButton != null && playText != null;
    }

    public void tapShopTab()
    {
        shopTab.tap();
    }

    public void tapHomeTab()
    {
        homeTab.tap();
    }

    public void tapInventoryTab()
    {
        inventoryTab.tap();
    }

    public void tapClaimButton()
    {
        claimButton.tap();
    }

    public void tapPlayButton()
    {
        playButton.tap();
    }

    public void tapOpenChestButton()
    {
        openChestButton.tap();
    }

    public void tapBackButtonForChestPopUp()
    {
        backButtonChestPopUp.tap();
    }
}
