package com.petrov;

import java.util.LinkedList;
import java.util.List;

public class Main3 {
    public static void main(String[] args) {
        TwoSideLinkedListImpl<Integer> list = new TwoSideLinkedListImpl<>();
        list.insertLast(111);
        list.insertLast(222);
        list.insertLast(333);
        list.insertLast(444);
        list.insertLast(555);
        list.removeLast();

        System.out.println(list);

        //1. Реализовать цикл forEach для простого связанного списка
        for (Integer digit : list){
            System.out.println(digit+" Element");
        }
        System.out.println();


        // для проверки
        List<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(555);

        //2. Реализовать Deque на основе двунаправленного списка
        LinkedDequeImpl<Integer> ldi = new LinkedDequeImpl<>();
        ldi.addLast(1);
        ldi.addLast(2);
        ldi.addFirst(222);
        ldi.add(123);
        ldi.offerFirst(333);
        ldi.offerLast(555);
        ldi.addLast(4);
        ldi.addLast(5);
        ldi.addFirst(3);

        ldi.retainAll(linkedList);

        for (Integer digit : ldi) {
            System.out.println(digit + " Element");
        }
    }
}
