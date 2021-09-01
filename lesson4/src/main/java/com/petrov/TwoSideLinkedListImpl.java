package com.petrov;

import java.util.Iterator;
import java.util.LinkedList;

public class TwoSideLinkedListImpl<E> extends SimpleLinkedListImpl<E> implements TwoSideLinkedList<E> {

    protected Node<E> lastElement;

    @Override
    public void insertFirst(E value) {
        super.insertFirst(value);
        if (size == 1) {
            lastElement = firstElement;
        }
    }

    @Override
    public void insertLast(E value) {
        Node<E> newNode = new Node<>(value, null, lastElement);

        if (isEmpty()) {
            insertFirst(value);
            return;
        }

        lastElement.next = newNode;
        newNode.previous = lastElement;
        lastElement = newNode;
        size++;
    }

    @Override
    public E getLast() {
        return getValue(lastElement);
    }


    @Override
    public E removeFirst() {
        E removedValue = super.removeFirst();

        if (isEmpty()) {
            lastElement = null;
        }

        return removedValue;
    }

    public E removeLast() {
        if (isEmpty()) {
            return null;
        }

        Node<E> removedNode = lastElement;
        lastElement = lastElement.previous;
        lastElement.next = null;
        size--;

        return removedNode.item;
    }

    @Override
    public boolean remove(E value) {
        Node<E> current = firstElement;
        Node<E> previous = null;

        while (current != null) {
            if (current.item.equals(value)) {
                break;
            }
            previous = current;
            current = current.next;
        }

        if (current == null) {
            return false;
        } else if (current == firstElement) {
            removeFirst();
            return true;
        } else if (current == lastElement) {
            lastElement = previous;
            previous.next = null;
        } else {
            previous.next = current.next;
        }

        current.next = null;
        size--;

        return true;
    }

    public boolean removeLastOccurrence(E value) {
        Node<E> current = lastElement;
        Node<E> temp = null;

        while (current != null) {
            if (current.item.equals(value)) {
                break;
            }
            temp = current;
            current = current.previous;
        }

        if (current == null) {
            return false;
        } else if (current == lastElement) {
            removeLast();
            return true;
        } else if (current == firstElement){
            firstElement = temp;
            temp.previous = null;
        } else {
            temp.previous = current.previous;
        }

        current.previous = null;
        size--;

        return true;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        for (Node<E> element = firstElement; element != null; element = element.next)
            result[i++] = element.item;
        return result;
    }

    @Override
    public Iterator<E> descIterator() {
        return new LinkedDescListIterator<>();
    }

    public class LinkedDescListIterator<E> implements Iterator<E> {

        @Override
        public boolean hasNext() {
            return lastElement != null;
        }

        @Override
        public E next() {
            Node<E> element = (Node<E>) lastElement;
            lastElement = lastElement.previous;
            return element.item;
        }

        @Override
        public void remove() {
            lastElement = null;
        }
    }

}
