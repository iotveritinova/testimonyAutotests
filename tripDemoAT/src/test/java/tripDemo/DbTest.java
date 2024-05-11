package tripDemo;

import org.testng.annotations.Test;
import tripDemo.model.Passenger;
import tripDemo.model.Trip;

import java.sql.SQLException;

import static tripDemo.db.PassengerRepository.getPassengerById;
import static tripDemo.db.TripRepository.getTripById;

public class DbTest {

    @Test
    public void DBConnectAndSelect() throws SQLException {
        Passenger passenger = getPassengerById(3);
        Trip trip = getTripById(3);
        System.out.println(passenger);
        System.out.println(trip);
    }
}
