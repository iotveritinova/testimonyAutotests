package tripDemo.comparator;

import lombok.AllArgsConstructor;
import org.testng.Assert;
import tripDemo.model.Passenger;
import tripDemo.model.Trip;


@AllArgsConstructor
public class TripComparator implements IComparator {
    private final Trip actual, expected;

    public void compare() {
        Assert.assertEquals(actual.getCompanyId(), expected.getCompanyId());
        Assert.assertEquals(actual.getPlane(), expected.getPlane());
        Assert.assertEquals(actual.getTownFrom(), expected.getTownFrom());
        Assert.assertEquals(actual.getTownTo(), expected.getTownTo());
        Assert.assertEquals(actual.getTimeOut(), expected.getTimeOut());
        Assert.assertEquals(actual.getTimeIn(), expected.getTimeIn());
        Assert.assertEquals(actual.getPassengerList().size(), expected.getPassengerList().size());
        for (int i = 0; i < actual.getPassengerList().size(); i++) {
            Passenger actualPassenger = actual.getPassengerList().get(i);
            Passenger expectedPassenger = expected.getPassengerList().get(i);
            Assert.assertEquals(actualPassenger.getFirstName(), expectedPassenger.getFirstName());
            Assert.assertEquals(actualPassenger.getMiddleName(), expectedPassenger.getMiddleName());
            Assert.assertEquals(actualPassenger.getLastName(), expectedPassenger.getLastName());
        }
    }
}