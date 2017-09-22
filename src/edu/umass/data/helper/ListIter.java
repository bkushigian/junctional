package edu.umass.data.helper;
import edu.umass.data.Just;
import edu.umass.data.List;
import edu.umass.data.Maybe;

import java.util.Iterator;
import java.util.NoSuchElementException;

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
        Maybe<E> maybe = xs.head();
        if (maybe.isNothing()){
            throw new NoSuchElementException();
        }
        xs = ((Just<List<E>>)xs.tail()).fromJust();
        return ((Just<E>)maybe).fromJust();
    }
}
