package com.epam;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

/**
 * Created by Schneidhoffer Tunde on 2016.04.04..
 */
public class OrderTest {

    public static final String NAME = "Gift4";
    public static final Integer PRICE = Integer.valueOf(700);
    public static final String CUSTOMER = "customer";
    public static final Integer NEW_QUANTITY = Integer.valueOf(1);
    public static final Integer CHANGE_QUANTITY = Integer.valueOf(7);
    private final static Candy GIFT1 = new Candy("Gift1", Integer.valueOf(1500),4, Candy.Taste.HONEY);
    private final static Candy GIFT2 = new Candy("Gift2", Integer.valueOf(5500), 1, Candy.Taste.CLASSIC);
    private final static Candy GIFT3 = new Candy("Gift3", Integer.valueOf(2700), 3, Candy.Taste.MENTHOL);
    private final static Candy GIFT4 = new Candy(NAME, PRICE, NEW_QUANTITY, Candy.Taste.MENTHOL);
    private final Order order = new Order();

    @BeforeMethod
    public void setUp() {
        //Given
    }

   @Test
    public void whenAddNewItemThenSuccess() {
       //Given
       final Candy expectedGift = new Candy("Gift1", Integer.valueOf(1500),NEW_QUANTITY, Candy.Taste.HONEY);
       final ArrayList<Gifts> expected = new ArrayList<Gifts>();
       expected.add(expectedGift);
       //When
       order.addItem(GIFT1,NEW_QUANTITY);
       //Then
       MatcherAssert.assertThat("New Gift: ",order.getItemList(), Is.is(expected));
   }
}