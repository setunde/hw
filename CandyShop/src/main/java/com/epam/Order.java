package com.epam;

import java.util.ArrayList;

public class Order {
    ArrayList<Gifts> itemList = new ArrayList<Gifts>();

    public ArrayList<Gifts> getItemList() {
        return itemList;
    }

    public void addItem(Gifts newItem){
        itemList.add(newItem);
    }

    public void addItem(Gifts newItem, int quantity){
        newItem.setQuantity(quantity);
        itemList.add(newItem);
    }

    public void modifyQuantity(int itemId, int newQuantity){
        if (newQuantity < 1){
            throw new NumberFormatException("Quantity should be positive number");
        }else {
            System.out.println("Changing quantity of item " + itemList.get(itemId).getName() + " from " + itemList.get(itemId).getQuantity() + " to " + newQuantity);
            itemList.get(itemId).setQuantity(newQuantity);
        }
    }

    public void deleteItem(int itemId){
        if (itemId > itemList.size()-1){
            throw new IllegalStateException("No item with that ID exist");
        }else{
            System.out.println("Deletion of item " + itemList.get(itemId).getName());
            itemList.remove(itemId);
        }
    }

    /**
     * Gives back the total price
     */
    public int getTotalPrice() {
        int totalPrice = 0;
        for (Gifts item : itemList) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }

    /**
     * Gives back total number of ordered items
     */
    public int getTotalQuantity() {
        int totalQuantity = 0;
        for (Gifts item : itemList) {
            totalQuantity++;
        }
        return totalQuantity;
    }


    /**
     * Gives back average price
     */
    public int getAveragePrice() {
        return getTotalPrice()/getTotalQuantity();
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
        return (itemList != null ? !CollectionUtils.isEqualCollection(itemList, order.itemList) : order.itemList !=
                null) return false;

        return itemList != null ? itemList.equals(order.itemList) : order.itemList == null;

    }

    @Override
    public int hashCode() {
        return itemList != null ? itemList.hashCode() : 0;
    }
}
