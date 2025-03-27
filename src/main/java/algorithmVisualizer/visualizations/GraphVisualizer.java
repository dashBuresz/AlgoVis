package algorithmVisualizer.visualizations;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GraphVisualizer  extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        primaryStage.setTitle("Graph-Visualizer");
        Pane myPane = (Pane) FXMLLoader.load(getClass().getResource("FXMLGraphVisualizer.fxml"));
        Scene myScene = new Scene(myPane);
        primaryStage.setScene(myScene);
        primaryStage.show();
    }
}
