package net.imcs.commons;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

@Component("mailValidation")
public class MailValidation {
	
	public boolean isImcsNetFormat (String mail) {
		String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
		String endsDomain="imcs.net";
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(mail);
		
		if(matcher.matches()&& mail.endsWith(endsDomain)) {
			return true;
		}
		
		return false;
	}

}
