class Vehicle {
    String numberPlate;
    String type;
    boolean isEmergency;
    boolean isSpeeding;

    Vehicle(String numberPlate, String type, boolean isEmergency, boolean isSpeeding) {
        this.numberPlate = numberPlate;
        this.type = type;
        this.isEmergency = isEmergency;
        this.isSpeeding = isSpeeding;
    }

    String getDetails() {
        return numberPlate + " (" + type + ") - Emergency: " + isEmergency + " - Speeding: " + isSpeeding;
    }
}

class Traffic {
    String signalName;
    Vehicle[] lanes;

    Traffic(String signalName, int size) {
        this.signalName = signalName;
        this.lanes = new Vehicle[size];
    }

    void assignVehicle(int index, Vehicle v) {
        if (index >= 0 && index < lanes.length) {
            lanes[index] = v;
        }
    }

    void displayLanes() {
        System.out.println("Traffic Signal: " + signalName);
        for (int i = 0; i < lanes.length; i++) {
            if (lanes[i] != null) {
                System.out.println("  Lane " + i + ": " + lanes[i].getDetails());
            } else {
                System.out.println("  Lane " + i + ": Empty");
            }
        }
    }
}

class MonitoringEnforcement {
    Vehicle[] monitoredVehicles;

    MonitoringEnforcement(int size) {
        monitoredVehicles = new Vehicle[size];
    }

    void addMonitoredVehicle(int index, Vehicle v) {
        if (index >= 0 && index < monitoredVehicles.length) {
            monitoredVehicles[index] = v;
        }
    }

    void displayMonitoredVehicles() {
        System.out.println("Monitored Vehicles:");
        for (int i = 0; i < monitoredVehicles.length; i++) {
            if (monitoredVehicles[i] != null) {
                System.out.println("  " + monitoredVehicles[i].getDetails());
            }
        }
    }
}

public class SimpleTrafficSystem {
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("TN01AB1234", "Car", false, false);
        Vehicle v2 = new Vehicle("TN02CD5678", "Ambulance", true, false);
        Vehicle v3 = new Vehicle("TN03EF9012", "Truck", false, true);

        Traffic traffic = new Traffic("Main Signal", 3);
        traffic.assignVehicle(0, v1);
        traffic.assignVehicle(1, v2);
        traffic.assignVehicle(2, v3);

        MonitoringEnforcement monitor = new MonitoringEnforcement(3);
        monitor.addMonitoredVehicle(0, v1);
        monitor.addMonitoredVehicle(1, v2);
        monitor.addMonitoredVehicle(2, v3);

        System.out.println("---- TRAFFIC LANES ----");
        traffic.displayLanes();

        System.out.println("\n---- MONITORING ----");
        monitor.displayMonitoredVehicles();
    }
}
