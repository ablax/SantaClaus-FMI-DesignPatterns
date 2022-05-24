package me.ablax.santaclaus;

import me.ablax.santaclaus.commands.Workshop;
import me.ablax.santaclaus.model.SantaClaus;
import me.ablax.santaclaus.model.interfaces.Toy;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class MainClass {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final SantaClaus santaClaus = SantaClaus.getInstance();

        final List<Future<Toy>> toysToMake = new CopyOnWriteArrayList<>();

        toysToMake.addAll(santaClaus.buildBicycles(500));
        toysToMake.addAll(santaClaus.buildDolls(500));

        for (final Future<Toy> toyFuture : toysToMake) {
            toyFuture.get();
        }

        final int toMakeCount = toysToMake.size();
        final int madeCount = Workshop.getToys().size();
        if(toMakeCount == madeCount){
            System.out.println("All requested toys were built!");
        }else{
            System.out.println("Needed toys - " + toMakeCount);
            System.out.println("Made toys - " + madeCount);
            System.out.println("Elves seem to have been slacking and there will be kids left without toys.");
        }
    }
}
