package org.example;

import java.util.*;

public abstract class Search<Vertex> {
    protected Set<Vertex> marked;
    protected Map<Vertex, Vertex> edgeTo;
    protected final Vertex source;

    public Search(Vertex source) {
        this.source = source;
        marked = new HashSet<>();
        edgeTo = new HashMap<>();
    }

    abstract void search(Vertex startVertex);

    public boolean hasPathTo(Vertex v) {
        return marked.contains(v);
    }

    public List<Vertex> pathTo(Vertex v) {
        if (!hasPathTo(v)) return null;

        LinkedList<Vertex> linkedList = new LinkedList<>();
        for (Vertex i = v; i != source; i = edgeTo.get(i)) {
            linkedList.push(i);
        }
        linkedList.push(source);

        return linkedList;
    }
}
