package com.performgroup.ott.interview.webapi.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.util.StringUtils;

/**
 * Created by lukasz.gawron on 17/06/16.
 */
public class Node {
    final private String id;
    final private String label;

    @JsonCreator
    public Node(@JsonProperty("id") String id, @JsonProperty("label") String label) {
        if (!StringUtils.hasText(id) || !StringUtils.hasText(label)) {
            throw new GraphException("Lack of required parameters");
        }
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

        if (!id.equals(node.id)) return false;
        return label.equals(node.label);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + label.hashCode();
        return result;
    }
}
