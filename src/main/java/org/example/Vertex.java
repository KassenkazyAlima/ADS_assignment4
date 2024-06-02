package org.example;

import java.util.*;

public class Vertex<T> {
    private T data;
    private Map<Vertex<T>, Double> adjacentVertices; //this is with weights

    public Vertex(T data) {
        this.data = data;
        this.adjacentVertices = new HashMap<>();
    }

    //getters&setters
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }

    public void addAdjacentVertex(Vertex<T> destination, double weight) {
        adjacentVertices.put(destination, weight);
    }
    public Map<Vertex<T>, Double> getAdjacentVertices() {
        return adjacentVertices;
    }
    public void setAdjacentVertices(Map<Vertex<T>, Double> adjacentVertices) {
        this.adjacentVertices = adjacentVertices;
    }
    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Vertex<?> vertex = (Vertex<?>) obj;
        return Objects.equals(data, vertex.data);
    }

    //uses the hash code of the field -  data
    @Override
    public int hashCode() {
        return Objects.hash(data);
    }
}
