package by.blintsov.check.entity;

import by.blintsov.check.entity.impl.Product;

public class Twix extends Product {
    private int itemId = 5;
    private String name = "Twix";
    private double cost = 1.79;
    private boolean stock = true;

    public Twix() {
    }

    public int getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public boolean isStock() {
        return stock;
    }

    public void setStock(boolean x) {
        stock = x;
    }
}