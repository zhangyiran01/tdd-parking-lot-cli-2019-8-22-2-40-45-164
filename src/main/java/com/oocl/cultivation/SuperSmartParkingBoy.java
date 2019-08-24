package com.oocl.cultivation;

import java.util.List;

public class SuperSmartParkingBoy extends  ParkingBoy {


    public SuperSmartParkingBoy(List parkingLots) {
        super(parkingLots);
    }

    @Override
    public ParkingTicket park(Car car) {
        float max=0;
        List<ParkingLot> parkingLotsList=getParkingLots();
        for(ParkingLot parkingLot:parkingLotsList){
            float canUse=parkingLot.getCapacity()-parkingLot.getSize();
            float useRate=canUse/parkingLot.getCapacity();
            if(canUse>max){
                max=canUse;
                super.setParkingLot(parkingLot);
            }
        }
        return  super.park(car);
    }
}
