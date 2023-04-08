package org.example;

public class Main {
    public static void main(String[] args) {
        MyTree tree = new MyTree(1);
        MyTree tree2 = new MyTree(1);

        Node node2 = new Node(3);
        Node node3 = new Node(7);
        Node node4 = new Node(2);
        Node node5 = new Node(5);
        Node node6 = new Node(1);
        Node node7 = new Node(0);
        Node node8 = new Node(2);
        Node node9 = new Node(8);
        Node node10 = new Node(5);
        Node node11 = new Node(6);


        tree.addNode(tree.getRoot(), node2, node3);
        tree.addNode(node2, node4, node5);
        tree.addNode(node3, node6, node7);
        tree.addNode(node7, node8, node9);
        tree.addNode(node9, null, node10);
        tree2.addNode(node10, null, node11);

        tree2.addNode(tree2.getRoot(), node2, node3);
        tree2.addNode(node2, node4, node5);
        tree2.addNode(node3, node6, node7);
        tree2.addNode(node7, node8, node9);
        tree2.addNode(node9, null, node10);



        System.out.println(tree.countLeafNodes());
        System.out.println(tree.getMaxPathLength());
        System.out.println(tree.isEquivalent(tree2));
        System.out.println("------------------------------------------------");
        tree.preetyPrint();
        System.out.println("------------------------------------------------");
        tree2.preetyPrint();
    }
}