package edu.umass.data.list;

import org.junit.Test;

import static org.junit.Assert.*;

public class ListUtilTest {
    List<Integer> nil = new List<>();
    List<Integer> l1  = new List<>(new Integer[] {0,1,2,3});
    List<Integer> l2  = new List<>(new Integer[] {0,1,2,3,4,5,6,7});

    @Test
    public void testIntersperes(){
        List<Integer> expected = new List<Integer>(new Integer[] {0,1,0,1,0});
        List<Integer> xs       = new List<Integer>(new Integer[] {0,0,0});
        List<Integer> actual   = ListUtil.intersperse(1, xs);
        assertEquals(expected, actual);
    }

    @Test
    public void testConcat(){
        List<Integer> expected = l2;
        List<Integer> left     = new List<>(new Integer[] {0,1,2,3});
        List<Integer> right    = new List<>(new Integer[] {4,5,6,7});
        List<Integer> actual   = ListUtil.concat(left, right);
        assertEquals(left, right);
    }

    @Test
    public void testFlatten(){
        List<Integer> l1 = ListUtil.range(0,3);
        List<Integer> l2 = ListUtil.range(3,6);
        List<Integer> l3 = ListUtil.range(6,9);
        List<List<Integer>> toFlatten = new List<List<Integer>>()
                .cons(l3)
                .cons(l2)
                .cons(l1);
        List<Integer> expected = ListUtil.range(9);
        List<Integer> actual = ListUtil.flatten(toFlatten);
        assertEquals(expected,actual);
    }

}