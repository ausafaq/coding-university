package ParkingLot;

public class Level {
    private int floor;
    private ParkingSpot[] spots; //number of spots in each level
    private int availableSpots; // number of spots
    private static final int SPOT_PER_ROW = 0;

    public Level(int floor, int availableSpots) {
        this.floor = floor;
        this.availableSpots = availableSpots;
        spots = new ParkingSpot[availableSpots];

        int largeSpots = availableSpots / 4;
        int bikeSpots = availableSpots / 4;
        int compactSpots = availableSpots - (largeSpots + bikeSpots);
    }

    public int getAvailableSpots() {
        return availableSpots;
    }

    public boolean parkVehicle(Vehicle vehicle) {
        if(getAvailableSpots() < vehicle.getSpotsNeeded()) {
            return false;
        }

        int spotNumber = findAvailableSpots(vehicle);
        if(spotNumber < 0) {
            return false;
        }
        return parkStartingAtSpot(spotNumber, vehicle);
    }

    private boolean parkStartingAtSpot(int num, Vehicle vehicle) {
        vehicle.clearSpots();
        boolean success = true;
        for(int i = num; i < num + vehicle.spotsNeeded; i++) {
            success &= spots[i].park(vehicle);
        }
        availableSpots -= vehicle.spotsNeeded;
        return success;
    }

    private int findAvailableSpots(Vehicle vehicle) {
        int spotsNeeded = vehicle.getSpotsNeeded();
        int lastRow = -1;
        int spotsFound = 0;
        for(int i = 0; i < spots.length; i++) {
            ParkingSpot spot = spots[i];
            // available spot logic here
        }
        return -1;
    }

    public void spotFreed() {
        availableSpots++;
    }


}
