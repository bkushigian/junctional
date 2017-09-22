package edu.umass.problems.helper;

public abstract class HowMany<T> {
    public final T value;

    protected HowMany(T value){
        if (value == null){
            throw new NullPointerException("HowMany received null for value in constructor");
        }
        this.value = value;
    }

    public boolean isSingle(){
        return false;
    }
    public boolean isMultiple(){
        return false;
    }
    public int size(){
        return 1;
    }
}
