package com.epam;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Schneidhoffer Tunde on 2016.04.01..
 */
public class ChocolateTest {


    public static final String CANDY_NAME = "Chocolate Name";
    public static final int PRICE = 160;
    public static final int QUANTITY = 2;
    public static final Chocolate.ChocolateType TASTE = Chocolate.ChocolateType.MILK;
    public static final String CLASSIC_CANDY = "Milk Chocolate";
    public static final int CLASSIC_CANDY_PRICE = 210;

    @Test(groups = "smoke")
    public void whenCreateChocolateWithQualityThenSuccess() {
        //Given
        //When
        final Chocolate actual = new Chocolate(CANDY_NAME, PRICE, QUANTITY, TASTE);
        //Then
        Assert.assertEquals(actual.getName(), CANDY_NAME, "Name: ");
        Assert.assertEquals(actual.getPrice(), PRICE, "Price: ");
        Assert.assertEquals(actual.getQuantity(), QUANTITY, "Quantity: ");
        MatcherAssert.assertThat("Taste: ", actual.getSpecialParameter(), Is.is(TASTE.name()));
    }

    @Test(groups = "trivial")
    public void whenCreateChocolateWithoutDataThenSuccess() {
        //Given
        //When
        final Chocolate actual = new Chocolate();
        //Then
        Assert.assertEquals(actual.getName(), CLASSIC_CANDY, "Name: ");
        Assert.assertEquals(actual.getPrice(), CLASSIC_CANDY_PRICE, "Price: ");
    }

    @Test(groups = "equalsVerifier")
    public void whenEqualsVerifierThenSuccess() {
        //Given
        final Chocolate chocolate = new Chocolate();
        //When
        chocolate.toString();
        EqualsVerifier.forClass(Chocolate.class).verify();
    }

}