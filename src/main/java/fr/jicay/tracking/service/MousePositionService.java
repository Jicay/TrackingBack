package fr.jicay.tracking.service;

import fr.jicay.tracking.dto.MousePositionDTO;
import fr.jicay.tracking.entity.MousePosition;
import fr.jicay.tracking.repository.MousePositionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class MousePositionService {

    private MousePositionRepository mousePositionRepository;

    public MousePositionService(MousePositionRepository mousePositionRepository) {
        this.mousePositionRepository = mousePositionRepository;
    }

    public void createMousePosition(Integer sessionId, MousePositionDTO mousePosition) {
        MousePosition m = new MousePosition()
                .setPage(mousePosition.getPage())
                .setX(mousePosition.getX())
                .setY(mousePosition.getY())
                .setSessionId(sessionId);
        mousePositionRepository.save(m);
    }

    public MousePositionDTO getLastMousePosition(Integer sessionId) {
        MousePosition m = mousePositionRepository.findFirstBySessionIdOrderByDateDesc(sessionId);

        if (m == null) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }

        return new MousePositionDTO()
                .setX(m.getX())
                .setY(m.getY())
                .setPage(m.getPage())
                .setDate(m.getDate());
    }

    public void deleteAllMousePositions() {
        mousePositionRepository.deleteAll();
    }
}
