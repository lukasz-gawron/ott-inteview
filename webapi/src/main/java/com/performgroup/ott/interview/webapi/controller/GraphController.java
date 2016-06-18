package com.performgroup.ott.interview.webapi.controller;

import com.performgroup.ott.interview.api.update.GraphDto;
import com.performgroup.ott.interview.webapi.domain.GraphException;
import com.performgroup.ott.interview.webapi.domain.GraphNotFoundException;
import com.performgroup.ott.interview.webapi.service.command.GraphService;
import com.performgroup.ott.interview.webapi.service.query.GraphQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.*;

/**
 * Created by lukasz.gawron on 17/06/16.
 */
@RestController
public class GraphController {

    private final GraphService graphService;
    private final GraphQueryService graphQueryService;

    @Autowired
    public GraphController(GraphService graphService, GraphQueryService graphQueryService) {
        this.graphService = graphService;
        this.graphQueryService = graphQueryService;
    }

    @RequestMapping(value = "/graph", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<com.performgroup.ott.interview.api.view.GraphDto> getGraph() {
        try {
            com.performgroup.ott.interview.api.view.GraphDto result = graphQueryService.getGraph();
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (GraphNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/graph", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> updateGraph(@RequestBody GraphDto graphDto) {
        try {
            graphService.addGraph(graphDto);
            return new ResponseEntity<>(OK);
        } catch (GraphException e) {
            return new ResponseEntity<>(PRECONDITION_FAILED);
        } catch (Exception e) {
            return new ResponseEntity<>(INTERNAL_SERVER_ERROR);
        }
    }
}