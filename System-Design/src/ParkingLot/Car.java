package ParkingLot;

public class Car extends Vehicle {

    public Car(String licensePlate, String company) {
        spotsNeeded = 1;
        size = VehicleSize.COMPACT;
        this.licensePlate = licensePlate;
        this.company = company;
    }

    @Override
    public boolean canFitInSpot(ParkingSpot spot) {
        return spot.getSize() == VehicleSize.COMPACT;
    }
}
