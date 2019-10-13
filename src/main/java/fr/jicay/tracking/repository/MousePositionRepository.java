package fr.jicay.tracking.repository;

import fr.jicay.tracking.entity.MousePosition;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MousePositionRepository extends CrudRepository<MousePosition, Integer> {
    MousePosition findFirstBySessionIdOrderByDateDesc(Integer sessionId);
}
