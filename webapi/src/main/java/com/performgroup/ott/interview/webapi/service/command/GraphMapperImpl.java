package com.performgroup.ott.interview.webapi.service.command;

import com.performgroup.ott.interview.api.update.GraphDto;
import com.performgroup.ott.interview.webapi.domain.Graph;
import com.performgroup.ott.interview.webapi.domain.Node;
import org.springframework.stereotype.Component;

/**
 * Created by lukasz.gawron on 17/06/16.
 */
@Component
class GraphMapperImpl implements GraphMapper {
    @Override
    public Graph map(GraphDto graphDto) {
        Graph graph = new Graph();
        graphDto.getNodes()
                .forEach(nodeDto -> graph.addNode(new Node(nodeDto.getId(), nodeDto.getLabel())));
        graphDto.getNodes()
                .forEach(nodeDto -> nodeDto.getAdjacentNodes()
                        .forEach(adjacentNodeId -> graph.addEdge(nodeDto.getId(), adjacentNodeId)));
        return graph;
    }


}
