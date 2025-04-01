package algorithmVisualizer.view;

import algorithmVisualizer.utils.Graph;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.Pane;

/**This Class is responsible for controlling the "editor" where we interact with our graphs
 */
public class GraphAlgoViewController{
    public Pane graphPane;
    private int n;
    private int m;
    private boolean directed = false;
    private boolean weighted = false;
    private boolean negativeWeights = false;
    private  boolean tree= false;
    @FXML private CheckBox directedButton;
    @FXML private CheckBox weightedButton;
    @FXML private CheckBox negativeWeightButton;
    @FXML private CheckBox treeButton;
    @FXML private TextField vertexNumber;
    @FXML private TextField edgeNumber;

    @FXML
    public void initialize()
    {
        vertexNumber.setTextFormatter(new TextFormatter<>(change ->
                (change.getControlNewText().matches("\\d+")) ? change : null
        ));
        edgeNumber.setTextFormatter(new TextFormatter<>(change ->
                (change.getControlNewText().matches("\\d+")) ? change : null
        ));
    }
    @FXML
    private void handleGenerateGraph()
    {
        n = Integer.parseInt(vertexNumber.getText());
        if (n == 1 || n == 0 || n == Integer.MIN_VALUE || m == Integer.MIN_VALUE) return;
        m = Integer.parseInt(edgeNumber.getText());
        if (m > (n*(n-1))/2) m = (n*(n-1))/2;   //because we don't allow parallel or loop edges
        Graph graph = new Graph(n, m, directed, weighted);
        graph.generateGraph(tree, negativeWeights);
        GraphRenderer graphRenderer = new GraphRenderer(graph.getEdges(), graph.getVertices(), graphPane);
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
}
