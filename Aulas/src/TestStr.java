import isel.poo.Str;

import java.util.Iterator;

public class TestStr {
    public static void main(String[] args) {
        Str a = new Str("abc");
        System.out.println(a + "[1]" + a.charAt(1));
        a.setCharAt('o',1);
        Str b = new Str(a);
        System.out.println(b);
        System.out.println(b.equals(b));
        System.out.println(b.equals(null));
        System.out.println(b.equals(new Str("abc")));
        System.out.println(b.equals("aoc"));
        if (a.equals(b)) System.out.println("Iguais.");
        System.out.println(a.hashCode()+"=="+b.hashCode());
        for (int i = 0; i < 10; i++)
            a.append("xpto");
        System.out.println(a+" , len="+a.length());

        printUpper("abc");
        printUpper(b);
        /*
        Iterator<Character> it = b.iterator();
        while( it.hasNext() ) {
            char e = it.next();
            System.out.println(e);
        }
         */
        for(char e : b) System.out.println(e);
    }

    private static void printUpper(CharSequence s) {
        for (int i = 0; i < s.length(); i++)
            System.out.print( Character.toUpperCase(s.charAt(i)));
        System.out.println();
    }
}
