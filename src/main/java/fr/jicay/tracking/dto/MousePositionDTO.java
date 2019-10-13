package fr.jicay.tracking.dto;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class MousePositionDTO {
    @NotNull
    private Double x;
    @NotNull
    private Double y;
    @NotNull
    private String page;

    private LocalDateTime date;

    public Double getX() {
        return x;
    }

    public MousePositionDTO setX(Double x) {
        this.x = x;
        return this;
    }

    public Double getY() {
        return y;
    }

    public MousePositionDTO setY(Double y) {
        this.y = y;
        return this;
    }

    public String getPage() {
        return page;
    }

    public MousePositionDTO setPage(String page) {
        this.page = page;
        return this;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public MousePositionDTO setDate(LocalDateTime date) {
        this.date = date;
        return this;
    }
}
