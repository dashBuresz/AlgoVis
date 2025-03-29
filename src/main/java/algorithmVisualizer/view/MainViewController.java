package algorithmVisualizer.view;

import algorithmVisualizer.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
/**This Class is responsible for controlling the "Main menu".
 */
public class MainViewController {
    public Button enterGraphVisualizer;
    public Button enterSortVisualizer;
    public Button exit;

    @FXML
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
    @FXML
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
    @FXML
    private void handleExitClick()
    {
        System.out.println("Exiting...");
        System.exit(0);
    }
    @FXML
    private void handleHover(MouseEvent event)
    {
        Button hoveredButton = (Button) event.getSource();
        hoveredButton.setStyle("-fx-background-color: #9a9a9a; -fx-text-Fill: BLACK");

    }
    @FXML
    private void handleHoverExit(MouseEvent event)
    {
        Button hoveredButton = (Button) event.getSource();
        hoveredButton.setStyle("-fx-background-color: GREY; -fx-text-Fill: WHITE");
    }
}
