package edu.umass.data;

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
