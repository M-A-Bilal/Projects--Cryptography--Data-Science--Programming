package Comp251Assignment3;
import java.io.*;
import java.util.*;

public class FordFulkerson{
    public static ArrayList<Integer> pathDFS(Integer source, Integer destination, WGraph graph){
        // Stack : Stack of nodes in the DFS path
        // Forbidden: List of nodes visited
	// start: Node to travel from for specific edge
        ArrayList<Integer> Stack = new ArrayList<Integer>();
        ArrayList<Integer> forbidden = new ArrayList<Integer>();
        Stack.add(source);
        int start = source;
        boolean foundEdge = false;
        forbidden.add(source);
        while(true) {
            // Brute force search for first adjacent node 
            for(int i = 0; i <= destination ; i++) {
                if(graph.getEdge(start, i) != null && !forbidden.contains(i) && graph.getEdge(start, i).weight > 0){					
                    Stack.add(i);
                    start = i;
                    forbidden.add(i);
                    foundEdge = true;
                    break;
                }
            }
            // If no edge found; return if stack is 1 else remove top of Stack
            if(!foundEdge){
                if(Stack.size() == 1){
                    return null;
                }else{
                    Stack.remove(Stack.size()-1);
                    start = Stack.get(Stack.size()-1);
                }
            }
            // If not at end: continue, else exit
            if(start != destination){
                foundEdge = false;
                continue;
            }else{
                break;
            }
        }
        return Stack;
    }
    
    public static void fordfulkerson(Integer source, Integer destination, WGraph graph, String filePath){
        String answer="";
        String myMcGillID = "12345678"; //Please initialize this variable with your McGill ID
        int maxFlow = 0;

        // Set edge flows to 0
        WGraph graphF = new WGraph(graph);
        ArrayList<Edge> edgesGraphF = graphF.getEdges();
        for(Edge e:edgesGraphF) {
            e.weight = 0;
        }

        // If no path found
        ArrayList<Integer> nodes = pathDFS(source, destination, graph);
        if(nodes == null) {
            answer += maxFlow + "\n" + graph.toString();	
            writeAnswer(filePath+myMcGillID+".txt",answer);
            System.out.println(answer);
            return;
        }

        // Find bottleneck
        int bottleNeck = Integer.MAX_VALUE;
        for(int i = 0 ; i < nodes.size()-1 ; i++) {
            Edge edge = graphF.getEdge(nodes.get(i), nodes.get(i+1)) ;
            bottleNeck = Math.min(bottleNeck, edge.weight);
        }

        // Initial flow instantiated
        for(int i = 0 ; i < nodes.size()-1 ; i++) {
            Edge edge = graphF.getEdge(nodes.get(i), nodes.get(i+1)) ;
            edge.weight = bottleNeck;
        }

        while(true){
            edgesGraphF = graphF.getEdges();
            ArrayList<Edge> forward = new ArrayList<Edge>();
            ArrayList<Edge> backward = new ArrayList<Edge>();

            // Create residual graph
            WGraph residue = new WGraph();
            for(Edge e : edgesGraphF) {
                // Forward edge : add if doesn't exist, else change weight
                if(e.weight < graph.getEdge(e.nodes[0], e.nodes[1]).weight) {
                    Edge forwardEdge = new Edge(e.nodes[0], e.nodes[1],(graph.getEdge(e.nodes[0], e.nodes[1]).weight - e.weight));
                    if(residue.getEdge(forwardEdge.nodes[0], forwardEdge.nodes[1])==null) {
                        residue.addEdge(forwardEdge);
                        forward.add(forwardEdge);
                    }else {
                        residue.getEdge(forwardEdge.nodes[0], forwardEdge.nodes[1]).weight = graph.getEdge(e.nodes[0], e.nodes[1]).weight - e.weight;
                    }
                }

                // Backward edge : add if doesn't exist, else change weight
                if(e.weight > 0) {
                    Edge backwardEdge = new Edge(e.nodes[1], e.nodes[0],(e.weight));
                    if(residue.getEdge(backwardEdge.nodes[0], backwardEdge.nodes[1])==null) {
                        residue.addEdge(backwardEdge);
                        backward.add(backwardEdge);
                    } else {
                        residue.getEdge(backwardEdge.nodes[0], backwardEdge.nodes[1]).weight = e.weight; 
                    }
                }
            }

            // Check if path from s to t exists in residual graph
            ArrayList<Integer> nodesResidual = pathDFS(source, destination, residue);

            // If no path found, set graph and break
            if(nodesResidual == null) {
                // Find maxFlow : flow out of source
                maxFlow = 0;
                for(int i = 0; i < graphF.getNbNodes(); i++) {
                    if(graphF.getEdge(source, i)!= null) {
                        maxFlow+=graphF.getEdge(source, i).weight;
                    }
                }
                graph=graphF;
                break;
            }

            // Find bottleneck
            bottleNeck = Integer.MAX_VALUE;
            for(int i = 0 ; i < nodesResidual.size()-1 ; i++) {
                Edge edge = residue.getEdge(nodesResidual.get(i), nodesResidual.get(i+1)) ;
                bottleNeck = Math.min(bottleNeck, edge.weight);
            }

            // Augment the Path
            for(int i = 0 ; i < nodesResidual.size()-1 ; i++) {
                Edge edge = residue.getEdge(nodesResidual.get(i), nodesResidual.get(i+1)) ;
                edge.weight = bottleNeck;
            }

            // Add to G
            for(int i = 0 ; i < nodesResidual.size()-1 ; i++) {
                Edge e = residue.getEdge(nodesResidual.get(i), nodesResidual.get(i+1)) ;

                // Forward Edge
                if(forward.contains(e)) {    
                    graphF.getEdge(e.nodes[0], e.nodes[1]).weight += e.weight ;

                        // Backward edge
                } else if(backward.contains(e)) {  
                    graphF.getEdge(e.nodes[1], e.nodes[0]).weight -= e.weight ;
                }
            }

        }
        answer += maxFlow + "\n" + graph.toString();	
        writeAnswer(filePath+myMcGillID+".txt",answer);
        System.out.println(answer);
    }


    public static void writeAnswer(String path, String line){
        BufferedReader br = null;
        File file = new File(path);
        // if file doesn't exists, then create it

        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(line+"\n");	
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        String file = "Your path goes here\\ff2.txt";
        File f = new File(file);
        WGraph g = new WGraph(file);
        System.out.println(pathDFS(0, 5, g).toString());
        fordfulkerson(g.getSource(),g.getDestination(),g,f.getAbsolutePath().replace(".txt",""));
    }
}