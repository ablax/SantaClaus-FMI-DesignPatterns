package me.ablax.santaclaus.commands;

import me.ablax.santaclaus.commands.interfaces.Command;
import me.ablax.santaclaus.observer.model.MagicBoard;

public class BuildBicycleCommand implements Command {
    @Override
    public void requestToy() {
        MagicBoard.getInstance().requestToy("Bicycle");
    }
}
