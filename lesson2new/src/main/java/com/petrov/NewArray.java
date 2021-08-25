package com.petrov;

import java.util.Random;

public class NewArray {
    private final int[] MEMORIES = {4, 8, 12, 16};

    public NewArray(Notebook[] notebooks) {
    }

    public Notebook[] getArray(Notebook[] notebooks) {

        Random random = new Random();

        for (int i = 0; i < notebooks.length; i++) {
            notebooks[i] = new Notebook(
                    getPrice(),
                    MEMORIES[random.nextInt(MEMORIES.length)],
                    getName()
            );
        }
        return notebooks;
    }

    public long getPrice() {
        Random random = new Random();
        long price;
        long temp;
        while (true) {
            temp = random.nextInt(2001);
            if (temp % 100 == 0 && temp >= 500) {
                price = temp;
                break;
            }
        }
        return price;
    }

    public Producer getName(){
        Random random = new Random();
        int num;
        num = (random.nextInt(Producer.values().length));
        return Producer.values()[num];
    }
}
