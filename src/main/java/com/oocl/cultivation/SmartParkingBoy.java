package com.oocl.cultivation;

import java.util.List;

public class SmartParkingBoy extends ParkingBoy {

    public SmartParkingBoy(List parkingLots) {
        super(parkingLots);
    }

    @Override
    public ParkingTicket park(Car car) {
        int max=0;
        List<ParkingLot> parkingLotsList=getParkingLots();
        for(ParkingLot parkingLot:parkingLotsList){
            int canUse=parkingLot.getCapacity()-parkingLot.getSize();
            if(canUse>max){
                max=canUse;
                super.setParkingLot(parkingLot);
            }
        }
        return  super.park(car);
    }
}
