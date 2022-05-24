package me.ablax.santaclaus.model.toys;

import me.ablax.santaclaus.model.interfaces.Toy;

public class Doll implements Toy {

    private String hairColor;

    public Doll() {
    }

    public Doll(final String hairColor) {
        this.hairColor = hairColor;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(final String hairColor) {
        this.hairColor = hairColor;
    }
}
