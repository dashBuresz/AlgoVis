package algorithmVisualizer.utils;

/**
 * Class representing vertices
 */
public class Vertex {
    private final int id;
    private String name;
    private int pozx, pozy; //for gui purposes

    /**
     * Creates a vertex, with the id given by the parameter, the id will also be the name of this vertex.
     * @param id: The ID of the vertex.
     */
    Vertex(int id)
    {
        this.id = id;
        this.name = Integer.toString(id);
    }
    /**
     * Creates a vertex, with the id and name given by the parameters.
     * @param id: The ID of the vertex.
     * @param name: The name of the vertex.
     */
    Vertex(int id, String name)
    {
        this.id = id;
        this.name = name;
    }
    public String name() {return name;}
    public int id() {return id;}
}
