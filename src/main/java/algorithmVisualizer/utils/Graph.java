package algorithmVisualizer.utils;

import java.util.ArrayList;
import java.util.Iterator;
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
        //we first create a simple graph (without parallel and loop edges), and then if we want a tree we run a bfs and make a tree out of it
        Random random = new Random();
        //adding n new vertices to the graph
        generateVertices();
        int random1, random2;
        Graph builderGraph = new Graph(n, m, directed, weighted);
        builderGraph.vertices = this.vertices;

        //if the graph isn't a tree
        if (!isTree) {
            while (edges.size() <= m) {
                random1 = random.nextInt(n);
                random2 = random.nextInt(n);
                Edge newEdge = new Edge(vertices.get(random1), vertices.get(random2));
                if (random1 != random2 && !isParallelEdge(newEdge) && !isLoopEdge(newEdge)) {
                    edges.add(newEdge);
                }
            }
        }
        //if the graph is a tree
        // since trees have n-1 edges, and no cycles we can create a tree first
        // and then add more edges if the graph is not a tree,
        // oh but wait that's not good. What if we want a non-connected graph? Or do we even care? No we don't.
        //TODO: implementation of tree generation (we'll probably need BFS for this)
        ///////////////////////////
        //BRAINSTORM
        //let's just run a BFS on the first generated graph, and if the spanning-tree returned by the runFullBFS method
        //doesn't contain all the vertices of the original graph, we know it's a non-connected-graph,
        //we can connect the vertices that are not in the spanning tree to the spanning tree randomly, and we can run a BFS again
        //so we always get a tree, until the vertices of the BFS spanning tree and the vertices of the original graph are the same.
        ///////////////////////////

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
        for (ArrayList<Vertex> adjList : adjacencyList)
            if (adjList.get(0).equals(newEdge.getStart())) adjList.add(newEdge.getEnd());
    }
    public void addEdge(Vertex start, Vertex end, int weight)
    {
        Edge newEdge = new Edge(start, end, weight);
        if (start != null && end != null && !isLoopEdge(newEdge) && !isParallelEdge(newEdge))
        {
            edges.add(newEdge);
            m = m + 1;
        }
        for (ArrayList<Vertex> adjList : adjacencyList)
            if (adjList.get(0).equals(start)) adjList.add(end);
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
        //update the list of edges
        edges.removeAll(edgesToRemove);
        //update the list of vertices
        vertices.remove(vertex);
        //now we remove the vertex from all the adjacency sub-lists, and we remove the adjacencyList of this vertex
        Iterator<ArrayList<Vertex>> iterator = adjacencyList.iterator();
        while (iterator.hasNext())
        {
            ArrayList<Vertex> subList = iterator.next();
            if (subList.get(0).equals(vertex)) iterator.remove();
            else subList.removeIf(v -> v.equals(vertex));
        }
    }
    public ArrayList<Vertex> findAdjacentVertices(Vertex vertex)
    {
        ArrayList<Vertex> adjacentVertices = new ArrayList<>();
        for (ArrayList<Vertex> vertexArrayList : adjacencyList) {
            if (vertex.id() == vertexArrayList.get(0).id()) {
                adjacentVertices.addAll(vertexArrayList.subList(1, vertexArrayList.size()));
                break;
            }
        }
        return adjacentVertices;
    }
    public boolean isParallelEdge(Edge edge)
    {
        for(Edge e : edges)
        {
            boolean sameStartSameEnd = edge.getStart().equals(e.getStart()) && edge.getEnd().equals(e.getEnd());
            boolean sameEndSameStart = edge.getStart().equals(e.getEnd()) && edge.getEnd().equals(e.getStart());
            if (!directed && (sameStartSameEnd || sameEndSameStart)) return true;
            if (directed && sameStartSameEnd) return true;
        }
        return false;
    }
    private void generateVertices()
    {
        //adding n new vertices to the graph
        for (int i = 0; i < n; i++)
        {
            Vertex newVertex = new Vertex(i + 1);
            vertices.add(newVertex);
            ArrayList<Vertex> adjListOfNewVertex= new ArrayList<>();
            //add vertex to it's own adjacency-sub-list
            adjListOfNewVertex.add(newVertex);
            //add the adjacency-sub-list to the adjacency-list (or with other word the list of adjacency-lists)
            adjacencyList.add(adjListOfNewVertex);
        }
    }
    public static boolean isLoopEdge(Edge edge) {return edge.getStart().equals(edge.getEnd());}
    public Edge findEdge(Vertex start, Vertex end)
    {
        for (Edge e : edges)
            if (e.getStart().equals(start) && e.getEnd().equals(end)) return e;
        return null;
    }
}
