package Pojo;

import com.alttester.AltObject;

public class PlayerCard {
    private String nameText;
    private String rarityTxt;
    private AltObject Card1_FillBg;
    private AltObject icon;

    public String getNameText() {
        return nameText;
    }

    public void setNameText(String nameText) {
        this.nameText = nameText;
    }

    public String getRarityTxt() {
        return rarityTxt;
    }

    public void setRarityTxt(String rarityTxt) {
        this.rarityTxt = rarityTxt;
    }

    public AltObject getCard1_FillBg() {
        return Card1_FillBg;
    }

    public void setCard1_FillBg(AltObject card1_FillBg) {
        Card1_FillBg = card1_FillBg;
    }

    public AltObject getIcon() {
        return icon;
    }

    public void setIcon(AltObject icon) {
        this.icon = icon;
    }
}
