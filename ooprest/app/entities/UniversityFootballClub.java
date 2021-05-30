package entities;

import java.util.Objects;

public class UniversityFootballClub extends FootballClub {

    private String universityName;

    public UniversityFootballClub(String nameOfTheClub, String locationOfTheClub, int numberOfWins, int numberOfDraws, int numberOfDefeats, int numberOfGoalsScored, int numberOfGoalsReceived, int numberOfMatchesPlayed, int numberOfCurrentPoints, int goalDifference) {
        super(nameOfTheClub, locationOfTheClub, numberOfWins, numberOfDraws, numberOfDefeats, numberOfGoalsScored, numberOfGoalsReceived, numberOfMatchesPlayed, numberOfCurrentPoints, goalDifference);
        this.universityName = universityName;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    @Override
    public String toString() {
        return "UniversityFootballClub\n" +
                "universityName: " + universityName;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        UniversityFootballClub that = (UniversityFootballClub) object;
        return Objects.equals(universityName, that.universityName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), universityName);
    }
}
