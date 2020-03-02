package ParkingLot;

public class ParkingSpot {
    private Vehicle vehicle;
    private VehicleSize spotSize;
    private int lane;
    private int spotNumber;
    private Level level;

    public ParkingSpot(Level level, int lane, int spotNumber, VehicleSize size) {
        this.level = level;
        this.lane = lane;
        this.spotNumber = spotNumber;
        this.spotSize = size;
    }

    public boolean isAvailable() {
        return vehicle == null;
    }

    public boolean canFitVehicle(Vehicle vehicle) {
        return isAvailable() && vehicle.canFitInSpot(this);
    }

    public boolean park(Vehicle vehicle) {
        if(!canFitVehicle(vehicle)) {
            return false;
        }
        this.vehicle = vehicle;
        vehicle.parkInSpot(this);
        return true;
    }

    public VehicleSize getSize() {
        return spotSize;
    }

    public int getLane() {
        return lane;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public void removeVehicle() {
        level.spotFreed();
        vehicle = null;
    }

}
