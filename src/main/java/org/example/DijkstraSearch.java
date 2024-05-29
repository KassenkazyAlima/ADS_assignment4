package org.example;

import java.util.*;

public class DijkstraSearch<Vertex> extends Search<Vertex> {
    private WeightedGraph<Vertex> graph;
    private PriorityQueue<Vertex> pq;
    private Map<Vertex, Double> distTo = new HashMap<>();

    public DijkstraSearch(WeightedGraph<Vertex> graph, Vertex source) {
        super(source);
        this.graph = graph;
        distTo.put(source, 0.0);

        // Initialize distance to all vertices as infinity, except for the source
        for (Vertex v : graph.getVerticesCount()) {
            if (!v.equals(source)) {
                distTo.put(v, Double.POSITIVE_INFINITY);
            }
        }

        pq = new PriorityQueue<>(Comparator.comparingDouble(distTo::get));
        pq.add(source);

        search(source);
    }

    @Override
    public void search(Vertex startVertex) {
        while (!pq.isEmpty()) {
            Vertex v = pq.poll();
            for (Edge<Vertex> e : graph.getEdges(v)) {
                relax(e);
            }
        }
    }

    private void relax(Edge<Vertex> e) {
        Vertex v = e.getSource(), w = e.getDest();
        if (distTo.get(w) > distTo.get(v) + e.getWeight()) {
            distTo.put(w, distTo.get(v) + e.getWeight());
            edgeTo.put(w, v);
            pq.remove(w); // Refresh the priority queue
            pq.add(w);
        }
    }

    @Override
    public List<Vertex> pathTo(Vertex destination) {
        List<Vertex> path = new ArrayList<>();

        if (!distTo.containsKey(destination) || distTo.get(destination) == Double.POSITIVE_INFINITY) {
            return path; // No path available
        }

        for (Vertex x = destination; x != null; x = edgeTo.get(x)) {
            path.add(x);
        }
        return path;
    }
}
