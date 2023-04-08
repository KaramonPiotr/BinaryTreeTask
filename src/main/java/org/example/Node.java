package org.example;

import java.util.ArrayList;
import java.util.List;

class Node {
    private int value;
    private Node left, right;

    public Node(int item) {
        value = item;
        left = null;
        right = null;
    }
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public List<Node> getChildren() {
        ArrayList<Node> children = new ArrayList<>();
        children.add(left);
        children.add(right);
        return children;
    }
}