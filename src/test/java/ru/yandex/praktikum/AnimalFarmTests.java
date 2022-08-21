package ru.yandex.praktikum;

import org.junit.Assert;
import org.junit.Test;

public class AnimalFarmTests extends BaseClass {

    @Test
    public void addAnimalTest() {
        farm.addAnimal(Animal.COW, "Buryenka");
        Assert.assertEquals("COW Buryenka\n", farm.toString());
    }
    @Test
    public void addAnimalByTypeTest() {
        farm.addAnimal("COW");
        Assert.assertEquals("COW N\n", farm.toString());
    }
    @Test
    public void addAnimalByNameTest() {
        farm.addAnimal("Zhuchka");
        Assert.assertEquals(Animal.NOT_DEFINED.name()+" Zhuchka\n", farm.toString());
    }
    @Test
    public void countAnimalsTest() {
        twoDogs();
        Assert.assertEquals("{DOG=2}", farm.countedAnimals().toString());
    }
    @Test
    public void uniqueAnimalsTest() {
        twoAnimalsWithSameNames();
        Assert.assertEquals("[Sharik]", farm.uniqueNames().toString());
    }

}
