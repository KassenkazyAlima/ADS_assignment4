package org.example;

import java.util.*;

public class MyGraph<V> extends WeightedGraph<V> {
    private final boolean undirected;
    private Map<V, List<V>> adjList; // Adjusted to use generic type V directly

    public MyGraph(boolean undirected) {
        this.undirected = undirected;
        this.adjList = new HashMap<>();  // Initialize the adjacency list
    }

    @Override
    public void addVertex(V data) {
        if (!adjList.containsKey(data)) {
            adjList.put(data, new ArrayList<>());
        }
    }

    public void addEdge(V source, V dest) {
        if (!adjList.containsKey(source)) {
            addVertex(source);
        }
        if (!adjList.containsKey(dest)) {
            addVertex(dest);
        }

        if (!adjList.get(source).contains(dest) && !source.equals(dest)) {
            adjList.get(source).add(dest);  // Add dest to the adjacency list of source
            if (undirected) {
                adjList.get(dest).add(source);  // For undirected graphs, add source to the adjacency list of dest
            }
        }
    }

    public boolean hasVertex(V data) {
        return adjList.containsKey(data);
    }

    public boolean hasEdge(V source, V dest) {
        return adjList.containsKey(source) && adjList.get(source).contains(dest);
    }

    public List<V> getAdjacencyList(V vertex) {
        return adjList.getOrDefault(vertex, Collections.emptyList());  // Safe retrieval of adjacency list
    }
}




//package org.example;
//
//import java.util.*;
//
//public class MyGraph<V> extends WeightedGraph<V> {
//    private final boolean undirected;
//    private Map<Vertex<V>, List<Vertex<V>>> map = new HashMap<>();
//
//    public MyGraph() {
//        this(true);
//    }
//
//    public MyGraph(boolean undirected) {
//        this.undirected = undirected;
//    }
//
//    public void addVertex(V data) {
//        Vertex<V> v = new Vertex<>(data);
//        if (!super.hasVertex(data)) {
//            super.addVertex(data);
//        }
////        if (hasVertex(v)) return;
////        map.put(v, new LinkedList<>());
//    }
//
//    public void addEdge(V source, V dest) {
//        Vertex<V> sourceVertex = new Vertex<>(source);
//        Vertex<V> destVertex = new Vertex<>(dest);
//
//        if (!hasVertex(sourceVertex)) addVertex(source);
//        if (!hasVertex(destVertex)) addVertex(dest);
//        if (hasEdge(sourceVertex, destVertex) || source.equals(dest)) return;
//
//        sourceVertex.add(destVertex);
//        if (undirected) destVertex.add(sourceVertex);
//    }
//
//    public boolean hasVertex(Vertex<V> v) {
//        return map.containsKey(v);
//    }
//
//    public boolean hasEdge(Vertex<V> source, Vertex<V> dest) {
//        if (!hasVertex(source)) return false;
//        return map.get(source).contains(dest);
//    }
//
//    public List<Vertex<V>> adjacencyList(Vertex<V> v) {
//        if (!hasVertex(v)) return null;
//        return map.get(v);
//    }
//}
