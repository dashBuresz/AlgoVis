package algorithmVisualizer.view;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class MainViewController {
    @FXML
    private Button enterGraphVisualizer;

    @FXML
    private Button enterSortVisualizer;

    @FXML
    private void initialize()
    {
        enterGraphVisualizer.setOnAction(e -> System.out.println("Graph Visualizer opened"));
        enterSortVisualizer.setOnAction(e -> System.out.println("Sort Visualizer opened"));

    }
}
