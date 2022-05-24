package me.ablax.santaclaus.observer.pool;

import me.ablax.santaclaus.model.interfaces.Toy;
import me.ablax.santaclaus.observer.interfaces.Observer;
import me.ablax.santaclaus.observer.model.Elf;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

public final class ElfPool implements Observer {

    private static AtomicLong elfId = new AtomicLong(0);
    private final static ElfPool INSTANCE = new ElfPool();
    private final static int MAXIMUM_ELVES = 50;
    private final static List<Elf> availableElves = new CopyOnWriteArrayList<>();
    private final static List<Elf> busyElves = new CopyOnWriteArrayList<>();

    private ElfPool() {
        // Singleton
    }

    public static ElfPool getInstance() {
        return INSTANCE;
    }

    public static Elf getAvailableElf() {
        final Elf elf;
        while(availableElves.size() + busyElves.size() > MAXIMUM_ELVES){
            try {
                Thread.sleep(250 + new Random().nextInt(0,250));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        if (availableElves.isEmpty())
            elf = new Elf(elfId.getAndIncrement());
        else
            elf = availableElves.remove(0);
        busyElves.add(elf);
        return elf;
    }

    public static void freeElf(final Elf elf) {
        if (busyElves.contains(elf)) {
            busyElves.remove(elf);
            if (availableElves.size() + busyElves.size() < MAXIMUM_ELVES - 15) {
                availableElves.add(elf);
            }
            return;
        }
        throw new RuntimeException("Elf not from our factory! We have security issue!");
    }

    @Override
    public Toy update(final String topic) {
        final Elf availableElf = getAvailableElf();
        final Toy toy = availableElf.buildToy(topic);
        freeElf(availableElf);
        return toy;
    }
}
