package capstone.DTO;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatsDTO {

    private Long id;

    @Column(name = "player_id")
    private Integer playerId;

    @Column(name = "games_played")
    private Integer gamesPlayed;

    private Integer goals;

    private Integer assists;

    private Integer points;

    @Column(name = "plus_minus")
    private Integer plusMinus;

    private Integer shots;

    private Integer wins;

    private Integer losses;

    @Column(name = "overtime_losses")
    private Integer OTL;

    private Integer shutouts;

    @Column(name = "save_percentage")
    private Double SVPercent;

    @Column(name = "goals_against_average")
    private Double GAA;

    private Integer saves;

    private Integer shotsAgainst;

    private Integer goalsAgainst;


}

