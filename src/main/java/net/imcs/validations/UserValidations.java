package net.imcs.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import net.imcs.commons.MailValidation;
import net.imcs.commons.PhoneValidation;
import net.imcs.model.UserModel;

@Component("userValidations")
public class UserValidations {
	
	@Autowired
	@Qualifier("phoneValidation")
	private PhoneValidation phoneValidation;
	
	@Autowired
	@Qualifier("mailValidation")
	private MailValidation mailValidation;
	

	public boolean addValidation(UserModel userModel) {
		try {
			//First name is not null
			//if(userModel.getFirstName().trim().isEmpty()) {return false;}
			//Last name is not null
			//if(userModel.getLastName().trim().isEmpty()) {return false;}
			//Email has the corporative format
			//if(!mailValidation.isImcsNetFormat(userModel.getEmail())) {return false;}
			//Phone is not null
			//if(userModel.getPhoneNumber().trim().isEmpty()) {return false;}
			//Phone valid characters
			//if(!phoneValidation.isPhoneFormat(userModel.getPhoneNumber())) {return false;}
			//Disclaimer false, then return false
			//if(!userModel.isDisclaimer()){return false;}
			//terms and conditions false, then return false
			//if(!userModel.isTermsAndCondition()){return false;}
			//business case false, then return false
			//if(!userModel.isBusinessCase()){return false;}
		} catch (Exception e) {
			// log e
		}
			
		return true;
	}
	
	
	public boolean updateValidation(UserModel userModel) {
		try {
			//First name is not null
			//if(userModel.getFirstName().trim().isEmpty()) {return false;}
			//Last name is not null
			//if(userModel.getLastName().trim().isEmpty()) {return false;}
			//Phone is not null
			//if(userModel.getPhoneNumber().trim().isEmpty()) {return false;}
			//Phone valid characters
			//if(!phoneValidation.isPhoneFormat(userModel.getPhoneNumber())) {return false;}
			
		} catch (Exception e) {
			// log e
		}
				
		return true;
	}
	
	public boolean userMailValidation(String mail) {
		System.out.println("userMailValidation");
		if(mailValidation.isImcsNetFormat(mail)) {return true;}
		return false;
	}
}
