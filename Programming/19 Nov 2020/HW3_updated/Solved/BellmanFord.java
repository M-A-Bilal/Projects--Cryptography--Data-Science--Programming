package Comp251Assignment3;
import java.util.ArrayList;

public class BellmanFord{
    public class BellmanFordException extends Exception{
        private static final long serialVersionUID = -4302041380938489291L;
        public BellmanFordException() {super();}
        public BellmanFordException(String message) {
            super(message);
        }
    }

    /*
     * Custom exception class for BellmanFord algorithm
     * Use this to specify a negative cycle has been found 
     */
    public class NegativeWeightException extends BellmanFordException{
        private static final long serialVersionUID = -7144618211100573822L;
        public NegativeWeightException() {super();}
        public NegativeWeightException(String message) {
            super(message);
        }
    }

    /*
     * Custom exception class for BellmanFord algorithm
     * Use this to specify that a path does not exist
     */
    public class PathDoesNotExistException extends BellmanFordException{
        private static final long serialVersionUID = 547323414762935276L;
        public PathDoesNotExistException() { super();} 
        public PathDoesNotExistException(String message) {
            super(message);
        }
    }

    private int[] distances = null;
    private int[] predecessors = null;
    private int source;

    BellmanFord(WGraph g, int source) throws BellmanFordException{
        /* Constructor, input a graph and a source
         * Computes the Bellman Ford algorithm to populate the
         * attributes 
         *  distances - at position "n" the distance of node "n" to the source is kept
         *  predecessors - at position "n" the predecessor of node "n" on the path
         *                 to the source is kept
         *  source - the source node
         *
         *  If the node is not reachable from the source, the
         *  distance value must be Integer.MAX_VALUE
         *  
         *  When throwing an exception, choose an appropriate one from the ones given above
         */

        // Initialize
        this.source = source;
        distances = new int[g.getNbNodes()];
        predecessors = new int[g.getNbNodes()];
        for(int i = 0; i < g.getNbNodes(); i++) {
            distances[i] = Integer.MAX_VALUE/2;
            predecessors[i] = -1;
        }

        distances[source] = 0;
        predecessors[source] = 0;

        for(int i = 0 ; i < g.getNbNodes()-1; i++) {
            for(Edge e : g.getEdges()) {
                if(distances[e.nodes[0]] != Integer.MAX_VALUE/2) {
                    relax(e.nodes[0], e.nodes[1], e.weight);
                }
            }
        }

        // Detect negative weight cycles
        for(Edge e : g.getEdges()) {
            if(distances[e.nodes[1]] > distances[e.nodes[0]] + e.weight) {
                throw new NegativeWeightException("Negative weight cycle");

            }
        }
    }

    public int[] shortestPath(int destination) throws BellmanFordException{
        /*Returns the list of nodes along the shortest path from 
         * the object source to the input destination
         * If not path exists an Exception is thrown
         * Choose appropriate Exception from the ones given 
         */
        ArrayList<Integer> path = new ArrayList<Integer>();
        path.add(destination);
        int i = destination;
        while(true) {
            if(path.get(path.size()-1) == source) {
                break;
            }else if(predecessors[i] == -1) {
                throw new PathDoesNotExistException("Path Does Not Exist");
            }
            path.add(predecessors[i]);
            i = predecessors[i];
        }

        int [] pathArr = new int[path.size()];
        for(int j = 0 ; j < path.size(); j++) {
            pathArr[j] = path.get(path.size()- 1 -j);
        }
        return pathArr;
    }

    private void relax(int u, int v, int w) {
        if(distances[v] > distances[u] + w) {
            distances[v] = distances[u] + w;
            predecessors[v] = u;
        }
    }

    public void printPath(int destination){
        /*Print the path in the format s->n1->n2->destination
         *if the path exists, else catch the Error and 
         *prints it
         */
        try {
            int[] path = this.shortestPath(destination);
            for (int i = 0; i < path.length; i++){
                int next = path[i];
                if (next == destination){
                    System.out.println(destination);
                }
                else {
                    System.out.print(next + "-->");
                }
            }
        }
        catch (BellmanFordException e){
            System.out.println(e);
        }
    }

    public static void main(String[] args){
        String file = "Your path goes here\\bf1.txt";
        WGraph g = new WGraph(file);
        try{
            BellmanFord bf = new BellmanFord(g, g.getSource());
            bf.printPath(g.getDestination());
        }
        catch (BellmanFordException e){
            System.out.println(e);
        }
    } 
}