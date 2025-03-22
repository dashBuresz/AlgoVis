package algorithmVisualizer.utils;

import java.beans.PropertyEditorManager;
import java.util.ArrayList;

public class Graph {
    private int n, m;
    private final boolean directed;
    private final boolean weighted;
    private ArrayList<ArrayList<Vertex>> adjasencyList;
    private ArrayList<Vertex> verteces;
    private ArrayList<Edge> edges;

    Graph(int n, int m, boolean directed, boolean weighted)
    {
        this.n = n;
        this.m = m;
        this.directed = directed;
        this.weighted = weighted;
    }
    public void generateGraph(boolean directed, boolean weighted, boolean isTree)
    {
        //adding n new verteces to the graph
        for (int i = 0; i < n; i++)
        {
            verteces.add(new Vertex(i + 1));
        }
    }
//getter setter
    public int getNumberOfEdges() {return m;}
    public int getNumberOfNodes() {return n;}
    public boolean directed() { return directed;}
    public boolean weighted() { return weighted;}
    public ArrayList<Vertex> getVerteces() {return verteces;}
    public ArrayList<Edge> getEdges() {return edges;}
    public void addEdge(Edge newEdge)
    {
        edges.add(newEdge);
    }
    public void addEdge(Vertex start, Vertex end, int weight)
    {
        if (start != null && end != null) edges.add(new Edge(start, end, weight));
    }
    public void addVertex(Vertex newVertex)
    {
        verteces.add(newVertex);
    }
    public void removeEdge(Edge edge)
    {
        edges.remove(edge);
    }
    public void removeVertex(Vertex vertex)
    {
        //we also need to remove all the edges that connect to this vertex

    }
}
