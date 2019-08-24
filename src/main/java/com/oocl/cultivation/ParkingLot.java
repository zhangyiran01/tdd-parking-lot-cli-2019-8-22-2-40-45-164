package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    //属性

    private final int capacity;
    private  int size=0;
    private Map<ParkingTicket, Car> cars = new HashMap<>();


    //getter  setter
    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Map<ParkingTicket, Car> getCars() {
        return cars;
    }

    public void setCars(Map<ParkingTicket, Car> cars) {
        this.cars = cars;
    }

    public ParkingLot() {

        this(10);
    }

    public ParkingLot(int capacity) {

        this.capacity = capacity;
    }


    //方法
    public ParkingTicket parkCar(Car car){
        if(size >= this.capacity){
            return null;
        }else{
            ParkingTicket ticket=new ParkingTicket();
            cars.put(ticket,car);
            size++;
            return  ticket;
        }

    }
    public Car fetchCar(ParkingTicket ticket){
        Car car=null;
        for (ParkingTicket carTicket:cars.keySet()){
            if((carTicket == ticket) && (cars.get(ticket) != null)){
                car = cars.get(ticket);
                cars.put(ticket,null);
                size--;
            }
        }
        return car;

    }

    public int getAvailableParkingPosition() {
        return cars.size() - capacity;
    }
}
