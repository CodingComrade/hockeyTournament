package capstone.DTO;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerStatsDTO {

    @Column(name = "id", table = "players")
    private Long playerId;

    @Column(name = "id", table = "stats")
    private Long statsId;

    @Column(name = "name")
    private String name;

    @Column(name = "team")
    private String team;

    @Column(name = "games_played")
    private Integer gamesPlayed;

    @Column(name = "goals")
    private Integer goals;

    @Column(name = "assists")
    private Integer assists;

    @Column(name = "points")
    private Integer points;

    @Column(name = "plus_minus")
    private Integer plusMinus;

    @Column(name = "shots")
    private Integer shots;

    @Column(name = "wins")
    private Integer wins;

    @Column(name = "losses")
    private Integer losses;

    @Column(name = "overtime_losses")
    private Integer overtimeLosses;

    @Column(name = "shutouts")
    private Integer shutouts;

    @Column(name = "save_percentage")
    private Double savePercentage;

    @Column(name = "goals_against_average")
    private Double goalsAgainstAverage;

    @Column(name = "saves")
    private Integer saves;

    @Column(name = "shots_against")
    private Integer shotsAgainst;

    @Column(name = "goals_against")
    private Integer goalsAgainst;



}