package edu.umass.data.list;

import java.lang.StringBuilder;
import java.util.function.Function;
import java.util.function.BiFunction;

/**
 * An immutable linked list implementation that allows for a functional style
 * of programming to be demonstrated. This makes no claims about efficiency but
 * should work for any small and medium sized tasks sent at it.
 *
 * Note that JVM doesn't do tail call optimization so recursive functions will
 * be slow and possibly blow the stack if nested too deep.
 *
 * @param <T> Type of element in the list
 */
public class List <T> {
    public final T head;
    public final List<T> tail;

    /**
     * Construct an empty node
     */
    public List(){
        head = null;
        tail  = null;
    }

    /**
     * Construct a singleton list
     * @param head: value of singleton
     */
    public List(T head){
        if (head == null) throw new NullPointerException();
        this.head = head;
        tail = new List<T>();
    }

    /**
     * Construct a list with head value and tail list
     * @param head
     * @param tail
     */
    public List(T head, List<T> tail){
        if (head == null) throw new NullPointerException();
        if (tail  == null) throw new NullPointerException();
        this.head = head;
        this.tail = tail;
    }

    /**
     * Convenience function: Construct list from array
     * @param vals
     */
    public List(T[] vals){
        if (vals.length == 0){
            head = null;
            tail = null;
            return;
        }

        List<T> tail = new List<>();

        for (int i = vals.length - 1; i > 0; --i) {
            T val = vals[i];
            if (val == null) throw new NullPointerException();
            tail = new List<T>(vals[i], tail);
        }

        this.head = vals[0];
        this.tail  = tail;
    }

    /**
     * Create a new list from this one w/ head value {@code val}
     * @param val
     * @return new list created, pointing at this
     */
    public List<T> cons(T val) {
        return new List<>(val, this);
    }


    /**
     * map this list under mapping {@code f}
     * @param f Mapping to perform on each element of this list
     * @param <Y> Domain type of {@code f}
     * @return this list mapped under {@code f}
     */
    public <Y> List<Y> map(Function<T, Y> f){
        if (nil()) return new List<Y>();
        return tail.map(f).cons(f.apply(head));
    }

    public <Y> Y foldr(BiFunction<T,Y,Y> f, Y acc){
        if (nil()){
            return acc;
        }
        return tail.foldr(f, f.apply(head, acc));
    }

    /**
     * Return the size of this list
     * @return total number of non-nil nodes in this list
     */
    public int size(){
        return head == null? 0 : 1 + tail.size();
    }

    /**
     * A predicate that tests if this list is empty (i.e., head == null)
     * @return head == null;
     */
    public boolean nil(){
        return head == null;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof List<?>) {
            List<?> other = (List<?>) obj;
            if (nil()) {
                return other.nil();
            }
            return !other.nil() && tail.equals(other.tail);
        }
        return false;
    }

    public String toString(){
        if (head == null) return "[]";
        StringBuilder sb = new StringBuilder("[" + head);
        tail.toStringHelper(sb);
        return sb.toString();
    }

    private void toStringHelper(StringBuilder sb){
        if (head == null){
            sb.append("]");
        } else{
            sb.append("," + head);
            tail.toStringHelper(sb);
        }
    }
}
