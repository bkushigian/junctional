package edu.umass.data;
import java.util.function.*;
import static edu.umass.data.ListUtil.*;

/**
 * Implementation of a binary tree. A {@code BinTree} can either be a {@code Leaf} or a
 * {@code Node<T>, T, Node<T>}.
 *
 */
public class BinTree<T> {

    final public BinTree<T> left;
    final public BinTree<T> right;
    final public T val;

    protected BinTree(){
        this.left = null;
        this.right = null;
        this.val = null;
    }

    protected BinTree(BinTree<T> left, T val, BinTree<T> right){
        this.left = left;
        this.right = right;
        this.val = val;
    }

    public class Leaf<T> extends BinTree<T> {
        public Leaf(){
            super();
        }

        @Override
        public boolean isLeaf(){
            return true;
        }
    }

    public class Node<T> extends BinTree<T> {
        public Node(BinTree<T> left, T val, BinTree<T> right){
            super(left, val, right);
            if (left == null || right == null || val == null) {
                throw new NullPointerException("Received null pointer for BinTree constructor");
            }
        }
    }

    public <X> List<X> in_order_map(Function<T,X> f){
        if (f == null)
            throw new NullPointerException("Received null value for function passed to BinTree.in_order()");
        if (isLeaf()){
            return new List<X>();
        }
        return concat(left.in_order_map(f), cons(f.apply(val), right.in_order_map(f)));
    }

    public boolean isLeaf(){
        return false;
    }

    public boolean isNode(){
        return !isLeaf();
    }
}
