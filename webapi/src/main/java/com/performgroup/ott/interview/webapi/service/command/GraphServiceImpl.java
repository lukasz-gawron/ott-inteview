package com.performgroup.ott.interview.webapi.service.command;

import com.performgroup.ott.interview.api.update.GraphDto;
import com.performgroup.ott.interview.webapi.domain.Graph;
import com.performgroup.ott.interview.webapi.repository.GraphRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lukasz.gawron on 17/06/16.
 */
@Service
class GraphServiceImpl implements GraphService {
    private final GraphRepository graphRepository;
    private final GraphMapper mapper;

    @Autowired
    public GraphServiceImpl(GraphRepository repository, GraphMapper mapper) {
        this.graphRepository = repository;
        this.mapper = mapper;
    }

    @Override
    public void addGraph(GraphDto graphDto) {
        Graph graph = mapper.map(graphDto);
        graphRepository.save(graph);
    }
}
