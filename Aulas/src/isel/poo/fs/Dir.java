package isel.poo.fs;

import java.util.Iterator;

public class Dir extends Entry implements Iterable<Entry> {
    /*
    private static final int MAX_ENTRIES = 100;
    private Entry[] entries = new Entry[MAX_ENTRIES];
    private int numOfEntries=0;
    */
    private Entry first;

    public Dir(String name) { super(name); }

    public void add(Entry entry) {
        //entries[numOfEntries++]=entry;
        if (first == null) first = entry;
        else {
            Entry cur = first;
            while( cur.next != null )  cur = cur.next;
            cur.next = entry;
        }
        entry.parent = this;
    }

    @Override
    public Iterator<Entry> iterator() {
        return new Iterator<Entry>() {
            //private int idx = 0;
            private Entry cur = first;
            @Override
            //public boolean hasNext() { return idx<numOfEntries; }
            public boolean hasNext() { return cur!=null; }
            @Override
            //public Entry next() { return entries[idx++]; }
            public Entry next() { Entry e=cur; cur=cur.next; return e; }
        };
    }

    @Override
    public int getSize() {
        int size = 0;
        for (Entry e : this) size+=e.getSize();
        return size;
    }
    @Override
    public String getTree() {
        StringBuilder res = new StringBuilder(super.getTree()).append('{');
        if (first!=null) {
            res.append(first.getTree());
            for(Entry e = first.next ; e!=null ; e=e.next )
                res.append(';').append(e.getTree());
        }
        return res.append('}').toString();
    }
}
