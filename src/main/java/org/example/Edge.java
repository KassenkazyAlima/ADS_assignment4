package org.example;

import java.util.*;

public class Edge<Vertex> {
    private Vertex source;
    private Vertex dest;
    private double weight;

    public Edge(Vertex source, Vertex dest, double weight) {
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }

    public Vertex getSource() {
        return source;
    }
    public Vertex getDest() {
        return dest;
    }
    public double getWeight() {
        return weight;
    }
    public void setSource(Vertex source) {
        this.source = source;
    }

    public void setDest(Vertex dest) {
        this.dest = dest;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Edge<?> otherEdge = (Edge<?>) o;

        return Objects.equals(this.source, otherEdge.source) &&
                Objects.equals(this.dest, otherEdge.dest);
    }
    public int hashCode(){
        return Objects.hash(source,dest);
    }
}