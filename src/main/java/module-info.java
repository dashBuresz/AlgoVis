module AlgoVis {
    requires javafx.controls;
    requires javafx.fxml;
    opens algorithmVisualizer to javafx.fxml;
    exports algorithmVisualizer;
}