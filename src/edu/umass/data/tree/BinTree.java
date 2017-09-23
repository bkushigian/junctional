package edu.umass.data.tree;
import edu.umass.data.list.List;

import java.util.function.*;
import static edu.umass.data.list.ListUtil.*;

/**
 * Implementation of a binary tree. A {@code BinTree} can either be a {@code Leaf} or a
 * {@code Node<T>, T, Node<T>}.
 *
 */
public abstract class BinTree<T> {

    final public BinTree<T> left;
    final public BinTree<T> right;
    final public T val;
    final protected int indent_depth = 4;

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        toStringHelper(sb, 0);
        return sb.toString();
    }

    public abstract <Y> BinTree<Y> map(Function<T, Y> f);
    public abstract <Y> Y fold(Function<Y, Function<T, Function<Y, Y>> > f, Y acc);

    protected abstract void toStringHelper(StringBuilder sb, int depth);
}
