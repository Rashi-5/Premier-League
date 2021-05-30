package entities;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface LeagueManager {

    void createAndAddNewClub(SportsClub sports);
    void deleteExistingClub(String nameOfTheClub);
    void displayStatistics(String nameOfTheClub);
    void displayPremierLeagueTable();                   //descending order according to the score
    void addPlayedMatch(String date, int team1, int scoredGoals1,int receivedGoals1,int team2, int scoredGoals2, int receivedGoals2);             //with score and date
    void saveFiles(File file, List<SportsClub> clubList) throws IOException;
    void saveFile(File file, List<Match> matchList) throws IOException;
    void readFiles(File file) throws IOException;
    void readFile(File file);
}
//netstat -ano | findstr :4200