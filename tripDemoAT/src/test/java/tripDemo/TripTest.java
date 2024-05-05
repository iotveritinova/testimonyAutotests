package tripDemo;

import org.junit.jupiter.api.Test;
import tripDemo.model.Passenger;
import tripDemo.model.Trip;

import java.util.ArrayList;
import java.util.List;

public class TripTest {

    @Test
    public void createTest() {
        Trip trip = new Trip();

        trip.setCompanyId(1L);
        trip.setPlane("Plane№2");
        trip.setTownFrom("Moskow");
        trip.setTownTo("Pekin");
        trip.setTimeOut("2021-05-16T03:31:43");
        trip.setTimeIn("2021-05-16T03:31:43");

        List<Passenger> passengerList = new ArrayList<>();
        Passenger passenger1 = new Passenger();
        passenger1.setFirstName("Andrey");
        passenger1.setMiddleName("Maksimov");
        passenger1.setLastName("Urkov");
        Passenger passenger2 = new Passenger();
        passenger2.setFirstName("Maksim");
        passenger2.setMiddleName("Maksimov");
        passenger2.setLastName("Urkov");

        passengerList.add(passenger1);
        passengerList.add(passenger2);
        trip.setPassengerList(passengerList);
    }
}
