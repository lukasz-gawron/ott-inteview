package com.performgroup.ott.interview.webapi.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.*;

import static java.util.Collections.unmodifiableSet;

/**
 * Graph domain representation, holds nodes and edges. Managed basic domain logic of graphs preventing creation of
 * bad graph.
 * Annotated with Elasticsearch annotations to make storing in Elasticsearch possible.
 * <p>
 * Created by lukasz.gawron on 17/06/16.
 */
@Document(indexName = "graphs")
public class Graph {
    @Id
    final private String id;
    final private Map<String, Node> nodesMap;
    @Field(type = FieldType.Nested)
    final private Set<Node> nodes;
    @Field(type = FieldType.Nested)
    final private Set<Edge> edges;

    public Graph() {
        id = "1";
        nodes = new HashSet<>();
        edges = new HashSet<>();
        nodesMap = new HashMap<>();
    }

    /**
     * Get unique identifier of this graph
     *
     * @return identifier
     */
    public String getId() {
        return id;
    }

    /**
     * Get unmodifiable set of distinct nodes in a graph
     *
     * @return get unmodifiable set of nodes
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

    /**
     * Gets unmodifiable set of graph edges
     *
     * @return unmodifiable set of graph edges
     */
    public Set<Edge> getEdges() {
        return unmodifiableSet(edges);
    }
}
