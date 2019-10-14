package fr.jicay.tracking.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Session session = (Session) o;
        return Objects.equals(id, session.id) &&
                Objects.equals(creationDate, session.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, creationDate);
    }
}
