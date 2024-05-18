package tripDemo.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import tripDemo.dictionaries.ServiceEnum;
import tripDemo.model.CompanyEntity;
import tripDemo.model.PassengerEntity;
import tripDemo.model.TripEntity;
import tripDemo.service.ConfigQA;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class BaseConnection {
    private final Map<ServiceEnum, Connection> connectionMap;
    private final ConfigQA configQA;

    private static BaseConnection instance;

    private BaseConnection() {
        connectionMap = new ConcurrentHashMap<>();
        configQA = ConfigQA.getInstance();
    }

    public static BaseConnection getInstance() {
        if (instance == null) {
            instance = new BaseConnection();
        }
        return instance;
    }

    public Connection getConnection(ServiceEnum serviceEnum) {
        if (Objects.nonNull(serviceEnum)) {
            return connectionMap.computeIfAbsent(serviceEnum,
                    a -> {
                        ConnectionProperties properties = configQA.getDbConnectionDataMap().get(a);
                        Connection connection = null;
                        try {
                            connection = DriverManager.getConnection(properties.getUrl(),
                                    properties.getUser(),
                                    properties.getPassword());
                        } catch (SQLException throwable) {
                            throwable.printStackTrace();
                        }
                        return connection;
                    });
        }
        throw new IllegalArgumentException();
    }

    public Connection getConnection2(ServiceEnum serviceEnum) {
        if (Objects.nonNull(serviceEnum)) {
            //(Session) wasn't in the manual
            return connectionMap.computeIfAbsent(serviceEnum,
                    a -> {
                        Configuration configuration = new Configuration();
                        configuration.setProperties(getSettings(a));
                        getClasses(a).forEach(configuration::addAnnotatedClass);
                        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                                .applySettings(configuration.getProperties()).build();
                        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
                        //(Connection) wasn't in the manual
                        return (Connection) sessionFactory.openSession();
                    });
        }
        throw new IllegalArgumentException();
    }

    public Session getSession(ServiceEnum serviceEnum) {
        if (Objects.nonNull(serviceEnum)) {
            //(Session) wasn't in the manual
            return (Session) connectionMap.computeIfAbsent(serviceEnum,
                    a -> {
                        Configuration configuration = new Configuration();
                        configuration.setProperties(getSettings(a));
                        getClasses(a).forEach(configuration::addAnnotatedClass);
                        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                                .applySettings(configuration.getProperties()).build();
                        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
                        //(Connection) wasn't in the manual
                        return (Connection) sessionFactory.openSession();
                    });
        }
        throw new IllegalArgumentException();
    }

    public void closeConnection(ServiceEnum serviceEnum) {
        connectionMap.computeIfPresent(serviceEnum,
                (a, b) -> {
                    try {
                        connectionMap.remove(a).close();
                    } catch (SQLException exception) {
                        exception.printStackTrace();
                    }
                    return null;
                });
    }

    //при помощи механизма switch, отберет нужные для работы с той или иной БД классы сущностей.
    private List<Class<?>> getClasses(ServiceEnum serviceEnum) {
        List<Class<?>> classes = new ArrayList<>();
        switch (serviceEnum) {
            case TRIP:
                classes.add(CompanyEntity.class);
                classes.add(TripEntity.class);
                classes.add(PassengerEntity.class);
        }
        return classes;
    }

    private Properties getSettings(ServiceEnum serviceEnum) {
        Properties properties = new Properties();
        ConnectionProperties connectionProperties = configQA.getDbConnectionDataMap().get(serviceEnum);
        System.out.println(connectionProperties);
        properties.put(Environment.DRIVER, connectionProperties.getDriver());
        properties.put(Environment.DIALECT, connectionProperties.getDialect());
        properties.put(Environment.URL, connectionProperties.getUrl());
        properties.put(Environment.USER, connectionProperties.getUser());
        properties.put(Environment.PASS, connectionProperties.getPassword());
        return properties;
    }

}
