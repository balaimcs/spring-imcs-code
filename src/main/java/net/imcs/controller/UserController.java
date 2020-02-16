package net.imcs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.imcs.model.MailModel;
import net.imcs.model.UserModel;
import net.imcs.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	@Qualifier("userSrv")
	private UserService userService;
	
	//Just for test purpose
	//http://localhost:8080/user/lkajwdiauspkmcpwodipldmaspduawodontusethisjustfortestendpoint
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/lkajwdiauspkmcpwodipldmaspduawodontusethisjustfortestendpoint")
	public ResponseEntity<List<UserModel>> allUsers(){
		return userService.allUserModel();
	}
	
	//http://localhost:8080/user/guest
	/*
	 	{
	 		"firstName":"UserFirstName",
	 		"middleName":"middleName",
	 		"lastName":"UserLastName",
	 		"email":"user.corporative.mail@imcs.net",
	 		"phoneNumber": "5528872541",
	 		"disclaimer":true,
	 		"termsAndCondition":true,
	 		"businessCase":true
	 	}
	 */
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/guest")
	public ResponseEntity<UserModel> addUser(@RequestBody UserModel userModel){
		//userService.saveUser(userModel);
		return userService.saveUser(userModel);
	}
	
	//http://localhost:8080/user/update
		/*
		 	{
			    "userId": 1,
			    "firstName": "UserFirstName",
			    "middleName": "middleName",
			    "lastName": "UserLastName",
			    "email": "user1.corporative.mail@imcs.net",
			    "phoneNumber": "+52 1 (552) 887 2541",
			    "disclaimer": true,
			    "termsAndCondition": true,
			    "businessCase": true,
			    "eventList": [{
					    "eventsId": 1
					},{
					    "eventsId": 3
					}]
			}
		 */
	@PostMapping("/update")
	public ResponseEntity<UserModel> editUser(@RequestBody UserModel userModel){
		//userService.saveUser(userModel);
		return userService.updateUser(userModel);
	}
	
	@PostMapping("/update")
	public ResponseEntity<UserModel> editUserAgreements(@RequestBody UserModel userModel){
		//userService.saveUser(userModel);
		return userService.updateUser(userModel);
	}
	
	//http://localhost:8080/user/stablishPhotoUrl
	/*
	 	{
		 "photoUrl":"/main/directory/photos",
		 "email":"user.corporative.mail@imc.net"
		}
	 */
//	@CrossOrigin(origins = "http://localhost:3000")
//	@PostMapping("/establishPhotoUrl")
//	public ResponseEntity<UserModel> establishPhotoUrl(@RequestBody UserModel userModel){
//		return userService.setPhotoUrl(userModel);
//	}
	
	
	//http://localhost:8080/user/editMail
	/*
	 	{
		 "mail":"user.corporative.mail@imcs.net",
		 "newMail":"user.oldest@imcs.net"
		}
	 */
	@PostMapping("/editMail")
	public ResponseEntity<MailModel> editMail(@RequestBody MailModel mailModel){
		return userService.updateMail(mailModel);
	}
	
}
