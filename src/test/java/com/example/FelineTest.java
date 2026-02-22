package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class FelineTest {

    private Feline feline;

    @BeforeEach
    public void setUp() {
       feline = new Feline();
    }

    @Test
    public void positiveEatListForPredatorIsTrue() throws Exception {
        List<String> food = feline.eatMeat();

        assertTrue(food.contains("Животные"));
        assertTrue(food.contains("Птицы"));
        assertTrue(food.contains("Рыба"));
    }

    @Test
    public void negativeEatListForPredatorIsNotTrue() throws Exception {
        List<String> food = feline.eatMeat();

        assertFalse(food.contains("Трава"), "Лев не ест траву, он предпочитает мясо.");
        assertFalse(food.contains("Различные растения"), "Лев не ест растения, он предпочитает мясо.");
    }

    @Test
    public void eatListNotMustBeEmpty() throws Exception {
        List<String> food = feline.eatMeat();

        assertFalse(food.isEmpty(), "Список еды - не должен быть пустым");
    }

    @Test
    public void getPositiveFamilyTypeIsTrue() {
       String family = feline.getFamily();

       assertEquals("Кошачьи", family);
    }

    @Test
    public void getCountKittensWithoutParamsShouldReturnOne() throws Exception {
        int result = feline.getKittens();

        assertFalse(result > 1, "Метод без параметров должен возвращать 1");
        assertFalse(result <= 0,"Метод без параметров должен возвращать 1" );
    }
}