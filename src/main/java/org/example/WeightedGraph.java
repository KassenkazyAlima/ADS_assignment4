package org.example;

import java.util.*;

public class WeightedGraph<V> {
    private final boolean undirected;
    private final Map<Vertex<V>, List<Edge<Vertex<V>>>> map = new HashMap<>();

    public WeightedGraph() {
        this(true);
    }

    public WeightedGraph(boolean undirected) {
        this.undirected = undirected;
    }

    public void addVertex(V data) {
        Vertex<V> v = new Vertex<>(data);
        if (hasVertex(v))
            return;

        map.put(v, new LinkedList<>());
    }

    public void addEdge(V source, V dest, double weight) {
        Vertex<V> sourceVertex = new Vertex<>(source);
        Vertex<V> destVertex = new Vertex<>(dest);

        if (!hasVertex(sourceVertex))
            addVertex(source);

        if (!hasVertex(destVertex))
            addVertex(dest);

        if (hasEdge(sourceVertex, destVertex) || source.equals(dest))
            return; // reject parallels & self-loops

        map.get(sourceVertex).add(new Edge<>(sourceVertex, destVertex, weight));

        if (undirected)
            map.get(destVertex).add(new Edge<>(destVertex, sourceVertex, weight));
    }

    public boolean hasVertex(Vertex<V> v) {
        return map.containsKey(v);
    }

    public boolean hasEdge(Vertex<V> source, Vertex<V> dest) {
        if (!hasVertex(source)) return false;

        return map.get(source).contains(new Edge<>(source, dest));
    }

    public List<Vertex<V>> adjacencyList(Vertex<V> v) {
        if (!hasVertex(v)) return null;

        List<Vertex<V>> vertices = new LinkedList<>();
        for (Edge<Vertex<V>> e : map.get(v)) {
            vertices.add(e.getDest());
        }

        return vertices;
    }

    public Iterable<Edge<Vertex<V>>> getEdges(Vertex<V> v) {
        if (!hasVertex(v)) return null;

        return map.get(v);
    }
}
