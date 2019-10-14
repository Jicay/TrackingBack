package fr.jicay.tracking.service;

import fr.jicay.tracking.dto.MousePositionDTO;
import fr.jicay.tracking.entity.MousePosition;
import fr.jicay.tracking.repository.MousePositionRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.HttpStatusCodeException;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class MousePositionServiceTest {

    @InjectMocks
    private MousePositionService mousePositionService;

    @Mock
    private MousePositionRepository mousePositionRepository;

    @Test
    public void createMousePosition() {
        MousePositionDTO mousePositionDTO = new MousePositionDTO()
                .setX(45.23)
                .setY(98.32)
                .setPage("home");

        MousePosition mousePosition = new MousePosition()
                .setX(45.23)
                .setY(98.32)
                .setPage("home")
                .setSessionId(2);

        mousePositionService.createMousePosition(2, mousePositionDTO);

        verify(mousePositionRepository).save(mousePosition);
    }

    @Test
    public void getLastMousePosition() {
        MousePositionDTO mousePositionDTO = new MousePositionDTO()
                .setX(45.23)
                .setY(98.32)
                .setPage("home")
                .setDate(LocalDateTime.of(2019, 10, 21, 21, 24, 10));

        MousePosition mousePosition = new MousePosition()
                .setSessionId(45)
                .setX(45.23)
                .setY(98.32)
                .setPage("home")
                .setDate(LocalDateTime.of(2019, 10, 21, 21, 24, 10));

        doReturn(mousePosition)
                .when(mousePositionRepository)
                .findFirstBySessionIdOrderByDateDesc(45);

        MousePositionDTO res = mousePositionService.getLastMousePosition(45);

        assertThat(res).isEqualToComparingFieldByFieldRecursively(mousePositionDTO);
    }


    @Test(expected = HttpStatusCodeException.class)
    public void getLastMousePosition_shouldReturnNotFoundException_whenNoMousePosition() {
        doReturn(null)
                .when(mousePositionRepository)
                .findFirstBySessionIdOrderByDateDesc(45);

        MousePositionDTO res = mousePositionService.getLastMousePosition(45);
    }
}
