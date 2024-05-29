package org.example;

import java.util.*;

public abstract class Search<V> {
    protected Set<Vertex<V>> marked;
    protected Map<Vertex<V>, Vertex<V>> edgeTo;
    protected final Vertex<V> source;

    public Search(Vertex<V> source) {
        this.source = source;
        marked = new HashSet<>();
        edgeTo = new HashMap<>();
    }

    public boolean hasPathTo(Vertex<V> v) {
        return marked.contains(v);
    }

    public Iterable<V> pathTo(Vertex<V> v) {
        if (!hasPathTo(v)) return null;

        LinkedList<V> ls = new LinkedList<>();
        for (Vertex<V> i = v; i != source; i = edgeTo.get(i)) {
            ls.push(i.getData());
        }

        ls.push(source.getData());

        return ls;
    }
}
