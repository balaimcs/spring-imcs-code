package net.imcs.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import net.imcs.converter.EventsConverter;
import net.imcs.entity.EventsEntity;
import net.imcs.model.EventsModel;
import net.imcs.repo.EventsRepo;
import net.imcs.service.EventsService;

@Service("eventsService")
public class EventsImpl implements EventsService{

	@Autowired
	@Qualifier("eventsConverter")
	private EventsConverter eventsConverter;
	
	@Autowired
	@Qualifier("eventsRepo")
	private EventsRepo eventsRepo;
	
	@Override
	public ResponseEntity<EventsModel> addEvent(EventsModel eventsModel) {
		 return new ResponseEntity<EventsModel>(
				 eventsConverter.entityToModel(
						 eventsRepo.save(
								 eventsConverter.modelToEntity(eventsModel)
						)
				), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<EventsModel>> eventsList() {
		List<EventsModel> eventsModel= new ArrayList<EventsModel>();
		for (EventsEntity eventsEntity:eventsRepo.findAll()) {
			eventsModel.add(eventsConverter.entityToModel(eventsEntity));
		}
		
		return new ResponseEntity<List<EventsModel>>(eventsModel,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<EventsModel> event(String eventId) {
		Long eventIdL=0l;
		try {
			eventIdL = Long.parseLong(eventId);
		} catch (Exception e) {
			return new ResponseEntity<EventsModel>(HttpStatus.BAD_REQUEST);
		}
		
		Optional<EventsEntity> optEvent = eventsRepo.findById(eventIdL);		
		if(optEvent.isPresent()){
			EventsEntity event = (EventsEntity)optEvent.get();
			return new ResponseEntity<EventsModel>(eventsConverter.entityToModel(event),HttpStatus.OK);
		}else {
			return new ResponseEntity<EventsModel>(HttpStatus.NO_CONTENT);
		}
		
	}
	
}
