package com.oocl.cultivation;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingBoy {

    private  ParkingLot parkingLot;

    private List<ParkingLot> parkingLots;
    private String lastErrorMessage;


    //getter  setter函数
    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }
    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }
    public void setParkingLots(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }


    public void setLastErrorMessage(String lastErrorMessage) {
        this.lastErrorMessage = lastErrorMessage;
    }
    public String getLastErrorMessage() {
        return lastErrorMessage;
    }


    //构造函数
    public ParkingBoy(ParkingLot parkingLot) {

        this.parkingLot = parkingLot;
    }
    public ParkingBoy(List parkingLots) {
        this.parkingLots = parkingLots;
    }


    //方法
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

    public Map<Car,ParkingLot> park(ArrayList<Car> carList){
        Map resultMap=new HashMap();
        List<ParkingLot> parkingLotsList=getParkingLots();
        for(Car car:carList){
            for (ParkingLot parkingLot:parkingLotsList){
                setParkingLot(parkingLot);
                if(park(car) != null){
                    resultMap.put(car,parkingLot);
                    break;
                }
            }
        }
        return resultMap;
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
}
