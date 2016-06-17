package com.performgroup.ott.interview.webapi.service;

import com.performgroup.ott.interview.api.update.GraphDto;
import com.performgroup.ott.interview.webapi.domain.Edge;
import com.performgroup.ott.interview.webapi.domain.Graph;
import com.performgroup.ott.interview.webapi.domain.Node;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static com.performgroup.ott.interview.webapi.domain.NodeDtoMother.*;
import static com.performgroup.ott.interview.webapi.domain.NodeMother.aNode1;
import static com.performgroup.ott.interview.webapi.domain.NodeMother.aNode2;
import static com.performgroup.ott.interview.webapi.service.GraphMapperAssertObject.assertThat;
import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Created by lukasz.gawron on 17/06/16.
 */
public class GraphMapperTest {
    private GraphMapper objectUnderTest = new GraphMapperImpl();

    @Test
    public void should_map_all_data_from_dto_to_model() {
        //given
        GraphDto dto = aGraphDto();

        //when
        Graph actual = objectUnderTest.map(dto);

        //then
        Edge EDGE_1_TO_2 = new Edge(NODE_1_ID, NODE_2_ID);
        Edge EDGE_2_TO_1 = new Edge(NODE_2_ID, NODE_1_ID);
        Set<Edge> expectedEdges = new HashSet<>(asList(EDGE_1_TO_2, EDGE_2_TO_1));
        Set<Node> expectedNodes = new HashSet<>(asList(aNode1(), aNode2()));

        assertThat(actual, notNullValue());
        assertThat(actual)
                .hasEdges(expectedEdges)
                .hasNodes(expectedNodes);
    }
}
