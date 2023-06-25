package hust.soict.dsai.aims.screen.controller;

import java.net.URL;
import java.util.*;

import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.*;
import hust.soict.dsai.aims.screen.*;

import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.event.*;

public class AddCDToStoreScreenController {
	
	private Store store;
	
	private CompactDisc cd;
	
	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button btnAddTrack;

	@FXML
	private Button btnSave;

	@FXML
	private Button btnAddCD;

	@FXML
	private TextField tfCategory;

	@FXML
	private TextField tfCost;

	@FXML
	private TextField tfArtist;

	@FXML
	private TextField tfTitle;
	
	private boolean allFilled = false;
	
	public AddCDToStoreScreenController(Store store) {
		this.store = store;
	}
	
	@FXML
	void btnAddCDPressed(ActionEvent event) {
	        store.addMedia(cd);
	        tfTitle.clear();
	        tfCategory.clear();
	        tfArtist.clear();
	        tfCost.clear();
	        btnSave.setDisable(true);
	        btnAddCD.setDisable(true);
	        btnAddTrack.setDisable(true);
	        Alert alert = new Alert(Alert.AlertType.INFORMATION, "CD has been added to the store!");
	        alert.setTitle("Success");
	        alert.setHeaderText(null);
	        alert.showAndWait();
	}
	@FXML
	void btnAddTrackPressed(ActionEvent event) {
	        new AddTrack(cd);
	}

	@FXML
	void btnSavePressed(ActionEvent event) {
	        String title = tfTitle.getText();
	        String category = tfCategory.getText();
	        String artist = tfArtist.getText();
	        float cost = 0.0f;
	        try {
	            cost = Float.parseFloat(tfCost.getText());
	        } catch (NumberFormatException e) {
	            Alert alert = new Alert(Alert.AlertType.ERROR, "Failed to parse cost!");
	            alert.setTitle("Wrong type");
	            alert.setHeaderText(null);
	            alert.showAndWait();
	            return;
	        }
	        cd = new CompactDisc(title, category, artist, cost);
	        btnAddCD.setDisable(false);
	        btnAddTrack.setDisable(false);
	        btnSave.setDisable(true);
	}

	@FXML
	void initialize() {
	        btnSave.setDisable(true);
	        btnAddCD.setDisable(true);
	        btnAddTrack.setDisable(true);
	        
	        tfTitle.textProperty().addListener((observable, oldValue, newValue) -> checkFields());
	        tfCategory.textProperty().addListener((observable, oldValue, newValue) -> checkFields());
	        tfArtist.textProperty().addListener((observable, oldValue, newValue) -> checkFields());
	        tfCost.textProperty().addListener((observable, oldValue, newValue) -> checkFields());
	}   

	private void checkFields() {
	        if (!tfTitle.getText().isEmpty() && !tfCategory.getText().isEmpty() && !tfArtist.getText().isEmpty() &&  !tfCost.getText().isEmpty()) {
	            allFilled = true;
	        } else {
	            allFilled = false;
	        }
	        btnSave.setDisable(!allFilled);
	}
}
