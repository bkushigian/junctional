package edu.umass.data.list;
/**
 * Tests against the ListUtil class. NOTE that all static methods from
 * ListUtil are pulled into this namespace so that we can use map(f, xs)
 * instead of ListUtil.map(f,xs). This is normally not a good idea but in
 * the context of functional programming these are canonical functions
 * and having to qualify them defeats the elegance that is garnered by
 * their use.
 */

import org.junit.Test;

import static org.junit.Assert.*;
import static edu.umass.data.list.ListUtil.*;

public class ListUtilTest {
    List<Integer> nil = new List<>();
    List<Integer> l1  = new List<>(new Integer[] {0,1,2,3});
    List<Integer> l2  = new List<>(new Integer[] {0,1,2,3,4,5,6,7});

    @Test
    public void testIntersperes(){
        List<Integer> expected = new List<Integer>(new Integer[] {0,1,0,1,0});
        List<Integer> xs       = new List<Integer>(new Integer[] {0,0,0});
        List<Integer> actual   = intersperse(1, xs);
        assertEquals(expected, actual);
    }

    @Test
    public void testConcat(){
        List<Integer> expected = range(0,8);
        List<Integer> left     = range(0,4);
        List<Integer> right    = range(4,8);
        List<Integer> actual   = concat(left, right);
        assertEquals(expected,actual);
    }

    @Test
    public void testFlatten(){
        List<Integer> l1 = range(0,3);
        List<Integer> l2 = range(3,6);
        List<Integer> l3 = range(6,9);
        List<List<Integer>> toFlatten = new List<List<Integer>>()
                .cons(l3)
                .cons(l2)
                .cons(l1);
        List<Integer> expected = range(9);
        List<Integer> actual = flatten(toFlatten);
        assertEquals(expected,actual);
    }

    @Test
    public void testMap(){
        List<Integer> expected = new List<>(new Integer[] {1,2,3,4});
        List<Integer> actual   = map((x -> x + 1), l1);
        assertEquals(expected, actual);
    }

    @Test
    public void testSize(){
        assertEquals(4, size(l1));
    }

    @Test
    public void testNil(){
        assertTrue(nil.nil());
    }

    @Test
    public void testFoldr(){
        Integer actual = foldr((x,y) -> {return x * y;}, 1, range(1,10));
        Integer expected = 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2;
        assertEquals(expected,actual);
    }

}