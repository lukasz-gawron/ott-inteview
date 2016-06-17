package com.performgroup.ott.interview.webapi.service.query;

import com.performgroup.ott.interview.api.view.GraphDto;
import com.performgroup.ott.interview.webapi.domain.Graph;
import org.modelmapper.ModelMapper;

/**
 * Created by lukasz on 17/06/16.
 */
public class ViewGraphMapper {


    public GraphDto map(Graph graph) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(graph, GraphDto.class);
    }
}
