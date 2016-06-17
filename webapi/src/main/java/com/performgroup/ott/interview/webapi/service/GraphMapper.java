package com.performgroup.ott.interview.webapi.service;

import com.performgroup.ott.interview.api.update.GraphDto;
import com.performgroup.ott.interview.webapi.domain.Graph;

/**
 * Created by lukasz.gawron on 17/06/16.
 */
public interface GraphMapper {
    /**
     * Maps between data transfer object and model class
     *
     * @param graphDto details of graph provided to this service
     * @return graph model based on dto
     */
    Graph map(GraphDto graphDto);
}
