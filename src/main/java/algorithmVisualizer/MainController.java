package algorithmVisualizer;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class MainController {
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
    /* add to Main.java:
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/hu/example/main-view.fxml"));
        Parent root = loader.load();

        primaryStage.setTitle("AlgoVisFX");
        primaryStage.setScene(new Scene(root, 400, 300));
        primaryStage.show();
     */
}
