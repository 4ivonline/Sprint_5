package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class LionParameterizedTest {
    private Feline realFeline = new Feline();

    @ParameterizedTest
    @MethodSource("incorrectGenderValue")
    public void getNegativeValueWhenGenderParamsFails(String incorrectGender) {
        Exception exception = assertThrows(Exception.class,
                () -> new Lion(incorrectGender, realFeline));
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }

    private static Stream<String> incorrectGenderValue() {
        return Stream.of(
                "123",
                "Male",
                "Female",
                "!@#%",
                "Животное",
                "Мужской",
                "Женский",
                " Самец",
                "Самка ",
                "самец",
                "самка",
                "САМЕЦ",
                "САМКА"
        );
    }
}