package com.performgroup.ott.interview.webapi.domain;

/**
 * Created by lukasz on 17/06/16.
 */
public class NodeMother {
    static Node aNode1() {
        return aNode("1", "Node1");
    }

    static Node aNode2() {
        return aNode("2", "Node2");
    }

    static Node aNode(String id, String label) {
        return new Node(id, label);
    }
}
