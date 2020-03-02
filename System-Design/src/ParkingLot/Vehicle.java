package ParkingLot;

import java.util.List;

public abstract class Vehicle {
    protected String licensePlate;
    protected int spotsNeeded;
    protected VehicleSize size;
    protected String company;
    protected List<ParkingSpot> parkingSpots;

    public int getSpotsNeeded() {
        return spotsNeeded;
    }

    public VehicleSize getSize() {
        return size;
    }

    public void parkInSpot(ParkingSpot spot) {
        parkingSpots.add(spot);
    }

    public void clearSpots() {
        // remove car from spot, and notify to the system that the spot is gone
        for(int i = 0; i < parkingSpots.size(); i++) {
            parkingSpots.remove(i);
        }
        parkingSpots.clear();
    }

    public abstract boolean canFitInSpot(ParkingSpot spot);

}
