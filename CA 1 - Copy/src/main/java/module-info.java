module com.example.ca1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires xstream;

    opens com.example.ca1 to javafx.fxml, xstream;
    opens controllers to javafx.fxml, xstream;
    opens models to javafx.fxml, xstream;
    opens utils to javafx.fxml, xstream;

    exports utils;
    exports models;
    exports com.example.ca1;
    exports controllers;
}