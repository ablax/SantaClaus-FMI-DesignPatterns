package me.ablax.santaclaus;

import me.ablax.santaclaus.commands.BuildBicycleCommand;

public class MainClass {
    public static void main(String[] args) {
        new BuildBicycleCommand().requestToy();
    }
}
