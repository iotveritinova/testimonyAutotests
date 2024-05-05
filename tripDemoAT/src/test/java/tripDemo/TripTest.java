package tripDemo;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import tripDemo.model.Passenger;
import tripDemo.model.Trip;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TripTest {

    @Test
    public void createTest() {
        Trip trip = createDefaultBodyTrip();
        Response response = given().log().all(true).contentType("application/json").accept("application/json").body(trip).when().post("http://localhost:8080/trip/createTrip").thenReturn();
        System.out.println(response.getBody().prettyPrint());
    }


    @Test
    public void getTrip() {
        given().log().all(true)
                .contentType("application/json")
                .accept("application/json")
                .when()
                .get("http://localhost:8080/trip/getTrip/2")
                .then()
                .assertThat()
                .statusCode(200)
                .body("townFrom", equalTo("Moscow"));
    }

    @Test
    public void createTripAs() {
        Trip trip = createDefaultBodyTrip();
        Trip tripResult = given().log().all(true)
                .contentType("application/json")
                .accept("application/json")
                .body(trip)
                .when()
                .post("http://localhost:8080/trip/createTrip")
                .as(Trip.class);
        System.out.println(tripResult);

    }

    private Trip createDefaultBodyTrip() {
        Trip trip = new Trip();
        trip.setCompanyId(1L);
        trip.setPlane("Plane№2");
        trip.setTownFrom("Moscow");
        trip.setTownTo("Pekin");
        trip.setTimeOut("2021-05-16T03:31:43");
        trip.setTimeIn("2021-05-16T03:31:43");

        List<Passenger> passengerList = new ArrayList<>();
        Passenger passenger1 = new Passenger();
        passenger1.setFirstName("Andrey");
        passenger1.setMiddleName("Maksimov");
        passenger1.setLastName("Urkov");
        Passenger passenger2 = new Passenger();
        passenger2.setFirstName("Maksim");
        passenger2.setMiddleName("Maksimov");
        passenger2.setLastName("Urkov");

        passengerList.add(passenger1);
        passengerList.add(passenger2);
        trip.setPassengerList(passengerList);
        return trip;
    }
}
