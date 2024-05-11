package tripDemo.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseConnection {
    private static Connection connection;
    //4. Создать класс BaseConnection, в котором будут два статических метода getConnection и closeConnection.
    // Метод getConnection() должен принимать параметр ServiceEnum, после этого проверять следующее:
    // Если для данного сервиса уже есть созданная сессия, то вернуть ее, иначе создать новое подключение.

    public static Connection getConnection() throws SQLException {
        //переменные перенести в ServiceEnum и добавить его в параметр метода
        String URL = "jdbc:postgresql://localhost:5432/postgres";
        String USER = "postgres";
        String PASSWORD = "148192";
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return connection;
    }

    public static void closeConnection() throws SQLException {
        connection.close();
    }

}
