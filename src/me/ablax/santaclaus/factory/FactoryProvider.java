package me.ablax.santaclaus.factory;

import me.ablax.santaclaus.factory.interfaces.AbstractFactory;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class FactoryProvider {

    private static final Map<String, Class<? extends AbstractFactory>> factoryMap = new HashMap<>();

     static {
        //Usually some reflections to scan all Classes in given package - but for a project with two factories it's not worth it.
        try {
            Class.forName("me.ablax.santaclaus.factory.toys.BicycleFactory");
            Class.forName("me.ablax.santaclaus.factory.toys.DollFactory");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void registerFactory(final String factoryName, final Class<? extends AbstractFactory> abstractFactory) {
        if(!factoryMap.containsKey(factoryName)){
            factoryMap.put(factoryName, abstractFactory);
        }else{
            throw new RuntimeException("This factory is already registered!");
        }
    }

    public static AbstractFactory getFactory(final String factoryName){
        try {
            return factoryMap.get(factoryName).getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

}
