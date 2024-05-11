package tripDemo.db;

import tripDemo.dictionaries.ServiceEnum;
import tripDemo.service.ConfigQA;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

public class BaseConnection {
    private static Connection connection;

    //4. Создать класс BaseConnection, в котором будут два статических метода getConnection и closeConnection.
    // Метод getConnection() должен принимать параметр ServiceEnum, после этого проверять следующее:
    // Если для данного сервиса уже есть созданная сессия, то вернуть ее, иначе создать новое подключение.

    public static Connection getConnection(ServiceEnum enumTrip) throws SQLException {
        //переменные перенести в ServiceEnum и добавить его в параметр метода
        //System.out.println(dbConnectionDataMap.get(ServiceEnum.TRIP));
       // ConnectionProperties connectionProperties = dbConnectionDataMap.get(enumTrip);
        String url =//connectionProperties.getUrl();//
                 "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "148192";
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(url, user, password);
        }
        return connection;
    }

    public static void closeConnection() throws SQLException {
        connection.close();
    }

}
