package entities;

import java.io.Serializable;
import java.util.Objects;

public class Match implements Serializable {

    private String date;
    private String team01;
    private String team02;
    private String status;

    public Match(String date, String team01, String team02, String status) {
        this.date = date;
        this.team01 = team01;
        this.team02 = team02;
        this.status = status;
    }

    public String getDate(){
        return date;
    }

    public void setDate(String date){
        this.date = date;
    }

    public String getTeam01() {
        return team01;
    }

    public void setTeam01(String team01) {
        this.team01 = team01;
    }

    public String getTeam02() {
        return team02;
    }

    public void setTeam02(String team02) {
        this.team02 = team02;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return  "Date : " + date +
                ",  Status : " + status +
                ",  Team 1 : " + team01 +
                ",  Team 2 : " + team02;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Match match = (Match) o;
        return Objects.equals(date, match.date) && Objects.equals(team01, match.team01) && Objects.equals(team02, match.team02) && Objects.equals(status, match.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, team01, team02, status);
    }
}
