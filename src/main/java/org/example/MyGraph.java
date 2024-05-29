package org.example;

import java.util.*;

public class MyGraph<V> {
    private final boolean undirected;
    private final Map<Vertex<V>, List<Vertex<V>>> map = new HashMap<>();

    public MyGraph() {
        this(true);
    }

    public MyGraph(boolean undirected) {
        this.undirected = undirected;
    }

    public void addVertex(V data) {
        Vertex<V> v = new Vertex<>(data);
        if (hasVertex(v)) return;
        map.put(v, new LinkedList<>());
    }

    public void addEdge(V source, V dest) {
        Vertex<V> sourceVertex = new Vertex<>(source);
        Vertex<V> destVertex = new Vertex<>(dest);

        if (!hasVertex(sourceVertex)) addVertex(source);
        if (!hasVertex(destVertex)) addVertex(dest);
        if (hasEdge(sourceVertex, destVertex) || source.equals(dest)) return;

        map.get(sourceVertex).add(destVertex);
        if (undirected) map.get(destVertex).add(sourceVertex);
    }

    public boolean hasVertex(Vertex<V> v) {
        return map.containsKey(v);
    }

    public boolean hasEdge(Vertex<V> source, Vertex<V> dest) {
        if (!hasVertex(source)) return false;
        return map.get(source).contains(dest);
    }

    public List<Vertex<V>> adjacencyList(Vertex<V> v) {
        if (!hasVertex(v)) return null;
        return map.get(v);
    }
}
