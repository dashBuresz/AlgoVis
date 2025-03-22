package algorithmVisualizer.utils;

public class Edge {
    private Vertex start, end;
    private int weight = 1;
    Edge(Vertex start, Vertex end)
    {
        this.start = start;
        this.end = end;
    }
    Edge(Vertex start, Vertex end, int weight)
    {
        this(start, end);
        this.weight = weight;
    }
//getter setter
    public Vertex getStart() {
        return start;
    }
    public Vertex getEnd() {
        return end;
    }
    public int getWeight() {
        return weight;
    }
    public void setStart(Vertex start) {
        this.start = start;
    }
    public void setEnd(Vertex end) {
        this.end = end;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
}
