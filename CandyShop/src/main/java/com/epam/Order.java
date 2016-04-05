package com.epam;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;

public class Order {
    final ArrayList<Gifts> itemList = new ArrayList<Gifts>();

    public ArrayList<Gifts> getItemList() {
        return itemList;
    }

    public void addItem(final Gifts newItem) {
        itemList.add(newItem);
    }

    public void addItem(final Gifts newItem, final int quantity) {
        newItem.setQuantity(quantity);
        itemList.add(newItem);
    }

    public void modifyQuantity(final int itemId, final int newQuantity) {
        if (newQuantity < 1) {
            throw new NumberFormatException("Quantity should be positive number");
        } else {
            if (itemId > itemList.size() - 1 || itemId < 0) {
                throw new IllegalArgumentException("No item with that ID exist");
            }
            System.out.println("Changing quantity of item " + itemList.get(itemId).getName() + " from " + itemList.get(itemId).getQuantity() + " to " + newQuantity);
            itemList.get(itemId).setQuantity(newQuantity);
        }
    }

    public void deleteItem(final int itemId) {
        if (itemId > itemList.size() - 1 || itemId < 0) {
            throw new IllegalArgumentException("No item with that ID exist");
        } else {
            System.out.println("Deletion of item " + itemList.get(itemId).getName());
            itemList.remove(itemId);
        }
    }

    /**
     * Gives back the total price
     */
    public int getTotalPrice() {
        int totalPrice = 0;
        for (final Gifts item : itemList) {
            totalPrice += item.getPrice() * item.getQuantity();
        }
        return totalPrice;
    }

    /**
     * Gives back total number of ordered items
     */
    public int getTotalQuantity() {
        int totalQuantity = 0;
        for (final Gifts item : itemList) {
            totalQuantity += item.getQuantity();
        }
        return totalQuantity;
    }


    /**
     * Gives back average price
     */
    public int getAveragePrice() {
        int totalPrice = 0;
        for (final Gifts item : itemList) {
            totalPrice += item.getPrice();
        }
        return totalPrice / itemList.size();
    }

    public void clear() {
        itemList.clear();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (itemList == null ^ order.itemList == null)
            return false;
        if (itemList != null ? !CollectionUtils.isEqualCollection(itemList, order.itemList) : order.itemList !=
                null) return false;
        return true;

    }

    @Override
    public int hashCode() {
        return itemList != null ? itemList.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Order{" +
                "itemList=" + itemList +
                '}';
    }
}
