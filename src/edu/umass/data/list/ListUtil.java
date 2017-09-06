package edu.umass.data.list;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.lang.NullPointerException;

public class ListUtil {

    public static <X> List<X> intersperse(X x, List<X> xs){
        if (xs == null) throw new NullPointerException();
        if (xs.nil()) return xs;
        if (xs.tail.nil()) return xs;
        return intersperse(x, xs.tail).cons(x).cons(xs.head);
    }

    public static <X> List<X> concat(List<X> left, List<X> right){
        if (left == null || right == null) throw new NullPointerException();
        if (left.nil()) return right;
        return concat(left.tail, right).cons(left.head);
    }
    public static <X> List<X> flatten(List<List<X>> xs) {
        if (xs == null) throw new NullPointerException();
        if (xs.nil()) return new List<X>();
        return concat(xs.head, flatten(xs.tail));
    }
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

    public static <X,Y> Y foldr(BiFunction<X,Y,Y> f, Y acc, List<X> xs){
        if (xs == null) throw new NullPointerException();
        if (xs.nil()){
            return acc;
        }
        return foldr(f, f.apply(xs.head, acc), xs.tail);
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
