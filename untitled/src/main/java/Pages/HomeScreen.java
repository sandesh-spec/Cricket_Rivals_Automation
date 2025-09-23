package Pages;

import Utils.AltDriverController;
import com.alttester.AltDriver;
import com.alttester.AltObject;
import com.alttester.Commands.FindObject.AltFindObjectsParams;

import java.sql.Driver;

import static Utils.AltDriverController.getDriver;

public class HomeScreen {

    AltDriver driver = AltDriverController.getDriver();

    AltFindObjectsParams object = new AltFindObjectsParams.Builder(AltDriver.By.NAME, "PlayBtn").build();
    AltObject PlayButton = getDriver().findObject(object);

    AltFindObjectsParams textObject = new AltFindObjectsParams.Builder(AltDriver.By.TEXT, "Play").build();
    AltObject PlayText = getDriver().findObject(textObject);

    public boolean isDisplayed()
    {
        return PlayButton != null && PlayText != null;
    }

    public void tapOnPlayButton()
    {
        PlayButton.tap();
    }
}
