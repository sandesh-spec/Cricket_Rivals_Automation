package Mapper;

import Pojo.PlayerCard;
import com.alttester.AltDriver;
import com.alttester.AltObject;
import com.alttester.AltDriver.By;
import com.alttester.Commands.FindObject.AltFindObjectsParams;
import pages.BasePage;
import pages.InventoryPage;

public class PlayerMapper {

    public PlayerCard buildExpectedPlayerCard(String name, String rarity, AltObject Card1_FillBg, AltObject icon) {
        PlayerCard expectedCard = new PlayerCard();
        expectedCard.setNameText(name);
        expectedCard.setRarityTxt(rarity);
        expectedCard.setCard1_FillBg(Card1_FillBg);
        expectedCard.setIcon(icon);
        return expectedCard;
    }

    public PlayerCard buildExpectedBatCard(String name, String rarity, AltObject Card1_FillBg, AltObject icon) {
        PlayerCard expectedCard = new PlayerCard();
        expectedCard.setNameText(name);
        expectedCard.setRarityTxt(rarity);
        expectedCard.setCard1_FillBg(Card1_FillBg);
        expectedCard.setIcon(icon);
        return expectedCard;
    }

        public PlayerCard mapAltObjectToPlayerCard(AltObject cardObject) {
                PlayerCard playerCard = new PlayerCard();
                try {
                    // Use findObjectFromObject to find child objects within the cardObject
                    AltFindObjectsParams nameParams = new AltFindObjectsParams.Builder(AltDriver.By.NAME, "NameTxt").build();
                    AltObject nameTxtObj = cardObject.findObjectFromObject(nameParams);
                    playerCard.setNameText(nameTxtObj.getText());

                    AltFindObjectsParams rarityParams = new AltFindObjectsParams.Builder(AltDriver.By.NAME, "RarityTxt").build();
                    AltObject rarityTxtObj = cardObject.findObjectFromObject(rarityParams);
                    playerCard.setRarityTxt(rarityTxtObj.getText());
//                    // For AltObject fields, store the found objects directly
//                    AltFindObjectsParams card1FillBgParams = new AltFindObjectsParams.Builder(AltDriver.By.NAME, "Card1_FillBg").build();
//                    playerCard.setCard1_FillBg(cardObject.findObjectFromObject(card1FillBgParams));
//
//                    AltFindObjectsParams iconParams = new AltFindObjectsParams.Builder(AltDriver.By.NAME, "Icon").build();
//                    playerCard.setIcon(cardObject.findObjectFromObject(iconParams));
                } catch (Exception e) {
                    System.err.println("Error mapping AltObject to PlayerCard: " + e.getMessage());
                    // Handle errors as needed
                }

                return playerCard;
            }

        }
