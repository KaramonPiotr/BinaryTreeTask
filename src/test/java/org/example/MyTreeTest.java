package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyTreeTest {
    private MyTree tree1;
    private MyTree tree2;
    private MyTree tree3;


    @BeforeEach
    public void setUp() {
        /*
         *  Create 3 trees, two identical and one different
         *         5                *         5                  *         5
         *      /     \             *      /     \               *      /     \
         *     /       \            *     /       \              *     /       \
         *    3         7           *    3         7             *    3         7
         *  /   \     /   \         *  /   \     /   \           *  /   \     /   \
         * 2     5   1     0        * 2     5   1     0          * 2     5   1     0
         *               /   \      *               /   \        *               /   \
         *              2     8     *              2     8       *              2     8
         *                     \    *                     \      *                   /  \
         *                      6   *                      6     *                  4    6
         */
        Node node2a = new Node(3);
        Node node3a = new Node(7);
        Node node4a = new Node(2);
        Node node5a = new Node(5);
        Node node6a = new Node(1);
        Node node7a = new Node(0);
        Node node8a = new Node(2);
        Node node9a = new Node(8);
        Node node10a = new Node(5);


        Node node2b = new Node(3);
        Node node3b = new Node(7);
        Node node4b = new Node(2);
        Node node5b = new Node(5);
        Node node6b = new Node(1);
        Node node7b = new Node(0);
        Node node8b = new Node(2);
        Node node9b = new Node(8);
        Node node10b = new Node(5);
        Node node11b = new Node(4);

        tree1 = new MyTree(5);
        tree1.addNode(tree1.getRoot(), node2a, node3a);
        tree1.addNode(node2a, node4a, node5a);
        tree1.addNode(node3a, node6a, node7a);
        tree1.addNode(node7a, node8a, node9a);
        tree1.addNode(node9a, null, node10a);

        tree2 = new MyTree(5);
        tree2.addNode(tree2.getRoot(), node2b, node3b);
        tree2.addNode(node2b, node4b, node5b);
        tree2.addNode(node3b, node6b, node7b);
        tree2.addNode(node7b, node8b, node9b);
        tree2.addNode(node9b, null, node10b);

        tree3 = new MyTree(5);
        tree3.addNode(tree3.getRoot(), node2b, node3b);
        tree3.addNode(node2b, node4b, node5b);
        tree3.addNode(node3b, node6b, node7b);
        tree3.addNode(node7b, node8b, node9b);
        tree3.addNode(node9b, node11b, node10b);



    }

    @Test
    public void testCountLeafNodes() {
        int expected = 5;
        int actual = tree1.countLeafNodes();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMaxPathLength(){
        int expected = 4;
        int actual = tree1.getMaxPathLength();
        Assertions.assertEquals(expected,actual);
    }
    @Test
    public void testIsEquivalent(){
        Assertions.assertTrue(tree1.isEquivalent(tree2));
    }
    @Test
    public  void testIsEquivalent2(){
        Assertions.assertFalse(tree1.isEquivalent(tree3));
    }
}