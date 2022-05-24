package me.ablax.santaclaus.observer.interfaces;

public interface Observable {

    void subscribe(final Observer observer);

    void unsubscribe(final Observer observer);

    String getUpdate();

}
