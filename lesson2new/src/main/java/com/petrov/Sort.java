package com.petrov;

public class Sort {
    public static Notebook[] getSort(Notebook[] notebooks) {
        Notebook tempPrice;
        Notebook tempMemory;
        Notebook tempProducer;
        long a = System.currentTimeMillis();
        for (int i = 0; i < notebooks.length; i++) {
            for (int j = 0; j < notebooks.length; j++) {
                if (notebooks[i].getPrice() < notebooks[j].getPrice()) {
                    tempPrice = notebooks[i];
                    notebooks[i] = notebooks[j];
                    notebooks[j] = tempPrice;
                } else if (notebooks[i].getPrice() == notebooks[j].getPrice()) {
                    if (notebooks[i].getMemory() < notebooks[j].getMemory()) {
                        tempMemory = notebooks[i];
                        notebooks[i] = notebooks[j];
                        notebooks[j] = tempMemory;
                    } else if (notebooks[i].getMemory() == notebooks[j].getMemory()) {
                        if (notebooks[i].getProducer().getNumber() < notebooks[j].getProducer().getNumber()) {
                            tempProducer = notebooks[i];
                            notebooks[i] = notebooks[j];
                            notebooks[j] = tempProducer;
                        }
                    }

                }
            }
        }
        long b = System.currentTimeMillis();
        System.out.println("Time: " + (b - a));
        return notebooks;
    }
}

