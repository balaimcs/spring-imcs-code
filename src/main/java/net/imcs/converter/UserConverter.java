package net.imcs.converter;

import org.springframework.stereotype.Component;

import net.imcs.entity.User;
import net.imcs.model.UserModel;

@Component("userConverter")
public class UserConverter {
	
	//User need to manage next data;
	
	/*
	 	private String photoUrl;
		private String firstName;
		private String middleName;
		private String lastName;
		private String email;
		
		private boolean disclaimer;
		private boolean termsAndCondition;
		private boolean businessCase;
	
	 */
	
	public User modellToEntity(UserModel userModel) {
		User user = new User();
		
		user.setUserId(userModel.getUserId());
		//user.setPhotoUrl(userModel.getPhotoUrl());
		user.setFirstName(userModel.getFirstName());
		user.setMiddleName(userModel.getMiddleName());
		user.setLastName(userModel.getLastName());
		user.setEmail(userModel.getEmail());
		user.setPhoneNumber(userModel.getPhoneNumber());
		
		user.setDisclaimer(userModel.isDisclaimer());
		user.setTermsAndCondition(userModel.isTermsAndCondition());
		user.setBusinessCase(userModel.isBusinessCase());
		
		user.setEventList(userModel.getEventList());
		
		return user;
	}
	
	public UserModel entityToModel(User user) {
		UserModel userModel = new UserModel();
		
		userModel.setUserId(user.getUserId());
		//userModel.setPhotoUrl(user.getPhotoUrl());
		userModel.setFirstName(user.getFirstName());
		userModel.setMiddleName(user.getMiddleName());
		userModel.setLastName(user.getLastName());
		userModel.setEmail(user.getEmail());
		userModel.setPhoneNumber(user.getPhoneNumber());
		
		userModel.setDisclaimer(user.isDisclaimer());
		userModel.setTermsAndCondition(user.isTermsAndCondition());
		userModel.setBusinessCase(user.isBusinessCase());
		
		userModel.setEventList(user.getEventList());
		return userModel;
	}
	
	/*
	 * Method to allow selected field for update on database
	 * If we want to allow field for modification add in her corresponding setter
	 */
	@Deprecated
	public User modellToEntityUpdateAllowedData(UserModel userModel) {
		User user = new User();
		
		//user.setPhotoUrl(userModel.getPhotoUrl());
		user.setFirstName(userModel.getFirstName());
		user.setMiddleName(userModel.getMiddleName());
		user.setLastName(userModel.getLastName());
		//user.setEmail(userModel.getEmail());
		
		//user.setDisclaimer(userModel.isDisclaimer());
		//user.setTermsAndCondition(userModel.isTermsAndCondition());
		//user.setBusinessCase(userModel.isBusinessCase());
		
		return user;
	}

}
