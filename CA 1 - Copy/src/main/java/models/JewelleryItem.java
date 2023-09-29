package models;

import utils.GenericLinkedList;

public class JewelleryItem {

    public String JewelleryDesc;
    public String JewelleryType;
    public String JewelleryGender;
    public String JewelleryImage;
    public int JewelleryPrice;
    public GenericLinkedList<MaterialComponent> materialComponents;

    public JewelleryItem(String jewelleryType, String jewelleryGender, int jewelleryPrice, String jewelleryImage, String jewelleryDesc) {
        this.JewelleryType = jewelleryType;
        this.JewelleryGender = jewelleryGender;
        this.JewelleryPrice = jewelleryPrice;
        this.JewelleryImage = jewelleryImage;
        this.JewelleryDesc = jewelleryDesc;
        this.materialComponents = new GenericLinkedList<>();
    }

    public void addMaterialComponent(String materialType, String materialDesc, int materialWeight, int materialQuality) {
        materialComponents.addElement(new MaterialComponent(materialType, materialDesc, materialWeight, materialQuality));
    }

    public String getJewelleryType() {
        return JewelleryType;
    }

    public String getJewelleryGender() {
        return JewelleryGender;
    }

    public String getJewelleryDesc() {
        return JewelleryDesc;
    }

    public String getJewelleryImage() {
        return JewelleryImage;
    }

    public int getJewelleryPrice() {
        return JewelleryPrice;
    }

    public GenericLinkedList<MaterialComponent> getMaterialComponents() {
        return materialComponents;
    }

    public void setJewelleryType(String jewelleryType) {
        JewelleryType = jewelleryType;
    }

    public void setJewelleryGender(String jewelleryGender) {
        JewelleryGender = jewelleryGender;
    }

    public void setJewelleryDesc(String jewelleryDesc) {
        JewelleryDesc = jewelleryDesc;
    }

    public void setJewelleryImage(String jewelleryImage) {
        JewelleryImage = jewelleryImage;
    }

    public void setJewelleryPrice(int jewelleryPrice) {
        JewelleryPrice = jewelleryPrice;
    }

    public void setMaterialComponents(GenericLinkedList<MaterialComponent> materialComponents) {
        this.materialComponents = materialComponents;
    }

    @Override
    public String toString() {
        return JewelleryType + " for " + JewelleryGender + ", €" + JewelleryPrice + " in price. Picture of Jewellery -> " + JewelleryImage + ". Description = " + JewelleryDesc;
    }
}
