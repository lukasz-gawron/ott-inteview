package com.performgroup.ott.interview.webapi.domain;

/**
 * Created by lukasz on 17/06/16.
 */
public class Node {
    private String id;
    private String label;

    public Node(String id, String label) {
        this.id = id;
        this.label = label;
    }

    public String getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        return id.equals(node.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
