package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class LionGetFoodTest {
    private final String gender;
    private final List<String> expectedFood;

    public LionGetFoodTest(String gender, List<String> expectedFood) {
        this.gender = gender;
        this.expectedFood = expectedFood;
    }

    @Test
    public void getFood() throws Exception {
        Feline mockFeline = Mockito.mock(Feline.class);

        Lion lion = new Lion(gender, mockFeline);

        when(mockFeline.getFood("Хищник")).thenReturn(expectedFood);

        List<String> actualFood = lion.getFood();

        assertEquals("Пол: " + gender, expectedFood, actualFood);
    }

    @Parameterized.Parameters
    public static Object[][] getFoodData() {
        return new Object[][]{
                new Object[]{"Самец", List.of("Мясо", "Рыба")},
                new Object[]{"Самка", List.of("Трава", "Различные растения")}
        };
    }
}
