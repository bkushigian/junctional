package edu.umass.data.list;

import java.util.function.Function;

public class Driver extends ListUtil{

    public static void main(String[] args){
        List<Integer> ll = new List<>();
        System.out.println(ll.toString());

        ll = ll.cons(3);
        System.out.println(ll.toString());

        ll = ll.cons(2);
        System.out.println(ll.toString());

        ll = ll.cons(1);
        System.out.println(ll.toString());


        ll = map(i -> i + 1, ll);
        System.out.println(ll.toString());
    
        ll = range(32);
        System.out.println(ll);

        System.out.println(filter(x -> x % 2 == 0, ll));

    }

}
