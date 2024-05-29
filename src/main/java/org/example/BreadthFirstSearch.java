package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch<V> extends Search<V> {
    public BreadthFirstSearch(MyGraph<V> graph, V source) {
        super(new Vertex<>(source));
        bfs(graph, new Vertex<>(source));
    }

    private void bfs(MyGraph<V> graph, Vertex<V> current) {
        marked.add(current);
        Queue<Vertex<V>> queue = new LinkedList<>();
        queue.add(current);

        while (!queue.isEmpty()) {
            Vertex<V> v = queue.remove();
            for (Vertex<V> neighbor : graph.adjacencyList(v)) {
                if (!marked.contains(neighbor)) {
                    marked.add(neighbor);
                    edgeTo.put(neighbor, v);
                    queue.add(neighbor);
                }
            }
        }
    }
}
