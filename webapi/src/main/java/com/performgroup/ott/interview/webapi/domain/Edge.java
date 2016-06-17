package com.performgroup.ott.interview.webapi.domain;

import org.springframework.util.StringUtils;

import java.util.Objects;

/**
 * Created by lukasz on 17/06/16.
 */
public class Edge {
    /**
     * Source node identifier
     */
    private final String srcNodeId;
    /**
     * Destination node identifier
     */
    private final String dstNodeId;


    public Edge(String srcNodeId, String dstNodeId) {
        this.srcNodeId = srcNodeId;
        this.dstNodeId = dstNodeId;
    }

    public String getSrcNodeId() {
        return srcNodeId;
    }

    public String getDstNodeId() {
        return dstNodeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Edge edge = (Edge) o;

        if (!srcNodeId.equals(edge.srcNodeId)) return false;
        return dstNodeId.equals(edge.dstNodeId);

    }

    @Override
    public int hashCode() {
        int result = srcNodeId.hashCode();
        result = 31 * result + dstNodeId.hashCode();
        return result;
    }
}
