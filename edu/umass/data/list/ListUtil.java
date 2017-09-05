package edu.umass.data.list;

import java.util.function.Function;
import java.lang.NullPointerException;

public class ListUtil {
    public static <X,Y> List<Y> map(Function<X,Y> f, List<X> xs){
        if (xs == null) throw new NullPointerException();
        if (nil(xs)) return new List<Y>();

        return map(f, xs.tail).cons(f.apply(xs.head));
    }

    public static <T> int size(List<T> xs){
        return xs.head == null ? 0 : 1 + size(xs.tail);
    }

    public static <T> boolean nil(List<T> xs) { 
        if (xs == null) throw new NullPointerException();
        return xs.head == null; 
    }


    public static List<Integer> range(int low, int hi){
        List<Integer> ll = new List<>();
        for (int i = hi - 1; i >= low; --i){
            ll = ll.cons(i); 
        }
        return ll;
    }

    public static List<Integer> range(int hi){
        return range(0, hi);
    }


    public static<T> List<T> filter(Function<T, Boolean> p, List<T> xs){
        if (xs == null) throw new NullPointerException();
        return xs.nil() ? xs : p.apply(xs.head) ? filter(p, xs.tail).cons(xs.head) : filter(p, xs.tail);
    }
}
