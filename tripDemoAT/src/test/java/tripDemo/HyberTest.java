package tripDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.testng.annotations.Test;
import tripDemo.model.Passenger;
import tripDemo.model.Trip;

public class HyberTest {
    @Test
    public void HybernateEntitiesTest(){
        System.out.println("pumpum");
        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addAnnotatedClass(Passenger.class);
        configuration.addAnnotatedClass(Trip.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        Session session = sessionFactory.openSession();

        //Генерация тестовой модели
     //   Passenger passenger = new Passenger ();
        //passenger.setFirstName("Петр");
       // passenger.setMiddleName("Петрович");
        //passenger.setLastName("Петров");
       // client.setBirthDay(LocalDate.now().minusYears(25));

     //   session.beginTransaction();
        //Сохранение клиента
     //   session.save(passenger);
     //   session.getTransaction().commit();
        //Считывание объекта из БД
     //   Passenger newPassenger = session.get(Passenger.class, passenger.getId());
       // Passenger newPassenger = session.get(Passenger.class, 60);
     //   System.out.println(newPassenger);
     //   System.out.println(passenger);

        Trip entity = session.get(Trip.class, 3);
       System.out.println(entity);


    }
}
