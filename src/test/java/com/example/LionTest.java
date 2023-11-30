package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
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
    public void testConstructorWithFemaleSex() throws Exception {
        // Создаем макет (mock) объекта Feline
        Feline mockFeline = Mockito.mock(Feline.class);

        // Создаем объект Lion с полом "Самка"
        Lion lion = new Lion("Самка", mockFeline);

        // Проверяем, что пол задан верно
        assertFalse(lion.doesHaveMane());
    }

    @Test
    public void testConstructorWithInvalidSex() {
        // Создаем макет (mock) объекта Feline
        Feline mockFeline = Mockito.mock(Feline.class);

        // Создаем объект Lion с некорректным полом, что должно вызвать исключение
        assertThrows(Exception.class, () -> new Lion("Некорректный пол", mockFeline));
    }
}
