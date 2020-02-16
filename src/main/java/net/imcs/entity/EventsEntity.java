package net.imcs.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="events")
public class EventsEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long eventId;
	private String photoUrl;
	private String disclaimer;
	private String termsAndConditions;
	private String business;

	//@OneToMany(mappedBy="event", cascade=CascadeType.ALL, orphanRemoval = true, fetch=FetchType.LAZY)
//	@JoinTable(
//    name = "event_user",
//    joinColumns = @JoinColumn(
//            name = "event_id",
//            referencedColumnName = "eventId"
//    ),
//    inverseJoinColumns = @JoinColumn(
//            name = "user_id",
//            referencedColumnName = "userId"
//    )
//  )
	//@ManyToMany
	//private List<User> userList;
	
	public Long getEventsId() {
		return eventId;
	}
	public void setEventsId(Long eventsId) {
		this.eventId = eventsId;
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
