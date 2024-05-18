package tripDemo.db;

import lombok.Data;

@Data
public class ConnectionProperties {

    String url, password, user, driver, dialect;

}
   /* Вооружившись всеми знаниями полученными в предыдущих уроках, предлагаю выполнить вам следующее задание:
+ 1. Нужно вынести в config файл свойства для подключения к базе данных.
 Нужно учесть, что наш тестовый сервис может являться микросервисом и иметь собственную базу данных,
 поэтому параметры для подключения должны быть каким - то образом заключены в блок trip.

+2. Создать класс ConnectionProperties, который будет в себе содержать всего лишь
3 свойства: url, password, user.

+3. В конфиг файле считать свойства для подключения, для этого создадим еще один map,
ключом которого будет являться ServiceEnum, а значением, заполненный объект ConnectionProperties.

+-4. Создать класс BaseConnection, в котором будут два статических метода getConnection и closeConnection.
Метод getConnection() должен принимать параметр ServiceEnum, после этого проверять следующее: Если для данного сервиса уже есть созданная сессия, то вернуть ее, иначе создать новое подключение.

+5. Создать классы TripRepository и PassangerRepository,
в которых нужно будет создать методы по извлечению данных из таблиц Trip и Passenger по id,
которые будут возвращать соответствующие модели.

    */
//}
