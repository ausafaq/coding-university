public class TrafficLight {

    private Integer greenOnRoadA;

    public TrafficLight() {
        greenOnRoadA = 1;
    }

    public void carArrived(
            int carId,
            int roadId,
            int direction,
            Runnable turnGreen,
            Runnable crossCar
    ) throws InterruptedException {
        synchronized (greenOnRoadA) {
            if(!isGreen(roadId)) {
                turnGreen.run();
                toggleGreen(roadId);
            }
            crossCar.run();
        }
    }

    private boolean isGreen(int roadId) {
        return roadId == greenOnRoadA.intValue();
    }

    private void toggleGreen(int roadId) {
        greenOnRoadA = roadId;
    }


}
