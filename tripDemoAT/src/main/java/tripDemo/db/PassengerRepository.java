package tripDemo.db;

import tripDemo.model.Passenger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static tripDemo.db.BaseConnection.closeConnection;
import static tripDemo.db.BaseConnection.getConnection;

public class PassengerRepository {

    private static String quiry = "SELECT * FROM PASSENGER WHERE id=%s";
    //5. Создать классы TripRepository и PassangerRepository,
    //в которых нужно будет создать методы по извлечению данных из таблиц Trip и Passenger по id,
    //которые будут возвращать соответствующие модели.

    public static Passenger getPassengerById(Integer id) throws SQLException {
        ResultSet resultSet = getConnection().createStatement()
                .executeQuery(String.format(quiry, id));
        resultSet.next();
        Passenger passenger=new Passenger();
        passenger.setId(Long.valueOf(id));
        passenger.setFirstName(resultSet.getString("first_name"));
        passenger.setLastName(resultSet.getString("last_name"));
        passenger.setMiddleName(resultSet.getString("middle_name"));
        closeConnection();
        return passenger;
    }
}
