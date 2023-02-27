package capstone.entity;

import jakarta.persistence.*;

@Entity
@Table(name="stats")
public class Stats {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id")
    private Player player;

    @Column(name="games_played")
    private int gamesPlayed;

    @Column(name="goals")
    private int goals;

    @Column(name="assists")
    private int assists;

    @Column(name="points")
    private int points;

    @Column(name="plus_minus")
    private int plusMinus;

    @Column(name="shots")
    private int shots;

    @Column(name="wins")
    private int wins;

    @Column(name="losses")
    private int losses;

    @Column(name="overtime_losses")
    private int OTL;

    @Column(name="shutouts")
    private int SO;

    @Column(name="save_percentage")
    private float SVPercent;

    @Column(name="goals_against_average")
    private float GAA;

    @Column(name="saves")
    private int saves;

    @Column(name="shots_against")
    private int shotsAgainst;

    @Column(name="goals_against")
    private int goalsAgainst;

    public Stats () {

    }

    public Stats(int gamesPlayed, int goals, int assists, int points,
                 int plusMinus, int shots, int wins, int losses, int OTL,
                 int SO, float SVPercent, float GAA, int saves,
                 int shotsAgainst, int goalsAgainst) {
        this.gamesPlayed = gamesPlayed;
        this.goals = goals;
        this.assists = assists;
        this.points = points;
        this.plusMinus = plusMinus;
        this.shots = shots;
        this.wins = wins;
        this.losses = losses;
        this.OTL = OTL;
        this.SO = SO;
        this.SVPercent = SVPercent;
        this.GAA = GAA;
        this.saves = saves;
        this.shotsAgainst = shotsAgainst;
        this.goalsAgainst = goalsAgainst;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getPlusMinus() {
        return plusMinus;
    }

    public void setPlusMinus(int plusMinus) {
        this.plusMinus = plusMinus;
    }

    public int getShots() {
        return shots;
    }

    public void setShots(int shots) {
        this.shots = shots;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getOTL() {
        return OTL;
    }

    public void setOTL(int OTL) {
        this.OTL = OTL;
    }

    public int getSO() {
        return SO;
    }

    public void setSO(int SO) {
        this.SO = SO;
    }

    public float getSVPercent() {
        return SVPercent;
    }

    public void setSVPercent(float SVPercent) {
        this.SVPercent = SVPercent;
    }

    public float getGAA() {
        return GAA;
    }

    public void setGAA(float GAA) {
        this.GAA = GAA;
    }

    public int getSaves() {
        return saves;
    }

    public void setSaves(int saves) {
        this.saves = saves;
    }

    public int getShotsAgainst() {
        return shotsAgainst;
    }

    public void setShotsAgainst(int shotsAgainst) {
        this.shotsAgainst = shotsAgainst;
    }

    public int getGoalsAgainst() {
        return goalsAgainst;
    }

    public void setGoalsAgainst(int goalsAgainst) {
        this.goalsAgainst = goalsAgainst;
    }

    @Override
    public String toString() {
        return "Stats{" +
                "id=" + id +
                ", player=" + player +
                ", gamesPlayed=" + gamesPlayed +
                ", goals=" + goals +
                ", assists=" + assists +
                ", points=" + points +
                ", plusMinus=" + plusMinus +
                ", shots=" + shots +
                ", wins=" + wins +
                ", losses=" + losses +
                ", OTL=" + OTL +
                ", SO=" + SO +
                ", SVPercent=" + SVPercent +
                ", GAA=" + GAA +
                ", saves=" + saves +
                ", shotsAgainst=" + shotsAgainst +
                ", goalsAgainst=" + goalsAgainst +
                '}';
    }
}
