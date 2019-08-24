package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class ParkingManager extends  ParkingBoy {
    //属性
    private List<ParkingBoy> parkingBoys=new ArrayList<>();

    //getter setter
    public List<ParkingBoy> getParkingBoys() {
        return parkingBoys;
    }
    public void setParkingBoys(List<ParkingBoy> parkingBoys) {
        this.parkingBoys = parkingBoys;
    }

    //构造函数

    public ParkingManager(ParkingLot parkingLot) {
        super(parkingLot);
    }

    public ParkingManager(List parkingLots) {
        super(parkingLots);
    }

    //方法
    public List<ParkingBoy> add(ParkingBoy parkingBoy){
        if(parkingBoys.isEmpty() || !(parkingBoys.contains(parkingBoy))){
            parkingBoys.add(parkingBoy);
        }

        return parkingBoys;
    }

    public List<ParkingBoy> delete(ParkingBoy parkingBoy){
        if(parkingBoys.contains(parkingBoy)){
            parkingBoys.remove(parkingBoy);
        }
        return parkingBoys;
    }

    public ParkingTicket orderParkCar(ParkingBoy parkingBoy,Car car){
        ParkingTicket parkingTicket=parkingBoy.park(car);
        if(parkingTicket == null){
            setLastErrorMessage(parkingBoy.getLastErrorMessage());
        }
        return parkingTicket;
    }

    public Car orderFetch(ParkingBoy parkingBoy,ParkingTicket parkingTicket){

        Car car=parkingBoy.fetch(parkingTicket);
        if(car == null){
            setLastErrorMessage(parkingBoy.getLastErrorMessage());
        }
        return  car;
    }

}
