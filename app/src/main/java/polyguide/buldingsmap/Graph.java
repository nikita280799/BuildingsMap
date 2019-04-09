package polyguide.buldingsmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;


public class Graph {

    private List<Vertex> vertexList;
    private HashMap<Vertex, List<Vertex>> connections;

    public Graph() {
        vertexList = new ArrayList<Vertex>();
        connections = new HashMap<>();
    }

    public Graph(List<Vertex> vertexList, HashMap<Vertex, List<Vertex>> connections) {
        this.vertexList = vertexList;
        this.connections = connections;
    }

    public void addVertex(Vertex vertex) {
        vertexList.add(vertex);
    }

    public void addConnectionsInTwoSides(Vertex from, Vertex to) {
        addConnection(from, to);
        addConnection(to, from);
    }

    public void addConnection(Vertex from, Vertex to) {
        List<Vertex> curConnections = connections.get(from);
        if (curConnections == null) {
            curConnections = new ArrayList<>();
        }
        curConnections.add(to);
        connections.put(from, curConnections);
    }

    public List<Vertex> getConnections(Vertex vertex) {
        return connections.get(vertex);
    }

    public Stack<Vertex> bdf(Vertex from, Vertex to) {
        Set<Vertex> visitedVertex = new HashSet<>();
        Stack<Vertex> stack = new Stack();
        Vertex curVertex = from;
        while (true) {
            stack.push(curVertex);
            if (curVertex.equals(to)) {
                break;
            }
            visitedVertex.add(curVertex);
            List<Vertex> candidates = getConnections(curVertex);
            List<Vertex> candidatesCopy = new ArrayList<>(candidates);
            for (Vertex canVertex : candidatesCopy) {
                if (visitedVertex.contains(canVertex)) {
                    candidates.remove(canVertex);
                }
            }
            if (candidates.isEmpty()) {
                stack.pop();
                curVertex = stack.pop();
            } else {
                for (Vertex canVertex : candidates) {
                    curVertex = candidates.get(0);
                    if (canVertex.equals(to)) {
                        curVertex = canVertex;
                    }
                }

            }

        }
        return stack;
    }


}
