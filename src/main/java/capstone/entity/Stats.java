package capstone.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "stats")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id", referencedColumnName = "id")
    private Player player;

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
