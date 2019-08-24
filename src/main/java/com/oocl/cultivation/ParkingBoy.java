package com.oocl.cultivation;


public class ParkingBoy {

    private final ParkingLot parkingLot;
    private String lastErrorMessage;

    public ParkingBoy(ParkingLot parkingLot) {

        this.parkingLot = parkingLot;
    }

    public ParkingTicket park(Car car) {
        ParkingTicket ticket=parkingLot.parkCar(car);
        return ticket;
    }

    public Car fetch(ParkingTicket ticket) {
        if(ticket == null){
            return  null;
        }
        return parkingLot.fetchCar(ticket);
    }

    public String getLastErrorMessage() {
        return lastErrorMessage;
    }
}
