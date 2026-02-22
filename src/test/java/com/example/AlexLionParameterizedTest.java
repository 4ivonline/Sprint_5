package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class AlexLionParameterizedTest {

    private AlexLion alex;
    private Feline realFeline;

    @BeforeEach
    public void setUp() throws Exception {
        realFeline = new Feline();
        alex = new AlexLion(realFeline);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Марти", "Глория", "Мелман"})

    public void positiveListFriendsForAlex(String friendName)  {
        assertTrue(alex.getFriends().contains(friendName), "У льва Алекса только 3 друга: Марти, Глория и Мелман");
    }

    @ParameterizedTest
    @ValueSource(strings = {"Симба", "Немо", "Патрик", "Шрек"})

    public void negativeListNotFriendsForAlex(String friendName)  {
        assertFalse(alex.getFriends().contains(friendName), "Друзья: Марти, Глория и Мелман - не должны в данном списке");
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "Московский зоопарк",
            "Парижский зоопарк",
            "Голландский зоопарк",
            "Итальянский зоопарк",
            "Немецкий зоопарк",
            "Китайский зоопарк"
    })

    public void negativePlaceForLivingAlexNotBeActual(String livingPlace)  {
        assertNotEquals(alex.getPlaceOfLiving(), livingPlace, "Нью-Йоркский зоопарк - не должен быть в данном списке");
    }

    @ParameterizedTest
    @ValueSource(strings = {"Животные", "Птицы", "Рыба"})

    public void positiveFoodListForAlexEat(String expectFood) throws Exception {
        assertTrue(alex.getFood().contains(expectFood), "Лев Алекс питается только: животными, птицами и рыбой");
    }

    @ParameterizedTest
    @ValueSource(strings = {"Трава", "Различные растения", "Пшено"})

    public void negativeFoodListForAlexDontEat(String expectFood) throws Exception {
        assertFalse(alex.getFood().contains(expectFood), "Мясо - не должно быть в данном списке");
    }
}