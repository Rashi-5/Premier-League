package services;

import entities.FootballClub;
import entities.Match;
import entities.SportsClub;
import entities.PremierLeagueManager;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.*;

public class PremierLeagueService {

    private static PremierLeagueService instance;

    public static PremierLeagueService getInstance() {
        if (instance == null) {
            instance = new PremierLeagueService();
        }
        return instance;
    }

    List<SportsClub> footballClubArray = new ArrayList<>();
    List<Match> footballMatchArray = new ArrayList<>();

    public List<SportsClub> readClubs() {

        footballClubArray.clear();
        try {
            FileInputStream readFile = new FileInputStream("premierLeague.txt");
            ObjectInputStream readPremierLeague = new ObjectInputStream(readFile);

            for (; ; ) {
                try {
                    SportsClub sportsClub = (SportsClub) readPremierLeague.readObject();
                    footballClubArray.add(sportsClub);

                } catch (EOFException eofException) {
                    break;
                }
            }
            System.out.println(footballClubArray);

            readFile.close();
            readPremierLeague.close();
        } catch (Exception e) {
            System.out.println("");
        }
        return footballClubArray;
    }

    public List<Match> readMatches() {

        footballMatchArray.clear();

        try {
            FileInputStream readFile = new FileInputStream("matchHistory.txt");
            ObjectInputStream readPremierLeague = new ObjectInputStream(readFile);

            for (; ;) {
                try {
                    Match matches = (Match) readPremierLeague.readObject();
                    footballMatchArray.add(matches);

                } catch (EOFException eofException) {
                    break;
                }
            }
            readFile.close();
            readPremierLeague.close();
        } catch (Exception e) {
            System.out.println("");
        }
        return footballMatchArray;
    }

    public List<SportsClub> randomMatch() {

        footballMatchArray = readMatches();
        footballClubArray = readClubs();

        Random randomNum = new Random();

        int club1;
        int club2;

        do {
            club1 = randomNum.nextInt(footballClubArray.size());
            club2 = randomNum.nextInt(footballClubArray.size());
        }
        while (club1 == club2);

        int maximumNumberOfGoals = 35;      //Assumption
        int goalsScored1 = randomNum.nextInt(maximumNumberOfGoals);   //35 is the maximum number of goals scored
        int goalsScored2 = randomNum.nextInt(maximumNumberOfGoals);   // number of goals could be less than 40

        int goalsReceived1 = randomNum.nextInt(maximumNumberOfGoals);
        int goalsReceived2 = randomNum.nextInt(maximumNumberOfGoals);

        LocalDate today = LocalDate.now();
        String randomDate = today.toString();

        try {
            String status = "";

            if (goalsScored1 == goalsScored2) {
                int currentPoint1 = ((FootballClub) footballClubArray.get(club1)).getNumberOfCurrentPoints() + 1;
                int draws1 = ((FootballClub) footballClubArray.get(club1)).getNumberOfDraws() + 1;

                ((FootballClub) footballClubArray.get(club1)).setNumberOfCurrentPoints(currentPoint1);
                ((FootballClub) footballClubArray.get(club1)).setNumberOfDraws(draws1);


                int currentPoint2 = ((FootballClub) footballClubArray.get(club2)).getNumberOfCurrentPoints() + 1;
                int draws2 = ((FootballClub) footballClubArray.get(club2)).getNumberOfDraws() + 1;

                ((FootballClub) footballClubArray.get(club2)).setNumberOfCurrentPoints(currentPoint2);
                ((FootballClub) footballClubArray.get(club2)).setNumberOfDraws(draws2);

                status = "Draw";

            } else if ((goalsScored1 > goalsScored2) || (goalsScored1 < goalsScored2)) {
                int winner = Math.max(club1, club2);
                int defeat = Math.min(club1, club2);

                int currentPoint1 = ((FootballClub) footballClubArray.get(winner)).getNumberOfCurrentPoints() + 3;
                int wins = ((FootballClub) footballClubArray.get(winner)).getNumberOfWins() + 1;

                ((FootballClub) footballClubArray.get(winner)).setNumberOfCurrentPoints(currentPoint1);
                ((FootballClub) footballClubArray.get(winner)).setNumberOfWins(wins);

                int defeats = ((FootballClub) footballClubArray.get(defeat)).getNumberOfDefeats() + 1;
                ((FootballClub) footballClubArray.get(winner)).setNumberOfDefeats(defeats);

                status = "NotDraw";

            } else {
                System.out.println("Couldn't update the teams. Please try again!");
                return null;
            }
            int currentScoredGoals1 = (((FootballClub) footballClubArray.get(club1)).getNumberOfGoalsScored() + goalsScored1);
            int numberOfMatches1 = ((FootballClub) footballClubArray.get(club1)).getNumberOfMatchesPlayed() + 1;
            int currentReceivedGoals1 = (((FootballClub) footballClubArray.get(club1)).getNumberOfGoalsReceived() + goalsReceived1);
            int goalDifference1 = currentScoredGoals1 - currentReceivedGoals1;

            ((FootballClub) footballClubArray.get(club1)).setNumberOfGoals(currentScoredGoals1);
            ((FootballClub) footballClubArray.get(club1)).setNumberOfGoalsReceived(currentReceivedGoals1);
            ((FootballClub) footballClubArray.get(club1)).setNumberOfMatchesPlayed(numberOfMatches1);
            ((FootballClub) footballClubArray.get(club1)).setGoalDifference(goalDifference1);

            int currentScoredGoals2 = (((FootballClub) footballClubArray.get(club2)).getNumberOfGoalsScored() + goalsScored2);
            int numberOfMatches2 = ((FootballClub) footballClubArray.get(club2)).getNumberOfMatchesPlayed() + 1;
            int currentReceivedGoals2 = (((FootballClub) footballClubArray.get(club2)).getNumberOfGoalsReceived() + goalsReceived2);
            int goalDifference2 = currentScoredGoals2 - currentReceivedGoals2;

            ((FootballClub) footballClubArray.get(club2)).setNumberOfGoals(currentScoredGoals2);
            ((FootballClub) footballClubArray.get(club2)).setNumberOfGoalsReceived(currentReceivedGoals2);
            ((FootballClub) footballClubArray.get(club2)).setNumberOfMatchesPlayed(numberOfMatches2);
            ((FootballClub) footballClubArray.get(club2)).setGoalDifference(goalDifference2);

            String matchTeam1 = footballClubArray.get(club1).getNameOfTheClub();
            String matchTeam2 = footballClubArray.get(club2).getNameOfTheClub();

            Match match = new Match(randomDate, matchTeam1, matchTeam2, status);
            footballMatchArray.add(match);

            File clubFile = new File("premierLeague.txt");
            File matchFile = new File("matchHistory.txt");

            PremierLeagueManager.getInstance().saveFiles(clubFile, footballClubArray);
            PremierLeagueManager.getInstance().saveFile(matchFile, footballMatchArray);

            System.out.println(footballMatchArray);
            System.out.println("Both clubs successfully updated!");

        } catch (Exception e) {
            System.out.println("Something went wrong!");
        }
        return footballClubArray;
    }

    public List<Match> orderOfDate() {

        List<Match> matchByDate = readMatches();

        Collections.sort(matchByDate, new Comparator<Match>(){
            @Override
            public int compare(Match match1, Match match2) {
                String date1 = match1.getDate();
                String date2 = match2.getDate();

                return date1.compareTo(date2);
            }
        });
        return matchByDate;
    }

    public List<Match> searchDate(String dateInput) {

        List<Match> matchList = readMatches();
        List<Match> clubsList = new ArrayList<>();

        Match foundMatch;

        for (Match searchMatch : matchList) {
            if (searchMatch.getDate().equals(dateInput)) {
                foundMatch = matchList.get(matchList.indexOf(searchMatch));

                clubsList.add(foundMatch);
            }
        }

        return clubsList;
    }
}
