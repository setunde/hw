package com.epam;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.hamcrest.Matchers.containsInAnyOrder;

/**
 * Created by Schneidhoffer Tunde on 2016.04.04..
 */
public class OrderTest {

    public static final String NAME = "Gift4";
    public static final Candy.Taste HONEY = Candy.Taste.HONEY;
    public static final Candy.Taste CLASSIC = Candy.Taste.CLASSIC;
    public static final Chocolate.ChocolateType WHITE = Chocolate.ChocolateType.WHITE;
    public static final Chocolate.ChocolateType DARK = Chocolate.ChocolateType.DARK;
    public static final Integer PRICE = Integer.valueOf(700);
    public static final Integer NEW_QUANTITY = Integer.valueOf(1);
    public static final Integer CHANGE_QUANTITY = Integer.valueOf(7);
    private final static Candy GIFT1 = new Candy("Gift1", Integer.valueOf(1500), 4, HONEY);
    private final static Candy GIFT2 = new Candy("Gift2", Integer.valueOf(5500), 1, CLASSIC);
    private final static Chocolate GIFT3 = new Chocolate("Gift3", Integer.valueOf(2700), 3, WHITE);
    private final static Chocolate GIFT4 = new Chocolate(NAME, PRICE, NEW_QUANTITY, DARK);
    private final Order order = new Order();

    @BeforeMethod
    public void setUp() {
        //Given
        order.clear();
    }

    @Test
    public void whenAddNewItemThenSuccess() {
        //Given
        final Candy expectedGift = new Candy(GIFT1.getName(), GIFT1.getPrice(), NEW_QUANTITY, HONEY);
        final ArrayList<Gifts> expected = new ArrayList<Gifts>();
        expected.add(expectedGift);
        //When
        order.addItem(GIFT1, NEW_QUANTITY);
        //Then
        MatcherAssert.assertThat("New Gift: ", order.getItemList(), Is.is(expected));
    }

    @DataProvider(name = "modifyQuantity")
    public Object[][] modifyQuantityFeeder() {
        return new Object[][]{{NEW_QUANTITY}, {CHANGE_QUANTITY}, {123}, {12}, {Integer.MAX_VALUE}};
    }

    @Test(dataProvider = "modifyQuantity")
    public void whenModifyQuantityThenSuccess(final int changeQuantity) {
        //Given
        final Candy expectedGift = new Candy(GIFT1.getName(), GIFT1.getPrice(), changeQuantity, HONEY);
        final ArrayList<Gifts> expected = new ArrayList<Gifts>();
        expected.add(expectedGift);
        order.addItem(GIFT1, NEW_QUANTITY);
        //When
        order.modifyQuantity(0, changeQuantity);
        //Then
        MatcherAssert.assertThat("New Gift: ", order.getItemList(), Is.is(expected));
    }

    @Test
    public void whenDeleteThenSuccess() {
        //Given
        final Candy expectedGift = new Candy(GIFT1.getName(), GIFT1.getPrice(), NEW_QUANTITY, HONEY);
        final ArrayList<Gifts> expected = new ArrayList<Gifts>();
        expected.add(expectedGift);
        order.addItem(GIFT2);
        order.addItem(GIFT1, NEW_QUANTITY);
        //When
        order.deleteItem(0);
        //Then
        MatcherAssert.assertThat("New Gift: ", order.getItemList(), Is.is(expected));
    }

    @Test
    public void whenGetTotalQuantityThenSuccess() {
        //Given
        final int expected = NEW_QUANTITY + GIFT2.getQuantity() + GIFT3.getQuantity() + GIFT4.getQuantity();
        order.addItem(GIFT2);
        order.addItem(GIFT1, NEW_QUANTITY);
        order.addItem(GIFT3);
        order.addItem(GIFT4);
        //When
        final int actual = order.getTotalQuantity();
        //Then
        Assert.assertEquals(actual, expected, "Total Quantity: ");
    }

    @Test
    public void whenGetTotalPriceThenSuccess() {
        //Given
        final int expected = GIFT1.getPrice() * NEW_QUANTITY + GIFT2.getPrice() * GIFT2.getQuantity() + GIFT3.getPrice() * GIFT3.getQuantity() + GIFT4.getPrice() * GIFT4.getQuantity();
        order.addItem(GIFT2);
        order.addItem(GIFT1, NEW_QUANTITY);
        order.addItem(GIFT3);
        order.addItem(GIFT4);
        //When
        final int actual = order.getTotalPrice();
        //Then
        Assert.assertEquals(actual, expected, "Total Price: ");
    }

    @Test
    public void whenGetAveragePriceThenSuccess() {
        //Given
        final int expected = (GIFT1.getPrice() + GIFT2.getPrice() + GIFT3.getPrice() + GIFT4.getPrice()) / 4;
        order.addItem(GIFT2);
        order.addItem(GIFT1, NEW_QUANTITY);
        order.addItem(GIFT3);
        order.addItem(GIFT4);
        //When
        final int actual = order.getAveragePrice();
        //Then
        Assert.assertEquals(actual, expected, "Total Price: ");
    }

    @Test
    public void whenClearThenSuccess() {
        //Given
        final ArrayList<Gifts> expected = new ArrayList<Gifts>();
        order.addItem(GIFT2);
        order.addItem(GIFT1, NEW_QUANTITY);
        order.addItem(GIFT3);
        order.addItem(GIFT4);
        //When
        order.clear();
        //Then
        MatcherAssert.assertThat("New Gift: ", order.getItemList(), Is.is(expected));
    }

    @DataProvider(name = "negative")
    public Object[][] negativeFeeder() {
        return new Object[][]{{-1}, {0}};
    }

    @Test(dataProvider = "negative", expectedExceptions = IllegalArgumentException.class)
    public void whenDeleteNotExistingItemsQuantityThenException(final int id) {
        //When
        order.deleteItem(id);
    }

    @Test(dataProvider = "negative", expectedExceptions = IllegalArgumentException.class)
    public void whenModifyNotExistingThenException(final int id) {
        //When
        order.modifyQuantity(id, 2);
    }

    @Test(dataProvider = "negative", expectedExceptions = NumberFormatException.class)
    public void whenModifyToNegativeQuantityThenException(final int quantity) {
        //Given
        order.addItem(GIFT1, NEW_QUANTITY);
        //When
        order.modifyQuantity(0, quantity);
    }

    @Test(enabled = false)
    public void whenMockGetTotalPriceThenSuccess() {
        //Given
        final int TOTAL = 1000;
        final Order mockOrder = Mockito.mock(Order.class);
        Mockito.when(mockOrder.getTotalPrice()).thenReturn(TOTAL);
        //When
        final int actual = mockOrder.getTotalQuantity();
        //Then
        Assert.assertEquals(actual, TOTAL);
    }

    @Test(enabled = false)
    public void whenMockGetTotalQuantityThenSuccess() {
        //Given
        final int TOTAL = 1000;
        final Order mockOrder = Mockito.mock(Order.class);
        Mockito.when(mockOrder.getTotalQuantity()).thenReturn(TOTAL);
        //When
        final int actual = mockOrder.getTotalQuantity();
        //Then
        Assert.assertEquals(actual, TOTAL);
    }

    @Test
    public void whenEqualsVerifierThenSuccess() {
        EqualsVerifier.forClass(Order.class).verify();
        order.toString();
    }


}