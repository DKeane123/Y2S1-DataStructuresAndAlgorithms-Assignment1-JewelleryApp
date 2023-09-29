package models;

import utils.GenericLinkedList;
import utils.Utilities;


public class DisplayCase {

    public int displayNum;
    public boolean displayType;
    public boolean displayLight;
    public GenericLinkedList<DisplayTray> displayTrays;


    public DisplayCase(int displayNum, boolean displayType, boolean displayLight) {
        this.displayType = displayType;
        this.displayNum = displayNum;
        this.displayLight = displayLight;
        this.displayTrays = new GenericLinkedList<>();
    }

    public void addDisplayTray(String trayNum, String trayColour, int trayWidth, int trayHeight) {
        displayTrays.addElement(new DisplayTray(trayNum, trayColour, trayWidth, trayHeight));
    }

    public int getDisplayNum() {
        return displayNum;
    }

    public boolean isDisplayType() {
        return displayType;
    }

    public boolean isDisplayLight() {
        return displayLight;
    }

    public GenericLinkedList<DisplayTray> getDisplayTrays() {
        return displayTrays;
    }

    public void setDisplayNum(int displayNum) {
        this.displayNum = displayNum;
    }

    public void setDisplayType(boolean displayType) {
        this.displayType = displayType;
    }

    public void setDisplayLight(boolean displayLight) {
        this.displayLight = displayLight;
    }

    public void setDisplayTrays(GenericLinkedList<DisplayTray> displayTrays) {
        this.displayTrays = displayTrays;
    }

    @Override
    public String toString() {
        String displayType = Utilities.booleanToStandWall(this.displayType);
        String displayLight = Utilities.booleanToLitUn(this.displayLight);
        return "Display Case Number " + displayNum + " is " + displayType + " and is " + displayLight;
    }

}
