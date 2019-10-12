package fr.jicay.tracking.web;

import fr.jicay.tracking.dto.MousePositionDTO;
import fr.jicay.tracking.entity.Session;
import fr.jicay.tracking.service.MousePositionService;
import fr.jicay.tracking.service.SessionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("sessions")
public class SessionController {

    private SessionService sessionService;
    private MousePositionService mousePositionService;

    public SessionController(SessionService sessionService, MousePositionService mousePositionService) {
        this.sessionService = sessionService;
        this.mousePositionService = mousePositionService;
    }

    @GetMapping
    public Iterable<Session> getSessions() {
        return sessionService.findAllSession();
    }

    @PostMapping
    public Session createSession() {
        return sessionService.createSession();
    }

    @PostMapping("/{sessionId}/mouse-positions")
    public ResponseEntity addMousePosition(@PathVariable Integer sessionId, @RequestBody @Valid MousePositionDTO mousePosition) {
        mousePositionService.createMousePosition(sessionId, mousePosition);

        return ResponseEntity.ok().build();
    }
}
