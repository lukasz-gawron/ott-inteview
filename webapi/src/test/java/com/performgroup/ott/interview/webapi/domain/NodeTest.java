package com.performgroup.ott.interview.webapi.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

/**
 * Created by lukasz on 17/06/16.
 */
public class NodeTest {

    @Test
    public void should_not_allow_creation_of_node_when_node_properties_are_missing() {
        assertThatExceptionOfType(GraphException.class)
                .isThrownBy(() -> new Node(null, ""));
    }
}
