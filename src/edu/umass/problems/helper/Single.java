package edu.umass.problems.helper;

public class Single<T> extends HowMany<T>{

    public Single(T value) {
        super(value);
    }

    @Override
    public boolean isSingle() {
        return true;
    }
}
