package fr.jicay.tracking.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name="mouse_position")
public class MousePosition {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name="date", insertable = false, updatable = false)
    private LocalDateTime date;

    private Double x;
    private Double y;
    private Integer sessionId;
    private String page;

    public Integer getId() {
        return id;
    }

    public MousePosition setId(Integer id) {
        this.id = id;
        return this;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public MousePosition setDate(LocalDateTime creationDate) {
        this.date = creationDate;
        return this;
    }

    public Double getX() {
        return x;
    }

    public MousePosition setX(Double x) {
        this.x = x;
        return this;
    }

    public Double getY() {
        return y;
    }

    public MousePosition setY(Double y) {
        this.y = y;
        return this;
    }

    public Integer getSessionId() {
        return sessionId;
    }

    public MousePosition setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
        return this;
    }

    public String getPage() {
        return page;
    }

    public MousePosition setPage(String page) {
        this.page = page;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MousePosition that = (MousePosition) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(date, that.date) &&
                Objects.equals(x, that.x) &&
                Objects.equals(y, that.y) &&
                Objects.equals(sessionId, that.sessionId) &&
                Objects.equals(page, that.page);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, x, y, sessionId, page);
    }
}
