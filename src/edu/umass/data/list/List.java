package edu.umass.data.list;

import java.lang.StringBuilder;
import java.util.function.Function;

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

    public List(T head){
        if (head == null) throw new NullPointerException();
        this.head = head;
        tail = new List<T>();
    }

    public List(T head, List<T> tail){
        if (head == null) throw new NullPointerException();
        if (tail  == null) throw new NullPointerException();
        this.head = head;
        this.tail = tail;
    }

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

    public List<T> cons(T val) {
        return new List<>(val, this);
    }

    /*
     * Some Helper Methods
     */

    public <Y> List<Y> map(Function<T, Y> f){
        if (nil()) return new List<Y>();
        return tail.map(f).cons(f.apply(head));
    }

    public int size(){
        return head == null? 0 : 1 + tail.size();
    }

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
