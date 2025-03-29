package algorithmVisualizer.view;

import algorithmVisualizer.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
/**This Class is responsible for controlling the "Main menu".
 */
public class MainViewController {
    @FXML
    private Button enterGraphVisualizer;
    @FXML
    private Button enterSortVisualizer;
    @FXML
    private Button exit;
    @FXML
    private void initialize() {buttonSetup();}

    private void buttonSetup()
    {
        //sets up all the buttons, technically could be set up in fxml,
        //but it just felt better doing it here.
        enterGraphVisualizer.setOnAction(event -> handleGraphVisClick());
        enterSortVisualizer.setOnAction(event -> handleSortVisClick());
        exit.setOnAction(event -> handleExitClick());
    }
    private void handleGraphVisClick()
    {
        System.out.println("Entering Graph-Visualizer...");
        try {
            Main.switchScene("/algorithmVisualizer/view/Graph-view.fxml");
        } catch (IOException exception)
        {
            exception.printStackTrace();
        }
    }
    private void handleSortVisClick()
    {
        System.out.println("Entering Sort-Visualizer...");
        try {
            Main.switchScene("/algorithmVisualizer/view/Sort-view.fxml");
        } catch (IOException exception)
        {
            exception.printStackTrace();
        }
    }
    private void handleExitClick()
    {
        System.out.println("Exiting...");
        System.exit(0);
    }
}
