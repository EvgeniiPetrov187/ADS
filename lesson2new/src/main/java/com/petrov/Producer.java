package com.petrov;

public enum Producer {
    ASOS(1),
    ESER(2),
    LENUVO(3),
    MACNOTE(4),
    XAMIOU(5);

    int number;

    Producer(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
