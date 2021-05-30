package entities;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.List;

public class PremierLeagueManagerTest extends TestCase {

    PremierLeagueManager manager = new PremierLeagueManager();
    List<SportsClub> tempList =  manager.getList();

    FootballClub footballClub1 = new FootballClub("testClub", "testCity", 12, 5, 2, 10, 14, 9, 22, -2);

    public void testCreateAndAddNewClub() {

        boolean test = false;

        tempList.add(footballClub1);

        for (SportsClub sportsClub : tempList) {
            if (sportsClub.equals(footballClub1)) {
                test = true;
            }
        }
        Assert.assertEquals(true, test);
    }

    public void testDeleteExistingClub() {
        boolean test = false;

        tempList.add(footballClub1);

        for (SportsClub sportsClub : tempList) {
            if (sportsClub.getNameOfTheClub().equals("testClub")) {
                tempList.remove(sportsClub);
                test = true;
                break;
            }
        }
        Assert.assertEquals(true, test);
    }

    public void testDisplayStatistics() {

        boolean test = false;
        tempList.add(footballClub1);

        for (SportsClub sportsClub : tempList) {
            if (sportsClub.equals(footballClub1)) {
                test = true;
            }
        }
        Assert.assertEquals(true, test);
    }
}