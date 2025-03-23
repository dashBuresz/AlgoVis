package algorithmVisualizer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
    //TODO Implement the basic GUI for selecting what kind algorithm we want to visualize
    public static void main(String[] args)
    {
        launch(args);
    }
    @Override
    public void start(Stage stage)
    {
        Label helloLabel = new Label("Hello World, I'm a JavaFX application!");
        StackPane root = new StackPane(helloLabel);
        Scene scene = new Scene(root, 400, 300);
        Stage primaryStage = new Stage();
        primaryStage.setTitle("AlgoVisFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
