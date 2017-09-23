package edu.umass.data.tuple;

public class Pair<U,V> {
    public final U fst;
    public final V snd;
    public Pair(U fst, V snd){
        if (fst == null){
            throw new NullPointerException("Pair() received null for fst");
        } if (snd == null){
            throw new NullPointerException("Pair() received null for snd");
        }
        this.fst = fst;
        this.snd = snd;
    }
}
