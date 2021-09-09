package com.petrov;

public interface Tree<E extends Comparable<? super E>> extends Comparable<Tree<Integer>> {

    enum TraversMode {
        IN_ORDER, PRE_ORDER, POST_ORDER
    }

    boolean add(E value);

    boolean contains(E value);

    boolean remove(E value);

    boolean isEmpty();

    int size();

    void display();

    void traverse(TraversMode mode);

    Node<E> getRoot();

    int getSize();
}
