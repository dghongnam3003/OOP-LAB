package hust.soict.dsai.aims.screen.controller;

import java.net.URL;
import java.util.*;

import hust.soict.dsai.aims.media.*;

import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;

public class AddTrackController {
	private CompactDisc cd;
	
	@FXML
	private URL location;
	
	@FXML
	private Button btnSaveTrack;
	
	@FXML
	private TextField tfLength;
	
	@FXML
	private TextField tfTitle;
	
	private boolean allFilled = false;
	
	public AddTrackController(CompactDisc cd) {
		super();
		this.cd = cd;
	}
	
	@FXML
	
	void btnSaveTrackPressed(ActionEvent event) {
		String title = tfTitle.getText();
		int length = 0;
		
		try {
			length = Integer.parseInt(tfLength.getText());
		} catch (NumberFormatException e) {
			Alert alert = new Alert(Alert.AlertType.ERROR, "Failed to get Length");
			alert.setTitle("Invalid Length");
			alert.setHeaderText(null);
			alert.showAndWait();
			return;
		}
		
		Track track = new Track(title, length);
		cd.addTrack(track);
		tfTitle.clear();
		tfLength.clear();
		Alert alert = new Alert(Alert.AlertType.INFORMATION, "Track has been added");
		alert.setTitle("Success");
		alert.setHeaderText(null);
		alert.showAndWait();
	}
	
	@FXML
	void initialize() {
		btnSaveTrack.setDisable(true);
		
		tfTitle.textProperty().addListener((observable, oldValue, newValue) -> checkFields());
		tfLength.textProperty().addListener((observable, oldValue, newValue) -> checkFields());
	}
	
	private void checkFields() {
		if (!tfTitle.getText().isEmpty() && !tfLength.getText().isEmpty()) {
			allFilled = true;
		} else allFilled = false;
		
		btnSaveTrack.setDisable(!allFilled);
	}
}
