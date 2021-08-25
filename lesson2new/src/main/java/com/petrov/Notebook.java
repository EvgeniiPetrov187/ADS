package com.petrov;


public class Notebook {
    private long price;
    private int memory;
    private Producer producer;


    public Notebook(long price, int memory, Producer producer) {
        this.price = price;
        this.memory = memory;
        this.producer = producer;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "price=" + price +
                ", memory=" + memory +
                ", name='" + producer + '\'' +
                '}';
    }
}
