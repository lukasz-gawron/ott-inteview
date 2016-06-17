package com.performgroup.ott.interview.webapi.domain;

/**
 * Created by lukasz.gawron on 17/06/16.
 */
public class NodeMother {

    public static final String NODE_1_ID = "1";
    public static final String NODE_2_ID = "2";

    public static Node aNode1() {
        return aNode(NODE_1_ID, "Node1");
    }

    public static Node aNode2() {
        return aNode(NODE_2_ID, "Node2");
    }

    public static Node aNode(String id, String label) {
        return new Node(id, label);
    }
}
