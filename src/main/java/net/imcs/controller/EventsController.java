package net.imcs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.imcs.model.EventsModel;
import net.imcs.service.EventsService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RequestMapping("/events")
public class EventsController {
	
	@Autowired
	@Qualifier("eventsService")
	private EventsService eventsService;
	
	//http://localhost:8080/events/allEvents
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/allEvents")
	public ResponseEntity<List<EventsModel>> allEvents(){
		return eventsService.eventsList();
	} 
	
	//http://localhost:8080/events/addEvent
	/*
	 	{
	        "eventsId": 1,
	        "photoUrl": "http://localhost:8080/downloadFile/avatar_1.png",
	        "disclaimer": "disclaimer tex",
	        "termsAndConditions": "terms and conditions",
	        "business": "business text",
	        "userList": []
	    }
	 */
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/addEvent")
	public ResponseEntity<EventsModel> addEvent(@RequestBody EventsModel eventsModel){		
		return eventsService.addEvent(eventsModel);
	}
	
	//http://localhost:8080/events/getEvent/167543
	@CrossOrigin(origins = "http://localhost:3000/events/getEvent/*")
	@GetMapping("/getEvent/{eventId}")
	public ResponseEntity<EventsModel> event(@PathVariable String eventId){
		return eventsService.event(eventId);
	} 

}
