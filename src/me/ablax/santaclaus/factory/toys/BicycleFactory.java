package me.ablax.santaclaus.factory.toys;

import me.ablax.santaclaus.factory.interfaces.AbstractFactory;
import me.ablax.santaclaus.model.toys.Bicycle;

public class BicycleFactory extends AbstractFactory {

    static {
        register(BicycleFactory.class.getSimpleName(), BicycleFactory.class);
    }

    @Override
    public Bicycle produce() {
        prepareMaterials();
        return new Bicycle();
    }
}
