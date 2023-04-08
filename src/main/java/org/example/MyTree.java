package org.example;

import ajs.printutils.PrettyPrintTree;

public class MyTree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public MyTree(int rootValue) {
        root = new Node(rootValue);
    }
    /**
    *Public method for adding a new node. Enter the parent node and the left and right nodes.
    */
    public void addNode(Node parentNode, Node leftChild, Node rightChild) {
        parentNode.setLeft(leftChild);
        parentNode.setRight(rightChild);
    }
    /**
    *Public method without parameters to count the leaves in the tree.
    *By default, it is called once, and in the iteration process, private method with a parameter is called.
    */
    public int countLeafNodes() {
        Node node = this.root;
        if (node.getLeft() == null && node.getRight() == null) {
            return 1;
        } else {
            return countLeafNodes(node.getLeft()) + countLeafNodes(node.getRight());
        }
    }
    private int countLeafNodes(Node node) {
        if (node == null) {
            return 0;
        } else if (node.getLeft() == null && node.getRight() == null) {
            return 1;
        } else {
            return countLeafNodes(node.getLeft()) + countLeafNodes(node.getRight());
        }
    }
    /**
    *Public method without parameters to count the leaves in the tree.
    *By default, it is called once, and in the iteration process, private method with a parameter is called.
    */
    public int getMaxPathLength() {
       Node node = this.root;
       int leftPath = getMaxPathLength(node.getLeft());
       int rightPath = getMaxPathLength(node.getRight());
       return Math.max(leftPath, rightPath);

    }
    private int getMaxPathLength(Node node) {
        if (node == null) {
            return 0;
        } else {
            int leftPath = getMaxPathLength(node.getLeft());
            int rightPath = getMaxPathLength(node.getRight());
            return 1 + Math.max(leftPath, rightPath);
        }
    }

    /**
    *Public method without parameters to compare two trees.
    *By default, it is called once, and in the iteration process, private method with parameters is called
    */
    public boolean isEquivalent(MyTree tree) {
       Node node1 = this.root;
       Node node2 = tree.root;
       if (node1 == null && node2 == null) {
           return true;
       } else if (node1 == null || node2 == null) {
           return false;
       } else if (node1.getValue() != node2.getValue()) {
           return false;
       } else {
           return isEquivalent(node1.getLeft(), node2.getLeft()) && isEquivalent(node1.getRight(), node2.getRight());
       }
    }
    private boolean isEquivalent(Node node1, Node node2) {
        if (node1 == null && node2 == null) {
            return true;
        } else if (node1 == null || node2 == null) {
            return false;
        } else if (node1.getValue() != node2.getValue()) {
            return false;
        } else {
            return isEquivalent(node1.getLeft(), node2.getLeft()) && isEquivalent(node1.getRight(), node2.getRight());
        }
    }

    /**
    * Public method based on an external library for displaying the tree in a more user-friendly form
    */
    public void preetyPrint(){
        PrettyPrintTree<Node> prettyTree = new PrettyPrintTree<>(
                Node::getChildren,
                node -> Integer.toString(node.getValue())
        );
        prettyTree.display(root);
    }
}