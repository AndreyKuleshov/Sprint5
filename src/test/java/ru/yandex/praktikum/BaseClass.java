package ru.yandex.praktikum;

import java.util.ArrayList;

public class BaseClass {
    AnimalFarm farm = new AnimalFarm(new ArrayList<>());
    public void twoDogs() {
        farm.addAnimal(Animal.DOG, "Sharik");
        farm.addAnimal(Animal.DOG, "Pushok");
    }
    public void twoAnimalsWithSameNames() {
        farm.addAnimal(Animal.DOG, "Sharik");
        farm.addAnimal(Animal.COW, "Sharik");
    }
}
