package com.performgroup.ott.interview.webapi.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.util.StringUtils;

/**
 * Created by lukasz.gawron on 17/06/16.
 */
public class Edge {
    /**
     * Source node identifier
     */
    final private String srcNodeId;
    /**
     * Destination node identifier
     */
    final private String dstNodeId;


    @JsonCreator
    public Edge(@JsonProperty("srcNodeId") String srcNodeId, @JsonProperty("dstNodeIs") String dstNodeId) {
        if (!StringUtils.hasText(srcNodeId) || !StringUtils.hasText(dstNodeId)) {
            throw new GraphException("Lack of node id");
        }
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

        return srcNodeId.equals(edge.srcNodeId) && dstNodeId.equals(edge.dstNodeId);

    }

    @Override
    public int hashCode() {
        int result = srcNodeId.hashCode();
        result = 31 * result + dstNodeId.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "srcNodeId='" + srcNodeId + '\'' +
                ", dstNodeId='" + dstNodeId + '\'' +
                '}';
    }
}
