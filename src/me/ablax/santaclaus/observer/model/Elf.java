package me.ablax.santaclaus.observer.model;

import me.ablax.santaclaus.factory.FactoryProvider;
import me.ablax.santaclaus.factory.interfaces.AbstractFactory;
import me.ablax.santaclaus.model.interfaces.Toy;

import java.util.Objects;

public class Elf {

    private final long elfId;

    public Elf(final long elfId) {
        this.elfId = elfId;
    }


    public Toy buildToy(final String toyToBuild) {
        final AbstractFactory factory = FactoryProvider.getFactory(toyToBuild + "Factory");

        final Toy toy = factory.produce();

        System.out.println("Elf id " + elfId + " built toy " + toy.getClass().getSimpleName());

        return toy;
    }

    @Override
    public String toString() {
        return "Elf{" +
                "elfId=" + elfId +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Elf)) return false;
        final Elf elf = (Elf) o;
        return elfId == elf.elfId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(elfId);
    }

}
