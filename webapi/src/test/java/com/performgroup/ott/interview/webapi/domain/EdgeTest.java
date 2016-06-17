package com.performgroup.ott.interview.webapi.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

/**
 * Created by lukasz on 17/06/16.
 */
public class EdgeTest {

    @Test
    public void should_not_allow_creation_of_edge_when_node_ids_are_missing() {
        assertThatExceptionOfType(GraphException.class)
                .isThrownBy(() -> new Edge(null, null));
    }
}
