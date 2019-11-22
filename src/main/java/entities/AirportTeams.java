package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.mindrot.jbcrypt.BCrypt;

@Entity
@Table(name = "airportteams")
public class AirportTeams implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "teams")
  private String teams;
  @Basic(optional = false)
  @NotNull
  @Column(name = "airports")
  private String airports;
  @Basic(optional = false)
  @NotNull
  @Column(name = "acode")
  private String acode;
  @Basic(optional = false)
  @NotNull
  @Column(name = "backupairports")
  private String backupairports;
  @Basic(optional = false)
  @NotNull
  @Column(name = "bcode")
  private String bcode;

  public AirportTeams() {}

    public AirportTeams(String teams, String airports, String acode, String backupairports, String bcode) {
        this.teams = teams;
        this.airports = airports;
        this.acode = acode;
        this.backupairports = backupairports;
        this.bcode = bcode;
    }

    public String getTeams() {
        return teams;
    }

    public void setTeams(String teams) {
        this.teams = teams;
    }

    public String getAirports() {
        return airports;
    }

    public void setAirports(String airports) {
        this.airports = airports;
    }

    public String getAcode() {
        return acode;
    }

    public void setAcode(String acode) {
        this.acode = acode;
    }

    public String getBackupairports() {
        return backupairports;
    }

    public void setBackupairports(String backupairports) {
        this.backupairports = backupairports;
    }

    public String getBcode() {
        return bcode;
    }

    public void setBcode(String bcode) {
        this.bcode = bcode;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.teams);
        hash = 23 * hash + Objects.hashCode(this.airports);
        hash = 23 * hash + Objects.hashCode(this.acode);
        hash = 23 * hash + Objects.hashCode(this.backupairports);
        hash = 23 * hash + Objects.hashCode(this.bcode);
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
        final AirportTeams other = (AirportTeams) obj;
        if (!Objects.equals(this.teams, other.teams)) {
            return false;
        }
        if (!Objects.equals(this.airports, other.airports)) {
            return false;
        }
        if (!Objects.equals(this.acode, other.acode)) {
            return false;
        }
        if (!Objects.equals(this.backupairports, other.backupairports)) {
            return false;
        }
        if (!Objects.equals(this.bcode, other.bcode)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AirportTeams{" + "teams=" + teams + ", airports=" + airports + ", acode=" + acode + ", backupairports=" + backupairports + ", bcode=" + bcode + '}';
    }


  
}
