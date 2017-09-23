package edu.umass.data.tuple;

public class Tuple2<U,V> {
    public final U fst;
    public final V snd;
    public Tuple2(U fst, V snd){
        if (fst == null){
            throw new NullPointerException("Tuple2() received null for fst");
        } if (snd == null){
            throw new NullPointerException("Tuple2() received null for snd");
        }
        this.fst = fst;
        this.snd = snd;
    }
}
