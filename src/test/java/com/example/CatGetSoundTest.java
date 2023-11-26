package com.example;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class CatGetSoundTest {
    @Test
    public void getSoundTest() {
        Cat cat = new Cat(Mockito.mock(Feline.class));
        String actualSound = cat.getSound();
        assertEquals(actualSound, "Мяу");
    }
}
