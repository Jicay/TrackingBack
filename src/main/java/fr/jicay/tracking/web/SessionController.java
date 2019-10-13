package fr.jicay.tracking.web;

import fr.jicay.tracking.dto.MousePositionDTO;
import fr.jicay.tracking.entity.MousePosition;
import fr.jicay.tracking.entity.Session;
import fr.jicay.tracking.service.MousePositionService;
import fr.jicay.tracking.service.SessionService;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import javax.validation.Valid;
import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

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

    @DeleteMapping
    public ResponseEntity deleteAllSessions() {
        mousePositionService.deleteAllMousePositions();
        sessionService.deleteAllSessions();

        return ResponseEntity.ok().build();
    }

    @PostMapping("/{sessionId}/mouse-positions")
    public ResponseEntity addMousePosition(@PathVariable Integer sessionId, @RequestBody @Valid MousePositionDTO mousePosition) {
        mousePositionService.createMousePosition(sessionId, mousePosition);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/{sessionId}/mouse-positions/last")
    public MousePositionDTO getLastMousePosition(@PathVariable Integer sessionId) {
        return mousePositionService.getLastMousePosition(sessionId);
    }

    @GetMapping("/{sessionId}/mouse-positions/stream")
    public Flux<ServerSentEvent<MousePositionDTO>> streamMousePosition(@PathVariable Integer sessionId) {
        return Flux.interval(Duration.ofMillis(100))
                .map(sequence -> ServerSentEvent.<MousePositionDTO> builder()
                        .id(String.valueOf(sequence))
                        .event("mouse-position-event")
                        .data(mousePositionService.getLastMousePosition(sessionId))
                        .build());
    }
}
