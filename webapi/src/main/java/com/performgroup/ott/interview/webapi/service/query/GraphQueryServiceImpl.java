package com.performgroup.ott.interview.webapi.service.query;

import com.performgroup.ott.interview.api.view.GraphDto;
import com.performgroup.ott.interview.webapi.domain.Graph;
import com.performgroup.ott.interview.webapi.domain.GraphNotFoundException;
import com.performgroup.ott.interview.webapi.repository.GraphRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lukasz.gawron on 17/06/16.
 */
@Service
public class GraphQueryServiceImpl implements GraphQueryService {

    private GraphRepository graphRepository;

    @Autowired
    public GraphQueryServiceImpl(GraphRepository graphRepository) {
        this.graphRepository = graphRepository;
    }

    @Override
    public GraphDto getGraph() {
        ViewGraphMapper graphMapper = new ViewGraphMapper();
        Graph graph = graphRepository.findOne("1");
        if (graph == null) {
            throw new GraphNotFoundException();
        }
        return graphMapper.map(graph);

    }
}
