package me.ablax.santaclaus;

import me.ablax.santaclaus.commands.BuildBicycleCommand;
import me.ablax.santaclaus.commands.BuildDollCommand;

public class MainClass {
    public static void main(String[] args) {
        final BuildBicycleCommand buildBicycleCommand = new BuildBicycleCommand();
        final BuildDollCommand buildDollCommand = new BuildDollCommand();

        buildDollCommand.requestToy();
        buildBicycleCommand.requestToy();
        buildDollCommand.requestToy();
        buildBicycleCommand.requestToy();
    }
}
