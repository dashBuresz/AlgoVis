package algorithmVisualizer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    //TODO Implement the basic GUI for selecting what kind algorithm we want to visualize
    public static void main(String[] args)
    {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/algorithmVisualizer/view/main-view.fxml"));
        Parent root = loader.load();

        stage.setTitle("AlgoVisFX");
        stage.setScene(new Scene(root, 400, 300));
        stage.show();
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
