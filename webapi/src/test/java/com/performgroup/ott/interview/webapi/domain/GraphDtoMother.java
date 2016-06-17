package com.performgroup.ott.interview.webapi.domain;

import com.performgroup.ott.interview.api.update.GraphDto;
import com.performgroup.ott.interview.api.update.NodeDto;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by lukasz.gawron on 17/06/16.
 */
public class GraphDtoMother {

    public static final String NODE_1_ID = "1";
    public static final String NODE_2_ID = "2";

    public static NodeDto aNodeDto1() {

        return aNodeDto(NODE_1_ID, "Node1", asList(NODE_2_ID));
    }

    public static NodeDto aNodeDto2() {

        return aNodeDto(NODE_2_ID, "Node2", asList(NODE_1_ID));
    }

    public static NodeDto aNodeDto(String id, String label, List<String> adjacentNodes) {

        NodeDto dto = new NodeDto();
        dto.setId(id);
        dto.setLabel(label);
        dto.setAdjacentNodes(adjacentNodes);
        return dto;
    }


    public static GraphDto aGraphDto() {
        GraphDto dto = new GraphDto();
        dto.setNodes(asList(aNodeDto1(), aNodeDto2()));
        return dto;

    }
}
