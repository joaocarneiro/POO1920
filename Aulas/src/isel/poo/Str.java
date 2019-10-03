package isel.poo;

import java.util.Iterator;

public class Str extends Object implements CharSequence, Iterable<Character> {
    private static final int INIT_SIZE = 32;
    private char[] txt;
    private int len;

    public Str(String s) {
        len = s.length();
        txt = new char[calcSize(len)];
        s.getChars(0,len,txt,0);
    }

    public Str(Str a) {
        //this(a.toString());
        len = a.len;
        txt = new char[a.txt.length];
        System.arraycopy(a.txt,0,txt,0,len);
    }

    private int calcSize(int minLen) {
        int size = txt==null ? INIT_SIZE : txt.length;
        while (size<minLen) size<<=1;
        return size;
    }

    @Override
    public String toString() {
        return new String(txt,0,len);
    }
    @Override
    public char charAt(int idx) {
        return txt[idx];
    }
    @Override
    public CharSequence subSequence(int start, int end) {
        return null;
    }

    public void setCharAt(char c, int idx) {
        txt[idx] = c;
    }

    public void append(String s) {
        final int nlen = len + s.length();
        if ( nlen > txt.length) {
            int size = calcSize(nlen);
            char[] ntxt = new char[size];
            System.arraycopy(txt,0,ntxt,0,len);
            txt = ntxt;
        }
        s.getChars(0,s.length(),txt,len);
        len = nlen;
    }
    @Override
    public int length() {
        return len;
    }

    @Override
    public boolean equals(Object obj) {
        if (this==obj) return true;
        if (!(obj instanceof Str)) return false;
        Str other = (Str) obj;
        if (len!=other.len) return false;
        for (int i = 0; i < len; i++)
            if (txt[i]!=other.txt[i]) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int h = 0;
        for (int i = 0; i < len; i++)
            h = h * 31 + txt[i];
        return h;
    }

    /*
    private static class Iter implements Iterator<Character> {
        private int idx = 0;
        private Str obj;

        public Iter(Str s) { obj =s; }

        @Override
        public boolean hasNext() {
            return  idx < obj.len;
        }

        @Override
        public Character next() {
            return obj.txt[idx++];
        }
    }
    */
    /*
    private class Iter implements Iterator<Character> {
        private int idx = 0;
        @Override
        public boolean hasNext() { return  idx < len; }
        @Override
        public Character next() { return txt[idx++]; }
    }
    */
    @Override
    public Iterator<Character> iterator() {
        //return new StrIter(this);
        //return new Iter(this);
        /*
        class Iter implements Iterator<Character> {
            private int idx = 0;
            @Override
            public boolean hasNext() { return  idx < len; }
            @Override
            public Character next() { return txt[idx++]; }
        }
        return new Iter();
        */
        return new Iterator<Character>() {
            private int idx = 0;
            @Override
            public boolean hasNext() {return idx<len;}
            @Override
            public Character next() {return txt[idx++];}
        };
    }
}
