package hust.soict.dsai.aims.screen.controller;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.*;

public class CartScreenController {
	private Cart cart;
	
	@FXML
    private Button btnPlay;
	
	@FXML
	private Button btnPlaceOrder;

    @FXML
    private Button btnRemove;
    
    @FXML
    private ToggleGroup filterCategory;
	
	@FXML
	private TableView<Media> tblMedia;
	
	@FXML
	private TableColumn<Media, String> colMediaTitle;
	
	@FXML
	private TableColumn<Media, String> colMediacategory;
	
	@FXML
	private TableColumn<Media, Float> colMediaCost;
	
	@FXML
	private RadioButton radioBtnFilterId;

	@FXML
	private RadioButton radioBtnFilterTitle;
	 
	@FXML
	private TextField tfFilter;
	
	@FXML
    private Label costLabel;
	
	public CartScreenController(Cart cart) {
		super();
		this.cart = cart;
	}
	
	@FXML
	private void initialize() {
		
		colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
		colMediacategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
		colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
		tblMedia.setItems(this.cart.getItemsOrdered());
		costLabel.setText(cart.totalCost() + " $");
		
		btnPlay.setVisible(false);
		btnRemove.setVisible(false);
		
		tblMedia.getSelectionModel().selectedItemProperty().addListener(
				new ChangeListener<Media>() {
					
					@Override
					public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
						if (newValue!=null) {
							updateButtonBar(newValue);
						}
					}
				});
	}

	private void updateButtonBar(Media media) {
		btnRemove.setVisible(true);
		if (media instanceof Playable) {
			btnPlay.setVisible(true);
		}
		else {
			btnPlay.setVisible(false);
		}
	}
	
	@FXML
    void btnRemovePressed(ActionEvent event) {
		Media media = tblMedia.getSelectionModel().getSelectedItem();
		cart.removeMedia(media);
		costLabel.setText(cart.totalCost() + " $");
    }
	
	@FXML
	void btnPlaceOrderPressed(ActionEvent event) {
		cart.placeOrder();
		costLabel.setText(cart.totalCost() + " $");
	}
	
	@FXML
	void btnPlayPressed(ActionEvent event) throws PlayerException {
		Media media = tblMedia.getSelectionModel().getSelectedItem();
		Playable playMedia = (Playable) media;
		playMedia.play();
		Alert alert;
		
		alert = new Alert(Alert.AlertType.NONE, playMedia.playGUI());
		alert.setTitle("Playing");
		alert.setHeaderText(null);
		alert.getDialogPane().getButtonTypes().add(ButtonType.OK);
		alert.showAndWait();
	}
}
