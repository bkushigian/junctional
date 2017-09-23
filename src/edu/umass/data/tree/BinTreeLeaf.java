package edu.umass.data.tree;

import java.util.Collections;
import java.util.function.Function;

public class BinTreeLeaf<T> extends BinTree<T> {

    public BinTreeLeaf() {
        super();
    }

    @Override
    public boolean isLeaf() {
        return true;
    }

    @Override
    public boolean isNode() {
        return false;
    }

    protected void toStringHelper(StringBuilder sb, int depth){
        sb.append(String.join("", Collections.nCopies(indent_depth * depth, " ")));
        sb.append("BinTreeLeaf");
    }

    public <Y> BinTree<Y> map(Function<T, Y> f){
        return new BinTreeLeaf<Y>();
    }
    public <Y> Y fold(Function<Y, Function<T, Function<Y, Y>> > f, Y acc){
        return acc;
    }

}
