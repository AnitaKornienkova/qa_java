package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Test
    public void getFood() {
        Feline mockFeline = Mockito.mock(Feline.class);

        // Параметризация для разных значений пола (самец, самка)
        Collection<Object[]> data = List.of(
                new Object[]{"Самец", List.of("Мясо", "Рыба")},
                new Object[]{"Самка", List.of("Трава", "Различные растения")}
        );

        for (Object[] testCase : data) {
            String gender = (String) testCase[0];
            List<String> expectedFood = (List<String>) testCase[1];

            try {
                Lion lion = new Lion(gender, mockFeline);

                when(mockFeline.getFood("Хищник")).thenReturn(expectedFood);

                List<String> actualFood = lion.getFood();

                assertEquals("Пол: " + gender, expectedFood, actualFood);
            } catch (Exception e) {
                // Обработка исключения, если оно произойдет в процессе выполнения теста
                e.printStackTrace();
            }
        }
    }

    @Test
    public void getKittens() throws Exception {
        // Создаем макет (mock) объекта Feline
        Feline mockFeline = Mockito.mock(Feline.class);

        // Устанавливаем ожидаемое поведение для метода getKittens()
        when(mockFeline.getKittens()).thenReturn(3);

        // Создаем объект Lion с макетом Feline
        Lion lion = new Lion("Самец", mockFeline);

        // Вызываем метод getKittens() и проверяем, что результат равен ожидаемому значению
        int actualKittens = lion.getKittens();
        assertEquals(3, actualKittens);
    }

    @Test
    public void doesHaveMane() throws Exception {
        // Создаем макет (mock) объекта Feline
        Feline mockFeline = Mockito.mock(Feline.class);

        // Создаем объект Lion с макетом Feline и полом "Самец"
        Lion lion = new Lion("Самец", mockFeline);

        // Проверяем, что у льва есть грива (should have mane)
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void testConstructorWithFemaleSex() {
        // Создаем макет (mock) объекта Feline
        Feline mockFeline = Mockito.mock(Feline.class);

        try {
            // Создаем объект Lion с полом "Самка"
            Lion lion = new Lion("Самка", mockFeline);

            // Проверяем, что пол задан верно
            assertFalse(lion.doesHaveMane());
        } catch (Exception e) {
            // Если произошло исключение, выводим его сообщение
            fail("Exception should not be thrown");
        }
    }

    @Test
    public void testConstructorWithInvalidSex() {
        // Создаем макет (mock) объекта Feline
        Feline mockFeline = Mockito.mock(Feline.class);

        try {
            // Создаем объект Lion с некорректным полом, что должно вызвать исключение
            new Lion("Некорректный пол", mockFeline);
            // Если исключение не было выброшено, тест считается неудачным
            fail("Exception should be thrown for invalid sex");
        } catch (Exception e) {
            // Проверяем, что сообщение об ошибке содержит правильное предупреждение
            assertEquals("Используйте допустимые значения пола животного - самей или самка", e.getMessage());
        }
    }

}
