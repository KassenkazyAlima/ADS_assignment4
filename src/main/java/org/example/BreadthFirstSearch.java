package org.example;

import java.util.*;


public class BreadthFirstSearch<Vertex> extends Search<Vertex> {
    private final Map<Vertex, Vertex> edgeTo = new HashMap<>();
    private final Set<Vertex> marked = new HashSet<>();
    private final WeightedGraph<Vertex> graph;

    public BreadthFirstSearch(WeightedGraph<Vertex> graph, Vertex startVertex) {
        super(startVertex); // Pass startVertex to the superclass constructor
        this.graph = graph;
        search(startVertex);
    }

    @Override
    public void search(Vertex startVertex) {
        Queue<Vertex> queue = new LinkedList<>();
        marked.add(startVertex);
        queue.offer(startVertex);

        while (!queue.isEmpty()) {
            Vertex current = queue.poll();
            for (Edge<Vertex> e : graph.getEdges(current)) {
                Vertex neighbor = e.getDest();
                if (!marked.contains(neighbor)) {
                    edgeTo.put(neighbor, current);
                    marked.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
    }

    @Override
    public List<Vertex> pathTo(Vertex endVertex) {
        List<Vertex> path = new ArrayList<>();

        if (!marked.contains(endVertex)) return null;

        for (Vertex x = endVertex; x != null; x = edgeTo.get(x)) {
            path.add(x);
        }
        Collections.reverse(path);
        return path;
    }
}
