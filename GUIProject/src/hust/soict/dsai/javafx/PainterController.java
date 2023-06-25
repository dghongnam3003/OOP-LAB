package hust.soict.dsai.javafx;

import javafx.event.*;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {
	
	@FXML
	private ToggleGroup identical;


    @FXML
    private Pane drawingAreaPane;
    
    private Color currentInk;
    private int mouseSize;

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
    	Circle newCircle = new Circle(event.getX(),
    			event.getY(), mouseSize, currentInk);
    	drawingAreaPane.getChildren().add(newCircle);
    }
    
    @FXML
    void penButtonPressed(ActionEvent event) {
    	mouseSize = 4;
    	currentInk = Color.BLACK;
    }

    @FXML
    void eraserButtonPressed(ActionEvent event) {
    	mouseSize = 10;
    	currentInk = Color.WHITE;
    }

    @FXML
    void clearButtonPressed(ActionEvent event) {
    	drawingAreaPane.getChildren().clear();
    }

}