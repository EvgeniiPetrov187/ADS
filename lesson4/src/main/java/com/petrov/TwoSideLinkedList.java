package com.petrov;

import java.util.Iterator;

public interface TwoSideLinkedList<E> extends LinkedList<E> {

    void insertLast(E value);

    E removeLast();

    E getLast();

    Object[] toArray();

    Iterator<E> descIterator();

    boolean removeLastOccurrence(E value);

}
