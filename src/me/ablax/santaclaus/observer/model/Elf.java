package me.ablax.santaclaus.observer.model;

import me.ablax.santaclaus.factory.FactoryProvider;
import me.ablax.santaclaus.factory.interfaces.AbstractFactory;
import me.ablax.santaclaus.model.interfaces.Toy;

public class Elf {

    public void buildToy() {
        final String toyToBuild = MagicBoard.getInstance().getUpdate();
        final AbstractFactory factory = FactoryProvider.getFactory(toyToBuild + "Factory");

        final Toy toy = factory.produce();

        System.out.println("Elf built toy " + toy);
    }

}
