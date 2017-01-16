package kwon.tree;

/**
 * Created by nhnent on 14/11/2016.
 */
public class Node {

    private int value;
    private Node left;
    private Node right;

    public Node(int value){
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }


    public int getValue() {
        return value;
    }

    public void addNode(int value) {

        if (this.value == value)
            return;

        if (this.value > value) {
            this.left = addSubNode(left, value);
        }
        else {
            this.right = addSubNode(right, value);
        }
    }

    private Node addSubNode(Node node, int value) {
        if (node == null) {
            node = new Node(value);
        } else {
            node.addNode(value);
        }

        return node;
    }
}
