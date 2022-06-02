package ru.geekbrains.HW_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class FruitBox<F extends Fruit> {

    private List<F> fruits;

    public FruitBox() {
        this.fruits = new ArrayList<>();
    }

    public FruitBox(List<F> fruits) {
        this.fruits = new ArrayList<>(fruits);
    }

    public FruitBox(F... fruits) {
        this.fruits = new ArrayList<>(Arrays.asList(fruits));
    }

    public void add(F fruit) {
        this.fruits.add(fruit);
    }
    public double getWeight() {
        double weight = 0.0;
        for (F fruit : fruits) {
            weight += fruit.getWeight();
        }
        return weight;
    }


    public boolean equalsByWeight(FruitBox<?> another) {
        return Math.abs(getWeight()-another.getWeight()) < 0.0001;
    }

    public void transferAll(FruitBox<? super F> another) {
        if (this == another) return;
        another.fruits.addAll(fruits);
        fruits.clear();
    }
    public List<F> getFruits(){
        return fruits;
    }



}
