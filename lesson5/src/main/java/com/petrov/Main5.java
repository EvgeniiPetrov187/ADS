package com.petrov;

import java.util.LinkedList;
import java.util.List;

public class Main5 {
    public static void main(String[] args) {

        // 1. Написать программу по возведению числа в степень с помощью рекурсии.
        System.out.println("Результат: " + MissionRecursion.multiple(4, 3));

        // 2. Написать программу «Задача о рюкзаке» с помощью рекурсии.
        List<Item> list = new LinkedList<>();
        list.add(new Item("Pen", 10, 1));
        list.add(new Item("Ball", 150, 5));
        list.add(new Item("Laptop", 1000, 7));
        list.add(new Item("Gold", 2000, 1));
        list.add(new Item("Nuts", 100, 2));
        Bag bag = new Bag(list);
        int maxWeight = 10;

        System.out.println("Стоимость украденного: " + bag.orderBag(list.size() - 1, maxWeight));

    }
}
