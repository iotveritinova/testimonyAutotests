package tripDemo;

import org.testng.annotations.Test;
import tripDemo.db.ConnectionProperties;
import tripDemo.dictionaries.ServiceEnum;
import tripDemo.model.Passenger;
import tripDemo.model.Trip;
import tripDemo.service.ConfigQA;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import static tripDemo.db.PassengerRepository.getPassengerById;
import static tripDemo.db.TripRepository.getTripById;

public class dbTest {
    private static final Map<ServiceEnum, ConnectionProperties> dbConnectionDataMap = ConfigQA.getInstance().getDbConnectionDataMap();

    @Test
    public void DBConnectAndSelect() throws SQLException {
        Passenger passenger = getPassengerById(3);
        Trip trip = getTripById(3);
        System.out.println(passenger);
        System.out.println(trip);
    }

    @Test
    public void DBConTest() {
        System.out.println(dbConnectionDataMap.get(ServiceEnum.TRIP));
    }
}
