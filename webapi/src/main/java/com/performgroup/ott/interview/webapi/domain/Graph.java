package com.performgroup.ott.interview.webapi.domain;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static java.util.Collections.unmodifiableSet;

/**
 * Created by lukasz on 17/06/16.
 */
public class Graph {
    final private Map<String, Node> nodesMap;
    final private Set<Node> nodes;
    final private Set<Edge> edges;

    public Graph() {
        nodes = new HashSet<>();
        edges = new HashSet<>();
        nodesMap = new HashMap<>();
    }

    /**
     * Get list of distinct nodes in a graph
     *
     * @return
     */
    public Set<Node> getNodes() {
        return unmodifiableSet(nodes);
    }

    /**
     * Add node to a graph, if its not already added
     *
     * @param node Node to add
     * @throws GraphException
     */
    public void addNode(Node node) {
        if (nodes.contains(node)) {
            throw new GraphException("Cannot add node which is already present in graph");
        }
        nodes.add(node);
        nodesMap.put(node.getId(), node);
    }

    /**
     * Add edge between nodes in a graph. If any of the nodes doesn't exists it throw an error
     *
     * @param srcNodeId  Identifier of source node
     * @param destNodeId Identifier of destination node
     * @return Edge edge connecting to nodes in a graph
     */
    public Edge addEdge(String srcNodeId, String destNodeId) {
        if (!nodesMap.containsKey(srcNodeId) || !nodesMap.containsKey(destNodeId)) {
            throw new GraphException("Cannot connect nodes which are not part of a graph");
        }
        Edge edge = new Edge(srcNodeId, destNodeId);
        edges.add(edge);
        return edge;
    }

    public Set<Edge> getEdges() {
        return unmodifiableSet(edges);
    }
}
