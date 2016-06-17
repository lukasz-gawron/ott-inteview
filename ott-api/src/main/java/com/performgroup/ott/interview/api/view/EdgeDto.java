package com.performgroup.ott.interview.api.view;

/**
 * Created by lukasz.gawron on 17/06/16.
 */
public class EdgeDto {
    /**
     * Source node identifier
     */
    private String srcNodeId;
    /**
     * Destination node identifier
     */
    private String dstNodeId;


    public EdgeDto() {

    }

    public String getSrcNodeId() {
        return srcNodeId;
    }

    public void setSrcNodeId(String srcNodeId) {
        this.srcNodeId = srcNodeId;
    }

    public String getDstNodeId() {
        return dstNodeId;
    }

    public void setDstNodeId(String dstNodeId) {
        this.dstNodeId = dstNodeId;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "srcNodeId='" + srcNodeId + '\'' +
                ", dstNodeId='" + dstNodeId + '\'' +
                '}';
    }
}
