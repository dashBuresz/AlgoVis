package algorithmVisualizer.utils;

public class Vertex {
    private final int id;
    private String name;
    private int pozx, pozy; //for gui purposes
    Vertex(int id)
    {
        this.id = id;
        this.name = Integer.toString(id);
    }
    Vertex(int id, String name)
    {
        this.id = id;
        this.name = name;
    }
    public String name() {return name;}
    public int id() {return id;}
}
