package capstone.DTO;

public class PlayerStatsDTO {
    private String name;

    private String team;

    private Integer gamesPlayed;

    private Integer goals;

    private Integer assists;

    private Integer points;

    private Integer plusMinus;

    private Integer shots;

    private Integer wins;

    private Integer losses;

    private Integer OTL;

    private Integer shutouts;

    private Double SVPercent;

    private Double GAA;

    private Integer saves;

    private Integer shotsAgainst;

    private Integer goalsAgainst;


    public PlayerStatsDTO(String name, String team, Integer gamesPlayed,
                          Integer goals, Integer assists, Integer points,
                          Integer plusMinus, Integer shots, Integer wins,
                          Integer losses, Integer OTL, Integer shutouts,
                          Double SVPercent, Double GAA, Integer saves,
                          Integer shotsAgainst, Integer goalsAgainst) {
        this.name = name;
        this.team = team;
        this.gamesPlayed = gamesPlayed;
        this.goals = goals;
        this.assists = assists;
        this.points = points;
        this.plusMinus = plusMinus;
        this.shots = shots;
        this.wins = wins;
        this.losses = losses;
        this.OTL = OTL;
        this.shutouts = shutouts;
        this.SVPercent = SVPercent;
        this.GAA = GAA;
        this.saves = saves;
        this.shotsAgainst = shotsAgainst;
        this.goalsAgainst = goalsAgainst;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public Integer getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(Integer gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public Integer getGoals() {
        return goals;
    }

    public void setGoals(Integer goals) {
        this.goals = goals;
    }

    public Integer getAssists() {
        return assists;
    }

    public void setAssists(Integer assists) {
        this.assists = assists;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getPlusMinus() {
        return plusMinus;
    }

    public void setPlusMinus(Integer plusMinus) {
        this.plusMinus = plusMinus;
    }

    public Integer getShots() {
        return shots;
    }

    public void setShots(Integer shots) {
        this.shots = shots;
    }

    public Integer getWins() {
        return wins;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }

    public Integer getLosses() {
        return losses;
    }

    public void setLosses(Integer losses) {
        this.losses = losses;
    }

    public Integer getOTL() {
        return OTL;
    }

    public void setOTL(Integer OTL) {
        this.OTL = OTL;
    }

    public Integer getShutouts() {
        return shutouts;
    }

    public void setShutouts(Integer shutouts) {
        this.shutouts = shutouts;
    }

    public Double getSVPercent() {
        return SVPercent;
    }

    public void setSVPercent(Double SVPercent) {
        this.SVPercent = SVPercent;
    }

    public Double getGAA() {
        return GAA;
    }

    public void setGAA(Double GAA) {
        this.GAA = GAA;
    }

    public Integer getSaves() {
        return saves;
    }

    public void setSaves(Integer saves) {
        this.saves = saves;
    }

    public Integer getShotsAgainst() {
        return shotsAgainst;
    }

    public void setShotsAgainst(Integer shotsAgainst) {
        this.shotsAgainst = shotsAgainst;
    }

    public Integer getGoalsAgainst() {
        return goalsAgainst;
    }

    public void setGoalsAgainst(Integer goalsAgainst) {
        this.goalsAgainst = goalsAgainst;
    }
}
