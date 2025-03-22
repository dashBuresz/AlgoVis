package algorithmVisualizer.algorithms;

public class BFS {
    //TODO Implement Breadth First Search Algorithm
    /*
    * we will need a FIFO queue, and the starting vertex, the end result should be a spanning tree of our original graph
    * how bfs works:
    *   we select a vertex at the start
    *   we but its neightbours in the queue
    *   we mark the vertex as complete, and we pop it from the queue
    *   after this in a cycle
    *       we add the neighbours of our currently active vertex to the queue wich are not yet in the queue
    *       we mark the veretx as complete and we move on, we do this until the queue is empty
    *   done :)
    * */

}
