package models;

import utils.GenericLinkedList;

public class DisplayTray {

    public String TrayNum;
    public String TrayColour;
    public int TrayWidth;
    public int TrayHeight;
    public GenericLinkedList<JewelleryItem> jewelleryItems;

    public DisplayTray(String trayNum, String trayColour, int trayWidth, int trayHeight) {
        this.TrayNum = trayNum;
        this.TrayColour = trayColour;
        this.TrayWidth = trayWidth;
        this.TrayHeight = trayHeight;
        this.jewelleryItems = new GenericLinkedList<>();
    }

    public void addJewelleryItem(String jewelleryType, String jewelleryGender, int jewelleryPrice, String jewelleryImage, String jewelleryDesc) {
        jewelleryItems.addElement(new JewelleryItem(jewelleryType, jewelleryGender, jewelleryPrice, jewelleryImage, jewelleryDesc));
    }

    public String getTrayNum() {
        return TrayNum;
    }

    public String getTrayColour() {
        return TrayColour;
    }

    public int getTrayWidth() {
        return TrayWidth;
    }

    public int getTrayHeight() {
        return TrayHeight;
    }

    public GenericLinkedList<JewelleryItem> getJewelleryItems() {
        return jewelleryItems;
    }

    public void setTrayNum(String trayNum) {
        TrayNum = trayNum;
    }

    public void setTrayColour(String trayColour) {
        TrayColour = trayColour;
    }

    public void setTrayWidth(int trayWidth) {
        TrayWidth = trayWidth;
    }

    public void setTrayHeight(int trayHeight) {
        TrayHeight = trayHeight;
    }

    public void setJewelleryItems(GenericLinkedList<JewelleryItem> jewelleryItems) {
        this.jewelleryItems = jewelleryItems;
    }

    @Override
    public String toString() {
        return "Display Tray ID " + TrayNum + " is " + TrayColour + " in colour and is " + TrayWidth + "cm by " + TrayHeight + "cm in size";
    }
}
