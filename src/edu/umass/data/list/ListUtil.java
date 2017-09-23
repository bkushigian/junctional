package edu.umass.data.list;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.lang.NullPointerException;

public class ListUtil {

    public static <X> Optional<X> head(List<X> xs){
        return xs.head();
    }

    public static <X> Optional<List<X>> tail(List<X> xs){
        return xs.tail();
    }

    public static <X> List<X> intersperse(X x, List<X> xs){
        if (xs == null) throw new NullPointerException();
        if (xs.nil()) return xs;
        if (xs.tl.nil()) return xs;
        return intersperse(x, xs.tl).cons(x).cons(xs.hd);
    }

    public static <X> List<X> concat(List<X> left, List<X> right){
        if (left == null || right == null) throw new NullPointerException();
        if (left.nil()) return right;
        return concat(left.tl, right).cons(left.hd);
    }
    public static <X> List<X> flatten(List<List<X>> xs) {
        if (xs == null) throw new NullPointerException();
        if (xs.nil()) return new List<X>();
        return concat(xs.hd, flatten(xs.tl));
    }
    public static <X,Y> List<Y> map(Function<X,Y> f, List<X> xs){
        if (xs == null) throw new NullPointerException();
        if (nil(xs)) return new List<Y>();

        return map(f, xs.tl).cons(f.apply(xs.hd));
    }

    public static <T> int size(List<T> xs){
        return xs.hd == null ? 0 : 1 + size(xs.tl);
    }

    public static <T> boolean nil(List<T> xs) { 
        if (xs == null) throw new NullPointerException();
        return xs.hd == null;
    }

    public static <X,Y> Y foldr(BiFunction<X,Y,Y> f, Y acc, List<X> xs){
        if (xs == null) throw new NullPointerException();
        if (xs.nil()){
            return acc;
        }
        return foldr(f, f.apply(xs.hd, acc), xs.tl);
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
        return xs.nil() ? xs : p.apply(xs.hd) ? filter(p, xs.tl).cons(xs.hd) : filter(p, xs.tl);
    }

    public static<T> List<T> cons(T x, List<T> xs){
        if (x == null || xs == null) throw new NullPointerException();
        return new List<T>(x, xs);
    }
}
