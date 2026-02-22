package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LionTest {

    private Feline realFeline;

    @Mock
    private FelineInterface mockFeline;

    @Test
    public void createPositiveMaleLionShouldBeWithMane() throws Exception {
        Lion lion = new Lion ("Самец", realFeline);

        assertTrue(lion.doesHaveMane(), "У самца есть грива");
    }

    @Test
    public void createNegativeMaleLionDontBeNoMane() throws Exception {
        Lion lion = new Lion ("Самец", realFeline);

        assertNotEquals(false, lion.doesHaveMane(), "Проверка на самца без гривы - должна быть false");
    }

    @Test
    public void сreatePositiveFemaleLionWithoutMane() throws Exception {
        Lion lion = new Lion ("Самка", realFeline);

        assertFalse(lion.doesHaveMane(), "У самки отсутствует грива");
    }

    @Test
    public void createNegativeFeMaleLionDontBeNoMane() throws Exception {
        Lion lion = new Lion ("Самка", realFeline);

        assertNotEquals(true, lion.doesHaveMane(), "Проверка на самку без гривы - должна быть true");
    }

    @Test
    public void getKittensReturnPositiveCount() throws Exception {
        when(mockFeline.getKittens()).thenReturn(1);

        Lion lion = new Lion("Самка", mockFeline);

        int kittens = lion.getKittens();

        assertEquals(1, kittens, "По умолчанию должен быть 1 котенок");
        verify(mockFeline, times(1)).getKittens();
    }

    @Test
    public void getPositiveFoodList() throws Exception {
    when(mockFeline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));

    Lion lion = new Lion("Самец", mockFeline);

    List<String> food = lion.getFood();

        assertTrue(food.contains("Животные"));
        assertTrue(food.contains("Птицы"));
        assertTrue(food.contains("Рыба"));

        Mockito.verify(mockFeline).eatMeat();
    }

    @Test
    public void getNegativeFoodList() throws Exception {
        when(mockFeline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        Lion lion = new Lion("Самец", mockFeline);

        List<String> food = lion.getFood();

        assertFalse(food.contains("Трава"));
        assertFalse(food.contains("Различные растения"));

        Mockito.verify(mockFeline).eatMeat();
    }
}