package com.example;

import java.util.ArrayList;
import java.util.List;

public class AlexLion extends Lion {

    public AlexLion(FelineInterface feline) throws Exception {
        super("Самец", feline);
    }

    @Override
    public int getKittens() {
        return 0;
    }

    public List<String> getFriends() {
        List<String> friendsAlex = new ArrayList<>();
        friendsAlex.add("Марти");
        friendsAlex.add("Глория");
        friendsAlex.add("Мелман");

        return friendsAlex;
    }

    public String getPlaceOfLiving() {
        return "Нью-Йоркский зоопарк";
    }
}