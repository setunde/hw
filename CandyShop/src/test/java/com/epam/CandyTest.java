package com.epam;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Schneidhoffer Tunde on 2016.04.01..
 */
public final class CandyTest {


    public static final String CANDY_NAME = "Candy Name";
    public static final int PRICE = 160;
    public static final int QUANTITY = 2;
    public static final Candy.Taste TASTE = Candy.Taste.HONEY;
    public static final String CLASSIC_CANDY = "Classic candy";
    public static final int CLASSIC_CANDY_PRICE = 190;

    @Test(groups = "smoke")
    public void whenCreateCandyWithQuantityThenSuccess() {
        //Given
        //When
        final Candy actual = new Candy(CANDY_NAME, PRICE, QUANTITY, TASTE);
        //Then
        Assert.assertEquals(actual.getName(), CANDY_NAME, "Name: ");
        Assert.assertEquals(actual.getPrice(), PRICE, "Price: ");
        Assert.assertEquals(actual.getQuantity(), QUANTITY, "Quantity: ");
        MatcherAssert.assertThat("Taste: ", actual.getSpecialParameter(), Is.is(TASTE.name()));
    }

    @Test(groups = "trivial")
    public void whenCreateCandyWithoutDataThenSuccess() {
        //Given
        //When
        final Candy actual = new Candy(TASTE);
        //Then
        Assert.assertEquals(actual.getName(), CLASSIC_CANDY, "Name: ");
        Assert.assertEquals(actual.getPrice(), CLASSIC_CANDY_PRICE, "Price: ");
        MatcherAssert.assertThat("Taste: ", actual.getSpecialParameter(), Is.is(TASTE.name()));
    }

    @Test(groups = "equalsVerifier")
    public void whenEqualsVerifierThenSuccess() {
        //Given
        final Candy candy = new Candy(TASTE);
        //When
        candy.toString();
        EqualsVerifier.forClass(Candy.class).suppress(Warning.NONFINAL_FIELDS).verify();
    }

}