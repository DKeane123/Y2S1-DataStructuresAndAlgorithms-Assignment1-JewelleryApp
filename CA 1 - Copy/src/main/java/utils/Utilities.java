package utils;

public class Utilities {

    public static String booleanToStandWall(boolean booleanToConvert) {
        return booleanToConvert ? "Free-Standing" : "Wall-Mounted";
    }

    public static String booleanToLitUn(boolean booleanToConvert) {
        return booleanToConvert ? "Lit" : "Unlit";
    }
}
