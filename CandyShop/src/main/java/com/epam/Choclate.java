package com.epam;

public class Choclate extends Gifts {
    private enum ChoclateType {DARK,MILK,WHITE};
    private ChoclateType type = ChoclateType.MILK;


    public Choclate() {
        super("Milk Choclate",210);
    }

    public Choclate(String name, int price, int quantity, ChoclateType type) {
        super(name,price,quantity);
        this.type = type;
    }

    @Override
    public String getSpecialParameter() {
        return String.valueOf(type);
    }
}
