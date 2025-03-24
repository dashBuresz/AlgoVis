package algorithmVisualizer.utils;

public class Edge {
    private Vertex start, end;
    private int weight = 1;

    /**
     * Creates an edge with the start and end vertices given by the parameters. The weight variable here is set to 1 by default.
     * @param start: The start vertex of the edge.
     * @param end: The end vertex of the edge.
     */
    Edge(Vertex start, Vertex end)
    {
        this.start = start;
        this.end = end;
    }
    /**
     * Creates an edge with the start, end vertices and weight given by the parameters.
     * @param start: The start vertex of the edge.
     * @param end: The end vertex of the edge.
     * @param weight: The weight of the edge.
     */
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
