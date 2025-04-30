package algorithmVisualizer.utils;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * Class representing vertices for both Application logic and GUI
 */
public class Vertex {
    private final int id;
    private Circle circle;
    boolean selected = false;
    /**
     * Creates a vertex, with the id given by the parameter, the id will also be the name of this vertex.
     * @param id: The ID of the vertex.
     */
    Vertex(int id) {this.id = id;}
    public int id() {return id;}
    public boolean selected() {return selected;}
    public void resetSelected() {selected = false;}
    public Circle getCircle() {
        return circle;
    }
    public void setCircle(Circle circle)
    {
        this.circle = circle;
        initCircleEvents();
    }
    private void initCircleEvents()
    {
        circle.setOnMouseClicked(e -> {
            selected = !selected;
            if (selected)
            {
                System.out.println(id + " selected");
                circle.setStroke(Color.GREEN);
                circle.setStrokeWidth(2);
            }
            else
            {
                System.out.println(id + " deselected");
                circle.setStroke(Color.BLUE);
                circle.setStrokeWidth(1);
            }
        });
        circle.setOnMouseEntered(e -> {
            if (!selected) {
                circle.setStroke(Color.WHITE);
                circle.setStrokeWidth(3);
            }
        });
        circle.setOnMouseExited(e -> {
            if (!selected) {
                circle.setStroke(Color.BLUE);
                circle.setStrokeWidth(1);
            }
        });
    }
}
