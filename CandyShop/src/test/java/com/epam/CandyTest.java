package com.epam;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Schneidhoffer Tunde on 2016.04.01..
 */
public class CandyTest {


    public static final String CANDY_NAME = "Candy Name";
    public static final int PRICE = 160;
    public static final int QUANTITY = 2;
    public static final Candy.Taste TASTE = Candy.Taste.HONEY;

    @Test
    public void whenCreateCandyThenSuccess() {
        //Given
        //When
        final Candy actual = new Candy(CANDY_NAME, PRICE, QUANTITY, TASTE);
        //Then
        Assert.assertEquals(actual.getName(), CANDY_NAME, "Name: ");
        Assert.assertEquals(actual.getPrice(), PRICE, "Price: ");
        Assert.assertEquals(actual.getQuantity(), QUANTITY, "Quantity: ");
        MatcherAssert.assertThat("Taste: ", actual.getSpecialParameter(), Is.is(TASTE.name()));
    }

}