package com.epam;

public abstract class Gifts {
    private String name;
    private int price;
    private int quantity = 1;

    public Gifts(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Gifts(String name, int price,int quantity) {
        this(name,price);
        this.quantity = quantity;

    }

    public abstract String getSpecialParameter();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
