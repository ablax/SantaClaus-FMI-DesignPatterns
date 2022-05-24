package me.ablax.santaclaus.commands;

import me.ablax.santaclaus.model.interfaces.Toy;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class Workshop {

    private static final Workshop INSTANCE = new Workshop();
    private static final List<Toy> toys = new CopyOnWriteArrayList<>();

    private Workshop() {
        //Singleton
    }

    public static List<Toy> getToys() {
        return Collections.unmodifiableList(toys);
    }

    public static Workshop getInstance() {
        return INSTANCE;
    }

    public Toy buildDoll() {
        final Toy toy = new BuildDollCommand().requestToy();
        toys.add(toy);
        return toy;
    }

    public Toy buildBicycle() {
        final Toy toy = new BuildBicycleCommand().requestToy();
        toys.add(toy);
        return toy;
    }

}
