package kwon.tree;

import java.util.Stack;

/**
 * Created by nhnent on 14/11/2016.
 */
public class Tree {
    private Node root = null;

    public Tree() {
    }

    public void addValue(int value) {

        if (this.root == null) {
            root = new Node(value);
        } else {
            root.addNode(value);
        }
    }

    public void print() {
        traverseTree(root);
    }

    private void traverseTree(Node node) {
        Node left = node.getLeft();

        if (left != null)
            traverseTree(left);

        System.out.println(node.getValue());

        Node right = node.getRight();
        if (right != null)
            traverseTree(right);
    }
}
