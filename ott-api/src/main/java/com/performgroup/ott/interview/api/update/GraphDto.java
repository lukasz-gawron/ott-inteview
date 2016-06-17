package com.performgroup.ott.interview.api.update;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * Created by lukasz.gawron on 17/06/16.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class GraphDto {
    @XmlElement
    private String id;

    @XmlElement(name = "node")
    private List<NodeDto> nodes;

    public GraphDto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<NodeDto> getNodes() {
        return nodes;
    }

    public void setNodes(List<NodeDto> nodes) {
        this.nodes = nodes;
    }
}
