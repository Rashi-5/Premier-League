package entities;

import java.io.*;
import java.util.*;

public class PremierLeagueManager implements LeagueManager {

    static Match match;
    public List<SportsClub> numberOfFootballClubs = new ArrayList<>();
    public List<Match> playedMatch = new ArrayList<>();

    private static PremierLeagueManager instance;

    public static PremierLeagueManager getInstance() {
        if (instance == null) {
            instance = new PremierLeagueManager();
        }
        return instance;
    }

    @Override
    public void createAndAddNewClub(SportsClub sports) {

        if (numberOfFootballClubs.equals(sports)) {
            System.out.println("This Football club is already there!");
        }
        if (!(numberOfFootballClubs.equals(sports))) {
            numberOfFootballClubs.add(sports);
        } else {
            System.out.println("Something went wrong please try again!");
        }
    }

    @Override
    public void deleteExistingClub(String nameOfTheClub) {

        boolean foundClub = false;

        for (SportsClub sportsClub : numberOfFootballClubs) {

            if (sportsClub.getNameOfTheClub().equals(nameOfTheClub)) {
                numberOfFootballClubs.remove(sportsClub);
                foundClub = true;

                System.out.println(nameOfTheClub + " has been successfully removed!");
                break;
            }
        }
        if (!foundClub) {
            System.out.println(nameOfTheClub + " Doesn't exist!");
        }
    }

    @Override
    public void displayStatistics(String nameOfTheClub) {

        for (SportsClub sportsClub : numberOfFootballClubs) {
            if (sportsClub.getNameOfTheClub().equals(nameOfTheClub)) {
                System.out.println("|   Statistics of the Club  |\n" + sportsClub);
                break;
            }
        }
    }

    @Override
    public void displayPremierLeagueTable() {

        try {
            if (numberOfFootballClubs.isEmpty()) {
                System.out.println("Nothing to sort, It`s empty here!");
            } else {
                Collections.sort(numberOfFootballClubs, PremierLeagueManager.numberOfPoints);

                for (SportsClub sportsClubArray : numberOfFootballClubs) {
                    System.out.println(sportsClubArray);
                }
            }
        } catch (Exception e) {
            System.out.println("Cannot sort, Please try again!");
        }
    }

    @Override
    public void addPlayedMatch(String date, int index1, int scoredGoals1, int receivedGoals1, int index2, int scoredGoals2, int receivedGoals2) {
        try {
            String status = "";

            if (scoredGoals1 == scoredGoals2) {
                int currentPoint1 = ((FootballClub) numberOfFootballClubs.get(index1)).getNumberOfCurrentPoints() + 1;
                int draws1 = ((FootballClub) numberOfFootballClubs.get(index1)).getNumberOfDraws() + 1;

                ((FootballClub) numberOfFootballClubs.get(index1)).setNumberOfCurrentPoints(currentPoint1);
                ((FootballClub) numberOfFootballClubs.get(index1)).setNumberOfDraws(draws1);


                int currentPoint2 = ((FootballClub) numberOfFootballClubs.get(index2)).getNumberOfCurrentPoints() + 1;
                int draws2 = ((FootballClub) numberOfFootballClubs.get(index2)).getNumberOfDraws() + 1;

                ((FootballClub) numberOfFootballClubs.get(index2)).setNumberOfCurrentPoints(currentPoint2);
                ((FootballClub) numberOfFootballClubs.get(index2)).setNumberOfDraws(draws2);

                status = "Draw";

            } else if ((scoredGoals1 > scoredGoals2) || (scoredGoals1 < scoredGoals2)) {
                int winner = Math.max(index1, index2);
                int defeat = Math.min(index1, index2);

                int currentPoint1 = ((FootballClub) numberOfFootballClubs.get(winner)).getNumberOfCurrentPoints() + 3;
                int wins = ((FootballClub) numberOfFootballClubs.get(winner)).getNumberOfWins() + 1;

                ((FootballClub) numberOfFootballClubs.get(winner)).setNumberOfCurrentPoints(currentPoint1);
                ((FootballClub) numberOfFootballClubs.get(winner)).setNumberOfWins(wins);

                int defeats = ((FootballClub) numberOfFootballClubs.get(defeat)).getNumberOfDefeats() + 1;
                ((FootballClub) numberOfFootballClubs.get(winner)).setNumberOfDefeats(defeats);

                status = "NotDraw";

            } else {
                System.out.println("Couldn't update the teams. Please try again!");
                return;
            }
            int currentScoredGoals1 = (((FootballClub) numberOfFootballClubs.get(index1)).getNumberOfGoalsScored() + scoredGoals1);
            int numberOfMatches1 = ((FootballClub) numberOfFootballClubs.get(index1)).getNumberOfMatchesPlayed() + 1;
            int currentReceivedGoals1 = (((FootballClub) numberOfFootballClubs.get(index1)).getNumberOfGoalsReceived() + receivedGoals1);
            int goalDifference1 = currentScoredGoals1 - currentReceivedGoals1;

            ((FootballClub) numberOfFootballClubs.get(index1)).setNumberOfGoals(currentScoredGoals1);
            ((FootballClub) numberOfFootballClubs.get(index1)).setNumberOfGoalsReceived(currentReceivedGoals1);
            ((FootballClub) numberOfFootballClubs.get(index1)).setNumberOfMatchesPlayed(numberOfMatches1);
            ((FootballClub) numberOfFootballClubs.get(index1)).setGoalDifference(goalDifference1);

            int currentScoredGoals2 = (((FootballClub) numberOfFootballClubs.get(index2)).getNumberOfGoalsScored() + scoredGoals2);
            int numberOfMatches2 = ((FootballClub) numberOfFootballClubs.get(index2)).getNumberOfMatchesPlayed() + 1;
            int currentReceivedGoals2 = (((FootballClub) numberOfFootballClubs.get(index2)).getNumberOfGoalsReceived() + receivedGoals2);
            int goalDifference2 = currentScoredGoals2 - currentReceivedGoals2;

            ((FootballClub) numberOfFootballClubs.get(index2)).setNumberOfGoals(currentScoredGoals2);
            ((FootballClub) numberOfFootballClubs.get(index2)).setNumberOfGoalsReceived(currentReceivedGoals2);
            ((FootballClub) numberOfFootballClubs.get(index2)).setNumberOfMatchesPlayed(numberOfMatches2);
            ((FootballClub) numberOfFootballClubs.get(index2)).setGoalDifference(goalDifference2);

            String team1 = numberOfFootballClubs.get(index1).getNameOfTheClub();
            String team2 = numberOfFootballClubs.get(index2).getNameOfTheClub();

            match = new Match(date, team1, team2, status);
            playedMatch.add(match);

            System.out.println(playedMatch);
            System.out.println("Both clubs successfully updated!");

        } catch (Exception e) {
            System.out.println("Something went wrong!");
        }
    }

    //save club statistics
    @Override
    public void saveFiles(File files, List<SportsClub> numberOfFootballClubs) throws IOException {
        ObjectOutputStream leagueMenu = null;
        FileOutputStream premierLeague = null;

        try {
            premierLeague = new FileOutputStream(files);
            leagueMenu = new ObjectOutputStream(premierLeague);

            for (SportsClub sportsClub : numberOfFootballClubs) {
                leagueMenu.writeObject(sportsClub);
            }
            // System.out.println("Successfully saved to the file!");

        } catch (IOException e) {
            System.out.println("Something went wrong try again!");
        } finally {
            premierLeague.flush();
            leagueMenu.close();
            premierLeague.close();
        }
    }

    //save match details
    @Override
    public void saveFile(File file, List<Match> playedMatch) throws IOException {

        try {
            FileOutputStream premierLeague = new FileOutputStream(file);
            ObjectOutputStream leagueMenu = new ObjectOutputStream(premierLeague);

            for (Match matchClubs : playedMatch) {
                leagueMenu.writeObject(matchClubs);
            }
             //System.out.println("Successfully saved to the file!");

            premierLeague.flush();
            leagueMenu.close();
            premierLeague.close();

        } catch (IOException e) {
            System.out.println("Something went wrong try again!");
        }
    }

    //read club statistics
    @Override
    public void readFiles(File files) {

        try {
            FileInputStream readFile = new FileInputStream(files);
            ObjectInputStream readPremierLeague = new ObjectInputStream(readFile);

            for (; ; ) {
                try {
                    SportsClub sportsClub = (SportsClub) readPremierLeague.readObject();
                    numberOfFootballClubs.add(sportsClub);

                } catch (EOFException eofException) {
                    break;
                }
            }

           // System.out.println(numberOfFootballClubs);

            readFile.close();
            readPremierLeague.close();
        } catch (Exception e) {
            System.out.println("");
        }
    }

    //read match details
    @Override
    public void readFile(File file) {

        try {
            FileInputStream readFile = new FileInputStream(file);
            ObjectInputStream readPremierLeague = new ObjectInputStream(readFile);

            for (; ; ) {
                try {
                    Match match = (Match) readPremierLeague.readObject();
                    playedMatch.add(match);

                } catch (EOFException eofException) {
                    break;
                }
            }
            readFile.close();
            readPremierLeague.close();

        } catch (Exception e) {
            System.out.println("");
        }
    }

    public static Comparator<SportsClub> numberOfPoints = new Comparator<SportsClub>() {
        @Override
        public int compare(SportsClub sportsClub1, SportsClub sportsClub2) {
            int currentPoints1 = ((FootballClub) sportsClub1).getNumberOfCurrentPoints();
            int currentPoints2 = ((FootballClub) sportsClub2).getNumberOfCurrentPoints();

            if (currentPoints1 == currentPoints2) {
                int goalDifference1 = ((FootballClub) sportsClub1).getGoalDifference();
                int goalDifference2 = ((FootballClub) sportsClub2).getGoalDifference();

                return goalDifference2 - goalDifference1;
            }
            return currentPoints2 - currentPoints1;
        }
    };

    public static Comparator<SportsClub> points = new Comparator<SportsClub>() {
        @Override
        public int compare(SportsClub sportsClub1, SportsClub sportsClub2) {
            int currentPoints1 = ((FootballClub) sportsClub1).getNumberOfCurrentPoints();
            int currentPoints2 = ((FootballClub) sportsClub2).getNumberOfCurrentPoints();

            return currentPoints2 - currentPoints1;
        }
    };

    public static Comparator<SportsClub> numberOfGoals = new Comparator<SportsClub>() {
        @Override
        public int compare(SportsClub sportsClub1, SportsClub sportsClub2) {
            int currentGoals1 = ((FootballClub) sportsClub1).getNumberOfGoalsScored();
            int currentGoals2 = ((FootballClub) sportsClub2).getNumberOfGoalsScored();

            return currentGoals2 - currentGoals1;
        }
    };

    public static Comparator<SportsClub> numberOfWins = new Comparator<SportsClub>() {
        @Override
        public int compare(SportsClub sportsClub1, SportsClub sportsClub2) {
            int currentWins1 = ((FootballClub) sportsClub1).getNumberOfWins();
            int currentWins2 = ((FootballClub) sportsClub2).getNumberOfWins();

            return currentWins2 - currentWins1;
        }
    };

    public List<SportsClub> getList(){
        return numberOfFootballClubs;
    }
}

