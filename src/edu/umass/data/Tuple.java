package edu.umass.data;

public class Tuple<U,V> {
    public final U fst;
    public final V snd;
    public Tuple(U fst, V snd){
        if (fst == null){
            throw new NullPointerException("Tuple() received null for fst");
        } if (snd == null){
            throw new NullPointerException("Tuple() received null for snd");
        }
        this.fst = fst;
        this.snd = snd;
    }
}
