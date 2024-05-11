package tripDemo.db;

import tripDemo.dictionaries.ServiceEnum;
import tripDemo.service.ConfigQA;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseConnection {
    private static Connection connection;
    //4. Создать класс BaseConnection, в котором будут два статических метода getConnection и closeConnection.
    // Метод getConnection() должен принимать параметр ServiceEnum, после этого проверять следующее:
    // Если для данного сервиса уже есть созданная сессия, то вернуть ее, иначе создать новое подключение.

    public static Connection getConnection(ServiceEnum serviceEnum) throws SQLException {
        ConnectionProperties connectionProperties = ConfigQA.getInstance()
                .getDbConnectionDataMap().get(serviceEnum);
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(connectionProperties.getUrl(), connectionProperties.getUser(), connectionProperties.getPassword());
        }
        return connection;
    }

    public static void closeConnection() throws SQLException {
        connection.close();
    }

}
