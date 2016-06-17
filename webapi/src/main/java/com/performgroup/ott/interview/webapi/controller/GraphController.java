package com.performgroup.ott.interview.webapi.controller;

import com.performgroup.ott.interview.api.update.GraphDto;
import com.performgroup.ott.interview.webapi.domain.GraphException;
import com.performgroup.ott.interview.webapi.service.GraphService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.HttpStatus.PRECONDITION_FAILED;

/**
 * Created by lukasz.gawron on 17/06/16.
 */
@RestController
public class GraphController {

    private final GraphService graphService;

    @Autowired
    public GraphController(GraphService graphService) {
        this.graphService = graphService;
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