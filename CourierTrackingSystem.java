import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// Parcel class to represent each parcel
class Parcel {
    private String packageNumber;
    private String currentLocation;
    private ArrayList<String> deliveryHistory;

    public Parcel(String packageNumber, String initialLocation) {
        this.packageNumber = packageNumber;
        this.currentLocation = initialLocation;
        this.deliveryHistory = new ArrayList<>();
        this.deliveryHistory.add(initialLocation);
    }

    public String getPackageNumber() {
        return packageNumber;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public ArrayList<String> getDeliveryHistory() {
        return deliveryHistory;
    }

    public void updateLocation(String newLocation) {
        if (newLocation != null && !newLocation.isEmpty()) {
            this.currentLocation = newLocation;
            this.deliveryHistory.add(newLocation);
        } else {
            System.out.println("Invalid location.");
        }
    }

    @Override
    public String toString() {
        return "Parcel{" +
                "packageNumber='" + packageNumber + '\'' +
                ", currentLocation='" + currentLocation + '\'' +
                ", deliveryHistory=" + deliveryHistory +
                '}';
    }
}

// CourierTrackingSystem class to manage the system
public class CourierTrackingSystem {
    private Map<String, Parcel> parcelMap; // Using HashMap for O(1) lookups

    public CourierTrackingSystem() {
        this.parcelMap = new HashMap<>();
    }

    // Add a parcel to the system
    public void addParcel(Parcel parcel) {
        if (parcel != null && !parcelMap.containsKey(parcel.getPackageNumber())) {
            parcelMap.put(parcel.getPackageNumber(), parcel);
        } else {
            System.out.println("Parcel already exists or invalid.");
        }
    }

    // Retrieve a parcel by its package number
    public Parcel getParcel(String packageNumber) {
        return parcelMap.get(packageNumber);
    }

    // Display the details of a parcel
    public void displayParcelDetails(String packageNumber) {
        Parcel parcel = getParcel(packageNumber);
        if (parcel != null) {
            System.out.println(parcel);
        } else {
            System.out.println("Parcel not found!");
        }
    }

    // Main method to simulate the tracking system
    public static void main(String[] args) {
        CourierTrackingSystem system = new CourierTrackingSystem();

        // Create new parcel and add to the system
        Parcel parcel1 = new Parcel("12345", "Mumbai");
        system.addParcel(parcel1);

        // Update the location of the parcel
        parcel1.updateLocation("Delhi");
        parcel1.updateLocation("Ahmedabad");

        // Retrieve and display the parcel details
        system.displayParcelDetails("12345");

        // Try retrieving a non-existent parcel
        system.displayParcelDetails("99999");
    }
}

