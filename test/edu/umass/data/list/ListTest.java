package edu.umass.data.list;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ListTest {
    List<Integer> nil = new List<>();
    List<Integer> l1  = new List<>(new Integer[] {0,1,2,3});
    List<Integer> l2  = new List<>(new Integer[] {0,1,2,3,4,5,6,7});
    @Before
    public void setUp(){

    }
    @Test
    public void testCons01(){
        List<Integer> l = nil.cons(1);
        assertEquals((Integer)1, (Integer)l.head);
    }
    @Test
    public void testCons02(){
        List<Integer> l = nil.cons(1).cons(2);
        assertEquals((Integer)2, l.head);
        assertEquals((Integer)1, l.tail.head);
        assertEquals(null, l.tail.tail.head);
    }
    @Test
    public void testCons03(){
        List<Integer> l = nil.cons(1).cons(2).cons(3);
        assertEquals((Integer)3, l.head);
        assertEquals((Integer)2, l.tail.head);
        assertEquals((Integer)1, l.tail.tail.head);
        assertEquals(null, l.tail.tail.tail.head);
    }

    @Test
    public void testEquals01(){
        List<Integer> l = nil.cons(3).cons(2).cons(1).cons(0);
        assertEquals(l, l1);
        assertEquals(l1, l);
    }

    @Test
    public void testEquals02(){
        List<Integer> l = nil.cons(3).cons(2).cons(1).cons(0).cons(0);
        assertNotEquals(l, l1);
        assertNotEquals(l1, l);
    }


    @Test
    public void testMap01(){
        assertEquals(
                new List<>(new Integer[] {1,2,3,4}),
                l1.map(i -> i+1));
    }

    @Test
    public void testMap02(){
        assertEquals(
                new List<>(new Integer[] { 0, -1 ,-2 ,-3}),
                l1.map(i -> -i));
    }

    @Test
    public void testMap03(){
        assertEquals(
                new List<>(new String[] {"0", "-1", "-2", "-3"}),
                l1.map(i -> i.toString())
        );
    }

    @Test
    public void testSize01(){
        assertEquals(0, nil.size());
    }

    @Test
    public void testSize02(){
        assertEquals(4, l1.size());
    }
}