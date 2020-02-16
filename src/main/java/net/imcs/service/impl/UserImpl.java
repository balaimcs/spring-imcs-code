package net.imcs.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import net.imcs.converter.UserConverter;
import net.imcs.entity.User;
import net.imcs.model.MailModel;
import net.imcs.model.UserModel;
import net.imcs.repo.UserRepo;
import net.imcs.service.UserService;
import net.imcs.validations.UserValidations;

@Service("userSrv")
public class UserImpl implements UserService{
	
	@Autowired
	@Qualifier("userConverter")
	private UserConverter userConverter;
	
	@Autowired
	@Qualifier("userRepo")
	private UserRepo userRepo;
	
	//@Autowired
	//@Qualifier("mailValidaton")
	//private MailValidaton mailValidaton;
	
	@Autowired
	@Qualifier("userValidations")
	private UserValidations userValidations;


	@Override
	public ResponseEntity<List<UserModel>> allUserModel() {
		List<UserModel> listUserModel= new ArrayList<UserModel>();
		for(User usr:userRepo.findAll()) {
			listUserModel.add(userConverter.entityToModel(usr));
		}
		
		return new ResponseEntity<List<UserModel>>(listUserModel,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<UserModel> findByMail(String email) {
		
//		if (mailValidaton.isImcsNetFormat(email)) {//Verify mail format		
//			//log; trying to edit unexistent user, posible security violation
//			UserModel usrMdl= new UserModel();
//			usrMdl.setEmail(email);
//			return new ResponseEntity<UserModel>(usrMdl, HttpStatus.NOT_FOUND);
//		}
		
		User usr=userRepo.findByEmail(email);
		try {
			if (null!=usr){
				return new ResponseEntity<UserModel>(userConverter.entityToModel(usr), HttpStatus.FOUND);
			}
		} catch (Exception e) {
			//log e
		}
		return new ResponseEntity<UserModel>(userConverter.entityToModel(usr), HttpStatus.NOT_FOUND);
		
	}

//	@Override
//	public ResponseEntity<UserModel> setPhotoUrl(UserModel userModel) {
//		//Obtain user object / check if user exist
//		if (!userRepo.existsByEmail(userModel.getEmail())) {//Check if the user exist on Data base			
//			//log; trying to edit unexistent user, posible security violation
//			return new ResponseEntity<UserModel>(userModel, HttpStatus.PRECONDITION_FAILED);
//		}
//		
//		User usr=userRepo.findByEmail(userModel.getEmail());
//		if (null!=usr) {			
//			usr.setPhotoUrl(userModel.getPhotoUrl());
//			return new ResponseEntity<UserModel>(userConverter.entityToModel(userRepo.save(usr)), HttpStatus.OK);
//		}
//		
//		return new ResponseEntity<UserModel>(userConverter.entityToModel(usr), HttpStatus.PRECONDITION_FAILED);
//	}

	@Override
	public ResponseEntity<UserModel> saveUser(UserModel userModel) {
		
		if(!userValidations.addValidation(userModel)) {
			return new ResponseEntity<UserModel>(userModel, HttpStatus.PRECONDITION_FAILED);
		}
		
		//add validations email here
		if (userRepo.existsByEmail(userModel.getEmail())) {
			//user allready exist so is PRECONDITION_FAILED, cant be another with same mail
			return new ResponseEntity<UserModel>(userModel, HttpStatus.PRECONDITION_FAILED);
		}
		
		//add business rules before execute next line
		try {
			User usr = userRepo.save(userConverter.modellToEntity(userModel));
			if (null!=usr){
				return new ResponseEntity<UserModel>(userConverter.entityToModel(usr), HttpStatus.CREATED);
			}
		} catch (Exception e) {
			//log e
			return new ResponseEntity<UserModel>(userModel, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<UserModel>(userModel, HttpStatus.PRECONDITION_FAILED);
	}
	
	@Override
	public ResponseEntity<UserModel> updateUser(UserModel userModel) {
		
		if(!userValidations.updateValidation(userModel)) {
			return new ResponseEntity<UserModel>(userModel, HttpStatus.PRECONDITION_FAILED);
		}
		
		if (!userRepo.existsByEmail(userModel.getEmail())) {//Check if the user exist on Data base			
			//log; trying to edit unexistent user, posible security violation
			return new ResponseEntity<UserModel>(userModel, HttpStatus.PRECONDITION_FAILED);
		}
			
		//Stablishing just authorized fields for update
		//userConverter.modellToEntityUpdateAllowedData(userModel);
		User usr=userRepo.findByEmail(userModel.getEmail());
		
		usr.setFirstName(userModel.getFirstName());
		usr.setMiddleName(userModel.getMiddleName());
		usr.setLastName(userModel.getLastName());
		usr.setPhoneNumber(userModel.getPhoneNumber());
		usr.setEventList(userModel.getEventList());
		
		try {
			User usrSaved = userRepo.save(usr);
			if (null!=usrSaved){
				return new ResponseEntity<UserModel>(userModel, HttpStatus.OK);
			}
		} catch (Exception e) {
			//log e
			return new ResponseEntity<UserModel>(userModel, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return new ResponseEntity<UserModel>(userModel, HttpStatus.PRECONDITION_FAILED);	
	}
	
	
	@Override
	public ResponseEntity<UserModel> updateUserAgreements(UserModel userModel) {
		
		if(!userValidations.updateValidation(userModel)) {
			return new ResponseEntity<UserModel>(userModel, HttpStatus.PRECONDITION_FAILED);
		}
		
		if (!userRepo.existsByEmail(userModel.getEmail())) {//Check if the user exist on Data base			
			//log; trying to edit unexistent user, posible security violation
			return new ResponseEntity<UserModel>(userModel, HttpStatus.PRECONDITION_FAILED);
		}
			
		//Stablishing just authorized fields for update
		//userConverter.modellToEntityUpdateAllowedData(userModel);
		User usr=userRepo.findByEmail(userModel.getEmail());
		
		usr.setFirstName(userModel.getFirstName());
		usr.setMiddleName(userModel.getMiddleName());
		usr.setLastName(userModel.getLastName());
		usr.setPhoneNumber(userModel.getPhoneNumber());
		usr.setEventList(userModel.getEventList());
		
		try {
			User usrSaved = userRepo.save(usr);
			if (null!=usrSaved){
				return new ResponseEntity<UserModel>(userModel, HttpStatus.OK);
			}
		} catch (Exception e) {
			//log e
			return new ResponseEntity<UserModel>(userModel, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return new ResponseEntity<UserModel>(userModel, HttpStatus.PRECONDITION_FAILED);	
	}
	

	@Override
	public ResponseEntity<MailModel> updateMail(MailModel mailModel) {
		try {
		
			//Verify newMail format
			if (!userValidations.userMailValidation(mailModel.getNewMail())) {		
				//log; trying to edit unexistent user, posible security violation
				return new ResponseEntity<MailModel>(mailModel, HttpStatus.PRECONDITION_FAILED);
			}
			
			//Check if the NEW user exist on Data base, can not add repited mail
			if (userRepo.existsByEmail(mailModel.getNewMail())) {			
				//log; trying to edit unexistent user, posible security violation
				return new ResponseEntity<MailModel>(mailModel, HttpStatus.PRECONDITION_FAILED);
			}
			
			//Check if the previous one exist on Data base	
			if (!userRepo.existsByEmail(mailModel.getMail())) {		
				//log; trying to edit unexistent user, posible security violation
				return new ResponseEntity<MailModel>(mailModel, HttpStatus.PRECONDITION_FAILED);
			}
		
			//////make update//////
		
			User usr=userRepo.findByEmail(mailModel.getMail());
			usr.setEmail(mailModel.getNewMail());
		
			User usrSavedMailUpdated = userRepo.save(usr);
			if (null!=usrSavedMailUpdated){
				return new ResponseEntity<MailModel>(mailModel, HttpStatus.OK);
			}
		} catch (Exception e) {
			//log e
			return new ResponseEntity<MailModel>(mailModel, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return new ResponseEntity<MailModel>(mailModel, HttpStatus.PRECONDITION_FAILED);
		
	}
	
}
