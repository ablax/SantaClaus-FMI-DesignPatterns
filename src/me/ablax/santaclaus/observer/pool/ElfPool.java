package me.ablax.santaclaus.observer.pool;

import me.ablax.santaclaus.observer.interfaces.Observer;
import me.ablax.santaclaus.observer.model.Elf;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ElfPool implements Observer {

    private final static ElfPool INSTANCE = new ElfPool();
    private final static int MAXIMUM_ELVES = 50;
    private static List<Elf> availableElves = new CopyOnWriteArrayList<>();
    private static List<Elf> busyElves = new CopyOnWriteArrayList<>();

    private ElfPool() {
        // Singleton
    }

    public static ElfPool getInstance() {
        return INSTANCE;
    }

    public static Elf getAvailableElf() {
        final Elf elf;
        if (availableElves.isEmpty())
            elf = new Elf();
        else
            elf = availableElves.remove(0);
        busyElves.add(elf);
        return elf;
    }

    public static void freeElf(final Elf elf) {
        if (busyElves.contains(elf)) {
            busyElves.remove(elf);
            if (availableElves.size() < MAXIMUM_ELVES) {
                availableElves.add(elf);
                return;
            }
        }
        throw new RuntimeException("Elf not from our factory! We have security issue!");
    }

    @Override
    public void update() {
        final Elf availableElf = getAvailableElf();
        availableElf.buildToy();
        freeElf(availableElf);
    }
}
