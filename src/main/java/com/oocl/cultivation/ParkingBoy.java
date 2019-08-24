package com.oocl.cultivation;


public class ParkingBoy {

    private final ParkingLot parkingLot;

    public void setLastErrorMessage(String lastErrorMessage) {
        this.lastErrorMessage = lastErrorMessage;
    }

    private String lastErrorMessage;

    public ParkingBoy(ParkingLot parkingLot) {

        this.parkingLot = parkingLot;
    }

    public ParkingTicket park(Car car) {
        ParkingTicket ticket=parkingLot.parkCar(car);
        if(ticket == null){
            setLastErrorMessage("The parking lot is full.");
        }
        if(ticket != null){
            setLastErrorMessage(null);
        }
        return ticket;
    }

    public Car fetch(ParkingTicket ticket) {
        Car car=new Car();
        car=parkingLot.fetchCar(ticket);
        if(ticket == null){
            setLastErrorMessage("Please provide your parking ticket.");
            return  null;
        }
        if(car == null){
            setLastErrorMessage("Unrecognized parking ticket.");
        }
        return car;
    }

    public String getLastErrorMessage() {
        return lastErrorMessage;
    }
}
