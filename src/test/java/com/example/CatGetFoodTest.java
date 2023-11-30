package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class CatGetFoodTest {
    private final List<String> expectedFood;
    private final Feline felineMock;

    public CatGetFoodTest(List<String> expectedFood, Feline felineMock) {
        this.expectedFood = expectedFood;
        this.felineMock = felineMock;
    }

    @Test
    public void getFoodTest() throws Exception {
        Cat cat = new Cat(felineMock);

        when(felineMock.eatMeat()).thenReturn(expectedFood);

        List<String> actualFood = cat.getFood();

        assertEquals(expectedFood, actualFood);
    }

    @Parameterized.Parameters
    public static Object[][] getFoodData() {
        return new Object[][]{
                new Object[]{Arrays.asList("Птица", "Мышь"), Mockito.mock(Feline.class)},
                new Object[]{Arrays.asList("Сухой корм", "Докторская колбаса"), Mockito.mock(Feline.class)},
                // Другие варианты входных данных
        };
    }
}
