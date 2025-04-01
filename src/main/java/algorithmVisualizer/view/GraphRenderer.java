package algorithmVisualizer.view;

import algorithmVisualizer.Main;
import algorithmVisualizer.utils.Edge;
import algorithmVisualizer.utils.Vertex;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

import java.util.ArrayList;

/**
 * This class implements the graphical interpretation of a graph
 */
public class GraphRenderer {
    private ArrayList<Edge> edges;
    private ArrayList<Vertex> vertices;
    private Pane pane;
    GraphRenderer(ArrayList<Edge> edges, ArrayList<Vertex> vertices, Pane pane)
    {
        this.edges = edges;
        this.vertices = vertices;
        this.pane = pane;
    }
    public void render()
    {
        pane.getChildren().removeAll(pane.getChildren());
        renderVertices();
        renderEdges();
    }
    //The vertices will be laid out the following way:
    //We divide a circle by the number of vertices, and we place the vertices on that circle all the same distance from each other (on the radius).
    private void renderVertices()
    {
        double centerX = pane.getWidth()/2, centerY = pane.getHeight()/2, radius = pane.getHeight()/3;
        //need to calculate with radians because Math.sin() and Math.cos() need radians as inputs
        for (int i = 0; i < vertices.size(); i++)
        {
            //2*PI*i/n because 2PI = 360 degrees, and we want to divide these 360 degrees equally n times
            //we multiply it by i because that's how we get the correct angle for the i. vertex.
            double angle = 2* Math.PI * i/ vertices.size();
            //vector scalar multiplication, we are transforming the directional vector with the radius.
            //And then we shift it by the center point.
            double x = centerX + radius * Math.cos(angle);
            double y = centerY + radius * Math.sin(angle);
            Circle circle = new Circle(x, y, 20, Color.BLUE);
            circle.setAccessibleText(String.valueOf(vertices.get(i).id() + 1));
            Text vertexLabel = new Text(x-4, y+5,String.valueOf(i + 1));
            vertexLabel.setFill(Color.WHITE);
            vertexLabel.toFront();

            vertices.get(i).setCircle(circle);
            pane.getChildren().addAll(circle, vertexLabel);
        }
    }
    //Then we render the edges
    private void renderEdges()
    {
        for (Edge edge : edges)
        {
            double startX = edge.getStart().getCircle().getCenterX(),
                    startY = edge.getStart().getCircle().getCenterY(),
                    endX = edge.getEnd().getCircle().getCenterX(),
                    endY = edge.getEnd().getCircle().getCenterY();
            Line line = new Line(startX, startY, endX, endY);
            line.setStrokeWidth(5);
            line.setStroke(Color.BLUE);
            edge.setLine(line);
            pane.getChildren().add(line);
            line.toBack();
        }
    }

}
