package com.epam;

public final class Candy extends Gifts {
    public enum Taste {HONEY, MENTHOL, CLASSIC};
    private final Taste taste;

    public Candy(final Taste taste) {
        super("Classic candy", 190);
        this.taste = taste;
    }

    public Candy(final String name, final int price, final int quantity, final Taste taste) {
        super(name, price, quantity);
        this.taste = taste;
    }

    @Override
    public String getSpecialParameter() {
        return String.valueOf(taste);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Candy candy = (Candy) o;
        if (getPrice() != candy.getPrice()) return false;
        if (getQuantity() != candy.getQuantity()) return false;
        if (getName() != null ? !getName().equals(candy.getName()) : candy.getName() != null) return false;
        return taste == candy.taste;

    }

    @Override
    public int hashCode() {
        return taste != null ? taste.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Candy{" +
                "name='" + getName() + '\'' +
                ", price=" + getPrice() +
                ", quantity=" + getQuantity() +
                ", taste=" + taste +
                '}';
    }
}
