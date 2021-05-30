package entities;

import java.io.Serializable;
import java.util.Objects;

public abstract class SportsClub implements Serializable {

    private String nameOfTheClub;
    private String locationOfTheClub;

    public SportsClub(String nameOfTheClub, String locationOfTheClub) {
        this.nameOfTheClub = nameOfTheClub;
        this.locationOfTheClub = locationOfTheClub;
    }

    public String getNameOfTheClub() {
        return nameOfTheClub;
    }

    public void setNameOfTheClub(String nameOfTheClub) {
        this.nameOfTheClub = nameOfTheClub;
    }

    public String getLocationOfTheClub() {
        return locationOfTheClub;
    }

    public void setLocationOfTheClub(String locationOfTheClub) {
        this.locationOfTheClub = locationOfTheClub;
    }

    @Override
    public String toString() {
        return "Name Of The Club : " + nameOfTheClub +
                ",  Location Of The Club : " + locationOfTheClub;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        SportsClub that = (SportsClub) object;
        return Objects.equals(nameOfTheClub, that.nameOfTheClub) &&
                Objects.equals(locationOfTheClub, that.locationOfTheClub);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameOfTheClub, locationOfTheClub);
    }
}

