package hust.soict.dsai.aims.screen.controller;

import java.net.URL;
import java.util.*;

import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.*;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AddDVDToStoreScreenController {

    private Store store;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnSave;

    @FXML
    private TextField tfCategory;

    @FXML
    private TextField tfCost;

    @FXML
    private TextField tfDirector;

    @FXML
    private TextField tfLength;

    @FXML
    private TextField tfTitle;

    private boolean allFilled = false;


    public AddDVDToStoreScreenController(Store store) {
        super();
        this.store = store;
    }

    @FXML
    void btnSavePressed(ActionEvent event) {
        String title = tfTitle.getText();
        String category = tfCategory.getText();
        String director = tfDirector.getText();
        int length = 0;
        try {
            length = Integer.parseInt(tfLength.getText());
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Failed to get length!");
            alert.setTitle("Invalid Length");
            alert.setHeaderText(null);
            alert.showAndWait();
            return;
        }
        float cost = 0.0f;
        try {
            cost = Float.parseFloat(tfCost.getText());
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Failed to get cost");
            alert.setTitle("Invalid Cost");
            alert.setHeaderText(null);
            alert.showAndWait();
            return;
        }
        DigitalVideoDisc DVD = new DigitalVideoDisc(title, category, director, length,cost);
        store.addMedia(DVD);
        tfTitle.clear();
        tfCategory.clear();
        tfDirector.clear();
        tfLength.clear();
        tfCost.clear();
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "DVD has been added");
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.showAndWait();
    }

    @FXML
    void initialize() {
        btnSave.setDisable(true);
        
        tfTitle.textProperty().addListener((observable, oldValue, newValue) -> checkFields());
        tfCategory.textProperty().addListener((observable, oldValue, newValue) -> checkFields());
        tfDirector.textProperty().addListener((observable, oldValue, newValue) -> checkFields());
        tfLength.textProperty().addListener((observable, oldValue, newValue) -> checkFields());
        tfCost.textProperty().addListener((observable, oldValue, newValue) -> checkFields());
    }   

    private void checkFields() {
        if (!tfTitle.getText().isEmpty() && !tfCategory.getText().isEmpty() && !tfDirector.getText().isEmpty() && !tfLength.getText().isEmpty() && !tfCost.getText().isEmpty()) {
            allFilled = true;
        } else {
            allFilled = false;
        }
        btnSave.setDisable(!allFilled);
    }
    

}
