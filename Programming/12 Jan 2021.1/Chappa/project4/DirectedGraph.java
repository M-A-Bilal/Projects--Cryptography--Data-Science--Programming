/* File: DirectedGraph.java
 * Date: 09 May 2020
 * Author: Tyler D Clark
 * Description: Defines a Graph which is created by adding Vertices, which are constructed of at least one Edge and an
 * element of which is a generic type. Defines a method for Depth First Search, which is to be used by ParenthesizedList
 * and Hierarchy to print the Graph. */

package wk8.project4;

import java.util.Objects;

public class DirectedGraph<E> {

    private Vertex<E> firstVertex;

    private enum Marks {UNDISCOVERED, DISCOVERED, FINISHED}

    //===============================================================================================
    //  Static nested Vertex class.
    //===============================================================================================

    private static class Vertex<E> {

        private final E element;
        private Edge<E> firstEdge;
        private Vertex<E> nextVertex;
        private Marks mark;


        public Vertex(E label) {
            element = label;
            mark = Marks.UNDISCOVERED;
        }

        public boolean hasNext() {
            return (nextVertex != null);
        }

        public Vertex<E> next() {
            return nextVertex;
        }

    }

    //===============================================================================================
    //  Static nested Edge class.
    //===============================================================================================

    private static class Edge<E> {
        //the vertex that the edge connects to
        private final Vertex<E> vertex;
        private Edge<E> nextEdge;

        public Edge(Vertex<E> v) {
            vertex = v;
        }

        public Edge<E> next() {
            return nextEdge;
        }

        public boolean hasNext() {
            return (nextEdge != null);
        }

        public String toString() {
            return vertex.element.toString();
        }
    }

    //===============================================================================================
    //  createEdge - either finds or creates the Vertices for which it will made an edge between
    //===============================================================================================

    public void createEdge(E from, E to) {
        // if the vertex doesnt exist, it gets made, otherwise returned
        Vertex<E> fromVertex = findAddVertex(from);
        Vertex<E> toVertex = findAddVertex(to);

        AddEdge(fromVertex, toVertex);
    }

    //===============================================================================================
    //  AddEdge - called by createEdge to do some of the work of traversing the linked lists
    //===============================================================================================

    private void AddEdge(Vertex<E> fromVertex, Vertex<E> toVertex) {
        //what if the first edge is null?
        if (fromVertex.firstEdge == null) {
            fromVertex.firstEdge = new Edge<>(toVertex);
        } else {
            Edge<E> currentEdge = fromVertex.firstEdge;
            while (currentEdge.hasNext()) {
                currentEdge = currentEdge.next();
            }
            currentEdge.nextEdge = new Edge<>(toVertex);
        }
    }

    //===============================================================================================
    //  findAddVertex - attempts to find a vertex and return it, otherwise adds it and returns it
    //===============================================================================================

    public Vertex<E> findAddVertex(E value) {
        if (firstVertex == null) {
            return firstVertex = new Vertex<>(value);
        }
        Vertex<E> current = firstVertex;
        while (current.hasNext()) {// == will not compare String content, only reference
            if (Objects.equals(current.element, value)) {
                return current;
            }//using Objects.equals to guard against null
            current = current.next();
        }// If it gets here, needs to create
        return current.nextVertex = new Vertex<>(value);
    }

    //===============================================================================================
    //  performDFS - calls markUndiscovered, then calls dfs on them before displaying undiscovered vertices
    //===============================================================================================

    public void performDFS(DFSActions<E> actions) {
        //first set all vertices to undiscovered
        markUndiscovered(this.firstVertex);
        depthFirstSearch(this.firstVertex, actions); //Call recursive method
    }
    //===============================================================================================
    //  markUndiscovered - marks all the vertices undiscovered then calls dfs on them
    //===============================================================================================

    private void markUndiscovered(Vertex<E> firstVertex) {
        firstVertex.mark = Marks.UNDISCOVERED;
        Vertex<E> currentVertex = firstVertex;
        while (currentVertex != null) {
            if (currentVertex.firstEdge != null) {
                currentVertex.mark = Marks.UNDISCOVERED;
                // do the edges here
                Edge<E> currentEdge = currentVertex.firstEdge;
                currentEdge.vertex.mark = Marks.UNDISCOVERED;
                while (currentEdge.hasNext()) {
                    currentEdge.next().vertex.mark = Marks.UNDISCOVERED;
                    currentEdge = currentEdge.next();
                }
            }
            currentVertex = currentVertex.next();
        }
    }

    //===============================================================================================
    //  depthFirstSearch - recursive dfs that allows specific dfs actions to be called
    //===============================================================================================

    private void depthFirstSearch(Vertex<E> vertex, DFSActions<E> actions) {

        if (vertex.mark == Marks.DISCOVERED) {
            actions.cycleDetected();
            return;
        }
        actions.processVertex(vertex.element);
        vertex.mark = Marks.DISCOVERED;
        actions.descend();
        if (vertex.firstEdge != null) {
            Edge<E> currentEdge = vertex.firstEdge;
            depthFirstSearch(currentEdge.vertex, actions);
            while (currentEdge.hasNext()) {
                //System.out.println(currentEdge.vertex.element + ": " + currentEdge.vertex.mark);
                depthFirstSearch(currentEdge.next().vertex, actions);
                currentEdge = currentEdge.next();
            }
        }
        //System.out.println(vertex.firstEdge);
        actions.ascend();
        vertex.mark = Marks.FINISHED;

    }
    //===============================================================================================
    // undiscovered - prints the Vertices that are undiscovered
    //===============================================================================================

    public void unreachable() {
        Vertex<E> currentVertex = firstVertex;
        while (currentVertex != null) {
            if (currentVertex.firstEdge != null) {
                if (currentVertex.mark == Marks.UNDISCOVERED) {
                    System.out.println(currentVertex.element + " is unreachable");
                    currentVertex.mark = Marks.DISCOVERED;
                }
                Edge<E> currentEdge = currentVertex.firstEdge;
                while (currentEdge.hasNext()) {
                    if ((currentEdge.next().vertex.mark == Marks.UNDISCOVERED)) {
                        System.out.println(currentEdge.next().vertex.element + " is unreachable");
                        currentEdge.next().vertex.mark = Marks.DISCOVERED;
                    }
                    currentEdge = currentEdge.next();
                }
            }
            currentVertex = currentVertex.next();
        }
    }

    //===============================================================================================
    //  toString - prints all of the vertices and the corresponding edges
    //===============================================================================================
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("All read Vertices:\n");
        Vertex<E> currentVertex = firstVertex;
        while (currentVertex != null) {
            if (currentVertex.firstEdge != null) {
                sb.append(currentVertex.element).append(": ");
                // do the edges here
                Edge<E> currentEdge = currentVertex.firstEdge;
                sb.append(currentEdge).append(" ");
                while (currentEdge.hasNext()) {
                    sb.append(currentEdge.next()).append(" ");
                    currentEdge = currentEdge.next();
                }
                sb.append('\n');
            }
            currentVertex = currentVertex.next();
        }

        return sb.toString();
    }
}