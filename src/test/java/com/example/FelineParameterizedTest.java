package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class FelineParameterizedTest {

    private Feline feline = new Feline();

    @ParameterizedTest
    @CsvSource({
            "0, 0",
            "1, 1",
            "5, 5",
            "10, 10"
    })

public void getPositiveKittensCountList(int expectedResult, int input) {
        int actual = feline.getKittens(input);

        assertEquals(expectedResult, actual);
    }

    @ParameterizedTest
    @MethodSource("otherFamilyAnimal")
    public void getShouldNotReturnOtherAnimalFamily(String otherFamily) {
        String family = feline.getFamily();

        assertNotEquals(otherFamily, family, "Семейство животного н может быть: " + otherFamily);
    }
    private static Stream<String> otherFamilyAnimal() {
        return Stream.of (
                "Заячьи",
                "Беличь",
                "Мышиные",
                "Псовые",
                "Собачьи",
                "Медвежьи",
                "Куньи"
        );
    }
}