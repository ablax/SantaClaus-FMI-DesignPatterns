package me.ablax.santaclaus.factory.toys;

import me.ablax.santaclaus.factory.interfaces.AbstractFactory;
import me.ablax.santaclaus.model.toys.Doll;

public class DollFactory extends AbstractFactory {

    static {
        register(DollFactory.class.getSimpleName(), DollFactory.class);
    }

    @Override
    public Doll produce() {
        prepareMaterials();
        return new Doll();
    }

}
