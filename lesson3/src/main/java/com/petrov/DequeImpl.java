package com.petrov;

import java.util.*;

//2. Создать класс для реализации Deque.
public class DequeImpl<E> implements Deque<E> {

    private final int TAIL_DEFAULT = -1;
    private final int HEAD_DEFAULT = 0;
    protected int size;
    protected final E[] data;

    protected int tail;
    protected int head;

    public DequeImpl(int maxSize) {
        this.data = (E[]) new Object[maxSize];
        head = HEAD_DEFAULT;
        tail = TAIL_DEFAULT;
    }

    @Override
    public void addFirst(E e) {
        for (int i = size - 1; i >= 0; i--) {
            data[i + 1] = data[i];
        }
        data[head] = e;
        size++;
    }

    @Override
    public void addLast(E e) {
        size++;
        data[size - 1] = e;
    }

    @Override
    public boolean offerFirst(E e) {
        if (data.length == size) {
            return false;
        } else {
            for (int i = size - 1; i >= 0; i--) {
                data[i + 1] = data[i];
            }
            data[head] = e;
            size++;
            return true;
        }
    }

    @Override
    public boolean offerLast(E e) {
        if (data.length == size) {
            return false;
        }
        size++;
        data[size - 1] = e;
        return true;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            E temp = data[head];
            for (int i = 0; i < size - 1; i++) {
                data[i] = data[i + 1];
            }
            data[size - 1] = null;
            size--;
            return temp;
        }
    }

    @Override
    public E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            E temp = data[size - 1];
            data[size - 1] = null;
            size--;
            return temp;
        }
    }

    @Override
    public E pollFirst() {
        if (isEmpty()) {
            return null;
        } else {
            E temp = data[head];
            for (int i = 0; i < size - 1; i++) {
                data[i] = data[i + 1];
            }
            data[size - 1] = null;
            size--;
            return temp;
        }
    }

    @Override
    public E pollLast() {
        if (isEmpty()) {
            return null;
        } else {
            E temp = data[size - 1];
            data[size - 1] = null;
            size--;
            return temp;
        }
    }

    @Override
    public E getFirst() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return data[head];
    }

    @Override
    public E getLast() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return data[size - 1];
    }

    @Override
    public E peekFirst() {
        if (size == 0) {
            return null;
        }
        return data[head];
    }

    @Override
    public E peekLast() {
        if (size == 0) {
            return null;
        }
        return data[size - 1];
    }

    @Override
    public boolean removeFirstOccurrence(Object o) {
        boolean isFound = false;
        for (int i = 0; i < size - 1; i++) {
            if (data[i].equals(o)) {
                isFound = true;
            }
            if (isFound) {
                data[i] = data[i + 1];
            }
        }
        removeLast();
        return isFound;
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        boolean isFound = false;
        for (int i = size - 1; i > 0; i--) {
            if (data[i].equals(o)) {
                isFound = true;
            }
            if (isFound) {
                data[i] = data[i - 1];
            }
        }
        removeFirst();
        return isFound;
    }

    @Override
    public boolean add(E e) {
        if (data.length == size) {
            return false;
        }
        size++;
        data[size - 1] = e;
        return true;
    }

    @Override
    public boolean offer(E e) {
        if (data.length == size) {
            return false;
        }
        size++;
        data[size - 1] = e;
        return true;
    }

    @Override
    public E remove() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            E temp = data[size - 1];
            data[size - 1] = null;
            size--;
            return temp;
        }
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        } else {
            E temp = data[size - 1];
            data[size - 1] = null;
            size--;
            return temp;
        }
    }

    @Override
    public E element() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return data[head];
    }

    @Override
    public E peek() {
        if (size == 0) {
            return null;
        }
        return data[head];
    }


    @Override
    public boolean addAll(Collection<? extends E> c) {
        try {
            for (int i = 0; i < c.size(); i++) {
                addLast(new ArrayList<>(c).get(i));
            }
        } catch (RuntimeException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        try {
            for (int i = 0; i < c.size(); i++) {
                removeFirstOccurrence(c.toArray()[i]);
            }
        } catch (RuntimeException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        E[] temp = data.clone();
        int tempSize = size;
        boolean isFound = false;

        for (int j = 0; j < c.size(); j++) {
            isFound = false;
            for (int i = 0; i < tempSize; i++) {

                if (temp[i].equals(c.toArray()[j])) {
                    isFound = true;
                }
                if (isFound) {
                    temp[i] = temp[i + 1];
                }
            }
            temp[tempSize - 1] = null;
            tempSize--;
        }

        for (int i = 0; i < tempSize; i++) {
            removeFirstOccurrence(temp[i]);
        }
        return isFound;
    }


    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
    }

    @Override
    public void push(E e) {
        data[++tail] = e;
    }

    @Override
    public E pop() {
        if (size == 0) {
            return null;
        }
        return data[size - 1];
    }

    @Override
    public boolean remove(Object o) {
        boolean isFound = false;
        for (int i = 0; i < size - 1; i++) {
            if (data[i].equals(o)) {
                removeFirstOccurrence(o);
                isFound = true;
            }
        }
        if (data[size - 1].equals(o)) {
            removeLast();
        }
        return isFound;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (data[i].equals(c.toArray()[i])) {
                count++;
            }
        }
        return count == c.size();
    }

    @Override
    public boolean contains(Object o) {
        boolean isFound = false;
        for (int i = 0; i < size; i++) {
            if (data[i].equals(o)) {
                isFound = true;
                break;
            }
        }
        return isFound;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return Arrays.stream(data).iterator();
    }

    @Override
    public Object[] toArray() {
        return data;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return a;
    }

    @Override
    public Iterator<E> descendingIterator() {
        E[] descData = (E[]) new Object[size];
        int count = 0;
        for (int i = size - 1; i >= 0; i++) {
            data[i] = descData[count];
            count++;
        }
        return Arrays.stream(descData).iterator();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = head; i <= size - 1; i++) {
            sb.append(data[i]);
            if (i != size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
