package Utilities;

import com.alttester.AltObject;

import java.util.function.Supplier;

public class Utility {

    public static int getStatValue(Supplier<AltObject> getter) {
        String text = getter.get().getText().replaceAll("[^0-9]", "");
        return Integer.parseInt(text);
    }
}
