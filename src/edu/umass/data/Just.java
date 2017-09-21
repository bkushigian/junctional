package edu.umass.data;

public class Just<T> extends Maybe<T>{
    private final T val;

    public Just(T val){
        if (val == null){
            throw new NullPointerException("Cannot pass null to Just");
        }
        this.val = val;
    }

    public T fromJust(){
        return this.val;
    }
    @Override
    public boolean isNothing() {
        return false;
    }

    @Override
    public boolean isJust() {
        return true;
    }
}
