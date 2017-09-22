package edu.umass.problems.helper;

public class Multiple<T> extends HowMany<T> {
    private final int s;
    public Multiple(T value, int size) {
        super(value);
        s = size;
    }

    @Override
    public boolean isMultiple() {
        return true;
    }

    @Override
    public int size() {
        return s;
    }
}
