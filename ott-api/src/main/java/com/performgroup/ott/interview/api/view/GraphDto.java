package com.performgroup.ott.interview.api.view;

import java.util.Set;

import static java.util.Collections.unmodifiableSet;

/**
 * Created by lukasz.gawron on 17/06/16.
 */
public class GraphDto {
    private String id;
    private Set<NodeDto> nodes;
    private Set<EdgeDto> edges;

    public GraphDto() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Set<NodeDto> getNodes() {
        return nodes;
    }

    public void setNodes(Set<NodeDto> nodes) {
        this.nodes = nodes;
    }

    public Set<EdgeDto> getEdges() {
        return edges;
    }

    public void setEdges(Set<EdgeDto> edges) {
        this.edges = edges;
    }
}
