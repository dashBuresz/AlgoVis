package algorithmVisualizer.utils;

import javafx.scene.shape.Circle;

/**
 * Class representing vertices for both Application logic and GUI
 */
public class Vertex {
    private final int id;
    private Circle circle;
    /**
     * Creates a vertex, with the id given by the parameter, the id will also be the name of this vertex.
     * @param id: The ID of the vertex.
     */
    Vertex(int id) {this.id = id;}
    public int id() {return id;}
    public Circle getCircle() {
        return circle;
    }
    public void setCircle(Circle circle) {this.circle = circle;}

}
