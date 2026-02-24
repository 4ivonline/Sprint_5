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
    public void positiveEatAnimalsForPredatorIsTrue() throws Exception {
        List<String> food = feline.eatMeat();

        assertTrue(food.contains("Животные"));
    }

    @Test
    public void positiveEatBirdsForPredatorIsTrue() throws Exception {
        List<String> food = feline.eatMeat();

        assertTrue(food.contains("Птицы"));
    }

    @Test
    public void positiveEatFishForPredatorIsTrue() throws Exception {
        List<String> food = feline.eatMeat();

        assertTrue(food.contains("Рыба"));
    }

    @Test
    public void negativeEatGrassForPredatorIsNotTrue() throws Exception {
        List<String> food = feline.eatMeat();

        assertFalse(food.contains("Трава"), "Лев не ест траву, он предпочитает мясо.");
    }

    @Test
    public void negativeEatPlantsForPredatorIsNotTrue() throws Exception {
        List<String> food = feline.eatMeat();

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
    public void getPositiveCountKittensWithoutParamsShouldReturnOne() throws Exception {
        int result = feline.getKittens();

        assertEquals(1, result,  "Метод без параметров должен возвращать 1");
    }

    @Test
    public void getNegativeCountKittensIfParamsMoreOneFail() throws Exception {
        int result = feline.getKittens();

        assertFalse(result > 1, "Метод без параметров должен возвращать 1");
    }

    @Test
    public void getNegativeCountKittensIfParamsEqualZeroOrLessZeroFail() throws Exception {
        int result = feline.getKittens();

        assertFalse(result <= 0,"Метод без параметров должен возвращать 1" );
    }
}