package pages;

import com.alttester.AltDriver;
import com.alttester.AltObject;
import com.alttester.Commands.FindObject.AltFindObjectsParams;

public class InventoryPage extends BasePage
{
    public InventoryPage(AltDriver driver) {
        super(driver);
    }

    public AltObject BatSelectionUI;
    public AltObject CharacterSelectionUI;
    public AltObject UIScrollButton;
    public AltObject playerCard;

    public AltObject inventoryPopUpObject;
    public AltObject equipButton;
    public AltObject upgradeButton;
    public AltObject powerStat;
    public AltObject precisionStat;
    public AltObject speedStat;
    public AltObject chancesStat;
    public AltObject inventoryPopUpCloseButton;

    public AltObject cardCollectionPanelObject;

    public AltObject getBatSelectionUI()
    {
        AltFindObjectsParams bat = new AltFindObjectsParams.Builder(AltDriver.By.NAME, "BatBtn").build();
        BatSelectionUI = getDriver().findObject(bat);
        return BatSelectionUI;
    }

    public AltObject getCharacterSelectionUI()
    {
        AltFindObjectsParams character = new AltFindObjectsParams.Builder(AltDriver.By.NAME, "CharacterBtn").build();
        CharacterSelectionUI = getDriver().findObject(character);
        return BatSelectionUI;
    }

    public AltObject getUIScrollButton()
    {
        AltFindObjectsParams scroll = new AltFindObjectsParams.Builder(AltDriver.By.NAME, "ScrollTransformBtn").build();
        UIScrollButton = getDriver().findObject(scroll);
        return UIScrollButton;
    }

    public AltObject getInventoryPopUpObject()
    {
        AltFindObjectsParams inventory = new AltFindObjectsParams.Builder(AltDriver.By.NAME, "Inventory").build();
        inventoryPopUpObject = getDriver().findObject(inventory);
        return inventoryPopUpObject;
    }

    public AltObject getPlayerCard()
    {
        AltFindObjectsParams card = new AltFindObjectsParams.Builder(AltDriver.By.PATH, "/Canvas/Inventory/CardCollectionPanel/Scroll View/Viewport/Content/PlayerCard(Clone)").build();
        playerCard = getDriver().findObject(card);
        return playerCard;
    }

    public AltObject getEquipButton()
    {
        AltFindObjectsParams equip = new AltFindObjectsParams.Builder(AltDriver.By.NAME, "Equip").build();
        equipButton = getDriver().findObject(equip);
        return equipButton;
    }

    public AltObject getUpgradeButton()
    {
        AltFindObjectsParams upgrade = new AltFindObjectsParams.Builder(AltDriver.By.NAME, "UpgradeBtn").build();
        upgradeButton = getDriver().findObject(upgrade);
        return upgradeButton;
    }

    public AltObject getPowerStat()
    {
        AltFindObjectsParams power = new AltFindObjectsParams.Builder(AltDriver.By.NAME, "Stat1_Txt").build();
        powerStat = getDriver().findObject(power);
        return powerStat;
    }

    public AltObject getPrecisionStat()
    {
        AltFindObjectsParams precision = new AltFindObjectsParams.Builder(AltDriver.By.NAME, "Stat2_Txt").build();
        precisionStat = getDriver().findObject(precision);
        return precisionStat;
    }

    public AltObject getSpeedStat()
    {
        AltFindObjectsParams speed = new AltFindObjectsParams.Builder(AltDriver.By.NAME, "Stat3_Txt").build();
        speedStat = getDriver().findObject(speed);
        return speedStat;
    }

    public AltObject getChancesStat()
    {
        AltFindObjectsParams speed = new AltFindObjectsParams.Builder(AltDriver.By.NAME, "Stat3_Txt").build();
        speedStat = getDriver().findObject(speed);
        return speedStat;
    }

    public AltObject getInventoryPopUpCloseButton()
    {
        AltFindObjectsParams close = new AltFindObjectsParams.Builder(AltDriver.By.NAME, "CloseBtn").build();
        inventoryPopUpCloseButton = getDriver().findObject(close);
        return inventoryPopUpCloseButton;
    }

    public AltObject getCardCollectionPanel()
    {
        AltFindObjectsParams cardPanel = new AltFindObjectsParams.Builder(AltDriver.By.NAME, "CardCollectionPanel").build();
        cardCollectionPanelObject = getDriver().findObject(cardPanel);
        return cardCollectionPanelObject;
    }

    public void tapOnBatSelectionUI()
    {
        getBatSelectionUI().tap();
    }

    public void tapOnCharacterSelectionUI()
    {
        getCharacterSelectionUI().tap();
    }

    public void tapOnUIScrollButton()
    {
        getUIScrollButton().tap();
    }

    public void tapOnPlayerCard()
    {
        getPlayerCard().tap();
    }

    public void tapOnInventoryCloseButton()
    {
        getInventoryPopUpCloseButton().tap();
    }
}
