package isel.poo.list;

import java.util.Iterator;

public class LinkList<T> implements Iterable<T> {

    private Node<T> first;

    public void add(T elem) {
        if (first == null)
            first = new Node<>(elem);
        else {
            Node<T> cur = first;
            while (cur.next != null) cur = cur.next;
            cur.next = new Node<>(elem);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> cur = first;

            @Override
            public boolean hasNext() {
                return cur != null;
            }

            @Override
            public T next() {
                Node<T> e = cur;
                cur = cur.next;
                return e.elem;
            }
        };
    }

    private static class Node<U> {
        U elem;
        Node<U> next;

        Node(U e) {
            elem = e;
        }
    }
}
