package me.ablax.santaclaus.observer.interfaces;

import me.ablax.santaclaus.model.interfaces.Toy;

public interface Observer {

    Toy update(final String topic);

}
