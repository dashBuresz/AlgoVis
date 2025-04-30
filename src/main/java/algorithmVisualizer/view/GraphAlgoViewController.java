package algorithmVisualizer.view;

import algorithmVisualizer.algorithms.*;
import algorithmVisualizer.utils.Graph;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.Pane;

import java.util.HashMap;
import java.util.Map;

/**This Class is responsible for controlling the "editor" where we interact with our graphs
 */
public class GraphAlgoViewController{
    public Pane graphPane;
    private Graph graph;
    private int n;
    private int m;
    private boolean directed = false;
    private boolean weighted = false;
    private boolean negativeWeights = false;
    private  boolean tree= false;
    //Buttons
    @FXML private CheckBox directedButton;
    @FXML private CheckBox weightedButton;
    @FXML private CheckBox negativeWeightButton;
    @FXML private CheckBox treeButton;
    @FXML private TextField vertexNumber;
    @FXML private TextField edgeNumber;
    @FXML private ComboBox<String> algorithmSelector;
    private final Map<String, Algorithm> algorithmOptions = new HashMap<>();

    @FXML
    public void initialize()
    {
        //checking user input here, we won't let non-number inputs through
        vertexNumber.setTextFormatter(new TextFormatter<>(change ->
                (change.getControlNewText().matches("\\d+")) ? change : null
        ));
        edgeNumber.setTextFormatter(new TextFormatter<>(change ->
                (change.getControlNewText().matches("\\d+")) ? change : null
        ));
        //initializing the algorithm selector combo-box
        algorithmSelector.getItems().addAll(
                "BFS",
                "DFS",
                "Dijkstra",
                "Kruskal"
        );
        graph = new Graph();
        algorithmOptions.put("BFS", new BFS());
        algorithmOptions.put("DFS", new DFS());
        algorithmOptions.put("Dijkstra", new Dijkstra());
        algorithmOptions.put("Kruskal", new Kruskal());
    }
    @FXML
    private void handleGenerateGraph()
    {
        n = Integer.parseInt(vertexNumber.getText());
        if (n == 1 || n == 0 || n == Integer.MIN_VALUE || m == Integer.MIN_VALUE) return;
        m = Integer.parseInt(edgeNumber.getText());
        if (m > (n*(n-1))/2) m = (n*(n-1))/2;   //because we don't allow parallel or loop edges
        graph = new Graph(n, m, directed, weighted);
        graph.generateGraph(tree, negativeWeights);
        GraphRenderer graphRenderer = new GraphRenderer(graph.getEdges(), graph.getVertices(), graphPane, graph.weighted(), graph.directed());
        graphRenderer.render();
    }
    @FXML
    private void handleCheckBox(ActionEvent event)
    {
        CheckBox source = (CheckBox) event.getSource();
        if (source == directedButton) directed = directedButton.isSelected();
        else if (source == weightedButton) weighted = weightedButton.isSelected();
        else if (source == negativeWeightButton) negativeWeights = negativeWeightButton.isSelected();
        else if (source == treeButton) tree = treeButton.isSelected();
    }
    //TODO: Implement GUI functions for adding and removing edges and vertices
    //we need to make the edges and vertices clickable, so we can select them.


    //TODO: Implement GUI functions for stepping and running full algorithms
    @FXML
    private void handleAlgorithmRunner()
    {
        Algorithm algo = algorithmOptions.get(algorithmSelector.getValue());
    }
    @FXML
    private void handleAlgorithmStep()
    {
        Algorithm algo = algorithmOptions.get(algorithmSelector.getValue());
        algo.step();
    }
}
