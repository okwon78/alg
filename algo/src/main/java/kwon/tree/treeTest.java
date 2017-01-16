package kwon.tree;

import kwon.tree.Tree;

/**
 * Created by nhnent on 14/11/2016.
 */
public class treeTest {
    public static void main(String[] args) {

        int[] array = {4, 2, 1, 3, 9, 5, 8, 7, 6};

        Tree tree = new Tree();

        for(int elem : array) {
            tree.addValue(elem);
        }

        tree.print();
    }
}
