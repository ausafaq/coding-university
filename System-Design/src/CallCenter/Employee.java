package CallCenter;

public class Employee {
    private enum Level {
        FRESHER,
        TECHNICAL_LEAD,
        MANAGER
    }

    private String name;
    private Level rank;
    private boolean isAvailable;

    public Employee(String name, boolean isAvailable, int rank) {
        this.name = name;
        this.isAvailable = isAvailable;
        if(rank == 0) {
            this.rank = Level.FRESHER;
        } else if (rank == 1) {
            this.rank = Level.TECHNICAL_LEAD;
        } else {
            this.rank = Level.MANAGER;
        }
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public void receiveCall(Call call) {
        // Call call
    }

    public void callHandled(Call call) {
        // Call handled
    }

}

