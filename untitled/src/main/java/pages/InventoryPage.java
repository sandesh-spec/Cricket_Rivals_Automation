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
    public AltObject playerCard1;

    public AltObject pieces;
    public AltObject piecesRequired;
    public AltObject inventoryObject;
    public AltObject equipButton;
    public AltObject upgradeButton;
    public AltObject upgradeCostText;
    public AltObject powerTxt;
    public AltObject precisionTxt;
    public AltObject speedTxt;
    public AltObject chancesTxt;
    public AltObject rarityTxt;

    public AltObject powerValue;
    public AltObject speedValue;
    public AltObject chancesValue;
    public AltObject precisionValue;

    public AltObject inventoryPopUpCloseButton;

    public AltObject topUICoinsText;

    public AltObject cardCollectionPanelObject;

    public AltObject playerCardPopUp;

    public AltObject nameText;

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
        return CharacterSelectionUI;
    }

    public AltObject getUIScrollButton()
    {
        AltFindObjectsParams scroll = new AltFindObjectsParams.Builder(AltDriver.By.NAME, "ScrollTransformBtn").build();
        UIScrollButton = getDriver().findObject(scroll);
        return UIScrollButton;
    }

    public AltObject getNameText()
    {
        AltFindObjectsParams name = new AltFindObjectsParams.Builder(AltDriver.By.PATH, "/Canvas/Inventory/CardCollectionPanel/Scroll View/Viewport/Content/PlayerCard(Clone)/NameTxt").build();
        nameText = getDriver().findObject(name);
        return nameText;
    }

    public AltObject getInventoryPopUpObject()
    {
        AltFindObjectsParams inventory = new AltFindObjectsParams.Builder(AltDriver.By.NAME, "Inventory").build();
        inventoryObject = getDriver().findObject(inventory);
        return inventoryObject;
    }

    public AltObject getPlayerCard()
    {
        AltFindObjectsParams card = new AltFindObjectsParams.Builder(AltDriver.By.PATH, "/Canvas/Inventory/CardCollectionPanel/Scroll View/Viewport/Content/PlayerCard(Clone)").build();
        playerCard = getDriver().findObject(card);
        return playerCard;
    }

    public AltObject getPieces()
    {
        AltFindObjectsParams cardPieces = new AltFindObjectsParams.Builder(AltDriver.By.PATH, "/Canvas/InventoryPopUp/Content/PlayerCard(Clone)/Pieces").build();
        pieces = getDriver().findObject(cardPieces);
        return pieces;
    }

    public AltObject getRarityText()
    {
        AltFindObjectsParams rarity = new AltFindObjectsParams.Builder(AltDriver.By.PATH, "/Canvas/Inventory/CardCollectionPanel/Scroll View/Viewport/Content/PlayerCard(Clone)/RarityTxt").build();
        rarityTxt = getDriver().findObject(rarity);
        return rarityTxt;
    }

    public AltObject getPiecesRequired()
    {
        AltFindObjectsParams cardPiecesReq = new AltFindObjectsParams.Builder(AltDriver.By.PATH, "/Canvas/InventoryPopUp/Content/PlayerCard(Clone)/PiecesRequired").build();
        piecesRequired = getDriver().findObject(cardPiecesReq);
        return piecesRequired;
    }

    public AltObject getPlayerCardPopUp()
    {
        AltFindObjectsParams cardPopUp = new AltFindObjectsParams.Builder(AltDriver.By.NAME, "InventoryPopUp").build();
        playerCardPopUp = getDriver().findObject(cardPopUp);
        return playerCardPopUp;
    }

    public AltObject getTopUICoinsText()
    {
        AltFindObjectsParams ownedCoins = new AltFindObjectsParams.Builder(AltDriver.By.NAME, "CoinsText").build();
        topUICoinsText = getDriver().findObject(ownedCoins);
        return topUICoinsText;
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

    public AltObject getUpgradeCostText()
    {
        AltFindObjectsParams upgradeCost = new AltFindObjectsParams.Builder(AltDriver.By.NAME, "UpgradeCostTxt").build();
        upgradeCostText = getDriver().findObject(upgradeCost);
        return upgradeCostText;
    }

    public AltObject getPowerTxt()
    {
        AltFindObjectsParams power = new AltFindObjectsParams.Builder(AltDriver.By.NAME, "Stat1_Txt").build();
        powerTxt = getDriver().findObject(power);
        return powerTxt;
    }

    public AltObject getPrecisionTxt()
    {
        AltFindObjectsParams precision = new AltFindObjectsParams.Builder(AltDriver.By.NAME, "Stat2_Txt").build();
        precisionTxt = getDriver().findObject(precision);
        return precisionTxt;
    }

    public AltObject getSpeedTxt()
    {
        AltFindObjectsParams speed = new AltFindObjectsParams.Builder(AltDriver.By.NAME, "Stat3_Txt").build();
        speedTxt = getDriver().findObject(speed);
        return speedTxt;
    }

    public AltObject getChancesTxt()
    {
        AltFindObjectsParams chances = new AltFindObjectsParams.Builder(AltDriver.By.NAME, "Stat3_Txt").build();
        chancesTxt = getDriver().findObject(chances);
        return chancesTxt;
    }

    public AltObject getPowerValue()
    {
        AltFindObjectsParams power = new AltFindObjectsParams.Builder(AltDriver.By.NAME, "Power_Txt").build();
        powerValue = getDriver().findObject(power);
        return powerValue;
    }

    public AltObject getPrecisionValue()
    {
        AltFindObjectsParams precision = new AltFindObjectsParams.Builder(AltDriver.By.NAME, "Precesion_Txt").build();
        precisionValue = getDriver().findObject(precision);
        return precisionValue;
    }

    public AltObject getSpeedValue()
    {
        AltFindObjectsParams speed = new AltFindObjectsParams.Builder(AltDriver.By.NAME, "Speed_Txt").build();
        speedValue = getDriver().findObject(speed);
        return speedValue;
    }

    public AltObject getChancesValue()
    {
        AltFindObjectsParams chances = new AltFindObjectsParams.Builder(AltDriver.By.NAME, "Chances_Txt").build();
        chancesValue = getDriver().findObject(chances);
        return chancesValue;
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
