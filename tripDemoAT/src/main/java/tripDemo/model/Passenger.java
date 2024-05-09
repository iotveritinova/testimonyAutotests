package tripDemo.model;


import lombok.Data;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.builder.CompareToBuilder;

@Data
public class Passenger implements Comparable<Passenger> {
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;

    @Override
    public int compareTo(Passenger o) {
        return new CompareToBuilder()
                .append(getId(), o.getId())
                .append(getFirstName(), o.getFirstName())
                .append(getMiddleName(), o.getMiddleName())
                .append(getLastName(), o.getLastName())
                .toComparison();
    }

    public static class Builder {
        private final Passenger passenger;

        public Builder() {
            passenger = new Passenger();
        }

        public Builder withRandomCompletely() {
            passenger.firstName = RandomStringUtils.random(5, true, false);
            passenger.middleName = RandomStringUtils.random(5, true, false);
            passenger.lastName = RandomStringUtils.random(5, true, false);
            return this;
        }

        public Passenger build() {
            return passenger;
        }

        public Builder withFirstName(String firstName){
            passenger.firstName=firstName;
            return this;
        }

        public Builder withLastName(String lastName){
            passenger.lastName=lastName;
            return this;
        }

        public Builder withMiddleName(String middleName){
            passenger.middleName=middleName;
            return this;
        }

        public Builder withId(Long id){
            passenger.id=id;
            return this;
        }
    }
}