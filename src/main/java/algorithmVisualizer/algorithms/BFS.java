package algorithmVisualizer.algorithms;

import algorithmVisualizer.utils.Graph;
import algorithmVisualizer.utils.Vertex;

import java.util.ArrayDeque;
import java.util.ArrayList;

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
    private ArrayDeque<Vertex> bfsQueue;
    private ArrayList<Vertex> finished;
    private Vertex active;
    public BFS(Graph graph, Vertex start)
    {
        active = start;
        if (graph.findAdjacentVertices(active).isEmpty())
        {
            System.err.println("active Vertex has no adjacent vertices");
        }
        bfsQueue.addAll(graph.findAdjacentVertices(active));
        bfsSpanningTree = new Graph(graph.getNumberOfVertices(), graph.getNumberOfVertices()-1, graph.directed(), graph.weighted());
        this.graph = graph;
    }
    public Graph runFullBFS()
    {
        while (!bfsQueue.isEmpty())
        {
            stepBFS();
        }
        //if (bfsSpanningTree.getVertices().equals(graph.getVertices())) return bfsSpanningTree;
        //else return null;
        return bfsSpanningTree;
    }
    //TODO: Implement a step of an initialized BFS algorithm
    public void stepBFS()
    {

    }
    //utils
    public void setActive(Vertex newActive) {active = newActive;}
}
