package algorithmVisualizer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
    //TODO Implement the basic GUI for selecting what kind algorithm we want to visualize
    public static void main(String[] args)
    {
        launch(args);
    }
    @Override
    public void start(Stage stage) {
        Label helloLabel = new Label("Welcome to AlgoVis");
        Button enterGraphVisualizer = new Button("Enter Graph Visualizer");
        enterGraphVisualizer.setPrefWidth(150);
        Button enterSortVisualizer = new Button("Enter Sort Visualizer");
        enterSortVisualizer.setPrefWidth(150);
        Button exit = new Button("Exit");
        exit.setPrefWidth(150);

        VBox vBoxPane = new VBox();
        vBoxPane.getChildren().addAll(helloLabel, enterGraphVisualizer, enterSortVisualizer, exit);
        vBoxPane.setAlignment(Pos.CENTER);
        vBoxPane.setSpacing(10);

        ////
        enterGraphVisualizer.setOnAction(event -> {
            enterGraphVisualizerButton();
        });
        exit.setOnAction(event -> {
            exitButton();
        });
        ////
        Scene scene = new Scene(vBoxPane, 400, 300, Color.DARKGREY);
        Stage primaryStage = new Stage();
        primaryStage.setTitle("AlgoVisFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private void enterGraphVisualizerButton()
    {
        System.out.println("graphvis pressed");
    }
    private void exitButton()
    {
        System.out.println("exit pressed");
    }
}
