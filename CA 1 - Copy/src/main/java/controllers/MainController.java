package controllers;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import models.DisplayCase;
import models.DisplayTray;
import models.JewelleryItem;
import models.MaterialComponent;
import utils.GenericLinkedList;
import utils.Utilities;

import java.io.*;

public class MainController implements Serializable {

    public static GenericLinkedList<DisplayCase> displayCases;
    public static GenericLinkedList<DisplayTray> displayTrays;
    public static GenericLinkedList<JewelleryItem> jewelleryItem;
    public static GenericLinkedList<MaterialComponent> materialComponent;

    private DisplayCase currentCase;
    private DisplayTray currentTray;
    private JewelleryItem currentJewellery;
    private MaterialComponent currentComponent;

    public MainController() {
        displayCases = new GenericLinkedList<>();
        displayTrays = new GenericLinkedList<>();
        jewelleryItem = new GenericLinkedList<>();
        materialComponent = new GenericLinkedList<>();
    }

    //Removes all linked lists saved in the store
    public void reset() {
        displayCases.clearList();
        displayTrays.clearList();
        jewelleryItem.clearList();
        materialComponent.clearList();
    }

    @FXML
    private ListView<String> viewAllStockListView;
    @FXML
    private Button viewAllStockButton;

    //Returns a list of all the current stock in the jewelery store
    public void viewAllStock() {
        viewAllStockListView.getItems().clear();
        for (DisplayCase displayCase : displayCases) {
            viewAllStockListView.getItems().add(displayCase.toString());
            for (DisplayTray displayTray : displayTrays) {
                viewAllStockListView.getItems().add("   " + displayTray.toString());
                for (JewelleryItem jewelleryItem : jewelleryItem) {
                    viewAllStockListView.getItems().add("       " + jewelleryItem.toString());
                    for (MaterialComponent materialComponent : materialComponent) {
                        viewAllStockListView.getItems().add("           " + materialComponent.toString());
                    }
                }
            }
        }
    }
    /**
     * Display Case Methods
     */


    @FXML
    private ListView<String> caseListView;
    @FXML
    private TextField AddCaseID;
    @FXML
    private RadioButton AddCaseType_Standing;
    @FXML
    private RadioButton AddCaseLight_Lit;

    public GenericLinkedList<DisplayCase> getDisplayCases() {
        return displayCases;
    }

    //Method to add a new display case to the linked list
    public void addCase(DisplayCase Case) {
        displayCases.addElement(Case);
    }

    //Makes the list of cases appear
    public void populateCaseView() {
        caseListView.getItems().clear();
        for (int i = displayCases.listLength() - 1; i >= 0; i--) {

            caseListView.getItems().add(String.valueOf(displayCases.get(i).toString()));
        }
    }

    //method to add a new display case
    public void addCaseInfo(ActionEvent event) {
        DisplayCase displayCase;
        displayCase = new DisplayCase(Integer.parseInt(AddCaseID.getText()), AddCaseType_Standing.isSelected(), AddCaseLight_Lit.isSelected());

        caseListView.getItems().add(displayCase.toString());

        String displayType = Utilities.booleanToStandWall(this.AddCaseType_Standing.isSelected());
        String displayLight = Utilities.booleanToLitUn(this.AddCaseLight_Lit.isSelected());

        addCase(displayCase);
        System.out.println("Display Case Number " + AddCaseID.getText() + " is " + displayType + " and is " + displayLight);
    }

    /**
     * Display Tray Methods
     */

    @FXML
    private ListView<String> trayListView;
    @FXML
    private TextField AddTrayID;
    @FXML
    private ChoiceBox<String> AddTrayColour;
    @FXML
    private TextField AddTrayDimensions_Width;
    @FXML
    private TextField AddTrayDimensions_Height;
    @FXML
    private ListView<DisplayCase> AddTrayCase;

    public GenericLinkedList<DisplayTray> getDisplayTrays() {
        return displayTrays;
    }

    //Makes the list of trays and the case select list appear
    public void populateTrayView() {
        trayListView.getItems().clear();
        AddTrayCase.getItems().clear();
        for (DisplayCase displayCase : displayCases) {
            AddTrayCase.getItems().add(displayCase);
            for (DisplayTray displayTray : displayTrays) {
                trayListView.getItems().add(displayTray.toString());
            }
        }
    }

    //Makes the case select list appear
    public void populateCaseSelectListView() {
        AddTrayCase.getItems().clear();
        for (int i = displayCases.listLength() - 1; i >= 0; i--) {
            AddTrayCase.getItems().add(displayCases.get(i));
        }
    }

    //Makes the list of trays refresh
    public void refreshTrayView() {
        trayListView.getItems().clear();
        System.out.println("Success");
        for (DisplayCase displayCase : displayCases) {
            for (DisplayTray displayTray : displayTrays) {
                trayListView.getItems().add(displayTray.toString());
            }
        }
    }

    //Method to add a new display tray to the linked list
    public void addTray(DisplayTray Tray) {
        displayTrays.addElement(Tray);
    }

    //Method to add a new display tray
    public void addTrayInfo(ActionEvent event) {
        currentCase = AddTrayCase.getSelectionModel().getSelectedItem();
        DisplayTray displayTray;
        displayTray = new DisplayTray(AddTrayID.getText(), AddTrayColour.getValue(), Integer.parseInt(AddTrayDimensions_Width.getText()), Integer.parseInt(AddTrayDimensions_Height.getText()));
        currentCase.addDisplayTray(AddTrayID.getText(), AddTrayColour.getValue(), Integer.parseInt(AddTrayDimensions_Width.getText()), Integer.parseInt(AddTrayDimensions_Height.getText()));

        trayListView.getItems().add(displayTray.toString());

        addTray(displayTray);
        System.out.println("Display Tray ID " + AddTrayID.getText() + " is " + AddTrayColour.getValue() + " in colour and is " + AddTrayDimensions_Width.getText() + "cm by " + AddTrayDimensions_Height.getText() + "cm in size");
        AddTrayID.clear();
        AddTrayDimensions_Width.clear();
        AddTrayDimensions_Height.clear();
    }

    /**
     * Jewellery Methods
     */

    @FXML
    private ListView<String> jewelleryListView;
    @FXML
    private Button TotalValueButton;
    @FXML
    private ListView<String> TotalValueListView;
    @FXML
    private ChoiceBox<String> AddJewelleryType;
    @FXML
    private ChoiceBox<String> AddJewelleryGender;
    @FXML
    private TextField AddJewelleryPrice;
    @FXML
    private TextField AddJewelleryImage;
    @FXML
    private TextArea AddJewelleryDesc;
    @FXML
    private ListView<DisplayTray> AddJewelTray;

    public GenericLinkedList<JewelleryItem> getJewelleryItem() {
        return jewelleryItem;
    }

    //Method to add a new jewellery item to the linked list
    public void addJewellery(JewelleryItem Jewellery) {
        jewelleryItem.addElement(Jewellery);
    }

    //Method to delete a jewellery item from the linked list
    public void deleteJewellery() {
        for (int i = 0; i < jewelleryItem.listLength() - 1; i--) {
            if (jewelleryItem.isEmpty()) {
                if (jewelleryListView.getSelectionModel().getSelectedIndex() == i) {

                    jewelleryItem.remove(i);
                    jewelleryListView.getItems().remove(i);

                    populateJewelView();
                }
            }
        }
    }

    //Method that returns to total value of all the jewellery in the store
    public void valueJewellery() {
        TotalValueListView.getItems().clear();
        if (jewelleryItem.isEmpty()){
            int totalValue = 0;
            for (int i = jewelleryItem.listLength() - 1; i >= 0; i--) {
                totalValue = totalValue + jewelleryItem.get(i).JewelleryPrice;
            }
            TotalValueListView.getItems().add("€" + totalValue);
        }
    }

    //Makes the list of jewellery and the tray select list appear
    public void populateJewelView() {
        jewelleryListView.getItems().clear();
        AddJewelTray.getItems().clear();
        for (int i = displayTrays.listLength() - 1; i >= 0; i--) {
            AddJewelTray.getItems().add(displayTrays.get(i));
        } for (int j = jewelleryItem.listLength() - 1; j >= 0; j--) {
            jewelleryListView.getItems().add(String.valueOf(jewelleryItem.get(j).toString()));
        }
    }

    //Method to add a new piece of jewellery
    public void addJewelleryInfo(ActionEvent event) {
        currentTray = AddJewelTray.getSelectionModel().getSelectedItem();
        JewelleryItem jewelleryItem;
        jewelleryItem = new JewelleryItem(AddJewelleryType.getValue(), AddJewelleryGender.getValue(), Integer.parseInt(AddJewelleryPrice.getText()), AddJewelleryImage.getText(), AddJewelleryDesc.getText());
        currentTray.addJewelleryItem(AddJewelleryType.getValue(), AddJewelleryGender.getValue(), Integer.parseInt(AddJewelleryPrice.getText()), AddJewelleryImage.getText(), AddJewelleryDesc.getText());

        jewelleryListView.getItems().add(jewelleryItem.toString());

        addJewellery(jewelleryItem);
        System.out.println(AddJewelleryType.getValue() + " for " + AddJewelleryGender.getValue() + ", €" + AddJewelleryPrice.getText() + " in price. Picture of Jewellery -> " + AddJewelleryImage.getText() + ". Description = " + AddJewelleryDesc.getText());
        AddJewelleryDesc.clear();
        AddJewelleryImage.clear();
        AddJewelleryPrice.clear();
    }

    /**
     * Material/Component Methods
     */

    @FXML
    private ListView<String> materialListView;
    @FXML
    private ChoiceBox<String> AddMaterialType;
    @FXML
    private TextField AddMaterialWeight;
    @FXML
    private TextField AddMaterialQuality;
    @FXML
    private TextArea AddMaterialDesc;
    @FXML
    private ListView<JewelleryItem> AddMatJewel;


    public GenericLinkedList<MaterialComponent> getMaterialComponent() {
        return materialComponent;
    }

    //Method to add a new material to the linked list
    public void addMaterial(MaterialComponent Material) {
        materialComponent.addElement(Material);
    }

    //Makes the jewellery select list appear
    public void populateMatJewelListView() {
        AddMatJewel.getItems().clear();
        for (JewelleryItem jewelleryItem : jewelleryItem) {
            AddMatJewel.getItems().add(jewelleryItem);
        }
    }

    //Method to add a new material
    public void addMaterialInfo(ActionEvent event) {
        currentJewellery = AddMatJewel.getSelectionModel().getSelectedItem();
        MaterialComponent materialComponent;
        materialComponent = new MaterialComponent(AddMaterialType.getValue(), AddMaterialDesc.getText(), Integer.parseInt(AddMaterialWeight.getText()), Integer.parseInt(AddMaterialQuality.getText()));
        currentJewellery.addMaterialComponent(AddMaterialType.getValue(), AddMaterialDesc.getText(), Integer.parseInt(AddMaterialWeight.getText()), Integer.parseInt(AddMaterialQuality.getText()));

        materialListView.getItems().add(materialComponent.toString());

        addMaterial(materialComponent);
        System.out.println(AddMaterialType.getValue() + " -> " + AddMaterialDesc.getText() + " weighing " + Integer.parseInt(AddMaterialWeight.getText()) + " grams and is " + AddMaterialQuality.getText() + "/10 in quality");
        AddMaterialQuality.clear();
        AddMaterialWeight.clear();
        AddMaterialDesc.clear();
    }

    //Add values to choice boxes
    public void initialize() {
        AddTrayColour.getItems().addAll("White", "Black", "Red", "Blue", "Green", "Orange", "Yellow", "Brown");
        AddJewelleryGender.getItems().addAll("Male", "Female", "Unisex");
        AddJewelleryType.getItems().addAll("Earring", "Necklace", "Cuff Link", "Ring", "Bracelet");
        AddMaterialType.getItems().addAll("Glass", "Wood", "Plastic", "Metal", "Precious Stone");
    }

    //Method to save store
    public void JewelleryStoreSave(ActionEvent event) throws Exception {
        try {
            XStream xstream = new XStream(new DomDriver());
            ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("JewelleryStore.xml"));
            out.writeObject(displayCases);
            out.writeObject(displayTrays);
            out.writeObject(jewelleryItem);
            out.writeObject(materialComponent);
            out.close();
            System.out.println("Save Successful");


        } catch (Exception e) {
            System.out.println("Error writing this file : " + e);
        }
    }

    //Method to load store
    public void JewelleryStoreLoad(ActionEvent event) throws Exception {
        try {
            System.out.println(displayCases.printList());
            XStream xstream = new XStream(new DomDriver());
            xstream.addPermission(AnyTypePermission.ANY);
            ObjectInputStream is = xstream.createObjectInputStream(new FileReader("JewelleryStore.xml"));
            displayCases = (GenericLinkedList<DisplayCase>) is.readObject();
            displayTrays = (GenericLinkedList<DisplayTray>) is.readObject();
            jewelleryItem = (GenericLinkedList<JewelleryItem>) is.readObject();
            materialComponent = (GenericLinkedList<MaterialComponent>) is.readObject();
            is.close();
            System.out.println("Load Successful");


        } catch (Exception e) {
            System.out.println("Error in reading this file : " + e);
        }
    }

}

