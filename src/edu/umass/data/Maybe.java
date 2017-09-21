package edu.umass.data;

public abstract class Maybe<T> {
    public abstract boolean isNothing();
    public abstract boolean isJust();
}
