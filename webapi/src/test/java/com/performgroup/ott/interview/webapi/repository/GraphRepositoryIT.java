package com.performgroup.ott.interview.webapi.repository;

import com.performgroup.ott.interview.webapi.App;
import com.performgroup.ott.interview.webapi.domain.Graph;
import com.performgroup.ott.interview.webapi.domain.Node;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.performgroup.ott.interview.webapi.domain.NodeMother.aNode1;
import static com.performgroup.ott.interview.webapi.domain.NodeMother.aNode2;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by lukasz.gawron on 17/06/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(App.class)
public class GraphRepositoryIT {
    @Autowired
    private GraphRepository objectUnderTest;

    @Test
    public void should_autowire_graph_repository() {
        //expect
        assertThat(objectUnderTest, notNullValue());
    }

    @Test
    public void should_store_graph() {
        //given
        Graph expected = new Graph();
        Node node1 = aNode1();
        Node node2 = aNode2();
        expected.addNode(aNode1());
        expected.addNode(aNode2());
        expected.addEdge(node1.getId(), node2.getId());

        //when
        objectUnderTest.save(expected);

        //then
        Graph actual = objectUnderTest.findOne(expected.getId());
        assertThat(expected, notNullValue());
        assertEquals(expected.getEdges(), expected.getEdges());
        assertEquals(expected.getNodes(), actual.getNodes());
    }
}
