package com.epam;

import jdk.nashorn.internal.ir.annotations.Immutable;

@Immutable
public abstract class Gifts {
    private final String name;
    private final int price;
    private int quantity = 1;

    public Gifts(final String name, final int price) {
        this.name = name;
        this.price = price;
    }

    public Gifts(final String name, final int price, final int quantity) {
        this(name,price);
        this.quantity = quantity;

    }

    public abstract String getSpecialParameter();

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}
