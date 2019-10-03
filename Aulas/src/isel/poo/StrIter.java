package isel.poo;

import java.util.Iterator;

public class StrIter implements Iterator<Character> {
    private int idx = 0;
    private Str obj;

    public StrIter(Str s) { obj =s; }

    @Override
    public boolean hasNext() {
        return  idx < obj.length();
    }

    @Override
    public Character next() {
        return obj.charAt(idx++);
    }
}
