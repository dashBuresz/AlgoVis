package algorithmVisualizer.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

public class MainViewController {
    @FXML
    private Button enterGraphVisualizer;
    @FXML
    private Button enterSortVisualizer;
    @FXML
    private Button exit;
    @FXML
    private void initialize()
    {
        enterGraphVisualizer.setOnAction(e -> System.out.println("Entering Graph-Visualizer..."));
        enterSortVisualizer.setOnAction(e -> System.out.println("Entering Sort-Visualizer..."));
        exit.setOnAction(e -> System.out.println("Exiting..."));
    }

}
