package fr.jicay.tracking.repository;

import fr.jicay.tracking.entity.MousePosition;
import org.springframework.data.repository.CrudRepository;

public interface MousePositionRepository extends CrudRepository<MousePosition, Integer> {
}
