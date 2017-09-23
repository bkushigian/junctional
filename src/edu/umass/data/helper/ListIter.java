package edu.umass.data.helper;
import edu.umass.data.list.List;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Optional;

public class ListIter<E> implements Iterator<E> {

    private List xs;

    public ListIter(List<E> xs){
        if (xs == null){
            throw new NullPointerException("Cannot iterate over null, silly");
        }
        this.xs = xs;
    }

    @Override
    public boolean hasNext() {
        return !xs.nil();
    }

    @Override
    public E next() {
        Optional<E> hd = xs.head();
        if (hd.isPresent()){
            xs = (List<E>)xs.tail().get();
            return (E)hd.get();
        }
        throw new NoSuchElementException();
    }
}
