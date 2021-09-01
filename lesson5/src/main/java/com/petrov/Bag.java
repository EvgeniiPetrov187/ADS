package com.petrov;

import java.util.List;

//2. Написать программу «Задача о рюкзаке» с помощью рекурсии.
public class Bag {

    private final List<Item> myBag;

    public Bag(List<Item> myBag) {
        this.myBag = myBag;
    }

    public int orderBag(int i, int maxWeight) {
        if (i < 0) {
            return 0;
        }
        if (myBag.get(i).getWeight() > maxWeight) {
            return orderBag(i - 1, maxWeight);
        } else {
            return Math.max(orderBag(i - 1, maxWeight), orderBag(i - 1, maxWeight - myBag.get(i).getWeight()) + myBag.get(i).getPrice());
        }
    }
}
