import isel.poo.list.LinkList;

import java.util.Iterator;

public class TestList {
    public static void main(String[] args) {
        LinkList<String> names = new LinkList<String>();
        names.add("abc");
        names.add("xpto");
        /*
        Iterator<String> it = names.iterator();
        while( it.hasNext() )
            System.out.println( it.next() );
         */
        for(String s : names)
            System.out.println(s);
        LinkList<Integer> values = new LinkList<>();
        for (int i = 0; i <10 ; i++) values.add(i);
        for(Integer val : values)
            System.out.println(val);
    }
}
