package me.ablax.santaclaus.observer.pool;

import me.ablax.santaclaus.observer.interfaces.Observer;
import me.ablax.santaclaus.observer.model.Elf;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ElfPool implements Observer {

    private static final ElfPool INSTANCE = new ElfPool();

    public static ElfPool getInstance() {
        return INSTANCE;
    }

    private ElfPool() {
        // Singleton
    }

    private static List<Elf> availableElves = new CopyOnWriteArrayList<>();
    private static List<Elf> busyElves = new CopyOnWriteArrayList<>();

    @Override
    public void update() {
        final Elf availableElf = getAvailableElf();
        availableElf.buildToy();
        freeElf(availableElf);
    }

    public static Elf getAvailableElf(){
        final Elf elf;
        if(availableElves.isEmpty())
            elf = new Elf();
        else
         elf = availableElves.remove(0);
        busyElves.add(elf);
        return elf;
    }

    public static void freeElf(final Elf elf){
        if(busyElves.contains(elf)){
            busyElves.remove(elf);
            availableElves.add(elf);
            return;
        }
        throw new RuntimeException("Elf not from our factory! We have security issue!");
    }
}
