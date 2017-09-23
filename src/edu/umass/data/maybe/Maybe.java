package edu.umass.data.maybe;

public abstract class Maybe<T> {
    public abstract boolean isNothing();
    public abstract boolean isJust();
}
