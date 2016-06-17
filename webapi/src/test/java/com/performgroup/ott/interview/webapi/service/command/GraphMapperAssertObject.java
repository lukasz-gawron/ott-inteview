package com.performgroup.ott.interview.webapi.service.command;

import com.performgroup.ott.interview.webapi.domain.Edge;
import com.performgroup.ott.interview.webapi.domain.Graph;
import com.performgroup.ott.interview.webapi.domain.Node;

import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created by lukasz.gawron on 17/06/16.
 */
public class GraphMapperAssertObject {
    private Graph graph;

    public GraphMapperAssertObject(Graph graph) {
        this.graph = graph;
    }

    public static GraphMapperAssertObject assertThat(Graph graph) {
        return new GraphMapperAssertObject(graph);
    }

    public GraphMapperAssertObject hasEdges(Set<Edge> expectedEgdes) {
        assertEquals(expectedEgdes, graph.getEdges());
        return this;
    }

    public GraphMapperAssertObject hasNodes(Set<Node> expectedNodes) {
        assertEquals(expectedNodes, graph.getNodes());
        return this;
    }
}
