package fr.jicay.tracking.service;

import fr.jicay.tracking.entity.Session;
import fr.jicay.tracking.repository.SessionRepository;
import org.springframework.stereotype.Service;

@Service
public class SessionService {

    private SessionRepository sessionRepository;

    public SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public Iterable<Session> findAllSession() {
        return sessionRepository.findAll();
    }

    public Session createSession() {
        return sessionRepository.save(new Session());
    }

    public void deleteAllSessions() {
        sessionRepository.deleteAll();
    }
}
