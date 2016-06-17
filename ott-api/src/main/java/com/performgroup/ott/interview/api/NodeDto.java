package com.performgroup.ott.interview.api;

import java.util.List;

/**
 * Created by lukasz on 17/06/16.
 */
public class NodeDto {
    private String id;
    private String label;
    private List<String> adjacentNodes;

    public NodeDto(String id, String label, List<String> adjacentNodes) {
        this.id = id;
        this.label = label;
        this.adjacentNodes = adjacentNodes;
    }

    public NodeDto() {
    }

    public java.lang.String getId() {
        return id;
    }

    public void setId(java.lang.String id) {
        this.id = id;
    }

    public java.lang.String getLabel() {
        return label;
    }

    public void setLabel(java.lang.String label) {
        this.label = label;
    }

    public List<java.lang.String> getAdjacentNodes() {
        return adjacentNodes;
    }

    public void setAdjacentNodes(List<java.lang.String> adjacentNodes) {
        this.adjacentNodes = adjacentNodes;
    }
}
