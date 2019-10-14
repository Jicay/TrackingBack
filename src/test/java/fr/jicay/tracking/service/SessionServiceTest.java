package fr.jicay.tracking.service;

import fr.jicay.tracking.entity.Session;
import fr.jicay.tracking.repository.SessionRepository;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class SessionServiceTest {

    @InjectMocks
    private SessionService sessionService;

    @Mock
    private SessionRepository sessionRepository;

    @Test
    public void findAllSession() {
        List<Session> sessions = Lists.newArrayList(
                new Session().setId(12).setCreationDate(LocalDateTime.now()),
                new Session().setId(52).setCreationDate(LocalDateTime.now()));

        doReturn(sessions)
                .when(sessionRepository)
                .findAll();

        Iterable<Session> res = sessionService.findAllSession();

        assertThat(res).usingRecursiveFieldByFieldElementComparator().containsExactlyElementsOf(sessions);
    }

    @Test
    public void createSession() {
        Session session = new Session().setId(45).setCreationDate(LocalDateTime.now());

        doReturn(session)
                .when(sessionRepository)
                .save(new Session());

        Session res = sessionService.createSession();

        assertThat(res).isEqualToComparingFieldByFieldRecursively(session);

        verify(sessionRepository).save(new Session());
    }

    @Test
    public void deleteAllSessions() {
        sessionService.deleteAllSessions();

        verify(sessionRepository).deleteAll();
    }
}