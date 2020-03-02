package ParkingLot;

public class Motorcycle extends Vehicle {
    public Motorcycle(String licensePlate, String company) {
        this.spotsNeeded = 1;
        this.size = VehicleSize.MOTORCYCLE;
        this.licensePlate = licensePlate;
        this.company = company;
    }

    @Override
    public boolean canFitInSpot(ParkingSpot spot) {
        return spot.getSize() == VehicleSize.COMPACT || spot.getSize() == VehicleSize.MOTORCYCLE;
    }
}
