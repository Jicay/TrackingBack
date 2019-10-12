package fr.jicay.tracking.repository;

import fr.jicay.tracking.entity.Session;
import org.springframework.data.repository.CrudRepository;

public interface SessionRepository extends CrudRepository<Session, Integer> {
}
