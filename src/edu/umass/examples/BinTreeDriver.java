package edu.umass.examples;
import edu.umass.data.container.BinTree;
import edu.umass.data.container.BinTreeNode;
import edu.umass.data.container.BinTreeLeaf;

public class BinTreeDriver {
    public static void main(String[] args){
        BinTree<Integer> t = new BinTreeNode<>(
            new BinTreeNode<>(
                    new BinTreeLeaf<>(),
                    3,
                    new BinTreeLeaf<>()
            ),
            2,
            new BinTreeNode<>(
                    new BinTreeLeaf<>(),
                    1,
                    new BinTreeLeaf<>()
            )
        );
        System.out.println(t.toString());
        BinTree<String> s = t.map(x -> x * 100).map(x -> x.toString());
        System.out.println(s);

        System.out.println("Sum of tree1 = " + t.fold(x -> y ->z -> x + y + z, 0));
    }
}
