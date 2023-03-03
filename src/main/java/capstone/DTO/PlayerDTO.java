package capstone.DTO;

public class PlayerDTO {
    private Integer id;

    private String name;

    private String team;

    private StatsDTO stats;

    public PlayerDTO(String name, String team) {
        this.name = name;
        this.team = team;
    }

    public PlayerDTO() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public StatsDTO getStats() {
        return stats;
    }

    public void setStats(StatsDTO stats) {
        this.stats = stats;
    }
}
