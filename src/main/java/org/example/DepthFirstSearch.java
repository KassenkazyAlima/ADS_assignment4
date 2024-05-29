package org.example;

import java.util.*;

public class DepthFirstSearch<V> extends Search<V> {
    private Set<V> visited = new HashSet<>();
    private final WeightedGraph<V> graph;

    public DepthFirstSearch(WeightedGraph<V> graph, V startVertex) {
        super(startVertex);
        this.graph = graph;
        dfs(startVertex);
    }

    private void dfs(V vertex) {
        visited.add(vertex);
        for (Edge<V> e : graph.getEdges(vertex)) {
            V neighbor = e.getDest();
            if (!visited.contains(neighbor)) {
                edgeTo.put(neighbor, vertex);
                dfs(neighbor);
            }
        }
    }

    @Override
    public List<V> pathTo(V destination) {
        List<V> path = new ArrayList<>();

        if (!visited.contains(destination)) {
            return null;
        }
        for (V x = destination; x != null; x = edgeTo.get(x)) {
            path.addFirst(x);
        }
        return path;
    }

    @Override
    public void search(V startVertex) {
        if (!visited.contains(startVertex)) {
            dfs(startVertex);
        }
    }
}
