package com.epam;

public class Chocolate extends Gifts {
    public enum ChocolateType {DARK, MILK, WHITE};
    private ChocolateType type = ChocolateType.MILK;

    public Chocolate() {
        super("Milk Chocolate", 210);
    }

    public Chocolate(final String name, final int price, final int quantity, final ChocolateType type) {
        super(name, price, quantity);
        this.type = type;
    }

    @Override
    public String getSpecialParameter() {
        return String.valueOf(type);
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Chocolate chocolate = (Chocolate) o;

        if (getPrice() != chocolate.getPrice()) return false;
        if (getQuantity() != chocolate.getQuantity()) return false;
        if (getName() != null ? !getName().equals(chocolate.getName()) : chocolate.getName() != null) return false;
        return type == chocolate.type;

    }

    @Override
    public int hashCode() {
        return type != null ? type.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Chocolate{" +
                "name='" + getName() + '\'' +
                ", price=" + getPrice() +
                ", quantity=" + getQuantity() +
                ", type=" + type +
                '}';
    }
}
