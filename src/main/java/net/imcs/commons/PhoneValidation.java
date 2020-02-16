package net.imcs.commons;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

@Component("phoneValidation")
public class PhoneValidation {
	
	public boolean isPhoneFormat (String mail) {
		String regex = "^[0-9#&+().-]{20}";
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(mail);
		
		if(matcher.matches()) {
			return true;
		}
		
		return false;
	}

}
