package tripDemo;

import io.restassured.response.Response;
import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.Test;
import tripDemo.model.JsonGenerator;
import tripDemo.model.Passenger;
import tripDemo.model.Trip;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TripTest {

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
                .post("http://localhost:8080/trip/createTrip")
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
                .put("http://localhost:8080/trip/putTrip")
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
                .delete("http://localhost:8080/trip/deleteTrip/6")
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
                .get("http://localhost:8080/trip/getTrip/2")
                .then()
                .assertThat()
                .statusCode(200)
                .body("townFrom", equalTo("Moscow"));
    }

}
