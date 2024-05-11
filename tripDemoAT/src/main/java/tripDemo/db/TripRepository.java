package tripDemo.db;

import tripDemo.model.Trip;

import java.sql.ResultSet;
import java.sql.SQLException;

import static tripDemo.db.BaseConnection.closeConnection;
import static tripDemo.db.BaseConnection.getConnection;

public class TripRepository {
    private static String quiry = "SELECT * FROM TRIP WHERE id=%s";
    //5. Создать классы TripRepository и PassangerRepository,
    //в которых нужно будет создать методы по извлечению данных из таблиц Trip и Passenger по id,
    //которые будут возвращать соответствующие модели.

    public static Trip getTripById(Integer id) throws SQLException {
        ResultSet resultSet = getConnection().createStatement()
                .executeQuery(String.format(quiry, id));
        resultSet.next();
        Trip trip = new Trip();
        trip.setId(Long.valueOf(id));
        trip.setCompanyId(resultSet.getLong("company_id"));
        trip.setTownFrom(resultSet.getString("town_from"));
        trip.setPlane(resultSet.getString("plane"));
        trip.setTownTo(resultSet.getString("town_to"));
        trip.setTimeOut(resultSet.getTimestamp("time_out").toLocalDateTime());
        trip.setTimeIn(resultSet.getTimestamp("time_in").toLocalDateTime());
        closeConnection();
        return trip;
    }
}
