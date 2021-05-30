package entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class FootballClub extends SportsClub implements Serializable {

    private int numberOfWins;
    private int numberOfDraws;
    private int numberOfDefeats;
    private int numberOfGoalsScored;
    private int numberOfGoalsReceived;
    private int numberOfMatchesPlayed;
    private int numberOfCurrentPoints;
    private int goalDifference;

    public FootballClub(String nameOfTheClub, String locationOfTheClub, int numberOfWins,
                        int numberOfDraws, int numberOfDefeats, int numberOfGoalsScored,
                        int numberOfGoalsReceived, int numberOfMatchesPlayed, int numberOfCurrentPoints, int goalDifference) {
        super(nameOfTheClub, locationOfTheClub);
        this.numberOfWins = numberOfWins;
        this.numberOfDraws = numberOfDraws;
        this.numberOfDefeats = numberOfDefeats;
        this.numberOfGoalsScored = numberOfGoalsScored;
        this.numberOfGoalsReceived = numberOfGoalsReceived;
        this.numberOfMatchesPlayed = numberOfMatchesPlayed;
        this.numberOfCurrentPoints = numberOfCurrentPoints;
        this.goalDifference = goalDifference;
    }

    public int getNumberOfWins() {
        return numberOfWins;
    }

    public void setNumberOfWins(int numberOfWins) {
        this.numberOfWins = numberOfWins;
    }

    public int getNumberOfDraws() {
        return numberOfDraws;
    }

    public void setNumberOfDraws(int numberOfDraws) {
        this.numberOfDraws = numberOfDraws;
    }

    public int getNumberOfDefeats() {
        return numberOfDefeats;
    }

    public void setNumberOfDefeats(int numberOfDefeats) {
        this.numberOfDefeats = numberOfDefeats;
    }

    public int getNumberOfGoalsScored(){
        return numberOfGoalsScored;
    }

    public void setNumberOfGoals(int numberOfGoalsScored){
        this.numberOfGoalsScored = numberOfGoalsScored;
    }

    public int getNumberOfGoalsReceived(){return numberOfGoalsReceived; }

    public void setNumberOfGoalsReceived(int numberOfGoalsReceived) {this.numberOfGoalsReceived = numberOfGoalsReceived;}

    public int getNumberOfMatchesPlayed() {
        return numberOfMatchesPlayed;
    }

    public void setNumberOfMatchesPlayed(int numberOfMatchesPlayed) {
        this.numberOfMatchesPlayed = numberOfMatchesPlayed;
    }

    public int getNumberOfCurrentPoints() {
        return numberOfCurrentPoints;
    }

    public void setNumberOfCurrentPoints(int numberOfCurrentPoints) {
        this.numberOfCurrentPoints = numberOfCurrentPoints;
    }
    public  void setGoalDifference (int goalDifference) {
        this.goalDifference = goalDifference;
    }

    public int getGoalDifference(){
        return goalDifference;
    }

    @Override
    public String toString() {
        return super.toString() +
                ",  Number Of Wins : " + numberOfWins +
                ",  Number Of Draws : " + numberOfDraws +
                ",  Number Of Defeats : " + numberOfDefeats +
                ",  Number Of Goals Scored : " + numberOfGoalsScored +
                ",  Number Of Goals Received: " + numberOfGoalsReceived +
                ",  Goal Difference : " + goalDifference +
                ",  Number Of Matches Played: " + numberOfMatchesPlayed +
                ",  Number Of CurrentPoints : " + numberOfCurrentPoints;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        FootballClub that = (FootballClub) object;
        return numberOfWins == that.numberOfWins &&
                numberOfDraws == that.numberOfDraws &&
                numberOfDefeats == that.numberOfDefeats &&
                numberOfGoalsScored == that.numberOfGoalsScored &&
                numberOfGoalsReceived == that.numberOfGoalsReceived &&
                numberOfMatchesPlayed == that.numberOfMatchesPlayed &&
                numberOfCurrentPoints == that.numberOfCurrentPoints;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfWins, numberOfDraws, numberOfDefeats,
                numberOfGoalsScored, numberOfGoalsReceived, numberOfMatchesPlayed, numberOfCurrentPoints);
    }
}
