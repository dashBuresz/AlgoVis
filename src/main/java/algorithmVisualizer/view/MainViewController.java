package algorithmVisualizer.view;

import algorithmVisualizer.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
}
