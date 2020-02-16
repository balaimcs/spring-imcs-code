package net.imcs.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.imcs.entity.EventsEntity;

@Repository("eventsRepo")
public interface EventsRepo extends CrudRepository<EventsEntity, Long> {

	public Optional<EventsEntity> findById(Long Id);
}
