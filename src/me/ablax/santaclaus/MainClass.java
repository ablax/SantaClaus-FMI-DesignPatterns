package me.ablax.santaclaus;

import me.ablax.santaclaus.factory.FactoryProvider;
import me.ablax.santaclaus.factory.interfaces.AbstractFactory;
import me.ablax.santaclaus.model.Toy;

public class MainClass {
    public static void main(String[] args) {
        final AbstractFactory bicycleFactory = FactoryProvider.getFactory("BicycleFactory");
        final Toy toy = bicycleFactory.produce();
        System.out.println(toy.getClass());
    }
}
