package com.chyld.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "positions")
@Data
public class Position {

    private int id;
    private int version;
    private String longitude;
    private String latitude;
    private String altitude;
    private Date currentTimeItude;
    private Date created;
    private Date modified;
    private Run run;

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Version
    public int getVersion() {
        return version;
    }
    public void setVersion(int version) {
        this.version = version;
    }

    @Column(nullable = false)
    public String getLongitude() {
        return longitude;
    }
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Column(nullable = false)
    public String getLatitude() {
        return latitude;
    }
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    @Column(nullable = false)
    public String getAltitude() {
        return altitude;
    }
    public void setAltitude(String altitude) {
        this.altitude = altitude;
    }

    @CreationTimestamp
    public Date getCurrentTimeItude() {
        return currentTimeItude;
    }
    public void setCurrentTimeItude(Date currentTimeItude) {
        this.currentTimeItude = currentTimeItude;
    }

    @CreationTimestamp
    public Date getCreated() {
        return created;
    }
    public void setCreated(Date created) {
        this.created = created;
    }

    @UpdateTimestamp
    public Date getModified() {
        return modified;
    }
    public void setModified(Date modified) {
        this.modified = modified;
    }

    @ManyToOne
    @JoinColumn(name = "run_id" )
    @JsonIgnore
    public Run getRun() {
        return run;
    }
    public void setRun(Run run) {
        this.run = run;
    }
}
