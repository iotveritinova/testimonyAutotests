package tripDemo;

import org.apache.commons.lang3.RandomUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tripDemo.comparator.TripComparator;
import tripDemo.db.PassengerRepository;
import tripDemo.db.TripRepository;
import tripDemo.dictionaries.IPathEnum;
import tripDemo.model.Passenger;
import tripDemo.model.Trip;
import tripDemo.service.ConfigQA;
import tripDemo.steps.TripSteps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

public class TripTest {

    private Map<IPathEnum, String> serviceDataMap;
    private Trip createTrip, putTrip;
    //пока это поле меняется вручную
    private long id=55L;

    @BeforeClass
    public void init() {
        serviceDataMap = ConfigQA.getInstance().getServiceDataMap();
        createTrip = new Trip.Builder()
                .withRandomMainInfo(1)
                .withPassengers(new ArrayList<>() {{
                    for (int i = 0; i < RandomUtils.nextInt(1, 3); i++) {
                        add(new Passenger.Builder().withRandomCompletely().build());
                    }
                }}).build();

        putTrip = new Trip.Builder()
                //Пока что нужно установить id существующей модели в базе
                .withId(id)
                .withRandomMainInfo(1)
                .withPassengers(new ArrayList<>() {{
                    add(new Passenger.Builder()
                            .withId(10L)
                            .withRandomCompletely().build());
                }}).build();
    }


    @Test (priority = 1)
    public void createTrip() {
           Trip responseTrip = TripSteps.sendPost(createTrip);
        new TripComparator(createTrip, responseTrip).compare();
        TripRepository tripRepository = new TripRepository();
        PassengerRepository passengerRepository = new PassengerRepository();
        Trip tripFromBD = tripRepository.getById(responseTrip.getId());
        for (Passenger passenger : responseTrip.getPassengerList()) {
            Passenger passengerFormBD = passengerRepository.getById(passenger.getId());
            tripFromBD.getPassengerList().add(passengerFormBD);
        }
        Collections.sort(tripFromBD.getPassengerList());
        new TripComparator(createTrip, tripFromBD).compare();
    }

    @Test (priority = 3)
    public void getTrip() {
        Trip responseTrip = TripSteps.sendGet(id);
        new TripComparator(putTrip, responseTrip).compare();
    }

    @Test (priority = 2)
    public void putTrip() {
        Trip responseTrip = TripSteps.sendPut(putTrip);
        new TripComparator(putTrip, responseTrip).compare();
    }

    @Test (priority = 4)
    public void deleteTrip() {
        Trip responseTrip = TripSteps.sendDelete(id);
        new TripComparator(putTrip, responseTrip).compare();
    }

}