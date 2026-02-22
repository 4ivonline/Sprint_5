package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CatTest {
    private Cat cat;
    private Feline realFeline;

    @Mock
    private Feline mockFeline;
    private Cat catMock;

    @BeforeEach
    public void setUp() {

        realFeline = new Feline();
        cat = new Cat(realFeline);
        catMock = new Cat(mockFeline);
    }

    @Test
    public void getPositiveSoundCat() {
        String sound = cat.getSound();

        assertEquals("Мяу", sound, "Кот может издавать только Мяу");
    }

    @Test
    public void getPositiveEatListForPredator() throws Exception {
        List <String> expectFood = List.of ("Животные", "Птица", "Рыба");
        when(mockFeline.eatMeat()).thenReturn(expectFood);

        List <String> actualFood = catMock.getFood();

        assertEquals(expectFood, actualFood);

        Mockito.verify(mockFeline, times(1)).eatMeat();
    }

}