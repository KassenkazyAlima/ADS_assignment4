
package org.example;

import java.util.Stack;



public class DepthFirstSearch<Vertex> extends Search<Vertex> {
    public DepthFirstSearch(MyGraph<Vertex> graph, Vertex source) {
        super(source);

        dfs(graph, source);
    }

    private void dfs(MyGraph<Vertex> graph, Vertex current) {
        marked.add(current);

        for (Vertex v : graph.adjacencyList(current)) {
            if (!marked.contains(v)) {
                edgeTo.put(v, current);
                dfs(graph, v);
            }
        }
    }
}



//
//public class DepthFirstSearch<V> extends Search<V> {
//    public DepthFirstSearch(MyGraph<V> graph, V source) {
//        super(new Vertex<>(source));
//        dfs(graph, new Vertex<>(source));
//    }
//
//    private void dfs(MyGraph<V> graph, Vertex<V> current) {
//        marked.add(current);
//
//        Stack<Vertex<V>> stack = new Stack<>();
//        stack.push(current);
//
//        while (!stack.isEmpty()) {
//            Vertex<V> v = stack.peek();
//            Vertex<V> next = null;
//            for (Vertex<V> neighbor : graph.adjacencyList(v)) {
//                if (!marked.contains(neighbor)) {
//                    next = neighbor;
//                    break;
//                }
//            }
//
//            if (next != null) {
//                marked.add(next);
//                edgeTo.put(next, v);
//                stack.push(next);
//            } else {
//                stack.pop();
//            }
//        }
//    }
//}
