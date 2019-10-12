package fr.jicay.tracking.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

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
}
