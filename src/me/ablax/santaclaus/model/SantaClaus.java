package me.ablax.santaclaus.model;

import me.ablax.santaclaus.commands.Workshop;
import me.ablax.santaclaus.model.interfaces.Toy;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public final class SantaClaus {

    private static final ExecutorService executor = Executors.newCachedThreadPool();
    private static final SantaClaus INSTANCE = new SantaClaus();

    private SantaClaus() {
        //Singleton
    }

    public static SantaClaus getInstance() {
        return SantaClaus.INSTANCE;
    }

    public List<Future<Toy>> buildDolls(int number) {
        final List<Future<Toy>> futureToys = new CopyOnWriteArrayList<>();
        for (int i = 0; i < number; i++) {
            futureToys.add(executor.submit(() -> Workshop.getInstance().buildDoll()));
        }
        return futureToys;
    }

    public List<Future<Toy>> buildBicycles(int number) {
        final List<Future<Toy>> futureToys = new CopyOnWriteArrayList<>();
        for (int i = 0; i < number; i++) {
            futureToys.add(executor.submit(() -> Workshop.getInstance().buildBicycle()));
        }
        return futureToys;
    }

}
