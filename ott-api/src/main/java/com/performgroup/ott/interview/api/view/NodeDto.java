package com.performgroup.ott.interview.api.view;

/**
 * Created by lukasz.gawron on 17/06/16.
 */
public class NodeDto {
    private String id;
    private String label;


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
}
