package tripDemo;

import io.restassured.response.Response;
import org.apache.commons.lang3.RandomUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tripDemo.api.ApiHelper;
import tripDemo.comparator.TripComparator;
import tripDemo.dictionaries.IPathEnum;
import tripDemo.dictionaries.TripPathEnum;
import tripDemo.generator.JsonGenerator;
import tripDemo.model.Passenger;
import tripDemo.model.Trip;
import tripDemo.service.ConfigQA;

import java.util.ArrayList;
import java.util.Map;

public class TripTest {

    private Map<IPathEnum, String> serviceDataMap;
    private Trip createTrip, putTrip;

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
                .withId(6L)
                .withRandomMainInfo(1)
                .withPassengers(new ArrayList<>() {{
                    add(new Passenger.Builder()
                            .withId(10L)
                            .withRandomCompletely().build());
                }}).build();
    }

    @Test
    public void createTrip() {
        String result = JsonGenerator.toJsonString(createTrip);
        String path = serviceDataMap.get(TripPathEnum.CREATE_TRIP);
        Response response = ApiHelper.post(path, result);
        System.out.println(response.getBody().prettyPrint());
        Trip responseTrip = response.as(Trip.class);
        //new TripComparator(responseTrip, createTrip).compare();
        new TripComparator(responseTrip, createTrip).compareTrip();

    }
    @Test
    public void getTrip() {
        String path = serviceDataMap.get(TripPathEnum.GET_TRIP);
        Response response = ApiHelper.get(path, 6);
        System.out.println(response.getBody().prettyPrint());
    }

    @Test
    public void putTrip() {
        String path = serviceDataMap.get(TripPathEnum.PUT_TRIP);
        String result = JsonGenerator.toJsonString(putTrip);
        Response response = ApiHelper.put(path, result);
        System.out.println(response.getBody().prettyPrint());
    }

    @Test
    public void deleteTrip() {
        String path = serviceDataMap.get(TripPathEnum.DELETE_TRIP);
        Response response = ApiHelper.delete(path, 6);
        System.out.println(response.getBody().prettyPrint());
    }
}