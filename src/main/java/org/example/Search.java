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

    // Abstract methods that subclasses must implement.
    abstract void search(Vertex startVertex);

    public boolean hasPathTo(Vertex v) {
        return marked.contains(v);
    }

    public List<Vertex> pathTo(Vertex v) {
        if (!hasPathTo(v)) return null;

        LinkedList<Vertex> ls = new LinkedList<>();
        for (Vertex i = v; i != source; i = edgeTo.get(i)) {
            ls.push(i); // inverted adding
        }
        ls.push(source);

        return ls;
    }
}
