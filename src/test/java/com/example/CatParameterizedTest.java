package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class CatParameterizedTest {
    private Cat cat;

    @BeforeEach
    public void setUp() {
        Feline feline = new Feline();
        cat = new Cat(feline);
    }

    @ParameterizedTest
    @MethodSource("negativeNotMeowSoundsForCat")
    public void getSoundNotReturnFailSound(String incorrectSound) {
        assertNotEquals(incorrectSound, cat.getSound());
    }

    private static Stream<String> negativeNotMeowSoundsForCat() {
        return Stream.of(
                "Гав",
                "Му",
                "Хрю",
                "Ква",
                "Бе"
        );
    }

    @ParameterizedTest
    @MethodSource("positiveAnimalFoodForCat")

    public void getFoodShouldOnlyPredator(String expectedFood) throws Exception {
        List<String> food = cat.getFood();

        assertTrue(food.contains(expectedFood),
                "Еда должна содержать: " + expectedFood);
    }

    private static Stream<String> positiveAnimalFoodForCat() {
        return Stream.of(
                "Животные",
                "Птицы",
                "Рыба"
        );
    }

    @ParameterizedTest
    @MethodSource("negativeAnimalFoodForCat")

    public void getFoodFailForPredator(String expectedFood) throws Exception {
        List<String> food = cat.getFood();

        assertFalse(food.contains(expectedFood),
                "Еда не должна содержать травоядную пищу: " + expectedFood);
    }

    private static Stream<String> negativeAnimalFoodForCat() {
        return Stream.of(
                "Трава",
                "Различные растения"
        );
    }
}