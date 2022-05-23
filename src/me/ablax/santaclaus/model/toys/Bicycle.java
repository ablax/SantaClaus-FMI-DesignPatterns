package me.ablax.santaclaus.model.toys;

import me.ablax.santaclaus.model.Toy;

public class Bicycle implements Toy {

    private String color;

    public Bicycle() {
    }

    public Bicycle(final String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(final String color) {
        this.color = color;
    }
}
