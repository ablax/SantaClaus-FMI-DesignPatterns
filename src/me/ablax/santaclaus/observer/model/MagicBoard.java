package me.ablax.santaclaus.observer.model;

import me.ablax.santaclaus.observer.interfaces.Observable;
import me.ablax.santaclaus.observer.interfaces.Observer;
import me.ablax.santaclaus.observer.pool.ElfPool;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Murad Hamza on 4/5/22
 */
public class MagicBoard implements Observable {

   private static MagicBoard INSTANCE = new MagicBoard();
   static {
       try {
           Class.forName("me.ablax.santaclaus.observer.pool.ElfPool");
           INSTANCE.subscribe(ElfPool.getInstance());
       } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
       }
   }

    public static MagicBoard getInstance() {
        return INSTANCE;
    }

    private final List<Observer> observerList;
    private String topic;

    private MagicBoard() {
        this.observerList = new ArrayList<>();
    }

    public void requestToy(final String topic) {
        this.topic = topic;
        this.notifyObservers();
    }

    @Override
    public void subscribe(final Observer observer) {
        this.observerList.add(observer);
    }

    @Override
    public void unsubscribe(final Observer observer) {
        this.observerList.remove(observer);
    }

    protected void notifyObservers() {
        this.observerList.parallelStream().forEach(Observer::update);
    }

    @Override
    public String getUpdate() {
        return topic;
    }
}
