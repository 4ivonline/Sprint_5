package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AlexLionTest {

    private Feline feline;
    private AlexLion alex;

    @BeforeEach
    public void setUp() throws Exception {
        feline = new Feline();
        alex = new AlexLion(feline);
    }

    @Test
    public void getListKittensForAlexEqualsZero() {
        int kittens = alex.getKittens();

        assertEquals(0, kittens, "У льва Алекса - нет котят.");
    }

    @Test
    public void getNegativeListKittensForAlexEqualsNotZero() {
        int kittens = alex.getKittens();

        assertNotEquals(1, kittens);
    }

    @Test
    public void getValueMaleShouldBeMane() {
        boolean hasMane = alex.doesHaveMane();
        assertEquals(true, hasMane, "Лев Алекс не может быть без гривы");
    }

    @Test
    public void getNegativeValueAlexNotBeWithoutMane() {
        boolean hasMane = alex.doesHaveMane();
        assertNotEquals(false, hasMane);
    }

    @Test
    public void positiveHomeAlexShouldBeNewYork() {
        String home = alex.getPlaceOfLiving();

        assertEquals("Нью-Йоркский зоопарк", home, "Лев Алекс живет в Нью-Йоркском зоопарке");
    }

    @Test
    public void negativeValueHomeAlexCantBeEmpty() {
        String home = alex.getPlaceOfLiving();

        assertFalse(home.isEmpty(), "Лев Алекс живет в Нью-Йоркском зоопарке");
    }

    @Test
    public void negativeValueFriendListForAlexCantBeEmpty() {
        List<String> friends = alex.getFriends();

        assertFalse(friends.isEmpty(), "Список друзей Алекса - не может быть пустым");
    }

    @Test
    public void negativeValueFoodListForAlexCantBeEmpty() throws Exception {
        List<String> food = alex.getFood();

        assertFalse(food.isEmpty(), "Список еды Алекса - не может быть пустым");
    }
}