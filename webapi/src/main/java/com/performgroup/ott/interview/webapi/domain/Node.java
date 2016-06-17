package com.performgroup.ott.interview.webapi.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by lukasz.gawron on 17/06/16.
 */
public class Node {
    final private String id;
    final private String label;

    @JsonCreator
    public Node(@JsonProperty("id") String id, @JsonProperty("label") String label) {
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
