package com.chyld.entities;

import com.chyld.enums.Category;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@Entity
@Table(name="devices")
//@Data
public class  Device {
    private int id;
    private int version;
    private int serialNumber;
    private String product;
    private Category category;
    private User user;
    private Date created;
    private Date modified;
    private List<Run> runs;

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

    @Column(nullable = false, name = "serial_number")
    public int getSerialNumber() {
        return serialNumber;
    }
    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getProduct() {
        return product;
    }
    public void setProduct(String product) {
        this.product = product;
    }

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('RUN', 'SWIM', 'BIKE', 'LIFT')")
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "device")
    public List<Run> getRuns() { return runs; }
    public void setRuns(List<Run> runs) { this.runs = runs;}


    public boolean doesNotHaveCurrentRun() {
        //Optional<Run> run = runs.stream().filter(r -> r.getEndTime().equals(null)).findFirst();
        //run.ifPresent();
        boolean x = true;
        for ( Run run : this.runs ) {
            if (run.getEndTime() == null) {
                x = false;
                break;
            }
        }

        return x;
    }

    public void stopRun() {
        for ( Run run : this.runs ) {
            if (run.getEndTime() == null) {
                Date date = new Date();
                run.setEndTime(date);
                break;
            }
        }

    }


    public Run startedRun() {
        Run startedRun = null;

        for ( Run run : this.runs ) {
            if (run.getEndTime() == null) {
                startedRun =  run;
                break;
            }
        }
        return startedRun;
    }
}
