package dto;

import java.util.Objects;

/**
 *
 * @author martin
 */
public class TeamAirportDTO {

    private String team;
    private String airport;
    private String aCode;
    private String backupAirport;
    private String bCode;

    public TeamAirportDTO() {
    }

    public TeamAirportDTO(String team, String airport, String aCode, String backupAirport, String bCode) {
        this.team = team;
        this.airport = airport;
        this.aCode = aCode;
        this.backupAirport = backupAirport;
        this.bCode = bCode;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getAirport() {
        return airport;
    }

    public void setAirport(String airport) {
        this.airport = airport;
    }

    public String getaCode() {
        return aCode;
    }

    public void setaCode(String aCode) {
        this.aCode = aCode;
    }

    public String getBackupAirport() {
        return backupAirport;
    }

    public void setBackupAirport(String backupAirport) {
        this.backupAirport = backupAirport;
    }

    public String getbCode() {
        return bCode;
    }

    public void setbCode(String bCode) {
        this.bCode = bCode;
    }

    @Override
    public String toString() {
        return "TeamAirportDTO{" + "team=" + team + ", airport=" + airport + ", aCode=" + aCode + ", backupAirport=" + backupAirport + ", bCode=" + bCode + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.team);
        hash = 83 * hash + Objects.hashCode(this.airport);
        hash = 83 * hash + Objects.hashCode(this.aCode);
        hash = 83 * hash + Objects.hashCode(this.backupAirport);
        hash = 83 * hash + Objects.hashCode(this.bCode);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TeamAirportDTO other = (TeamAirportDTO) obj;
        if (!Objects.equals(this.team, other.team)) {
            return false;
        }
        if (!Objects.equals(this.airport, other.airport)) {
            return false;
        }
        if (!Objects.equals(this.aCode, other.aCode)) {
            return false;
        }
        if (!Objects.equals(this.backupAirport, other.backupAirport)) {
            return false;
        }
        if (!Objects.equals(this.bCode, other.bCode)) {
            return false;
        }
        return true;
    }


}
