package edu.umass.data;

public abstract class Maybe<T> {

    public final boolean nothing;

    protected Maybe(boolean nothing){
        this.nothing = nothing;
    }
    public class Just<T> extends Maybe<T>{
        final public T val;
        public Just(T val){
            super(false);
            if (val == null) throw new NullPointerException();
            this.val = val;
        }
    }

    public class Nothing<T> extends Maybe<T>{
        public Nothing(){
            super(true);
        }
    }

}
