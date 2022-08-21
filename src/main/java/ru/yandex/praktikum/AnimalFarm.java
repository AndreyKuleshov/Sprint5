package ru.yandex.praktikum;

import java.util.*;

public class AnimalFarm {
    private final List<String> farmAnimals;

    public AnimalFarm(List<String> animals) {
        this.farmAnimals = animals;
    }

    public Map<Animal, Integer> countedAnimals() {
        Map<Animal, Integer> animalMap = new HashMap<>();
        Animal animal;
        for (String farmAnimal: farmAnimals) {
            try {
                animal = Animal.valueOf(farmAnimal.split(" ")[0].toUpperCase());
                Integer currentNumber = animalMap.get(animal);
                animalMap.put(animal, currentNumber == null ? 1 : currentNumber + 1);
            } catch (IllegalArgumentException | NullPointerException e) {
                System.out.println("Please correct string " + farmAnimal + ". Incorrect input data.");
            }
        }
        return animalMap;
    }

    public Set<String> uniqueNames() {
        Set<String> names = new HashSet<>();
        for (String farmAnimal:farmAnimals) {
            try {
                names.add(farmAnimal.split(" ")[1]);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Please correct string " + farmAnimal + ". Incorrect input data.");
            }
        }
        return names;
    }

    public void addAnimal(Animal type, String name) {
        farmAnimals.add(type.name() + " " + name);
    }

    public void addAnimal(String typeOrName) {
        if (checkEnum(typeOrName)) {
            farmAnimals.add(Animal.valueOf(typeOrName) + " N");
        } else {
            farmAnimals.add(Animal.NOT_DEFINED + " " + typeOrName);
        }
    }
    private boolean checkEnum(String name) {
        try {
            Animal.valueOf(name);
            return true;
        } catch (IllegalArgumentException | NullPointerException e) {
            return false;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String farmAnimal : farmAnimals) {
            stringBuilder.append(farmAnimal).append("\n");
        }

        return stringBuilder.toString();
    }
}
