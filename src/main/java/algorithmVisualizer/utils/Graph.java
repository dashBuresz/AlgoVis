package algorithmVisualizer.utils;

import java.util.ArrayList;
import java.util.Random;

public class Graph {
    private int n, m;
    private final boolean directed;
    private final boolean weighted;
    private ArrayList<ArrayList<Vertex>> adjacencyList;
    private ArrayList<Vertex> vertices;
    private ArrayList<Edge> edges;

    public Graph(int n, int m, boolean directed, boolean weighted)
    {
        this.n = n;
        this.m = m;
        this.directed = directed;
        this.weighted = weighted;
    }
    public void generateGraph(boolean isTree, boolean negativeWeights)
    {
        Random random = new Random();
        //adding n new vertices to the graph
        for (int i = 0; i < n; i++)
        {
            vertices.add(new Vertex(i + 1));
        }
        int random1, random2;
        Graph builderGraph = new Graph(n, m, directed, weighted);
        builderGraph.vertices = this.vertices;
        //if the graph is a tree
        // since trees have n-1 edges, and no cycles we can create a tree first
        // and then add more edges if the graph is not a tree,
        // oh but wait that's not good. What if we want a non-connected graph? Or do we even care? No we don't.
        if (isTree)
        {
            while (edges.size() <= n - 1) {
                random1 =  random.nextInt(n);
                random2 =  random.nextInt(n);
                if (random1 != random2)
                {

                }
            }
        }
        //if the graph isn't a tree
        if (!isTree)
        {
            while(edges.size() <= m)
            {
                random1 =  random.nextInt(n);
                random2 =  random.nextInt(n);
                if (random1 != random2)
                {

                }
            }
        }


        //if the edges are weighted we assign them values randomly (depending on if there is negative weight or not)

    }
//getter setter
    public int getNumberOfEdges() {return m;}
    public int getNumberOfVertices() {return n;}
    public boolean directed() { return directed;}
    public boolean weighted() { return weighted;}
    public ArrayList<Vertex> getVertices() {return vertices;}
    public ArrayList<Edge> getEdges() {return edges;}
//Utilities
    public void addEdge(Edge newEdge)
    {
        edges.add(newEdge);
        m = m + 1;
    }
    public void addEdge(Vertex start, Vertex end, int weight)
    {
        if (start != null && end != null) edges.add(new Edge(start, end, weight));
        m = m + 1;
    }
    public void addVertex()
    {
        Vertex newVertex = new Vertex(vertices.size());
        vertices.add(newVertex);
        n = n + 1;
    }
    public void removeEdge(Edge edge)
    {
        edges.remove(edge);
        m = m - 1;
    }
    public void removeVertex(Vertex vertex)
    {
        //we also need to remove all the edges that connect to this vertex
        ArrayList<Edge> edgesToRemove = new ArrayList<>();
        for (int i = 0; i < m; i++)
        {
            if (edges.get(i).getStart().equals(vertex) || edges.get(i).getEnd().equals(vertex)) edgesToRemove.add(edges.get(i));
        }
        edges.removeAll(edgesToRemove);
        vertices.remove(vertex);
    }
    public ArrayList<Vertex> findAdjacentVertices(Vertex vertex)
    {
        ArrayList<Vertex> adjacentVertices = new ArrayList<>();
        for (int i = 0; i < adjacencyList.size(); i++)
        {
            if (vertex.id() == adjacencyList.get(i).get(0).id())
            {
                adjacentVertices.addAll(adjacencyList.get(i).subList(1, adjacencyList.get(i).size()));
                break;
            }
        }
        return adjacentVertices;
    }

}
