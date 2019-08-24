package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final int capacity;
    private Map<ParkingTicket, Car> cars = new HashMap<>();

    public ParkingLot() {

        this(10);
    }

    public ParkingLot(int capacity) {

        this.capacity = capacity;
    }

    public ParkingTicket parkCar(Car car){
        ParkingTicket ticket=new ParkingTicket();
        cars.put(ticket,car);
        return  ticket;

    }
    public Car fetchCar(ParkingTicket ticket){
        Car car=null;
        for (ParkingTicket carTicket:cars.keySet()){
            if((carTicket == ticket) && (cars.get(ticket) != null)){
                car = cars.get(ticket);
                cars.put(ticket,null);
            }
        }
        return car;

    }

    public int getAvailableParkingPosition() {
        return cars.size() - capacity;
    }
}
