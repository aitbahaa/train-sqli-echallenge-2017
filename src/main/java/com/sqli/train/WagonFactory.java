package com.sqli.train;

class WagonFactory {


    public static Wagon createWagon(char wagonChar){
        Wagon wagon = null;

        switch (wagonChar) {
            case 'H':
                wagon = new Head();
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

    }

}
