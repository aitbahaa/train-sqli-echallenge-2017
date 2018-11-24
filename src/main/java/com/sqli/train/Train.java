package com.sqli.train;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Train {
    private final static String CONNECTOR = "::";
    List<Wagon> wagons = new LinkedList<>();

    public Train(String trainWagons) {

        trainWagons
                .chars()
                .mapToObj(chaar -> (char) chaar)
                .forEach(wagonChar -> {
                    Wagon tmpWagon = WagonFactory.createWagon(wagonChar);
                    if (tmpWagon instanceof Head && !wagons.isEmpty()) ((Head)tmpWagon).last();
                    wagons.add(
                            tmpWagon
                    );

                });

    }

    /*private Wagon constructWagon(char wagonChar) {
        Wagon wagon = null;

        switch (wagonChar) {
            case 'H':
                wagon = new Head(wagons.isEmpty());
                break;
            case 'P':
                wagon = new Passenger();
                break;
            case 'R':
                wagon = new Restaurant();
                break;
            case 'C':
                wagon = new Cargo();
                break;
            default:
                new IllegalArgumentException("type of wagon not defined");
        }

        return wagon;
    }*/

    public boolean fill() {
        Cargo cargo = (Cargo) findAnEmptyCargo();

        if (cargo != null) {
            cargo.fill();
            return true;
        }

        return false;
    }

    private Wagon findAnEmptyCargo() {
        return wagons.stream()
                .filter(wagon -> wagon instanceof Cargo && ((Cargo) wagon).isEmpty())
                .findAny()
                .orElse(null);
    }

    public void detachHead() {
        if (wagons.size() > 0)
            wagons.remove(0);
    }

    public void detachEnd() {
        if (wagons.size() > 0)
            wagons.remove(wagons.size() - 1);
    }

    public String print() {
        return wagons
                .stream()
                .map(Wagon::print)
                .collect(Collectors.joining(Train.CONNECTOR));
    }

    public static void main(String[] args) {
        Train train = new Train("HPRPH");
        System.out.println(train.print());

        train = new Train("HPRP");
        System.out.println(train.print());
    }

}
