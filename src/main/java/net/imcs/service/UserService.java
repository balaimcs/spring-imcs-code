package net.imcs.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import net.imcs.model.MailModel;
import net.imcs.model.UserModel;

public interface UserService {
	
	public abstract ResponseEntity<List<UserModel>> allUserModel();
	public abstract ResponseEntity<UserModel> saveUser(UserModel userModel);
	public abstract ResponseEntity<UserModel> updateUser(UserModel userModel);
	public abstract ResponseEntity<UserModel> findByMail(String email);
	//public abstract ResponseEntity<UserModel> setPhotoUrl(UserModel userModel);
	public abstract ResponseEntity<MailModel> updateMail(MailModel mailModel);
	ResponseEntity<UserModel> updateUserAgreements(UserModel userModel);

}
