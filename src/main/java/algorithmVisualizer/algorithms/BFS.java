package algorithmVisualizer.algorithms;

import algorithmVisualizer.utils.Graph;
import algorithmVisualizer.utils.Vertex;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * Class representing and implementing the BFS algorithm
 */
public class BFS {
    //TODO Implement Breadth First Search Algorithm
    /*
    * we will need a FIFO queue, and the starting vertex, the end result should be a spanning tree of our original graph
    * how bfs works:
    *   we select a vertex at the start
    *   we but its neighbours in the queue
    *   we mark the vertex as complete, and we pop it from the queue
    *   after this in a cycle
    *       we add the neighbours of our currently active vertex to the queue which are not yet in the queue
    *       we mark the vertex as complete and we move on, we do this until the queue is empty
    *   done :)
    * */
    private Graph bfsSpanningTree;
    private Graph graph;
    private ArrayDeque<Vertex> bfsQueue = new ArrayDeque<>();
    private ArrayDeque<Vertex> finished = new ArrayDeque<>();
    private Vertex active;

    /**
     * Constructor of the BFS algorithm, initializes the necessary collections and variables.
     * @param graph: The graph the BFS runs on.
     * @param start: The vertex where the BFS starts from.
     */
    public BFS(Graph graph, Vertex start)
    {
        active = start;
        bfsSpanningTree = new Graph(1, 0, graph.directed(), graph.weighted());
        bfsSpanningTree.addVertex(active);
        if (graph.findAdjacentVertices(active).isEmpty()) System.err.println("active Vertex has no adjacent vertices");

        ArrayList<Vertex> adjacentOfActive = graph.findAdjacentVertices(active);
        bfsQueue.addAll(adjacentOfActive);    //initialize the queue
        bfsSpanningTree.getVertices().addAll(adjacentOfActive);
        //adding the edges between the start vertex, and its adjacent vertices
        for (Vertex v : bfsQueue)
        {
            bfsSpanningTree.addEdge(graph.findEdge(active, v));
        }
        //we create an empty graph, with the directed and weighted parameters of the original.
        //We'll start adding in vertices and edges as the algorithm progresses.
        this.graph = graph;
    }

    /**
     * Runs a full BFS algorithm
     * @return returns the BFS-spanning-tree
     */
    public Graph runFullBFS()
    {
        while (!bfsQueue.isEmpty()) step();
        return bfsSpanningTree;
    }

    /**
     * Implements a single step of the BFS algorithm, updates the spanning tree (adds vertices and edges),
     * manages the bfsQueue and the finished queue, as well as the active vertex.
     */
    //TODO: Implement a step of an initialized BFS algorithm
    public void step()
    {
        if (bfsQueue.isEmpty()) return;
        //assumptions: bfsQueue already initialized, active already initialized, bfsSpanningTree
        finished.add(active); //add the active to the finished list
        //find unvisited adjacent vertices of the active vertex
        for (Vertex v : graph.findAdjacentVertices(active))
        {
            if (isNotInQueue(v))
            {
                bfsQueue.add(v);
                //create necessary edges in the spanning tree
                bfsSpanningTree.addVertex(v);
                bfsSpanningTree.addEdge(graph.findEdge(active, v));
            }
        }
        active = bfsQueue.pop();
    }
    //utils
    public void setActive(Vertex newActive) {active = newActive;}
    public Graph getBfsSpanningTree() {return bfsSpanningTree;}
    /**
     * Checks whether the vertex given by the parameter is not the bfsQueue
     * @param vertex: The vertex to check whether it's not in or in.
     * @return Whether the vertex is not in the queue.
     */
    public boolean isNotInQueue(Vertex vertex) {return !bfsQueue.contains(vertex) && !finished.contains(vertex);}
}
