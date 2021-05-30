package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.Match;
import entities.PremierLeagueManager;
import entities.SportsClub;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import play.mvc.Controller;
import play.mvc.Result;
import services.PremierLeagueService;

import java.util.Collections;
import java.util.List;


public class PremierLeagueController extends Controller {

    private static final Logger logger = LoggerFactory.getLogger("controller");

    public Result orderOfPoints() {
        List<SportsClub> pointsArray = PremierLeagueService.getInstance().readClubs();
        Collections.sort(pointsArray, PremierLeagueManager.points);
        
        logger.debug("In PremierLeagueController.orderOfPoints(), result is: {}",pointsArray.toString());
        ObjectMapper mapper = new ObjectMapper();

        JsonNode jsonData = mapper.convertValue(pointsArray, JsonNode.class);
        return ok(jsonData);
    }

    public Result orderOfGoals() {
        List<SportsClub> goalsArray = PremierLeagueService.getInstance().readClubs();
        Collections.sort(goalsArray, PremierLeagueManager.numberOfGoals);

        logger.debug("In PremierLeagueController.orderOfGoals(), result is: {}",goalsArray.toString());
        ObjectMapper mapper = new ObjectMapper();

        JsonNode jsonData = mapper.convertValue(goalsArray, JsonNode.class);
        return ok(jsonData);
    }

    public Result orderOfWins() {
        List<SportsClub> winsArray = PremierLeagueService.getInstance().readClubs();
        Collections.sort(winsArray, PremierLeagueManager.numberOfWins);

        logger.debug("In PremierLeagueController.orderOfWins(), result is: {}",winsArray.toString());
        ObjectMapper mapper = new ObjectMapper();

        JsonNode jsonData = mapper.convertValue(winsArray, JsonNode.class);
        return ok(jsonData);
    }

    public Result randomMatch() {
        List<SportsClub> matchArray = PremierLeagueService.getInstance().randomMatch();
        Collections.sort(matchArray, PremierLeagueManager.points);

        logger.debug("In PremierLeagueController.randomMatch(), result is: {}",matchArray.toString());
        ObjectMapper mapper = new ObjectMapper();

        JsonNode jsonData = mapper.convertValue(matchArray, JsonNode.class);
        return ok(jsonData);
    }

    public Result matchHistory() {
        List<Match> matchesArray = PremierLeagueService.getInstance().orderOfDate();

        logger.debug("In PremierLeagueController.randomMatch(), result is: {}",matchesArray.toString());
        ObjectMapper mapper = new ObjectMapper();

        JsonNode jsonData = mapper.convertValue(matchesArray, JsonNode.class);
        return ok(jsonData);
    }

    public Result searchMatch(String date) {
        logger.debug("In EmployeeController.retrieve(), retrieve employee with id: {}",date);
        if (PremierLeagueService.getInstance().searchDate(date) == null) {
            return notFound("Employee with id:" + date + " not found");
        }
        List<Match> dateArray = PremierLeagueService.getInstance().searchDate(date);

        logger.debug("In PremierLeagueController.randomMatch(), result is: {}",dateArray.toString());
        ObjectMapper mapper = new ObjectMapper();

        JsonNode jsonData = mapper.convertValue(dateArray, JsonNode.class);
        return ok(jsonData);
    }
}
