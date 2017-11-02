package com.lance.demo.esper.event;

public class ProcessInsertStreamEvent {

    public ProcessInsertStreamEvent(double price) {
        this.price = price;
    }

    private double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
