package algorithmVisualizer.algorithms;

import algorithmVisualizer.utils.Graph;

/**
 * Interface for our algorithms to interact with the GUI
 */
public abstract class Algorithm {
    protected Graph graph;
    public abstract Graph run();
    public abstract void step();
}
