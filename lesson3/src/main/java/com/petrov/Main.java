package com.petrov;

import java.util.Deque;

public class Main {
    public static void main(String[] args) {

        // 1. Дан массив из n элементов, начиная с 1. Каждый следующий элемент равен (предыдущий + 1).
        // Но в массиве гарантированно 1 число пропущено. Необходимо вывести на экран пропущенное число.
        int[] arr = {1, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        MissionOne.searchDigit(arr);


        //2. Создать класс для реализации Deque.
        DequeImpl<Integer> deque = new DequeImpl<>(15);
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        deque.addLast(4);
        deque.addLast(5);
        deque.addLast(6);
        deque.addLast(7);
        deque.addFirst(54);
        System.out.println(deque);

        DequeImpl<Integer> d = new DequeImpl<>(5);
        d.addLast(1);
        d.addLast(3);
        d.addLast(4);
        System.out.println(d);

        deque.retainAll(d);

        System.out.println(deque);
    }
}
