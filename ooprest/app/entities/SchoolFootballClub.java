package entities;

import java.util.Objects;

public class SchoolFootballClub extends FootballClub {

    private String schoolName;

    public SchoolFootballClub(String nameOfTheClub, String locationOfTheClub,
                              int numberOfWins, int numberOfDraws, int numberOfDefeats, int numberOfGoalsScored,
                              int numberOfGoalsReceived, int numberOfMatchesPlayed, int numberOfCurrentPoints, int goalDifference) {

        super(nameOfTheClub, locationOfTheClub, numberOfWins, numberOfDraws,
                numberOfDefeats, numberOfGoalsScored, numberOfGoalsReceived, numberOfMatchesPlayed, numberOfCurrentPoints, goalDifference);
        this.schoolName = schoolName;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    @Override
    public String toString() {
        return "SchoolFootballClub\n" +
                "schoolName: " + schoolName;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        SchoolFootballClub that = (SchoolFootballClub) object;
        return Objects.equals(schoolName, that.schoolName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), schoolName);
    }
}
