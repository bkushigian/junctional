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

}