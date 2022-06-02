package ru.geekbrains.HW_1;

public class Test {
    public static void main(String[] args) {
        FruitBox<Apple> appleFruitBox = new FruitBox<>(new Apple(),new Apple(),new Apple());

        FruitBox<Orange> oranges = new FruitBox<>(new Orange(), new Orange());

        System.out.println(appleFruitBox.equalsByWeight(oranges));

        FruitBox<Orange> orangeFruitBox = new FruitBox<>(new Orange());

        System.out.println(oranges.getWeight());
        oranges.transferAll(orangeFruitBox);
        System.out.println(orangeFruitBox.getWeight());
        System.out.println(oranges.getWeight());
    }
}
