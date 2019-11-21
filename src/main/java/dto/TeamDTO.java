package dto;

import java.util.Objects;

/**
 *
 * @author simon
 */
public class TeamDTO {

    private String name;
    private String crestUrl;
    private Integer teamID;

    public TeamDTO() {
    }

    public TeamDTO(String name, String crestUrl, Integer teamID) {
        this.name = name;
        this.crestUrl = crestUrl;
        this.teamID = teamID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCrestUrl() {
        return crestUrl;
    }

    public void setCrestUrl(String crestUrl) {
        this.crestUrl = crestUrl;
    }

    public Integer getTeamID() {
        return teamID;
    }

    public void setTeamID(Integer teamID) {
        this.teamID = teamID;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.name);
        hash = 89 * hash + Objects.hashCode(this.crestUrl);
        hash = 89 * hash + Objects.hashCode(this.teamID);
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
        final TeamDTO other = (TeamDTO) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.crestUrl, other.crestUrl)) {
            return false;
        }
        if (!Objects.equals(this.teamID, other.teamID)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TeamDTO{" + "name=" + name + ", crestUrl=" + crestUrl + ", teamID=" + teamID + '}';
    }

      

}
