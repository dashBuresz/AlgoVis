package algorithmVisualizer.utils;

public class Node {
    private final int id;
    private String name;
    Node(int id)
    {
        this.id = id;
        this.name = Integer.toString(id);
    }
    Node(int id, String name)
    {
        this.id = id;
        this.name = name;
    }
}
