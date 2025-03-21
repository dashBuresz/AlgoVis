package algorithmVisualizer.utils;

public class Edge {
    private Node start, end;
    private int weight = 1;
    Edge(Node start, Node end)
    {
        this.start = start;
        this.end = end;
    }
    Edge(Node start, Node end, int weight)
    {
        this(start, end);
        this.weight = weight;
    }
//getter setter
    public Node getStart() {
        return start;
    }
    public Node getEnd() {
        return end;
    }
    public int getWeight() {
        return weight;
    }
    public void setStart(Node start) {
        this.start = start;
    }
    public void setEnd(Node end) {
        this.end = end;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
}
