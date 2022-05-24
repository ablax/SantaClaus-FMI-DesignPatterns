package me.ablax.santaclaus.observer.model;

import me.ablax.santaclaus.model.interfaces.Toy;
import me.ablax.santaclaus.observer.interfaces.Observable;
import me.ablax.santaclaus.observer.interfaces.Observer;
import me.ablax.santaclaus.observer.pool.ElfPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class MagicBoard implements Observable {

    private static final ExecutorService executor = Executors.newCachedThreadPool();
    private static MagicBoard INSTANCE = new MagicBoard();

    static {
        try {
            Class.forName("me.ablax.santaclaus.observer.pool.ElfPool");
            INSTANCE.subscribe(ElfPool.getInstance());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private final List<Observer> observerList;
    private MagicBoard() {
        this.observerList = new ArrayList<>();
    }

    public static MagicBoard getInstance() {
        return INSTANCE;
    }

    public Toy requestToy(final String topic) {
        return this.notifyObservers(topic);
    }

    @Override
    public void subscribe(final Observer observer) {
        this.observerList.add(observer);
    }

    @Override
    public void unsubscribe(final Observer observer) {
        this.observerList.remove(observer);
    }

    private Toy notifyObservers(final String topic) {
        Toy toy = null;
        for (Observer observer : this.observerList) {
            try {
                toy = executor.submit(() -> observer.update(topic)).get();
            } catch (InterruptedException | ExecutionException e) {
                Thread.currentThread().interrupt();
            }
        }
        return toy;
    }

}
