package com.performgroup.ott.interview.webapi.domain;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.*;

/**
 * Created by lukasz on 17/06/16.
 */
public class GraphTest {
    private Graph objectUnderTest = new Graph();

    @Test
    public void should_add_node_to_list_of_nodes_if_nodes_list_is_empty() {
        //given
        Node node1 = NodeMother.aNode1();

        //when
        objectUnderTest.addNode(node1);

        //then
        assertThat(objectUnderTest.getNodes(), hasItem(node1));
    }

    @Test
    public void should_throw_error_if_node_is_already_added() {
        //given
        Node node1 = NodeMother.aNode1();

        //when
        objectUnderTest.addNode(node1);

        //then
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> objectUnderTest.addNode(node1));
    }


    @Test
    public void should_add_edge_if_connected_nodes_exists_in_graph() {
        //given
        Node node1 = NodeMother.aNode1();
        Node node2 = NodeMother.aNode2();
        objectUnderTest.addNode(node1);
        objectUnderTest.addNode(node2);

        //when
        Edge edge = objectUnderTest.addEdge(node1.getId(), node2.getId());

        //then
        assertThat(objectUnderTest.getEdges(), hasItem(edge));
    }


    @Test
    public void should_not_add_edge_if_at_least_one_node_doesnt_exists_in_graph() {
        //given
        Node node1 = NodeMother.aNode1();
        Node node2 = NodeMother.aNode2();
        objectUnderTest.addNode(node1);

        //then
        assertThatExceptionOfType(GraphException.class)
                .isThrownBy(() -> objectUnderTest.addEdge(node1.getId(), node2.getId()));
    }

}
