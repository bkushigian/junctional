package edu.umass.data.container;

import java.util.Collections;
import java.util.function.Function;

public class BinTreeNode<T> extends BinTree<T> {
    public BinTreeNode(BinTree<T> left, T val, BinTree<T> right){
        super(left, val, right);
        if (left == null || right == null || val == null) {
            throw new NullPointerException("Received null pointer for BinTree constructor");
        }
    }

    @Override
    public boolean isLeaf() {
        return false;
    }

    @Override
    public boolean isNode() {
        return true;
    }

    protected void toStringHelper(StringBuilder sb, int depth){
        sb.append(String.join("", Collections.nCopies(indent_depth * depth, " ")));
        sb.append("BinTreeNode(\n");
        left.toStringHelper(sb, depth + 1);
        sb.append(",\n");
        sb.append(String.join("", Collections.nCopies(indent_depth * (depth + 1), " ")));
        sb.append(val);
        sb.append(",\n");
        right.toStringHelper(sb, depth + 1);
        sb.append("\n");
        sb.append(String.join("", Collections.nCopies(indent_depth * depth, " ")));
        sb.append(")");
    }

    public <Y> BinTree<Y> map(Function<T, Y> f){
        return new BinTreeNode<Y>(
                left.map(f),
                f.apply(val),
                right.map(f)
        );
    }

    public <Y> Y fold(Function<Y, Function<T, Function<Y, Y>> > f, Y acc){
        return f.apply(left.fold(f, acc)).apply(val).apply(right.fold(f,acc));
    }
}
