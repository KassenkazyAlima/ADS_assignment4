package org.example;

import java.util.*;

public class Vertex<V> {
    private final V data;
    private final Map<Vertex<V>, Double> adjacentVertices; //this is with weights

    public Vertex(V data) {
        this.data = data;
        this.adjacentVertices = new HashMap<>();
    }

    public V getData() {
        return data;
    }

    public void addAdjacentVertex(Vertex<V> destination, double weight) {
        adjacentVertices.put(destination, weight);
    }

//    public Map<Vertex<V>, Double> getAdjacentVertices() {
//        return adjacentVertices;
//    }
}
