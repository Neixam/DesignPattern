package fr.uge.poo.ducks;

import java.util.ServiceLoader;
import java.util.stream.Stream;

public class DuckFarmBetter {
    public static void main(String[] args) {
        var ducks = ServiceLoader.load(DuckFactory.class);
        for (DuckFactory duck : ducks) {
            System.out.println(duck.withName("Riri").quack());
            System.out.println(duck.withName("Fifi").quack());
            System.out.println(duck.withName("Loulou").quack());
        }
    }
}
