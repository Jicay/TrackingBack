package fr.jicay.tracking.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="session")
public class Session {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name="creation_date", insertable = false, updatable = false)
    private LocalDateTime creationDate;

    public Integer getId() {
        return id;
    }

    public Session setId(Integer id) {
        this.id = id;
        return this;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public Session setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
        return this;
    }
}
