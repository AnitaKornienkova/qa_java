package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Test
    public void getFoodMeatTest() throws Exception {
        // Создаем макет (spy) объекта Feline
        Feline feline = Mockito.spy(new Feline());

        // Устанавливаем поведение макета для метода getFood
        Mockito.when(feline.getFood("Хищник")).thenReturn(Arrays.asList("Мясо", "Рыба"));

        // Вызываем метод eatMeat у объекта Feline
        List<String> food = feline.eatMeat();

        // Проверяем, что результат соответствует ожидаемому
        assertEquals(Arrays.asList("Мясо", "Рыба"), food);

        // Проверяем, что метод getFood был вызван у объекта Feline
        Mockito.verify(feline).getFood("Хищник");
    }

    @Test
    public void getFamilyTest() {
        Feline feline = new Feline();

        // Вызываем метод getFamily у объекта Feline
        String family = feline.getFamily();

        // Проверяем, что результат соответствует ожидаемому
        assertEquals("Кошачьи", family);
    }

    @Test
    public void getKittensTest() {
        Feline feline = new Feline();

        // Вызываем метод getKittens у объекта Feline
        int kittensCount = feline.getKittens();

        // Проверяем, что результат соответствует ожидаемому
        assertEquals(1, kittensCount);
    }

    @Test
    public void getKittensWithCountTest() {
        Feline feline = new Feline();

        // Вызываем метод getKittens с аргументом у объекта Feline
        int kittensCount = feline.getKittens(2);

        // Проверяем, что результат соответствует ожидаемому
        assertEquals(2, kittensCount);
    }
}
