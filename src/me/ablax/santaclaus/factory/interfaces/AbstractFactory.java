package me.ablax.santaclaus.factory.interfaces;

import me.ablax.santaclaus.factory.FactoryProvider;
import me.ablax.santaclaus.model.interfaces.Toy;

public abstract class AbstractFactory {

    protected static void register (final String factoryName, final Class<? extends AbstractFactory> factoryClass) {
        FactoryProvider.registerFactory(factoryName, factoryClass);
    }


    protected void prepareMaterials(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public abstract Toy produce();

}
