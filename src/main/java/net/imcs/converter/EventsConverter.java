package net.imcs.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import net.imcs.entity.EventsEntity;
import net.imcs.entity.User;
import net.imcs.model.EventsModel;

@Component("eventsConverter")
public class EventsConverter {
	
	/* 
		private Long eventsId;
		private String photoUrl;
		private String disclaimer;
		private String termsAndConditions;
		private String business;
		
		private List<User> userList= new ArrayList<User>();
	 */
	
	public EventsEntity modelToEntity(EventsModel eventsModel) {
		EventsEntity eventsEntity= new EventsEntity();
	
		eventsEntity.setEventId(eventsModel.getEventId());
		eventsEntity.setUniversity(eventsModel.getUniversity());
		eventsEntity.setPhotoUrl(eventsModel.getPhotoUrl());
		eventsEntity.setDisclaimer(eventsModel.getDisclaimer());
		eventsEntity.setTermsAndConditions(eventsModel.getTermsAndConditions());
		eventsEntity.setBusiness(eventsModel.getBusiness());
//		eventsEntity.setUserList(eventsModel.getUserList());
		
		return eventsEntity;
	}
	
	public EventsModel entityToModel(EventsEntity eventsEntity) {
		EventsModel eventsModel = new EventsModel();
		
		eventsModel.setEventId(eventsEntity.getEventId());
		eventsModel.setUniversity(eventsEntity.getUniversity());
		eventsModel.setPhotoUrl(eventsEntity.getPhotoUrl());
		eventsModel.setDisclaimer(eventsEntity.getDisclaimer());
		eventsModel.setTermsAndConditions(eventsEntity.getTermsAndConditions());
		eventsModel.setBusiness(eventsEntity.getBusiness());
//		eventsModel.setUserList(eventsEntity.getUserList());
		
		return eventsModel;
	}

}
