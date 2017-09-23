package edu.umass.data.maybe;

public class Nothing<T> extends Maybe<T> {
    @Override
    public boolean isNothing() {
        return true;
    }

    @Override
    public boolean isJust() {
        return false;
    }
}
