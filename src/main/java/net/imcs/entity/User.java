package net.imcs.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long userId;
	//private String photoUrl;
	private String firstName;
	private String middleName;
	private String lastName;
	private String email;
	private String phoneNumber;
	
	private boolean disclaimer;
	private boolean termsAndCondition;
	private boolean businessCase;
	
	@ManyToMany
	private List<EventsEntity> eventList;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
//	public String getPhotoUrl() {
//		return photoUrl;
//	}
//	public void setPhotoUrl(String photoUrl) {
//		this.photoUrl = photoUrl;
//	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public boolean isDisclaimer() {
		return disclaimer;
	}
	public void setDisclaimer(boolean disclaimer) {
		this.disclaimer = disclaimer;
	}
	public boolean isTermsAndCondition() {
		return termsAndCondition;
	}
	public void setTermsAndCondition(boolean termsAndCondition) {
		this.termsAndCondition = termsAndCondition;
	}
	public boolean isBusinessCase() {
		return businessCase;
	}
	public void setBusinessCase(boolean businessCase) {
		this.businessCase = businessCase;
	}
	public List<EventsEntity> getEventList() {
		return eventList;
	}
	public void setEventList(List<EventsEntity> eventList) {
		this.eventList = eventList;
	}
	
	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", middleName=" + middleName + ", lastName="
				+ lastName + ", email=" + email + ", disclaimer=" + disclaimer + ", termsAndCondition="
				+ termsAndCondition + ", businessCase=" + businessCase + "]";
	}
	
}
