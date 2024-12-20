package hust.soict.dsai.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML
    private VBox drawingAreaPane;

    @FXML
    private Pane drawingPane;

    @FXML
    private RadioButton eraserRadioButton;

    @FXML
    private RadioButton penRadioButton;

    @FXML
    private TitledPane toolsBox;

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        // Determine whether to use Pen or Eraser
        if (penRadioButton.isSelected()) {
            // Add a black circle for drawing
            Circle newCircle = new Circle(event.getX(), event.getY(), 4, Color.BLACK);
            drawingAreaPane.getChildren().add(newCircle);
        } else if (eraserRadioButton.isSelected()) {
            // Add a white circle for erasing (matches background color)
            Circle newCircle = new Circle(event.getX(), event.getY(), 8, Color.WHITE);
            drawingAreaPane.getChildren().add(newCircle);
        }
    }

}
