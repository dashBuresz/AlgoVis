package algorithmVisualizer.view;

import algorithmVisualizer.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

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
        enterGraphVisualizer.setOnAction(e -> {
            System.out.println("Entering Graph-Visualizer...");
            //TODO: start Graph-visualizer COMPLETE
            try {
                Main.switchScene("/algorithmVisualizer/view/Graph-view.fxml");
            } catch (IOException exception)
            {
                exception.printStackTrace();
            }
        });
        enterSortVisualizer.setOnAction(e -> {
            System.out.println("Entering Sort-Visualizer...");
            //TODO: start Sort-visualizer COMPLETE
            try {
                Main.switchScene("/algorithmVisualizer/view/Sort-view.fxml");
            } catch (IOException exception)
            {
                exception.printStackTrace();
            }
        });
        exit.setOnAction(e -> {
            System.out.println("Exiting...");
            System.exit(0);
        });
    }

}
