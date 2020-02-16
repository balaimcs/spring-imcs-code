package net.imcs.model;

import java.util.ArrayList;
import java.util.List;

import net.imcs.entity.User;

public class EventsModel {

	private Long eventsId;
	private String photoUrl;
	private String disclaimer;
	private String termsAndConditions;
	private String business;
	
//	private List<User> userList= new ArrayList<User>();
	
	public Long getEventsId() {
		return eventsId;
	}
	public void setEventsId(Long eventsId) {
		this.eventsId = eventsId;
	}
	public String getPhotoUrl() {
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	public String getDisclaimer() {
		return disclaimer;
	}
	public void setDisclaimer(String disclaimer) {
		this.disclaimer = disclaimer;
	}
	public String getTermsAndConditions() {
		return termsAndConditions;
	}
	public void setTermsAndConditions(String termsAndConditions) {
		this.termsAndConditions = termsAndConditions;
	}
	public String getBusiness() {
		return business;
	}
	public void setBusiness(String business) {
		this.business = business;
	}
//	public List<User> getUserList() {
//		return userList;
//	}
//	public void setUserList(List<User> userList) {
//		this.userList = userList;
//	}
	
}
