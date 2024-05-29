package org.example;

import java.util.*;

public class WeightedGraph<V> {
    private final boolean undirected;
    private final Map<V, List<Edge<V>>> map = new HashMap<>();

    public WeightedGraph() {
        this(true);
    }

    public WeightedGraph(boolean undirected) {
        this.undirected = undirected;
    }

    public void addVertex(V v) {
        if (hasVertex(v))
            return;

        map.put(v, new LinkedList<>());
    }

    public void addEdge(V source, V dest, double weight) {
        if (!hasVertex(source))
            addVertex(source);

        if (!hasVertex(dest))
            addVertex(dest);

        if (hasEdge(source, dest) || source.equals(dest))
            return;

        map.get(source).add(new Edge<>(source, dest, weight));

        if (undirected)
            map.get(dest).add(new Edge<>(dest, source, weight));
    }

    public Set<V> getVerticesCount() {
        return map.keySet();
    }

    public int getEdgesCount() {
        int count = 0;
        for (V v : map.keySet()) {
            count += map.get(v).size();
        }

        if (undirected)
            count /= 2;

        return count;
    }


    public boolean hasVertex(V v) {
        return map.containsKey(v);
    }

    public boolean hasEdge(V source, V dest) {
        if (!hasVertex(source)) return false;
        List<Edge<V>> edges = map.get(source);
        Edge<V> edge = new Edge<>(source, dest, 0);
        return edges.contains(edge);
    }

    public List<V> adjacencyList(V v) {
        if (!hasVertex(v)) return null;

        List<V> vertices = new LinkedList<>();
        for (Edge<V> e : map.get(v)) {
            vertices.add(e.getDest());
        }

        return vertices;
    }

    public Iterable<Edge<V>> getEdges(V vertex) {
        List<Edge<V>> edges = map.get(vertex);
        if (edges == null) {
            return Collections.emptyList();  // Always return an empty list instead of null
        }
        return edges;
    }

}