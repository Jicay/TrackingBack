package fr.jicay.tracking.service;

import fr.jicay.tracking.dto.MousePositionDTO;
import fr.jicay.tracking.entity.MousePosition;
import fr.jicay.tracking.entity.Session;
import fr.jicay.tracking.repository.MousePositionRepository;
import fr.jicay.tracking.repository.SessionRepository;
import org.springframework.stereotype.Service;

@Service
public class MousePositionService {

    private MousePositionRepository mousePositionService;

    public MousePositionService(MousePositionRepository mousePositionService) {
        this.mousePositionService = mousePositionService;
    }

    public void createMousePosition(Integer sessionId, MousePositionDTO mousePosition) {
        MousePosition m = new MousePosition()
                .setPage(mousePosition.getPage())
                .setX(mousePosition.getX())
                .setY(mousePosition.getY())
                .setSessionId(sessionId);
        mousePositionService.save(m);
    }
}
