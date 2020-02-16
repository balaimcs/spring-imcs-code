package net.imcs.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import net.imcs.model.EventsModel;

public interface EventsService {

	public abstract ResponseEntity<EventsModel> addEvent(EventsModel eventsModel);
	public abstract ResponseEntity<List <EventsModel>> eventsList();
	public abstract ResponseEntity<EventsModel> event (String eventId);
	
}
