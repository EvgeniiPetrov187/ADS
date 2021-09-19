package com.petrov;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HashTableChain<K, V> implements HashTable<K, V> {

    protected ItemWithNext<K, V> firstElement;

    private int size;

    private List<ItemWithNext<K, V>> list = new ArrayList<>();

    private int listSize;


    public HashTableChain() {

        listSize = 10;
        size = 0;

        for (int i = 0; i < listSize; i++) {
            list.add(null);
        }
    }

    static class ItemWithNext<K, V> implements Entry<K, V> {
        private final K key;
        private V value;
        private ItemWithNext<K, V> next;

        public ItemWithNext(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public void setValue(V value) {
            this.value = value;
        }

        public ItemWithNext<K, V> getNext() {
            return next;
        }

        public void setNext(ItemWithNext<K, V> next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Item{" + "key=" + key + ", value=" + value + '}';
        }

    }


    @Override
    public boolean put(K key, V value) {
        int index = getIndex(key);

        ItemWithNext<K, V> head = list.get(index);
        ItemWithNext<K, V> newItem = new ItemWithNext<>(key, value);

        if (head == null) {
            list.set(index, newItem);

        } else {

            while (head != null) {
                if (head.key.equals(key)) {
                    head.value = value;
                    size++;
                    break;
                }
                head = head.next;
            }
            if (head == null) {
                head = list.get(index);
                newItem.next = head;
                list.set(index, newItem);
                size++;
            }
        }

        if ((1.0 * size) / listSize > 0.7) {
            List<ItemWithNext<K, V>> temp = list;
            list = new ArrayList<>();
            listSize = listSize * 2;

            for (int i = 0; i < listSize; i++) {
                list.add(null);
            }
            for (ItemWithNext<K, V> item : temp) {
                while (item != null) {
                    put(item.key, item.value);
                    item = item.next;
                }
            }
        }
        return true;
    }

    @Override
    public V get(K key) {
        int index = getIndex(key);
        ItemWithNext<K, V> head = list.get(index);
        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    @Override
    public V remove(K key) {
        int index = getIndex(key);
        ItemWithNext<K, V> head = list.get(index);
        if (head == null) {
            return null;
        }
        if (head.key.equals(key)) {
            V val = head.value;
            head = head.next;
            list.set(index, head);
            size--;
            return val;
        } else {
            ItemWithNext<K, V> prev = null;
            while (head != null) {

                if (head.key.equals(key)) {
                    prev.next = head.next;
                    size--;
                    return head.value;
                }
                prev = head;
                head = head.next;
            }
            return null;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void display() {
        ItemWithNext<K, V> temp;
        System.out.println("---------------");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + " " + list.get(i));
            if (list.get(i) != null && list.get(i).next != null) {
                temp = list.get(i).next;
                while (temp != null) {
                    System.out.println("  Same hash " + temp);
                    temp = temp.next;
                }
            }
        }
        System.out.println("---------------");
    }

    private int getIndex(K key) {
        return Math.abs(key.hashCode() % listSize);
    }

}
