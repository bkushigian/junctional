package edu.umass.data.container;

import edu.umass.data.helper.ListIter;
import edu.umass.data.maybe.Just;
import edu.umass.data.maybe.Maybe;
import edu.umass.data.maybe.Nothing;

import java.lang.StringBuilder;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Function;
import java.util.function.BiFunction;
import java.util.function.Predicate;

/**
 * An immutable linked list implementation that allows for a functional style
 * of programming to be demonstrated. This makes no claims about efficiency but
 * should work for any small and medium sized tasks sent at it.
 *
 * Note that JVM doesn't do tl call optimization so recursive functions will
 * be slow and possibly blow the stack if nested too deep.
 *
 * @param <T> Type of element in the list
 */
public class List <T> implements Collection{
    protected final T hd;
    protected final List<T> tl;

    /**
     * Construct an empty node
     */
    public List(){
        hd = null;
        tl = null;
    }

    /**
     * Construct a singleton list
     * @param head: value of singleton
     */
    public List(T head){
        if (head == null) throw new NullPointerException();
        this.hd = head;
        tl = new List<T>();
    }

    /**
     * Construct a list with hd value and tl list
     * @param head
     * @param tail
     */
    public List(T head, List<T> tail){
        if (head == null) throw new NullPointerException();
        if (tail  == null) throw new NullPointerException();
        this.hd = head;
        this.tl = tail;
    }

    /**
     * Convenience function: Construct list from array
     * @param vals
     */
    public List(T[] vals){
        if (vals.length == 0){
            hd = null;
            tl = null;
            return;
        }

        List<T> tail = new List<>();

        for (int i = vals.length - 1; i > 0; --i) {
            T val = vals[i];
            if (val == null) throw new NullPointerException();
            tail = new List<T>(vals[i], tail);
        }

        this.hd = vals[0];
        this.tl = tail;
    }

    public Maybe<T> head(){
        return nil() ? new Nothing<>() : new Just<>(hd);
    }
    public Maybe<List<T>> tail() { return nil()? new Nothing() : new Just<>(tl);}

    /**
     * Create a new list from this one w/ hd value {@code val}
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
        return tl.map(f).cons(f.apply(hd));
    }

    /**
     * fold this list under folding function f
     * @param f
     * @param acc
     * @param <Y>
     * @return
     */
    public <Y> Y foldr(BiFunction<T,Y,Y> f, Y acc){
        if (nil()){
            return acc;
        }
        return tl.foldr(f, f.apply(hd, acc));
    }

    /**
     * Given predicate {@code p} return a list of all elements that satisfy {@code p}
     * @param p predicate to satisfy
     * @return list of elements in this that satisfy {@code p}
     */
    public List<T> filter(Predicate<T> p){
        if (nil()) return this;
        return p.test(hd) ? tl.filter(p).cons(hd)
                            : tl.filter(p);
    }

    /**
     * Return the length of this list
     * @return total number of non-nil nodes in this list
     */
    public int length(){
        return hd == null? 0 : 1 + tl.length();
    }

    /**
     * A predicate that tests if this list is empty (i.e., hd == null)
     * @return hd == null;
     */
    public boolean nil(){
        return hd == null;
    }

    /**
     * Take the first {@code min(n, length())} elements of the list
     * @param n number of elements to take
     * @return the list of values
     */
    public List<T> take(int n){
        if (n < 1) return new List<>(); // empty list
        if (nil()) return new List<>(); // empty list
        return take(n - 1).cons(hd);
    }

    /**
     * Given a predicate {@code p}, take contiguous block of elements that satisfy
     * {@code p}
     * @param p predicate to satisfy
     * @return first and largest contiguous block of elements that satisfy {@code p}
     */
    public List<T> takeWhile(Predicate<T> p){
        if (nil()) return this;
        return p.test(hd) ? tl.takeWhile(p).cons(hd) : new List<>();
    }

    /**
     * Check if this list equals another list
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof List<?>) {
            List<?> other = (List<?>) obj;
            if (nil()) {
                return other.nil();
            }
            return !other.nil() && tl.equals(other.tl);
        }
        return false;
    }

    public String toString(){
        if (hd == null) return "[]";
        StringBuilder sb = new StringBuilder("[" + hd);
        tl.toStringHelper(sb);
        return sb.toString();
    }

    private void toStringHelper(StringBuilder sb){
        if (hd == null){
            sb.append("]");
        } else{
            sb.append("," + hd);
            tl.toStringHelper(sb);
        }
    }


    /* Collection API */


    @Override
    public int size() {
        return length();
    }

    @Override
    public boolean isEmpty() {
        return nil();
    }

    @Override
    public boolean contains(Object o) {
        return !nil() && (hd.equals(o) || tl.contains(o));
    }

    @Override
    public Iterator iterator() {
        return new ListIter(this);
    }

    @Override
    public Object[] toArray() {
        return toArrayHelper(0);
    }
    protected Object[] toArrayHelper(int size){
        if (nil()){
            // Create new array
            Object[] result = new Object[size];
            return result;
        }
        Object[] result = tl.toArrayHelper(size + 1);
        result[size] = hd;
        return result;
    }

    @Override
    public boolean add(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection c) {
        throw new UnsupportedOperationException();
    }

    /**
     * TODO
     * @param c
     * @return
     */
    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    /**
     * TODO
     * @param a
     * @return
     */
    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}
