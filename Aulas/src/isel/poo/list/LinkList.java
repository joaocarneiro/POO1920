package isel.poo.list;

import java.util.Iterator;

public class LinkList<T> implements Iterable<T> {

    private static class Node<U> {
        U elem;
        Node<U> next;
        public Node(U e) { elem=e; }
    }
    private Node<T> first;

    public void add(T elem) {
        if (first==null)
            first = new Node<>(elem);
        else {
            //TODO
        }
    }

    @Override
    public Iterator<T> iterator() {
        //TODO
        return null;
    }
}
