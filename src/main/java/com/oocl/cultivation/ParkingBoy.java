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
            setLastErrorMessage("The parkingLot capacity is not enough.");
        }
        if(ticket != null){
            setLastErrorMessage(null);
        }
        return ticket;
    }

    public Car fetch(ParkingTicket ticket) {
        if(ticket == null){
            setLastErrorMessage("Please provide your parking ticket.");
            return  null;
        }
        if(parkingLot.fetchCar(ticket) == null){
            setLastErrorMessage("Unrecognized parking ticket.");
        }
        return parkingLot.fetchCar(ticket);
    }

    public String getLastErrorMessage() {
        return lastErrorMessage;
    }
}
