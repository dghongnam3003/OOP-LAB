package hust.soict.dsai.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class PainterController {

	@FXML
	private RadioButton penButton;

	@FXML
	private ToggleGroup identical;

	@FXML
	private VBox drawingAreaPane;

	@FXML
	private RadioButton eraserButton;

    private Paint currentInkColor;

    @FXML
    void initialize() {
        // Set the default ink color to black
        currentInkColor = Color.BLACK;
        
        // Add a listener to the toolToggleGroup to handle ink color changes
        identical.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                String selectedTool = ((RadioButton) newValue).getId();
                if (selectedTool.equals("penButton")) {
                    currentInkColor = Color.BLACK;
                } else if (selectedTool.equals("eraserButton")) {
                    currentInkColor = drawingAreaPane.getBackground().getFills().get(0).getFill();
                }
            }
        });
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        Circle newCircle = new Circle(event.getX(), event.getY(), 4);
        newCircle.setFill(currentInkColor);
        drawingAreaPane.getChildren().add(newCircle);
    }

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }
    
    @FXML
    void penButtonPressed(ActionEvent event) {
        currentInkColor = Color.BLACK;
    }
    
    @FXML
    void eraserButtonPressed(ActionEvent event) {
        currentInkColor = drawingAreaPane.getBackground().getFills().get(0).getFill();
    }
}
