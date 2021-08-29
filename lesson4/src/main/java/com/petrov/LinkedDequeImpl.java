package com.petrov;

import java.util.*;

//2. Реализовать Deque на основе двунаправленного списка
public class LinkedDequeImpl<E> implements Deque<E> {

    private final TwoSideLinkedList<E> data;

    public LinkedDequeImpl() {
        this.data = new TwoSideLinkedListImpl<>();
    }

    @Override
    public void addFirst(E e) {
        data.insertFirst(e);
    }

    @Override
    public void addLast(E e) {
        data.insertLast(e);
    }

    @Override
    public boolean offerFirst(E e) {
        data.insertFirst(e);
        return true;
    }

    @Override
    public boolean offerLast(E e) {
        data.insertLast(e);
        return true;
    }

    @Override
    public E removeFirst() {
        if (data.isEmpty()) {
            throw new NoSuchElementException();
        } else {
            return data.removeFirst();
        }
    }

    @Override
    public E removeLast() {
        if (data.isEmpty()) {
            throw new NoSuchElementException();
        } else {
            return data.removeLast();
        }
    }

    @Override
    public E pollFirst() {
        if (data.isEmpty()) {
            return null;
        } else {
            return data.removeFirst();
        }
    }

    @Override
    public E pollLast() {
        if (data.isEmpty()) {
            return null;
        } else {
            return data.removeLast();
        }
    }

    @Override
    public E getFirst() {
        if (data.isEmpty()) {
            throw new NoSuchElementException();
        } else {
            return data.getFirst();
        }
    }

    @Override
    public E getLast() {
        if (data.isEmpty()) {
            throw new NoSuchElementException();
        } else {
            return data.getLast();
        }
    }

    @Override
    public E peekFirst() {
        if (data.isEmpty()) {
            return null;
        } else {
            return data.getFirst();
        }
    }

    @Override
    public E peekLast() {
        if (data.isEmpty()) {
            return null;
        } else {
            return data.getLast();
        }
    }

    @Override
    public boolean removeFirstOccurrence(Object o) {
        if (data.isEmpty()) {
            return false;
        } else {
            remove(o);
            return true;
        }
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        if (data.isEmpty()) {
            return false;
        } else {
            for (int i = data.size() - 1; i >= 0; i--) {
                if (o.equals(data.toArray()[i])) {
                    data.removeLastOccurrence((E) o);
                    return true;
                }
            }
            return false;
        }
    }

    @Override
    public boolean add(E e) {
        addLast(e);
        return true;
    }

    @Override
    public boolean offer(E e) {
        addLast(e);
        return true;
    }

    @Override
    public E remove() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            return removeLast();
        }
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        } else {
            return data.removeLast();
        }
    }

    @Override
    public E element() {
        return getFirst();
    }

    @Override
    public E peek() {
        return peekFirst();
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        int count = 0;
        for (int i = 0; i < c.size(); i++) {
            addLast((E) c.toArray()[i]);
            count++;
        }
        return count == c.size();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean isFound = false;
        for (int i = 0; i < c.size(); i++) {
            for (int j = 0; j < data.size(); j++) {
                if (c.toArray()[i].equals(data.toArray()[j])) {
                    remove(data.toArray()[j]);
                    isFound = true;
                }
            }
        }
        return isFound;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean isFound = false;
        Object[] temp = data.toArray().clone();
        int tempSize = data.size();
        for (int i = 0; i < c.size(); i++) {
            isFound = false;
            for (int j = 0; j < tempSize - 1; j++) {
                if (c.toArray()[i].equals(temp[j])) {
                    isFound = true;
                }
                if (isFound) {
                    temp[j] = temp[j + 1];
                }
            }
            tempSize--;
        }

        for (int i = 0; i < tempSize; i++) {
            remove(temp[i]);
        }
        return isFound;
    }


    @Override
    public void clear() {
        Object[] temp = data.toArray().clone();
        removeAll(Arrays.asList(temp));
    }

    @Override
    public void push(E e) {
        getLast();
    }

    @Override
    public E pop() {
        if (data.isEmpty()) {
            return null;
        } else {
            return getLast();
        }
    }

    @Override
    public boolean remove(Object o) {
        try {
            data.remove((E) o);
            return true;
        } catch (ClassCastException | NoSuchElementException e) {
            return false;
        }
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        int count = 0;
        for (int i = 0; i < data.size(); i++) {
            for (int j = 0; j < c.size(); j++)
                if (c.toArray()[j].equals(data.toArray()[i])) {
                    count++;
                }
        }
        return count == c.size();
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < data.size(); i++) {
            if (o.equals(data.toArray()[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return data.iterator();
    }

    @Override
    public Object[] toArray() {
        return data.toArray();
    }


    @Override
    public <T> T[] toArray(T[] a) {
        return a;
    }

    @Override
    public Iterator<E> descendingIterator() {
        return data.descIterator();
    }
}
