package tripDemo;

import io.restassured.response.Response;
import org.apache.commons.lang3.RandomUtils;
import org.testng.annotations.*;
import tripDemo.dictionaries.IPathEnum;
import tripDemo.dictionaries.TripPathEnum;
import tripDemo.generator.JsonGenerator;
import tripDemo.model.Passenger;
import tripDemo.model.Trip;
import tripDemo.service.ConfigQA;

import java.util.ArrayList;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TripTest {

    private static Map<IPathEnum, String> serviceDataMap;

    @BeforeClass
    public static void init(){
        serviceDataMap= ConfigQA.getInstance().getServiceDataMap();
    }

    @Test
    public void createTrip() {
        Trip trip = new Trip.Builder()
                .withRandomMainInfo(1)
                .withPassengers(new ArrayList<>() {{
                    for (int i = 0; i < RandomUtils.nextInt(1, 3); i++) {
                        add(new Passenger.Builder().withRandomCompletely().build());
                    }
                }}).build();
        String body = JsonGenerator.toJsonString(trip);
        Response response = given().log().all(true)
                .contentType("application/json")
                .accept("application/json")
                .body(body)
                .when()
                .post(serviceDataMap.get(TripPathEnum.CREATE_TRIP))
                .thenReturn();
        System.out.println(response.getBody().prettyPrint());
        /*
        Trip tripResult = given().log().all(true)
                .contentType("application/json")
                .accept("application/json")
                .body(trip)
                .when()
                .post("http://localhost:8080/trip/createTrip")
                .as(Trip.class);
        * */
    }

    @Test
    public void putTrip() {
        Trip trip = new Trip.Builder()
                //Пока что нужно установить id существующей модели в базе
                .withId(6L)
                .withRandomMainInfo(1)
                .withPassengers(new ArrayList<>() {{
                    for (int i = 0; i < RandomUtils.nextInt(1, 3); i++) {
                        add(new Passenger.Builder().withRandomCompletely().build());
                    }
                }}).build();
        String body = JsonGenerator.toJsonString(trip);
        Response response = given()
                .log().all(true)
                .contentType("application/json")
                .accept("application/json")
                .body(body )
                .when()
                .put(serviceDataMap.get(TripPathEnum.PUT_TRIP))
                .thenReturn();

        System.out.println(response.getBody().prettyPrint());
    }

    @Test
    public void deleteTrip() {
        Response response = given()
                .log().all(true)
                .contentType("application/json")
                .accept("application/json")
                .when()
                .delete(serviceDataMap.get(TripPathEnum.DELETE_TRIP))
                .thenReturn();
        System.out.println(response.getBody().prettyPrint());
    }

    @Test
    public void getTrip() {
        given()
                .log().all(true)
                .contentType("application/json")
                .accept("application/json")
                .when()
                .get(serviceDataMap.get(TripPathEnum.GET_TRIP))
                .then()
                .assertThat()
                .statusCode(200)
                .body("townFrom", equalTo("Moscow"));
    }

}
