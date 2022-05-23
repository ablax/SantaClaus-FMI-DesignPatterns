package me.ablax.santaclaus.factory.interfaces;

import me.ablax.santaclaus.factory.FactoryProvider;
import me.ablax.santaclaus.model.Toy;

public abstract class AbstractFactory {

    protected static void register (final String factoryName, final Class<? extends AbstractFactory> factoryClass) {
        FactoryProvider.registerFactory(factoryName, factoryClass);
    }

    public abstract Toy produce();

}
