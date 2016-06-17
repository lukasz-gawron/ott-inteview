package com.performgroup.ott.interview.api.update;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by lukasz.gawron on 17/06/16.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "node")
public class NodeDto {
    private String id;
    private String label;
    @XmlElementWrapper(name = "adjacentNodes")
    @XmlElement(name = "id")
    private List<String> adjacentNodes;

    public NodeDto() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<String> getAdjacentNodes() {
        return adjacentNodes;
    }

    public void setAdjacentNodes(List<String> adjacentNodes) {
        this.adjacentNodes = adjacentNodes;
    }
}
