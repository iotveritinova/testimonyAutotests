package tripDemo.service;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import lombok.Getter;
import tripDemo.db.ConnectionProperties;
import tripDemo.dictionaries.IPathEnum;
import tripDemo.dictionaries.ServiceEnum;

import java.util.HashMap;
import java.util.Map;

public class ConfigQA {
    @Getter
    private Map<IPathEnum, String> serviceDataMap = new HashMap<>();
    //3. В конфиг файле считать свойства для подключения, для этого создадим еще один map,
//ключом которого будет являться ServiceEnum, а значением, заполненный объект ConnectionProperties.
    @Getter
    private Map<ServiceEnum, ConnectionProperties> dbConnectionDataMap = new HashMap<>();
    private static ConfigQA instance;

    public static ConfigQA getInstance() {
        if (instance == null) {
            instance = new ConfigQA();
        }
        return instance;
    }

    private ConfigQA() {
       Config config = ConfigFactory.parseResources("config.conf");
        String port, host;
        for (ServiceEnum value : ServiceEnum.values()) {
            Config conf = config.getConfig("service").getConfig(value.name().toLowerCase());
            host = conf.getString("host");
            port = conf.getString("port");
            Config pathsConf = conf.getConfig("path");
            for (IPathEnum iPathEnum : value.getPathEnumList()) {
                String path = pathsConf.getString(iPathEnum.name().toLowerCase());
                serviceDataMap.put(iPathEnum, generateFullPath(host, port, path));
            }
            Config dbConf = conf.getConfig("db");
            ConnectionProperties connectionProperties = new ConnectionProperties();
            connectionProperties.setUrl(dbConf.getString("url"));
            connectionProperties.setPassword(dbConf.getString("password"));
            connectionProperties.setUser(dbConf.getString("user"));
            dbConnectionDataMap.put(ServiceEnum.TRIP, connectionProperties);
        }
    }

    public String generateFullPath(String host, String port, String path) {
        return host + ":" + port + "/" + path;
    }
}