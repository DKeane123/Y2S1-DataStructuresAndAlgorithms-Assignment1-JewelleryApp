package models;

public class MaterialComponent {

    public MaterialComponent nextMaterialComponent;
    public String MaterialType;
    public String MaterialDesc;
    public int MaterialWeight;
    public int MaterialQuality;

    public MaterialComponent(String materialType, String materialDesc, int materialWeight, int materialQuality) {
        MaterialType = materialType;
        MaterialDesc = materialDesc;
        MaterialWeight = materialWeight;
        MaterialQuality = materialQuality;
    }

    public String getMaterialType() {
        return MaterialType;
    }

    public MaterialComponent getNextMaterialComponent() {
        return nextMaterialComponent;
    }

    public String getMaterialDesc() {
        return MaterialDesc;
    }

    public int getMaterialWeight() {
        return MaterialWeight;
    }

    public int getMaterialQuality() {
        return MaterialQuality;
    }

    public void setNextMaterialComponent(MaterialComponent nextMaterialComponent) {
        this.nextMaterialComponent = nextMaterialComponent;
    }

    public void setMaterialType(String materialType) {
        MaterialType = materialType;
    }

    public void setMaterialDesc(String materialDesc) {
        MaterialDesc = materialDesc;
    }

    public void setMaterialWeight(int materialWeight) {
        MaterialWeight = materialWeight;
    }

    public void setMaterialQuality(int materialQuality) {
        MaterialQuality = materialQuality;
    }

    @Override
    public String toString() {
        return MaterialType + " -> " + MaterialDesc + " weighing " + MaterialWeight + " grams and is " + MaterialQuality + "/10 in quality";
    }
}
