package hust.soict.dsai.aims.screen.controller;

import java.net.URL;
import java.util.*;

import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.*;

import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;

public class AddBookToStoreScreenController {
	
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
	private TextField tfTitle;
	
	private boolean allFilled = false;
	
	public AddBookToStoreScreenController(Store store) {
		super();
		this.store = store;
	}
	
	@FXML
	void btnSavePressed(ActionEvent event) {
		String title = tfTitle.getText();
		String category = tfCategory.getText();
		float cost = 0.0f;
		
		try {
			cost = Float.parseFloat(tfCost.getText());
		} catch (NumberFormatException e) {
			Alert alert = new Alert(Alert.AlertType.ERROR, "Failed to get cost");
			alert.setTitle("Invalid cost");
			alert.setHeaderText(null);
			alert.showAndWait();
			return;
		}
		
		Book book = new Book(title, category, cost);
		store.addMedia(book);
		tfTitle.clear();
		tfCategory.clear();
		tfCost.clear();
		Alert alert = new Alert(Alert.AlertType.INFORMATION, "Book has been added to store");
		alert.setTitle("Success");
		alert.setHeaderText(null);
		alert.showAndWait();
	}
	
	@FXML
	void initialize() {
		btnSave.setDisable(true);
		
		tfTitle.textProperty().addListener((observable, oldValue, newValue) -> checkFields());
		tfCategory.textProperty().addListener((observable, oldValue, newValue) -> checkFields());
		tfCost.textProperty().addListener((observable, oldValue, newValue) -> checkFields());
	}
	
	private void checkFields() {
		if (!tfTitle.getText().isEmpty() && !tfCategory.getText().isEmpty() && !tfCost.getText().isEmpty()) {
			allFilled = true;
		} else {
			allFilled = false;
		}
		btnSave.setDisable(!allFilled);
	}
}
