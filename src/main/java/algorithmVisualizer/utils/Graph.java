package algorithmVisualizer.utils;

import algorithmVisualizer.algorithms.BFS;

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

    /**
     * This method generates a graph based on the given parameters, updating all the necessary data within the class
     * @param isTree: boolean value, describing whether we want to generate a tree or not
     * @param negativeWeights: boolean value determining if we allow negative weights, if the graph is not weighted the value of all weights is 1
     */
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
        //TODO: not complete yet
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
        if(isTree) {
            BFS treeGenerator = new BFS(this, vertices.get(0));
            treeGenerator.runFullBFS();
            while (treeGenerator.getBfsSpanningTree().getNumberOfVertices() < n)
            {
                ArrayList<Vertex> notInTree = new ArrayList<>();
                for (Vertex v : vertices)
                    if (!treeGenerator.getBfsSpanningTree().hasVertex(v)) notInTree.add(v);

                if (!notInTree.isEmpty())
                {
                    random1 = random.nextInt(notInTree.size());
                    random2 = random.nextInt(treeGenerator.getBfsSpanningTree().getNumberOfVertices());
                    Vertex outOfTreeVertex = notInTree.get(random1);
                    Vertex inTreeVertex = treeGenerator.getBfsSpanningTree().getVertices().get(random2);
                    addEdge(new Edge(inTreeVertex, outOfTreeVertex));
                    //TODO: updating the adjacency-list
                }
                treeGenerator.runFullBFS();
            }
        }
        //if the edges are weighted we assign them values randomly (depending on if there is negative weight or not)
        if (weighted)
        {
            //TODO: Implement logic for weighting edges.
        }else
        {
            for (Edge e : edges)
                e.setWeight(1);
        }
    }
//Getter-Setter
    public int getNumberOfEdges() {return m;}
    public int getNumberOfVertices() {return n;}
    public boolean directed() { return directed;}
    public boolean weighted() { return weighted;}
    public ArrayList<Vertex> getVertices() {return vertices;}
    public ArrayList<Edge> getEdges() {return edges;}
//Utilities
    /**The method adds the edge object given by the parameters, updates the edges, and adjacency list collections as well.
     * @param newEdge: an Edge object we want to add to our graph.
     **/
    public void addEdge(Edge newEdge)
    {
        //we only add the edge, if the edge is not in the graph already, to avoid parallel edges
        if (!edges.contains(newEdge)) {
            edges.add(newEdge);
            m = m + 1;
            //updating the adjacency-list
            //TODO: Implement the update of adjacencyList depending on whether the graph is directed or not
            // (if directed we add to both to the start and end vertex adjacencyList).
            for (ArrayList<Vertex> adjList : adjacencyList)
                if (adjList.get(0).equals(newEdge.getStart())) adjList.add(newEdge.getEnd());
        }
    }
    /**
     * The method adds a new edge based on the parameters, updates the edges, and adjacency list collections as well.
     * @param start: Vertex object necessary for the Edge constructor, representing the starting vertex of the new edge.
     * @param end: Vertex object necessary for the Edge constructor, representing the end vertex of the new edge.
     * @param weight: int variable representing the weight of the new edge.
     **/
    public void addEdge(Vertex start, Vertex end, int weight)
    {
        Edge newEdge = new Edge(start, end, weight);
        if (start != null && end != null && !isLoopEdge(newEdge) && !isParallelEdge(newEdge))
        {
            edges.add(newEdge);
            m = m + 1;
        }
        //updating the adjacency-list
        //TODO: Implement the update of adjacencyList depending on whether the graph is directed or not
        // (if directed we add to both to the start and end vertex adjacencyList).
        for (ArrayList<Vertex> adjList : adjacencyList)
            if (adjList.get(0).equals(start)) adjList.add(end);
    }

    /**
     * Adds a new vertex, without any parameters
     */
    public void addVertex()
    {
        Vertex newVertex = new Vertex(vertices.size());
        //updating the adjacency-list
        vertices.add(newVertex);
        ArrayList<Vertex> adjList = new ArrayList<>();
        adjList.add(newVertex);
        adjacencyList.add(adjList);
        n = n + 1;
    }

    /**
     * Adds a new vertex given as a parameter, we update the vertices collection. If the vertex is already in the graph we do nothing.
     * @param vertex: the specific vertex we want to add.
     */
    public void addVertex(Vertex vertex)
    {
        if (!vertices.contains(vertex))
        {
            vertices.add(vertex);
            //updating the adjacency-list
            ArrayList<Vertex> adjList = new ArrayList<>();
            adjList.add(vertex);
            adjacencyList.add(adjList);
            n += 1;
        }
    }

    /**
     * Removes an edge from the graph given by the parameters, we update both the edges and adjacencyList collections.
     * @param edge: The edge we want to remove.
     */
    public void removeEdge(Edge edge)
    {
        if (!edges.contains(edge)) return;
        edges.remove(edge);
        m = m - 1;
        //updating the adjacency-list
        //TODO: implement logic to make this dependent on the directed property of the graph
        ArrayList<Vertex> adjListToModify = findAdjacentVertices(edge.getStart());
        adjListToModify.remove(edge.getEnd());
    }

    /**
     * Removes the vertex given as the parameter from the graph, and all the edges connecting to it. Updates the edges, adjacencyList and vertices collections.
     * @param vertex: The vertex to remove from the graph.
     */
    public void removeVertex(Vertex vertex)
    {
        if (!vertices.contains(vertex)) return;
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

    /**
     * Finds the adjacent vertices to the vertex given as the parameter.
     * @param vertex: The vertex, we want the adjacent vertices to.
     * @return returns the adjacent vertices to the parameter vertex.
     */
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

    /**
     * Checks whether the edge given by the parameter is parallel to any edges within the graph.
     * @param edge: the edge we check if it's parallel to any edges in the graph.
     * @return if the edge is parallel or not.
     */
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

    /**
     * Generates the vertices of the graph
     */
    private void generateVertices()
    {
        //adding n new vertices to the graph
        for (int i = 0; i < n; i++)
        {
            Vertex newVertex = new Vertex(i + 1);
            vertices.add(newVertex);
            ArrayList<Vertex> adjListOfNewVertex= new ArrayList<>();
            //add vertex to its own adjacency-sub-list
            adjListOfNewVertex.add(newVertex);
            //add the adjacency-sub-list to the adjacency-list (or with other word the list of adjacency-lists)
            adjacencyList.add(adjListOfNewVertex);
        }
    }

    /**
     * Checks whether the edge given by the parameter is a looped edge.
     * @param edge: the edge to be checked whether it is looped or not.
     * @return if the edge is a looped edge or not.
     */
    public static boolean isLoopEdge(Edge edge) {return edge.getStart().equals(edge.getEnd());}

    /**
     * Finds an edge in the graph based on its start and end vertex.
     * @param start: The starting vertex of the edge.
     * @param end: The end vertex of the edge.
     * @return the edge that was searched for, if not found returns null.
     */
    public Edge findEdge(Vertex start, Vertex end)
    {
        //TODO:Implement different cases for directed and non-directed graphs
        for (Edge e : edges)
            if (e.getStart().equals(start) && e.getEnd().equals(end)) return e;
        return null;
    }
    public boolean hasVertex(Vertex vertex) {return vertices.contains(vertex);}
}
