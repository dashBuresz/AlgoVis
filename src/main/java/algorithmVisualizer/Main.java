package algorithmVisualizer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    //TODO Implement the basic GUI for selecting what kind algorithm we want to visualize
    private static Stage stage;
    public static void main(String[] args)
    {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/algorithmVisualizer/view/main-view.fxml"));
        Parent root = loader.load();
        stage.setTitle("AlgoVisFX");
        stage.setScene(new Scene(root));
        stage.show();
    }
    public static void switchScene(String fxmlFile) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlFile));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
    }
}
